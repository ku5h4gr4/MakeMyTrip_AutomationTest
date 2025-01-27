package LowestCharges;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TC_2_Gift_Card extends Base{
	
	By giftCard = By.xpath("//span[normalize-space()='Gift Cards']");
	By chooseGiftcard = By.xpath("//div[@class='gc__right']//div[2]//ul[1]//li[1]//div[1]//img[1]");
	By email = By.xpath("//span[normalize-space()='E-Mail']");
	By name = By.xpath("//input[@name='name']");
	By mobileNo = By.xpath("//input[@name='mobileNo']");
	By emailId = By.xpath("//input[@name='emailId']");
	By messageBox = By.xpath("//textarea[@placeholder='COMPOSE A MESSAGE (0/250)']");
	By senderName = By.xpath("//input[@name='senderName']");
	By senderMobileNo = By.xpath("//input[@name='senderMobileNo']");
	By senderEmailId = By.xpath("//input[@name='senderEmailId']");
	By buyNowButton = By.xpath("//button[normalize-space()='BUY NOW']");
	By errorMsg = By.xpath("//p[@class='red-text font11 append-top5']");
	
	
	@Test
	public void gift_card() throws Exception
	{
		ReadData rd = new ReadData();
		WebElement giftCard_ele = driver.findElement(giftCard);
		giftCard_ele.click();
		
		ArrayList<String> windowIds = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowIds.get(1));
		
		ss.captureScreenshot("GiftCardPage");
		WebElement clickGiftCard = wait.until(ExpectedConditions.elementToBeClickable(chooseGiftcard));
		js.executeScript("arguments[0].click();", clickGiftCard);
		js.executeScript("window.scrollBy(0,600)", "");
		
		WebElement email_ele = wait.until(ExpectedConditions.elementToBeClickable(email));
		act.moveToElement(email_ele).click().perform();
		js.executeScript("window.scrollBy(0,600)", "");
		
		ArrayList<String> rData = rd.Data();
		
		driver.findElement(name).sendKeys(rData.get(0));
		driver.findElement(mobileNo).sendKeys(rData.get(1));
		driver.findElement(emailId).sendKeys(rData.get(2));
		driver.findElement(messageBox).sendKeys(rData.get(3));
		driver.findElement(senderName).sendKeys(rData.get(4));
		driver.findElement(senderMobileNo).sendKeys(rData.get(5));
		driver.findElement(senderEmailId).sendKeys(rData.get(6));
		driver.findElement(buyNowButton).click();
		
		WebElement errMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
		String output = errMsg.getText();
		ss.captureScreenshot("ErrorMsg");
		System.out.println("<----------------- Test Case-2 ----------------->");
		System.out.println(output);
		System.out.println();
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
}
