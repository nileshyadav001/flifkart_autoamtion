package org.info.pages.qproducts;

import org.info.utils.WebUtilpvt;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginePage {

	private WebUtilpvt wu;
	public  LoginePage(WebUtilpvt wuObject) {
		wu=wuObject;
		PageFactory.initElements(wu.getDriver(),this);
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement user_name;
	public WebElement getUser_name() {
		return user_name;
	}

	@FindBy(xpath="//input[@name='user_password']")
	public WebElement user_password;
	public WebElement getUser_password() {
		return user_password;
	}
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement loginId;
	public WebElement getLoginId() {
		return loginId;
	}
	
	public void validLoginPage() {
		wu.type(getUser_name(),"admin", "passwordName");
		wu.type(getUser_password(), "automation", "userPassword");
		wu.click(getLoginId(), "loginBt");
	}
}
