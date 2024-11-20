package TestingAcademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="(//input[@value='Details'])[1]")
	WebElement detailButton;
	
	@FindBy(xpath="//td[@class='a-left name']")
	private List<WebElement> products;
	
	
	public Boolean VerifyOrderDisplay(String productName)
	{
		detailButton.click();
		Boolean prod = products.stream().anyMatch(product->product.getText().equals(productName));
		return prod;
	}


	public List<WebElement> productName()
	{
		return products;
	}
}
