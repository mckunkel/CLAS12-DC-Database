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
package com.IKP.database.ui.run;

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
import com.IKP.database.model.entities.RunRange;
import com.IKP.database.service.AddUserFormService;
import com.IKP.database.serviceimpl.AddUserFormServiceImpl;
import com.IKP.utils.NumberConstants;
import com.IKP.utils.StringConstants;

public class AddRunForm extends JDialog implements ActionListener {
	private JButton cancelButton;
	private JButton saveButton;

	private JLabel nameLabel;
	private JLabel commentLabel;
	private JLabel runMinLabel;
	private JLabel runMaxLabel;

	private JTextField nameField;
	private JTextField commentField;
	private JTextField runMinField;
	private JTextField runMaxField;

	private AddUserFormService addUserFormService;
	private AddUserCallback addUserCallback;

	public AddRunForm(JFrame parentFrame) {
		super(parentFrame, StringConstants.RUN_FORM_TITLE, false);
		initializeVariables();
		constructLayout();
		setWindow(parentFrame);
	}

	private void initializeVariables() {
		this.addUserFormService = new AddUserFormServiceImpl();
		this.cancelButton = new JButton(StringConstants.USER_FORM_CANCEL);
		this.saveButton = new JButton(StringConstants.USER_FORM_SAVE);

		this.nameLabel = new JLabel(StringConstants.RUN_FORM_NAME);
		this.commentLabel = new JLabel(StringConstants.RUN_FORM_COMMENT);
		this.runMinLabel = new JLabel(StringConstants.RUN_FORM_RUNMIN);
		this.runMaxLabel = new JLabel(StringConstants.RUN_FORM_RUNMAX);

		this.nameField = new JTextField(NumberConstants.USER_FORM_WINDOW_FIELD_LENGTH);
		this.commentField = new JTextField(NumberConstants.USER_FORM_WINDOW_FIELD_LENGTH);
		this.runMinField = new JTextField(NumberConstants.USER_FORM_WINDOW_FIELD_LENGTH);
		this.runMaxField = new JTextField(NumberConstants.USER_FORM_WINDOW_FIELD_LENGTH);

		this.cancelButton.addActionListener(this);
		this.saveButton.addActionListener(this);
	}

	private void constructLayout() {

		JPanel userInfoPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();

		int space = 15;
		Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
		Border titleBorder = BorderFactory.createTitledBorder(StringConstants.RUN_FORM_SUBTITLE);

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
		userInfoPanel.add(runMinLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		userInfoPanel.add(runMinField, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		userInfoPanel.add(runMaxLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		userInfoPanel.add(runMaxField, gc);

		// ////// Next row ////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		userInfoPanel.add(commentLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		userInfoPanel.add(commentField, gc);

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

	private void setWindow(JFrame parentFrame) {
		setSize(NumberConstants.USER_FORM_WINDOW_SIZE_WIDTH, NumberConstants.USER_FORM_WINDOW_SIZE_HEIGHT);
		setLocationRelativeTo(parentFrame);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.cancelButton) {
			setVisible(false);
		} else if (event.getSource() == this.saveButton) {

			String name = this.nameField.getText();
			int runMin = Integer.parseInt(this.runMinField.getText());
			int runMax = Integer.parseInt(this.runMaxField.getText());
			String comment = this.commentField.getText();

			RunRange runRange = new RunRange(name, runMin, runMax, comment);
			this.addUserFormService.insertRun(runRange);

			this.addUserCallback.itemSaved();

			this.setVisible(false);
		}
	}

	public void setCallback(AddUserCallback addUserCallback) {
		this.addUserCallback = addUserCallback;
	}
}
