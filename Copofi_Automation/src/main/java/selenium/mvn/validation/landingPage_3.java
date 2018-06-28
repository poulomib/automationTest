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

public class landingPage_3 {

	public WebDriver driver;

	public landingPage_3(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n" + "Configure filter for property price (Min, Max)");
		Reporter.log("\n");
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("priceDropDown")));
		driver.findElement(By.id("priceDropDown")).click();
		checkMinPrice();
		checkMaxPrice();
		validateOnIncorrectMinInputs();
		refreshPage();
	}
	public void checkMinPrice() throws InterruptedException {
		Reporter.log("<b>Verify - checkMinPrice</b>");
		Reporter.log("\n");
		driver.findElement(By.id("minDropDown")).click();
	    Thread.sleep(500);
		List<WebElement> options = driver.findElements(By.className("btn"));
		ArrayList<String> minOptions = new ArrayList<String>();
		
		minOptions.add("NO MIN");
		minOptions.add("£50K");
		minOptions.add("£60K");
		minOptions.add("£70K");
		minOptions.add("£80K");
		minOptions.add("£90K");		
		minOptions.add("£100K");
		minOptions.add("£110K");
		minOptions.add("£120K");
		minOptions.add("£125K");
		minOptions.add("£130K");		
		minOptions.add("£140K");
		minOptions.add("£150K");
		minOptions.add("£160K");
		minOptions.add("£170K");
		minOptions.add("£175K");
		minOptions.add("£180K");
		minOptions.add("£190K");
		minOptions.add("£200K");
		minOptions.add("£210K");
		minOptions.add("£220K");	
		minOptions.add("£230K");
		minOptions.add("£240K");
		minOptions.add("£250K");
		minOptions.add("£260K");
		minOptions.add("£270K");	
		minOptions.add("£280K");
		minOptions.add("£290K");
		minOptions.add("£300K");
		minOptions.add("£325K");
		minOptions.add("£350K");
		minOptions.add("£375K");
		minOptions.add("£400K");
		minOptions.add("£425K");
		minOptions.add("£450K");
		minOptions.add("£475K");
		minOptions.add("£500K");
		minOptions.add("£550K");
		minOptions.add("£600K");
		minOptions.add("£650K");
		minOptions.add("£700K");
		minOptions.add("£800K");
		minOptions.add("£900K");
		minOptions.add("£1M");	
		minOptions.add("£1.25M");
		minOptions.add("£1.5M");
		minOptions.add("£1.75M");
		minOptions.add("£2M");
		minOptions.add("£2.5M");
		minOptions.add("£3M");
		minOptions.add("£4M");
		minOptions.add("£5M");
		minOptions.add("£7.5M");
		minOptions.add("£10M");
		minOptions.add("£15M");
		minOptions.add("£20M");
		
		ArrayList<String> availableMin = new ArrayList<String>();
		for (WebElement option : options) {
			if (option.getText().isEmpty() == false) {
				availableMin.add(option.getText());
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
		
		driver.findElement(By.id("minDropDown")).click();
		driver.findElement(By.name("ngb-radio-20")).click();
	    driver.findElement(By.id("maxDropDown")).click();
	    driver.findElement(By.name("ngb-radio-74")).click();
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
		//driver.findElement(By.xpath("//div[@class='searchBox']")).click();
		Thread.sleep(500);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div")));
		WebElement actualErrormsg = driver.findElement(By.xpath("//div[@id='toast-container']/div/div"));
		validateOnIncorrectMaxMinInputs(actualErrormsg.getText());
		driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).click();
		driver.findElement(By.id("priceDropDown")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Clear')])[2]")));
		driver.findElement(By.xpath("(//a[contains(text(),'Clear')])[2]")).click();
	}

	public void validateOnIncorrectMaxMinInputs(String actualErrormsg) throws InterruptedException, AWTException {
		Reporter.log("<b>Verify - validateOnIncorrectMaxMinInputs</b>");
		Reporter.log("\n");
		String expectedErrorToast = "The minimum price should be lesser than the maximum price";
		assertTrue(expectedErrorToast.equalsIgnoreCase(actualErrormsg), "\n Expected error message : "
				+ expectedErrorToast + " not matches with actual error message : " + actualErrormsg);
		
		Reporter.log("validateOnIncorrectMaxMinInputs - Passed");
		Reporter.log("\n");
	}

	public void checkMaxPrice() throws InterruptedException {

		Reporter.log("<b>Verify - checkMaxPrice</b>");
		Reporter.log("\n");
		driver.findElement(By.id("maxDropDown")).click();
	    Thread.sleep(500);
		List<WebElement> options = driver.findElements(By.className("btn"));
		ArrayList<String> maxOptions = new ArrayList<String>();
		
		maxOptions.add("NO MAX");
		maxOptions.add("£50K");
		maxOptions.add("£60K");	
		maxOptions.add("£70K");
		maxOptions.add("£80K");
		maxOptions.add("£90K");
		maxOptions.add("£100K");
		maxOptions.add("£110K");
		maxOptions.add("£120K");
		maxOptions.add("£125K");
		maxOptions.add("£130K");
		maxOptions.add("£140K");
		maxOptions.add("£150K");
		maxOptions.add("£160K");
		maxOptions.add("£170K");
		maxOptions.add("£175K");
		maxOptions.add("£180K");
		maxOptions.add("£190K");	
		maxOptions.add("£200K");
		maxOptions.add("£210K");
		maxOptions.add("£220K");
		maxOptions.add("£230K");
		maxOptions.add("£240K");
		maxOptions.add("£250K");
		maxOptions.add("£260K");
		maxOptions.add("£270K");
		maxOptions.add("£280K");
		maxOptions.add("£290K");
		maxOptions.add("£300K");
		maxOptions.add("£325K");
		maxOptions.add("£350K");
		maxOptions.add("£375K");
		maxOptions.add("£400K");
		maxOptions.add("£425K");
		maxOptions.add("£450K");
		maxOptions.add("£475K");
		maxOptions.add("£500K");
		maxOptions.add("£550K");
		maxOptions.add("£600K");
		maxOptions.add("£650K");
		maxOptions.add("£700K");	
		maxOptions.add("£800K");
		maxOptions.add("£900K");
		maxOptions.add("£1M");
		maxOptions.add("£1.25M");
		maxOptions.add("£1.5M");
		maxOptions.add("£1.75M");
		maxOptions.add("£2M");
		maxOptions.add("£2.5M");
		maxOptions.add("£3M");
		maxOptions.add("£4M");
		maxOptions.add("£5M");
		maxOptions.add("£7.5M");
		maxOptions.add("£10M");
		maxOptions.add("£15M");
		maxOptions.add("£5M");
		maxOptions.add("£20M");

		ArrayList<String> availableMax = new ArrayList<String>();
		
		for (WebElement option : options) {
			if (option.getText().isEmpty() == false) {
				availableMax.add(option.getText());
				System.out.println("\n Each option : " + option.getText());
			}
		}
		
		for (int i = 0; i < maxOptions.size(); i++) {
			Assert.assertTrue(availableMax.contains(maxOptions.get(i)),
					maxOptions.get(i).toString() + " - Text/Option Not Available");	
			Reporter.log(maxOptions.get(i).toString() + " - Text/Option is Available");
			Reporter.log("\n");
		}
		
	}


	public void refreshPage() {

		driver.get("http://34.228.214.228/frontend/landing");
	}
}
