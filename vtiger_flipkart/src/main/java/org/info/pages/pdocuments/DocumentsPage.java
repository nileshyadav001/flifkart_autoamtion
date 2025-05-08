package org.info.pages.pdocuments;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DocumentsPage {

	@FindBy(xpath="//img[@alt='Create Document...']")
	public WebElement ducumentPlusBt;
	
	public void documentsCreatButton(WebUtil wu) {
		wu.click(ducumentPlusBt, "plusBt");
	}
}
