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
package com.IKP.database.ui.additem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.IKP.database.callbacks.AddItemCallback;
import com.IKP.database.model.UsedClass;
import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;
import com.IKP.database.service.AddItemFormService;
import com.IKP.database.serviceimpl.AddItemFormServiceImpl;
import com.IKP.utils.NumberConstants;
import com.IKP.utils.StringConstants;

public class AddItemForm extends JDialog implements ActionListener {
	private JButton cancelButton;
	private JButton saveButton;

	private List<JLabel> jLabels;
	private List<JTextField> jTextFields;

	private String type;
	private List<String> aList;

	private AddItemFormService addItemFormService;
	private AddItemCallback addCallback;

	public AddItemForm(JFrame parentFrame, UsedClass usedClass) {
		super(parentFrame, StringConstants.RUN_FORM_TITLE, false);
		this.type = usedClass.getClass().getSimpleName();
		this.aList = usedClass.getFieldList();
		this.jLabels = new ArrayList<JLabel>();
		this.jTextFields = new ArrayList<JTextField>();
		initializeVariables();
		constructLayout();
		setWindow(parentFrame);

	}

	private void initializeVariables() {
		this.addItemFormService = new AddItemFormServiceImpl();
		this.cancelButton = new JButton(StringConstants.USER_FORM_CANCEL);
		this.saveButton = new JButton(StringConstants.USER_FORM_SAVE);

		for (String str : aList) {
			this.jLabels.add(new JLabel(str));
			this.jTextFields.add(new JTextField(NumberConstants.USER_FORM_WINDOW_FIELD_LENGTH));
		}
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

		for (String str : aList) {
			System.out.println(str + " " + type);

			gc.weightx = 1;
			gc.weighty = 1;
			gc.fill = GridBagConstraints.NONE;

			gc.gridx = 0;
			gc.anchor = GridBagConstraints.EAST;
			gc.insets = rightPadding;
			userInfoPanel.add(this.jLabels.get(gc.gridy), gc);

			gc.gridx++;
			gc.anchor = GridBagConstraints.WEST;
			gc.insets = noPadding;
			userInfoPanel.add(this.jTextFields.get(gc.gridy), gc);
			gc.gridy++;
		}

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

			createItemType();
			this.setVisible(false);
		}
	}

	private void createItemType() {

		if (this.type.equalsIgnoreCase("RunRange")) {

			String name = this.jTextFields.get(0).getText();//
			int runMin = Integer.parseInt(this.jTextFields.get(1).getText());//
			int runMax = Integer.parseInt(this.jTextFields.get(2).getText());////
			String comment = this.jTextFields.get(3).getText(); //
			System.out.println("############################");
			System.out.println("############ NAME and COMMENT ################");

			System.out.println(name + " " + comment + " " + runMin + " " + runMax);

			RunRange runRange = new RunRange(name, runMin, runMax, comment);
			this.addItemFormService.insertRun(runRange);
			this.addCallback.itemSaved();
		}

		if (this.type.equalsIgnoreCase("User")) {

			String name = this.jTextFields.get(0).getText();
			String password = this.jTextFields.get(1).getText();
			String roles = this.jTextFields.get(2).getText();
			String info = this.jTextFields.get(3).getText();

			byte isDeleted = Byte.parseByte(this.jTextFields.get(4).getText());
			System.out.println(isDeleted + "Is deleted???!!?");
			User user = new User(name, password, roles, info, isDeleted);
			this.addItemFormService.insertUser(user);

			this.addCallback.itemSaved();
		}

	}

	public void setCallback(AddItemCallback addCallback) {
		this.addCallback = addCallback;
	}

}
