package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdownList {

	public static void main(String[] args) {
		String url = "https://www.wikipedia.org/";
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		
		//get dropdown by selector -- don't use sendkeys for select elements.
		//driver.findElement(By.id("searchLanguage")).sendKeys("English");
		
		
		//Use `Select()` class for drop down
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select select = new Select(dropdown);
		
		//select by index
		select.selectByIndex(2);
		
		//select by visible text
		select.selectByVisibleText("Polski");
		
		//select by value
		select.selectByValue("hi");
		
		//creating list of option(i.e List<WebElement>)
		List<WebElement> options = driver.findElements(By.tagName("option"));
		
		//print count of all options available
		System.out.println(options.size());
		
		//get Text of option at index 2 
		System.out.println(options.get(2).getText());
		
		//print all the options in the page
		for(int i = 0; i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
		
		
		//find all the links of the wiki homepage
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for (WebElement link : links) {
			System.out.println(link.getText()+" : "+link.getAttribute("href"));
			
		}
		
		//finding links only from specific section of page
		WebElement block = driver.findElement(By.className("other-projects"));
		
		List<WebElement> blockList = block.findElements(By.tagName("a"));
		for(WebElement eachBlock : blockList)
		{
			System.out.println(eachBlock.getAttribute("href"));
		}
				
		
		
	}

}
