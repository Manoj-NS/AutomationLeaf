package leaf_test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import leaf_base.BaseClass;
import leaf_pages.HomePage;
import leaf_pages.LoginPage;
import leaf_pages.WelcomePage;

public class HomeTest extends BaseClass {
	
	LoginPage loginP;
	WelcomePage welcomeP;
	HomePage homeP;
	
	@BeforeMethod()
	public void pageSetup() {
		loginP=new LoginPage(driver);
		welcomeP=new WelcomePage(driver);
		homeP=new HomePage(driver);
	}
	
	@Test(dataProvider="loginData", dataProviderClass=leaf_dataproviders.DataProviders.class)
	public void homepageTest(String username, String password) {
		//LoginPage			
				loginP.enterUser(username);
				loginP.enterPassword(password);
				loginP.clickLogin();
				
			//WelcomPage
				welcomeP.clickCRMSFALink();			
		
		   //HomePage
				Assert.assertTrue(homeP.verifyHomePage(), "My Home");
				homeP.clickLeads();
	}

}
