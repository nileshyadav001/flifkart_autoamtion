package RunnerTestScripts;

import org.info.utils.WebUtils_Generic;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestRunnerScripts {
@Test
	public void testVtiger() {
	try {
		WebUtils_Generic gen=new WebUtils_Generic();
		gen.launchBrowser("chrome");
		gen.openUrl("http://localhost:7617");
		
		WebElement webUser=gen.searchElement("//input[@name='user_name']");
		gen.type(webUser, "admin");
		
		WebElement wePas=gen.searchElement("//input[@name='user_password']");
		gen.type(wePas,"automation");
		
		WebElement webClick=gen.searchElement("//input[@id='submitButton']");
		gen.snapshot("HomePage", "HomePage");
		gen.snapshotRandomElement(webClick,"loginBt","loginButton");
		gen.jsClick(webClick);
		
//		WebElement iIcon=gen.searchElement("//img[@src='themes/softed/images/info.PNG']");
//		
//		//gen.click(iIcon);
//		gen.mouseOver(iIcon);
//		WebElement feedBackBT=gen.searchElement("//a[text()='Feedback']");
//		gen.click(feedBackBT);
//		
//		gen.switchToWindowByTitle(" ");
//		WebElement textWrite=gen.searchElement("//textarea[@name='description']");
//		gen.type(textWrite, "A detailed exception in your project");
		WebElement contacts=gen.searchElement("//a[text()='Contacts']");
		gen.click(contacts);
		WebElement creatBt=gen.searchElement("//img[@alt='Create Contact...']");
		gen.click(creatBt);
		WebElement saveBt=gen.searchElement("//input[@title='Save [Alt+S]']");
		gen.click(saveBt);
		
		gen.popupDismiss();
		
	 }catch(Exception e) {
		e.printStackTrace();
		throw e;
	}
	}

}
