package TestingAcademy;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import TestingAcademy.TestComponets.BaseTest;

public class ErrorValidation extends BaseTest{

	@Test(groups= {"ErrorHandling"})
	public void LoginPageErrorValidation () throws IOException 
	{
		// TODO Auto-generated method stub
		
		landingpage.loginApplication("hs16@gmail.com" ,"@Test12345");
		Assert.assertEquals("Login was unsuccessful correct errors and try again.",landingpage.getErrorMessage());	    
		
	}
	@Test
	public void ProductPageErrorValidation () throws IOException 
	{
		// TODO Auto-generated method stub
		String productName = "Casual Golf Belt";
		ProductCatelogue productCatelogue = landingpage.loginApplication("ruksar@gmail.com" ,"@Test12345");
		List<WebElement> products=productCatelogue.getProductList();
		productCatelogue.addProductToCart(productName);
		CartPage cartpage= productCatelogue.goToCart();
		Boolean match = cartpage.VerifyProductDisply(productName);
		Assert.assertTrue(match);
		
		}
		
		
	    
		
	

}
