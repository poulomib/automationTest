package selenium.mvn.validation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class searchFlow_7 {

	public WebDriver driver;

	public searchFlow_7(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n" + "Repeat searches using 'Repeat Search' button on My Account\n");
		Reporter.log("\n");

		enterCredsToLogin();
		repeatSearch();
		logout();
	}

	public void enterCredsToLogin() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.linkText("Login / Sign Up")).click();
		Thread.sleep(500);
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("arjun@techalchemy.co");
		Thread.sleep(500);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("12345678");
		Thread.sleep(500);
		driver.findElement(By.name("submit")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='toast-success toast ng-trigger ng-trigger-flyInOut ng-animating']")));
		WebElement actualSuccessmsg = driver.findElement(
				By.xpath("//div[@class='toast-success toast ng-trigger ng-trigger-flyInOut ng-animating']"));

		validateSuccessfulLogin(actualSuccessmsg.getText());
	}

	public void validateSuccessfulLogin(String actualSuccessmsg) {

		Reporter.log("<b> Verify - validateSuccessfulLogin</b>");
		Reporter.log("\n");

		String expectedSuccessmsg = "Successfully Logged In";
		assertTrue(expectedSuccessmsg.equalsIgnoreCase(actualSuccessmsg), "\n Expected success message after login : "
				+ expectedSuccessmsg + " does not match actual success message after login : " + actualSuccessmsg);

		Reporter.log("validateSuccessfulLogin - Passed\n");
	}

	public void repeatSearch() throws InterruptedException {
		Reporter.log("<b> Verify - repeatSearch</b>");
		Reporter.log("\n");
		driver.findElement(By.linkText("Recent Searches")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Repeat Search")));
		String searchedTxt = driver.findElement(By.xpath("//h2")).getText();
		driver.findElement(By.linkText("Repeat Search")).click();

		checkSearchResultPage(searchedTxt);
	}

	public void checkSearchResultPage(String searchTxt) throws InterruptedException {
		Reporter.log("<b>Verify - checkSearchResultPage</b>");
		Reporter.log("\n");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/span")));

		String location = driver.findElement(By.xpath("//h4/span")).getText();
		Reporter.log("Location displayed as " + location);
		Reporter.log("\n");

		if (searchTxt.length() < location.length()) {
			assertTrue(location.contains(searchTxt), "\n Searched location : " + location
					+ "does not contain the provided search location : " + searchTxt);
			Reporter.log("checkSearchResultPage - Passed");
		}

		else {
			assertTrue(searchTxt.contains(location), "\n Searched location : " + location
					+ " does not contain the provided search location : " + searchTxt);
			Reporter.log("checkSearchResultPage - Passed");
		}

		Reporter.log("\n");
	}

	public void logout() throws InterruptedException {

		driver.findElement(By.xpath("//span/img")).click();
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		Thread.sleep(6000);
		driver.findElement(By.linkText("Logout")).click();
		WebElement logoutmsg = driver.findElement(By.xpath("//div[@id='toast-container']/div"));
		verifyLogoutMsg(logoutmsg.getText());
	}

	public void verifyLogoutMsg(String logoutmsg) {

		Reporter.log("<b> Verify - verifyLogoutMsg</b>");
		Reporter.log("\n");

		String expectedSuccessmsg = "Successfully logged Out";
		assertTrue(expectedSuccessmsg.equalsIgnoreCase(logoutmsg), "\n Expected success message after logout : "
				+ expectedSuccessmsg + " does not match actual success message after logout : " + logoutmsg);

		Reporter.log("verifyLogoutMsg - Passed\n");
	}

}
