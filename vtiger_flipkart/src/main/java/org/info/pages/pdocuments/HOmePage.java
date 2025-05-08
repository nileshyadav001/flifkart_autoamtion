package org.info.pages.pdocuments;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HOmePage {
	
	@FindBy(xpath="//a[text()='Documents']")
	public WebElement documentsLink;
	
	public void clickOnDocumentsLink(WebUtil wu) {
		wu.click(documentsLink, "documents");
	}
}
