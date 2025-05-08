package org.info.pages.contacts;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;

public class InformationPage {

public void informationChecked(WebUtil wu) {
	
	WebElement editBt=wu.searchElement("//input[@title='Edit [Alt+E]']","editB");
	wu.click(editBt,"editB");
	
}	
	
}
