package testcases;


import java.util.Iterator;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksCountOnPage {
	public static WebDriver driver;
	public static ChromesetUp chromesetUp;

	public static void main(String[] args) {

		getPageLinks(driver, "https://rahulshettyacademy.com/AutomationPractice/");

	}

	public static void getPageLinks(WebDriver driver, String url) {
		chromesetUp = new ChromesetUp();
		driver = chromesetUp.setupChrome(driver, url);

		// 1. Get all the links of the page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are :" + links.size());
		for (WebElement link : links) {
			System.out.println(link.getText() + link.getAttribute("href"));

		}

		// 2. Get only footer links of the page
		WebElement footerDivSection = driver.findElement(By.id("gf-BIG"));
		List<WebElement> footerLinks = footerDivSection.findElements(By.tagName("a"));
		System.out.println("Links at footer are " + footerLinks.size());
		for (WebElement link : footerLinks) {
			System.out.println(link.getText() + " : " + link.getAttribute("href"));

		}

		// 3. Get links of first column of footer element.
		WebElement footerColumn = footerDivSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		List<WebElement> urls = footerColumn.findElements(By.tagName("a"));

		int firstColumnLinks = urls.size();

		System.out.println("Footer first column have " + firstColumnLinks + " links");
		

		// 4. click all links of footers
		for (int i = 1; i < firstColumnLinks; i++) {

			// click control and enter for link to open in new tab
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			urls.get(i).sendKeys(clickOnLinkTab);

		}
		

		// 5. Get title of all open tabs
		Set<String> tabSet = driver.getWindowHandles();

		Iterator<String> iterator = tabSet.iterator();

		while (iterator.hasNext()) {
			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle());
		}

	}
}
