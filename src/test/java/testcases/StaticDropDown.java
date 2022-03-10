package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class StaticDropDown {
	public static WebDriver driver;
	public static void main(String[] args) {
		ChromesetUp chromesetUp = new ChromesetUp();
		driver = chromesetUp.setupChrome(driver,"https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropDown);
		
		dropdown.selectByValue("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText()); //prints AED
		
		dropdown.selectByVisibleText("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText()); //prints USD
		
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText()); //prints INR
		
		//Multiple clicks dropdown
		WebElement multiClickElement= driver.findElement(By.id("divpaxinfo"));
		
		//initially selected
		System.out.println(multiClickElement.getText());
		
		//load drop down 
		multiClickElement.click();
		
		//select 5 adults, 4 children
		
		for(int i = 1;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			driver.findElement(By.id("hrefIncChd")).click();
		}
		
		//close dropdown 
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//after clicks selected values
		System.out.println(multiClickElement.getText());
		
		

	}

}
