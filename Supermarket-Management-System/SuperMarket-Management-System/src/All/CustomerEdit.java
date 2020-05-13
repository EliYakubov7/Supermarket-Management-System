package All;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CustomerEdit  extends JFrame  {
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_CustomerID;
	private JTextField textField_Email;
	private JTextField textField_Address;
	private JTextField textField_Telephone;
	private JTextField textField_Gender;
	private Factory m_Factory =new Factory();
	private Controller m_Controller =m_Factory.creatController();


	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerEdit frame = new CustomerEdit();
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
	
	public CustomerEdit() {
		File logoImage = new File("CustomerEdit.jpg");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setResizable(false);
		setTitle("Customer Edit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 1053, 520);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_FirstName = new JLabel("First name:");
		label_FirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_FirstName.setBounds(15, 77, 79, 22);
		contentPane.add(label_FirstName);
		
		textField_FirstName = new JTextField();
		textField_FirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_FirstName.setColumns(10);
		textField_FirstName.setBounds(120, 77, 139, 22);
		contentPane.add(textField_FirstName);
		
		JLabel label_LastName = new JLabel("Last name:");
		label_LastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_LastName.setBounds(15, 112, 79, 22);
		contentPane.add(label_LastName);
		
		textField_LastName = new JTextField();
		textField_LastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(120, 112, 139, 22);
		contentPane.add(textField_LastName);
		
		textField_CustomerID = new JTextField();
		textField_CustomerID.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_CustomerID.setColumns(10);
		textField_CustomerID.setBounds(120, 43, 139, 22);
		contentPane.add(textField_CustomerID);
		
		JLabel label_CustomerID = new JLabel("Customer ID:");
		label_CustomerID.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_CustomerID.setBounds(15, 43, 93, 16);
		contentPane.add(label_CustomerID);
		
		JLabel label_Email = new JLabel("Email:");
		label_Email.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_Email.setBounds(15, 146, 79, 22);
		contentPane.add(label_Email);
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Email.setColumns(10);
		textField_Email.setBounds(120, 145, 139, 22);
		contentPane.add(textField_Email);
		
		textField_Address = new JTextField();
		textField_Address.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Address.setColumns(10);
		textField_Address.setBounds(120, 180, 139, 22);
		contentPane.add(textField_Address);
		
		JLabel label_Address = new JLabel("Address:");
		label_Address.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_Address.setBounds(15, 181, 79, 22);
		contentPane.add(label_Address);
		
		JLabel label_Telephone = new JLabel("Telephone:");
		label_Telephone.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_Telephone.setBounds(15, 215, 79, 22);
		contentPane.add(label_Telephone);
		
		textField_Telephone = new JTextField();
		textField_Telephone.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Telephone.setColumns(10);
		textField_Telephone.setBounds(120, 215, 139, 22);
		contentPane.add(textField_Telephone);
		
		textField_Gender = new JTextField();
		textField_Gender.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Gender.setColumns(10);
		textField_Gender.setBounds(120, 250, 139, 22);
		contentPane.add(textField_Gender);
		
		JButton button = new JButton("Back");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Frame screen= m_Factory.creatNewScreen(Factory.Screens.CUSTOMERSCREEN);
				screen.setVisible(true);
			}
		});
		button.setBounds(827, 447, 97, 25);
		contentPane.add(button);
		

	
		JLabel label = new JLabel("Please fill ID number and click Search");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(15, 8, 240, 22);
		contentPane.add(label);

		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				m_Controller.deleteCustomrt(textField_CustomerID.getText());	
				textField_CustomerID.setText("");
				textField_FirstName.setText("");
				textField_LastName.setText("");
				textField_Email.setText("");
				textField_Telephone.setText("");
				textField_Address.setText("");
				textField_Gender.setText("");
			}
		});
		btnDelete.setBounds(270, 145, 97, 25);
		contentPane.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				try
				{
					Customer searchedCustomer = m_Controller.searchCustomer(textField_CustomerID.getText());
					textField_FirstName.setText(searchedCustomer.getCustomerFirstName());
					textField_LastName.setText(searchedCustomer.getCustomerLastName());
					textField_Email.setText(searchedCustomer.getCustomerEmail());
					textField_Telephone.setText(searchedCustomer.getCustomerPhone());
					textField_Address.setText(searchedCustomer.getCustomerAddress());
					textField_Gender.setText(searchedCustomer.getCustomerGender());
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "The Customer is not in the data base");
				}

			}
		});
		btnSearch.setBounds(270, 78, 97, 25);
		contentPane.add(btnSearch);
		

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_CustomerID.setText("");
				textField_FirstName.setText("");
				textField_LastName.setText("");
				textField_Email.setText("");
				textField_Telephone.setText("");
				textField_Address.setText("");
				textField_Gender.setText("");
			}
		});
		btnClear.setBounds(270, 181, 97, 25);
		contentPane.add(btnClear);
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				Customer newCustomer = m_Factory.creatCustomer(textField_Gender.getText(), textField_Telephone.getText(), textField_Email.getText(),
						textField_Address.getText(), textField_FirstName.getText(), textField_LastName.getText(), 
						textField_CustomerID.getText());
				m_Controller.updateCustomer(newCustomer);
				
				textField_CustomerID.setText("");
				textField_FirstName.setText("");
				textField_LastName.setText("");
				textField_Email.setText("");
				textField_Telephone.setText("");
				textField_Address.setText("");
				textField_Gender.setText("");
							
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error please check all filds date must be in fotmat: DD-MM-YYYY");
				}
			}
		});
		btnUpdate.setBounds(270, 112, 97, 25);
		contentPane.add(btnUpdate);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGender.setBounds(15, 250, 56, 16);
		contentPane.add(lblGender);
		
		JLabel lblPicture = new JLabel("");
		File CustomerEdit = new File("CustomerEdit.jpg");
		String CustomerEditPath = CustomerEdit.getPath();
		lblPicture.setIcon(new ImageIcon(CustomerEditPath));
		lblPicture.setBounds(0, 0, 1047, 485);
		contentPane.add(lblPicture);
		
	}

}
