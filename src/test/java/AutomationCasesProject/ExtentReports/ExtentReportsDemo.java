package AutomationCasesProject.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo {

	@Test
	public void Demo()
	{
		 
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 System.out.println(driver.getTitle());
	}
}
