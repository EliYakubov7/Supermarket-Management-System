package All;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Invoice implements java.io.Serializable
{
	private String m_CustomerId;
	private int m_InvoiceNumber;
	private String m_InvoiceData;
	private List <ProductInCart> m_ProductsList = new ArrayList<ProductInCart>();
	private double m_TotalPrice;
	
	Invoice(String i_CustomerId, int i_InvoiceNumber, List <ProductInCart> i_ProductsList, String i_InvoiceData, double i_TotalProce)
	{
		m_CustomerId = i_CustomerId;
		m_InvoiceNumber = i_InvoiceNumber;
		m_ProductsList = i_ProductsList;
		m_InvoiceData = i_InvoiceData;
		m_TotalPrice = i_TotalProce;
	}

	public int getInvoiceNumber() 
	{
		return m_InvoiceNumber;
	}


	public String getInvoiceData()
	{
		return m_InvoiceData;
	}

	public List <ProductInCart> getProductsList() {
		return m_ProductsList;
	}

	public double getTotalPrice() {
		return m_TotalPrice;
	}

	public String getCustomerId() {
		return m_CustomerId;
	}

}
