package org.info.vtiger.testscripts;

import org.info.pages.more.HomePag;
import org.info.pages.more.LoginPag;
import org.info.pages.more.ServiceContracts;
import org.info.utils.WebUtil;
import org.testng.annotations.Test;

public class MoreAutomationScripts {
@Test
	public void testMoreInServiceButtonContactCreationWithRequiredField() {
		WebUtil wu=new WebUtil();
		wu.launchBrowser("edge");	
		wu.openUrl("http://localhost:9999");
		
		LoginPag lp=new LoginPag(wu);
		lp.validLoginCredential();
		
		HomePag hp=new HomePag(wu);
		hp.clickMoreLink();
		ServiceContracts sv=new ServiceContracts(wu);
		sv.clickOnCreatServiceContractsButton();
	}
}
