package javaSwing;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField first;
	private JTextField last;
	private JTextField email;
	private JPasswordField pass;
	private JComboBox ComboBox;
	private JTextField phoneNumber;
	private JTextField courseText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel firstName = new JLabel("First Name");
		firstName.setFont(new Font("Dialog", Font.BOLD, 14));
		firstName.setBounds(252, 70, 155, 28);
		contentPane.add(firstName);
		
		
		JLabel LastName = new JLabel("Last Name");
		LastName.setFont(new Font("Dialog", Font.BOLD, 14));
		LastName.setBounds(252, 122, 155, 33);
		contentPane.add(LastName);
		
		JLabel userPassword = new JLabel("Password");
		userPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		userPassword.setBounds(252, 228, 155, 33);
		contentPane.add(userPassword);
		
		JLabel userEmail = new JLabel("Email");
		userEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		userEmail.setBounds(252, 173, 114, 33);
		contentPane.add(userEmail);
		
		ComboBox = new JComboBox();
		ComboBox.setModel(new DefaultComboBoxModel(new String[]{"Select user","Admin", "Teacher", "Student"}));
		ComboBox.setBounds(398, 376, 127, 24);
		contentPane.add(ComboBox);
		
		first = new JTextField();
		first.setBounds(398, 73, 127, 24);
		contentPane.add(first);
		first.setColumns(10);
		
		last = new JTextField();
		last.setBounds(398, 125, 127, 28);
		contentPane.add(last);
		last.setColumns(10);
		
		email = new JTextField();
		email.setBounds(398, 173, 127, 33);
		contentPane.add(email);
		email.setColumns(10);
		
		
		pass = new JPasswordField();
		pass.setBounds(398, 231, 133, 28);
		contentPane.add(pass);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpAction();			
			}
		});
		btnSignUp.setBounds(398, 412, 127, 25);
		contentPane.add(btnSignUp);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(398, 461, 127, 25);
		contentPane.add(btnLogin);
		
		JLabel WelcomeSignup = new JLabel("Welcome To Signup Page");
		WelcomeSignup.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeSignup.setFont(new Font("Dialog", Font.BOLD, 15));
		WelcomeSignup.setBounds(290, 12, 274, 39);
		contentPane.add(WelcomeSignup);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUser.setBounds(252, 379, 93, 19);
		contentPane.add(lblUser);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhoneNumber.setBounds(252, 285, 139, 24);
		contentPane.add(lblPhoneNumber);
		
		phoneNumber = new JTextField();
		phoneNumber.setBounds(398, 284, 127, 28);
		contentPane.add(phoneNumber);
		phoneNumber.setColumns(10);
		
		courseText = new JTextField();
		courseText.setBounds(398, 333, 127, 31);
		contentPane.add(courseText);
		courseText.setColumns(10);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCourse.setBounds(252, 337, 114, 23);
		contentPane.add(lblCourse);
		
		JLabel lblAccountAlreadyCreated = new JLabel("Account already created?");
		lblAccountAlreadyCreated.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAccountAlreadyCreated.setBounds(170, 466, 229, 15);
		contentPane.add(lblAccountAlreadyCreated);
		
	}
	public void SignUpAction() {
		String firstName = first.getText();
		String LastName = last.getText();
		String userEmail = email.getText();
		char[] pa = pass.getPassword();
		String password = new String(pa);
		String combo = (String)ComboBox.getSelectedItem();
		String number = phoneNumber.getText();
		String course = courseText.getText();
		String level = "4";
		
		String fn = "[A-Z]{1}[a-zA-Z]+";
		Pattern f = Pattern.compile(fn);
		Matcher fna = f.matcher(firstName);
		boolean fp = fna.matches();
		
		String ln = "[A-Z]{1}[a-zA-Z]+";
		Pattern l = Pattern.compile(ln);
		Matcher lna = l.matcher(LastName);
		boolean lp = lna.matches();
		
		
		String ema = "[a-z]{1}[a-zA-Z1-9]+[@]gmail[.]com";
		Pattern em = Pattern.compile(ema);
		Matcher emaa = em.matcher(userEmail);
		boolean ma = emaa.matches();
		
		
		String pn = "[a-zA-Z]{1}[a-zA-Z1-9@]+";
		Pattern pan = Pattern.compile(pn);
		Matcher mp = pan.matcher(new String(password));
		boolean mpa = mp.matches();
		
		
		if(!firstName.equals("") && !LastName.equals("") && !userEmail.equals("") && !(new String(password)).equals("") && number.length()<=10) {
			if( fp==true && lp==true && ma==true && mpa==true) {
				System.out.println(firstName);
				System.out.println(LastName);
				System.out.println(userEmail);
				System.out.println(password);
				System.out.println(combo);
				System.out.print(number);
				String url = "jdbc:mysql://localhost:3307/";
		        String baseUsername = "root";
		        String basePassword = "";
		         try {
		             Connection con = DriverManager.getConnection(url, baseUsername, basePassword);
		             Statement stn = con.createStatement();
		             System.out.println("Connection established");
		             String q = "CREATE DATABASE IF NOT EXISTS courses";
		             stn.execute(q); 
		            if(combo.equals("Student")) {
		            	String table = "CREATE TABLE IF NOT EXISTS courses.student(ID INT AUTO_INCREMENT PRIMARY KEY, FirstName varchar(50), LastName varchar(50), Email varchar(120), Password varchar(50), User varchar(50), Phone varchar(120), Course varchar(1000),level varchar(100))";
		            	stn.execute(table);
		            	String insertValues = "INSERT INTO courses.student (FirstName, LastName, Email, Password, User, Phone, course, level) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
		            	PreparedStatement pstmt = con.prepareStatement(insertValues);
		            	pstmt.setString(1, firstName);
		            	pstmt.setString(2, LastName);
		            	pstmt.setString(3, userEmail);
		            	pstmt.setString(4, password);
		            	pstmt.setString(5, combo);
		            	pstmt.setString(6, number);
		            	pstmt.setString(7, course);
		            	pstmt.setString(8,level);
		            	pstmt.executeUpdate();
		                 if(table!=null) {
		                	 System.out.println("Table created");
		                 }
		                 System.out.println("values inserted");
		            } else if(combo.equals("Teacher")) {
		            	String teacherTable = "CREATE TABLE IF NOT EXISTS courses.teacher(ID INT AUTO_INCREMENT PRIMARY KEY, First_Name varchar(100), Last_Name varchar(1000), Email varchar(1000), Password varchar(1200), User varchar(50), Phone varchar(120), Course varchar(1000))";
		            	stn.execute(teacherTable);
		            	String insertValues = "INSERT INTO courses.teacher (First_Name, Last_Name, Email, Password, User, Phone, Course) VALUES (?, ?, ?, ?, ?, ?, ?)";
		            	PreparedStatement p = con.prepareStatement(insertValues);
		            	p.setString(1, firstName);
		            	p.setString(2, LastName);
		            	p.setString(3, userEmail);
		            	p.setString(4, password);
		            	p.setString(5, combo);
		            	p.setString(6, number);
		            	p.setString(7, course);
		            	p.executeUpdate();
		                     if(teacherTable!=null) {
		                    	 System.out.println("Table created");
		                     }
		                     System.out.println("values inserted");
		                     
		            } else if(combo.equals("Admin")) {
		            	String adminTable = "CREATE TABLE IF NOT EXISTS courses.admin(ID INT AUTO_INCREMENT PRIMARY KEY,FirstName varchar(50), LastName varchar(50), Email varchar(120), Password varchar(50), User varchar(50), Phone varchar(20))";
		            	stn.execute(adminTable);

		            	String insertValues = "INSERT INTO courses.admin (FirstName, LastName, Email, Password, User, Phone) VALUES (?, ?, ?, ?, ?, ?)";
		            	PreparedStatement p2 = con.prepareStatement(insertValues);
		            	p2.setString(1, firstName);
		            	p2.setString(2, LastName);
		            	p2.setString(3, userEmail);
		            	p2.setString(4, password);
		            	p2.setString(5, combo);
		            	p2.setString(6, number);
		            	p2.executeUpdate();
		                     if(adminTable!=null) {
		                    	 System.out.println("Table created");
		                     }
		                     System.out.println("values inserted");
		            }
		           
		         } catch (SQLException e) {
		             System.out.println("Connection not established");
		             e.printStackTrace();
		         }
		         
				JOptionPane.showMessageDialog(null, "Sign Up success");
				Login log= new Login();
                log.setVisible(true);
                dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect format of Password or email or phone number");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please fill the box");
		}
		
		 
	}
}



