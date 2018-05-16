/*  +__^_________,_________,_____,________^-.-------------------,
 *  | |||||||||   `--------'     |          |                   O
 *  `+-------------USMC----------^----------|___________________|
 *    `\_,---------,---------,--------------'
 *      / X MK X /'|       /'
 *     / X MK X /  `\    /'
 *    / X MK X /`-------'
 *   / X MK X /
 *  / X MK X /
 * (________(                @author m.c.kunkel
 *  `------'
*/
package databaseextras;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class TestTable extends JDialog implements ActionListener {
	private JTable table = null;
	private JButton executeButton = null;
	private JButton cancelButton = null;
	public List<Integer> runList = null;
	MainFrameService mService = null;

	public TestTable() {
		System.out.println("I should have be --- 3");

		this.runList = new ArrayList<>();
		mService = MainFrameServiceManager.getSession();
		initializeVariables();
		constructLayout();
		setWindow();
	}

	public void initializeVariables() {
		this.table = new JTable(makeTableModel());
		this.table.setAutoCreateRowSorter(true);
		this.table.setRowSelectionAllowed(true);
		this.table.setColumnSelectionAllowed(false);
		this.table.setCellSelectionEnabled(true);
		this.table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		makeButtons();
	}

	private DefaultTableModel makeTableModel() {
		List<String> runList = new ArrayList<>();
		runList.add("3111");
		runList.add("3222");
		Object[][] data = new Object[runList.size()][runList.size()];
		for (int i = 0; i < runList.size(); i++) {
			for (int j = 0; j < runList.size(); j++) {
				data[i][j] = runList.get(i);
			}
		}
		String[] columnNames = { "Runs" };

		DefaultTableModel model = new DefaultTableModel(data, columnNames) {

			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		return model;
	}

	public void makeButtons() {

		this.executeButton = new JButton("OK");
		this.executeButton.addActionListener(this);
		this.executeButton.setToolTipText("This will create script based upon Run selections");
		this.cancelButton = new JButton("Cancel");
		this.cancelButton.addActionListener(this);

	}

	private void setWindow() {
		setSize(400, 400);
		setLocationRelativeTo(null);
	}

	private void constructLayout() {

		JPanel fileInfoPanel = new JPanel();
		Border spaceBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
		Border titleBorder = BorderFactory.createTitledBorder("Runs!!");
		fileInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		fileInfoPanel.setLayout(new GridBagLayout());

		Insets leftPadding = new Insets(0, 0, 0, 0);

		PanelConstraints.addComponent(fileInfoPanel, new JScrollPane(this.table), 0, 0, 1, 1,
				GridBagConstraints.LINE_START, GridBagConstraints.BOTH, leftPadding, 0, 0);
		// ////////// Buttons Panel ///////////////
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		Dimension btnSize = executeButton.getPreferredSize();
		executeButton.setPreferredSize(btnSize);
		buttonsPanel.add(executeButton);
		buttonsPanel.add(cancelButton);

		setLayout(new GridBagLayout());// BorderLayout
		PanelConstraints.addComponent(this, fileInfoPanel, 1, 0, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, 0, 100);
		PanelConstraints.addComponent(this, buttonsPanel, 1, 1, 1, 1, GridBagConstraints.LAST_LINE_END,
				GridBagConstraints.BOTH, 0, 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.cancelButton) {
			this.setVisible(false);
		} else if (e.getSource() == this.executeButton) {
			processList();
		} else {
			System.err.println("I have no idea why I am here or why I wrote this...bored?");
		}
		this.setVisible(false);
	}

	private void processList() {
		if (table.getSelectedRow() != -1) {
			for (int aInt : table.getSelectedRows()) {
				this.mService.getRunList().add(Integer.parseInt(table.getValueAt(aInt, 0).toString()));
			}
			this.mService.runWriteProcess();
			if (this.mService.getWantsToExecute()) {
				try {
					this.mService.runScript();
				} catch (IOException | InterruptedException e) {
					System.err.println("This error is in the running at the Jlab cluster. Do you have permissions?");
					e.printStackTrace();
				}
			}
		}
	}
}
