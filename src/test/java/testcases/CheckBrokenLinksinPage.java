package testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.trace.StatusCode;

public class CheckBrokenLinksinPage {

	public static void main(String[] args) throws IOException, MalformedURLException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// we gonna check by using the status code of each link of the page. If status is not 200 ,it might be broken link.
		
		SoftAssert softAssert = new SoftAssert();
		
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		
		for(WebElement link : links) {			

			
			URL url = new URL(link.getAttribute("href"));			
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();			
			connection.setRequestMethod("HEAD");
			connection.connect();
			
			int stausCode = connection.getResponseCode();
			
			softAssert.assertTrue(stausCode<400, link.getText()+" "+link.getAttribute("href")+" is broken");
			
			
			
			
		}
		softAssert.assertAll();
		
		
		

	}

}
