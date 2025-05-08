package org.info.pages.contacts;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;

public class HomePage {

	public void clickContactsLink(WebUtil wu) {
		
		WebElement hp=wu.searchElement("//a[text()='Contacts']", "contacts");
		wu.click(hp,"contactsBt");
	}
	
}
