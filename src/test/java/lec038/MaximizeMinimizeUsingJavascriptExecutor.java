package lec038;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MaximizeMinimizeUsingJavascriptExecutor
{
//	@Test
	public void maxMinWindowUsingSeleniumMethods() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(2000);
		
		WebDriver.Window window = driver.manage().window();
		
		// Maximize the window
//		window.maximize();
		
		// Minimize the window
//		window.minimize();
		
		// Full screen the window
//		Thread.sleep(2000);
//		window.fullscreen();
		
		// getting and setting window size
		int width = window.getSize().getWidth();
		int height = window.getSize().getHeight();
		
		System.out.println(width+" "+height);
		Thread.sleep(2000);
		
		window.setSize(new Dimension(800, 500));
	}
	
	@Test
	public void maxMinWindowUsingJavascriptExecutor() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		// zoom to 50%
		js.executeScript("document.body.style.zoom='50%'");
		
		// zoom to 80%
		Thread.sleep(2000);
		js.executeScript("document.body.style.zoom='80%'");
	}
}
