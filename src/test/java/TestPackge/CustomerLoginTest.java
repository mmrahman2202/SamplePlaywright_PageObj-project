package TestPackge;

import org.testng.annotations.Test;

import Pages.CustLogin;

public class CustomerLoginTest extends BaseClass {
	//CustLogin cl = hp.clickCustomerLogin();
	
	@Test(priority=1)
	public void checkTitle() {

		CustLogin cl = hp.clickCustomerLogin();
		cl.getCustLoginTitle();
		cl.getCustLoginUrl();
	}
	@Test(priority=2)
	public void checkCustomer() {
	
		cl.selectCust();
		String name=prop.getProperty("firstName");
		System.out.println("my config name is: "+name);
	}
	

}
