package java.com.SMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pettycash
{
	
@FindBy(xpath = "//span[text()='My Petty Cash']")
private WebElement MyPettyCash;

@FindBy(xpath = "//a[text()='Add ']")
private WebElement AddButton;

@FindBy(id = "textDesc_1")
private WebElement Desc;

@FindBy(id = "textAmount_1")
private WebElement Amount;

@FindBy(id = "btnSubmit")
private WebElement Submit;

@FindBy(xpath = "//span[@class='hidden-xs']")
private WebElement Signout;


public Pettycash(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getMyPettyCash() {
	return MyPettyCash;
}

public WebElement getAddButton() {
	return AddButton;
}

public WebElement getDesc() {
	return Desc;
}

public WebElement getAmount() {
	return Amount;
}

public WebElement getSubmit() {
	return Submit;
}

public WebElement getSignout() {
	return Signout;
}


public void clickonpetty()
{
	MyPettyCash.click();
}

public void addButton()
{
	AddButton.click();
}

public void description()
{
	Desc.click();
}

public void amount()
{
	Amount.click();
}

public void submit()
{
	Submit.click();
}
public void signOut()
{
	Signout.click();
}





}