package handling_Dropdown;

import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public WebDriver driver;
	String URL;
	String WebdriverPath;
	String DriverType;
	
	public void readConfigFile() throws Exception{
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("C:\\Users\\Indranil Sarkar\\Revision1\\Handling_Dropdown\\Config.properties");
		prop.load(input);
		
		URL = prop.getProperty("URL");
		WebdriverPath = prop.getProperty("WebdriverPath");
		DriverType = prop.getProperty("DriverType");
		
	}
	
	@BeforeMethod
	public void setUp() throws Exception{
		
		readConfigFile();
		
		driver = new ChromeDriver();
		System.setProperty("DriverType", WebdriverPath);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(URL);
			
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.close();
		
		
	}
	
	public static void Screenshot(WebDriver driver, String filename) throws Exception{
		
		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("C:\\Users\\Indranil Sarkar\\Revision1\\Handling_Dropdown\\Screenshots\\"+filename+".png"));
		
	}

}
