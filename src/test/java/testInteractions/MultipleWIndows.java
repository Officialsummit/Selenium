package testInteractions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWIndows {

	public static void main(String[] args) {	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");		
		driver.findElement(By.className("blinkingText")).click();
		
		//now new tab will open.so we have switch from parent to child tab
		
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentId = iterator.next();
		String childId = iterator.next();
		driver.switchTo().window(childId);
		
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText();
		email = email.split("at")[1].trim().split(" ")[0];
		
		//switch to parend window to enter email
		driver.switchTo().window(parentId);
		
		//enter username which we grabbed from child window
		driver.findElement(By.id("username")).sendKeys(email);
		
	}

}
