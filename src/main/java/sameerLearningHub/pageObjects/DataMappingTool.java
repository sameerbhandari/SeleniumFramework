package sameerLearningHub.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sameerLearningHub.AbstractComponents.AbstractComponents;

@SuppressWarnings("unused")
public class DataMappingTool extends AbstractComponents {

	WebDriver driver;

	public DataMappingTool(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(), 'Document Name')]/following-sibling::div")
	WebElement docName;
	@FindBy(xpath = "//div[contains(text(), 'Canoe Document ID')]/following-sibling::div")
	WebElement docId;

	public String getDocName() {
		return docName.getText();
	}
	public String getDocId(){
		return docId.getText();
	}
}
