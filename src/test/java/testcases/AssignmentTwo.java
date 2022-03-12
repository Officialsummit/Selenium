package testcases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentTwo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.xpath("//form/div[1]/input[@name='name']")).sendKeys("test");
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("test@gmail.com");
		
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("test1234");
		
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement genderElement = driver.findElement(By.id("exampleFormControlSelect1"));
		Select select = new Select(genderElement);		
		select.selectByVisibleText("Female");
		
		Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isSelected());
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("02021988");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		WebElement alertElement = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/strong"));
		
		System.out.println(alertElement.getText());
		Assert.assertEquals(alertElement.getText(), "Success!");
		
		
		
		
		
		

	}

}
