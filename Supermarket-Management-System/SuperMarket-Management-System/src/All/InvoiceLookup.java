package All;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.LocalDateTime;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class InvoiceLookup extends JFrame {

	JPanel contentPane;
	private JTextField textFieldCustomerId;
	private JTextField textField_InvoiveNumber;
	private Factory m_Factory = new Factory();
	private Controller m_Controller = m_Factory.creatController();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoiceLookup frame = new InvoiceLookup();
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
	
	public InvoiceLookup()
	{
		File logoImage = new File("InvoiceLookup.jpg");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setResizable(false);
		setTitle("Invoice Lookup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 833, 524);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldCustomerId = new JTextField();
		textFieldCustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCustomerId.setColumns(10);
		textFieldCustomerId.setBounds(571, 25, 114, 22);
		contentPane.add(textFieldCustomerId);
		
		JLabel labelCustpmerId = new JLabel("Customer ID:");
		labelCustpmerId.setFont(new Font("Dialog", Font.BOLD, 12));
		labelCustpmerId.setBounds(441, 29, 76, 16);
		contentPane.add(labelCustpmerId);
		
		textField_InvoiveNumber = new JTextField();
		textField_InvoiveNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_InvoiveNumber.setColumns(10);
		textField_InvoiveNumber.setBounds(571, 65, 114, 22);
		contentPane.add(textField_InvoiveNumber);
		
		JLabel lblInvoiceNumber = new JLabel("Invoice number:");
		lblInvoiceNumber.setFont(new Font("Dialog", Font.BOLD, 12));
		lblInvoiceNumber.setBounds(441, 69, 105, 16);
		contentPane.add(lblInvoiceNumber);
	
		
		JComboBox comboBoxInvoiceId = new JComboBox();
		comboBoxInvoiceId.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxInvoiceId.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		comboBoxInvoiceId.setBounds(571, 108, 114, 20);
		contentPane.add(comboBoxInvoiceId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 19, 343, 450);
		contentPane.add(scrollPane);
				
		JTextArea text_Receipt = new JTextArea();
		scrollPane.setViewportView(text_Receipt);
		text_Receipt.setBackground(new Color(211, 211, 211));
		text_Receipt.setEditable(false);
		JButton btnSearchCustomerId = new JButton("Search");
		btnSearchCustomerId.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearchCustomerId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxInvoiceId.setModel(new DefaultComboBoxModel(m_Controller.getInvoiceNumbers(textFieldCustomerId.getText())));
			}
		});
		btnSearchCustomerId.setBounds(710, 26, 89, 23);
		contentPane.add(btnSearchCustomerId);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_Receipt.setText(m_Controller.getInvoice((String)comboBoxInvoiceId.getSelectedItem()));
			}
		});
		btnDisplay.setBounds(710, 107, 89, 23);
		contentPane.add(btnDisplay);
		
		JButton buttonSearchInvoiceNumber = new JButton("Search");
		buttonSearchInvoiceNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonSearchInvoiceNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_Receipt.setText(m_Controller.getInvoice(textField_InvoiveNumber.getText()));	
			}
		});
		buttonSearchInvoiceNumber.setBounds(710, 66, 89, 23);
		contentPane.add(buttonSearchInvoiceNumber);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.SALESSCREEN);
				screen.setVisible(true);
			}
		});
		btnBack.setBounds(710, 446, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_Receipt.setText("");
				textFieldCustomerId.setText("");
				textField_InvoiveNumber.setText("");
				comboBoxInvoiceId.setModel(new DefaultComboBoxModel(new String[] {"Select"}));			}
		});
		btnClear.setBounds(710, 143, 89, 23);
		contentPane.add(btnClear);
		
		JLabel lblPicture = new JLabel("");
		File InvoiceLookup = new File("InvoiceLookup.jpg");
		String InvoiceLookupPath = InvoiceLookup.getPath();
		
		JButton btnPrintButton = new JButton("Print");
		btnPrintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
     					try
						{
     						text_Receipt.print();	
						}
						
						catch (java.awt.print.PrinterException e)
						{
							System.err.format("No Printer Found", e.getMessage());
						}
					}
				});			
		
		btnPrintButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPrintButton.setBounds(710, 180, 89, 23);
		contentPane.add(btnPrintButton);
		lblPicture.setIcon(new ImageIcon(InvoiceLookupPath));
		lblPicture.setBounds(354, 141, 371, 270);
		contentPane.add(lblPicture);
	}
}

