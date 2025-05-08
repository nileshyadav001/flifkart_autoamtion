package org.info.vtiger.testscripts;

import org.info.pages.contacts.CreatNewContactPage;
import org.info.pages.qproducts.CreatingNewProductPage;
import org.info.pages.qproducts.HomeePage;
import org.info.pages.qproducts.LoginePage;
import org.info.pages.qproducts.PoductsPage;
import org.info.utils.WebUtilpvt;
import org.testng.annotations.Test;

public class qProductsAutomationScripts {
@Test
	public void testTheCrearProductWithRequiredFields() {
		WebUtilpvt wu=new WebUtilpvt();
		wu.launchBrowser("chrome");
		wu.openUrl("http://localhost:9999");
		
		LoginePage lp=new LoginePage(wu);
        lp.validLoginPage();
		
        HomeePage hp=new HomeePage(wu);
        hp.clickOnProductLink();
        
        PoductsPage pp= new PoductsPage(wu);
        pp.clickOnCreatProductBt();
        
        CreatingNewProductPage cnp=new CreatingNewProductPage(wu);
        cnp.typeRequiredFields();
        cnp.saveButton();
}
}