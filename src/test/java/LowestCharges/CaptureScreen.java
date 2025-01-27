package LowestCharges;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreen {
	WebDriver driver;
	 
    public CaptureScreen(WebDriver driver) {
        this.driver = driver;
    }
 
    // Method to capture screenshot and save to the specified folder
    public void captureScreenshot(String fileName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmm");
        String timestamp = LocalDateTime.now().format(formatter);
        String filePath = "Screenshot/" + fileName + "_" + timestamp + ".png";
 
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
 
        File destFile = new File(filePath);
        destFile.getParentFile().mkdirs();  // Create folder if it doesn't exist
 
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
