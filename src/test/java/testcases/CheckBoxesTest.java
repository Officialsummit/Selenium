package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckBoxesTest {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		ChromesetUp chromesetUp = new ChromesetUp();
		driver = chromesetUp.setupChrome(driver, "https://www.spicejet.com/");
		
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-n6v787 r-1ozqkpa']")); 
				
		//Select students		
		
		for(WebElement checkbox : checkBoxes) {
			if(checkbox.getText().equalsIgnoreCase("Students")) {
				checkbox.click();
				Thread.sleep(2000);
				Assert.assertEquals(checkbox.getText(), "Students");
			}
		}

	}

}
