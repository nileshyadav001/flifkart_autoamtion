package org.info.vtiger.testscripts;

import org.info.pages.organization.HomPage;
import org.info.pages.organization.LognPage;
import org.info.pages.organization.OrganizationPage;
import org.info.utils.WebUtil;
import org.testng.annotations.Test;

public class OrganigationAutomationScripts {
@Test
	public void testOrganizationCreationWithRequiredFields() {
		try {
		WebUtil wu=new WebUtil();
		wu.launchBrowser("chrome");	
		wu.openUrl("http://localhost:9999");
		
		LognPage lp=new LognPage(wu);
		lp.validLoginCredential();
		
		HomPage hp=new HomPage(wu);
		hp.clickOrganizationLink();
		
		OrganizationPage org=new OrganizationPage(wu);
		org.clickOnCreatButton();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
