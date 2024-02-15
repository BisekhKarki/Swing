package javaSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditingTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField tutorEmail;
	private JTextField tutorPhone;
	private JTextField course;
	private JLabel lblId;
	private JTextField tutorID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditingTutor frame = new EditingTutor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditingTutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFirstName.setBounds(12, 96, 127, 23);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLastName.setBounds(12, 142, 127, 23);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(12, 200, 127, 23);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhone.setBounds(12, 259, 127, 23);
		contentPane.add(lblPhone);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCourse.setBounds(12, 321, 127, 23);
		contentPane.add(lblCourse);
		
		JButton tutorEdit = new JButton("Update");
		tutorEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tutorID.getText();
				String first = fname.getText();
				String last = lname.getText();
				String email = tutorEmail.getText();
				String phone = tutorPhone.getText();
				String module = course.getText();
				updateTutor ut = new updateTutor();
				ut.updatingTutor(id,first,last, email, phone,module);
				Dashboard.tutorsData();
				dispose();
				
			}
			
			
		});
		tutorEdit.setBounds(167, 385, 156, 35);
		contentPane.add(tutorEdit);
		
		fname = new JTextField();
		fname.setBounds(167, 84, 156, 35);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(167, 136, 156, 35);
		contentPane.add(lname);
		
		tutorEmail = new JTextField();
		tutorEmail.setColumns(10);
		tutorEmail.setBounds(167, 194, 156, 35);
		contentPane.add(tutorEmail);
		
		tutorPhone = new JTextField();
		tutorPhone.setColumns(10);
		tutorPhone.setBounds(167, 253, 156, 35);
		contentPane.add(tutorPhone);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(167, 315, 156, 35);
		contentPane.add(course);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblId.setBounds(22, 43, 127, 23);
		contentPane.add(lblId);
		
		tutorID = new JTextField();
		tutorID.setColumns(10);
		tutorID.setBounds(167, 37, 156, 35);
		contentPane.add(tutorID);
	}
}
