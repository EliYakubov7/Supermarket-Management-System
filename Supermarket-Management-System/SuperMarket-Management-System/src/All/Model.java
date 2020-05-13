package All;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.ComboBoxModel;

import com.sun.javafx.binding.StringFormatter;
import com.sun.javafx.util.TempState;

import sun.security.smartcardio.SunPCSC.Factory;

public class Model {

	final static String  m_ProductDataFile = "productList.dat";
	final static String  m_CustomerDataFile = "customerList.dat";
	final static String  m_UserDataFile = "userList.dat";
	final static String  m_ProductTextFile = "Products.txt";
	final static String  m_CustomerTextFile = "Customers.txt";
	final static String  m_UserTextFile = "Users.txt";
	final static String  m_InvoiceTextFile = "invoiceList.txt";
	final static String  m_InvoiceDataFile = "invoiceList.dat";  // \t = 4 spaces 7 7 7 
	final String m_FirstLineInInvoice = "Product name\t       Product id\t       Price\t       Units" + System.lineSeparator();
	final String m_InvoiceSeparatLine = "------------------------------------------------------------------------------------------------" + System.lineSeparator(); 
	final String m_InvoiceSpace = "\t       ";
	private static List<User> usersList = loadUserList(); 
	private static List<Product> ProductList = loadItemList();
	private static List<Customer> CustomersList = loadCustomerList(); 
	private static List<Invoice> InvoiceList = loadInvoiceList();
	private List<ProductInCart> ProductInCartList = new ArrayList<ProductInCart>(); 
	
	public String addProductToInvoice(String i_ProductName, int i_ProductQuantity)
	{
		if (i_ProductQuantity <= 0)
		{
			throw new RuntimeException("Enter product quantity");
		}
		if (i_ProductQuantity >= 100)
		{
			throw new RuntimeException("You can't buy 100 or more");
		}
		
		for (Product tempProduct : ProductList)
		{
			if (tempProduct.getProductName().contentEquals(i_ProductName) == true)
			{
				if (Integer.parseInt(tempProduct.getProductQuantity()) < i_ProductQuantity)
				{
					throw new RuntimeException("There is not enough quantity of this product");
				}
			}
		}
		
		String stringToAdd = "";
		Product tempProduct = searchProductByName(i_ProductName);
		ProductInCartList.add(new ProductInCart(tempProduct.getProductId(), tempProduct.getProductName() ,i_ProductQuantity, tempProduct.getProductCostPrice()));
		stringToAdd += tempProduct.getProductName() + m_InvoiceSpace + tempProduct.getProductId() + m_InvoiceSpace 
				+ tempProduct.getProductCostPrice() + m_InvoiceSpace + i_ProductQuantity + m_InvoiceSpace + System.lineSeparator();
		return stringToAdd;
	}
	
	private Product searchProductByName(String i_ProductName)
	{
		Product tempProduct = null;
		for (Product newProduct : ProductList)
		{
			if (newProduct.getProductName().equals(i_ProductName) == true)
			{	
				tempProduct = newProduct;
				break;	
		    }
		}
		
		return tempProduct;	
	}

	
	public String getFirstLineInInvoice()
	{
		return m_FirstLineInInvoice;
	}
	
	public String getInvoiceSeparatLine()
	{
		return m_InvoiceSeparatLine;
	}
	
	public void saveToInvoiceFileFromList() 
	{
  	  try
  	  {
  		File customerFile = new File(m_InvoiceDataFile);
  		String filePath = customerFile.getPath();
		FileOutputStream fout = new FileOutputStream(filePath/*, true ); if we want to append to the file*/);
		ObjectOutputStream outputStream = new ObjectOutputStream(fout);
		for (Invoice newInvoice : InvoiceList)
		{
			outputStream.writeObject(newInvoice);
		}
		
		outputStream.close();
		fout.close();
		
	  }
  	  
  	  catch (FileNotFoundException e)
  	  {
		e.printStackTrace();
	  } 
  	  catch (IOException e) 
  	  {
		e.printStackTrace();
	  } 
	}


	
	@SuppressWarnings("resource")
	public static List<Invoice> loadInvoiceList()
	{
		List<Invoice> InvoiceList = new ArrayList<Invoice>();
  		try 
  		{
  	  		File customerFile = new File(m_InvoiceDataFile);
  	  		String filePath = customerFile.getPath();
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream inputStream;
			try
			{
				if (fin.available() == 0)
				{
					return InvoiceList;
				}
				
				inputStream = new ObjectInputStream(fin);
				try 
				{
					while (fin.available() != 0)
					{
						InvoiceList.add((Invoice) inputStream.readObject());
					}
				}
				
				catch (ClassNotFoundException e) 
				  {
					e.printStackTrace();
				  } 
				
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
				inputStream.close();
			}
			
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}			
		} 
  		
  		catch (FileNotFoundException e) 
  		{
			e.printStackTrace();
		}
  		
		return InvoiceList;	

	}
	
	public static List<Customer> loadCustomerList()
	{
		List<Customer> customerList= new ArrayList<Customer>();
  		try 
  		{
  	  		File customerFile = new File(m_CustomerDataFile);
  	  		String filePath = customerFile.getPath();
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream inputStream;
			try
			{
				if (fin.available() == 0)
				{
					return customerList;
				}
				
				inputStream = new ObjectInputStream(fin);
				try 
				{
					while (fin.available() != 0)
					{
						customerList.add((Customer) inputStream.readObject());
					}
				}
				
				catch (ClassNotFoundException e) 
				  {
					e.printStackTrace();
				  } 
				
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
				inputStream.close();
			}
			
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}			
		} 
  		
  		catch (FileNotFoundException e) 
  		{
			e.printStackTrace();
		}
  		
		return customerList;	
	}

	
	public void saveToCustomerFileFromList () 
	{
  	  try
  	  {
  		File customerFile = new File(m_CustomerDataFile);
  		String filePath = customerFile.getPath();
		FileOutputStream fout = new FileOutputStream(filePath);
		ObjectOutputStream outputStream = new ObjectOutputStream(fout);
		for (Customer newCustomer : CustomersList)
		{
			outputStream.writeObject(newCustomer);
		}
		
		outputStream.close();
		fout.close();
		
	  }
  	  
  	  catch (FileNotFoundException e)
  	  {
		e.printStackTrace();
	  } 
  	  catch (IOException e) 
  	  {
		e.printStackTrace();
	  } 
	}
	
	public void writeToCustomerTextFileFromList()
	{
		 try {
	            FileWriter writer = new FileWriter(m_CustomerTextFile);
	    		for (Customer newCustomer : CustomersList)
	    		{
	    			writer.write("Customer First Name: " + newCustomer.getFirstName()+"\n");
	    			writer.write("Customer Last Name: " + newCustomer.getLastName()+"\n");
	    			writer.write("Customer ID: " + newCustomer.getCustomerId()+"\n");
	    			writer.write("Customer Email: " + newCustomer.getEmail()+"\n");
	    			writer.write("Customer Address: " + newCustomer.getAddress()+"\n");
	    			writer.write("Customer PhoneNumber: " + newCustomer.getPhone()+"\n");
	    			writer.write("Customer Gender: " + newCustomer.getGender() +"\n");
	    			writer.write("-----------------------------------------------" +"\n");
	    		}
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	 }
	

    public void saveToProductFileFromList () 
	{
  	  try
  	  {
  		File productsFile = new File(m_ProductDataFile);
  		String filePath = productsFile.getPath();
		FileOutputStream fout = new FileOutputStream(filePath/*, true ); if we want to append to the file*/);
		ObjectOutputStream outputStream = new ObjectOutputStream(fout);
		for (Product newProduct : ProductList)
		{
			outputStream.writeObject(newProduct);
		}
		
		outputStream.close();
		fout.close();
	  }
  	  
  	  catch (FileNotFoundException e)
  	  {
		e.printStackTrace();
	  } 
  	  catch (IOException e) 
  	  {
		e.printStackTrace();
	  }
  	  
	}
	
    public void writeToProductTextFileFromList()
	{
		 try {
	            FileWriter writer = new FileWriter(m_ProductTextFile);
	    		for (Product newProduct : ProductList)
	    		{
	    			writer.write("Produc Name: " + newProduct.getProductName() + "\n");
	    			writer.write("Product Id: " + newProduct.getProductId() + "\n");
	    			writer.write("Product Category: " + newProduct.getProductCategory() + "\n");
	    			writer.write("Cost Price: " + newProduct.getProductCostPrice() + "\n");
	    			writer.write("Product Sell ptice: " + newProduct.getProductPrice() + "\n");
	    			writer.write("Product Quantity: " + newProduct.getProductQuantity() + "\n");
	    			writer.write("Product Receive Date: " + newProduct.getProductReceiveDate() + "\n");
	    			writer.write("Product Expire Date: " + newProduct.getProductExpireDate( )+ "\n");
	    			writer.write("Product Supplier: " + newProduct.getProductSupplier() + "\n");
	    			writer.write("Product Weight: " + newProduct.getProductWeight() + "\n");
	    			writer.write("-----------------------------------------------"  + "\n");

	    		}
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	 }
    
	public static List<Product> loadItemList()
	{
		List<Product> productList= new ArrayList<Product>();
  		try 
  		{
  	  		File itemsFile = new File(m_ProductDataFile);
  	  		String filePath = itemsFile.getPath();
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream inputStream;
			try
			{
				if (fin.available() == 0)
				{
					return productList;
				}
				
				inputStream = new ObjectInputStream(fin);
				try 
				{
					while (fin.available() != 0)
					{
						productList.add((Product) inputStream.readObject());
					}
				}
				
				catch (ClassNotFoundException e) 
				  {
					e.printStackTrace();
				  } 
				
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
				inputStream.close();
			}
			
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			
		} 
  		
  		catch (FileNotFoundException e) 
  		{
			e.printStackTrace();
		}
  		
		return productList;	
	}

	public void saveToUserFileFromList ()
	{
  	  try
  	  {
  		File employeeFile = new File(m_UserDataFile);
  		String filePath = employeeFile.getPath();
		FileOutputStream fout = new FileOutputStream(filePath);
		ObjectOutputStream outputStream = new ObjectOutputStream(fout);
		for (User newUser : usersList)
		{
			outputStream.writeObject(newUser);
		}
		
		outputStream.close();
		fout.close();
	  }
  	  
  	  catch (FileNotFoundException e)
  	  {
		e.printStackTrace();
	  } 
  	  catch (IOException e) 
  	  {
		e.printStackTrace();
	  }
  	  
	}
	
	public void writeToUserTextFileFromList()
	{
		 try {
	            FileWriter writer = new FileWriter(m_UserTextFile);
	    		for (User newUser : usersList)
	    		{
	    			writer.write("User First Name: " + newUser.getUserFirstName()+"\n");
	    			writer.write("User Last Name: " + newUser.getUserLastName()+"\n");
	    			writer.write("User ID: " + newUser.getUserId()+"\n");
	    			writer.write("User address: " + newUser.getUserAddress()+"\n");
	    			writer.write("User Email: " + newUser.getUserEmail()+"\n");
	    			writer.write("User Titel: " + newUser.getUserJob()+"\n");
	    			writer.write("User salary: " + newUser.getSalary() +"\n");
	    			writer.write("User Phone Number: " + newUser.getUserPhone()+"\n");
	    			writer.write("User Started Work Day: " + newUser.getUserStartedWorkDay()+"\n");
	    			writer.write("User Birth Date: " + newUser.getUserBithDate()+"\n");
	    			writer.write("-----------------------------------------------" +"\n");
	    		}
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	 }
	
	@SuppressWarnings("resource")
	public static List<User> loadUserList()

	{
		List<User> employeeList= new ArrayList<User>();
  		try 
  		{
  	  		File employeeFile = new File(m_UserDataFile);
  	  		String filePath = employeeFile.getPath();
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream inputStream;
			try
			{
				if (fin.available() == 0)
				{
					return employeeList;
				}
				
				inputStream = new ObjectInputStream(fin);
				try 
				{
					while (fin.available() != 0)
					{
						employeeList.add((User) inputStream.readObject());
					}
				}
				
				catch (ClassNotFoundException e) 
				  {
					e.printStackTrace();
				  } 
				
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
				inputStream.close();
				fin.close();
			}
			
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			
		} 
  		
  		catch (FileNotFoundException e) 
  		{
			e.printStackTrace();
		}
  		
		return employeeList;	
	}

		
	public void addUser(User i_TemporaryUser) {
		usersList.add(i_TemporaryUser);
		saveUser();
	}

	
	public void updateUser(String i_UserID, String i_UserAddress, String i_UserEmail, String i_UserFirstName, String i_UserLastName,
			String i_UserPhoneNumber) {
		for (User newUser : usersList)
		{
			if (newUser.getUserId().equals(i_UserID) == true)
			{
				newUser.setUserAddress(i_UserAddress);
				newUser.setUserEmail(i_UserEmail);
				newUser.setUserFirstName(i_UserFirstName);
				newUser.setUserLastName(i_UserLastName);
				newUser.setUserPhone(i_UserPhoneNumber);
				break;
			}
		}
		
		saveUser();
	}

	public void deleteUser(String i_UserId) {

		for (User newUser : usersList)
		{
			if (newUser.getUserId().equals(i_UserId) == true)
			{
				usersList.remove(newUser);
				break;
			}
		}
		
		saveUser();	
	}

	private void saveUser()
	{
		this.saveToUserFileFromList();
		this.writeToUserTextFileFromList();
	}


	public User searchUser(String i_UserId) {
		User tempUser = null;
		for (User newUser : usersList)
		{
			if (newUser.getUserId().equals(i_UserId) == true)
			{
				tempUser = newUser;
				break;
			}
		}	
		return tempUser;
	}

	public void updateProduct(Product i_NewProduct) {
		
		for (Product newProduct : ProductList)
		{
			if (newProduct.getProductId().equals(i_NewProduct.getProductId()) == true)
			{
				newProduct.setProductCategory(i_NewProduct.getProductCategory());
				newProduct.setProductExpireDate(i_NewProduct.getProductExpireDate());
				newProduct.setProductName(i_NewProduct.getProductName());
				newProduct.setProductPrice(i_NewProduct.getProductPrice());
				newProduct.setProductQuantity(i_NewProduct.getProductQuantity());
				newProduct.setProductReceiveDate(i_NewProduct.getProductReceiveDate());
				newProduct.setProductSupplier(i_NewProduct.getProductSupplier());
				newProduct.setProductWeight(i_NewProduct.getProductWeight());
				newProduct.setProductCostPrice(i_NewProduct.getProductCostPrice());
				break;
			}
		}
		
		this.saveToProductFileFromList();
		this.writeToProductTextFileFromList();
	}

	public Product searchProduct(String i_ProductId) {
		Product tempProduct = null;
		for (Product newProduct : ProductList)
		{
			if (newProduct.getProductId().equals(i_ProductId) == true)
			{	
				tempProduct = newProduct;
				break;
		    }
		}
		
		return tempProduct;
	}

	public void deleteProduct(String i_ProductId) {
		for (Product newProduct : ProductList)
		{
			if (newProduct.getProductId().equals(i_ProductId) == true)
			{
				ProductList.remove(newProduct);
				break;
			}		
		}
		
		this.saveProduct();	
	}
	
	public void addProduct(Product i_NewProduct) {
		ProductList.add(i_NewProduct);
		this.saveProduct();
	}
	
	private void saveProduct()
	{
		this.saveToProductFileFromList();
		this.writeToProductTextFileFromList();
	}

	public void addCustomer(Customer i_NewCustomer) {
		CustomersList.add(i_NewCustomer);
		saveCustomer();
	}
	
	private void saveCustomer()
	{
		this.writeToCustomerTextFileFromList();
		this.saveToCustomerFileFromList();
	}

	public void deleteCustomer(String i_CustomerId) {
		for (Customer newCustomer : CustomersList)
		{
			if (newCustomer.getCustomerId().equals(i_CustomerId) == true)
			{
				CustomersList.remove(newCustomer);
				break;
			}
		}
		
		this.saveCustomer();		
	}
		
	public Customer searchCustomer(String i_CustomerId) {
		Customer tempCustomer = null;
		for (Customer newCustomer : CustomersList)
		{
			if (newCustomer.getCustomerId().equals(i_CustomerId) == true)
			{
				tempCustomer = newCustomer;
				break;
			}
		}
		
		return tempCustomer;
	}

	public void updateCustomer(Customer i_NewCustomer) {
		for (Customer newCustomer : CustomersList)
		{
			if (newCustomer.getCustomerId().equals(i_NewCustomer.getCustomerId()) == true)
			{
				newCustomer.setCustomerAddress(i_NewCustomer.getCustomerAddress());
				newCustomer.setCustomerEmail(i_NewCustomer.getCustomerEmail());
				newCustomer.setCustomerFirstName(i_NewCustomer.getCustomerFirstName());
				newCustomer.setCustomerLastName(i_NewCustomer.getCustomerLastName());
				newCustomer.setCustomerPhone(i_NewCustomer.getCustomerPhone());
				newCustomer.setCustomerGender(i_NewCustomer.getCustomerGender());
				break;
			}
		}
		
		this.saveCustomer();
	}

	public String[] getCategoryList() {
		String[] categoryString = new String[ProductList.size() + 1];
		categoryString[0] = "Select";
		int index = 1;
		for (Product tempProduct : ProductList)
		{
			
			categoryString[index] = tempProduct.getProductCategory();
			index++;
		}
		
		categoryString = Arrays.stream(categoryString).distinct().toArray(String[]::new);
		return categoryString;
	}

	public String[] getProductsToComboBox(String i_ProductCategorty)
	{
		int size = 0;
		for (Product tempProduct : ProductList)
		{
			if (i_ProductCategorty.equals(tempProduct.getProductCategory()) == true)
			{
				size++;
			}

		}
		
		String[] productsToComboBoxList = new String[size + 1];
		productsToComboBoxList[0] = "Select";
		int index = 1;
		
		for (Product tempProduct : ProductList)
		{			
			if (i_ProductCategorty.equals(tempProduct.getProductCategory()) == true)
			{
				productsToComboBoxList[index] = tempProduct.getProductName();
				index++;
			}

		}
		
		productsToComboBoxList = Arrays.stream(productsToComboBoxList).distinct().toArray(String[]::new);
		return productsToComboBoxList;
	}

	public double getInvoiceTotalPrice() 
	{
		double sum = 0;
		for (ProductInCart tempProductInCart : ProductInCartList)
		{
			sum += tempProductInCart.getM_ProductQuantity() * Double.parseDouble(tempProductInCart.getProductPrice());
		}
		
		return sum;	
	}
	
	public void writeToInvoiceTextFileFromList()
	{
		 try {
	            FileWriter writer = new FileWriter(m_InvoiceTextFile);
	    		for (Invoice newInvoice : InvoiceList)
	    		{
	    			writer.write(newInvoice.getInvoiceData() + "======================================================================");
	    		}
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	 }

	public String payInvoice(double i_AmountToPay, String i_CustomerId, String i_InvoiveData, double i_Totalprice)
	{
		if (i_AmountToPay == 0)
		{
			throw new RuntimeException("Enter money to pay");
		}
		
		if (i_AmountToPay < i_Totalprice)
		{
			throw new RuntimeException("Enter more money");
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		int invoiceNumber = getRandomNumberInRange(1,99999999);
		String finalInvoice = i_InvoiveData + "\n\nInvoice number: " + String.valueOf(invoiceNumber) + "\n";
		finalInvoice += "Total Price: " + i_Totalprice + "\n";
		finalInvoice += "purchase date: " + dateFormat.format(date).toString() + "\n";
		finalInvoice  += "Change: " + String.valueOf((i_AmountToPay - i_Totalprice)) +  "\n";
		finalInvoice  += "Customer id: " + i_CustomerId + "\n";
		Invoice newInvoice = new Invoice(i_CustomerId, invoiceNumber, ProductInCartList, finalInvoice, i_Totalprice);
		InvoiceList.add(newInvoice);
		this.saveToInvoiceFileFromList();
		this.writeToInvoiceTextFileFromList();
		int currentQuantity;
		int productInCartQuantity;
		int newQuantity;
		
		for (ProductInCart tempProductInCart : ProductInCartList )
		{
			for (Product tempProduct : ProductList)
			{
				if (tempProductInCart.getM_ProductId().equals(tempProduct.getProductId()) == true)
				{
					currentQuantity = Integer.parseInt(tempProduct.getProductQuantity());
					productInCartQuantity = tempProductInCart.getM_ProductQuantity();
					newQuantity = currentQuantity - productInCartQuantity;
					tempProduct.setProductQuantity(String.valueOf(newQuantity));
					this.saveToProductFileFromList();
					this.writeToProductTextFileFromList();
					break;
				}
			}
		}
		
		return finalInvoice;
	}
	
	private static int getRandomNumberInRange(int min, int max) 
	{
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public String[] getInvoiceNumbers(String i_CustomerId) {
		String[] invoicesNumbers = new String[InvoiceList.size() + 1];
		invoicesNumbers[0] = "Select";
		int index = 1;
		for (Invoice tempInvoice : InvoiceList)
		{
			if (i_CustomerId.equals(String.valueOf(i_CustomerId)))
			{
				invoicesNumbers[index] = String.valueOf(tempInvoice.getInvoiceNumber());	
				index++;
			}			
		}
		
		return invoicesNumbers;
	}

	public String getInvoice(String i_SelectedInvoiceNumber) 
	{
		String selectedInvoice = "";
		for (Invoice tempInvoice : InvoiceList)
		{
			if (i_SelectedInvoiceNumber.equals(String.valueOf(tempInvoice.getInvoiceNumber())))
			{
				return tempInvoice.getInvoiceData();
			}
		}
		
		return selectedInvoice;	
	}

	public String getReport() 
	{
		int salaries = this.sumAllWorkersSalaris();
		int totalWorkers = usersList.size();
		double income = this.getIncome();
		double costOfProducts = this.getcostOfProducts();
		int totalItemsInDtock = ProductList.size();
		double totalProfit = income - salaries - costOfProducts;
		
		String report = "\n This Report represent the current status of your business\n\n\n\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n\n Total Salaries at this" + " time: "	+ salaries+ " ¤ for: "+ totalWorkers 
				+	" employees in your business.\n\n Total income at this time: " + income + " ¤\n\n Total inventory costs: "
				+costOfProducts+" ¤ for total of: "+ totalItemsInDtock + " items from: "+ totalItemsInDtock+" different product in your inventory\n\n This Company Profits: "+ income  +"\n\n" 
				+ "Total Profit:    "+ totalProfit +" ¤\n " + " \n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
						+ "~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n\n\t\t\tEnd Of Report, Thank you !.";
	
		return report;	
	}
	
	private int sumAllWorkersSalaris()
	{
		int sum = 0;
		for (User tempUser : usersList)
		{
			sum += tempUser.GetIntSalary();
		}
		
		return sum;
	}
	
	private double getIncome()
	{
		double sum = 0;
		
		for (Invoice tempInvoice : InvoiceList)
		{
			sum += tempInvoice.getTotalPrice();
		}
		
		return sum;
	}
	
	private double getcostOfProducts()
	{
		int totalProductInStock = 0;
		double totalcostOfProducts = 0;
		
		for (Product tempProduct : ProductList)
		{
			for (Invoice tempInvoice : InvoiceList)
			{
				for (ProductInCart tempProductInCart : tempInvoice.getProductsList())
				{
					if (tempProduct.getProductId().equals(tempProductInCart.getM_ProductId()) == true)
					{
						totalProductInStock = Integer.parseInt(tempProduct.getProductQuantity()) + tempProductInCart.getM_ProductQuantity();
						totalcostOfProducts += totalProductInStock * Double.parseDouble(tempProduct.getProductCostPrice()); 
						totalProductInStock = 0;
					}
				}
			}
		}
		
		return totalcostOfProducts;
	}
	
	public void updateInventory(String i_ProductId, String i_ExpiredDate, String i_ProductName, String i_ProductQuantity, String i_ReciveDate, String i_Supplier) 
	{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try
        {
            Date date = formatter.parse(i_ExpiredDate);
            date = formatter.parse(i_ReciveDate);
        }
        catch (Exception e) {
			throw new RuntimeException();
        }
        if (searchProduct(i_ProductId) == null)
        {
        	throw new RuntimeException();
        }
        
        if(Integer.parseInt(i_ProductQuantity) < 0)
        {
        	throw new RuntimeException();
        }
		
		for (Product newProduct : ProductList)
		{
			if (newProduct.getProductId().equals(i_ProductId) == true)
			{	
				newProduct.setProductName(i_ProductName);
				newProduct.setProductQuantity(i_ProductQuantity);
				newProduct.setProductReceiveDate(i_ReciveDate);
				newProduct.setProductExpireDate(i_ExpiredDate);
				newProduct.setProductSupplier(i_Supplier);
				break;
		    }
		}
		
		this.saveToProductFileFromList();
		this.writeToProductTextFileFromList();
	}

	public void saveInventory(String i_ExpiredDate, String i_ReceiveDate, String i_ProductID, String i_ProductQuantity) {
		
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try
        {
            Date date = formatter.parse(i_ExpiredDate);
            date = formatter.parse(i_ReceiveDate);
        }
        catch (Exception e) {
			throw new RuntimeException();
        }
        if (searchProduct(i_ProductID) == null)
        {
        	throw new RuntimeException();
        }
        
        if(Integer.parseInt(i_ProductQuantity) < 0)
        {
        	throw new RuntimeException();
        }
		
		for (Product newProduct : ProductList)
		{
			if (newProduct.getProductId().equals(i_ProductID) == true)
			{	
				newProduct.setProductQuantity(i_ProductQuantity);
				newProduct.setProductReceiveDate(i_ReceiveDate);
				newProduct.setProductExpireDate(i_ExpiredDate);
				break;
		    }
		}
		
		this.saveToProductFileFromList();
		this.writeToProductTextFileFromList();
	}

	public String getStockReport()
	{
		String stockReport = "\n This Report represent the current status of your business\n\n\n\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n\n ";
		
		for (Product newProduct : ProductList)
		{
			stockReport += "Product name: " + " " + newProduct.getProductName();
			stockReport += "\n";
			stockReport += "Product ID: " + " " + newProduct.getProductId();
			stockReport += "\n";
			stockReport += "Product quantity: " + " " + newProduct.getProductQuantity();
			stockReport += "\n";
			stockReport += "--------------------------------------------------------------------------------------------------------------------------------";
			stockReport += "\n";
		}		
		
		stockReport += " \n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n\n\t\t\tEnd Of Report, Thank you !.";
	
		return stockReport;	
	}

	public String getSalariesReport() {
		String salariesReport = "\n This Report represent the current status of your business\n\n\n\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n\n ";
		
		for (User newUser : usersList)
		{
			salariesReport  += "User name:" + " " + newUser.FirstName + " " + newUser.LastName;
			salariesReport  += "\n";
			salariesReport  += "User ID:" + " " + newUser.Id;
			salariesReport  += "\n";
			salariesReport  += "User salary:" + " " + newUser.getSalary();
			salariesReport  += "\n";
			salariesReport  += "--------------------------------------------------------------------------------------------------------------------------------";
			salariesReport  += "\n";
		}		
		
		salariesReport  += " \n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n\n\t\t\tEnd Of Report, Thank you !.";
	
		return salariesReport;	
		
	}

}
