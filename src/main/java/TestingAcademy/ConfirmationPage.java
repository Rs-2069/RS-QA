package TestingAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="div[class='title'] strong")
	WebElement confirmMessage;
	
	@FindBy(css="input[value='Continue']")
	WebElement ContinueBtn;
	 
	public String GetConfirmationMessage()
	{
		return confirmMessage.getText();
		
	}
	
	public void ContinueShopping() 
	{
		ContinueBtn.click();
	}
	
	

	
	
	
	
	
	
	
}
