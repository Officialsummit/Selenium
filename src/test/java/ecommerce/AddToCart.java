package ecommerce;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {
	public static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		String productNames[] = { "Cucumber", "Brocolli", "Almonds", "Onion" };

		addItemToCart(productNames);

		// proceed to check out
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active']/div/button")).click();

		// applying promo code
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

		// place order
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();

	}

	public static void addItemToCart(String[] products) {
		// converting Product names list to collection - Array List
		ArrayList<String> productArrayList = new ArrayList<String>();
		productArrayList.addAll(Arrays.asList(products));

		List<WebElement> productsList = driver.findElements(By.cssSelector("h4[class='product-name']"));

		for (int i = 0; i < productsList.size(); i++) {

			String[] product = productsList.get(i).getText().split("-");
			String productNameTrimmed = product[0].trim();

			if (productArrayList.contains(productNameTrimmed)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

			}

		}
	}

}
