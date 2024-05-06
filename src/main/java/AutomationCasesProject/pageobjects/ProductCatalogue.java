package AutomationCasesProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationCasesProject.AbstarctComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='card-body']/h5/b")
	List<WebElement> products;
	
	@FindBy(xpath="//div[@class='card-body']/button[2]")
	List<WebElement> cartButtonList;
	
	@FindBy(xpath="//div[contains(text(),'Product Added To Cart')]")
	WebElement productText;
	
	By productBox=By.xpath("//div[contains(text(),'Product Added To Cart')]");
	By productList=By.xpath("//div[@class='card-body']/h5/b");
	
	public String addProductToCart(String productName)
	{
		waitForElementToAppear(productList);
		String result="";
		for(int i=0;i<products.size();i++)
		{
			String ans=products.get(i).getText();
			if(ans.equalsIgnoreCase(productName))
			{
			     result =products.get(i).getText();
			     cartButtonList.get(i).click();
			}
		}
		return result;
	}
	
	public String productAddedVerify()
	{
		waitForElementToAppear(productBox);
		String productVerification =productText.getText();
		return productVerification;
		
	}
}
