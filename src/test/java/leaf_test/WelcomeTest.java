package leaf_test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import leaf_base.BaseClass;
import leaf_pages.LoginPage;
import leaf_pages.WelcomePage;

public class WelcomeTest extends BaseClass{
	
	LoginPage loginP;
	WelcomePage welcomeP;

	
	@BeforeMethod
	public void pageSetup() {
		loginP=new LoginPage(driver);
		welcomeP=new WelcomePage(driver);
		
	}
	
	@Test(dataProvider="loginData", dataProviderClass=leaf_dataproviders.DataProviders.class)
	public void verifyLogin(String username, String password) {
	//LoginPage			
		loginP.enterUser(username);
		loginP.enterPassword(password);
		loginP.clickLogin();
		
	//WelcomPage
		Assert.assertTrue(welcomeP.isWelcomeTextDisplayed(), "Welcome Demo B2B CSR");
		Assert.assertTrue(welcomeP.logoutButton(), "Logout button not displayed");
		Assert.assertTrue(welcomeP.crmsfaLink(), "CRMSFA link not displayed");
		welcomeP.clickCRMSFALink();		
	}
}
