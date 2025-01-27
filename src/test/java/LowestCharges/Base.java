package LowestCharges;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
	WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	WebDriverWait wait;
	CaptureScreen ss;
	
	By closePopup = By.xpath("//span[@class='commonModal__close']");

	@BeforeClass
	@Parameters({"browser"})
	public void DriverSetup(String browser)
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("--disable-infobars");
		opt.setExperimentalOption("useAutomationExtension", false);
		opt.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		
		EdgeOptions opt1 = new EdgeOptions();
		opt1.addArguments("start-maximized");
		opt1.addArguments("--disable-infobars");
		opt.setExperimentalOption("useAutomationExtension", false);
		opt1.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		
		switch(browser)
		{
		case "chrome":
			driver = new ChromeDriver(opt);
			break;
			
		case "edge":
			driver = new EdgeDriver(opt1);
			break;
		default:
			System.out.println("Invalid Browser");
		}
		
		act = new Actions(driver);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		ss = new CaptureScreen(driver);
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		
	}
	
	@AfterClass
	public void closeApp()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
	
	@BeforeMethod
	public void closePopup() throws Exception
	{
		try
		{
			driver.findElement(closePopup).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	public void markE(WebElement ele)
	{
		js.executeScript("arguments[0].setAttribute('style','border: solid green 3px; color:red; border-radius:3rem')", ele);
	}
	*/
	
	
	

}
