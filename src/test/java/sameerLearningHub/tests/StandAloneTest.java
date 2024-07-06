package sameerLearningHub.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import dev.failsafe.internal.util.Assert;
import sameerLearningHub.pageObjects.LoginPage;

@SuppressWarnings("unused")
public class StandAloneTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://client.stage.canoesoftware.com/");
		
		LoginPage loginPage = new LoginPage(driver);
		driver.findElement(By.id("email")).sendKeys("sameer+SJTestClient@canoeintelligence.com");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.name("password")).sendKeys("Qwerty@CI2020");
		driver.findElement(By.id("loginButton")).click();

		List<WebElement> dataIntelligenceLinks = (List<WebElement>) driver
				.findElements(By.cssSelector(".data-intelligence-link"));

//		for (WebElement webElement : dataIntelligenceLinks) {
//			boolean condition =  webElement.findElement(By.cssSelector(".data-intelligence-link-text > h3")).getText().equals("Intelligent Document Center");
//			if(condition) {
//				webElement.click();
//			}
//		}
		WebElement linkToSelect = dataIntelligenceLinks.stream()
				.filter(link -> link.findElement(By.cssSelector(".data-intelligence-link-text > h3")).getText()
						.equals("Intelligent Document Center"))
				.findFirst().orElse(null);

		linkToSelect.click();
		System.out.println(driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector(".processing"), "Processing..."));

		WebElement docRow = driver.findElement(By.id("0ecf9947-c3e8-4796-ad51-2644d50bda87"));
		docRow.findElement(By.cssSelector(".col-actions > a")).click();
		By docNameXpath = By.xpath("//div[contains(text(), 'Document Name')]/following-sibling::div");
		WebElement docName = driver.findElement(docNameXpath);
		wait.until(ExpectedConditions.visibilityOf(docName));
		System.out.println("Doc Name: "+docName.getText());
		Boolean match = docName.getText().contentEquals("Mezza Fund II - TestRandonEnt - Capital Call Notice - 03/07/18");
		driver.quit();
	}
}
