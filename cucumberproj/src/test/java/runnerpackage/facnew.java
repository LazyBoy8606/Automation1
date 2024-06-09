package runnerpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class facnew {
	

	public WebDriver driver;

	public facnew(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement Email;
	@FindBy(id = "phone")
	WebElement Phone;
	@FindBy(id = "organization")
	WebElement Organization;
	@FindBy(id = "first_name")
	WebElement FirstName;
	@FindBy(id = "last_name")
	WebElement LastName;
	@FindBy(id = "tos")
	WebElement check1;
	@FindBy(id = "gdpr")
	WebElement check2;
	@FindBy(id = "hostname")
	WebElement HostName;

	public WebElement firstname() {
		return FirstName;
	}

	public WebElement lastname() {
		return LastName;
	}

	public WebElement emailid() {
		return Email;
	}

	public WebElement Phonenumber() {
		return Phone;
	}

	public WebElement organization() {
		return Organization;
	}

	public WebElement check1() {
		return check1;
	}

	public WebElement check2() {
		return check2;
	}

	public WebElement hostname() {
		return HostName;
	}


}



