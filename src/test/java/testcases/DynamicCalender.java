package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicCalender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.agoda.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		driver.findElement(By.xpath("//div[@data-element-name='check-in-box']/div")).click();
		
		//checkin Date
		getDate(driver, "25");
		
		//check out date
		getDate(driver, "28");		
	
	
	
	}
	
	public static void getDate(WebDriver driver, String date) {
		List<WebElement> dates	=  driver.findElements(By.xpath("(//div[@class='DayPicker-Body'])[1]/div/div"));
		for (WebElement i : dates) {		
			if(i.getText().equalsIgnoreCase(date)) {
				i.click();
				break;
			}
				
			}
		
	}

}
