package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//elements
		WebElement username = driver.findElement(By.id("identifierId"));
		username.sendKeys("slnmtest1001@gmail.com");
		
		WebElement button = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
		button.click();
		
		// waiting using thread.sleep(ms) -- not recommended .we gonna use imlicit wait instead
//		try {
//			Thread.sleep(1000);
//		}
//		catch(InterruptedException e) {
//			e.printStackTrace();
//		}
		
		WebElement password_field = driver.findElement(By.name("password"));
		password_field.sendKeys("hitbp1251*");
		
		WebElement pass_btn = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
		pass_btn.click();
		
		
		
		
	}

}
