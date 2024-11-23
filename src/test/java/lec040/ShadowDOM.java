package lec040;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOM
{
	// Element within single shadow root
	// Here we will locate "Shadow Element" in the page
	// It is inside single shadow root
//	@Test
	public void testSingleShadowRoot()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		WebElement shadowHost = driver.findElement(By.cssSelector("#shadow-root"));
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		WebElement shadowElement = shadowRoot.findElement(By.id("shadow-element"));
	
		System.out.println(shadowElement.getText());
		System.out.println(shadowElement.getAttribute("innerText"));
		System.out.println(shadowElement.getAttribute("textContent"));
		System.out.println(shadowElement.getAttribute("innerHTML"));
		
	}

	// Nested shadow root
	// Here we will locate "Nested Shadow Element". It's nested shadow element
	// Here element will be inside two shadow roots (nested shadow root)
	@Test(enabled = false)
	public void testNestedShadowRoot()
	{
		WebDriverManager.chromedriver().setup();
			
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/shadow-dom");
			
		WebElement parentShadowHost = driver.findElement(By.cssSelector("#shadow-root"));
		SearchContext parentShadowRoot = parentShadowHost.getShadowRoot();
	
		WebElement childShadowHost = parentShadowRoot.findElement(By.id("inner-shadow-dom"));
		SearchContext childShadowRoot = childShadowHost.getShadowRoot();
		WebElement nestedElement = childShadowRoot.findElement(By.id("nested-shadow-element"));
		System.out.println(nestedElement.getText());
		System.out.println(nestedElement.getAttribute("innerText"));
		System.out.println(nestedElement.getAttribute("textContent"));
		System.out.println(nestedElement.getAttribute("innerHTML"));
	}

	
	// Multi-nested shadow root
	// Here we will locate "Multi-nested Shadow Element". It's multi-nested shadow element
	// Here element will be inside three shadow roots (multi-nested shadow root)
//	@Test
	public void testMultiNestedShadowRoot()
	{
		WebDriverManager.chromedriver().setup();
			
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/shadow-dom");
			
		WebElement parentShadowHost = driver.findElement(By.cssSelector("#shadow-root"));
		SearchContext parentShadowRoot = parentShadowHost.getShadowRoot();
	
		WebElement childShadowHost = parentShadowRoot.findElement(By.id("inner-shadow-dom"));
		SearchContext childShadowRoot = childShadowHost.getShadowRoot();
		
		WebElement innerShadowHost = childShadowRoot.findElement(By.cssSelector("#nested-shadow-dom"));
		SearchContext innerShadowRoot = innerShadowHost.getShadowRoot();
		
		WebElement innerElement = innerShadowRoot.findElement(By.cssSelector("#multi-nested-shadow-element"));
		System.out.println(innerElement.getText());
		System.out.println(innerElement.getAttribute("innerText"));
		System.out.println(innerElement.getAttribute("textContent"));
		System.out.println(innerElement.getAttribute("innerHTML"));
	}

	// Here we are testing another shadow root application
	@Test(enabled = false)
	public void testShadowRootBooks()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://books-pwakit.appspot.com/");
		
		WebElement shadowHost0 = driver.findElement(By.cssSelector("[apptitle='BOOKS']"));
		SearchContext shadowRoot0 = shadowHost0.getShadowRoot();
		shadowRoot0.findElement(By.id("input")).sendKeys("Elon Musk");
	}
	
	// Here we are testing mercedes app
	@Test
	public void testBenzApp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.mercedes-benz.co.in/");
		
		// Wait for the pop-up
		WebElement shadowHost = driver.findElement(By.cssSelector("[data-market='IN']"));
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		WebElement popup = shadowRoot.findElement(By.cssSelector(".cmm-cookie-banner__content"));
		wait.until(ExpectedConditions.visibilityOf(popup));
		
		// Locate "Accept all" button and click
		WebElement acceptAllButton = shadowRoot.findElement(By.cssSelector("[data-test='handle-accept-all-button']"));
		System.out.println(acceptAllButton.getText());
		System.out.println(acceptAllButton.getAttribute("innerText"));
		System.out.println(acceptAllButton.getAttribute("textContent"));
		System.out.println(acceptAllButton.getAttribute("innerHTML"));
		acceptAllButton.click();
		
		// Locate profile login anc click
//		WebElement shadowHostLogin = driver.findElement(By.cssSelector("iam-user-menu.webcomponent.webcomponent-nested"));
//		SearchContext shadowRootLogin = shadowHostLogin.getShadowRoot();
	
		driver.findElement(By.cssSelector("iam-user-menu.webcomponent.webcomponent-nested")).click();
		
	}

}
