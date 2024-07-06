package sameerLearningHub.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sameerLearningHub.AbstractComponents.AbstractComponents;

@SuppressWarnings("unused")
public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	pageFactory for following line
//	WebElement userEmail = driver.findElement(By.id("email"));
	@FindBy(id = "email")
	WebElement userEmailElement;
	@FindBy(id = "loginButton")
	WebElement loginButton;
	@FindBy(name = "password")
	WebElement passwordElement;
	@FindBy(css = "#errors > small")
	WebElement errorMessage;

	public DataIntelligencePage loginToApplication(String email, String password) {
		userEmailElement.sendKeys(email);
		loginButton.click();
		passwordElement.sendKeys(password);
		loginButton.click();
		DataIntelligencePage dip = new DataIntelligencePage(driver);
		return dip;
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

	public void gotoLoginPage() {
		driver.get("https://client.stage.canoesoftware.com/");
	}

}
