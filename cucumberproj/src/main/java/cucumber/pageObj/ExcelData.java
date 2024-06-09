package cucumber.pageObj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ExcelData {

	
	
    XSSFWorkbook work_book;
    XSSFSheet sheet;

public  void TestData(WebDriver driver) throws IOException, InterruptedException {
	   JavascriptExecutor js = (JavascriptExecutor)driver;
File s = new File("C:\\Users\\srina\\OneDrive\\Documents\\Test\\Book1.xlsx");
FileInputStream stream = new FileInputStream(s);
 work_book = new XSSFWorkbook(stream);
 sheet = work_book.getSheet("Sheet1");

 // Iterate through the rows and columns to read the data
 for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
     XSSFRow row = sheet.getRow(rowNum);
     String username = row.getCell(0).getStringCellValue();
     String password = row.getCell(1).getStringCellValue();
  // Execute the test with the current set of data
     driver.manage().window().maximize();
		driver.get("https://secure.testrail.com/customers/testrail/trial/?type=signup&utm_term=testing%20tools&utm_campaign=gg_dg_geo6_search_non_branded&utm_source=google&utm_medium=cpc&utm_content=medium_intent_qa_tools&hsa_acc=9739162558&hsa_cam=18929403020&hsa_grp=146518110627&hsa_ad=635046738226&hsa_src=g&hsa_tgt=kwd-113746915&hsa_kw=testing%20tools&hsa_mt=p&hsa_net=adwords&hsa_ver=3&gad_source=1&gclid=CjwKCAjw26KxBhBDEiwAu6KXt8f0GnDem9LasS43p4A3Z7ife6kDJSvY3MXtBAAIF70WQWGyMkkyoBoC-LYQAvD_BwE");
		Thread.sleep(4000);
	 	  js.executeScript("window.scrollBy(0,1000)");
		   Thread.sleep(4000);
		driver.findElement(By.linkText("Privacy Policy")).click();
		Thread.sleep(5000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String ParentWindow = iterator.next();
		String ChildWindow = iterator.next();
		driver.switchTo().window(ParentWindow);
		Thread.sleep(5000);
		 js.executeScript("window.scrollBy(0,-1000)");
		driver.findElement(By.xpath("//*[@class='btn btn-success btn-trial']")).click();
		driver.findElement(By.id("first_name")).sendKeys(username);

} 
 

}

}
