/*Test case for reset password and using dynamically.
 * 1. go to login page 
 * 2. click on forgot password
 * 3. click on reset password
 * 4. extract the new password from the reset text
 * 5. go back to logic page
 * 6. enter usernma and password
 * 7.click login 
 * 8. Check the login page message.
 */

package testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForgotPasswordTest {
	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.xpath("//div[@class='forgot-pwd-container']//a")).click();

		sleepfor(2000);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[2]")).click();
		String getResetValue = driver.findElement(By.xpath("//form/p[@class='infoMsg']")).getText();

		String newPassword = getResetPassword(getResetValue);
		// back to login
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		sleepfor(2000);

		// fill username and new password
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys(newPassword);
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

		sleepfor(2000);
		
		//verifying login page message 
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

	}

	/* Retrieving password from reset message */
	public static String getResetPassword(String resetText) {

		System.out.println(resetText);

		String[] passwords = resetText.split(" ");

		List<String> passwordList = new ArrayList<String>();

		for (String passString : passwords) {
			passwordList.add(passString);
		}

		// remove '(single quote) character
		String resetPassword = passwordList.get(4).replace("'", "");

		return resetPassword;

	}

	public static void sleepfor(long time) {
		/**for handling synchronixation
		 * @time : for how long thread should sleep
		 *  */
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
