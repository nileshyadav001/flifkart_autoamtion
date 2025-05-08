package org.info.pages.qproducts;

import org.info.utils.WebUtilpvt;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage extends BasePage {
	
	private WebUtilpvt wu;
	
	public CreatingNewProductPage(WebUtilpvt wuObject) {
		super(wuObject);
		wu=wuObject;
		PageFactory.initElements(wu.getDriver(),this);
	}
	
@FindBy(xpath="//input[@name='productname']")
private WebElement productName;
public WebElement getProductName() {
	return productName;
}


	public void typeRequiredFields() {
		wu.type(getProductName(), "flifKart", "flifkart");
	}
	}
