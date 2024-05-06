package AutomationCasesProject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationCasesProject.AbstarctComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
   
	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement confirmationTest;
    
	public String getConfiramtionMessage()
	{
		return confirmationTest.getText();
	}
	
	
}
