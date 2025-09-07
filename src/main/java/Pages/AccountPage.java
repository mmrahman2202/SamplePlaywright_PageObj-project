package Pages;

import com.microsoft.playwright.Page;

public class AccountPage {
 private Page page;
	public AccountPage(Page page) {
		this.page= page;
	}

	public String getAccountTitle() {
		System.out.println(page.title());
		String title = page.title();
		return title;
	}

	public String getAccountUrl() {
		System.out.println(page.url());
		String Url = page.url();
		return Url;
		
	}

	public String checkWelcomeMsg() {
		String msg=page.locator("strong:has-text('Welcome')").textContent();
		System.out.println(msg);
		return msg;
	}

	public String depositAmount() {
		page.click("button[ng-click='deposit()']");
		page.fill("input[ng-model='amount']", "5000");
		page.click("button[type='submit']");
		String msg = page.locator("span[ng-show='message']").textContent();
		System.out.println(msg);
		return msg;
	}

}
