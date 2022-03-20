package testcases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablesTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		//1. Number of rows
		List<WebElement> tableRows = driver.findElements(By.xpath("//fieldset/table[@id='product']/tbody/tr"));		
		
		
		System.out.println("Number of Rows: "+tableRows.size());
		
		
		//2. Number ofNumber Columns
		int tableColumns = 0;
		
		for (int i = 1; i <= tableRows.size(); i++) {

			if (i == 1) {
				tableColumns += driver.findElements(By.xpath("//fieldset/table[@id='product']/tbody/tr[" + i + "]/th"))
						.size();

			} else {
				tableColumns += driver.findElements(By.xpath("//fieldset/table[@id='product']/tbody/tr[" + i + "]/td"))
						.size();
			}

		}		
		
		System.out.println("Number of columns : " + tableColumns);
		
		
		//3. Print Second rows texts
		List<WebElement> secondRoWebElements = driver.findElements(By.xpath("//fieldset/table[@id='product']/tbody/tr[3]/td"));
		
		for(WebElement col : secondRoWebElements) {
			System.out.print(col.getText()+" ");
		}
		
		
		

	}

}
