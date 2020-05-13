package All;

import javax.swing.ComboBoxModel;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Controller {
	private Factory m_Factory = new Factory();
	private Model m_Model = m_Factory.createModel();
	
	public void addUser(User i_TemporaryUser)
	{
		m_Model.addUser(i_TemporaryUser);
	}

	public void updateUser(String i_UserID, String i_UserAddress, String i_UserEmail, String i_UserFirstName, String i_UserLastName, String i_UserPhoneNumber) {
		m_Model.updateUser(i_UserID, i_UserAddress, i_UserEmail, i_UserFirstName, i_UserLastName, i_UserPhoneNumber);		
	}

	public void deleteUser(String i_UserId) {
		m_Model.deleteUser(i_UserId);
	}

	public User searchUser(String i_UserId) {
		return m_Model.searchUser(i_UserId);
	}

	public void addProduct(Product i_NewProduct) {
		m_Model.addProduct(i_NewProduct); 
		
	}

	public void updateProduct(Product i_NewProduct) {
		m_Model.updateProduct(i_NewProduct);
		
	}

	public Product searchProduct(String i_ProductId) {
		return m_Model.searchProduct(i_ProductId);
	}

	public void deleteProduct(String i_ProductId) {
		m_Model.deleteProduct(i_ProductId);
		
	}

	public void addCustomer(Customer i_NewCustomer) {
		m_Model.addCustomer(i_NewCustomer); 
		
	}

	public void deleteCustomrt(String i_CustomerId) {
		m_Model.deleteCustomer(i_CustomerId);
		
	}

	public Customer searchCustomer(String i_CustomerId) {
		return m_Model.searchCustomer(i_CustomerId);
		
	}

	public void updateCustomer(Customer i_NewCustomer) {
		m_Model.updateCustomer(i_NewCustomer); 
		
	}

	public String[] getCategoryList() {
		return m_Model.getCategoryList();
	}

	public String[] getProductsToComboBox(String i_ProductCategorty) 
	{
		return m_Model.getProductsToComboBox(i_ProductCategorty);
	}
	
	public String getFirstLineInInvoice()
	{
		return m_Model.getFirstLineInInvoice();
	}
	
	public String getInvoiceSeparatLine()
	{
		return m_Model.getInvoiceSeparatLine();
	}
	
	public String addProductToInvoice(String i_ProductName, int i_ProductQuantity)
	{
		return m_Model.addProductToInvoice(i_ProductName, i_ProductQuantity);
	}

	public String getInvoiceTotalPrice() {
		return String.valueOf(m_Model.getInvoiceTotalPrice());
	}

	public String payInvoice(double i_AmountToPay, String i_CustomerId, String i_InvoiveData, double i_Totalprice)
	{
		return m_Model.payInvoice(i_AmountToPay, i_CustomerId, i_InvoiveData, i_Totalprice);
	}

	public String[] getInvoiceNumbers(String i_CustomerId) {
		return m_Model.getInvoiceNumbers(i_CustomerId);
	}

	public String getInvoice(String i_SelectedInvoiceNumber) {
		return m_Model.getInvoice(i_SelectedInvoiceNumber);
	}

	public String getReport() {
		return m_Model.getReport();
	}
	
	public void updateInventory(String i_ProductId, String i_ExpiredDate, String i_ProductName, String i_ProductQuantity, String i_ReciveDate, String i_Supplier) 
	{
		m_Model.updateInventory(i_ProductId, i_ExpiredDate, i_ProductName, i_ProductQuantity, i_ReciveDate, i_Supplier); 
	}

	public void saveInventory(String i_ExpiredDate, String i_ReceiveDate, String i_ProductID, String i_EnterNewQuantity) 
	{
		m_Model.saveInventory(i_ExpiredDate, i_ReceiveDate, i_ProductID, i_EnterNewQuantity);
	}

	public String getStockReport()
	{
		return m_Model.getStockReport();
	}

	public String getSalariesReport() {
		return m_Model.getSalariesReport() ;
	}
}





