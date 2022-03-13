package ecommerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String productNames [] = {"Cucumber","Brocolli","Almonds","Onion"};
		
		//converting Product names list to collection - Array List
		ArrayList<String> productArrayList = new ArrayList<String>();
		productArrayList.addAll(Arrays.asList(productNames));
		
		List<WebElement> productsList = driver.findElements(By.cssSelector("h4[class='product-name']"));
		
		for (int i=0; i<productsList.size();i++) {
			
			String[] product = productsList.get(i).getText().split("-");
			String productNameTrimmed = product[0].trim();
						
			if(productArrayList.contains(productNameTrimmed)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
								
				
			}
			
		}
		

	}

}
