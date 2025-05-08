package org.info.pagest.or;

import org.info.utils.WebUtilpvt;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerAccessoriesOr {

public ComputerAccessoriesOr(WebUtilpvt wuObj) {
	PageFactory.initElements(wuObj.getDriver(),this);
}

@FindBy(xpath="//div[text()='Keyboards']")
private WebElement keyboard;

public WebElement getKeyboard() {
	return keyboard;
}
}
