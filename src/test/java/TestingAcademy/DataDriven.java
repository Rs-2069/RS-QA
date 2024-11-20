package TestingAcademy;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class DataDriven {

	public void driveData() throws IOException
	{
		 FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\Documents\\data.xlsx");
		 XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheet("Demo");
		XSSFRow row =sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		String Email = cell.getStringCellValue();
		Iterator<Cell> cell1=row.cellIterator();
		Cell it = cell1.next();
		String Password = it.getStringCellValue();
		System.out.println("Email ="+Email);
		System.out.println("Password ="+Password);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys(Email);
		driver.findElement(By.id("userPassword")).sendKeys(Password);
		driver.findElement(By.id("login")).click();
	}
//	//@Test
//	public void Execute(String Email, String Password)
//	{		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://rahulshettyacademy.com/client");
//		driver.manage().window().maximize();
//		driver.findElement(By.id("userEmail")).sendKeys(Email);
//		driver.findElement(By.id("userPassword")).sendKeys(Password);
//		driver.findElement(By.id("login")).click();
//	}

}
