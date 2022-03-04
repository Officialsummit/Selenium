package testcases;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static void main(String[] args) {
		
		//chrome set and drive instantiate
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		//go to url
		driver.get("https://gmail.com");
		
		//username field
		WebElement username = driver.findElement(By.id("identifierId"));
		username.sendKeys("slnmtest1001@gmail.com");
		
		// username submit button
		WebElement button = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
		button.click();	
		
		
		//using fluent wait for password field
		WebElement password_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password_field.sendKeys("asasaSAsA");
		
		WebElement pass_btn = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
		pass_btn.click();
		
		//using fluent wait 
		System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span"))).getText());
		
		
		
		
		
		
		

	}

}
