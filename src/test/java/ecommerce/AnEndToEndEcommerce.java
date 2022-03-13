package ecommerce;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnEndToEndEcommerce {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		loginModule(driver, wait);

		cartCheckModule(driver);

	}

	public static void loginModule(WebDriver driver, WebDriverWait wait)  {
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.cssSelector("input[value='user']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn"))).click();
		WebElement userType = driver.findElement(By.xpath("//div[@class='form-group']/select"));
		Select select = new Select(userType);
		select.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

		String pagetitle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='navbar-brand'])[1]")))
				.getText();

		// make sure we landed to home page successfully
		Assert.assertEquals(pagetitle, "ProtoCommerce");

	}

	public static void cartCheckModule(WebDriver driver) {

		String[] items = { "iphone X", "Samsung Note 8", "Blackberry" };

		ArrayList<String> itemList = new ArrayList<String>();
		itemList.addAll(Arrays.asList(items));

		List<WebElement> itemCards = driver.findElements(By.cssSelector(".card"));
		List<WebElement> itemName = driver.findElements(By.cssSelector("h4[class='card-title']"));

		for (int i = 0; i < itemCards.size(); i++) {
			String name = itemName.get(i).getText();
			if (itemList.contains(name)) {
				driver.findElements(By.cssSelector("div[class='card-footer'] .btn")).get(i).click();
			}

		}

		// checkout
		driver.findElement(By.xpath("//li[@class='nav-item active']/a")).click();

	}

}
