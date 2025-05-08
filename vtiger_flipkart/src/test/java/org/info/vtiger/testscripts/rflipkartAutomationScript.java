package org.info.vtiger.testscripts;

import org.info.pagesr.flifkart.electronics.ComputerAccessoriesPage;
import org.info.pagesr.flifkart.electronics.ElectronicsSaleLivePage;
import org.info.pagesr.flifkart.electronics.HomefPage;
import org.info.pagesr.flifkart.electronics.SaleInFashionPage;
import org.info.utils.WebUtilpvt;
import org.testng.annotations.Test;

public class rflipkartAutomationScript {
@Test
	public void testTheSearchingProduct() {
		WebUtilpvt webu=new WebUtilpvt();
		webu.launchBrowser("chrome");
		webu.openUrl("https://www.flipkart.com");
		
		HomefPage hp=new HomefPage(webu);
		hp.clickOnElectronicsLink();
		
		ElectronicsSaleLivePage esp=new ElectronicsSaleLivePage(webu);
		esp.clickViewAllButton();
		
		ComputerAccessoriesPage cap=new ComputerAccessoriesPage(webu);
		cap.clickOnKeyboards();
		
		webu.closeAllBrowser();
	}
@Test
public void testTheTMobiles_Tablets(){
	WebUtilpvt webu=new WebUtilpvt();
	webu.launchBrowser("chrome");
	webu.openUrl("https://www.flipkart.com");
	
	HomefPage hp=new HomefPage(webu);
	hp.clickOnMobiles_Tablates();
	webu.closeAllBrowser();
}
@Test
public void testTheFashion() {
	WebUtilpvt webu=new WebUtilpvt();
	webu.launchBrowser("firefox");
	webu.openUrl("https://www.flipkart.com");
	HomefPage hp=new HomefPage(webu);
	hp.clickOnFashion();
	
	SaleInFashionPage sfp=new SaleInFashionPage(webu);
	sfp.mensClothingUspa();
}
	
}
