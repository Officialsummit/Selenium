package testInteractions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MutipleWindowsPractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.cssSelector("a[href='/windows']")).click();

		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> iterator = windows.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();

		driver.switchTo().window(childWindow);

		System.out.println(driver.findElement(By.tagName("h3")).getText());

		driver.switchTo().window(parentWindow);

		System.out.println(driver.findElement(By.tagName("h3")).getText());

	}

}
