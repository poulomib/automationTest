package selenium.mvn.validation;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class mapView_17_30 {

	public WebDriver driver;

	public mapView_17_30(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n" + "<b>Test Case No. 17 - </b>" + " List / Map toggle");
		Reporter.log("\n");
		Reporter.log("<b>Test Case No. 30 - </b>" + " Clicking the list view card for a property");
		Reporter.log("\n");
		mapToList();
	}

	public void mapToList() throws InterruptedException, AWTException {
		Reporter.log("<b> Verify - mapToList</b>");
		Reporter.log("\n");
		driver.get(
				"http://34.228.214.228/frontend/search/map?nearLat=51.5073509&nearLng=-0.12775829999998223&miles=0.5&address=London,%20UK&city=London&option=map");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/span")));
		Thread.sleep(5000);
		driver.findElement(By.linkText("List")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p")));
		String description = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-result/div/app-property-list-view/div/div[1]/div/div/div[1]/div/div/div[2]/div/div[3]/div[1]/p"))
				.getText();
		String title = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-result/div/app-property-list-view/div/div[1]/div/div/div[1]/div/div/div[2]/div/div[1]/div[1]/h4/span/strong"))
				.getText();
		String subTitle = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-result/div/app-property-list-view/div/div[1]/div/div/div[1]/div/div/div[2]/div/div[2]/div[1]/h5"))
				.getText();

		Reporter.log("Title is - " + title);
		Reporter.log("\n");
		Reporter.log("Sub-Title is - " + subTitle);
		Reporter.log("\n");
		Reporter.log("Description is - " + description);
		Reporter.log("\n");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='basicContainer']/article/div/div[2]/div/div/div/span/span/strong")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='basicContainer']/article/div/div[2]/div/div/div/span/span/strong"))
				.click();
		String details_description = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-detail/section/div[1]/div[2]/div[1]/section/div/div[2]/div[2]/div/p"))
				.getText();
		String details_title = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-detail/section/div[1]/div[2]/article/div/div[2]/div/div[1]/div/span[1]/span/strong"))
				.getText();
		String details_subTitle = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-detail/section/div[1]/div[2]/article/div/div[2]/div/div[1]/div/span[2]"))
				.getText();

		Reporter.log("details_Title is - " + details_title);
		Reporter.log("\n");
		Reporter.log("details_Sub-Title is - " + details_subTitle);
		Reporter.log("\n");
		Reporter.log("details_Description is - " + details_description);
		Reporter.log("\n");

		stringMatch(title, details_title, "Title");
		stringMatch(subTitle, details_subTitle, "Sub Title");
		stringMatch(description, details_description, "Description");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section/div/div/div/a/img")));
		driver.findElement(By.xpath("//section/div/div/div/a/img")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/span")));
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

	public void stringMatch(String match1, String match2, String condition) {
		Reporter.log("<b>Verify - stringMatch for - " + condition + "</b>");
		if (match1.equals(match2) == true) {
			Reporter.log("Text matching in details page for - " + condition);
			Reporter.log("\n");
		}

	}

}
