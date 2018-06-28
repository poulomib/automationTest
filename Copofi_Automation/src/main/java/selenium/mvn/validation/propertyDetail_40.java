package selenium.mvn.validation;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class propertyDetail_40 {

	public WebDriver driver;

	public propertyDetail_40(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n" + "Favourite a property");
		Reporter.log("\n");

		performsearch();
		savePropertyAsFavourites();
		logout();
		loadHomePage();
	}

	public void logout() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
		WebElement logoutmsg = driver.findElement(By.xpath("//div[@id='toast-container']/div"));
		verifyLogoutMsg(logoutmsg.getText());
	}

	public void savePropertyAsFavourites() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/span")));
		Thread.sleep(1000);
		driver.findElement(By.linkText("List")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='basicContainer']/article/div/div[2]/div/div/div/span/span/strong")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='basicContainer']/article/div/div[2]/div/div/div/span/span/strong"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section/div/div/div/a/img")));
		driver.findElement(By.xpath("//span/strong")).click();
		driver.findElement(By.xpath("//section[@id='overview']/div/div/div/div/div/a/i")).click();

		loginBeforeSaving();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//section[@id='overview']/div/div/div/div/div/a/i")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//section[@id='overview']/div/div/div/div/div/a/i")).click();
		Thread.sleep(1000);
		WebElement successmsg = driver.findElement(By.xpath("//div[@aria-live='polite']"));
		validateAddedToFavouritesMessage(successmsg.getText());

		WebElement propertyName = driver
				.findElement(By.xpath("//span[@class='address textEllipsis text-dark']//span//strong"));
		String propertyNamesaved = propertyName.getText();
		System.out.println("\n Property Name: " + propertyNamesaved);

		driver.findElement(By.xpath("//img[@src='assets/images/user.jpg']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/app-root/app-post-auth/div/app-dashboard/section/div[1]/div[1]/ul/li[1]/div[2]/a")));
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/app-root/app-post-auth/div/app-dashboard/section/div[1]/div[1]/ul/li[1]/div[2]/a"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content-padding")));
		Thread.sleep(1000);
		WebElement allProperties = driver.findElement(By.className("content-padding"));
		System.out.println("\n content : " + allProperties.getText());
		checkAddedPropertyInMyAccount(propertyNamesaved, allProperties.getText());

	}

	public void checkAddedPropertyInMyAccount(String propertyName, String allProperties) {
		Reporter.log("<b> Verify - checkAddedPropertyInMyAccount</b>");
		Reporter.log("\n");

		assertTrue(allProperties.contains(propertyName), "\n Property added to Favourites : " + propertyName
				+ " does not match to the property in My account : " + allProperties);

		Reporter.log("validateAddedToFavouritesMessage - Passed\n");
	}

	public void loginBeforeSaving() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='']")).click();
		driver.findElement(By.xpath("//input[@name='']")).clear();
		driver.findElement(By.xpath("//input[@name='']")).sendKeys("arjun@techalchemy.co");
		driver.findElement(By.xpath("(//input[@name=''])[2]")).click();
		driver.findElement(By.xpath("(//input[@name=''])[2]")).clear();
		driver.findElement(By.xpath("(//input[@name=''])[2]")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
	}

	public void performsearch() throws InterruptedException, AWTException {
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
		Thread.sleep(1000);
	}

	public void validateAddedToFavouritesMessage(String successmsg) {

		Reporter.log("<b> Verify - validateAddedToFavouritesMessage</b>");
		Reporter.log("\n");

		String expectedSuccessmsg = "Property added";
		assertTrue(successmsg.contains(expectedSuccessmsg),
				"\n Expected success message after adding property to favourites : " + expectedSuccessmsg
						+ " does not match actual success message after adding property to favouries : " + successmsg);

		Reporter.log("validateAddedToFavouritesMessage - Passed\n");
	}

	public void enterCredsToLogin() throws InterruptedException {

		driver.findElement(By.linkText("Login / Sign Up")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("arjun@techalchemy.co");
		Thread.sleep(500);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("12345678");
		Thread.sleep(500);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
	}

	public void verifyLogoutMsg(String logoutmsg) {

		Reporter.log("<b> Verify - verifyLogoutMsg</b>");
		Reporter.log("\n");

		String expectedSuccessmsg = "Successfully logged Out";
		assertTrue(expectedSuccessmsg.equalsIgnoreCase(logoutmsg), "\n Expected success message after logout : "
				+ expectedSuccessmsg + " does not match actual success message after logout : " + logoutmsg);

		Reporter.log("verifyLogoutMsg - Passed\n");
	}

	public void loadHomePage() {

		driver.get("http://34.228.214.228/frontend/landing");
	}
}
