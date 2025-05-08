package org.info.pages.contacts;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;

public class ContactsPage {

	public void  clickOnCreatContactButton(WebUtil wu) {
	
	WebElement creatBt=wu.searchElement("//img[@alt='Create Contact...']","plusBt");
	wu.click(creatBt,"plusBt");
	
	}
}
