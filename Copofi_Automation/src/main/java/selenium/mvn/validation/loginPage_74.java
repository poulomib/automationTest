package selenium.mvn.validation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class loginPage_74 {

	public WebDriver driver;

	public loginPage_74(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n" + "Login with Email supplying correct email and password ");
		Reporter.log("\n");
		
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click(); // Accept Cookie Policy
		enterCredsToLogin();
		Thread.sleep(3000);
		logout();
	}

	public void enterCredsToLogin() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/app-landing/app-header/div/div/div[2]/ul/li[6]/a")));
		driver.findElement(By.xpath("/html/body/app-root/app-landing/app-header/div/div/div[2]/ul/li[6]/a")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("arjun@techalchemy.co");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("12345678");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
		driver.findElement(By.name("submit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='toast-success toast ng-trigger ng-trigger-flyInOut ng-animating']")));
		WebElement actualSuccessmsg = driver.findElement(
				By.xpath("//div[@class='toast-success toast ng-trigger ng-trigger-flyInOut ng-animating']"));
		
		validateSuccessfulLogin(actualSuccessmsg.getText());

		WebElement username = driver.findElement(By.xpath("//span[@class='name']"));
		validateLoggedInUserName(username.getText());
	}

	public void validateLoggedInUserName(String username) {

		Reporter.log("<b> Verify - validateLoggedInUserName</b>");
		Reporter.log("\n");

		String expectedUserName = "Arjun Shankar";
		assertTrue(expectedUserName.equalsIgnoreCase(username), "\n Expected user name after login : "
				+ expectedUserName + " does not match actual user name after login : " + username);

		Reporter.log("validateLoggedInUSerName - Passed\n");
	}

	public void validateSuccessfulLogin(String actualSuccessmsg) {

		Reporter.log("<b> Verify - validateSuccessfulLogin</b>");
		Reporter.log("\n");

		String expectedSuccessmsg = "Successfully Logged In";
		assertTrue(expectedSuccessmsg.equalsIgnoreCase(actualSuccessmsg), "\n Expected success message after login : "
				+ expectedSuccessmsg + " does not match actual success message after login : " + actualSuccessmsg);

		Reporter.log("validateSuccessfulLogin - Passed\n");
	}

	public void logout() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 200);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
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
