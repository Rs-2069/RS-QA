package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestingAcademy.CartPage;
import TestingAcademy.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//a[@class='ico-cart'])[1]")
	WebElement cartHeader;
	
	@FindBy(css=".ico-logout")
	WebElement Logout;
	
	@FindBy(css="a[href='/customer/orders']")
	WebElement OrderHeader;
	
	public CartPage goToCart()
	{
		cartHeader.click();
		CartPage cartpage =new CartPage(driver);
		return cartpage;
	}
	public OrderPage goToOrderPage()
	{
		OrderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	public void Logout() 
	{
		Logout.click();
	}
	public void WaitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void WaitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	public void WaitForElementToDisAppear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	public void WaitForElementToDisAppear1(By spinner)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
		
	}
	public void WaitForElementToBeClickable(WebElement opt)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.elementToBeClickable(opt));
	}
}
