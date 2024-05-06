package AutomationCasesProject.AbstarctComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomationCasesProject.pageobjects.CartPage;

public class AbstractComponents {
    WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartIcon;

	public void waitForElementToAppear(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public CartPage goToCart()
	{
		cartIcon.click();
		CartPage cp=new CartPage(driver);
		return cp;
	}
	
	

}
