package AutomationCasesProject.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationCasesProject.AbstarctComponents.AbstractComponents;

public class CheckOut extends AbstractComponents{

	WebDriver driver;
	public CheckOut(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countrySelect;
	
	@FindBy(xpath="//a[contains(text(),'Place Order ')]")
	WebElement placeOrder;
	
	@FindBy(xpath="//section[contains(@class,'ta-results')]/button/span")
	List<WebElement> selectCountry;
	
	public void selectCountry(String countryName)
	{
		countrySelect.sendKeys(countryName);
		for(int i=0;i<selectCountry.size();i++)
		{
			String result=selectCountry.get(i).getText();
			if(result.equalsIgnoreCase(countryName))
			{
				selectCountry.get(i).click();
			}
		}
	}
	
	public ConfirmationPage submitOrder()
	{
		placeOrder.click();
		ConfirmationPage c=new ConfirmationPage(driver);
		return c;
	}
	
	

}
