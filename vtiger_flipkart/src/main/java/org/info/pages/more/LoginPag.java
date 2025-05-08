package org.info.pages.more;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;

public class LoginPag {
//Constructor through code perform ,doing the WebUtil in wu initialized 
	public WebUtil wu;
	public LoginPag(WebUtil wuObject) {
		wu=wuObject;
	}
	public void validLoginCredential() {
	
		WebElement userName=wu.searchElement("//input[@name='user_name']", "userName");
		wu.type(userName,"admin","admin");
		WebElement passName=wu.searchElement("//input[@name='user_password']", "passwName");
		wu.type(passName,"automation","admin");
		WebElement loginbt=wu.searchElement("//input[@id='submitButton']", "loginClick");
		wu.click(loginbt,"loginBt");
		
	}
	
}
