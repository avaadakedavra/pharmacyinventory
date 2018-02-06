	package Login_Sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.*;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.JTable;


public class Owner extends JFrame {

	private ResultSet rs3;
	private ResultSet rs2;
	private JPanel contentPane;
	private JTable table_1;
	private JTable table_2;
	JFrame frame2;
	JFrame frame1; 
	String Cols[]= {"Product ID","Product Name","Price","Dosage","Expiry Date","Expiry Date","Quantity"};
	String Cols2[]= {"Vendor ID","Vendor Name"};		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Owner frame = new Owner();
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
	public Owner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShowRecords = new JButton("Show product records");
		btnShowRecords.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnShowRecords.setBackground(Color.PINK);
		btnShowRecords.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
						
				frame1 = new JFrame("Product Records");

				//frame1 = frame;
				
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.getContentPane().setLayout(new BorderLayout());
				frame1.setVisible(true);
						
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(Cols);
				table_1 = new JTable();
				table_1.setModel(model);
				table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table_1.setFillsViewportHeight(true);
				//JScrollPane scroll= new JScrollPane(table_1);
			
				try {
				DBConnect connect = new DBConnect();
				rs2 = connect.getData("product");
				
				
				//table_1.setBounds(323, 300, 209, 130);
				//contentPane.add(table_1);
				
				
				
				while(rs2.next()) {
					
					String id = rs2.getString("product_id");	
					String prodname = rs2.getString("productname");
					String price = rs2.getString("price");
					String dosage = rs2.getString("dosage");
					String expdt = rs2.getString("expdt");
					String qty = rs2.getString("quantity");
					String descript = rs2.getString("description");
					
					//System.out.println("Name: "+name+"   "+"ID: "+id);
					
					model.addRow(new Object[] {id, prodname, price, dosage, expdt, qty, descript});
				}
				
				}
				catch(Exception ex){
					System.out.println("Error:"+ex);
				}
				
				contentPane.add(table_1);
				
				frame1.getContentPane().add(table_1);
				frame1.setVisible(true);
				frame1.setSize(400,300);	
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.setBounds(100, 100, 940, 521);
				frame1.setFont(new Font("Tahoma", Font.PLAIN, 30));
				frame1.setBackground(Color.PINK);
				
				
			}
			
		});
		btnShowRecords.setForeground(Color.RED);
		btnShowRecords.setIcon(new ImageIcon("C:\\Users\\Joel Braganza\\Downloads\\pharmaokay.png"));
		btnShowRecords.setBounds(208, 55, 483, 114);
		contentPane.add(btnShowRecords);
		
		JButton btnNewButton = new JButton("Retailer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Retailer");
				
			}
		});
		btnNewButton.setBounds(146, 237, 148, 62);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Orders");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(null, "Orders");
				
				
			}
		});
		btnNewButton_1.setBounds(563, 237, 173, 62);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Customer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(null, "Customer");
				
			}
		});
		btnNewButton_2.setBounds(146, 344, 148, 53);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Vendor");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//JOptionPane.showMessageDialog(null, "Vendor");
				
				
				frame2 = new JFrame("Vendor Records");
			
			
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.getContentPane().setLayout(new BorderLayout());
				frame2.setVisible(true);
				
				DefaultTableModel model1 = new DefaultTableModel();
				model1.setColumnIdentifiers(Cols);
				table_2 = new JTable();
				table_2.setModel(model1);
				table_2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table_2.setFillsViewportHeight(true);
				
				try {
					
					DBConnect connect2 = new DBConnect();
					rs3 = connect2.getData("vendor");
					
					
					//table_1.setBounds(323, 300, 209, 130);
					//contentPane.add(table_1);
					
					
					
							while(rs3.next()) {
								
								String id = rs3.getString("vendor_id");	
								String vendname = rs3.getString("vendorname");
														
								//System.out.println("Name: "+name+"   "+"ID: "+id);
								
								model1.addRow(new Object[] {id, vendname});
							}
					
					}
					catch(Exception ex){
						System.out.println("Error:"+ex);
					}
				
				contentPane.add(table_2);
				
				frame2.getContentPane().add(table_2);
				frame2.setVisible(true);
				frame2.setSize(400,300);	
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setBounds(100, 100, 940, 521);
				frame2.setFont(new Font("Tahoma", Font.PLAIN, 30));
				frame2.setBackground(Color.PINK);
			
			
			}
		});
		btnNewButton_3.setBounds(563, 344, 173, 53);
		contentPane.add(btnNewButton_3);
		
		JButton btnModifyContents = new JButton("Modify Contents");
		btnModifyContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//frame1.dispose();
				//frame2.dispose();
				
				modifyTables mod1=new modifyTables();
				mod1.setVisible(true);
				
				//JOptionPane.showMessageDialog(null, "Modify Contents");
			}
		});
		btnModifyContents.setBounds(350, 409, 173, 29);
		contentPane.add(btnModifyContents);
		
		
	}
}
