package org.info.pages.contacts;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;

public class LoginPage {
//Code perform with ,give the all method of parameter WebUtil wu .
	public void validLoginCredential(WebUtil wu) {
	
		WebElement userName=wu.searchElement("//input[@name='user_name']", "userName");
		wu.type(userName,"admin","admin");
		WebElement passName=wu.searchElement("//input[@name='user_password']", "passwName");
		wu.type(passName,"automation","admin");
		WebElement loginbt=wu.searchElement("//input[@id='submitButton']", "loginClick");
		wu.click(loginbt,"loginBt");
		
	}
	
	public void invalidLoginCredential(WebUtil wu) {
		
//		WebElement userName=wu.searchElement("//input[@name='user_name']", "userName");
//		wu.type(userName,"adin","admin");
//		WebElement passName=wu.searchElement("//input[@name='usr_password']", "passwName");
//		wu.type(passName,"admin","admin");
//		WebElement loginbt=wu.searchElement("//input[@id='submitButton']", "loginClick");
//		wu.click(loginbt,"loginBt");
	}
}
