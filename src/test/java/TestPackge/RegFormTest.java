package TestPackge;

import org.testng.annotations.Test;

public class RegFormTest extends BaseClass {

	@Test
	public void regFormDetails() {
		hp.clickForm();
		rg.getRegTitle();
		rg.getRegUrl();
		rg.register();

	}
	
	

}
