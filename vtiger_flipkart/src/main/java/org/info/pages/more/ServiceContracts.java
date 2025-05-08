package org.info.pages.more;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;

public class ServiceContracts {
	public WebUtil wu;
	public ServiceContracts(WebUtil wuObject) {
		wu=wuObject;
	}
	public void clickOnCreatServiceContractsButton() {
		WebElement plusServiceBt=wu.searchElement("//img[@alt='Create Service Contract...']","serviceContract");
		wu.click(plusServiceBt,"plusBt");
	}
}
