package Google_Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.relevantcodes.extentreports.ExtentTest;

public class Testfitpeo extends TestBase {

	@Test(priority = 1)
	public void Google() throws InterruptedException, Throwable {
		ExtentTest test = extent.startTest("Google"); // Initialize extentTest
		extentTest.set(test);
		//      Enter the values in search text field	
		WebElement Google = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		Google.sendKeys("fitpeo");
		Thread.sleep(2000);
		Robot ms = new Robot();

		/*
		 * WebElement Google1 = driver.findElement(By.xpath(
		 * "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
		 * Google.click();
		 */


		ms.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		// step 1
		WebElement fitpeo = driver.findElement(By.xpath(
				" /html/body/div[3]/div/div[13]/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div[3]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/span/a"));
		fitpeo.click();
		Thread.sleep(2000);

		// step 2
		WebElement fitpeo1 = driver.findElement(By.xpath(
				"/html/body/div[2]/header/div/div[3]/div[6]"));
		fitpeo.click();
		Thread.sleep(2000);
		
		  ms.keyPress(KeyEvent.VK_TAB); ms.keyRelease(KeyEvent.VK_TAB);
		  Thread.sleep(1000);
		  ms.keyPress(KeyEvent.VK_TAB); ms.keyRelease(KeyEvent.VK_TAB);
		  Thread.sleep(1000);
		  ms.keyPress(KeyEvent.VK_TAB); ms.keyRelease(KeyEvent.VK_TAB);
		  Thread.sleep(5000);
		 
		/*
		 * ms.keyPress(KeyEvent.VK_ENTER); ms.keyPress(KeyEvent.VK_M);
		 */

		/*
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"hdtb-sc\"]/div/div[1]/div[1]/div/div[2]/a/div")).click();
		 * Thread.sleep(2000); driver.findElement(By.xpath(
		 * "//*[@id=\"hdtb-sc\"]/div/div[1]/div[1]/div/div[1]/a/div")).click();
		 * Thread.sleep(2000); driver.findElement(By.xpath(
		 * "//*[@id=\"APjFqb\"]")).clear(); Thread.sleep(2000);
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"APjFqb\"]")).sendKeys("SeleniumWebDriver"); Thread.sleep(2000);
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"tsf\"]/div[1]/div[1]/div[2]/button")).click(); Thread.sleep(2000);
		 */

	}

}
