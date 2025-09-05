package TestPackge;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import InitiatePlaywright.SetUpPlaywright;
import Pages.AccountPage;
import Pages.CustLogin;
import Pages.HomePage;
import Pages.RegstFormPage;
//import Pages.RegstPage;

public class BaseClass {
	
	SetUpPlaywright sp;
	Page page;
	CustLogin cl;
	HomePage hp;
	RegstFormPage rg;
	AccountPage ac;
	protected Properties prop;
	@BeforeTest
	public void testSetup() {
		sp = new SetUpPlaywright();
		
		sp.getConfig();
		page=sp.openBrowser();
		cl=new CustLogin(page);
	    hp=new HomePage(page);	
	    rg= new RegstFormPage(page);
	    ac=new AccountPage(page);
	    prop=sp.prop;
	}
	@AfterTest
	public void tearDown() {
		page.context().close();
		page.close();
	}

}
