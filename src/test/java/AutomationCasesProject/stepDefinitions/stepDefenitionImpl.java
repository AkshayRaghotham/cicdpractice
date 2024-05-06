package AutomationCasesProject.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import AutomationCasesProject.TestComponents.BaseTest;
import AutomationCasesProject.pageobjects.CartPage;
import AutomationCasesProject.pageobjects.CheckOut;
import AutomationCasesProject.pageobjects.ConfirmationPage;
import AutomationCasesProject.pageobjects.LandingPage;
import AutomationCasesProject.pageobjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefenitionImpl extends BaseTest {

	public LandingPage landingPage;
	public 	ProductCatalogue prouductCatalogue;
	public CartPage cp;
	public ConfirmationPage cp1;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage=launchApplication();
	}
	
	@Given("Logged in with username (.+) and (.+)")
	public void logged_in_with_username_and_password(String username,String password) throws IOException
	{
	   prouductCatalogue=landingPage.loginApplication(username,password);
	}
	
	@When("I add product (.+) TO cart")
	public void i_add_product_tocart(String productName)
	{
		String addedProduct=prouductCatalogue.addProductToCart(productName);
        System.out.println(addedProduct);
		String productVerification=prouductCatalogue.productAddedVerify();
		Assert.assertEquals(productVerification,"Product Added To Cart");
	}
	
	@And("checkout (.+) and submit the order")
	public void check_submit_order(String product)
	{
		cp=prouductCatalogue.goToCart();
		boolean addedVerify=cp.verifySelectedProduct(product);
		Assert.assertTrue(addedVerify);
		String country="India";
		CheckOut co=new CheckOut(driver);
		co.selectCountry(country);
		cp1=co.submitOrder();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmation(String string)
	{
		String confirmationOrder=cp1.getConfiramtionMessage();
		Assert.assertEquals(confirmationOrder, "Thankyou for the order.");
	}
	

}
