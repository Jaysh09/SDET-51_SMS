package java.com.SMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	@FindBy(id="btnEdit")
	private WebElement edit;
	
	public MyProfilePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEdit() {
		return edit;
	}
	//business logic or utilization
 public void Editpage()
 {
	 edit.click();
 }
}
