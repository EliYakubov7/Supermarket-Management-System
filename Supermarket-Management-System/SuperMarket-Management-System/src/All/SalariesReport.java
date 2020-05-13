package All;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class SalariesReport extends JFrame{
	
	private JPanel contentPane;
	Factory m_Factory = new Factory();
	Controller m_Controller = new Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalariesReport frame = new SalariesReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public SalariesReport() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(620, 280, 850, 650);
		setResizable(false);
		setTitle("Salaries Report");
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
																				 
		JTextArea text_Salaries = new JTextArea();									
		scrollPane.setViewportView(text_Salaries);
		text_Salaries.setEditable(false);
		text_Salaries.setFont(new Font("Tahoma", Font.BOLD, 14));					
		text_Salaries.setText("text area");
	
		
		text_Salaries.setText(m_Controller.getSalariesReport());
		
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
						text_Salaries.print();	
				}
				
				catch (java.awt.print.PrinterException e2)
				{
					System.err.format("No Printer Found", e2.getMessage());
				}

			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPrint.setBounds(566, 554, 97, 25);
		contentPane.add(btnPrint);
			
	}
	
}
