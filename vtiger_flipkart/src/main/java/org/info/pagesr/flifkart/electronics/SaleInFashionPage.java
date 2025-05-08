package org.info.pagesr.flifkart.electronics;

import org.info.pagest.or.SaleFashionOr;
import org.info.utils.WebUtilpvt;

public class SaleInFashionPage extends SaleFashionOr {
private WebUtilpvt webu;

public SaleInFashionPage(WebUtilpvt webObj) {
	super(webObj);
	webu=webObj;
}

public void mensClothingUspa() {
	webu.click(getMenCloth(), "clickOnMenUspa");
}
}
