package All;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ProductScreen extends JFrame {

	private JPanel contentPane;
	Factory m_Factory = new Factory();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductScreen frame = new ProductScreen();
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
	public ProductScreen() {
		File logoImage = new File("CONSUMER-PRODUCTS.jpg");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setResizable(false);
		setTitle("Product Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 905, 566);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddUser = new JButton("Add Product");
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.PRODUCTADD);
			setVisible(false);
			screen.setVisible(true);
			
			}
		});
		btnAddUser.setBounds(12, 13, 137, 25);
		contentPane.add(btnAddUser);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.MANAGMENTSCREEN);
			setVisible(false);
			screen.setVisible(true);
			}
		});
		btnCancel.setBounds(739, 480, 137, 25);
		contentPane.add(btnCancel);
		
		JButton btnEditUser = new JButton("Edit Product");
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.PRODUCTEDIT);
				screen.setVisible(true);
			}
		});
		btnEditUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditUser.setBounds(12, 51, 137, 25);
		contentPane.add(btnEditUser);
		
		JLabel lblPicture = new JLabel("");
		File ConsumerProducts = new File("CONSUMER-PRODUCTS.jpg");
		String ConsumerProductsPath = ConsumerProducts.getPath();
		lblPicture.setIcon(new ImageIcon(ConsumerProductsPath));
		lblPicture.setBounds(0, 0, 899, 531);
		contentPane.add(lblPicture);
	}
}
