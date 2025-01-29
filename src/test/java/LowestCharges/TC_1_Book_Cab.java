package LowestCharges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TC_1_Book_Cab extends Base {
	
	String source = "Delhi";
	String destination = "Manali";
	
	//LOCATORS
	By cabs = By.xpath("//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Cabs']");
	By fromCity = By.xpath("//input[@id='fromCity']");
	By toCity = By.xpath("//input[@placeholder='To']");
	By fromInput = By.xpath("//input[@placeholder='From']");
	By chooseSource = By.xpath("//span[normalize-space()='New Delhi, Delhi, India']");
	By chooseDestination = By.xpath("//span[normalize-space()='Manali, Himachal Pradesh, India']");
	By departureDate = By.xpath("//span[normalize-space()='Departure']");
	By date1 = By.xpath("//div[@aria-label='Thu Jan 02 2025']");
	By date2 = By.xpath("//div[@aria-label='Wed Feb 12 2025']");
	By chooseTime = By.xpath("//label[contains(@for,'pickupTime')]");
	By chooseHour = By.xpath("//div[@class='minContainer']//div[1]//div[2]//ul[1]//li[7]");
	By chooseMinute = By.xpath("//ul[contains(@class,'newTimeSlotMinUl')]//li[7]");
	By applyButton = By.xpath("//span[@class='applyBtnText']");
	By searchButton = By.xpath("//a[normalize-space()='Search']");
	By chooseSuv = By.xpath("//label[normalize-space()='SUV']");
	By lowestPrice = By.xpath("//div[@id='List']//div[1]//div[1]//div[3]//div[1]//div[2]//div[1]//p[1]");
	
	
	// LOWEST COST OF SUV CAB FROM DELHI TO MANALI
	@Test(priority=1)
	public void bookCab()
	{			
		ss.captureScreenshot("HomePage");
		driver.findElement(cabs).click();
		driver.findElement(fromCity).click();
		driver.findElement(fromInput).sendKeys(source);
		WebElement source_city = driver.findElement(chooseSource);
		act.moveToElement(source_city).click().perform();
		
		driver.findElement(toCity).sendKeys(destination);
		WebElement destination_city = driver.findElement(chooseDestination);
		act.moveToElement(destination_city).click().perform();
		
		driver.findElement(departureDate).click();
		WebElement date = driver.findElement(date1);
		js.executeScript("arguments[0].scrollIntoView();", date);
		
		WebElement day = wait.until(ExpectedConditions.elementToBeClickable(date2));
		day.click();
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		WebElement Time = wait.until(ExpectedConditions.elementToBeClickable(chooseTime));
		act.moveToElement(Time).click().perform();

		WebElement hour = wait.until(ExpectedConditions.elementToBeClickable(chooseHour));
		hour.click();
		
		WebElement mins = wait.until(ExpectedConditions.elementToBeClickable(chooseMinute));
		act.moveToElement(mins).click().perform();
		
		WebElement apply = wait.until(ExpectedConditions.elementToBeClickable(applyButton));
		apply.click();
		driver.findElement(searchButton).click();
		ss.captureScreenshot("availableCabs");
		WebElement SUV = wait.until(ExpectedConditions.elementToBeClickable(chooseSuv));
		SUV.click();
		ss.captureScreenshot("SUV");
		String lowest_price = driver.findElement(lowestPrice).getText();
		System.out.println("<----------------- Test Case-1 ----------------->");
		System.out.println("Lowest Cab Price: "+lowest_price);
		System.out.println();
		
	}

}
