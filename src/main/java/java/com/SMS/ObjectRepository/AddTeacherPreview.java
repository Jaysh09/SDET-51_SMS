package java.com.SMS.ObjectRepository;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTeacherPreview {
	
	@FindBy(xpath = "//input[@placeholder='Enter index number']")
	private WebElement IndexNo;
	
	@FindBy(xpath = "//input[@placeholder='Enter full name']")
	private WebElement FullName;
	
	@FindBy(xpath = "//input[@placeholder='Enter name with initials']")
	private WebElement InitialName;
	
	@FindBy(xpath = "//input[@placeholder='Enter address']")
	private WebElement Address;

	@FindBy(xpath = "//select[@id='gender']")
	private WebElement Gender;
	
	@FindBy(xpath = "//input[@placeholder='123-456-7890']")
	private WebElement PhoneNo;
	
	@FindBy(xpath = "//input[@placeholder='Enter valid email address']")
	private WebElement Email;
	
	@FindBy(xpath = "//input[@name='fileToUpload' and @style='margin-top:7px;']")
	private WebElement Photo;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submit;
	
	//initialization 
	public AddTeacherPreview(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}

	//utilization 
	public WebElement getIndexNo() {
		return IndexNo;
	}

	public WebElement getFullName() {
		return FullName;
	}

	public WebElement getInitialName() {
		return InitialName;
	}

	public WebElement getAddress() {
		return Address;
	}

	public WebElement getGender() {
		return Gender;
	}

	public WebElement getPhoneNo() {
		return PhoneNo;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getPhoto() {
		return Photo;
	}

	public WebElement getSubmit() {
		return submit;
	}

	//Business Libraries
	public void Submit()
	{
		submit.click();
	}
}
