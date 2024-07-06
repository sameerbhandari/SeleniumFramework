package sameerLearningHub.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void waitUntilIDCIsLoaded() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector(".processing"), "Processing..."));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void fluentWaitForElement(By findBy, String expectedText) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(null).withTimeout(null);
		fluentWait.until(ExpectedConditions.invisibilityOfElementWithText(findBy, expectedText));
	}
}
