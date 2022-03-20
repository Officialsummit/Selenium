package testInteractions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SuggestiveDropDownMouseInteract {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.findElement(By.id("autocomplete")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		
		Thread.sleep(1000);
		
		Actions actions = new Actions(driver);
		
		
		List<WebElement> listCountry = driver.findElements(By.cssSelector("#ui-id-1 li"));
		String resultCountry = "India";
		
		for(WebElement country : listCountry) {
			if(country.getText().equalsIgnoreCase(resultCountry)) {
				actions.moveToElement(country).click().build().perform();				
				System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
				break;
				
			}
		}
		
		
		

	}

}
