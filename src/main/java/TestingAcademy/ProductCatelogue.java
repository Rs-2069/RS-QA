package TestingAcademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponent;

public class ProductCatelogue extends AbstractComponent{

	WebDriver driver;
	public ProductCatelogue(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(linkText="Apparel & Shoes")
	WebElement productPage;
	
	@FindBy(xpath="//select[@name='products-orderby']")
	WebElement orderby;
	
	@FindBy(css="#products-pagesize")
	WebElement pagesize;
	
	@FindBy(css=".item-box")
	List<WebElement> Products;
	
	
	By ProductsBy = By.cssSelector(".item-box");
	By addProductToCart =By.cssSelector(".button-2.product-box-add-to-cart-button");
	By  Spinner = By.cssSelector(".loading-image");
	By toastMessage = By.xpath("//p[@class='content']/a[text()='shopping cart']");
			
	public List<WebElement> getProductList()
	{
		productPage.click();
		Select s = new Select(orderby);
		s.selectByVisibleText("Price: Low to High");
		Select sc = new Select(pagesize);
		sc.selectByVisibleText("12");
		WaitForElementToAppear(ProductsBy);
		return Products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector(".product-title a")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName)
	{
		WebElement prod =getProductByName(productName);
		prod.findElement(addProductToCart).click();
		WaitForElementToAppear(toastMessage);
		WaitForElementToDisAppear1(Spinner);
		WaitForElementToDisAppear1(toastMessage);
		
	}
	
}
