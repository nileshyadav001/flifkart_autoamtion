package org.info.pagesr.flifkart.electronics;

import org.info.pagest.or.HomeOr;
import org.info.utils.WebUtilpvt;

public class HomefPage extends HomeOr {
private WebUtilpvt webu;
	
public HomefPage(WebUtilpvt webuObj) {
	super(webuObj);
	webu=webuObj;
}

public void clickOnElectronicsLink() {
	webu.click(getElectronics(), "electronics");
}

public void clickOnMobiles_Tablates() {
	webu.click( getMobilesTablets(),"mobilesTablete");
}

public void clickOnFashion() {
	webu.click(getFashion(), "fashionclick");
}
}
