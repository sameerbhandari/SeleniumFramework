package sameerLearningHub.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
public class OpenDMM extends BaseTest {
	DataIntelligencePage dip;
	IntelligentDocumentCenter idc;
	DataMappingTool dmm;
	String app = "Intelligent Document Center";
	String docId1 = "0ecf9947-c3e8-4796-ad51-2644d50bda87";
	String docName1 = "Mezza Fund II - TestRandonEnt - Capital Call Notice - 03/07/18";
	String docId2 = "24835816-a78e-41d2-b729-fc84edffcc74";
	String docName2 = "sb03JanFund - sb03JanEntity - ILPA Reporting Template - 12/31/15";
	String userEmail = "sameer+SJTestClient@canoeintelligence.com";
	String userPassword = "Qwerty@CI2020";

	@DataProvider
	public Object[][] getData() throws Exception {
		return new String[][] { { docId1, docName1 }, { docId2, docName2 } };
	}

	@DataProvider
	public Object[][] getDatafromHashMap() throws Exception {

		HashMap<String, String> input1 = new HashMap<String, String>();
		input1.put("docID", docId1);
		input1.put("docName", docName1);

		HashMap<String, String> input2 = new HashMap<String, String>();
		input2.put("docID", docId2);
		input2.put("docName", docName2);

		return new Object[][] { { input1 }, { input2 } };

	}

	@DataProvider
	public Object[][] getDatafromJSON() throws Exception {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\sameerLearningHub\\data\\data.json";
		List<HashMap<String, String>> input = getJsonDataToMap(filePath);
		return new Object[][] { { input.get(0) }, { input.get(1) } };
	}

	@Test(dataProvider = "getDatafromJSON", groups = { "dpCheck" })
	public void goToDIP(HashMap<String, String> input) throws IOException {

	}

	@Test(dataProvider = "getDatafromJSON", groups = { "dpCheck" })
	public void getDocNamefromDMMTest(HashMap<String, String> input) throws IOException {
		dip = loginPage.loginToApplication(userEmail, userPassword);
		idc = dip.goToIDC(app);
		dmm = idc.openDocumentID(input.get("docID"));
		assertEquals(input.get("docName"), dmm.getDocName());
		assertEquals(input.get("docID"), dmm.getDocId());
	}

	@Test(enabled = false, dataProvider = "getData", dependsOnMethods = { "getDocNamefromDMMTest" }, groups = {
			"dpCheck" })
	public void getDocIdfromDMMTest(String docId) {
		assertEquals(docId, dmm.getDocId());
	}
}
