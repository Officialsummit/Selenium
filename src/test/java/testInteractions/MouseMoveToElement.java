package testInteractions;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MouseMoveToElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		Actions action = new Actions(driver);
		
		//Enter search in capital letters
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("monitor").keyUp(Keys.SHIFT);
		
		
		//Delete the prioulsy searched and enter new search item -books
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().sendKeys(Keys.DELETE).sendKeys("books");
		
		
		//Move to signin in 
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		
		
		

	}

}
