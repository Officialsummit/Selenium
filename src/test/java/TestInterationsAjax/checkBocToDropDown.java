package TestInterationsAjax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkBocToDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1. Select checkbox and grab the label
		WebElement checkBoxElement = driver.findElement(By.cssSelector("label[for='bmw']"));
		checkBoxElement.click();

		// 2.Grab the label
		String selectedChkBoxLabel = checkBoxElement.getText();
		System.out.println(selectedChkBoxLabel);

		// 3. selecting from dropdown
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropdown);
		select.selectByVisibleText(selectedChkBoxLabel);

		// 4 . Enter the grabbed label in text in editbox
		driver.findElement(By.id("name")).sendKeys(selectedChkBoxLabel);
		driver.findElement(By.id("alertbtn")).click();
		String alertTxt = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		Assert.assertEquals(selectedChkBoxLabel, alertTxt);

	}

}
