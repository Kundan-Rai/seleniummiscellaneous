package lec039;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnableExtensionsAtRuntime
{
	// Add/Get/Enable single extension
	@Test(enabled = false)
	public void enableSelectorsHubExtension()
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		String path = "E:\\CXF_Files\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx";
		File file = new File(path);
		
		options.addExtensions(file);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
//		driver.get("https://text-compare.com/");
		
		// Using this URL because it displays so many ads
		driver.get("https://www.geeksforgeeks.org/javascriptexecutor-in-selenium/");
	}
	
	// Add all extension and return
	public List<File> addExtensions()
	{
		File adsBlockerFile = new File("E:\\CXF_Files\\Stands-AdBlocker-Chrome-Web-Store.crx");
		
		File selectorsFile = new File("E:/CXF_Files/SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
	
		List<File> allExtensions = new LinkedList<>();
		allExtensions.add(adsBlockerFile);
		allExtensions.add(selectorsFile);
		
		return allExtensions;
	}
	
	// Get/Add/Enable multiple extensions
	@Test
	public void blockAds()
	{
		WebDriverManager.chromedriver().setup();
		
		List<File> allExtensions = addExtensions();
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(allExtensions);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.geeksforgeeks.org/javascriptexecutor-in-selenium/");
	}
}
