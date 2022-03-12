package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EnabledDisabledTest {
	public static WebDriver driver;

	public static void main(String[] args) {
		ChromesetUp chromesetUp = new ChromesetUp();
		driver = chromesetUp.setupChrome(driver, "https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='DEL']")).click();	
		
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='GOI']")).click();
		driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-highlight ui-state-hover']")).click();
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		//round trip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		//the opacity is changing so verifying opacity for disabled element
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		

	}

}
