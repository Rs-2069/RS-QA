package TestingAcademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="checkout")
	WebElement checkOutButton;
	
	@FindBy(css ="#termsofservice")
	WebElement termsofservice;
	
	@FindBy(css=".product-name")
	private List<WebElement> cartProducts;
	
	public Boolean VerifyProductDisply(String productName)
	{
		Boolean match= cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	
	}
	public CheckOutPage gotoCheckOut()
	{
		termsofservice.click();
		checkOutButton.click();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		return checkoutpage;
	}
	
}
