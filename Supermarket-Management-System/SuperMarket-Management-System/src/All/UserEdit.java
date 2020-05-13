package All;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;

public class UserEdit extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_WorkerId;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_Email;
	private JTextField textField_startrdWorkDay;
	private JTextField textField_BirthdayDate;
	private JTextField textField_Phone;
	private JTextField textField_Titel;
	private JTextField textField_Address;
	private JTextField textField_Gender;
	private JTextField textField_Salary;
	private Factory m_Factory = new Factory();
	private Controller m_Controller = m_Factory.creatController();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					UserEdit frame = new UserEdit();
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

	public UserEdit() {
		File logoImage = new File("UserEdit.png");
		String imagePath = logoImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setResizable(false);
		setTitle("Edit Users");
		getContentPane().setBackground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 868, 560);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUserid = new JLabel("WorkerID:");
		lblUserid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserid.setBounds(10, 43, 79, 22);
		contentPane.add(lblUserid);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(10, 82, 79, 22);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(10, 115, 79, 22);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(10, 148, 79, 22);
		contentPane.add(lblEmail);
		
		JLabel lblStartedWorkiDay = new JLabel("started work day:");
		lblStartedWorkiDay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStartedWorkiDay.setBounds(10, 181, 118, 22);
		contentPane.add(lblStartedWorkiDay);
		
		JLabel lblBirthdayDate = new JLabel("Birthday date:");
		lblBirthdayDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBirthdayDate.setBounds(10, 224, 102, 22);
		contentPane.add(lblBirthdayDate);
		
		JLabel lblAddress = new JLabel("Phone Number:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(10, 266, 102, 22);
		contentPane.add(lblAddress);
		
		JLabel lblTitle = new JLabel("Job:");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitle.setBounds(10, 301, 79, 22);
		contentPane.add(lblTitle);
		
		JLabel lblAddress_1 = new JLabel("Address:");
		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress_1.setBounds(10, 339, 79, 22);
		contentPane.add(lblAddress_1);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGender.setBounds(10, 372, 79, 22);
		contentPane.add(lblGender);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Frame screen= m_Factory.creatNewScreen(Factory.Screens.USERSCREEN);
				screen.setVisible(true);
			}
		});
		btnBack.setBounds(749, 464, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblPleaseFillId = new JLabel("Please fill ID number and click Search");
		lblPleaseFillId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPleaseFillId.setBounds(10, 11, 240, 22);
		contentPane.add(lblPleaseFillId);
		
		textField_WorkerId = new JTextField();
		textField_WorkerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_WorkerId.setColumns(10);
		textField_WorkerId.setBounds(131, 43, 161, 22);
		contentPane.add(textField_WorkerId);
		
		textField_FirstName = new JTextField();
		textField_FirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_FirstName.setColumns(10);
		textField_FirstName.setBounds(131, 80, 161, 22);
		contentPane.add(textField_FirstName);
		
		textField_LastName = new JTextField();
		textField_LastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(131, 113, 161, 22);
		contentPane.add(textField_LastName);
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Email.setColumns(10);
		textField_Email.setBounds(131, 147, 161, 22);
		contentPane.add(textField_Email);
		
		textField_startrdWorkDay = new JTextField();
		textField_startrdWorkDay.setEditable(false);
		textField_startrdWorkDay.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_startrdWorkDay.setColumns(10);
		textField_startrdWorkDay.setBounds(131, 181, 161, 22);
		contentPane.add(textField_startrdWorkDay);
		
		textField_BirthdayDate = new JTextField();
		textField_BirthdayDate.setEditable(false);
		textField_BirthdayDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_BirthdayDate.setColumns(10);
		textField_BirthdayDate.setBounds(131, 223, 161, 22);
		contentPane.add(textField_BirthdayDate);
		
		textField_Phone = new JTextField();
		textField_Phone.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(131, 266, 161, 22);
		contentPane.add(textField_Phone);
		
		textField_Titel = new JTextField();
		textField_Titel.setEditable(false);
		textField_Titel.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Titel.setColumns(10);
		textField_Titel.setBounds(131, 301, 161, 22);
		contentPane.add(textField_Titel);
		
		textField_Address = new JTextField();
		textField_Address.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Address.setColumns(10);
		textField_Address.setBounds(131, 339, 161, 22);
		contentPane.add(textField_Address);
		
		textField_Gender = new JTextField();
		textField_Gender.setEditable(false);
		textField_Gender.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Gender.setColumns(10);
		textField_Gender.setBounds(131, 372, 161, 22);
		contentPane.add(textField_Gender);
		
		textField_Salary = new JTextField();
		textField_Salary.setEditable(false);
		textField_Salary.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Salary.setColumns(10);
		textField_Salary.setBounds(131, 405, 161, 22);
		contentPane.add(textField_Salary);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalary.setBounds(10, 405, 79, 22);
		contentPane.add(lblSalary);
			
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					User temporaryUser = m_Factory.creatUser(textField_WorkerId.getText(), textField_FirstName.getText(), 
							textField_LastName.getText(), textField_Gender.getText(),
							textField_startrdWorkDay.getText(), textField_Address.getText(),
							textField_Phone.getText(), textField_Email.getText(),
							textField_Titel.getText(), 
							textField_BirthdayDate.getText());
		
					m_Controller.updateUser(textField_WorkerId.getText(), textField_Address.getText(),textField_Email.getText(), textField_FirstName.getText(), textField_LastName.getText(), textField_Phone.getName());
					textField_WorkerId.setText("");
					textField_FirstName.setText("");
					textField_LastName.setText("");
					textField_Email.setText("");
					textField_startrdWorkDay.setText("");
					textField_BirthdayDate.setText("");
					textField_Phone.setText("");
					textField_Address.setText("");
					textField_Titel.setText("");
					textField_Gender.setText("");
					textField_Salary.setText("");
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error please check all filds date must be in fotmat: DD-MM-YYYY");
				}
		
		}});
		btnUpdate.setBounds(749, 133, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					m_Controller.deleteUser(textField_WorkerId.getText());
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "The user is not in the data base");
				}
				
				textField_WorkerId.setText("");
				textField_FirstName.setText("");
				textField_LastName.setText("");
				textField_Email.setText("");
				textField_startrdWorkDay.setText("");
				textField_BirthdayDate.setText("");
				textField_Phone.setText("");;
				textField_Address.setText("");
				textField_Titel.setText("");
				textField_Gender.setText("");
				textField_Salary.setText("");
			}
		});
		btnDelete.setBounds(749, 188, 89, 23);
		contentPane.add(btnDelete);
		

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					User SearchedUser = m_Controller.searchUser(textField_WorkerId.getText());
					textField_WorkerId.setText(SearchedUser.getUserId());
					textField_FirstName.setText(SearchedUser.getUserFirstName());
					textField_LastName.setText(SearchedUser.getUserLastName());
					textField_Email.setText(SearchedUser.getUserEmail());
					textField_startrdWorkDay.setText(SearchedUser.getUserStartedWorkDay());
					textField_BirthdayDate.setText(SearchedUser.getUserBithDate());
					textField_Phone.setText(SearchedUser.getUserPhone());
					textField_Address.setText(SearchedUser.getUserAddress());
					textField_Titel.setText(SearchedUser.getUserJob());
					textField_Gender.setText(SearchedUser.getUserGender());
					textField_Salary.setText(SearchedUser.getSalary());

				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "The user is not in the data base");
				}


			}
		});
		btnSearch.setBounds(749, 27, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_WorkerId.setText("");
				textField_FirstName.setText("");;
				textField_LastName.setText("");;
				textField_Email.setText("");;
				textField_startrdWorkDay.setText("");
				textField_BirthdayDate.setText("");
				textField_Phone.setText("");;
				textField_Address.setText("");;
				textField_Titel.setText("");
				textField_Gender.setText("");
				textField_Salary.setText("");
			}
		});
		btnClear.setBounds(749, 80, 89, 23);
		contentPane.add(btnClear);
		
		JLabel lblPicture = new JLabel("");
		File UsersEdit = new File("UserEdit.png");
		String UserEditPath = UsersEdit.getPath();
		lblPicture.setIcon(new ImageIcon(UserEditPath));
		lblPicture.setBounds(299, -3, 551, 465);
		contentPane.add(lblPicture);
		

	}
}
