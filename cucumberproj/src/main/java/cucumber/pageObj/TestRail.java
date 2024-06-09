package cucumber.pageObj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;



public class TestRail {


	XSSFWorkbook work_book;
	XSSFSheet sheet;



	ExcelData read = new ExcelData();
	public static WebElement element = null;

	public void SignInpage(WebDriver driver) throws InterruptedException, IOException {
		
		driver.manage().window().maximize();
		ChromeOptions options = new ChromeOptions();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(
				"https://secure.testrail.com/customers/testrail/trial/?type=signup&utm_term=testing%20tools&utm_campaign=gg_dg_geo6_search_non_branded&utm_source=google&utm_medium=cpc&utm_content=medium_intent_qa_tools&hsa_acc=9739162558&hsa_cam=18929403020&hsa_grp=146518110627&hsa_ad=635046738226&hsa_src=g&hsa_tgt=kwd-113746915&hsa_kw=testing%20tools&hsa_mt=p&hsa_net=adwords&hsa_ver=3&gad_source=1&gclid=CjwKCAjw26KxBhBDEiwAu6KXt8f0GnDem9LasS43p4A3Z7ife6kDJSvY3MXtBAAIF70WQWGyMkkyoBoC-LYQAvD_BwE");
		Thread.sleep(4000);
	}
	public void PrivacyPage(WebDriver driver) throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(4000);
		driver.findElement(By.linkText("Privacy Policy")).click();
		
		Thread.sleep(4000);
		
		//a1.moveToElement(driver.findElement(By.id("cookiescript_reject"))).click().build().perform();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cookiescript_reject']")));
		
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		/*
		 * Set<String> windows = driver.getWindowHandles(); Iterator<String> iterator =
		 * windows.iterator(); String ParentWindow = iterator.next(); String ChildWindow
		 * = iterator.next(); driver.switchTo().window(ParentWindow);
		 * Thread.sleep(5000); js.executeScript("window.scrollBy(0,-1000)");
		 */

	}

	public void Windowidw(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String ParentWindow = iterator.next();
		String ChildWindow = iterator.next();
		driver.switchTo().window(ParentWindow);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,-1000)");
		
	}

	@DataProvider

	public String[][] UserInfo() throws IOException {
		// public static void main(String[] args) throws IOException{
		File s = new File("C:\\Users\\srina\\OneDrive\\Documents\\Test\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(s);
		XSSFWorkbook work_book = new XSSFWorkbook(stream);
		XSSFSheet sheet = work_book.getSheet("Sheet1");
		int NoRow = sheet.getPhysicalNumberOfRows();
		int NoCol = sheet.getRow(0).getLastCellNum();

		// Iterate through the rows and columns to read the data
		String[][] data = new String[NoRow - 1][NoCol];
		for (int i = 0; i < NoRow - 1; i++) {
			for (int j = 0; j < NoCol; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));

			}

		}
		// for( String[] dataArr :data) {

		// System.out.println(Arrays.toString(dataArr));

		work_book.close();
		stream.close();
		return data;

	}
	
}
