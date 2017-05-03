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
package com.IKP.database.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.IKP.database.callbacks.AddItemCallback;
import com.IKP.database.callbacks.RemoveItemCallback;
import com.IKP.database.model.UsedClass;
import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;
import com.IKP.database.service.MainFrameService;
import com.IKP.database.serviceimpl.MainFrameServiceImpl;
import com.IKP.database.ui.additem.AddItemForm;
import com.IKP.database.ui.additem.RemoveItemForm;
import com.IKP.utils.NumberConstants;
import com.IKP.utils.StringConstants;

public class MainFrame extends JFrame implements RemoveItemCallback, AddItemCallback {

	private MainFrameService mainFrameService;
	private TablePanel userPanel;
	private TablePanel runPanel;
	private StatusPanel statusPanel;

	// Add/remove the item of User
	private AddItemForm addUserForm;
	private UsedClass user = new User();
	private RemoveItemForm removeUserForm;

	// Add/remove the item of RunRange
	private AddItemForm addRunForm;
	private UsedClass run = new RunRange();
	private RemoveItemForm removeRunForm;

	private JTabbedPane tabbedPane = null;
	ImageIcon icon = new ImageIcon("java-swing-tutorial.JPG");

	JMenuBar menuBar = null;
	JMenu jMenu = null;
	JMenu miniMenu = null;
	JMenuItem addItem = null;
	JMenuItem removeItem = null;

	public MainFrame() {
		super(StringConstants.APP_NAME);
		constructAppWindow();
		setJMenuBar(createFrameMenu());
		initializeVariables();
		constructLayout();
		refreshTable();
		setCallbacks();
	}

	private void initializeVariables() {
		this.mainFrameService = new MainFrameServiceImpl();
		this.tabbedPane = new JTabbedPane();
		this.userPanel = new TablePanel(user);
		this.runPanel = new TablePanel(run);

		this.statusPanel = new StatusPanel();

		this.addUserForm = new AddItemForm(this, user);
		this.removeUserForm = new RemoveItemForm(this, user);

		this.addRunForm = new AddItemForm(this, run);
		this.removeRunForm = new RemoveItemForm(this, run);
	}

	private void setCallbacks() {
		this.addUserForm.setCallback(this);
		this.removeUserForm.setCallback(this);

		this.addRunForm.setCallback(this);
		this.removeRunForm.setCallback(this);

	}

	private void refreshTable() {
		List<UsedClass> users = this.mainFrameService.getAllRows(user);
		List<UsedClass> runs = this.mainFrameService.getAllRows(run);

		this.userPanel.setTableModel(users);
		this.userPanel.updateTable();

		this.runPanel.setTableModel(runs);
		this.runPanel.updateTable();
	}

	private void constructLayout() {
		setLayout(new BorderLayout());

		tabbedPane.addTab("Users", userPanel);

		tabbedPane.addTab("Run Ranges", runPanel);
		JPanel jplInnerPanel1 = createInnerPanel("Run Range tables will be here");

		jplInnerPanel1 = createInnerPanel("Wire Tables");
		tabbedPane.addTab("Wire Tables", icon, jplInnerPanel1);

		jplInnerPanel1 = createInnerPanel("HV Components");
		tabbedPane.addTab("HV Components", icon, jplInnerPanel1);

		jplInnerPanel1 = createInnerPanel("Sense Ranges");
		tabbedPane.addTab("Sense Ranges", icon, jplInnerPanel1);

		jplInnerPanel1 = createInnerPanel("Layer");
		tabbedPane.addTab("Layer", icon, jplInnerPanel1);

		jplInnerPanel1 = createInnerPanel("stbMap");
		tabbedPane.addTab("stbMap", icon, jplInnerPanel1);

		add(tabbedPane, BorderLayout.CENTER);

		// add(tablePanel, BorderLayout.CENTER);
		add(statusPanel, BorderLayout.SOUTH);
	}

	protected JPanel createInnerPanel(String text) {
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 1));
		jplPanel.add(jlbDisplay);
		return jplPanel;
	}

	private void constructAppWindow() {
		setSize(NumberConstants.APP_WINDOW_SIZE_WIDTH, NumberConstants.APP_WINDOW_SIZE_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JMenuBar createFrameMenu() {
		menuBar = new JMenuBar();

		menuBar.add(createFileMenu());
		menuBar.add(createUserMenu());
		menuBar.add(createRunMenu());

		menuBar.add(createWireMenu());

		menuBar.add(createHVMenu());

		menuBar.add(createSenseMenu());

		menuBar.add(createLayerMenu());

		menuBar.add(createStbMapMenu());

		return menuBar;

	}

	private JMenu createFileMenu() {
		jMenu = new JMenu(StringConstants.MAIN_MENU_FILE);
		JMenuItem openItem = new JMenuItem(StringConstants.MAIN_MENU_OPEN);
		JMenuItem exitItem = new JMenuItem(StringConstants.MAIN_MENU_EXIT);

		jMenu.add(openItem);
		jMenu.add(exitItem);

		exitItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this, StringConstants.MAIN_MENU_EXIT_TEXT,
						StringConstants.MAIN_MENU_EXIT_TITLE, JOptionPane.OK_CANCEL_OPTION);

				if (action == JOptionPane.OK_OPTION) {
					mainFrameService.shutdown();
					statusPanel.stopTimer();
					System.gc();
					System.exit(0);
				}
			}
		});

		return jMenu;
	}

	private JMenu createUserMenu() {
		// Users
		jMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_USER);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_USER);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_USER);

		jMenu.add(addItem);
		jMenu.add(removeItem);
		addItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addUserForm.setVisible(true);
			}
		});
		removeItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				removeUserForm.setVisible(true);
			}
		});
		return jMenu;
	}

	private JMenu createRunMenu() {
		jMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_RUNRANGES);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_RUNRANGES);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_RUNRANGES);

		addItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addRunForm.setVisible(true);
			}
		});
		removeItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				removeRunForm.setVisible(true);
			}
		});

		jMenu.add(addItem);
		jMenu.add(removeItem);
		return jMenu;
	}

	private JMenu createWireMenu() {
		// Wires
		jMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_WIRE);
		// wireToLocWire
		miniMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_WIRETOLOCWIRE);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_WIRETOLOCWIRE);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_WIRETOLOCWIRE);
		miniMenu.add(addItem);
		miniMenu.add(removeItem);
		jMenu.add(miniMenu);
		// wireToPin
		miniMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_WIRETOPIN);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_WIRETOPIN);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_WIRETOPIN);
		miniMenu.add(addItem);
		miniMenu.add(removeItem);
		jMenu.add(miniMenu);

		return jMenu;
	}

	private JMenu createHVMenu() {
		// HV
		jMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_HV);
		// hvSubSlotChanSF
		miniMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_HVSUBSLOTCHANSF);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_HVSUBSLOTCHANSF);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_HVSUBSLOTCHANSF);
		miniMenu.add(addItem);
		miniMenu.add(removeItem);
		jMenu.add(miniMenu);
		// hvSubSlotChanG
		miniMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_HVSUBSLOTCHANG);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_HVSUBSLOTCHANG);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_HVSUBSLOTCHANG);
		miniMenu.add(addItem);
		miniMenu.add(removeItem);
		jMenu.add(miniMenu);
		// hvCrateSlot
		miniMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_HVCRATESLOT);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_HVCRATESLOT);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_HVCRATESLOT);
		miniMenu.add(addItem);
		miniMenu.add(removeItem);
		jMenu.add(miniMenu);
		// hvpIntoLayer
		miniMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_HVPINTOLAYER);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_HVPINTOLAYER);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_HVPINTOLAYER);
		miniMenu.add(addItem);
		miniMenu.add(removeItem);
		jMenu.add(miniMenu);
		// hvdbTohvtb
		miniMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_HVDBTOHVTB);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_HVDBTOHVTB);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_HVDBTOHVTB);
		miniMenu.add(addItem);
		miniMenu.add(removeItem);
		jMenu.add(miniMenu);

		return jMenu;
	}

	private JMenu createSenseMenu() {
		// Sense Menu
		jMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_SENSERANGE);

		// senseWireRange
		miniMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_SENSEWIRERANGE);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_SENSEWIRERANGE);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_SENSEWIRERANGE);
		miniMenu.add(addItem);
		miniMenu.add(removeItem);
		jMenu.add(miniMenu);
		// senseLayerRange
		miniMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_SENSELAYERRANGE);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_SENSELAYERRANGE);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_SENSELAYERRANGE);
		miniMenu.add(addItem);
		miniMenu.add(removeItem);
		jMenu.add(miniMenu);

		return jMenu;
	}

	private JMenu createLayerMenu() {
		// layer
		jMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_LAYER);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_LAYER);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_LAYER);
		jMenu.add(addItem);
		jMenu.add(removeItem);

		return jMenu;
	}

	private JMenu createStbMapMenu() {
		// stbMap
		jMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW_STBMAP);
		addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_STBMAP);
		removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_STBMAP);
		jMenu.add(addItem);
		jMenu.add(removeItem);
		return jMenu;
	}

	public void itemSaved() {
		refreshTable();
		this.removeUserForm.loadData();
		this.removeRunForm.loadData();

	}

	public void itemRemoved() {
		refreshTable();
		this.removeUserForm.loadData();
		this.removeRunForm.loadData();

	}
}
