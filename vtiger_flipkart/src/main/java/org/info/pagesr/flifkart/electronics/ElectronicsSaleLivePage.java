package org.info.pagesr.flifkart.electronics;

import org.info.pagest.or.ElectronicSaleLiveOr;
import org.info.utils.WebUtilpvt;



public class ElectronicsSaleLivePage extends ElectronicSaleLiveOr  {
	
	private WebUtilpvt webu;
public ElectronicsSaleLivePage(WebUtilpvt webuOb) {
	super(webuOb);
	webu=webuOb;
   }

public void clickViewAllButton() {
	webu.click(getViewAll(),"viewAll");
}
}
