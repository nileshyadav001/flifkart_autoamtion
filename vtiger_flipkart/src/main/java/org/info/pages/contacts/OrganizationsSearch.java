package org.info.pages.contacts;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;

public class OrganizationsSearch {
	
   public void orgSearch(WebUtil wu) {
	   wu.switchToWindowByUrl("http://localhost:7617/index.php?module=Accounts&action=Popup");
	WebElement org=wu.searchElement("//input[@id='search_txt']", "orgSearch");
	wu.type(org,"Nilesh","orgSearch");
	wu.ScreenShot("Organization","searchPage");
	
}
}
