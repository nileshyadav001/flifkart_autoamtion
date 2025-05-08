package org.info.pages.organization;

import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

   public class HomPage {

       public WebUtil wu;
       public HomPage(WebUtil wuObject) {
    	   wu=wuObject;
    	   PageFactory.initElements(wu.driver,this);
       }

       @FindBy(xpath="//a[text()='Organizations']")
       WebElement orgaLink;
       
  public void clickOrganizationLink() {
	wu.click(orgaLink, "Organization");
}
	
}
