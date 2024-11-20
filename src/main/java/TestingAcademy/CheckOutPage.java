package TestingAcademy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	
	WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath = "//select[@id='billing-address-select']")
	WebElement Baddress;
	
	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	WebElement billingBtn;
	
	@FindBy(id = "shipping-address-select")
	WebElement shippingDropdown;
	
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	WebElement shippingBtn;
	
	@FindBy(css = "#shippingoption_2")
	WebElement shippingmethodoption;
	
	@FindBy(css = "input[class='button-1 shipping-method-next-step-button']")
	WebElement shippingmethod;
	
	@FindBy(css = "input[value='Payments.CashOnDelivery']")
	WebElement paymentoption;
	
	@FindBy(css = "input[class='button-1 payment-method-next-step-button']")
	WebElement paymentmethod; 
	
	@FindBy(css = "input[class='button-1 payment-info-next-step-button']")
	WebElement paymentinfo;
	
	@FindBy(xpath = "//input[@value='Confirm']")
	WebElement Confirm;
		
	
	public void billingAdd()
	{
		Select ba = new Select(Baddress);
		ba.selectByIndex(1);
		billingBtn.click();
	}
	
	public void shippingAdd()
	{
		//WaitForElementToBeClickable(shippingDropdown);
		WaitForWebElementToAppear(shippingDropdown);
		Select ba = new Select(shippingDropdown);
		ba.selectByIndex(1);
		shippingBtn.click();
	}
	public void shippingMethod()
	{
		WaitForWebElementToAppear(shippingmethodoption);
		shippingmethodoption.click();
		shippingmethod.click();
	}
	
	public void PaymentMethod()
	{
		WaitForWebElementToAppear(paymentoption);
		paymentoption.click();
		paymentmethod.click();
	}
	
	public void PaymentInfo()
	{
		WaitForWebElementToAppear(paymentinfo);
		paymentinfo.click();
	}
	
	public ConfirmationPage ConfirmOrder()
	{
		
		Confirm.click();
		return new ConfirmationPage(driver);
		
		
	}
	
	
	
	
}
