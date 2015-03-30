package org.prom5.mining.partialordermining;

import org.prom5.framework.log.LogReader;
import org.prom5.framework.models.ModelGraph;
import org.prom5.framework.plugin.ProvidedObject;
import org.prom5.mining.instancemining.ModelGraphResult;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2004</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class AggregationGraphResult extends ModelGraphResult {

	private LogReader log;

	public AggregationGraphResult(LogReader log, ModelGraph net) {
		super(net);
		this.log = log;
	}

	public LogReader getLogReader() {
		return log;
	}

	public ProvidedObject[] getProvidedObjects() {
		return new ProvidedObject[] {
				new ProvidedObject(net.getIdentifier(), new Object[] {net, log})
		};
	}

}
