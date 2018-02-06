package Login_Sys;

import java.awt.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
	
public class Login_s {

	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//DBConnect connect = new DBConnect();
		//connect.getData();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_s window = new Login_s();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_s() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 716, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login System");
		lblLogin.setBounds(249, 36, 139, 20);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUname = new JLabel("Username");
		lblUname.setBounds(249, 110, 111, 20);
		frame.getContentPane().add(lblUname);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(249, 173, 69, 20);
		frame.getContentPane().add(lblPassword);
		
		JTextArea txtUsername = new JTextArea();
		txtUsername.setBounds(344, 110, 159, 26);
		frame.getContentPane().add(txtUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(292, 167, -57, 26);
		frame.getContentPane().add(passwordField);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(344, 167, 159, 26);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Log-in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				 	
				if((password.contains("Joel") || password.contains("Aditya") || password.contains("Sanika") || password.contains("Pooja")) && username.contains("Pharmacy")){
						
					txtPassword.setText(null);
					txtUsername.setText(null);
					frame.dispose();
					Owner showall = new Owner();
					showall.setVisible(true);
					
					
					
					//JOptionPane.showMessageDialog(null, "Succesful Log-in","Welcome",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Log-in","Log-in Error",JOptionPane.ERROR_MESSAGE);
				}
					
			}
		});
		btnLogin.setBounds(189, 275, 115, 29);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPassword.setText(null);
				txtUsername.setText(null); 
			}
		});
		btnReset.setBounds(388, 275, 115, 29);
		frame.getContentPane().add(btnReset);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 245, 621, 14);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(54, 69, 557, 14);
		frame.getContentPane().add(separator_1);
		
		JLabel label = new JLabel("");
		//Image img = new ImageIcon(this.getClass().getResource("/pharmacy.png")).getImage();
		//Image fpageicon = new ImageIcon(this.getClass().getResource("/pharmacy.png")).getImage();
		
		label.setIcon(new ImageIcon("C:\\Users\\Joel Braganza\\Downloads\\pharmacy.png"));
		label.setBounds(64, 88, 178, 129);
		frame.getContentPane().add(label);
	}
}
