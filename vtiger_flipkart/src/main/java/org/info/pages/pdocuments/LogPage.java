package org.info.pages.pdocuments;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogPage {

@FindBy(xpath="//input[@name='user_name']")
public WebElement userName;

@FindBy(xpath="//input[@name='user_password']")
public WebElement userPassword;

@FindBy(xpath="//input[@id='submitButton']")
public WebElement loginBt;

public void  validLoginCreadential(WebUtil wu) {
	wu.type(userName, "admin","userName");
	wu.type(userPassword,"automation","admin");
	wu.click(loginBt,"loginBt");
}

}
