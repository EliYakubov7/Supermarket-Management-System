package All;

public class ProductInCart implements java.io.Serializable
{
	
	private String m_ProductId;
	private String m_ProductName;
	private int m_ProductQuantity;
	private String m_ProductPrice;
	
	
	ProductInCart(String i_ProductId, String i_ProductName, int i_ProductQuantity, String i_ProductPrice)
	{
		m_ProductId = i_ProductId;
		m_ProductName = i_ProductName;
		m_ProductQuantity = i_ProductQuantity;
		m_ProductPrice = i_ProductPrice;
	}
	
	
	public String getM_ProductId()
	{
		return m_ProductId;
	}
	
	public void setM_ProductId(String i_ProductId) 
	{
		this.m_ProductId = i_ProductId;
	}
	
	public String getM_ProductName()
	{
		return m_ProductName;
	}
	
	public void setM_ProductName(String i_ProductName)
	{
		this.m_ProductName = i_ProductName;
	}
	
	public int getM_ProductQuantity()
	{
		return m_ProductQuantity;
	}
	
	public void setM_ProductQuantity(int i_ProductQuantity)
	{
		this.m_ProductQuantity = m_ProductQuantity;
	}


	public String getProductPrice() {
		return m_ProductPrice;
	}


	
	

}
