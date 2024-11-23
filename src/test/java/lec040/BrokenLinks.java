package lec040;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BrokenLinks
{
	@Test
	public void getBrokenLinks()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().minimize();
		driver.get("http://www.deadlinkcity.com/");
		
		// Get all links from the page as links have the URL
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		Reporter.log("Total no. of links : "+allLinks.size(), true);
		
		int countBrokenLink = 0;
		for(WebElement link : allLinks)
		{
			// Get href attribute value from each link
			// href attribute contains the URL or link
			String href = link.getAttribute("href");
			
			if(href.equals("null") || href.isEmpty())
			{
				continue;
			}
		
			// Now we have URL (i.e., href value) in the form of string
			// In order to hit this url to the server, we need to convert 
			// it from String to the URL
			try
			{
				URL linkURL = new URL(href);	// converted href value from string to URL format
				HttpURLConnection	conn = (HttpURLConnection)linkURL.openConnection();	// open connection to the server
				conn.connect(); // connect to the server (establish connection to the server) and send request to the it (server)
				
				int responseCode = conn.getResponseCode(); 	// get response code
			
				if(responseCode >= 400)
				{
					System.out.println(href+" --> Broken link!!!");
					countBrokenLink++;
				}
				else
				{
					System.out.println(href+" --> Working link!!!");
				}
			}
			catch(Exception e) {}
		}
			System.out.println("Total no. of broken links is : "+countBrokenLink);
	}
}
