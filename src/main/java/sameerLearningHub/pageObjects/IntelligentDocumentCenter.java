package sameerLearningHub.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import sameerLearningHub.AbstractComponents.AbstractComponents;

@SuppressWarnings("unused")
public class IntelligentDocumentCenter extends AbstractComponents {

	WebDriver driver;

	public IntelligentDocumentCenter(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(), 'Document Name')]/following-sibling::div")
	WebElement docName;

	public DataMappingTool openDocumentID(String docId) {
		// TODO Auto-generated method stub
		WebElement docRow = driver.findElement(By.id(docId));
		docRow.findElement(By.cssSelector(".col-actions > a")).click();
		String docNameXpath = "//div[contains(text(), 'Document Name')]/following-sibling::div";
		waitForElementToAppear(By.xpath(docNameXpath));
		DataMappingTool dmm = new DataMappingTool(driver);
		return dmm;
	}
}
