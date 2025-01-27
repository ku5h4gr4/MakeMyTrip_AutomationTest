package LowestCharges;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_3_Hotel_Booking extends Base{

	@Test(priority=3)
	public void hotel()
	{
		By hotels = By.xpath("//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Hotels']");
		By guests = By.xpath("//input[@id='guest']");
		By noOfAdults = By.xpath("//body/div[@id='root']/div[@id='top-banner']/div[@class='minContainer']/div/div[@class='widgetSection appendBottom40']/div[@class='makeFlex primaryTraveler']/div[@class='hsw hswFullWidth hswNew widgetOpen']/div[@class='hsw_inner']/div[@class='hsw_inputBox roomGuests inactiveWidget activeWidget']/div[@class='rmsGst']/div[@class='rmsGst__body']/div[2]");
		
		WebElement hotel_ele = driver.findElement(hotels);
		act.moveToElement(hotel_ele).click().perform();
		ss.captureScreenshot("HotelPage");
		driver.findElement(guests).click();
		List<WebElement> adult_ele = driver.findElements(noOfAdults);
		ss.captureScreenshot("noOfAdult");
		System.out.println("<----------------- Test Case-3 ----------------->");
		for(WebElement n: adult_ele)
		{
			System.out.println(n.getText());
		}
		
	}
}
