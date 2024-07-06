package sameerLearningHub.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;




public class handleAlerts {
	@Test
	public void handlingAlert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.findElement(By.id("alertBox")).click();
		Alert alertObj = driver.switchTo().alert();
		alertObj.accept();
		assertEquals(driver.findElement(By.id("output")).getText(), "You selected alert popup");
		Thread.sleep(10000);

		
		driver.findElement(By.id("confirmBox")).click();
		alertObj = driver.switchTo().alert();
		alertObj.accept();
		assertEquals(driver.findElement(By.id("output")).getText(), "You pressed OK in confirmation popup");
		Thread.sleep(10000);
		
		driver.findElement(By.id("confirmBox")).click();
		alertObj = driver.switchTo().alert();
		alertObj.dismiss();
		assertEquals(driver.findElement(By.id("output")).getText(), "You pressed Cancel in confirmation popup");
		Thread.sleep(10000);
		
		driver.findElement(By.id("promptBox")).click();
		alertObj = driver.switchTo().alert();
		String enteredText = "Sameer Bhandari";
		alertObj.sendKeys(enteredText);
		String actualText = driver.findElement(By.id("output")).getText();
		System.out.println(actualText);
		Thread.sleep(10000);
		
		driver.quit();
	}
}
