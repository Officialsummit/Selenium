package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBrowsers {

	public static String browser = "chrome";
	public static WebDriver driver;
	public static void main(String[] args) {
		// Configuring browsers
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		//Chrome browser
				//System.setProperty("webdriver.chrome.driver", "D:\\eclipse ide\\eclipse projects\\selenium_prerequisites\\chromedriver.exe");
				
//				WebDriverManager.chromedriver().setup(); // will use this since we have added dependency from pom.xml.
//				WebDriver driver = new ChromeDriver();
				driver.get("https://www.gmail.com");
				String title = driver.getTitle();
				System.out.println(title);
				System.out.println(title.length());
				
				//close the browser
				//driver.close();//close current browser
				//driver.quit(); //close current browser + all related browser session.
				
		
		
		
//		//Firefox browser
//		System.setProperty("webdriver.gecko.driver", "D:\\eclipse ide\\eclipse projects\\selenium_prerequisites\\geckodriver.exe");
//		FirefoxDriver driver = new FirefoxDriver();
//		driver.get("http://way2automation.com");
//		
		
		
//		//Edge Browser 
//		System.setProperty("webdriver.edge.driver", "D:\\eclipse ide\\eclipse projects\\selenium_prerequisites\\msedgedriver.exe");
//		EdgeDriver eDriver = new EdgeDriver();
//		eDriver.get("https://youtube.com");		
		

	}

}
