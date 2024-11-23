package lec038;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload 
{
	@Test
	public void singleFileUpload() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		driver.manage().window().maximize();
		
		// Single file upload
		Thread.sleep(5000);
//		driver.findElement(By.id("filesToUpload")).sendKeys("C:\\Users\\kunda\\OneDrive\\Desktop\\FileUpload\\file1.txt");
	
		// Verify the file is uploaded or not
//		String fileName = driver.findElement(By.cssSelector("#fileList>li")).getAttribute("textContent");
//		Assert.assertEquals(fileName, "file1.txt", "File not uploaded successfully");
	
		// Upload multiple files
		String[] st= {"C:/Users/kunda/OneDrive/Desktop/FileUpload/file1.txt",
					  "C:\\Users\\kunda\\OneDrive\\Desktop\\FileUpload\\file2.txt",
					  "C:\\Users\\kunda\\OneDrive\\Desktop\\FileUpload\\Screenshot (1938).png"};
		driver.findElement(By.id("filesToUpload")).sendKeys(st[0]+"\n"+st[1]+"\n"+st[2]);
	
		// Validate the number of files that are uploaded
		int allUploadedFileCount = driver.findElements(By.cssSelector("#fileList>li")).size();
		System.out.println(allUploadedFileCount+" "+st.length);
		Assert.assertEquals(allUploadedFileCount, st.length);
		
		// Validate the name of files
		List<WebElement> allFiles = driver.findElements(By.cssSelector("#fileList>li"));
		if(allFiles.get(0).getText().equals("file1.txt") && 
				allFiles.get(1).getText().equals("file2.txt")
				&& allFiles.get(2).getText().equals("Screenshot (1938).png"))
		{
			System.out.println("All file names matched");
		}
		else
		{
			System.out.println("File names didn't match");
		}
		
	}
}
