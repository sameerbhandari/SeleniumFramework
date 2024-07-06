package sameerLearningHub.tests;

import org.testng.annotations.Test;

import sameerLearningHub.TestComponents.BaseTest;
import sameerLearningHub.pageObjects.DataIntelligencePage;
import sameerLearningHub.pageObjects.DataMappingTool;
import sameerLearningHub.pageObjects.IntelligentDocumentCenter;

public class EntityConfigurations extends BaseTest {
	DataIntelligencePage dip;
	IntelligentDocumentCenter idc;
	DataMappingTool dmm;
	
	@Test
	public void createEntity() {
		dip = loginPage.loginToApplication(userEmail, userPassword);
	}

}
