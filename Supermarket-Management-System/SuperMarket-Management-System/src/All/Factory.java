package All;

import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class Factory 
{

	enum Screens
	{
		CUSTOMERADD,
		CUSTOMEREDIT,
		CUSTOMERSCREEN,
		INVENTORYEDIT,
		INVENTORYRECEIVE,
		INVENTORYSCREEN,
		INVOICELOOKUP,
		INVOICESCREEN,
		LOGIN,
		MAINMENU,
		MANAGMENTSCREEN,
		PRODUCTADD,
		PRODUCTEDIT,
		PRODUCTSCREEN,
		REPORTSCREEN,
		SALESSCREEN,
		USERADD,
		USEREDUT,
		USERSCREEN,
		SALARIESREPORT,
		STOCKREPORT,
	}
	
	public Frame creatNewScreen(Screens i_newScreen)
	{
		switch(i_newScreen)
		{
		case CUSTOMERADD:
			return new CustomerAdd();
		case CUSTOMEREDIT:
			return new CustomerEdit();
		case CUSTOMERSCREEN:
			return new CustomerScreen();
		case INVENTORYEDIT:
			return new InventoryEdit();
		case INVENTORYRECEIVE:
			return new InventoryReceive();
		case INVENTORYSCREEN:
			return new InventoryScreen();	
		case INVOICELOOKUP:
			return new InvoiceLookup();
		case INVOICESCREEN:
			return new InvoiceScreen();
		case LOGIN:
			return new Login();
		case MAINMENU:
			return new MainMenu(true);
		case MANAGMENTSCREEN:
			return new ManagementScreen();
		case PRODUCTADD:
			return new ProductAdd();
		case PRODUCTEDIT:
			return new ProductEdit();
		case PRODUCTSCREEN:
			return new ProductScreen();
		case REPORTSCREEN:
			return new ReportScreen();
		case SALESSCREEN:
			return new SalesScreen();
		case USERADD:
			return new UserAdd();
		case USEREDUT:
			return new UserEdit();
		case USERSCREEN:
			return new UserScreen();
		case STOCKREPORT:
			return new StockReport();
		case SALARIESREPORT:
			return new SalariesReport();
		}
		
		return null;		
	}
	
	public Controller creatController()
	{
		return new Controller();
	}
	
	public Model createModel()
	{
		return new Model();
	}

	public User creatUser(String i_UserId, String i_UserFirstName, String i_UserLastName , String i_Gender, String i_StatedWorkDay, String i_Address,
			String i_PhoneNember, String i_Email, String i_Titel, String i_DateOfBirth) 
	{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try
        {
            Date date = formatter.parse(i_DateOfBirth);
            date = formatter.parse(i_StatedWorkDay);
        }
        catch (Exception e) {
			throw new RuntimeException();
        }
		if (i_Titel.equals("Select") == true)
		{
			throw new RuntimeException();
		}
		if (i_UserId.equals(""))
		{
			throw new RuntimeException();
		}
		for (char letter : i_UserId.toCharArray())
		{
			if ( Character.isLetter(letter) == true)
			{
				throw new RuntimeException();
			}
		}

		for (char letter : i_PhoneNember.toCharArray())
		{
			if ( Character.isLetter(letter) == true)
			{
				throw new RuntimeException();
			}
		}
		
		if (i_UserFirstName.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_UserLastName.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_Gender.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_StatedWorkDay.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_Address.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_PhoneNember.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_Email.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_DateOfBirth.equals(""))
		{
			throw new RuntimeException();
		}
		
		String UserSalary;
		if (i_Titel.equals("Manager") == true)
		{
			UserSalary = "10000";
		}
		else
		{
			UserSalary = "7000";
		}
	
	return new User(i_UserId, i_UserFirstName, i_UserLastName , i_Gender, i_StatedWorkDay,i_Address,
			i_PhoneNember, i_Email, i_Titel, i_DateOfBirth, UserSalary);
	}
	
	public Product creatProduct(String i_ProductName, String i_ProductId, String i_ProductQuntity
			, String i_ProductPrice, String i_ProductWeight,
			String i_ProductSupplier, String i_ProductCatgory, String i_ProductRecivedDate,
			String i_ProductExpiredDate, String i_ProductCostPrice) {
		
		
		
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try
        {
            Date date = formatter.parse(i_ProductExpiredDate);
            date = formatter.parse(i_ProductRecivedDate);
        }
        catch (Exception e) {
			throw new RuntimeException();
        }
        for (char letter : i_ProductId.toCharArray())
		{
			if ( Character.isLetter(letter) == true)
			{
				throw new RuntimeException();
			}
		}
		if (Integer.parseInt(i_ProductQuntity) < 0)
		{
			throw new RuntimeException();
		}
		
		if (i_ProductName.equals(""))
		{
			throw new RuntimeException();
		}
		
		if (i_ProductId.equals(""))
		{
			throw new RuntimeException();
		}
		
		if (i_ProductQuntity.equals(""))
		{
			throw new RuntimeException();
		}
		
		if (i_ProductPrice.equals(""))
		{
			throw new RuntimeException();
		}
		
		if (i_ProductWeight.equals("Select"))
		{
			throw new RuntimeException();
		}
		
		if (i_ProductSupplier.equals(""))
		{
			throw new RuntimeException();
		}
		
		if (i_ProductCatgory.equals("Select"))
		{
			throw new RuntimeException();
		}
		
		if (i_ProductRecivedDate.equals(""))
		{
			throw new RuntimeException();
		}
		
		if (i_ProductExpiredDate.equals(""))
		{
			throw new RuntimeException();
		}
		
		if (i_ProductCostPrice.equals(""))
		{
			throw new RuntimeException();
		}
			
		return new Product(i_ProductName, i_ProductId,i_ProductQuntity
				, i_ProductPrice,  i_ProductWeight,
				i_ProductSupplier, i_ProductCatgory, i_ProductRecivedDate,
				i_ProductExpiredDate,  i_ProductCostPrice) ;
	}

	public Customer creatCustomer(String i_CustomerGender, String i_CustomerPhoneNumber, String i_CustomerEmail
			, String i_CustomerAddress, String i_CustomerFirstName,
			String i_CustomerLastName, String i_CustomerId) {
		
		for (char letter : i_CustomerPhoneNumber.toCharArray())
		{
			if ( Character.isLetter(letter) == true)
			{
				throw new RuntimeException();
			}
		}
		
		for (char letter : i_CustomerId.toCharArray())
		{
			if ( Character.isLetter(letter) == true)
			{
				throw new RuntimeException();
			}
		}
		
		if (i_CustomerGender.equals("Select"))
		{
			throw new RuntimeException();
		}
		if (i_CustomerPhoneNumber.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_CustomerEmail.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_CustomerAddress.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_CustomerFirstName.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_CustomerLastName.equals(""))
		{
			throw new RuntimeException();
		}
		if (i_CustomerId.equals(""))
		{
			throw new RuntimeException();
		}
		return new Customer( i_CustomerGender, i_CustomerPhoneNumber, i_CustomerEmail
				, i_CustomerAddress, i_CustomerFirstName,
				 i_CustomerLastName, i_CustomerId);
	}
}