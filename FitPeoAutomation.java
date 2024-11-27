package Google_Test;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FitPeoAutomation {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        // Set up WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void navigateToFitPeoHomepage() {
        driver.get("https://fitpeo.com/");
        System.out.println("Navigated to FitPeo Homepage");
    }

    @Test(priority = 2)
    public void navigateToRevenueCalculatorPage() {
        WebElement revenueCalculatorLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Revenue Calculator")));
        revenueCalculatorLink.click();
        System.out.println("Navigated to Revenue Calculator Page");
    }

    @Test(priority = 3)
    public void scrollToSliderSection() throws AWTException, InterruptedException {
        // Use Robot class to scroll to the slider section
        Robot robot = new Robot();
        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(3000); // Delay to simulate smooth scrolling
        }
        System.out.println("Scrolled to the slider section using Robot");
    }

    @Test(priority = 4)
    public void adjustSlider() {
        WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("slider")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = 820; arguments[0].dispatchEvent(new Event('change'));", slider);

        WebElement sliderValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("slider-value")));
        String actualValue = sliderValue.getAttribute("value");

        if ("820".equals(actualValue)) {
            System.out.println("Slider adjusted successfully to 820");
        } else {
            System.err.println("Failed to adjust slider to 820. Current value: " + actualValue);
        }
    }

    @Test(priority = 5)
    public void updateTextField() {
        WebElement sliderValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("slider-value")));
        sliderValue.clear();
        sliderValue.sendKeys("560");

        WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("slider")));
        String updatedValue = slider.getAttribute("value");

        if ("560".equals(updatedValue)) {
            System.out.println("Slider updated successfully to 560 via text field");
        } else {
            System.err.println("Failed to update slider to 560 via text field. Current value: " + updatedValue);
        }
    }

    @Test(priority = 6)
    public void selectCPTCodes() {
        String[] cptCodes = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};
        for (String cptCode : cptCodes) {
            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(cptCode)));
            if (!checkbox.isSelected()) {
                checkbox.click();
                System.out.println("Selected CPT code: " + cptCode);
            }
        }
    }

    @Test(priority = 7)
    public void validateTotalReimbursement() {
        WebElement reimbursementHeader = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("total-reimbursement")));
        String actualReimbursement = reimbursementHeader.getText();
        String expectedReimbursement = "$110700";

        if (expectedReimbursement.equals(actualReimbursement)) {
            System.out.println("Reimbursement validated successfully: " + actualReimbursement);
        } else {
            System.err.println("Reimbursement mismatch. Expected: " + expectedReimbursement + ", Found: " + actualReimbursement);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed and resources released.");
        }
    }
}
