package selenium.mvn.validation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class mapView_16 {

	public WebDriver driver;

	public mapView_16(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n" + "Change Search location");
		Reporter.log("\n");
		changeSearchLocation();
	}

	public void changeSearchLocation() throws InterruptedException, AWTException {
		Reporter.log("<b> Verify - changeSearchLocation</b>");
		Reporter.log("\n");
		driver.get(
				"http://34.228.214.228/frontend/search/map?nearLat=51.5073509&nearLng=-0.12775829999998223&miles=0.5&address=London,%20UK&city=London&option=map");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/span")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("New York Street, Manchester, UK");
		Thread.sleep(500);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(500);

		checkSearchResultPage();
	}

	public void checkSearchResultPage() throws InterruptedException {
		Reporter.log("<b>Verify - checkSearchResultPage</b>");
		Reporter.log("\n");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/span")));

		String location = driver.findElement(By.xpath("//h4/span")).getText();
		Reporter.log("Location displayed as " + location);
		Reporter.log("\n");
	}

}
