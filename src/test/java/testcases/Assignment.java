package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/*1. Check the first  Checkbox and verify if it is successfully checked and 
		 * Uncheck it again to verify if it is successfully Unchecked*/
		WebElement firstCheckBoxElement = driver.findElement(By.id("checkBoxOption1"));	
		
		//clicking
		firstCheckBoxElement.click();
		
		//verify if it is clicked
		Assert.assertTrue(firstCheckBoxElement.isSelected());
		
		//unclicking 
		firstCheckBoxElement.click();
		
		//verifying if it is unclicked
		Assert.assertFalse(firstCheckBoxElement.isSelected());
		
		/*How to get the Count of number of check boxes present in the page*/
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		System.out.println("Total checkboxes : "+checkboxes.size());
		
	}

}
