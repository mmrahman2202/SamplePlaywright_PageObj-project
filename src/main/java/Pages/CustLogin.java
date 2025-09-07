package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CustLogin {
	private String selectCustomer="//select[@id='userSelect']";
	private Page page;
	
	public CustLogin(Page page) {
		this.page = page;

	}

	
	public String getCustLoginTitle() {
		System.out.println(page.title());
		String title = page.title();
		return title;
	}

	public String getCustLoginUrl() {
		System.out.println(page.url());
		String Url = page.url();
		return Url;
	}
	public AccountPage selectCust() {
		Locator customer= page.locator(selectCustomer);
		customer.selectOption("2");
		page.click("button[type='submit']");
		return new AccountPage(page);
	}
}
