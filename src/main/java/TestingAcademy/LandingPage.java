package TestingAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	//PageFactory
	@FindBy(xpath="//input[@id='Email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement userPassword;
	
	@FindBy(css="input[value='Log in']")
	WebElement login;
	
	@FindBy(css="div[class='validation-summary-errors'] span")
	WebElement errorMessage;
	
	public ProductCatelogue loginApplication(String email, String password)
	{
		username.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		ProductCatelogue productCatelogue = new ProductCatelogue(driver);
		return productCatelogue;
	}
	
	public String getErrorMessage()
	{
		WaitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
	}
}
