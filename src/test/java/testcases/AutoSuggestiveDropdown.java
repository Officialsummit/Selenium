package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoSuggestiveDropdown {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromesetUp chromesetUp = new ChromesetUp();
		driver = chromesetUp.setupChrome(driver ,"https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		
		Thread.sleep(2000);
		
		List<WebElement> optionsElements = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		for(WebElement option : optionsElements ) {
			if(option.getText().equalsIgnoreCase("Indonesia")) {
				option.click();
			}
		}
		


	}

}
