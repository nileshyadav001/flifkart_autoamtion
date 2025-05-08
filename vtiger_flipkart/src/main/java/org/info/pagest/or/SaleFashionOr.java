package org.info.pagest.or;

import org.info.utils.WebUtilpvt;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaleFashionOr {
	public SaleFashionOr(WebUtilpvt webu) {
		PageFactory.initElements(webu.getDriver(), this);
	}
	@FindBy(xpath="//div[@class='ZHvV68']")
	private WebElement menCloth;
	public WebElement getMenCloth() {
		return menCloth;
	}
	
}
