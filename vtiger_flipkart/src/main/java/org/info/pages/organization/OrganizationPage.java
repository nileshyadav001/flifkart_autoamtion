package org.info.pages.organization;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
public WebUtil wu;

public OrganizationPage(WebUtil wuObj) {
	wu=wuObj;
	PageFactory.initElements(wu.driver,this);
}
@FindBy(xpath="//img[@alt='Create Organization...']")
WebElement creatButton;

public void clickOnCreatButton() {
	wu.click(creatButton,"creatBt");
}
}
