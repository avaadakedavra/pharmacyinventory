package Login_Sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class formEntry extends JFrame {

	//private ResultSet rs2;
	private JPanel contentPane;
	private JTextField txtVendorID;
	private JTextField txtVendorName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formEntry frame = new formEntry();
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
	public formEntry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Vendor ID");
		lblNewLabel.setBounds(96, 92, 140, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterVendorName = new JLabel("Enter Vendor Name");
		lblEnterVendorName.setBounds(96, 156, 165, 37);
		contentPane.add(lblEnterVendorName);
		
		txtVendorID = new JTextField();
		txtVendorID.setBounds(277, 89, 146, 26);
		contentPane.add(txtVendorID);
		txtVendorID.setColumns(10);
		
		txtVendorName = new JTextField();
		txtVendorName.setBounds(276, 167, 146, 26);
		contentPane.add(txtVendorName);
		txtVendorName.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					DBConnect connect2 = new DBConnect();
					//rs2 = connect2.getData("vendor");
					
					String sql= "insert into vendor values ("+txtVendorID.getText()+","+       "\'"+ txtVendorName.getText() + "\'"       +")";
					
					System.out.println(sql);
					connect2.st.executeUpdate(sql);
					
					//table_1.setBounds(323, 300, 209, 130);
					//contentPane.add(table_1);
					
					
					
					
					}
					catch(Exception ex){
						System.out.println("Error:"+ex);
					}
			}
		});
		btnInsert.setBounds(146, 280, 115, 29);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					DBConnect connect2 = new DBConnect();
					//rs2 = connect2.getData("vendor");
					
					String sql= "delete from vendor where vendor_id="+txtVendorID.getText();
					
					System.out.println(sql);
					connect2.st.executeUpdate(sql);
					
					//table_1.setBounds(323, 300, 209, 130);
					//contentPane.add(table_1);
					
					
					
					
					}
					catch(Exception ex){
						System.out.println("Error:"+ex);
					}
			
			
			
			
			}
		});
		btnDelete.setBounds(376, 280, 115, 29);
		contentPane.add(btnDelete);
	}
}
