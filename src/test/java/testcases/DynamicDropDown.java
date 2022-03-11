package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class DynamicDropDown {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromesetUp chromesetUp = new ChromesetUp();
		driver = chromesetUp.setupChrome(driver, "https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		
		//driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();
		
		//specific parent-child traverse for specific element
		
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='GOI']")).click();
		
		
		

	}

}
