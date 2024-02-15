package javaSwing;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class StudentReport extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable resultTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentReport frame = new StudentReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void displayResult(){
		DefaultTableModel model= (DefaultTableModel)resultTable.getModel();
		model.setRowCount(0);			
		String url = "jdbc:mysql://localhost:3307/courses";
	    String baseUsername = "root";
	    String basePassword = "";
	    String email = Login.mail();
	    try {
	           Connection con = DriverManager.getConnection(url, baseUsername, basePassword);
	           Statement stmt = con.createStatement();
	           String query = "select * from courses.Result WHERE Email = '"+email+"'";
	           ResultSet rs = stmt.executeQuery(query);
	           while(rs.next()){
	        	   String id = rs.getString(1);
	        	   String name= rs.getString(2);
	        	   String mail= rs.getString(3);
	        	   String module = rs.getString(4);
	        	   String course= rs.getString(5);
	        	   String level = rs.getString(6);
	        	   String marks= rs.getString(7);
	        	   String data[]= {id,name, mail,module,course,level,marks};
	        	   model.addRow(data);
	           }
	       }
			catch (SQLException e1) {
	           e1.printStackTrace();
	       }	
	}
	
	/**
	 * Create the frame.
	 */
	public StudentReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 92, 704, 360);
		contentPane.add(scrollPane);
		
		resultTable = new JTable();
		scrollPane.setViewportView(resultTable);
		resultTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Full Name", "Email", "Module", "Course","level", "Marks"
			}
		));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 65, 704, 15);
		contentPane.add(separator);
		
		Panel pannel = new Panel();
		pannel.setBackground(new Color(153, 193, 241));
		pannel.setBounds(23, 10, 224, 35);
		contentPane.add(pannel);
		pannel.setLayout(null);

		

		JLabel lblResult = new JLabel("Student Result");
		lblResult.setBackground(new Color(255, 255, 255));
		lblResult.setFont(new Font("Dialog", Font.BOLD, 16));
		lblResult.setBounds(12, 0, 180, 35);
		pannel.add(lblResult);
		
		JButton btnResult = new JButton("Result");
		btnResult.setBackground(new Color(222, 221, 218));
		btnResult.setIcon(new ImageIcon("/home/bisekh/Desktop/JavaEclipse/Week10/Swing/JavaIcons/icons8-report-card-50.png"));
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayResult();
				
			}
		});
		btnResult.setBounds(506, 10, 181, 43);
		contentPane.add(btnResult);
		
	}
}
