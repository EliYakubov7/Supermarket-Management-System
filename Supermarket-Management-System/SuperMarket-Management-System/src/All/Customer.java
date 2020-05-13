package All;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
public class Customer extends Person implements java.io.Serializable 
{

	
	public Customer() {}
	public Customer (String customerGender,String customerPhone, String customerEmail, String customerAddress, String customerFirstName,
			String customerLastName,String customerId)
	{
		this.setCustomerGender(customerGender);
		this.setCustomerPhone(customerPhone);
		this.setCustomerEmail(customerEmail);
		this.setCustomerAddress(customerAddress);
		this.setCustomerFirstName(customerFirstName);
		this.setCustomerLastName(customerLastName);
		this.setCustomerId(customerId);
	}
	
	public String getCustomerGender() {
		return Gender;
	}

	public void setCustomerGender(String customerGender) {
		this.Gender = customerGender;
	}

	public String getCustomerPhone() {
		return Phone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.Phone = customerPhone;
	}

	public String getCustomerEmail() {
		return Email;
	}

	public void setCustomerEmail(String customerEmail) {
		this.Email = customerEmail;
	}

	public String getCustomerAddress() {
		return Address;
	}

	public void setCustomerAddress(String customerAddress) {
		this.Address = customerAddress;
	}

	public String getCustomerFirstName() {
		return FirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.FirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return LastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.LastName = customerLastName;
	}

	public String getCustomerId() {
		return Id;
	}

	public void setCustomerId(String customerId) {
		this.Id = customerId;
	}
}