package AutomationCasesProject.TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import AutomationCasesProject.TestComponents.BaseTest;
import AutomationCasesProject.TestComponents.Retry;
import AutomationCasesProject.pageobjects.CartPage;
import AutomationCasesProject.pageobjects.CheckOut;
import AutomationCasesProject.pageobjects.ConfirmationPage;
import AutomationCasesProject.pageobjects.LandingPage;
import AutomationCasesProject.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class rahulShettyWebsiteCases extends BaseTest{

	
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void clientStart(HashMap<String,String> input) throws InterruptedException, IOException
	{
		
		
		//landingPage.loginApplication("akshay1999@gmail.com", "Akshay123");
		
		ProductCatalogue prouductCatalogue=landingPage.loginApplication(input.get("email"), input.get("password"));
		String res=input.get("product");
		String addedProduct=prouductCatalogue.addProductToCart(res);
        System.out.println(addedProduct);
		String productVerification=prouductCatalogue.productAddedVerify();
		Assert.assertEquals(productVerification,"Product Added To Cart");
		 Thread.sleep(5000);
		CartPage cp=prouductCatalogue.goToCart();
		boolean addedVerify=cp.verifySelectedProduct(addedProduct);
		Assert.assertTrue(addedVerify);
		String country="India";
		CheckOut co=new CheckOut(driver);
		co.selectCountry(country);
		ConfirmationPage cp1=co.submitOrder();
		String confirmationOrder=cp1.getConfiramtionMessage();
		Assert.assertEquals(confirmationOrder, "Thankyou for the order.");
		
		
	}
	
	    @Test(groups= {"MouseHover"},retryAnalyzer=Retry.class)
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
	    
	    //@Parameters({ "URL" })
	    @Test(dataProvider="getDataFrom")
	    public void printtheValue(String name,String lastname)
	    {
	    	System.out.println(name);
	    	System.out.println(lastname);
	    	
	    }
	    
	    @DataProvider
	    public Object[][] getDataFrom()
	    {
	    	/*
	    	HashMap<String,String>hm=new HashMap<>();
	    	hm.put("email","password123@");
	    	hm.put("password","pas12");
	    	hm.put("Name","Akshay");
	    	*/
	    	Object [][] data=new Object[2][2];
	    	data[0][0]="Akshay";
	    	data[0][1]="Raghotham";
	    	data[1][0]="1";
	    	data[1][1]="Raghotham1";
	    	
	    	
			return data;
	    }
	    
	    
	    @DataProvider
	    public Object[][] getData() throws IOException
	    {
	    	List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//AutomationCasesProject//jsondataprovider//PurchaseInfo.json");
	    	
	    	return new Object [][] {{data.get(0)},{data.get(1)}};
	    	
	    }

	    @SuppressWarnings("deprecation")
		@Test
	    public void autoITAutomation() throws InterruptedException, IOException
	    {
	    	landingPage.uploadFile();
	    	Thread.sleep(3000);
	    	Runtime.getRuntime().exec("D:\\FileUpload\\fileUpload.exe");
	    }

}
