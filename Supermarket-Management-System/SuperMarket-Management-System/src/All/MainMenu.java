package All;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	boolean visible=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu(false);
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
	public MainMenu(boolean faded) {
		setResizable(false);
		setFont(new Font("Dialog", Font.PLAIN, 6));
		setTitle("Main Menu");
		setBackground(Color.WHITE);
		File logoImage = new File("main_menu.jpg");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 653, 374);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalesScreen = new JButton("Sales Screen");
		btnSalesScreen.setEnabled(faded);
		btnSalesScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			SalesScreen ss=new SalesScreen();
			ss.setVisible(true);
			}
		});
		
		JButton button = new JButton("");
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jopt = new JOptionPane();
			    String result;
			    result = "Created by Eliyahu Yakubov, Barak Ated And Gal Reshef S";
			    JLabel resLabel = new JLabel(result);
			    resLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
			    jopt.showMessageDialog( null, resLabel);
			}
		});
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Login frame1 = new Login();
			frame1.main(null);
			}
		});
		btnLogin.setFont(new Font("Serif", Font.BOLD, 15));
		btnLogin.setBounds(12, 13, 79, 29);
		contentPane.add(btnLogin);
		button.setIcon(new ImageIcon(MainMenu.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		button.setForeground(Color.RED);
		button.setBackground(Color.WHITE);
		button.setBounds(585, 13, 50, 50);
		contentPane.add(button);
		btnSalesScreen.setFont(new Font("Serif", Font.BOLD, 15));
		btnSalesScreen.setBounds(194, 272, 129, 54);
		contentPane.add(btnSalesScreen);
		
		JButton btnManagement = new JButton("Management");
		btnManagement.setEnabled(faded);
		btnManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ManagementScreen mgts = new ManagementScreen();
			setVisible(false);
			mgts.setVisible(true);
					
			}
		});
		btnManagement.setFont(new Font("Serif", Font.BOLD, 15));
		btnManagement.setBounds(387, 272, 129, 54);
		contentPane.add(btnManagement);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		btnExit.setFont(new Font("Serif", Font.BOLD, 15));
		btnExit.setBounds(12, 55, 79, 29);
		contentPane.add(btnExit);
		
		JLabel lblPicture = new JLabel("");
		File MainMenuImage = new File("main_menu.jpg");
		String MainMenuPath = MainMenuImage.getPath();
		lblPicture.setIcon(new ImageIcon(MainMenuPath));
		lblPicture.setBounds(0, 0, 647, 339);
		contentPane.add(lblPicture);
	}
	}

/*	JButton btnNewButton = new JButton("");
	btnNewButton.setForeground(Color.WHITE);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
*/