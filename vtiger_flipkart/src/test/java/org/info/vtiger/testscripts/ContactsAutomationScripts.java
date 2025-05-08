package org.info.vtiger.testscripts;

import org.info.pages.contacts.ContactsPage;
import org.info.pages.contacts.CreatNewContactPage;
import org.info.pages.contacts.HomePage;
import org.info.pages.contacts.InformationPage;
import org.info.pages.contacts.LoginPage;
import org.info.pages.contacts.OrganizationsSearch;
import org.info.utils.WebUtil;
import org.testng.annotations.Test;

public class ContactsAutomationScripts {
@Test
	public void testContactCreationWithRequredFieldsOnly() {
		try {
		WebUtil wu=new WebUtil();
		wu.launchBrowser("chrome");	
		wu.openUrl("http://localhost:9999");
		
		LoginPage lp=new LoginPage();
		lp.validLoginCredential(wu);
		//lp.invalidLoginCredential(wu);
		
		HomePage hp=new HomePage();
		hp.clickContactsLink(wu);
		
		ContactsPage cp=new ContactsPage();
		cp.clickOnCreatContactButton(wu);
		
		CreatNewContactPage cnc=new CreatNewContactPage();
		cnc.creatContact(wu);
		cnc.clickOnSaveButton(wu);
		
		InformationPage InPage=new InformationPage();
		InPage.informationChecked(wu);
		
		CreatNewContactPage cn=new CreatNewContactPage();
		cn.creatContact(wu);
		cn.plusButton(wu);
		
		OrganizationsSearch Orgsea=new OrganizationsSearch();
		Orgsea.orgSearch(wu);
		
		//wu.closeBrowser();
		wu.closeAllBrowser();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
@Test
public void testContactCreationWithoutRequiredFieldsOnly() {
	
	try {
	WebUtil wu=new WebUtil();
	wu.launchBrowser("chrome");	
	wu.openUrl("http://localhost:9999");
	
	LoginPage lp=new LoginPage();
	lp.validLoginCredential(wu);
	//lp.invalidLoginCredential(wu);
	
	HomePage hp=new HomePage();
	hp.clickContactsLink(wu);
	
	ContactsPage cp=new ContactsPage();
	cp.clickOnCreatContactButton(wu);
	
	CreatNewContactPage cnc=new CreatNewContactPage();
	cnc.clickOnSaveButton(wu);
	wu.staticWait(4);
	cnc.popupHandle(wu);
	wu.ScreenShot("popup","creatPage");
	//wu.closeBrowser();
	wu.closeAllBrowser();
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
@Test
public void testTheCancelButtonContactCreation() {
	
	try {
	WebUtil wu=new WebUtil();
	wu.launchBrowser("chrome");	
	wu.openUrl("http://localhost:9999");
	
	LoginPage lp=new LoginPage();
	lp.validLoginCredential(wu);
	//lp.invalidLoginCredential(wu);
	
	HomePage hp=new HomePage();
	hp.clickContactsLink(wu);
	
	ContactsPage cp=new ContactsPage();
	cp.clickOnCreatContactButton(wu);
	
	CreatNewContactPage cnc=new CreatNewContactPage();
	cnc.creatContact(wu);
	cnc.ClickOnCancelButton(wu);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
