package TestPackge;

import org.testng.Assert;
import org.testng.annotations.Test;

//import Pages.CustLogin;
//import Pages.AccountPage;
public class AcctPageTesting  extends BaseClass {
	
	@Test(priority=1)
	public void accountDetails() {
		hp.navigateToAccPage();
		ac.getAccountTitle();
		ac.getAccountUrl();
		// ac.accountDetails();
	} 
	@Test(priority=2)
	public void welcomeMsg() {
		String msg=ac.checkWelcomeMsg();
		Assert.assertTrue(msg.contains("Welcome"));
	}
   @Test(priority=2)
   public void depositTest() {
	   String msg=ac.depositAmount();
	   Assert.assertTrue(msg.contains("Deposit Successful"));
   }
  
}
