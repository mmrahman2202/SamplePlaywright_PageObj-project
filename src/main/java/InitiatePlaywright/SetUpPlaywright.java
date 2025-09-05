package InitiatePlaywright;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SetUpPlaywright {
	
	

	 Playwright playwright;
	 Browser browser;	
	 BrowserContext context;
	 Page page;
	private String selectedBrowser;
	public Properties prop; 
	// For ThreadLocal Implementation
	private static ThreadLocal<Playwright> tlocalPlaywright=new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> thlocalBrowserCont=new ThreadLocal<>();
	private static ThreadLocal<Browser> thlocalBrowser=new ThreadLocal<>();
	private static ThreadLocal<Page> thlocalPage=new ThreadLocal<>();

	public static Playwright getPlaywright() {
		return tlocalPlaywright.get();
	}

	public static Browser getBrowser() {
		return thlocalBrowser.get();
	}

	public static BrowserContext getContext() {
		return thlocalBrowserCont.get();
	}

	public static Page getPage() {
		return thlocalPage.get();
	}
	
	
	public Page openBrowser() {
	 // playwright = Playwright.create();	
	  tlocalPlaywright.set(Playwright.create());
	 selectedBrowser=prop.getProperty("browser");
	 switch (selectedBrowser.toLowerCase()) {
	 case "chromium": 
           
           // browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		     thlocalBrowser.set( getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
            System.out.println("Launching in Chromium Browser");
            break;
        case "chrome":
           
           // browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        	 thlocalBrowser.set( getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
            System.out.println("Launching in Chrome Browser");
            break;
        case "firefox":
           
           // browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        	 thlocalBrowser.set( getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
            System.out.println("Launching in Firefox Browser");
            break;
        case "edge":
           
           // browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
        	 thlocalBrowser.set( getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false)));
            System.out.println("Launching in Edge Browser");
            break;
        default:
            throw new IllegalArgumentException("Unsupported browser: " + selectedBrowser);
        }
	
	    // context = browser.newContext();
	     thlocalBrowserCont.set(getBrowser().newContext());
	     //page = context.newPage();
	     thlocalPage.set(getContext().newPage());
	     getPage().navigate(prop.getProperty("url").trim());
	     return getPage();
}	
	
	public void getConfig() {
		try {
			FileInputStream fl=new FileInputStream("./src/test/resources/ConfigFiles/Config.properties");
			prop =new Properties();
			try {
				prop.load(fl);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	
	
}


