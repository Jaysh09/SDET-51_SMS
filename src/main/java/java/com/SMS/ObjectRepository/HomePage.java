package java.com.SMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText  = "My Profile")
	private WebElement MyProfileLink;
	
	@FindBy(linkText = "Teacher")
	private WebElement TeacherLink;
	
	@FindBy(linkText = "Subject Routing")
	private WebElement SubjectRoutingLink;
	
	@FindBy(xpath = "//span[@class='hidden-xs']")
	private WebElement Signout;
	
	@FindBy(xpath = "//a[text()=' Add Teacher']")
	private WebElement AddTeacher;
	
	
	
	//Initialization
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getMyProfileLink() {
	return MyProfileLink;
}

public WebElement getTeacherLink() {
	return TeacherLink;
}

public WebElement getSubjectRoutingLink() {
	return SubjectRoutingLink;
}

public WebElement getSignout() {
	return Signout;
}

public WebElement getAddTeacher() {
	return AddTeacher;
}

public void AddTeacher()
{
	AddTeacher.click();
}

public void Teacher()
{
	TeacherLink.click();
}
public void ClickonMyProfilePage() 
{
	
	MyProfileLink.click();
}
}




