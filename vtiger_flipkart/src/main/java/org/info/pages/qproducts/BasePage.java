package org.info.pages.qproducts;

import org.info.utils.WebUtilpvt;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	private WebUtilpvt wu;
	public BasePage(WebUtilpvt wuObject) {
		wu=wuObject;
		PageFactory.initElements(wu.getDriver(),this);
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	protected WebElement clickSaveBotton;
	
	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	protected WebElement clickCancelBotton;
	
	public void saveButton() {
		wu.click(clickSaveBotton, "save");
	}

	
	public void cancelButton() {
		wu.click(clickCancelBotton, "save");
	}
	
}
