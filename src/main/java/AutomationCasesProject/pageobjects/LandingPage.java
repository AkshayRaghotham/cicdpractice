package AutomationCasesProject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationCasesProject.AbstarctComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement userPassword;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement submit;
	
	@FindBy(xpath="//a[@class='uploader__btn tooltip--left active']")
	WebElement fileUploader;

	public ProductCatalogue loginApplication(String e, String p)
	{
		userEmail.sendKeys(e);
		userPassword.sendKeys(p);
		submit.click();
		ProductCatalogue prouductCatalogue=new ProductCatalogue(driver);
		return prouductCatalogue;
	}
	
	public void goTo()
	{
		driver.get("https://www.ilovepdf.com/powerpoint_to_pdf");
	}
	
	public void uploadFile()
	{
		fileUploader.click();
	}
	
	
}
