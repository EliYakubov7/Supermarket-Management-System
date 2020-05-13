package All;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;

@SuppressWarnings({ "serial", "unused" })
public class ReportScreen extends JFrame {
	private JPanel contentPane;
	Controller m_Controller = new Controller();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportScreen frame = new ReportScreen();
					frame.setLocationRelativeTo(null);
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
	public ReportScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 500, 850, 650);
		setResizable(false);
		setTitle("Report Screen");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
		JButton btnCloseReport = new JButton("Close Report");
		btnCloseReport.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCloseReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				}
		});
		btnCloseReport.setBounds(675, 554, 125, 25);
		contentPane.add(btnCloseReport);
		
		JLabel label_top = new JLabel("HIT Mart Managment Systems");			
		label_top.setFont(new Font("Tahoma", Font.BOLD, 18));					
		label_top.setBounds(51, 9, 285, 31);									
		contentPane.add(label_top);												
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 53, 766, 488);
		contentPane.add(scrollPane);
																				 
		JTextArea text_ReportScreen = new JTextArea();									
		scrollPane.setViewportView(text_ReportScreen);
		text_ReportScreen.setFont(new Font("Tahoma", Font.BOLD, 14));					
		text_ReportScreen.setText("text area");
	
		
		text_ReportScreen.setText(m_Controller.getReport());
		
		JButton btnSaveReport = new JButton("Save Report");
		btnSaveReport.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSaveReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveReport.setBounds(429, 554, 125, 25);
		contentPane.add(btnSaveReport);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			{
					text_ReportScreen.print();	
			}
			
			catch (java.awt.print.PrinterException e4)
			{
				System.err.format("No Printer Found", e4.getMessage());
			}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPrint.setBounds(566, 554, 97, 25);
		contentPane.add(btnPrint);
		
	}
	
}
	