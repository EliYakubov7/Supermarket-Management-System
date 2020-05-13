package All;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.scenario.Settings;

import java.awt.Window.Type;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTree;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SalesScreen extends JFrame {

	private JPanel contentPane;
	private JFrame SalesScreen;
	private Factory m_Factory = new Factory();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesScreen frame = new SalesScreen();
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
	public SalesScreen() {
		File logoImage = new File("SalesScreen.png");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setResizable(false);
		setTitle("Sales Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);    дефк моск ома

		setBounds(620, 280, 1042, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInvoiceLookup = new JButton("Invoice Lookup");
		btnInvoiceLookup.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInvoiceLookup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			InvoiceLookup FindReceipt = new InvoiceLookup();
			setVisible(false);
			FindReceipt.setVisible(true);
			}			
		});
		btnInvoiceLookup.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInvoiceLookup.setBounds(32, 85, 153, 25);
		contentPane.add(btnInvoiceLookup);
		

		
		JButton btnInvoiceScreen = new JButton("Invoice Screen");
		btnInvoiceScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.INVOICESCREEN);
				setVisible(false);
				screen.setVisible(true);
			}
		});
		btnInvoiceScreen.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInvoiceScreen.setBounds(32, 35, 153, 25);
		contentPane.add(btnInvoiceScreen);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.MAINMENU);
				screen.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(871, 475, 153, 25);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		File SalesScreen = new File("SalesScreen.png");
		String SalesScreenPath = SalesScreen.getPath();
		lblNewLabel.setIcon(new ImageIcon(SalesScreenPath));
		lblNewLabel.setBounds(-12, 138, 1024, 264);
		contentPane.add(lblNewLabel);
	}
}
