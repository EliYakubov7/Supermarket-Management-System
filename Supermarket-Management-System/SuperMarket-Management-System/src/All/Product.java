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

public class Product implements java.io.Serializable
{
	
	private String productName;
	private String productId;
	private String productQuantity;
	private String productPrice;
	private String productWeight;
	private String productSupplier;
	private String productCategory;
	private String productReceiveDate;
	private String productExpireDate;
	private String productCostPrice;
	
	public Product (String productName,String productId, String productQuantity, String productPrice, String productWeight,
			String productSupplier, String productCategory, String productReceiveDate, String productExpireDate,
			String productCostPrice)
	{
		this.setProductName(productName);
		this.setProductId(productId);
		this.setProductQuantity(productQuantity);
		this.setProductPrice(productPrice);
		this.setProductWeight(productWeight);
		this.setProductSupplier(productSupplier);
		this.setProductCategory(productCategory);
		this.setProductReceiveDate(productReceiveDate);
		this.setProductExpireDate(productExpireDate);
		this.setProductCostPrice(productCostPrice);
		
	}
	
	public Product() {}
	
	public void writeToTextFileFromList(List<Product> productList)
	{
		 try {
	            FileWriter writer = new FileWriter("Products.txt");
	    		for (Product newProduct : productList)
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

	public void saveToFileFromList (List<Product> productList) 
	{
  	  try
  	  {
  		File productsFile = new File("productList.dat");
  		String filePath = productsFile.getPath();
		FileOutputStream fout = new FileOutputStream(filePath/*, true ); if we want to append to the file*/);
		ObjectOutputStream outputStream = new ObjectOutputStream(fout);
		for (Product newProduct : productList)
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
	
	public List<Product> loadItemList()
	{
		List<Product> productList= new ArrayList<Product>();
  		try 
  		{
  	  		File itemsFile = new File("productList.dat");
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(String productWeight) {
		this.productWeight = productWeight;
	}

	public String getProductSupplier() {
		return productSupplier;
	}

	public void setProductSupplier(String productSupplier) {
		this.productSupplier = productSupplier;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductReceiveDate() {
		return productReceiveDate;
	}

	public void setProductReceiveDate(String productReceiveDate2) {
		this.productReceiveDate = productReceiveDate2;
	}

	public String getProductExpireDate() {
		return productExpireDate;
	}

	public void setProductExpireDate(String productExpireDate) {
		this.productExpireDate = productExpireDate;
	}
	
	public String getProductCostPrice() {
		return productCostPrice;
	}

	public void setProductCostPrice(String productCostPrice) {
		this.productCostPrice = productCostPrice;
	}



	public int GetIntCostPrise()
	{
		int IntCostPrice;
		try
		{
			IntCostPrice = Integer.parseInt(this.productCostPrice);
		}
		catch (NumberFormatException e)
		{
			IntCostPrice = 0;
		}
		
		return IntCostPrice;
	}
	


	public int GetIntPrise()
	{
		int IntSellPrice;
		try
		{
			IntSellPrice = Integer.parseInt(this.productPrice);
		}
		catch (NumberFormatException e)
		{
			IntSellPrice = 0;
		}
		
		return IntSellPrice;
	}
}

