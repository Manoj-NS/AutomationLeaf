package leaf_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
//Constructor	
	public HomePage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//Locators
	@FindBy(xpath="//div[contains(text(),'My Home')]")
	WebElement HomeLink;
	
	@FindBy(xpath="//a[contains(text(),'Leads')]")
	WebElement leadsLink;
	
//Action Methods	
	public boolean verifyHomePage() {
		return HomeLink.isDisplayed();
	}
	
	public LeadsPage clickLeads() {
		
		leadsLink.click();
		return new LeadsPage(driver);
		
	}

}
