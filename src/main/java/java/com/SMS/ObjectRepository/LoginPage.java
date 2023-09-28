package java.com.SMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	
	@FindBy(id = "email")
	private WebElement IDEdt;
	
	@FindBy(name = "password")
	private WebElement PasswordEdt;
	
	@FindBy(id = "btnSubmit")
	private WebElement SubmitBtn;
	
	//initilazition
	
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements( driver,this);
		}
		//utilization

		public WebElement getIDEdt() {
			return IDEdt;
		}

		public WebElement getPasswordEdt() {
			return PasswordEdt;
		}

		public WebElement getSubmitBtn() {
			return SubmitBtn;
		}
		
		//Business Libraries
		public void login(String ID,String PASSWORD)
		{
			IDEdt.sendKeys(ID);
			PasswordEdt.sendKeys(PASSWORD);
			SubmitBtn.click();
		}
		
		

		
	}
	
	
	


