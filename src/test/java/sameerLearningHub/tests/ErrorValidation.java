package sameerLearningHub.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import dev.failsafe.internal.util.Assert;
import sameerLearningHub.TestComponents.BaseTest;
import sameerLearningHub.pageObjects.DataIntelligencePage;
import sameerLearningHub.pageObjects.DataMappingTool;
import sameerLearningHub.pageObjects.IntelligentDocumentCenter;
import sameerLearningHub.pageObjects.LoginPage;

@SuppressWarnings("unused")
public class ErrorValidation extends BaseTest {

	@Test
	public void errorLogin() throws IOException {

		String userEmail = "sameer+SJTestClient1@canoeintelligence.com";
		String userPassword = "Qwerty@CI2020";

//		DataIntelligencePage dip = loginPage.loginToApplication(userEmail, userPassword);
		loginPage.loginToApplication(userEmail, userPassword);
		assertEquals("The email or password you have entered is invalid.", loginPage.getErrorMessage());

//		String app = "Intelligent Document Center";
//
//		IntelligentDocumentCenter idc = dip.goToIDC(app);
//
//		String docId = "24835816-a78e-41d2-b729-fc84edffcc74";
//		String docName = "sb03JanFund - sb03JanEntity - ILPA Reporting Template - 12/31/15";
//
//		DataMappingTool dmm = idc.openDocumentID(docId);
//
//		assertEquals(docName, dmm.getDocName());
//		assertEquals(docId, dmm.getDocId());
	}
}
