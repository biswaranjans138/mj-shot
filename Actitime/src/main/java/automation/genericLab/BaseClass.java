package automation.genericLab;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import automation.elementRepository.LoginLocators;

public class BaseClass {
	public static WebDriver Listenerdriver;
	public WebDriver driver;
	public DataUtility du=new DataUtility();
	
	@BeforeClass(alwaysRun=true)
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Listenerdriver=driver;
	}
	@BeforeMethod(alwaysRun=true)
	public void loginApp() throws IOException
	{
		driver.get(du.getDatafromproperties("url"));
		LoginLocators ll=new LoginLocators(driver);
		ll.login(du.getDatafromproperties("username"),du.getDatafromproperties("password"));
	}
	@AfterMethod(alwaysRun=true)
	public void logoutApp()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass(alwaysRun=true)
	public void close()
	{
		driver.close();
	}

}
