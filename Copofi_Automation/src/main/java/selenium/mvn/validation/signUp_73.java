package selenium.mvn.validation;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class signUp_73 {

	public String firstName = "Gini";
	public String lastName = "sharma";
	public String email = firstName+"@mailinator.com";
	public String password = "1234567890";
	public WebDriver driver;

	public signUp_73(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n" + "Sign up with Email supplying valid information\n");
		Reporter.log("\n");
		
		enterDetailsToSignUp();
		//openMailBoxForVerificationMail();
		Thread.sleep(5000);
		login();
		Thread.sleep(5000);
		logout();
	}

	public void enterDetailsToSignUp() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login / Sign Up")));
		driver.findElement(By.linkText("Login / Sign Up")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a/strong")).click();
		driver.findElement(By.id("firstName")).click();
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("re_password")).clear();
		driver.findElement(By.id("re_password")).sendKeys(password);
		driver.findElement(By.id("inlineCheckbox1")).click();
		driver.findElement(By.id("inlineCheckbox2")).click();
		driver.findElement(By.name("submit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-live='polite']")));
		WebElement actualSuccessmsg = driver.findElement(By.xpath("//div[@aria-live='polite']"));

		validateSignUpMessage(actualSuccessmsg.getText());
	}

	public void openMailBoxForVerificationMail() throws InterruptedException {

		driver.get("https://www.mailinator.com/");
		driver.findElement(By.id("inboxfield")).click();
		driver.findElement(By.id("inboxfield")).clear();
		driver.findElement(By.id("inboxfield")).sendKeys(email);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("all_message-min")));
		List<WebElement> optionsemails = driver.findElements(By.className("all_message-min"));
		Thread.sleep(500);
		Thread.sleep(500);
		for (WebElement optionsemail : optionsemails) {
			if (optionsemail.getText().contains("noreply.copofi@gmail.com")) {
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
		Thread.sleep(5000);
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
		Thread.sleep(5000);

		driver.get(urlforVerification);

		login();
	}

	public void login() throws InterruptedException {

		//driver.findElement(By.linkText("Proceed to Log In")).click();
		Thread.sleep(500);
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		Thread.sleep(500);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(500);
		driver.findElement(By.name("submit")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='toast-success toast ng-trigger ng-trigger-flyInOut ng-animating']")));
		WebElement actualSuccessmsg = driver.findElement(
				By.xpath("//div[@class='toast-success toast ng-trigger ng-trigger-flyInOut ng-animating']"));

		validateSuccessfulLogin(actualSuccessmsg.getText());
		
		WebElement username = driver.findElement(By.xpath("//span[@class='name']"));
		String status = driver.findElement(By.xpath("//h1/span")).getText();
		validateLoggedInUserNameAndStatus(username.getText(),status);
	}

	public void validateLoggedInUserNameAndStatus(String username, String status) {

		Reporter.log("<b> Verify - validateLoggedInUserNameAndStatus</b>");
		Reporter.log("\n");

		String expectedUserName = firstName+ " " +lastName;
		String expectedStatus="Unverified";
		assertTrue(expectedUserName.contains(username), "\n Expected user name after login : "
				+ expectedUserName + " does not match actual user name after login : " + username);

		assertTrue(expectedUserName.contains(username), "\n Expected status after login : "
				+ expectedStatus + " does not match actual status after login : " + status);
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

	public void validateSignUpMessage(String actualSuccessmsg) {

		Reporter.log("<b> Verify - validateSignUpMessage</b>");
		Reporter.log("\n");

		String expectedSuccessmsg = "Signed up successfully. Please check your email and click on the verification link to verify your account.";
		assertTrue(expectedSuccessmsg.equalsIgnoreCase(actualSuccessmsg),
				"\n Expected success message after providing Sign Up details : " + expectedSuccessmsg
						+ " does not match actual success message providing Sign Up details : " + actualSuccessmsg);

		Reporter.log("validateForgotPasswordMessage - Passed\n");
	}

	public void logout() throws InterruptedException {

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