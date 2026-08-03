package leaf_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
//Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//Locators	
		
	@FindBy(xpath="//form[@id='login']//p/label[@for='username']/following-sibling::input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath="//form[@id='login']//p/label[@for='password']/following-sibling::input[@id='password']")
	WebElement passWord;
	
	@FindBy(xpath="//form[@id='login']//p/input[@value='Login']")
	WebElement login;
	
	
//Action Methods
	
	public void enterUser(String user) {
		userName.sendKeys(user);
	}
	
	public void enterPassword(String password) {
		passWord.sendKeys(password);
	}

	public WelcomePage clickLogin() {
		login.click();
		return new WelcomePage(driver);
	}

}

