package org.info.pages.qproducts;

import org.info.utils.WebUtilpvt;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeePage extends BasePage {
	private WebUtilpvt wu;
	
	public HomeePage(WebUtilpvt wuObject) {
		super(wuObject);
		wu=wuObject;
		PageFactory.initElements(wu.getDriver(),this);
	}
	
@FindBy(xpath="//a[text()='Products']")
private WebElement product;
public WebElement getProduct() {
	return product;
}


	public void clickOnProductLink() {
		wu.click(getProduct(),"products");
	}
}
