package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPopUpHandling {
	public static WebDriver driver;

	public static void main(String[] args) {
		String name = "Test";
		ChromesetUp chromesetUp = new ChromesetUp();
		driver = chromesetUp.setupChrome(driver, "https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).sendKeys(name);
		
		driver.findElement(By.id("alertbtn")).click();
		
		/*alert can be found by findelement as it resides outside dom.We can capture
		 * it by using switching to alert method*/
		
		//grabbing the alert box text
		
		System.out.println(driver.switchTo().alert().getText().contains("Test"));
		
		driver.switchTo().alert().accept();

	}

}
