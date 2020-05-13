package All;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;

public class ProductEdit extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_ProductID;
	private JTextField textField_Name;
	private JTextField textField_Supplier;
	private JTextField textField_Quantity;
	private JTextField textField_Price;
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
					ProductEdit frame = new ProductEdit();
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
	
	public ProductEdit() {
		File logoImage = new File("ProductEdit.png");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Edit Product");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 868, 560);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_ProductID = new JLabel("Product ID:");
		label_ProductID.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_ProductID.setBounds(18, 48, 97, 22);
		contentPane.add(label_ProductID);
		
		JLabel label_Category = new JLabel("Category:");
		label_Category.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Category.setBounds(18, 89, 79, 16);
		contentPane.add(label_Category);
		
		JLabel label_Name = new JLabel("Name:");
		label_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Name.setBounds(18, 118, 79, 22);
		contentPane.add(label_Name);
		
		JLabel label_Supplier = new JLabel("Supplier:");
		label_Supplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Supplier.setBounds(18, 156, 79, 16);
		contentPane.add(label_Supplier);
		
		JLabel label_Weight = new JLabel("Weight:");
		label_Weight.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Weight.setBounds(18, 189, 56, 23);
		contentPane.add(label_Weight);
		
		JLabel label_Quantity = new JLabel("Quantity:");
		label_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Quantity.setBounds(18, 223, 79, 22);
		contentPane.add(label_Quantity);
		
		JLabel lblSellPrice = new JLabel("Sell Price:");
		lblSellPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSellPrice.setBounds(18, 257, 79, 22);
		contentPane.add(lblSellPrice);
		
		JLabel lblReceivedDate = new JLabel("Received Date:");
		lblReceivedDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReceivedDate.setBounds(18, 325, 116, 16);
		contentPane.add(lblReceivedDate);
		
		JLabel label_ExpiredDate = new JLabel("Expired Date:");
		label_ExpiredDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_ExpiredDate.setBounds(18, 359, 116, 16);
		contentPane.add(label_ExpiredDate);
		
		textField_ProductID = new JTextField();
		textField_ProductID.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ProductID.setColumns(10);
		textField_ProductID.setBounds(132, 48, 116, 22);
		contentPane.add(textField_ProductID);
		
		JComboBox comboBox_Category = new JComboBox();
		comboBox_Category.setModel(new DefaultComboBoxModel(new String[] {"Select","Dairy", "Meat","Vegetables","Fruits","Canning","Sauce","Snacks","Bakery","Cleaning","Drinks","Spice","Grain","Leavs","Alcohol","Hot Drinks"}));
		comboBox_Category.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_Category.setBounds(132, 83, 116, 25);
		contentPane.add(comboBox_Category);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Name.setColumns(10);
		textField_Name.setBounds(132, 121, 116, 22);
		contentPane.add(textField_Name);
		
		textField_Supplier = new JTextField();
		textField_Supplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Supplier.setColumns(10);
		textField_Supplier.setBounds(132, 153, 116, 22);
		contentPane.add(textField_Supplier);
		
		JComboBox comboBox_Weight = new JComboBox();
		comboBox_Weight.setModel(new DefaultComboBoxModel(new String[] {"Select", "Regular", "Per 100gr", "Per 1kg"}));
		comboBox_Weight.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_Weight.setBounds(132, 189, 116, 25);
		contentPane.add(comboBox_Weight);
		
		textField_Quantity = new JTextField();
		textField_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Quantity.setColumns(10);
		textField_Quantity.setBounds(132, 223, 116, 22);
		contentPane.add(textField_Quantity);
		
		textField_Price = new JTextField();
		textField_Price.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Price.setColumns(10);
		textField_Price.setBounds(132, 257, 116, 22);
		contentPane.add(textField_Price);
		
		textField_ReceivedDate = new JTextField();
		textField_ReceivedDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ReceivedDate.setColumns(10);
		textField_ReceivedDate.setBounds(132, 325, 116, 22);
		contentPane.add(textField_ReceivedDate);
		
		textField_ExpiredDate = new JTextField();
		textField_ExpiredDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ExpiredDate.setColumns(10);
		textField_ExpiredDate.setBounds(132, 359, 116, 22);
		contentPane.add(textField_ExpiredDate);

		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.PRODUCTSCREEN);
				screen.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(753, 487, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_ProductID.setText("");
				textField_Name.setText("");
				textField_Supplier.setText("");
				textField_Quantity.setText("");
				textField_Price.setText("");
				textField_ReceivedDate.setText("");
				textField_ExpiredDate.setText("");
				comboBox_Weight.setSelectedIndex(0);
				comboBox_Category.setSelectedIndex(0);
				textField_CostPrice.setText("");				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(275, 212, 97, 25);
		contentPane.add(btnClear);
		
		textField_CostPrice = new JTextField();
		textField_CostPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_CostPrice.setColumns(10);
		textField_CostPrice.setBounds(132, 291, 116, 22);
		contentPane.add(textField_CostPrice);
		
		JLabel lblCostPrice = new JLabel("Cost Price:");
		lblCostPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCostPrice.setBounds(18, 291, 79, 22);
		contentPane.add(lblCostPrice);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Product newProduct = m_Factory.creatProduct(textField_Name.getText(), textField_ProductID.getText(), textField_Quantity.getText(),
							textField_Price.getText(), (String) comboBox_Weight.getSelectedItem(), textField_Supplier.getText(),
							(String) comboBox_Category.getSelectedItem(), textField_ReceivedDate.getText(),
							textField_ExpiredDate.getText(), textField_CostPrice.getText());
					
					m_Controller.updateProduct(newProduct);
					
					textField_ProductID.setText("");
					textField_Name.setText("");
					textField_Supplier.setText("");
					textField_Quantity.setText("");
					textField_Price.setText("");
					textField_ReceivedDate.setText("");
					textField_ExpiredDate.setText("");
					comboBox_Weight.setSelectedIndex(0);
					comboBox_Category.setSelectedIndex(0);
					textField_CostPrice.setText("");
					
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error please check all filds date must be in fotmat: DD-MM-YYYY");
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(275, 272, 97, 25);
		contentPane.add(btnUpdate);
		
		JLabel lblPleaseFillProduct = new JLabel("Please fill Product ID number and click Search");
		lblPleaseFillProduct.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPleaseFillProduct.setBounds(23, 11, 299, 22);
		contentPane.add(lblPleaseFillProduct);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				try
				{
					Product searchedProduct =  m_Controller.searchProduct(textField_ProductID.getText());
					textField_Name.setText(searchedProduct.getProductName());
					textField_Supplier.setText(searchedProduct.getProductSupplier());
					textField_Quantity.setText(searchedProduct.getProductQuantity());
					textField_Price.setText(searchedProduct.getProductPrice());
					textField_ReceivedDate.setText(searchedProduct.getProductReceiveDate());
					textField_ExpiredDate.setText(searchedProduct.getProductExpireDate());
					comboBox_Weight.setSelectedItem(searchedProduct.getProductWeight());
					comboBox_Category.setSelectedItem(searchedProduct.getProductCategory());
					textField_CostPrice.setText(searchedProduct.getProductCostPrice());	
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "The Product is not in the data base");
				}

		}});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(275, 152, 97, 25);
		contentPane.add(btnSearch);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m_Controller.deleteProduct(textField_ProductID.getText());
				textField_ProductID.setText("");
				textField_Name.setText("");
				textField_Supplier.setText("");
				textField_Quantity.setText("");
				textField_Price.setText("");
				textField_ReceivedDate.setText("");
				textField_ExpiredDate.setText("");
				comboBox_Weight.setSelectedIndex(0);
				comboBox_Category.setSelectedIndex(0);
				textField_CostPrice.setText("");
		}});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(275, 332, 97, 25);
		contentPane.add(btnDelete);
		
		JLabel lblPicture = new JLabel("");
		File ProductEdit = new File("ProductEdit.png");
		String ProductEditPath = ProductEdit.getPath();
		lblPicture.setIcon(new ImageIcon(ProductEditPath));
		lblPicture.setBounds(334, 0, 862, 525);
		contentPane.add(lblPicture);	
	}
	
}
