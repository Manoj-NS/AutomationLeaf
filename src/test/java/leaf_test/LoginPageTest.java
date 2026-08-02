package leaf_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import leaf_base.BaseClass;
import leaf_dataproviders.DataProviders;
import leaf_pages.LoginPage;
import leaf_pages.WelcomePage;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginP;
	WelcomePage welcomeP;

	
	@BeforeMethod
	public void pageSetup() {
		loginP=new LoginPage(driver);
		welcomeP=new WelcomePage(driver);

	}
	
	@Test(dataProvider="loginData", dataProviderClass=DataProviders.class)
	public void verifyLogin(String username, String password) {
	//LoginPage			
		loginP.loginDetails(username, password);
		
	//WelcomPage	
		Assert.assertTrue(welcomeP.logoutButton(), "Logout button not displayed");
		Assert.assertTrue(welcomeP.crmsfaLink(), "CRMSFA link not displayed");
		
	}

}
