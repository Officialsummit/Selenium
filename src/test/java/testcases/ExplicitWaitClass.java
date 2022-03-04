package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitClass {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.gmail.com");
			
			driver.manage().window().maximize();
			
			
			//implicit wait : Mostly for ``NoSuchElement`` 
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//Creating explicit wait instance : mostly for “ElementNotVisibleException” exception
			WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));					
			
			
			
			
			//elements
			WebElement username = driver.findElement(By.id("identifierId"));
			username.sendKeys("slnmtest1001@gmail.com");
			
			WebElement button = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
			button.click();	
			
			// WebElement password_field = driver.findElement(By.name("password"));
			
			//using explicit wait for password field
			WebElement password_field = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			password_field.sendKeys("asasaSAsA");
			
			WebElement pass_btn = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
			pass_btn.click();
			
			System.out.println(explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]"))).getText());
			
			
			
			
			

		}
}
