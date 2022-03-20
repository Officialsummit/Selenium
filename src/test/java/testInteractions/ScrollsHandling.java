package testInteractions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollsHandling {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		
		//using JavaScipt executer for scrolling
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;		
		jsExecutor.executeScript("window.scroll(0,500)");
		
		jsExecutor.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> tdValues = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		
		for(int i=0;i<tdValues.size();i++) {
			sum = sum+Integer.parseInt(tdValues.get(i).getText());
			
		}
		System.out.println(sum);
		
		int expectedSum = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(expectedSum, sum);
		
		
		
		
	}

}
