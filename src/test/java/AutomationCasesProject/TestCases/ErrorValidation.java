package AutomationCasesProject.TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import AutomationCasesProject.TestComponents.BaseTest;
import AutomationCasesProject.pageobjects.CartPage;
import AutomationCasesProject.pageobjects.CheckOut;
import AutomationCasesProject.pageobjects.LandingPage;
import AutomationCasesProject.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest{

	@Test
	public void clientStart() throws InterruptedException, IOException
	{
		
		
		//landingPage.loginApplication("akshay1999@gmail.com", "Akshay123");
		ProductCatalogue prouductCatalogue=landingPage.loginApplication("akhay1999@gmail.com", "Aksha123");
		
		
	}
	
	    @Test
		public void verifyMouseHover()
		{
	    	WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
	        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	        driver.manage().window().maximize();
	        JavascriptExecutor js=(JavascriptExecutor)driver;
	        js.executeScript("window.scrollBy(0,1000)");
	        Actions a=new Actions(driver);
	        a.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).build().perform();
	        driver.close();
		}


}
