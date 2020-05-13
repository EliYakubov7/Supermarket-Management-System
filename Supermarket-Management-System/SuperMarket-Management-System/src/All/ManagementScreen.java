package All;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

@SuppressWarnings({ "serial", "unused" })
public class ManagementScreen extends JFrame {

	private JPanel contentPane;
	private Factory m_Factory = new Factory();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementScreen frame = new ManagementScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManagementScreen() {
		File ManagementScreenImage = new File("ManagementScreenImage.jpg");
		String ManagementScreenPath = ManagementScreenImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManagementScreenPath));
		setResizable(false);
		setFont(new Font("Serif", Font.BOLD, 14));
		setTitle("Management Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 458, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Users");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			UserScreen Userscreen = new UserScreen();
			Userscreen.setVisible(true);
			}			
		});
		
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 16));
		btnNewButton.setBounds(98, 85, 111, 31);
		contentPane.add(btnNewButton);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			ProductScreen screen = new ProductScreen();
			screen.setVisible(true);
			}
		});
		
		btnProducts.setFont(new Font("Serif", Font.BOLD, 16));
		btnProducts.setBounds(98, 144, 111, 31);
		contentPane.add(btnProducts);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			InventoryScreen screen = new InventoryScreen();
			screen.setVisible(true);
			}
		});
		
		btnInventory.setFont(new Font("Serif", Font.BOLD, 16));
		btnInventory.setBounds(238, 144, 111, 31);
		contentPane.add(btnInventory);
		
		JButton btnAccounting = new JButton("Accounting");
		btnAccounting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			AccountingScreen screen = new AccountingScreen();
			screen.setVisible(true);
			}
		});
		
		btnAccounting.setFont(new Font("Serif", Font.BOLD, 16));
		btnAccounting.setBounds(168, 199, 111, 31);
		contentPane.add(btnAccounting);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			CustomerScreen screen = new CustomerScreen();
			screen.setVisible(true);
			}
		});
		
		btnCustomers.setFont(new Font("Serif", Font.BOLD, 16));
		btnCustomers.setBounds(238, 85, 111, 31);
		contentPane.add(btnCustomers);
		
		JButton button_6 = new JButton("Back");
		button_6.setFont(new Font("Serif", Font.BOLD, 16));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.MAINMENU);
			screen.setVisible(true);
			}
		});
		
		button_6.setBounds(168, 256, 111, 25);
		contentPane.add(button_6);
		
		JLabel lblPicture = new JLabel("");
		File logoImage = new File("rsz_28347664145_cefc72c915_b.jpg");
		String imagePath = logoImage.getPath();
		lblPicture.setIcon(new ImageIcon(imagePath));
		lblPicture.setBounds(0, 0, 452, 426);
		contentPane.add(lblPicture);
	}
}
