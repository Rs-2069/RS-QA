package TestingAcademy.TestComponets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import TestingAcademy.LandingPage;

public class BaseTest {
public WebDriver driver;
public LandingPage landingpage;

	public WebDriver intializeDriver() throws IOException
	{
		//Properties class
		
		Properties prop = new Properties();
		FileInputStream  fls = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\TestingAcademy\\Resources\\GlobalData.properties");
		prop.load(fls);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome"))
		{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			 driver = new FirefoxDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJSONNData(String filePath) throws IOException
	{
		String JsonConnect = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(JsonConnect, new TypeReference<List<HashMap<String,String>>>(){}); 
		return data;
	}
	
	public String getScreenShot(String testName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty(("user.dir")+"\\reports\\" +testName + ".png"));
		FileUtils.copyFile(source, file);
		return System.getProperty(("user.dir")+"\\reports\\" +testName + ".png");
	}
	
	@BeforeMethod(alwaysRun = true)
	 public LandingPage LaunchApplication() throws IOException
	 {
		 driver = intializeDriver();
		 landingpage = new LandingPage(driver);
		 landingpage.goTo();
		 return landingpage;
	 }
	@AfterMethod(alwaysRun = true)
	public void teamDown()
	{
		driver.close();
	}
	}
	
	
	
	
	
	
	
	

