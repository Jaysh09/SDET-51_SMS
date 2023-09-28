package java.com.SMS.ObjectRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SMS.genericUtils.IpathConstants;
import com.SMS.genericUtils.JavaUtility;
import com.SMS.genericUtils.WebDriverUtility;

public class MyProfileUpdatePAge extends WebDriverUtility {
	@FindBy(xpath = "//input[@id='full_name1']")
	private WebElement Fullname;
	
	@FindBy(xpath = "//input[@id='i_name1']")
	private WebElement initialname;
	 
	@FindBy(xpath = "//input[@id='address1']")
	private WebElement address;
	
	@FindBy(xpath = "//input[@id='phone1']")
	private WebElement PhoneNo;
	
	@FindBy(xpath = "//select[@name='gender']")
	private WebElement GenderDD;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement UpdateBtn;
	
	//initialization 
	public MyProfileUpdatePAge (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFullname() {
		return Fullname;
	}

	public WebElement getinitialname() {
		return initialname;
	}

	public WebElement getaddress() {
		return address;
	}

	public WebElement getPhoneNo() {
		return PhoneNo;
	}

	public WebElement getGenderDD() {
		return GenderDD;
	}

	public WebElement getUpdateBtn() {
		return UpdateBtn;
	}
		
	
	//Business Libraries
	
	public void Profileupdate(HashMap<String, String> map, WebDriver driver, String gender)
	{
		
		for(Entry<String, String> s: map.entrySet())
		{
			driver.findElement(By.xpath(s.getKey())).clear();
			driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue());
		}
		selectDropDown(gender, GenderDD);
		UpdateBtn.click();
	}
	
}
