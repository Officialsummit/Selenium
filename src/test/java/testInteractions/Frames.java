package testInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		//This will result in NoSuchElement exception since its a frame
		//driver.findElement(By.id("draggable")).click();
		
		//count of frames
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//Now switch fram
		
		//one way
		//driver.switchTo().frame(0);
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		WebElement sourceDragElement = driver.findElement(By.id("draggable"));
		
		WebElement destDragElement = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		
		actions.dragAndDrop(sourceDragElement, destDragElement).build().perform();
		
		driver.switchTo().defaultContent();
		
		

	}

}
