package sameerLearningHub.tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class handleWindow {
	
	@Test
	public void handlingMultipleWindows()  throws Exception{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window handle - "+  parentWindow);
		driver.findElement(By.id("name")).sendKeys("Before Switching");
		driver.findElement(By.id("newWindowBtn")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String handle : windowHandles) {
			System.out.println("Window Handle Id - " +  handle);
			if(!parentWindow.equals(handle)) {
				driver.switchTo().window(handle);
				driver.findElement(By.id("firstName")).sendKeys("Sameer");
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("name")).sendKeys("After Switching");
		Thread.sleep(5000);
		driver.quit();
	}
}
