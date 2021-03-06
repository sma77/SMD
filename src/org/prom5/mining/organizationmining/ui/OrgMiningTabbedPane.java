package org.prom5.mining.organizationmining.ui;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.prom5.framework.models.orgmodel.OrgModel;
import org.prom5.mining.organizationmining.OrgMiningResult;

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
public class OrgMiningTabbedPane extends JTabbedPane {

	public OrgMiningTabbedPane() {
	}

	private OrgModel orgModel = null;
	private OrgMiningResult parentPanel;

	// GUI attributes
	private OrgModelManagementPanel orgModelManagementPanel = null;
	private TaskOrgEntityPanel taskOrgEntityPanel = null;
	private OrgEntityResourcePanel orgEntityResourcePanel = null;


	public OrgMiningTabbedPane(OrgModel orgmod, OrgMiningResult parentpanel) {

		this.orgModel = orgmod;
		this.parentPanel = parentpanel;

		orgModelManagementPanel = new OrgModelManagementPanel(orgModel, parentPanel);
		this.add(orgModelManagementPanel, "Org Model Manager");

		taskOrgEntityPanel = new TaskOrgEntityPanel(orgModel, parentPanel);
		this.add(taskOrgEntityPanel, "Task <-> Org Entity");

		orgEntityResourcePanel = new OrgEntityResourcePanel(orgModel, parentPanel);
		this.add(orgEntityResourcePanel, "Org Entity <-> Resource");

		this.addChangeListener(new ChangeListener() {
				// This method is called whenever the selected tab changes
				public void stateChanged(ChangeEvent evt) {
					JTabbedPane pane = (JTabbedPane)evt.getSource();
					// Get current tab
					int sel = pane.getSelectedIndex();
					if(sel == 1) changeTaskOrgEntityPanel();
					else if(sel == 2) changeOrgEntityResourcePanel();
					// added by song
					parentPanel.updateActivitySet();
				}
			});
	}

	public void changeTaskOrgEntityPanel()
	{
		taskOrgEntityPanel.redrawTable();

	}

	public void changeOrgEntityResourcePanel()
	{
		orgEntityResourcePanel.redrawTable();
	}
}
