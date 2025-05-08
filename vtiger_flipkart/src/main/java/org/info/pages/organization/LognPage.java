package org.info.pages.organization;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LognPage {

	public WebUtil wu;
	
	public LognPage(WebUtil wuObject) {
		wu=wuObject;
		PageFactory.initElements(wu.driver, this);
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@name='user_password']")
	public WebElement userPassword;
	
	@FindBy(xpath="//input[@id='submitButton']")
	public WebElement loginBt;
	
	//methods
	public void validLoginCredential() {

	wu.type(userName,"admin","admin");
	wu.type(userPassword,"automation","admin");
	wu.click(loginBt,"loginBt");
		
	}
	
	public void invalidLoginCredential() {

	}
}
