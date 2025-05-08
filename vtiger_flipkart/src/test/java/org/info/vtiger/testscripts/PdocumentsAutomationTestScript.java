package org.info.vtiger.testscripts;

import org.info.pages.pdocuments.CreatingNewDocumentPage;
import org.info.pages.pdocuments.DocumentsPage;
import org.info.pages.pdocuments.HOmePage;
import org.info.pages.pdocuments.LogPage;
import org.info.utils.WebUtil;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PdocumentsAutomationTestScript {
@Test
	public void testCreatDocumentwithRequiredField() {
		WebUtil wu=new WebUtil();
		wu.launchBrowser("chrome");	
		wu.openUrl("http://localhost:9999");
		
		LogPage lp=PageFactory.initElements(wu.driver, LogPage.class);
		lp.validLoginCreadential(wu);
		
		HOmePage hp=PageFactory.initElements(wu.driver,HOmePage.class);
		hp.clickOnDocumentsLink(wu);
		
		DocumentsPage dp=PageFactory.initElements(wu.driver,DocumentsPage.class);
		dp.documentsCreatButton(wu);
		
		CreatingNewDocumentPage cnp=PageFactory.initElements(wu.driver,CreatingNewDocumentPage.class);
		cnp.printAllLinkOfInnerText(wu);
		cnp.creatDocuments(wu);
		cnp.saveDucument(wu);
	}

}
