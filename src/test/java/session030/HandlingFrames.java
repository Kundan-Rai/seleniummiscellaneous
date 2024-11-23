package session030;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames
{
	@Test
	public void handleFrame()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		js.executeScript("document.body.style.zoom='50%'");
		
		// Locate Frame 1 and switch to it
		WebElement frame1 = driver.findElement(By.cssSelector("[src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		
		// Enter text in Frame 1
		driver.findElement(By.cssSelector("[name='mytext1']")).sendKeys("Hello frame 1");
		
		// Switch to parent frame / default content
//		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		// Locate Frame 2 and switch to it
		WebElement frame2 = driver.findElement(By.xpath("//*[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		
		// Enter text in Frame 2
		driver.findElement(By.name("mytext2")).sendKeys("Welcome to Frame 2");
		driver.switchTo().parentFrame();
		
		// Working with frame 3
		WebElement frame3 = driver.findElement(By.cssSelector("[src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.name("mytext3")).sendKeys("It's frame 3");
		
		// Handling Nested frame
		// Nested frame is inside frame 3
		WebElement nestedFrame = driver.findElement(By.cssSelector("iframe"));
		driver.switchTo().frame(nestedFrame);
		
		WebElement headElement = driver.findElement(By.cssSelector("[role='heading'][aria-level='1']"));
		System.out.println(headElement.getText());
		
		// Check "I am a human" checkbox
		driver.findElement(By.cssSelector("#i9")).click();
		driver.switchTo().defaultContent();
		
		// Working with the frame 4
		WebElement frame4 = driver.findElement(By.cssSelector("[src*='frame_4']"));
		driver.switchTo().frame(frame4);
		driver.findElement(By.name("mytext4")).sendKeys("Welcome frame 4");
		driver.switchTo().defaultContent();
//		js.executeScript("document.body.style.zoom='50%'");
		
		// Working with frame 5
		WebElement frame5 = driver.findElement(By.cssSelector("[src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//*[@type='text' and @name='mytext5']")).sendKeys("Last frame : Frame 5");
		
		driver.findElement(By.tagName("a")).click();
		
	}
}
