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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

class NewTable extends JFrame

{

	private JPanel topPanel;

	private JTable table;

	public JScrollPane scrollPane;

	public JScrollPane scrollPane1;

	private String[] columnNames = new String[3];

	private String[][] dataValues = new String[3][3];

	JButton button = new JButton("Click Here");

	public NewTable() {

		setTitle("Button Click and JTable Appears");

		setSize(320, 300);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		button.setBounds(75, 200, 90, 30);

		columnNames = new String[] { "Column 1", "Column 2", "Column 3" };

		dataValues = new String[][]

		{

				{ "a", "2", "3" },

				{ "b", "5", "6" },

				{ "c", "8", "9" }

		};

		topPanel = new JPanel();

		topPanel.setLayout(null);

		getContentPane().add(topPanel);

		table = new JTable();

		scrollPane = new JScrollPane(table);

		scrollPane.setSize(300, 200);

		scrollPane1 = new JScrollPane(button);

		scrollPane1.setSize(90, 30);

		scrollPane1.setBounds(75, 200, 150, 30);

		topPanel.add(scrollPane);

		topPanel.add(scrollPane1);

		button.addActionListener(

				new ActionListener()

				{

					public void actionPerformed(ActionEvent event)

				{

						TableModel model = new myTableModel();

						table.setModel(model);

					}

				}

		);

	}

	public class myTableModel extends DefaultTableModel

	{

		myTableModel()

		{

			super(dataValues, columnNames);

		}

		public boolean isCellEditable(int row, int cols)

		{

			return true;

		}

	}

	public static void main(String args[])

	{

		NewTable x = new NewTable();

		x.setVisible(true);

	}
}