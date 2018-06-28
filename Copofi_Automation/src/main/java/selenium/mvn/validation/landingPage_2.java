package selenium.mvn.validation;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class landingPage_2 {

	public WebDriver driver;

	public landingPage_2(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n" + "Configure filter for number of bedrooms (Min, Max)");
		Reporter.log("\n");

		checkMinRooms();
		checkMaxRooms();
		validateOnIncorrectMinInputs();
		refreshPage();
	}

	public void checkMinRooms() throws InterruptedException {
		Reporter.log("<b>Verify - checkMinRooms</b>");
		Reporter.log("\n");
		Thread.sleep(5000);
		driver.findElement(By.id("roomDropDown")).click();
		driver.findElement(By.id("minBedDropDown")).click();
		Thread.sleep(5000);
		List<WebElement> options = driver.findElements(By.className("btn"));
		ArrayList<String> minOptions = new ArrayList<String>();
		minOptions.add("NO MIN");
		minOptions.add("STUDIO");
		minOptions.add("1");
		minOptions.add("2");
		minOptions.add("3");
		minOptions.add("4");
		minOptions.add("5");
		minOptions.add("6");
		ArrayList<String> availableMin = new ArrayList<String>();
		for (WebElement option : options) {
			if (option.getText().isEmpty() == false) {
				availableMin.add(option.getText());
				System.out.println("\n Each option : " + option.getText());
			}
		}

		for (int i = 0; i < minOptions.size(); i++) {
			Assert.assertTrue(availableMin.contains(minOptions.get(i)),
					minOptions.get(i).toString() + " - Text/Option Not Available");

			Reporter.log(minOptions.get(i).toString() + " - Text/Option is Available");
			Reporter.log("\n");
		}
	}

	public void validateOnIncorrectMinInputs() throws InterruptedException, AWTException {
		Reporter.log("<b>Verify - validateOnIncorrectMaxMinInputs</b>");
		Reporter.log("\n");
		driver.findElement(By.id("minBedDropDown")).click();
		Thread.sleep(500);
		driver.findElement(By.name("ngb-radio-5")).click();
		Thread.sleep(500);
		driver.findElement(By.id("maxBedDropDown")).click();
		Thread.sleep(500);
		driver.findElement(By.name("ngb-radio-10")).click();
		Thread.sleep(500);
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
		driver.findElement(By.xpath("//div[@class='searchBox']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-live='polite']")));
		WebElement actualErrormsg = driver.findElement(By.xpath("//div[@aria-live='polite']"));
		validateOnIncorrectMaxMinInputs(actualErrormsg.getText());
		driver.findElement(By.xpath("//div[@aria-live='polite']")).click();
		driver.findElement(By.id("roomDropDown")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Clear")));
		driver.findElement(By.linkText("Clear")).click();
	}

	public void validateOnIncorrectMaxMinInputs(String actualErrormsg) throws InterruptedException, AWTException {
		String expectedErrorToast = "Value for minimum bedroom should not be bigger than the maximum bedroom";
		assertTrue(expectedErrorToast.equalsIgnoreCase(actualErrormsg), "\n Expected error message : "
				+ expectedErrorToast + " does not match actual error message : " + actualErrormsg);

		Reporter.log("validateOnIncorrectMaxMinInputs - Passed");
		Reporter.log("\n");
	}

	public void checkMaxRooms() throws InterruptedException {
		Reporter.log("<b>Verify - checkMaxRooms</b>");
		Reporter.log("\n");
		driver.findElement(By.id("maxBedDropDown")).click();
		Thread.sleep(500);
		List<WebElement> options = driver.findElements(By.className("btn"));
		ArrayList<String> maxOptions = new ArrayList<String>();
		maxOptions.add("STUDIO");
		maxOptions.add("1");
		maxOptions.add("2");
		maxOptions.add("3");
		maxOptions.add("4");
		maxOptions.add("5");
		maxOptions.add("6");
		maxOptions.add("NO MAX");
		ArrayList<String> availableMax = new ArrayList<String>();
		for (WebElement option : options) {
			if (option.getText().isEmpty() == false) {
				availableMax.add(option.getText());
			}
		}
		for (int i = 0; i < maxOptions.size(); i++) {
			assertTrue(availableMax.contains(maxOptions.get(i)),
					maxOptions.get(i).toString() + " - Text/Option Available");
			Reporter.log(maxOptions.get(i).toString() + " - Text/Option is Available");
			Reporter.log("\n");
		}
	}

	public void refreshPage() {

		driver.get("http://34.228.214.228/frontend/landing");
	}
}
