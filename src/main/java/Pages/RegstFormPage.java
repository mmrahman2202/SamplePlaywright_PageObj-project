package Pages;

import java.util.Properties;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class RegstFormPage {
	
	private Page page;
	//SetUpPlaywright sp;
	private String firstName ="input#firstName";
	private String lastName ="input#lastName";
	private String email= "input#email";
	private String password = "input#password";
	private String gender = "select#gender option[value='male']";
    private Properties prop;
    
	public RegstFormPage(Page page) {
		this.page = page;
	}
	
	public String getRegTitle() {
		System.out.println(page.title());
		String title = page.title();
		return title;
	}

	public String getRegUrl() {
		System.out.println(page.url());
		String Url = page.url();
		return Url;
	}
	public void register() {
		//HomePage hp=new HomePage(page);
		//hp.clickForm();
      // page= sp.openBrowser();  
       page.fill(firstName, "firstName");
       page.fill(lastName,"lastName");
       page.fill(email, "mofiz-email@gmail.com");
       page.fill(password,"password");
      // page.locator("//input[@type='checkbox']").check();
       page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Reading")).check();
       Locator GendSelect=page.locator("//select[@id='gender']");
       GendSelect.selectOption("male");
      
       page.locator("//textarea[@id='about']").fill("I am a software tester");
       page.click("button[type='submit']");
       String mesg= page.locator("div#errorMessage").textContent();
       System.out.println(mesg);
       
     }
}