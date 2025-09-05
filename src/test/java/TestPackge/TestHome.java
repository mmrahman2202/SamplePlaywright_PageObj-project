package TestPackge;

import org.testng.annotations.Test;

import org.testng.Assert;

public class TestHome extends BaseClass{
	
	
	@Test(priority=1)
	public void testHomePageTitle() {
		
		String tit=hp.getTitle();
		Assert.assertEquals(tit, "Protractor practice website - Banking App");

	}
	@Test(priority=2)
	public void checkUrl() {
		String URL=hp.getUrl();
		Assert.assertEquals(URL,prop.getProperty("url")); 
				//"https://www.way2automation.com/angularjs-protractor/banking/#/login");
	}
	//@Test(priority=3)
	//public void clickRegForm() {
	//	hp.clickForm();
	//}
  
	   
	
}
