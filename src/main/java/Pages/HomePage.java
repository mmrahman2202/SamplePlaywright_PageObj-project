package Pages;

import java.util.Properties;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private String selectCustomer="//select[@id='userSelect']";
	private String selectForm="//a[text()='Sample Form']";
	private String logincustomer="//button[text()='Customer Login']";
	private String loginMgr="//a[text()='Bank Manager Login']";
	private String loginLife="//a[text()='Lifetime Membership']";
	private Page page;
    private Properties prop;
    
	public HomePage(Page page ) {
		this.page = page;
		

	}
    public String getTitle() {
      
      System.out.println(page.title());
      String title=page.title();
      return title;
    }

	public String getUrl() {
		System.out.println(page.url());
		String Url=page.url();
		return Url;
	}
	/*
	public void navigate(String url) {
		page.navigate(prop.getProperty(url));
	}
	*/
	public RegstFormPage clickForm() {
		page.click(selectForm);
		return new RegstFormPage(page);
	}

	public CustLogin clickCustomerLogin() {
		page.click(logincustomer);
		return new CustLogin(page);
	}
	public AccountPage navigateToAccPage() {
		page.click(logincustomer);
		page.locator(selectCustomer);
		page.locator(selectCustomer).selectOption("2");
		page.click("button[type='submit']");
		return new AccountPage(page);
	}
}
