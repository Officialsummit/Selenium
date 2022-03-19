package testInteractions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PickDateDynamically {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.path2usa.com/travel-companions/");		
		driver.findElement(By.id("travel_date")).click();		
		WebElement month = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));
		
		//Selecting May 5
		
		while(! month.getText().contains("May")) {
			
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
			
		}
		
		
		List<WebElement> dateList = driver.findElements(By.className("day")); //xpath can be also used : [class='datepicker-days'] [class='next']		
		
		for(int i=0;i<dateList.size();i++)
		{
			if(dateList.get(i).getText().equals("5")) {
				dateList.get(i).click();
				break;
			}
		}
		
		
		
		
		

	}

}
