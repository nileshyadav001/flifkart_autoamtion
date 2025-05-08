package org.info.pages.qproducts;

import org.info.utils.WebUtilpvt;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoductsPage {
	private WebUtilpvt wu;
	
	public PoductsPage(WebUtilpvt wuObject) {
		wu=wuObject;
		PageFactory.initElements(wu.getDriver(),this);
	}
	
@FindBy(xpath="//img[@alt='Create Product...']")
private WebElement creatProductButton;
public WebElement getcreatProductButton() {
	return creatProductButton;
}


	public void clickOnCreatProductBt() {
		wu.click(getcreatProductButton(),"productPlusBt");
	}
}
