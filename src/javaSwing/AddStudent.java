package javaSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField phone;
	private JTextField course;
	private JPasswordField pass;
	private JTextField levelStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFirstName.setBounds(35, 41, 123, 22);
		contentPane.add(lblFirstName);
		
		firstName = new JTextField();
		firstName.setBounds(186, 36, 150, 33);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(186, 99, 150, 33);
		contentPane.add(lastName);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(186, 166, 150, 33);
		contentPane.add(email);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(186, 299, 150, 33);
		contentPane.add(phone);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(186, 360, 150, 33);
		contentPane.add(course);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLastName.setBounds(35, 104, 123, 22);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(35, 171, 123, 22);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(35, 235, 123, 22);
		contentPane.add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhone.setBounds(35, 304, 123, 22);
		contentPane.add(lblPhone);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCourse.setBounds(35, 365, 123, 22);
		contentPane.add(lblCourse);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String first = firstName.getText();
				String last = lastName.getText();
				String mail = email.getText();
				char[] pa = pass.getPassword();
				String pass = new String(pa);
				String number = phone.getText();
				String subject = course.getText();
				String level = levelStudent.getText();
				StudentAdd st = new StudentAdd();
				st.addStudent(first,last, mail, pass, number, subject,level);
				Dashboard.dataStudent();
				dispose();
				
			}
		});
		btnAddStudent.setBounds(186, 481, 150, 39);
		contentPane.add(btnAddStudent);
		
		pass = new JPasswordField();
		pass.setBounds(186, 230, 150, 33);
		contentPane.add(pass);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLevel.setBounds(35, 419, 123, 22);
		contentPane.add(lblLevel);
		
		levelStudent = new JTextField();
		levelStudent.setColumns(10);
		levelStudent.setBounds(186, 416, 150, 33);
		contentPane.add(levelStudent);
	}
}
