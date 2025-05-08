package org.info.pagest.or;

import org.info.utils.WebUtilpvt;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ElectronicSaleLiveOr {
		public ElectronicSaleLiveOr(WebUtilpvt webuObj) {
			PageFactory.initElements(webuObj.getDriver(),this);
		}
		
		@FindBy(xpath="(//a[text()='VIEW ALL'])[2]")
		private WebElement viewAll;
		
		public WebElement getViewAll() {
			return viewAll;
		}
}
