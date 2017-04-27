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
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.IKP.database.callbacks.RemoveItemCallback;
import com.IKP.database.model.UsedClass;
import com.IKP.database.service.RemoveItemFormService;
import com.IKP.database.serviceimpl.RemoveItemFormServiceImpl;
import com.IKP.utils.NumberConstants;
import com.IKP.utils.StringConstants;

public class RemoveItemForm extends JDialog implements ActionListener {
	private JButton cancelButton;
	private JButton removeButton;
	private JLabel aJLabel;
	private RemoveItemFormService removeItemFormService;
	private RemoveItemCallback removeCallback;

	private JComboBox<UsedClass> aComboBox;

	private String type;

	UsedClass usedClass;

	public RemoveItemForm(JFrame parentFrame, UsedClass usedClass) {
		super(parentFrame, StringConstants.RUN_REMOVE_FORM_TITLE, false);
		this.type = usedClass.getClass().getSimpleName();
		this.usedClass = usedClass;
		System.out.println("###################");
		System.out.println("###################");
		System.out.println(type);

		System.out.println("###################");
		System.out.println("###################");

		initializeVariables();
		loadData();
		constructLayout();
		setWindow(parentFrame);
	}

	private void initializeVariables() {

		this.removeItemFormService = new RemoveItemFormServiceImpl(usedClass);
		this.aComboBox = new JComboBox<UsedClass>();

		if (this.type.equalsIgnoreCase("RunRange")) {
			this.aJLabel = new JLabel(StringConstants.RUN_FORM_NAME);
		}

		if (this.type.equalsIgnoreCase("User")) {
			this.aJLabel = new JLabel(StringConstants.USER_FORM_NAME);
		}

		this.cancelButton = new JButton(StringConstants.USER_FORM_CANCEL);
		this.removeButton = new JButton(StringConstants.USER_REMOVE_FORM_DELETE);

		this.cancelButton.addActionListener(this);
		this.removeButton.addActionListener(this);
	}

	public void loadData() {

		this.aComboBox.removeAllItems();

		List<UsedClass> rows = this.removeItemFormService.getAllItems();

		for (UsedClass row : rows)
			this.aComboBox.addItem(row);
	}

	private void setWindow(JFrame parentFrame) {
		setSize(NumberConstants.USER_FORM_WINDOW_SIZE_WIDTH, NumberConstants.USER_REMOVE_FORM_WINDOW_SIZE_HEIGHT);
		setLocationRelativeTo(parentFrame);
	}

	private void constructLayout() {

		JPanel userInfoPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();

		int space = 15;
		Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
		Border titleBorder = BorderFactory.createTitledBorder(StringConstants.RUN_REMOVE_FORM_SUBTITLE);

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
		userInfoPanel.add(aJLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		userInfoPanel.add(aComboBox, gc);

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

	public void setCallback(RemoveItemCallback removeCallback) {
		this.removeCallback = removeCallback;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.cancelButton) {
			setVisible(false);
		} else if (event.getSource() == this.removeButton) {

			UsedClass row = (UsedClass) this.aComboBox.getSelectedItem();

			this.removeItemFormService.removeItem(row);
			this.removeCallback.itemRemoved();

			this.setVisible(false);
		}
	}
}
