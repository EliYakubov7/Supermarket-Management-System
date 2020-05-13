package All;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

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

@SuppressWarnings({ "serial", "unused" })
public class AccountingScreen extends JFrame {

	private JPanel contentPane;
	private Factory m_Factory = new Factory();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountingScreen frame = new AccountingScreen();
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
	public AccountingScreen() {
		File logoImage = new File("Accounting.png");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setResizable(false);
		setTitle("Accounting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 744, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(609, 527, 117, 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			ManagementScreen screen= new ManagementScreen();
			screen.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnCancel);
		
		JButton btnSalaries = new JButton("Salaries");
		btnSalaries.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalaries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame frame = m_Factory.creatNewScreen(Factory.Screens.SALARIESREPORT);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnSalaries.setBounds(27, 66, 161, 25);
		contentPane.add(btnSalaries);
		
		JButton btnProfitLost = new JButton("Profit Lost");
		btnProfitLost.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProfitLost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame frame = m_Factory.creatNewScreen(Factory.Screens.REPORTSCREEN);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			
			}
		});
		btnProfitLost.setBounds(27, 29, 161, 25);
		contentPane.add(btnProfitLost);
		
		JButton btnPaymentMethood = new JButton("Inventory Report");
		btnPaymentMethood.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPaymentMethood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame frame = m_Factory.creatNewScreen(Factory.Screens.STOCKREPORT);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnPaymentMethood.setBounds(27, 105, 161, 25);
		contentPane.add(btnPaymentMethood);
		
		JLabel lblPicture = new JLabel("");
		File AccountingScreen = new File("Accounting.png");
		String AccountingScreenPath = AccountingScreen.getPath();
		lblPicture.setIcon(new ImageIcon(AccountingScreenPath));
		lblPicture.setBounds(200, 0, 526, 534);
		contentPane.add(lblPicture);
	}
	
}