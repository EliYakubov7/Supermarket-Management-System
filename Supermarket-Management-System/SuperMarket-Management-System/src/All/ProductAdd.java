package All;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class ProductAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID;
	private JTextField textField_Quantity;
	private JTextField textField_Price;
	private JTextField textField_Supplier;
	private JTextField textField_ProductName;
	private JTextField textField_ReceivedDate;
	private JTextField textField_ExpiredDate;
	private JTextField textField_CostPrice;
	private Factory m_Factory = new Factory();
	private Controller m_Controller = m_Factory.creatController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ProductAdd frame = new ProductAdd();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ProductAdd() {
		setResizable(false);
		File logoImage = new File("ProductAdd.jpg");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Details Of Products");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 833, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductId.setBounds(12, 13, 97, 22);
		contentPane.add(lblProductId);
		
		
		JLabel lblFirstName = new JLabel("Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(12, 83, 79, 22);
		contentPane.add(lblFirstName);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setBounds(12, 192, 79, 22);
		contentPane.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Sell Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(12, 227, 79, 22);
		contentPane.add(lblPrice);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeight.setBounds(12, 153, 56, 23);
		contentPane.add(lblWeight);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSupplier.setBounds(12, 118, 79, 16);
		contentPane.add(lblSupplier);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategory.setBounds(12, 54, 79, 16);
		contentPane.add(lblCategory);
			
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.PRODUCTSCREEN);
				screen.setVisible(true);
				
			}
			
		});
		btnBack.setBounds(695, 488, 97, 25);
		contentPane.add(btnBack);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ID.setColumns(10);
		textField_ID.setBounds(134, 13, 116, 22);
		contentPane.add(textField_ID);
		
		textField_Quantity = new JTextField();
		textField_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Quantity.setColumns(10);
		textField_Quantity.setBounds(134, 192, 116, 22);
		contentPane.add(textField_Quantity);
		
		textField_Price = new JTextField();
		textField_Price.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Price.setColumns(10);
		textField_Price.setBounds(134, 227, 116, 22);
		contentPane.add(textField_Price);
		
		textField_Supplier = new JTextField();
		textField_Supplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Supplier.setBounds(134, 118, 116, 22);
		contentPane.add(textField_Supplier);
		textField_Supplier.setColumns(10);
		
		
		JComboBox comboBox_weight = new JComboBox();
		comboBox_weight.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_weight.setModel(new DefaultComboBoxModel(new String[] {"Select", "Regular", "Per 100gr", "Per 1kg"}));
		comboBox_weight.setBounds(134, 153, 116, 28);
		contentPane.add(comboBox_weight);
		
		JComboBox comboBox_category = new JComboBox();
		comboBox_category.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_category.setModel(new DefaultComboBoxModel(new String[] {"Select","Dairy", "Meat","Vegetables","Fruits","Canning","Sauce","Snacks","Bakery","Cleaning","Drinks","Spice","Grain","Leavs","Alcohol","Hot Drinks"}));
		comboBox_category.setBounds(134, 48, 116, 25);
		contentPane.add(comboBox_category);
		
		JLabel lblReceivedDate = new JLabel("Received Date :");
		lblReceivedDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReceivedDate.setBounds(12, 295, 116, 16);
		contentPane.add(lblReceivedDate);
		
		JLabel lblExpiredDate = new JLabel("Expired Date:");
		lblExpiredDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExpiredDate.setBounds(12, 330, 116, 16);
		contentPane.add(lblExpiredDate);
		
		
		JLabel lblPicture = new JLabel("");
		lblPicture.setBackground(Color.WHITE);
		File ProductAdd = new File("ProductAdd.jpg");
		String ProductAddPath = ProductAdd.getPath();
		lblPicture.setIcon(new ImageIcon(ProductAddPath));
		lblPicture.setBounds(267, 13, 525, 462);
		contentPane.add(lblPicture);
		
		
		textField_CostPrice = new JTextField();
		textField_CostPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_CostPrice.setColumns(10);
		textField_CostPrice.setBounds(134, 262, 116, 22);
		contentPane.add(textField_CostPrice);
		
		JLabel lblCostPrice = new JLabel("Cost Price:");
		lblCostPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCostPrice.setBounds(12, 262, 79, 22);
		contentPane.add(lblCostPrice);

		
		textField_ProductName = new JTextField();
		textField_ProductName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ProductName.setColumns(10);
		textField_ProductName.setBounds(134, 83, 116, 22);
		contentPane.add(textField_ProductName);
		
		textField_ReceivedDate = new JTextField();
		textField_ReceivedDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ReceivedDate.setColumns(10);
		textField_ReceivedDate.setBounds(134, 295, 116, 22);
		contentPane.add(textField_ReceivedDate);
		
		textField_ExpiredDate = new JTextField();
		textField_ExpiredDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ExpiredDate.setColumns(10);
		textField_ExpiredDate.setBounds(134, 330, 116, 22);
		contentPane.add(textField_ExpiredDate);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Product newProduct = m_Factory.creatProduct(textField_ProductName.getText(), textField_ID.getText(), textField_Quantity.getText(),
							textField_Price.getText(), (String) comboBox_weight.getSelectedItem(), textField_Supplier.getText(),
							(String) comboBox_category.getSelectedItem(), textField_ReceivedDate.getText(),
							textField_ExpiredDate.getText(), textField_CostPrice.getText());
					m_Controller.addProduct(newProduct);	
					
					textField_ProductName.setText("");
					textField_ID.setText("");
					textField_Quantity.setText("");
					textField_Price.setText("");
					comboBox_weight.setSelectedIndex(0);
					textField_Supplier.setText("");
					comboBox_category.setSelectedIndex(0);
					textField_ReceivedDate.setText("");
					textField_ExpiredDate.setText("");
					textField_CostPrice.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error please check all filds date must be in fotmat: DD-MM-YYYY");
				}
				
			}});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(12, 384, 97, 25);
		contentPane.add(btnAdd);		
	}		
	
}


