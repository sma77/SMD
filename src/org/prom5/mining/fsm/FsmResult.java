package org.prom5.mining.fsm;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.prom5.framework.models.ModelGraphPanel;
import org.prom5.framework.models.fsm.FSM;
import org.prom5.framework.plugin.ProvidedObject;
import org.prom5.framework.plugin.Provider;

/**
 * <p>Title: FsmResult</p>
 *
 * <p>Description: Result of the FSM miner</p>
 *
 * <p>Copyright: Copyright (c) 2004</p>
 *
 * <p>Company: TU/e</p>
 *
 * @author Eric Verbeek
 * @version 1.0
 *
 * Code rating: Red
 *
 * Review rating: Red
 */
public class FsmResult extends JPanel implements Provider {

	private FSM fsm;

	public FsmResult(FSM fsm) {
		this.fsm = fsm;
		setLayout(new BorderLayout());
		JScrollPane fsmContainer = new JScrollPane();

		ModelGraphPanel gp = fsm.getGrappaVisualization();
		fsmContainer.setViewportView(gp);
		add("Center", fsmContainer);
	}

	public ProvidedObject[] getProvidedObjects() {
		return new ProvidedObject[] {
				new ProvidedObject("FSM", fsm)
		};
	}
}
