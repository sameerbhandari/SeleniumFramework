package sameerLearningHub.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FrameDemo {
	
	@Test
	public void practiceDropdown()  throws Exception{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.findElement(By.cssSelector("#name")).sendKeys("Hello");
		
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		driver.switchTo().frame(driver.findElement(By.id("frm1")));

		Select objSelect = new Select(driver.findElement(By.id("course")));
		objSelect.getOptions().size();
		objSelect.selectByIndex(4);
		Thread.sleep(5000);
		objSelect.selectByVisibleText("Java");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("#name")).sendKeys("Frames");
		
		driver.quit();
	}
	

}
