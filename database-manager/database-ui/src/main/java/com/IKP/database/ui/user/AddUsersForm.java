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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.IKP.database.callbacks.AddUserCallback;
import com.IKP.database.model.entities.User;
import com.IKP.database.service.AddUserFormService;
import com.IKP.database.serviceimpl.AddUserFormServiceImpl;
import com.IKP.utils.NumberConstants;
import com.IKP.utils.StringConstants;

public class AddUsersForm extends JDialog implements ActionListener {// implements
																		// ActionListener

	private JButton cancelButton;
	private JButton saveButton;
	private JLabel nameLabel;
	private JLabel passwordLabel;
	private JLabel rolesLabel;
	private JLabel infoLabel;
	private JLabel isDeletedLabel;

	private JTextField nameField;
	private JTextField passwordField;
	private JTextField rolesField;
	private JTextField infoField;
	private JTextField isDeletedField;

	private AddUserFormService addUserFormService;
	private AddUserCallback addUserCallback;

	public AddUsersForm(JFrame parentFrame) {
		super(parentFrame, StringConstants.USER_FORM_TITLE, false);

		initializeVariables();
		constructLayout();
		setWindow(parentFrame);
	}

	private void setWindow(JFrame parentFrame) {
		setSize(NumberConstants.USER_FORM_WINDOW_SIZE_WIDTH, NumberConstants.USER_FORM_WINDOW_SIZE_HEIGHT);
		setLocationRelativeTo(parentFrame);
	}

	private void initializeVariables() {
		this.addUserFormService = new AddUserFormServiceImpl();
		this.cancelButton = new JButton(StringConstants.USER_FORM_CANCEL);
		this.saveButton = new JButton(StringConstants.USER_FORM_SAVE);

		this.nameLabel = new JLabel(StringConstants.USER_FORM_NAME);
		this.passwordLabel = new JLabel(StringConstants.USER_FORM_PASSWORD);
		this.rolesLabel = new JLabel(StringConstants.USER_FORM_ROLES);
		this.infoLabel = new JLabel(StringConstants.USER_FORM_INFO);
		this.isDeletedLabel = new JLabel(StringConstants.USER_FORM_ISDELETED);

		this.nameField = new JTextField(NumberConstants.USER_FORM_WINDOW_FIELD_LENGTH);
		this.passwordField = new JTextField(NumberConstants.USER_FORM_WINDOW_FIELD_LENGTH);
		this.rolesField = new JTextField(NumberConstants.USER_FORM_WINDOW_FIELD_LENGTH);
		this.infoField = new JTextField(NumberConstants.USER_FORM_WINDOW_FIELD_LENGTH);
		this.isDeletedField = new JTextField(NumberConstants.USER_FORM_WINDOW_FIELD_LENGTH);

		this.cancelButton.addActionListener(this);
		this.saveButton.addActionListener(this);
	}

	private void constructLayout() {

		JPanel userInfoPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();

		int space = 15;
		Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
		Border titleBorder = BorderFactory.createTitledBorder(StringConstants.USER_FORM_SUBTITLE);

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
		userInfoPanel.add(nameLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		userInfoPanel.add(nameField, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		userInfoPanel.add(passwordLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		userInfoPanel.add(passwordField, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		userInfoPanel.add(rolesLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		userInfoPanel.add(rolesField, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		userInfoPanel.add(infoLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		userInfoPanel.add(infoField, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		userInfoPanel.add(isDeletedLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		userInfoPanel.add(isDeletedField, gc);

		// ////////// Buttons Panel ///////////////

		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(saveButton);
		buttonsPanel.add(cancelButton);

		Dimension btnSize = cancelButton.getPreferredSize();
		saveButton.setPreferredSize(btnSize);

		// Add sub panels to dialog
		setLayout(new BorderLayout());
		add(userInfoPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.cancelButton) {
			setVisible(false);
		} else if (event.getSource() == this.saveButton) {

			String name = this.nameField.getText();
			String password = this.passwordField.getText();
			String roles = this.rolesField.getText();
			String info = this.infoField.getText();

			byte isDeleted = Byte.parseByte(this.isDeletedField.getText());
			System.out.println(isDeleted + "Is deleted???!!?");
			User user = new User(name, password, roles, info, isDeleted);
			this.addUserFormService.insertUser(user);

			this.addUserCallback.itemSaved();

			this.setVisible(false);
		}
	}

	public void setCallback(AddUserCallback addStudentCallback) {
		this.addUserCallback = addStudentCallback;
	}

}
