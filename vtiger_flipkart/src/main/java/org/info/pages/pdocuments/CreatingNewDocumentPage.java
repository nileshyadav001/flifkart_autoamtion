package org.info.pages.pdocuments;
import java.util.List;
import org.info.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CreatingNewDocumentPage {


	@FindBys(@FindBy(xpath="//a"))
	public List<WebElement>InnerText;
	
	@FindBy(xpath="//input[@name='notes_title']")
	public WebElement title;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	public WebElement saveButton;
	
	
	public void printAllLinkOfInnerText(WebUtil wu) {
		int textSize=InnerText.size();
		System.err.println("All Element count="+textSize);
		
		int blankLinkCount=0;
		int nonBlankLinkCount=0;
		for(int i=0;i<=textSize-1;i++) {
			WebElement textPrint=InnerText.get(i);
			String innertext=wu.getInnerText(textPrint);
		
			if(innertext.equals(" ")==true) {
				blankLinkCount=blankLinkCount++;
			}else {
				nonBlankLinkCount=nonBlankLinkCount++;
			}
			System.out.println(innertext);
		

		}
		System.err.println("blankLinkCount="+blankLinkCount);
		System.err.println("nonBlankLinkCount="+nonBlankLinkCount);
	}
	
	public void creatDocuments(WebUtil wu) {
		wu.type(title,"Exepireence", "title");
		
	}
	
	public void saveDucument(WebUtil wu) {
	wu.click(saveButton, "DucumentSave");
	
	}
}
