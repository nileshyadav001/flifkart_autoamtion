package org.info.pages.contacts;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;

public class CreatNewContactPage {

	
	public void creatContact(WebUtil wu) {
		WebElement weLastN=wu.searchElement("//input[@name='lastname']","lastName");
		
		wu.type(weLastN,"Yanukupar","lastName");
		
		WebElement weFirstN=wu.searchElement("//input[@name='firstname']","firstname");
		wu.type(weFirstN,"Trilochan","firstname");
		
	}
	
	public void clickOnSaveButton(WebUtil wu) {
		
		WebElement saveBt=wu.searchElement("//input[@title='Save [Alt+S]']","saveB");
		wu.click(saveBt,"svaeB");
	}
	
	public void plusButton(WebUtil wu) {
		WebElement plusBt=wu.searchElement("//img[@alt='Select']","plusB");
		wu.staticWait(2);
		wu.click(plusBt,"plusB");
	}
	
	public void popupHandle(WebUtil wu) {
		wu.popup();
	}
	public void ClickOnCancelButton(WebUtil wu) {
		WebElement cancelBt=wu.searchElement("//input[@title='Cancel [Alt+X]']","cancelBt");
		wu.staticWait(2);
		wu.click(cancelBt,"cancelBt");
	}
}
