package lec039;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshot
{
//	1. Screenshot of Full page
//	@Test
	public void takeFullPageScreenshot() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		driver.get("https://www.nopcommerce.com/en");
		driver.manage().window().maximize();
		
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		// We can use any of the below syntax for storing screenshot

		// 1st way
//		FileUtils.copyFile(srcFile, new File("./screenshots/fullPageScreenshot.png"));
		
		// 2nd way
		// System.getProperty("user.dir") : gives the path of Current Working Directory (CWD)
//		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"/screenshots/fullPageScreenshot.png"));
	
		// 3rd way
		File targetFile = new File(System.getProperty("user.dir")+"/screenshots/fullPageScreenshot.png");
		
		// Copy source file to target file
		srcFile.renameTo(targetFile);
	}

//	2. Screenshot of Specific area / block of the page
	
//	@Test
	public void takeScreenshotOfSpecificSectionOfWebPage()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.nopcommerce.com/en");
		driver.manage().window().maximize();
		
		WebElement sectionOfPage = driver.findElement(By.cssSelector(".whynopcommerce-section"));
		File sourceFile = sectionOfPage.getScreenshotAs(OutputType.FILE);
		
		File targetFile = new File(System.getProperty("user.dir")+"/screenshots/sectionOfPage.png");
		sourceFile.renameTo(targetFile);
	}
	
//	3.	Screenshot of Web element
	@Test
	public void takeElementScreenshot()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.nopcommerce.com/en");
		driver.manage().window().maximize();
		
		WebElement logoElement = driver.findElement(By.xpath("//*[@title='nopCommerce']"));
	
		File sourceFile = logoElement.getScreenshotAs(OutputType.FILE);
	
		File targetFile = new File("./screenshots/logoElement.png");
		
		// Copy source file to target file
		sourceFile.renameTo(targetFile);
	}

}
