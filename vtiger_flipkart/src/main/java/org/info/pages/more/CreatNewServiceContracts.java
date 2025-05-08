package org.info.pages.more;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;

public class CreatNewServiceContracts {//img[@alt='Create Service Contract...']
public WebUtil wu;
public CreatNewServiceContracts(WebUtil wuObject) {
	wu=wuObject;
}
public void creatServiceContracts() {
	WebElement name=wu.searchElement("//img[@alt='Create Service Contract...']","serviceContract");
	
}

}
