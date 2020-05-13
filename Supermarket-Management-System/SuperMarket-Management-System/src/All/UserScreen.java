package All;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdk.internal.org.objectweb.asm.tree.analysis.Frame;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings({ "serial", "unused" })
public class UserScreen extends JFrame {

	private JPanel contentPane;
	private Factory m_Factory = new Factory();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserScreen frame = new UserScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("rawtypes")
	public UserScreen() {
		File logoImage = new File("UserScreen.png");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setResizable(false);
		setTitle("Users");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 788, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.USERADD);
			setVisible(false);
			screen.setVisible(true);
			
			}
		});
		btnAddUser.setBounds(12, 13, 117, 25);
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
		btnCancel.setBounds(653, 439, 117, 25);
		contentPane.add(btnCancel);
		
		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.USEREDUT);
				screen.setVisible(true);
			}
		});
		btnEditUser.setBounds(12, 51, 117, 25);
		contentPane.add(btnEditUser);
		
		JLabel lblPicture = new JLabel("");
		File UserScreen = new File("UserScreen.png");
		String UserScreenPath = UserScreen.getPath();
		lblPicture.setIcon(new ImageIcon(UserScreenPath));
		lblPicture.setBounds(0, 0, 782, 477);
		contentPane.add(lblPicture);
		
	}
}
