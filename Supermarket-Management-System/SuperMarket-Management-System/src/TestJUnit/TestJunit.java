package TestJUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import All.Customer;
import All.Factory;
import All.Model;
import All.Product;
import All.User;


public class TestJunit {

	@Test
	public void test()
	{
		String Gender = "Test";
		String Phone = "999";
		String Email = "Test";
		String Address = "Test";
		String firstName = "Test";
		String LastName = "Test";
		String Id = "99999";
		
		String userStartedWorkDay = "01-01-2000";
		String userBithDate = "01-01-2000";
		String userJob = "Manager";

		String productName = "Test";
		String productId ="99999";
		String productQuantity = "0";
		String productPrice = "0";
		String productWeight = "0";
		String productSupplier = "Test";
		String productCategory = "Meat";
		String productReceiveDate = "01-01-2000";
		String productExpireDate = "01-01-2000";
		String productCostPrice = "0";
		
		Factory factory = new Factory();
		
		User tempUser = new User();
		User testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		assertTrue(testUser.getClass() == tempUser.getClass());
		
		Customer tempCustomer = new Customer();
		Customer testCustomer = factory.creatCustomer(Gender, Phone,
				Email, Address, firstName, LastName, Id);
		assertTrue(testCustomer.getClass() == tempCustomer.getClass());
		
				
		Product tempProduct = new Product();
		Product testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice); 
		assertTrue(tempProduct.getClass() == testProduct.getClass());		
		
		
	}
	
	
	@Test(expected = Exception.class)
	public void testException()
	{
		String Gender = "Test";
		String Phone = "Test";
		String Email = "Test";
		String Address = "Test";
		String firstName = "Test";
		String LastName = "Test";
		String Id = "99999";
		
		String userStartedWorkDay = "01-01-2000";
		String userBithDate = "01-01-2000";
		String userJob = "Manager";

		String productName = "Test";
		String productId ="99999";
		String productQuantity = "0";
		String productPrice = "0";
		String productWeight = "0";
		String productSupplier = "Test";
		String productCategory = "Meat";
		String productReceiveDate = "01-01-2000";
		String productExpireDate = "01-01-2000";
		String productCostPrice = "0";
		
		Factory factory = new Factory();
		

		Gender = "Select";
		User testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		
		Phone = "";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		Phone = "Test";
		

		Phone = "dfbdfb"; // new test		
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
		Address, Phone, Email, userJob, userBithDate);
		Phone = "Test";

		Email = "";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		Email = "Test";
		
		Address = "";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		Address = "Test";
		
		firstName = "";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		firstName = "Test";
		
		LastName = "";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		LastName = "Test";
		
		Id = "";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		Id = "99999";
		
		Id = "sdfdv"; // new test
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		Id = "99999";
	
		userStartedWorkDay = "";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		
		userStartedWorkDay = "01-01-2000";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		
		userStartedWorkDay = "01/01/2000";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		userStartedWorkDay = "01-01-2000";
		
		userBithDate = "01-01-2000";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		userBithDate = "01-01-2000";
		
		userBithDate = "";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		userBithDate = "01-01-2000";
		
		userBithDate = "01/01/2000";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		userBithDate = "01-01-2000";
		
		userJob = "Select";
		testUser = factory.creatUser(Id, firstName, LastName, Gender, userStartedWorkDay,
				Address, Phone, Email, userJob, userBithDate);
		userJob = "Manager";
		
		
			
		Gender = "Select";
		Customer testCustomer = factory.creatCustomer(Gender, Phone,
				Email, Address, firstName, LastName, Id);

		
		Phone = "";
		testCustomer = factory.creatCustomer(Gender, Phone,
				Email, Address, firstName, LastName, Id);
		Phone = "Test";
		
		Phone = "dfbdfb"; // new test
		testCustomer = factory.creatCustomer(Gender, Phone,
				Email, Address, firstName, LastName, Id);
		Phone = "Test";

		Email = "";
		testCustomer = factory.creatCustomer(Gender, Phone,
				Email, Address, firstName, LastName, Id);
		Email = "Test";
		
		Address = "";
		testCustomer = factory.creatCustomer(Gender, Phone,
				Email, Address, firstName, LastName, Id);
		Address = "Test";
		
		firstName = "";
		testCustomer = factory.creatCustomer(Gender, Phone,
				Email, Address, firstName, LastName, Id);
		firstName = "Test";
		
		LastName = "";
		testCustomer = factory.creatCustomer(Gender, Phone,
				Email, Address, firstName, LastName, Id);
		LastName = "Test";
		
		Id = "";
		testCustomer = factory.creatCustomer(Gender, Phone,
				Email, Address, firstName, LastName, Id);
		Id = "99999";
		
		Id = "sdfdv"; // new test
		testCustomer = factory.creatCustomer(Gender, Phone,
				Email, Address, firstName, LastName, Id);
		Id = "99999";

		
		productName = "";
		Product testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice); 	
		productName = "Test";
		
		productId ="";
		testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice);
		productId ="99999";
		
		productQuantity = "";

		testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice);
		productQuantity = "0";
		
		productPrice = "";

		testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice);
		productPrice = "0";
		
		productWeight = "";

		testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice);
		productWeight = "0";
		
		productSupplier = "";
		testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice);
		productSupplier = "Test";
		
		productCategory = "Select";

		testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice);
		productCategory = "Meat";
		
		
		productReceiveDate = "";
		testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice);
		productReceiveDate = "01-01-2000";
		
		productReceiveDate = "01/01/2000";

		testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice);
		productReceiveDate = "01-01-2000";
		
		productExpireDate = "";

		testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice);
		productExpireDate = "01-01-2000";
		
		productExpireDate = "01/01/2000";

		testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice);
		productExpireDate = "01-01-2000";
		
		productCostPrice = "";

		testProduct = factory.creatProduct(productName, productId, productQuantity, productPrice
				, productWeight, productSupplier, productCategory, productReceiveDate, productExpireDate, productCostPrice);
		productCostPrice = "0";
		
	}
	
}
