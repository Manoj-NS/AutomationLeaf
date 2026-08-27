package leaf_base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import leaf_utilities.ExtentManager;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger=LogManager.getLogger(BaseClass.class);
	
	@BeforeSuite
	public void startReport() {
		
		ExtentManager.setupReport();
		
	}
	
	@Parameters({"browser", "url"})
	@BeforeMethod
	public void browserSetup(String browser, String url) {
	
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
	
//To avoid browser popup and chrome UI popup
			
			ChromeOptions options = new ChromeOptions();

	        Map<String, Object> prefs = new HashMap<>();

	        prefs.put("credentials_enable_service", false);
	        prefs.put("profile.password_manager_enabled", false);
	        prefs.put("profile.password_manager_leak_detection", false);

	        options.setExperimentalOption("prefs", prefs);

	        options.addArguments(
	                "--disable-features=PasswordLeakDetection"
	        );
			 
			driver = new ChromeDriver(options);
/*			
			ChromeOptions options=new ChromeOptions();  //for headless mode(no browser launch)
			options.addArguments("--headless=new");
			driver=new ChromeDriver(options);
*/			
			
			
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
	
		}else {
			throw new RuntimeException("Browser Not Supported");
		}
		logger.info("Launched Browser: "+ browser);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		driver.get(url);
		logger.info("Navigated to URL: "+url);
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
			logger.info("Browser closed");
		}
	}
	
	@AfterSuite
	public void endReport() {
		ExtentManager.tearDownReport();
	}
	

}
