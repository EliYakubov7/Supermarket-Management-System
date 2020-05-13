package All;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class InvoiceScreen extends JFrame 
{
	private JPanel contentPane;
	private JTextField textFieldCustomerId;
	private JTextField textFieldTotalPrice;
	private JTextField textFieldPay;
	private JTextField textField_Amount;
	private Factory m_Factory = new Factory();
	String[] m_SelectCatgoey = {"Select Category"};
	private Controller m_Controller = m_Factory.creatController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoiceScreen frame = new InvoiceScreen();
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
	
	//private JTextField textField;
	@SuppressWarnings("unchecked")
	public InvoiceScreen() {
		File logoImage = new File("InvoiceScreen.jpg");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setResizable(false);
		setTitle("Invoice Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 1169, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelCudtomerID = new JLabel("Customer ID:");
		labelCudtomerID.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelCudtomerID.setBounds(445, 16, 96, 16);
		contentPane.add(labelCudtomerID);
		
		textFieldCustomerId = new JTextField();
		textFieldCustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCustomerId.setColumns(10);
		textFieldCustomerId.setBounds(573, 12, 114, 22);
		contentPane.add(textFieldCustomerId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 18, 343, 450);
		contentPane.add(scrollPane);
		
		JTextArea text_Receipt = new JTextArea();
		scrollPane.setViewportView(text_Receipt);
		text_Receipt.setBackground(new Color(211, 211, 211));
		text_Receipt.setEditable(false);
		text_Receipt.setText(m_Controller.getFirstLineInInvoice() + m_Controller.getInvoiceSeparatLine());
		
		JLabel lblTotalPrice = new JLabel("Total price:");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalPrice.setBounds(1033, 16, 76, 16);
		contentPane.add(lblTotalPrice);
		
		textFieldTotalPrice = new JTextField();
		textFieldTotalPrice.setEditable(false);
		textFieldTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTotalPrice.setColumns(10);
		textFieldTotalPrice.setBounds(1033, 44, 82, 22);
		contentPane.add(textFieldTotalPrice);
		
		
		textFieldPay = new JTextField();
		textFieldPay.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldPay.setColumns(10);
		textFieldPay.setBounds(1033, 171, 82, 22);
		contentPane.add(textFieldPay);
		
		JComboBox comboBoxProducts = new JComboBox();
		comboBoxProducts.setBounds(445, 84, 96, 20);
		contentPane.add(comboBoxProducts);
		
		@SuppressWarnings("unchecked")
		JComboBox comboBoxCategory = new JComboBox();
		comboBoxCategory.setModel(new DefaultComboBoxModel(m_Controller.getCategoryList()));
		comboBoxCategory.setBounds(445, 46, 96, 20);
		contentPane.add(comboBoxCategory);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSelect.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				comboBoxProducts.setModel(new DefaultComboBoxModel(m_Controller.getProductsToComboBox((String)comboBoxCategory.getSelectedItem())));
			}
		});
		btnSelect.setBounds(571, 46, 116, 23);
		contentPane.add(btnSelect);
				
		textField_Amount = new JTextField();
		textField_Amount.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Amount.setColumns(10);
		textField_Amount.setBounds(445, 122, 96, 22);
		contentPane.add(textField_Amount);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					text_Receipt.setText(text_Receipt.getText() + m_Controller.addProductToInvoice((String)comboBoxProducts.getSelectedItem(), Integer.parseInt(textField_Amount.getText())));
					comboBoxCategory.setSelectedIndex(0);
					comboBoxProducts.setModel(new DefaultComboBoxModel(m_SelectCatgoey));
					textField_Amount.setText("");
					textFieldTotalPrice.setText(m_Controller.getInvoiceTotalPrice());
					
				}
				catch (Exception E)
				{
					JOptionPane.showMessageDialog(null/*new JFrame()*/, E.getMessage());
				}
			}
		});
		btnAdd.setBounds(571, 122, 116, 23);
		contentPane.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxCategory.setSelectedIndex(0);
				comboBoxProducts.setModel(new DefaultComboBoxModel(m_SelectCatgoey));
				textField_Amount.setText("");
				
			}
		});
		btnClear.setBounds(571, 84, 116, 23);
		contentPane.add(btnClear);
		
		JButton btnNewButtonPay = new JButton("Pay");
		btnNewButtonPay.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButtonPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					//(double i_AmountToPay, String i_CustomerId, String i_InvoiveData, double i_Totalprice)
					String finalInvoice = m_Controller.payInvoice(Double.parseDouble(textFieldPay.getText()), textFieldCustomerId.getText(), text_Receipt.getText(),Double.parseDouble(textFieldTotalPrice.getText()) );
					comboBoxCategory.setSelectedIndex(0);
					comboBoxProducts.setModel(new DefaultComboBoxModel(m_SelectCatgoey));
					textField_Amount.setText("");
					text_Receipt.setText(finalInvoice);
				}
				catch (Exception E)
				{
					JOptionPane.showMessageDialog(null/*new JFrame()*/, E.getMessage());
				}
			}
		});
		btnNewButtonPay.setBounds(1033, 214, 89, 23);
		contentPane.add(btnNewButtonPay);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.SALESSCREEN);
				screen.setVisible(true);
			}
		});
		btnBack.setBounds(1033, 446, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnNewInvoice = new JButton("New Invoice");
		btnNewInvoice.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_Receipt.setText("");
				textField_Amount.setText("");
				textFieldCustomerId.setText("");
				textFieldPay.setText("");
				textFieldTotalPrice.setText("");
				comboBoxCategory.setSelectedIndex(0);
				comboBoxProducts.setModel(new DefaultComboBoxModel(m_SelectCatgoey));
				text_Receipt.setText(m_Controller.getFirstLineInInvoice() + m_Controller.getInvoiceSeparatLine());
				
			}
		});
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
		     					try
								{
		     						text_Receipt.print();	
								}
								
								catch (java.awt.print.PrinterException e1)
								{
									System.err.format("No Printer Found", e1.getMessage());
								}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPrint.setBounds(573, 158, 114, 23);
		contentPane.add(btnPrint);
		btnNewInvoice.setBounds(573, 193, 114, 23);
		contentPane.add(btnNewInvoice);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cash");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(1033, 83, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnCredit = new JRadioButton("Credit");
		rdbtnCredit.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnCredit.setBackground(Color.WHITE);
		rdbtnCredit.setBounds(1033, 129, 109, 23);
		contentPane.add(rdbtnCredit);
		
		JLabel lblPicture = new JLabel("");
		File InvoiceScreen = new File("InvoiceScreen.jpg");
		String InvoiceScreenPath = InvoiceScreen.getPath();
		
		JLabel lblComment = new JLabel("Please select category and click on select button to see products");
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComment.setBounds(365, 234, 442, 16);
		contentPane.add(lblComment);
		lblPicture.setIcon(new ImageIcon(InvoiceScreenPath));
		lblPicture.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPicture.setBounds(376, 0, 775, 480);
		contentPane.add(lblPicture);
		
	}
}
