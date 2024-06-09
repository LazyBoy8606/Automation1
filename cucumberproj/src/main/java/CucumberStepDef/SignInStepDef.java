package CucumberStepDef;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.pageObj.ReilUserFields;
import cucumber.pageObj.TestRail;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class SignInStepDef {
	public static final WebDriver ChromeDriver = null;

	WebDriver driver1;

	@Given("User invokes Chrome")
	public void User_invokes_Chrome() {
		driver1 = new ChromeDriver();
		
		return;
	}

	@And("User navigates to TestRail Trial SignIn Page")
	public void user_navigates_to_test_rail_trial_sign_in_page() throws InterruptedException, IOException {
		
		TestRail RailSignInPage = new TestRail();
		RailSignInPage.SignInpage(driver1);
			
			}
	   

	@And("User open privacy policy page")
	public void user_open_privacy_policy_page() throws InterruptedException, IOException {
		TestRail RailSignInPage = new TestRail();
		RailSignInPage.PrivacyPage(driver1);
	    
	}

	@And("User Navigates back to SignIn Page")
	public void sign_in_using_different_user() throws InterruptedException {
		TestRail RailSignInPage = new TestRail();
		RailSignInPage.Windowidw(driver1);
	    
	}
	
	@When("User Submit Details")
	
		public void enter_user_details(DataTable datatable)throws IOException, InterruptedException {
		List<Map<String, String>> userlist = datatable.asMaps(String.class, String.class);
			ReilUserFields elem1 = new ReilUserFields(driver1);
	        Thread.sleep(3000);
	        for (int i=0;i<=8;i++) {
			elem1.firstname().sendKeys(userlist.get(i).get("FirstName"));
			elem1.lastname().sendKeys(userlist.get(i).get("LastName"));
			elem1.emailid().sendKeys(userlist.get(i).get("Email"));
			elem1.organization().sendKeys(userlist.get(i).get("Company"));
		    elem1.Phonenumber().sendKeys(userlist.get(0).get("PhoneNum"));
			

			JavascriptExecutor js = (JavascriptExecutor) driver1;
			js.executeScript("window.scrollBy(0,500)");
			WebDriverWait wait1 = new WebDriverWait(driver1, Duration.ofSeconds(10));
			ReilUserFields elem = new ReilUserFields(driver1);
			Select CountryName = new Select(driver1.findElement(By.xpath("//*[@Class='addressCountry form-control']")));
			CountryName.selectByIndex(15);
			Select maxuser = new Select(driver1.findElement(By.id("users")));
			maxuser.selectByIndex(3);

			elem.hostname().sendKeys("https://tech.com");
			
			driver1.findElement(By.id("tos")).click();
			driver1.findElement(By.id("gdpr")).click();
			driver1.findElement(By.xpath("//*[@class='btn btn-success btn-trial']")).click();
			 
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='form-error']")));
			if(driver1.findElement(By.xpath("//*[@class='form-error']")).getText().equals("The Email Address field must contain a valid email address."))

			 {
			elem.firstname().clear();
			elem.lastname().clear();
			elem.emailid().clear();
			elem.Phonenumber().clear();
			elem.organization().clear();
			elem.hostname().clear();
			driver1.findElement(By.id("tos")).click();
			driver1.findElement(By.id("gdpr")).click();
			 }
			}
					 
		}
	                   

	@Then("User validate the Error message")
	public void user_validate_the_error_message() {
		String ErrorMessage = driver1.findElement(By.xpath("//*[@class='form-error']")).getText();
	 System.out.println(ErrorMessage);
	 driver1.close();
	 
}}



	
