package org.info.pagest.or;

import org.info.utils.WebUtilpvt;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeOr {
public HomeOr(WebUtilpvt webuObj) {
	PageFactory.initElements(webuObj.getDriver(), this);
}

@FindBy(xpath="//img[@alt='Electronics']")
private WebElement electronics;

@FindBy(xpath="//img[@alt='Mobiles & Tablets']")
private WebElement Mobilestablets;

@FindBy(xpath="//span[text()='Fashion']")
private WebElement Fashion;

public WebElement getElectronics() {
	return electronics;
}

public WebElement getMobilesTablets() {
	return Mobilestablets;
}

public WebElement getFashion() {
	return Fashion;
}
}
