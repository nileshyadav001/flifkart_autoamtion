package org.info.pagesr.flifkart.electronics;

import org.info.pagest.or.ComputerAccessoriesOr;
import org.info.utils.WebUtilpvt;

public class ComputerAccessoriesPage extends ComputerAccessoriesOr  {
	public WebUtilpvt webu;


	public ComputerAccessoriesPage(WebUtilpvt wuObj) {
		super(wuObj);
		webu=wuObj;
	}

	public void  clickOnKeyboards() {
		webu.click(getKeyboard(),"keyboard");
	}
}
