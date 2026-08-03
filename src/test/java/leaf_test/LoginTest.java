package leaf_test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import leaf_base.BaseClass;
import leaf_pages.LoginPage;


public class LoginTest extends BaseClass{
		
		LoginPage loginP;
		
		@BeforeMethod
		public void pageSetup() {
			loginP=new LoginPage(driver);
			
		}
		
		@Test(dataProvider="loginData", dataProviderClass=leaf_dataproviders.DataProviders.class)
		public void verifyLogin(String username, String password) {
		//LoginPage			
			loginP.enterUser(username);
			loginP.enterPassword(password);
			loginP.clickLogin();
			
		}

}
