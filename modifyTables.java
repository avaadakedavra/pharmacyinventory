package Login_Sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modifyTables extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifyTables frame = new modifyTables();
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
	public modifyTables() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModifyContents = new JLabel("Modify Contents");
		lblModifyContents.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblModifyContents.setBounds(215, 42, 279, 64);
		contentPane.add(lblModifyContents);
		
		JButton btnNewButton = new JButton("Update Vendor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//frame.dispose();
				formEntry ent1=new formEntry();
				ent1.setVisible(true);
			}
		});
		btnNewButton.setBounds(76, 145, 177, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Product");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_1.setBounds(76, 246, 177, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Customer");
		btnNewButton_2.setBounds(76, 357, 177, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update Supplies");
		btnNewButton_3.setBounds(435, 145, 155, 29);
		contentPane.add(btnNewButton_3);
		
		
		JButton btnNewButton_4 = new JButton("Update Order");
		btnNewButton_4.setBounds(435, 246, 155, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Update Purchase");
		btnNewButton_5.setBounds(435, 357, 155, 29);
		contentPane.add(btnNewButton_5);
	}
}
