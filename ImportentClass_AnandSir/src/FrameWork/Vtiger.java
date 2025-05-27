package FrameWork;
public class Vtiger {
	public static void verifyloginPage() {
		Ganeric.launchBrowser("chrome");
		
		Ganeric. hitURL("http://localhost:7617");
		
		Ganeric.mysendKeys("//input[@name='user_name']", "userNameTb", "admin");
		
		Ganeric.mysendKeys("//input[@name='user_password']", "userPasswordTb","automation");
		
		Ganeric.myclick("//input[@id='submitButton']", "loginButton");
		
		Ganeric.myclick("//a[text()='Leads']","Leads Element Click");
		
		Ganeric.myclick("//img[@title='Create Lead...']", "+ Leads button click");
		
		Ganeric.getText("//span[@class='lvtHeaderText']", "LaedsPage");
		
		Ganeric.getAttribute("//input[@class='crmbutton small cancel']", "CancelLeads", "value");
	
		Ganeric.SelectByVisibleText("//select[@name='industry']", "VtigerLeads", "Banking");
	}
}
