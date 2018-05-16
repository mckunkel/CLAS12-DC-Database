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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class NeedThread extends JPanel implements ActionListener {

	private Border spaceBorder = null;
	private Border titleBorder = null;
	private JButton ccDBButton = null;
	private JFrame errorFrame;
	MainFrameService mService = null;

	public NeedThread() {
		this.mService = MainFrameServiceManager.getSession();
		initializeVariables();
		initialLayout();

	}

	private void initializeVariables() {

		this.spaceBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
		this.titleBorder = BorderFactory.createTitledBorder("A Label");
		this.ccDBButton = new JButton("Choose this");
		this.ccDBButton.addActionListener(this);

		this.errorFrame = new JFrame("");

	}

	private void initialLayout() {
		setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		setLayout(new GridBagLayout());
		PanelConstraints.addComponent(this, ccDBButton, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				200, 0);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.mService.setWantsToExecute(false);
		if (event.getSource() == this.ccDBButton) {
			this.mService.setWantsToExecute(true);
			showNoDataChoice();
		}
	}

	private synchronized void runProcess() {
		showNoDataChoice();
	}

	private synchronized void executeScript() {

		System.out.println("I should have be --- 4");
		// try {
		// this.mService.runScript();
		// } catch (IOException | InterruptedException e) {
		// System.err.println("This error is in the running at the Jlab cluster.
		// Do you have permissions?");
		// e.printStackTrace();
		// }
	}

	private synchronized void showNoDataChoice() {
		System.out.println("I should have be --- 1");
		int n = JOptionPane.showConfirmDialog(errorFrame,
				"No data has been sent to the MySQL. \nDo you want to create CCDB entries from past MySQL entries?",
				"Eggs are not supposed to be green.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		if (n == 0) {
			System.out.println("I should have be --- 2");
			TestTable testTable = new TestTable();
			testTable.setVisible(true);
		}
	}

	private static void createAndShowUI() {
		JFrame frame = new JFrame("Simple");
		frame.add(new NeedThread());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				createAndShowUI();
			}
		});
	}

}
