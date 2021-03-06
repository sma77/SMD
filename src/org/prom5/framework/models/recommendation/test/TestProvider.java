package org.prom5.framework.models.recommendation.test;

import java.io.IOException;

import org.prom5.framework.log.ProcessInstance;
import org.prom5.framework.models.recommendation.Recommendation;
import org.prom5.framework.models.recommendation.RecommendationProvider;
import org.prom5.framework.models.recommendation.RecommendationQuery;
import org.prom5.framework.models.recommendation.RecommendationResult;

public class TestProvider implements RecommendationProvider {
	public RecommendationResult getRecommendation(RecommendationQuery query) throws Exception,
			IOException {
/*		System.out.println("Received following query:");
		System.out.println(query.toString());
		RecommendationResult result = new RecommendationResult(query.getId());
		for (AuditTrailEntry ate : query.getAuditTrail()) {
			Recommendation rec = new Recommendation();
			rec.setTask(ate.getElement());
			rec.setConfidence((new Random()).nextDouble());
			rec.setRationale("Because we can...");
			rec.addUser(ate.getOriginator());
			rec.addRole("Dummy role");
			rec.addGroup("Dummy group");
			result.add(rec);
		}
		System.out.println("\n\n\nTransmitting result:");
		System.out.println(result.toString());
		return result;
	   */
	  return null;
	}

	public void signalPickedResult(RecommendationResult result, int index) {
		// TODO Auto-generated method stub

	}

	public void signalPickedResult(RecommendationResult result, Recommendation picked) {
		signalPickedResult(result, (picked == null ? -1 : result.indexOf(picked)));
	}

	public void handleCompletedExecution(ProcessInstance instance) {
		// no implementation at this point
	}

	public void requestRestart(String contributor, String scale) throws Exception {
	}

	public void requestClose() throws Exception {
	}

}
