package All;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;


@SuppressWarnings({ "serial", "unused" })
public class InventoryScreen extends JFrame {

	private JPanel contentPane;
	private Factory m_Factory = new Factory();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryScreen frame = new InventoryScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	@SuppressWarnings("rawtypes")
	public InventoryScreen() {
		File logoImage = new File("InventoryScreen.jpg");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setResizable(false);
		setTitle("Inventory Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 868, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			ManagementScreen screen= new ManagementScreen();
			screen.setVisible(true);
			}
		});
		btnBack.setBounds(689, 487, 161, 25);
		contentPane.add(btnBack);
		
		JButton btnEditQuantity = new JButton("Edit Inventory");
		btnEditQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			java.awt.Frame screen = m_Factory.creatNewScreen(Factory.Screens.INVENTORYEDIT);
			screen.setVisible(true);					
			}
		});
		btnEditQuantity.setBounds(12, 52, 161, 25);
		contentPane.add(btnEditQuantity);
		
		JButton btnRecieveShipment = new JButton("Receive Shipment");
		btnRecieveShipment.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRecieveShipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			InventoryReceive ir=new InventoryReceive();
			ir.setVisible(true);
			}
		});
		btnRecieveShipment.setBounds(12, 13, 161, 25);
		contentPane.add(btnRecieveShipment);
		
		JLabel lblPicture = new JLabel("");
		lblPicture.setFont(new Font("Tahoma", Font.BOLD, 13));
		File InventoryScreen = new File("InventoryScreen.jpg");
		String InventoryScreenPath = InventoryScreen.getPath();
		lblPicture.setIcon(new ImageIcon(InventoryScreenPath));
		lblPicture.setBounds(0, 0, 862, 528);
		contentPane.add(lblPicture);
		
	}
}
