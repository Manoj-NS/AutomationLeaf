package leaf_utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public Object[][] loginData(){
		return new Object[][] {
			{"DemoCSR", "crmsfa"}
		};
	}

}
