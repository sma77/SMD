package org.apromore.mining.guidetree.pcm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apromore.dao.ProcessDao;
import org.apromore.graph.JBPT.CPF;
import org.apromore.mining.MiningConfig;
import org.apromore.mining.complexity.ComplexityEvaluatorTool;
import org.apromore.mining.guidetree.Prom5BasedMiner;
import org.apromore.mining.guidetree.pcm.GTClusterer.GTNode;
import org.apromore.mining.standardize.ProcessMerger;
import org.apromore.mining.standardize.StandardizedCluster;
import org.apromore.service.ClusteringService;
import org.apromore.service.RepositoryService;
import org.apromore.service.utils.FormattableEPCSerializer;
import org.apromore.util.DebugUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GTBasedProcessCollectionMiner {
	
	private static final Logger logger = LoggerFactory.getLogger(GTBasedProcessCollectionMiner.class);
	
	@Autowired
	private GTClusterer clusterer;
	
	@Autowired
	private GTProcessImporter processImporter;
	
	@Autowired
	private ProcessMerger processMerger;
	
	@Autowired
	private Prom5BasedMiner miner;
	
	@Autowired
	private ClusteringService csrv;
	
	@Autowired
	private GTComplexityChecker complexityChecker;
	
	@Autowired
	private GTProcessStandardizer standardizer;
	
	@Autowired @Qualifier("RepositoryService")
	RepositoryService rsrv;
	
	@Autowired @Qualifier("ProcessDao")
	private ProcessDao pdao;
	
	private FormattableEPCSerializer formattableEPCSerializer = new FormattableEPCSerializer();
	
	String processesPath = "processes";
	String processesDataPath = "b_c_processes_data.csv";
	String subprocessesPath = "subprocesses";
	String subprocessesDataPath = "b_c_subprocesses_data.csv";
	String combinedPath = "combined";
	String combinedDataPath = "b_c_combined_data.csv";
	private final String invalidModelsPath = "invalid";
	
	public void mineCollection(String inPath, String outPath) throws Exception {
		
		long t1 = System.currentTimeMillis();
		
		initializePaths(outPath);
		
		if (MiningConfig.WRITE_ADDITIONAL_DATA) {
			GTEvaluatorUtil.init(outPath);
			DebugUtil.initOutPath(outPath);
		}
		processMerger.initialize();
		
		String logPath = inPath;
		logger.info("Mining a process collection from the log file: {}", logPath);
		
		clusterer.initialize(logPath);
		List<GTNode> initialModels = getInitialNodes(MiningConfig.INITIAL_PROCESS_SIZE);
		
		List<GTNode> addedModels = processImporter.importModels(initialModels);
		csrv.computeGEDMatrix();
		
		Collection<GTNode> complexModels = complexityChecker.getComplexModelsToReprocess(addedModels);
		if (complexModels.isEmpty()) {
			standardizer.standardize();
		}
		
		Set<GTNode> undividableModels = new HashSet<GTNode>();
		
		while (!complexModels.isEmpty()) {
			
			standardizer.standardize();
			Map<GTNode, CPF> standardizedProcesses = standardizer.getStandardizedProcesses();
			Map<String, CPF> standardizedSubprocesses = standardizer.getStandardizedSubprocesses();
	
			complexModels = complexityChecker.getComplexProcessesToReprocessAll(standardizer, undividableModels);
			
			if (logger.isDebugEnabled()) {
				StringBuffer b = new StringBuffer();
				for (GTNode n : complexModels) {
					b.append(n.getID() + ",");
				}
				logger.debug("Complex models selected for simplification: {}", b.toString());
			}
			
			List<GTNode> allNewProcesses = new ArrayList<GTNode>();
			for (GTNode node : complexModels) {
				
				List<GTNode> nextLevelModels = getDirectNextLevelModels(node, undividableModels);
				
				if (!undividableModels.contains(node)) {
					String processNameToDelete = processImporter.getProcessNameOfNode(node);
					logger.debug("Deleting the process {} to replace with its next level models.", processNameToDelete);
					rsrv.deleteProcess(processNameToDelete);
					GTEvaluatorUtil.removeCluster(processNameToDelete);
					List<GTNode> addedNewProcesses = processImporter.importModels(nextLevelModels);
					allNewProcesses.addAll(addedNewProcesses);
				}
			}
			
			appendGEDMatrix(allNewProcesses);
		} 
		
		standardizer.apply();
		
		long endTime = System.currentTimeMillis();
		long duration = endTime - t1;
		
		serialize(processesPath, standardizer.getStandardizedProcesses());
		serializeSubprocesses(subprocessesPath, standardizer);
		
		if (MiningConfig.WRITE_ADDITIONAL_DATA) {
			GTEvaluatorUtil.writeData(clusterer, duration);
		}
		
		if (MiningConfig.WRITE_EVAL_DATA) {
			writeEvalData(duration);
		}
	}
	
	private void initializePaths(String outPath) {

		File outFolder = new File(outPath);
		try {
			FileUtils.cleanDirectory(outFolder);
		} catch (IOException e) {
			e.printStackTrace();
		}

		File processesFolder = new File(outFolder, "processes");
		processesFolder.mkdir();
		processesPath = processesFolder.getAbsolutePath();
		
		File subprocessesFolder = new File(outFolder, "subprocesses");
		subprocessesFolder.mkdir();
		subprocessesPath = subprocessesFolder.getAbsolutePath();
	}
	
	private void writeEvalData(long duration) {
		ComplexityEvaluatorTool evaluatorTool = new ComplexityEvaluatorTool();
		evaluatorTool.writeComplexities(processesPath, processesDataPath, duration);
		evaluatorTool.writeComplexities(subprocessesPath, subprocessesDataPath, duration);
		
		try {
			File processesFolder = new File(processesPath);
			File subprocessesFolder = new File(subprocessesPath);
			File combinedFolder = new File(combinedPath);
			FileUtils.cleanDirectory(combinedFolder);
			FileUtils.copyDirectory(processesFolder, combinedFolder);
			FileUtils.copyDirectory(subprocessesFolder, combinedFolder);
			evaluatorTool.writeComplexities(combinedPath, combinedDataPath, duration, processesFolder.list().length, subprocessesFolder.list().length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void appendGEDMatrix(Collection<GTNode> allNewProcesses) {
		
		if (logger.isDebugEnabled()) {
			StringBuffer b = new StringBuffer();
			for (GTNode n : allNewProcesses) {
				b.append(n.getID() + ",");
			}
			logger.debug("Appending the distance matrix for {} new processes: {}", allNewProcesses.size(), b.toString());
		}
		Collection<String> newRoots = new HashSet<String>();
		for (GTNode c : allNewProcesses) {
			String processName = processImporter.getProcessNameOfNode(c); 
			String rootId = pdao.getRootFragmentId(processName);
			newRoots.add(rootId);
		}
		
		csrv.appendGEDMatrix(newRoots);
	}
	
	private List<GTNode> getDirectNextLevelModels(GTNode node, Set<GTNode> undividableModels) throws Exception {
		List<GTNode> nextLevelModels = new ArrayList<GTNode>();
		
		Queue<GTNode> complexLogClusters = new LinkedList<GTNode>();
		complexLogClusters.add(node);
		while (!complexLogClusters.isEmpty()) {
			GTNode c = complexLogClusters.poll();
			Collection<GTNode> children = clusterer.getChildren(c);
			if (children.isEmpty()) {
				// complex model "c" does not have child logs. so cannot be divided into simple models.
				// we have report this as an undividable model, so that it will be outputted as it is.
				undividableModels.add(c);
			} else {
				for (GTNode childLogCluster : children) {
					CPF childModel = miner.mineModel(childLogCluster.log);
					childLogCluster.cpf = childModel;
					nextLevelModels.add(childLogCluster);
				}
			}
		}
		
		if (logger.isDebugEnabled()) {
			StringBuffer b = new StringBuffer();
			for (GTNode n : nextLevelModels) {
				b.append(n.getID() + ",");
			}
			logger.debug("Next level models generated for the log cluster Id {} -> {}", 
					node.getGroupId() + "_" + node.getID(), b.toString());
		}
		return nextLevelModels;
	}

	private List<GTNode> getInitialNodes(int maxSize) throws Exception {
		List<GTNode> initialNodes = new ArrayList<GTNode>();
		GTNode root = clusterer.getRoot();
		Queue<GTNode> unprocessedNodes = new LinkedList<GTNode>();
		unprocessedNodes.add(root);
		
		while (!unprocessedNodes.isEmpty()) {
			GTNode node = unprocessedNodes.poll();
			CPF cpf = miner.mineModel(node.log);
			if (cpf.getVertices().size() > maxSize) {
				Collection<GTNode> childNodes = clusterer.getChildren(node);
				unprocessedNodes.addAll(childNodes);
			} else {
				node.cpf = cpf;
				initialNodes.add(node);
			}
		}
		return initialNodes;
	}
	
	private void serialize(String outFolder, Map<GTNode, CPF> gs) {
		
		try {
			FileUtils.cleanDirectory(new File(outFolder));
		} catch (IOException e) {
			System.out.println("Failed to clear folder " + outFolder);
		}
		
		int modelNumber = 0;
		for (GTNode logCluster : gs.keySet()) {
			modelNumber++;
			String processName = processImporter.getProcessNameOfNode(logCluster);
			File modelFile = new File(outFolder, processName + ".epml");
			formattableEPCSerializer.serialize(gs.get(logCluster), modelFile.getAbsolutePath());
		}
	}
	
	private void serializeSubprocesses(String outFolder, GTProcessStandardizer standardizer) {
		
		try {
			FileUtils.cleanDirectory(new File(outFolder));
		} catch (IOException e) {
			System.out.println("Failed to clear folder " + outFolder);
		}
		Map<String, CPF> gs = standardizer.getStandardizedSubprocesses();
		Map<String, StandardizedCluster> cs = standardizer.getStandardizedClusters();
		int modelNumber = 0;
		for (String cid : cs.keySet()) {
			StandardizedCluster c = cs.get(cid);
			String repFragmentId = c.getRepresentativeFragmentId();
			CPF cpf = gs.get(repFragmentId);
			modelNumber++;
			File modelFile = new File(outFolder, repFragmentId + ".epml");
			formattableEPCSerializer.serialize(cpf, modelFile.getAbsolutePath());
		}
	}

}
