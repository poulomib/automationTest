package selenium.mvn.validation;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class loginPage_76 {

	public WebDriver driver;

	public loginPage_76(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n"
				+ "Click 'Forgot Password', enter registered email account and click 'Submit'\n");
		Reporter.log("\n");

		Thread.sleep(1000);
		enterEmailToChangePassword();
		openMailBoxForVerificationMail();
		Thread.sleep(1000);
		logout();
	}

	public void openMailBoxForVerificationMail() throws InterruptedException {

		driver.get("https://www.mailinator.com/");
		driver.findElement(By.id("inboxfield")).click();
		driver.findElement(By.id("inboxfield")).clear();
		driver.findElement(By.id("inboxfield")).sendKeys("testcopofi1@mailinator.com");
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("all_message-min")));
		List<WebElement> optionsemails = driver.findElements(By.className("all_message-min"));
		Thread.sleep(500);
		System.out.println("Before Loop");
		Thread.sleep(500);
		for (WebElement optionsemail : optionsemails) {
			System.out.println("Inside Loop");
			if (optionsemail.getText().contains("Password reset")) {
				System.out.println("\n Each option : " + optionsemail.getText());
				Thread.sleep(500);
				optionsemail.click();
				Thread.sleep(5000);
				System.out.println("Clicked");
				break;
			}
		}
		Thread.sleep(500);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
		driver.switchTo().frame(driver.findElement(By.name("msg_body")));
		Thread.sleep(2000);
		String link = driver.findElement(By.linkText("here")).getAttribute("href");
		System.out.println("Link2 - " + link);

		String actualURL = link.substring(39);
		System.out.println("actualURL - " + actualURL);
		Thread.sleep(500);

		driver.get("https://www.url-encode-decode.com/");
		driver.findElement(By.id("string")).click();
		driver.findElement(By.id("string")).click();
		driver.findElement(By.id("string")).clear();
		driver.findElement(By.id("string")).sendKeys(actualURL);
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[1]/button[2]")).click();
		Thread.sleep(500);
		String urlforVerification = driver.findElement(By.id("string2")).getText();
		System.out.println("\n Decode URL:" + urlforVerification);
		Thread.sleep(1000);

		driver.get(urlforVerification);

		resetPassword();
	}

	public void resetPassword() throws InterruptedException {

		String newPassword = "12345678";
		driver.findElement(By.name("newPassword")).click();
		driver.findElement(By.name("newPassword")).clear();
		driver.findElement(By.name("newPassword")).sendKeys(newPassword);
		driver.findElement(By.name("confirmation")).click();
		driver.findElement(By.name("confirmation")).clear();
		driver.findElement(By.name("confirmation")).sendKeys(newPassword);
		driver.findElement(By.xpath("//input[@value='Reset']")).click();
		driver.findElement(By.xpath("//div")).click();
		driver.findElement(By.linkText("Proceed to Log In")).click();
		login(newPassword);
	}

	public void enterEmailToChangePassword() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login / Sign Up")));
		driver.findElement(By.linkText("Login / Sign Up")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("testcopofi1@mailinator.com");
		driver.findElement(By.name("submit")).click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='toast-success toast ng-trigger ng-trigger-flyInOut ng-animating']")));
		WebElement actualSuccessmsg = driver.findElement(
				By.xpath("//div[@class='toast-success toast ng-trigger ng-trigger-flyInOut ng-animating']"));

		validateForgotPasswordMessage(actualSuccessmsg.getText());
	}

	private void login(String newPassword) throws InterruptedException {

		Thread.sleep(500);
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("testcopofi1@mailinator.com");
		Thread.sleep(500);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(newPassword);
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

	public void validateForgotPasswordMessage(String actualSuccessmsg) {

		Reporter.log("<b> Verify - validateForgotPasswordMessage</b>");
		Reporter.log("\n");

		String expectedSuccessmsg = "We have sent you an e-mail to your registered e-mail address";
		assertTrue(expectedSuccessmsg.equalsIgnoreCase(actualSuccessmsg),
				"\n Expected success message after providing Email for Forgot Password : " + expectedSuccessmsg
						+ " does not match actual success message providing Email for Forgot Password : "
						+ actualSuccessmsg);

		Reporter.log("validateForgotPasswordMessage - Passed\n");
	}
	
	public void logout() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		Thread.sleep(5000);
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