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
package com.IKP.database.ui.user;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.IKP.database.callbacks.RemovedUserCallback;
import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;
import com.IKP.database.service.RemoveUserFormService;
import com.IKP.database.serviceimpl.RemoveUserFormServiceImpl;
import com.IKP.utils.NumberConstants;
import com.IKP.utils.StringConstants;

public class RemoveUsersForm extends JDialog implements ActionListener {

	private JButton cancelButton;
	private JButton removeButton;
	private JLabel userName;
	private RemoveUserFormService removeUserFormService;
	private RemovedUserCallback removeCallback;

	private JComboBox<User> usersNameComboBox;
	private JComboBox<RunRange> runRangeComboBox;

	public RemoveUsersForm(JFrame parentFrame) {
		super(parentFrame, StringConstants.USER_REMOVE_FORM_TITLE, false);

		initializeVariables();
		loadData();
		constructLayout();
		setWindow(parentFrame);
	}

	public void loadData() {

		this.usersNameComboBox.removeAllItems();
		// this.runRangeComboBox.removeAllItems();

		List<User> users = this.removeUserFormService.getAllUsers();
		// List<RunRange> runs = this.removeUserFormService.getAllRuns();

		for (User user : users)
			this.usersNameComboBox.addItem(user);
		// for (RunRange run : runs)
		// this.runRangeComboBox.addItem(run);
	}

	private void setWindow(JFrame parentFrame) {
		setSize(NumberConstants.USER_FORM_WINDOW_SIZE_WIDTH, NumberConstants.USER_REMOVE_FORM_WINDOW_SIZE_HEIGHT);
		setLocationRelativeTo(parentFrame);
	}

	private void initializeVariables() {

		this.removeUserFormService = new RemoveUserFormServiceImpl();
		this.usersNameComboBox = new JComboBox<User>();

		this.cancelButton = new JButton(StringConstants.USER_FORM_CANCEL);
		this.removeButton = new JButton(StringConstants.USER_REMOVE_FORM_DELETE);

		this.userName = new JLabel(StringConstants.USER_FORM_NAME);

		this.cancelButton.addActionListener(this);
		this.removeButton.addActionListener(this);
	}

	private void constructLayout() {

		JPanel userInfoPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();

		int space = 15;
		Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
		Border titleBorder = BorderFactory.createTitledBorder(StringConstants.USER_REMOVE_FORM_SUBTITLE);

		userInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

		userInfoPanel.setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridy = 0;

		Insets rightPadding = new Insets(0, 0, 0, 15);
		Insets noPadding = new Insets(0, 0, 0, 0);

		// ///// First row /////////////////////////////

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		userInfoPanel.add(userName, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		userInfoPanel.add(usersNameComboBox, gc);

		// ////////// Buttons Panel ///////////////

		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(removeButton);
		buttonsPanel.add(cancelButton);

		Dimension btnSize = removeButton.getPreferredSize();
		cancelButton.setPreferredSize(btnSize);

		// Add sub panels to dialog
		setLayout(new BorderLayout());
		add(userInfoPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	public void setCallback(RemovedUserCallback removeCallback) {
		this.removeCallback = removeCallback;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.cancelButton) {
			setVisible(false);
		} else if (event.getSource() == this.removeButton) {

			User user = (User) this.usersNameComboBox.getSelectedItem();

			this.removeUserFormService.removeUser(user);
			this.removeCallback.userRemoved();

			this.setVisible(false);
		}
	}
}
