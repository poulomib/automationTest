package selenium.mvn.validation;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class landingPage_1_5 {

	public WebDriver driver;

	public landingPage_1_5(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n" + "<b>Test Case No. 1 - </b>"
				+ " Search for a Place Name / Address / Post code");
		Reporter.log("\n");
		Reporter.log("<b>Test Case No. 5 - </b>" + " Taken to Search page with Map View (Dash API's called)");
		Reporter.log("\n");

		performSearch();
	}

	public void performSearch() throws InterruptedException, AWTException {
		Reporter.log("<b>Verify - Perform Search</b>");
		Reporter.log("\n");
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("London");
		Thread.sleep(500);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(500);
		Reporter.log("Search Successful - Passed");
		Reporter.log("\n");
		checkSearchResultPage("London");
	}

	public void checkSearchResultPage(String searchTxt) throws InterruptedException {
		Reporter.log("<b>Verify - checkSearchResultPage</b>");
		Reporter.log("\n");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/span")));
		
		String location = driver.findElement(By.xpath("//h4/span")).getText();
		Reporter.log("Location displayed as "+location);
		Reporter.log("\n");
		
		assertTrue(location.contains(searchTxt), "\n Searched location : "
				+ location + "does not contain the provided search location : " + searchTxt);
		Reporter.log("checkSearchResultPage - Passed");

		Reporter.log("\n");

	}
}
