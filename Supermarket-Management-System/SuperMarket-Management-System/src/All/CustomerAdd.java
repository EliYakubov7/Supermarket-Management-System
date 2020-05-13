package All;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.ImageIcon;
@SuppressWarnings("serial")
public class CustomerAdd extends JFrame {


	private JPanel contentPane;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_CustomerId;
	private JTextField textField_Email;
	private JTextField textField_Address;
	private JTextField textField_Telephone;
	private Factory m_Factory = new Factory();
	private Controller m_Controller =m_Factory.creatController();



	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerAdd frame = new CustomerAdd();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CustomerAdd() {
		File logoImage = new File("CustomerAdd.jpg");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setResizable(false);
		setTitle("Details Of Customers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 763, 636);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblFirstName.setBounds(12, 13, 79, 22);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblLastName.setBounds(12, 48, 79, 22);
		contentPane.add(lblLastName);
		
		JLabel lblId = new JLabel("Customer ID:");
		lblId.setFont(new Font("Dialog", Font.BOLD, 12));
		lblId.setBounds(12, 91, 76, 16);
		contentPane.add(lblId);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEmail.setBounds(12, 120, 79, 22);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAddress.setBounds(12, 155, 79, 22);
		contentPane.add(lblAddress);
		
		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTelephone.setBounds(12, 190, 79, 22);
		contentPane.add(lblTelephone);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Dialog", Font.BOLD, 12));
		lblGender.setBounds(12, 228, 56, 16);
		contentPane.add(lblGender);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Frame screen= m_Factory.creatNewScreen(Factory.Screens.CUSTOMERSCREEN);
				screen.setVisible(true);
				
			}
			
		});
		
		btnBack.setBounds(648, 561, 97, 25);
		contentPane.add(btnBack);
		
		textField_FirstName = new JTextField();
		textField_FirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_FirstName.setBounds(103, 13, 128, 22);
		contentPane.add(textField_FirstName);
		textField_FirstName.setColumns(10);
		
		textField_LastName = new JTextField();
		textField_LastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(103, 48, 128, 22);
		contentPane.add(textField_LastName);
		
		textField_CustomerId = new JTextField();
		textField_CustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_CustomerId.setColumns(10);
		textField_CustomerId.setBounds(103, 86, 128, 22);
		contentPane.add(textField_CustomerId);
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Email.setColumns(10);
		textField_Email.setBounds(103, 118, 128, 22);
		contentPane.add(textField_Email);
		
		textField_Address = new JTextField();
		textField_Address.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Address.setColumns(10);
		textField_Address.setBounds(103, 155, 128, 22);
		contentPane.add(textField_Address);
		
		textField_Telephone = new JTextField();
		textField_Telephone.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Telephone.setBounds(103, 188, 128, 22);
		contentPane.add(textField_Telephone);
		textField_Telephone.setColumns(10);
		
		JList list = new JList();
		list.setBounds(326, 190, -9, -56);
		contentPane.add(list);
		
		JComboBox comboBox_Gender = new JComboBox();
		comboBox_Gender.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_Gender.setModel(new DefaultComboBoxModel(new String[] {"Select", "Male", "Female", "Non-binary"}));
		comboBox_Gender.setBounds(103, 225, 128, 22);
		contentPane.add(comboBox_Gender);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				Customer newCustomer = m_Factory.creatCustomer((String) comboBox_Gender.getSelectedItem(), textField_Telephone.getText(), textField_Email.getText(),
						textField_Address.getText(), textField_FirstName.getText(), textField_LastName.getText(), 
						textField_CustomerId.getText());
				m_Controller.addCustomer(newCustomer);
				
				textField_CustomerId.setText("");
				textField_FirstName.setText("");
				textField_LastName.setText("");
				textField_Email.setText("");
				textField_Telephone.setText("");
				textField_Address.setText("");
				comboBox_Gender.setSelectedIndex(0);
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error please check all filds date must be in fotmat: DD-MM-YYYY");
				}
			}
		});
		btnAdd.setBounds(12, 273, 97, 25);
		contentPane.add(btnAdd);
		
		JLabel lblPicture = new JLabel("");
		File CustomerAdd = new File("CustomerAdd.jpg");
		String CustomerAddPath = CustomerAdd.getPath();
		lblPicture.setIcon(new ImageIcon(CustomerAddPath));
		lblPicture.setBounds(231, 27, 526, 521);
		contentPane.add(lblPicture);
	
	}

}
