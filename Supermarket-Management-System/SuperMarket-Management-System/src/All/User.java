package All;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class User extends Person implements java.io.Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userStartedWorkDay;
	private String userBithDate;
	private String userJob;
	private String salary;
	

	public User (String userWorkerId, String userFirstName, String userLastName, String userGender,
			String userStartedWorkDay, String userAddress,String userPhone, String userEmail,
			String userJob, String userBithDate, String UserSalary)
	{
		this.setUserId(userWorkerId);
		this.setUserFirstName(userFirstName);
		this.setUserLastName(userLastName);
		this.setUserGender(userGender);
		this.setUserStartedWorkDay(userStartedWorkDay);
		this.setUserAddress(userAddress);
		this.setUserPhone(userPhone);
		this.setUserEmail(userEmail);
		this.setUserJob(userJob);	
		this.setUserBithDate(userBithDate);
		this.setSalary(UserSalary);
		
	}
	
	public User() {	}

	public String getUserId() {
		return Id;
	}

	public void setUserId(String userId) {
		this.Id = userId;
	}

	public String getUserFirstName() {
		return FirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.FirstName = userFirstName;
	}

	public String getUserLastName() {
		return LastName;
	}

	public void setUserLastName(String userLastName) {
		this.LastName = userLastName;
	}

	public String getUserGender() {
		return Gender;
	}

	public void setUserGender(String userGender) {
		this.Gender = userGender;
	}

	public String getUserStartedWorkDay() {
		return userStartedWorkDay;
	}

	public void setUserStartedWorkDay(String userStartedWorkDay) {
		this.userStartedWorkDay = userStartedWorkDay;
	}

	public String getUserBithDate() {
		return userBithDate;
	}

	public void setUserBithDate(String userBithDate) {
		this.userBithDate = userBithDate;
	}

	public String getUserAddress() {
		return Address;
	}

	public void setUserAddress(String userAddress) {
		this.Address = userAddress;
	}

	public String getUserPhone() {
		return Phone;
	}

	public void setUserPhone(String userPhone) {
		this.Phone = userPhone;
	}

	public String getUserEmail() {
		return Email;
	}

	public void setUserEmail(String userEmail) {
		this.Email = userEmail;
	}

	public String getUserJob() {
		return userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public int GetIntSalary() {
		int Intsalary;
		try {
			Intsalary = Integer.parseInt(this.salary);
		}
		catch (NumberFormatException e)
		{
			Intsalary = 0;
		}
		
		return Intsalary;
	}
	
	
}