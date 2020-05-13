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
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
public class CustomerScreen extends JFrame {

	private JPanel contentPane;
	private Factory m_Factory = new Factory();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerScreen frame = new CustomerScreen();
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
	@SuppressWarnings("rawtypes")
	public CustomerScreen() {
		setResizable(false);
		File logoImage = new File("CustomerScreen.jpg");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Customer Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 912, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddUser = new JButton("Add Customer");
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.CUSTOMERADD);
			setVisible(false);
			screen.setVisible(true);
			
			}
		});
		btnAddUser.setBounds(10, 11, 138, 25);
		contentPane.add(btnAddUser);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.MANAGMENTSCREEN);
			screen.setVisible(true);
			}
		});
		btnCancel.setBounds(815, 408, 83, 25);
		contentPane.add(btnCancel);
		
		JButton btnEditUser = new JButton("Edit Customer");
		btnEditUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.CUSTOMEREDIT);
				screen.setVisible(true);
			}
		});
		btnEditUser.setBounds(10, 51, 138, 25);
		contentPane.add(btnEditUser);
		
		JLabel lblPicture = new JLabel("");
		File CustomerScreen = new File("CustomerScreen.jpg");
		String CustomerScreenPath = CustomerScreen.getPath();
		lblPicture.setIcon(new ImageIcon(CustomerScreenPath));
		lblPicture.setBounds(0, 0, 906, 476);
		contentPane.add(lblPicture);
	}
}




