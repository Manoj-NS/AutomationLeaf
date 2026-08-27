package leaf_pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
//Constructor	
	public WelcomePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
	
//Locators
	
	@FindBy(xpath="//h2[normalize-space(.)='Welcome Demo B2B CSR']")
	WebElement welcomeText;
	
	@FindBy(id="logout")
	WebElement logoutBtn;
	
	@FindBy(xpath="//a[normalize-space(text())='CRM/SFA']")
	WebElement crmLink;
	

//Action Methods
	
	public boolean isWelcomeTextDisplayed() {
		return welcomeText.isDisplayed();
	}
	
	public boolean logoutButton() {
		return logoutBtn.isDisplayed();
	}
	
	public boolean crmsfaLink() {
		return crmLink.isDisplayed();
	}
	
	public HomePage clickCRMSFALink() {
		crmLink.click();
		return new HomePage(driver);
	}
	

}
