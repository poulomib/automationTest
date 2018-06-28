package selenium.mvn.settings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class launchBrowser {

	public WebDriver driver;

	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("launching Firefox browser");
			String firefoxdriverPath = "/home/INDUSNETTECHNOL/debmalya.ghosh/Desktop/Gecko/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxdriverPath);
			driver = new FirefoxDriver();
			driver.get("http://34.228.214.228/frontend/landing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("launching Chrome browser");
			String chromedriverPath = "/home/INDUSNETTECHNOL/debmalya.ghosh/Desktop/chrome/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromedriverPath);
			driver = new ChromeDriver();
			driver.get("http://34.228.214.228/frontend/landing");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
	}

	public WebDriver getdriver() {

		return driver;
	}

	@AfterTest
	public void endtest() {

		driver.quit();
	}

}
