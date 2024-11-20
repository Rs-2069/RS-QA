package TestingAcademy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestingAcademy.TestComponets.BaseTest;

public class StandAloneTest extends BaseTest{
	String productName = "Casual Golf Belt";
	
	@Test(dataProvider="getData", groups = {"PurchesOrder"}) 
	 public void SubmitOrder(HashMap<String,String> input) throws IOException {
		
		
		ProductCatelogue productCatelogue = landingpage.loginApplication(input.get("email"), input.get("Password"));	
		List<WebElement> Products = productCatelogue.getProductList();
		productCatelogue.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatelogue.goToCart();	
		Boolean match = cartPage.VerifyProductDisply(input.get("productName"));
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartPage.gotoCheckOut();
		checkoutpage.billingAdd();
		checkoutpage.shippingAdd();
		checkoutpage.shippingMethod();
		checkoutpage.PaymentMethod();
		checkoutpage.PaymentInfo();
		ConfirmationPage confirmationPage = checkoutpage.ConfirmOrder();
		String ConfirmMessage = confirmationPage.GetConfirmationMessage();
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("Your order has been successfully processed!"));
		confirmationPage.ContinueShopping();
		confirmationPage.Logout();
		
	}
	
		
	@Test(dependsOnMethods = {"SubmitOrder()"})
	 public void OrderHistory() {
		ProductCatelogue productCatelogue = landingpage.loginApplication("hs16@gmail.com", "@july17");
		OrderPage OrderPage = productCatelogue.goToOrderPage();
		Assert.assertTrue(OrderPage.VerifyOrderDisplay(productName));
	}
		@DataProvider
	public Object[][] getData() throws IOException
	{

			List<HashMap<String,String>> data = getJSONNData(System.getProperty("user.dir")+"\\src\\test\\java\\Testing\\Data\\PurchesOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
		

}
