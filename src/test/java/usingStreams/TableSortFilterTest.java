package usingStreams;

import java.util.List;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableSortFilterTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		listCompare(driver);

	}

	public static void listCompare(WebDriver driver) {

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elementList = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

		List<String> originalList = elementList.stream().map(name -> name.getText()).collect(Collectors.toList());

		System.out.println(originalList);

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		System.out.println(sortedList);

		Assert.assertTrue(originalList.equals(sortedList));

		// 2. get price of beans from table
		List<String> items = elementList.stream().filter(element -> element.getText().contains("Beans"))
				.map(name -> getPrice(name)).collect(Collectors.toList());

		items.forEach(item -> System.out.println(item));

		/* get price of rice(which in last page) we have to do pagination here to last
		page till we find Rice.*/
		List<String> price;

		do {

			List<WebElement> paginationWebElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

			price = paginationWebElements.stream().filter(name -> name.getText().contains("Rice"))
					.map(name -> getPrice(name)).collect(Collectors.toList());

			
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
			price.forEach(a -> System.out.println(a));

		} while (price.size() < 1);

	}

	private static String getPrice(WebElement name) {
		// TODO Auto-generated method stub
		String price = name.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
