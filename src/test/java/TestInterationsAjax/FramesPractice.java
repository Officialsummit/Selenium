package TestInterationsAjax;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesPractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();		

		//using frame attribute		
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
		
		/* we can also achieve this by using index as below
		 * 
		 * 
			int frames= driver.findElements(By.name("frame")).size();
			System.out.println(frames);
			driver.switchTo().frame(0);
			System.out.println(driver.findElements(By.tagName("frame")).size());
			driver.switchTo().frame(1);
			System.out.println(driver.findElement(By.id("content")).getText());
		   
		 * */	
		
		
		
		

	}

}
