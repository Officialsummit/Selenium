package testcases;




import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BadSsl {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		//for setting up proxy
//		Proxy proxy = new Proxy();
//		proxy.setHttpProxy(null)
		
		
		//Bypassing bad ssl warning
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		
		//blocking pop ups like- allow location, allow noticfication pop ups
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocing"));
		
		
		//providing custom download location
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory","/downloads/testPath");
		
		
		WebDriver driver = new ChromeDriver(options);
		
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
		
		

	}

}
