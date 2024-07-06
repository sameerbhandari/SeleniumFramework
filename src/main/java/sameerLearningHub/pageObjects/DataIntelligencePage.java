package sameerLearningHub.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sameerLearningHub.AbstractComponents.AbstractComponents;

@SuppressWarnings("unused")
public class DataIntelligencePage extends AbstractComponents {

	WebDriver driver;

	public DataIntelligencePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	pageFactory for following line
//	List<WebElement> dataIntelligenceLinks = (List<WebElement>) driver
//			.findElements(By.cssSelector(".data-intelligence-link"));

	@FindBy(css = ".data-intelligence-link")
	List<WebElement> dataIntelligenceLinks;
	@FindBy(css = ".title-banner > h3")
	WebElement titleOfApp;
	@FindBy(className = ".rf-dropdown.nested.top-right")
	WebElement cubeIcon;

	By linksBy = By.cssSelector(".data-intelligence-link");

	public List<WebElement> getListofAllLinks() {
		waitForElementToAppear(linksBy);
		return dataIntelligenceLinks;
	}

	public WebElement getLinkByName(String nameOfLink) {
		return getListofAllLinks().stream().filter(link -> link
				.findElement(By.cssSelector(".data-intelligence-link-text > h3")).getText().equals(nameOfLink))
				.findFirst().orElse(null);
	}

	public IntelligentDocumentCenter goToIDC(String nameofLink) {
		getLinkByName(nameofLink).click();
		waitUntilIDCIsLoaded();
		String nameOfApp = titleOfApp.getText();
		System.out.println("You have reached: " + nameOfApp);
		IntelligentDocumentCenter idc = new IntelligentDocumentCenter(driver);
		return idc;
	}
	
	public WebElement visitCreatEntity() {
		WebElement 
	}
	
}
