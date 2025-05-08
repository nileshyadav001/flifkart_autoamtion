package org.info.pages.more;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;

public class HomePag {
public WebUtil wu;
public HomePag(WebUtil wuObject) {
	wu=wuObject;
}

	public void clickMoreLink() {
		WebElement  moreBt=wu.searchElement("//a[@href='javascript:;']","more");
		wu.mouseOver(moreBt,"more module in mouseOver");
		WebElement  moreServiceCo=wu.searchElement("//a[text()='Service Contracts']","Service Contracts");
		wu.click(moreServiceCo, "Service Contracts");
	}
	

	
}
