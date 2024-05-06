package AutomationCasesProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationCasesProject.AbstarctComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='cart']/ul/li/div/div[@class='cartSection']/h3")
	List<WebElement> cartList;
	By cartListAppear=By.xpath("//div[@class='cart']/ul/li/div/div[@class='cartSection']/h3");
	
	@FindBy(xpath="//div[@class='cart']/ul/li/div/div[@class='cartSection removeWrap']/button[@class='btn btn-primary']")
	List<WebElement> buyNow;
	
	
	public boolean verifySelectedProduct(String productName)
	{
		
		waitForElementToAppear(cartListAppear);
		for(int i=0;i<cartList.size();i++)
		{
			String answer=cartList.get(i).getText();
			System.out.println(answer);
			if(answer.equalsIgnoreCase(productName))
			{
				//waitForElementToAppear()
				buyNow.get(i).click();
			     return true;
			}
			
		}
		return false;
	}
	
	

}
