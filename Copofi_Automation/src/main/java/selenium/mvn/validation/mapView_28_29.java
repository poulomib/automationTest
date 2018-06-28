package selenium.mvn.validation;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class mapView_28_29 {

	public WebDriver driver;

	public mapView_28_29(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n" + "<b>Test Case No. 28 - </b>"
				+ " View Basic property information on clicking of a pin");
		Reporter.log("\n");
		Reporter.log("<b>Test Case No. 29 - </b>" + " Clicking the pin popout for a property");
		Reporter.log("\n");
		mapPin();
	}

	public void mapPin() throws InterruptedException, AWTException {
		Reporter.log("<b> Verify - mapPin</b>");
		Reporter.log("\n");
		driver.get(
				"http://34.228.214.228/frontend/search/map?nearLat=51.5073509&nearLng=-0.12775829999998223&miles=0.5&address=London,%20UK&city=London&option=map");
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/span")));
		Thread.sleep(5000);
		WebElement locationMarker = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-result/div/app-property-map-view/div/div[1]/div/agm-map/div[1]/div/div/div[1]/div[3]/div[2]/div[3]/div[2]"));
		locationMarker.click();

		String description = driver.findElement(By.xpath("//div[2]/div/div/p")).getText();
		String title = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-result/div/app-property-map-view/div/div[1]/div/agm-map/div[1]/div/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div/div/article/div[2]/header/div[1]/div[1]/h5/span"))
				.getText();
		String subTitle = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-result/div/app-property-map-view/div/div[1]/div/agm-map/div[1]/div/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div/div/article/div[2]/header/div[2]/div[1]/span"))
				.getText();

		String price = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-result/div/app-property-map-view/div/div[1]/div/agm-map/div[1]/div/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div/div/article/div[2]/header/div[1]/div[2]/span"))
				.getText();
		String noOfBedrooms = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-result/div/app-property-map-view/div/div[1]/div/agm-map/div[1]/div/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div/div/article/div[2]/header/div[2]/div[2]/div/div/span"))
				.getText();
		boolean provider = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-result/div/app-property-map-view/div/div[1]/div/agm-map/div[1]/div/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div/div/article/div[1]/div/div[2]"))
				.isDisplayed();
		Thread.sleep(5000);
		boolean image1 = driver.findElement(By.xpath("//ngx-gallery-image/div/div")).isDisplayed();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//ngx-gallery-arrows/div[2]/div")).click();
		Thread.sleep(10000);
		boolean image2 = driver.findElement(By.xpath("//ngx-gallery-image/div/div[2]")).isDisplayed();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ngx-gallery-arrows/div[2]/div")).click();
		Thread.sleep(5000);
		boolean image3 = driver.findElement(By.xpath("//ngx-gallery-image/div/div[2]")).isDisplayed();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ngx-gallery-arrows/div[2]/div")).click();
		Thread.sleep(5000);
		boolean image4 = driver.findElement(By.xpath("//ngx-gallery-image/div/div[3]")).isDisplayed();

		boolean close = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-result/div/app-property-map-view/div/div[1]/div/agm-map/div[1]/div/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/button"))
				.isDisplayed();
		boolean favicon = driver.findElement(By.xpath(
				"/html/body/app-root/app-search-result/div/app-property-map-view/div/div[1]/div/agm-map/div[1]/div/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div/div/article/div[1]/div/div[1]/a/i"))
				.isDisplayed();

		Reporter.log("Title is - " + title);
		Reporter.log("\n");
		Reporter.log("Sub-Title is - " + subTitle);
		Reporter.log("\n");
		Reporter.log("Description is - " + description);
		Reporter.log("\n");
		Reporter.log("Price is - " + price);
		Reporter.log("\n");
		Reporter.log("bed is - " + noOfBedrooms);

		checkPopUpContentIsDisplayed(title, false, "Title");
		checkPopUpContentIsDisplayed(description, false, "Description");
		checkPopUpContentIsDisplayed(subTitle, false, "Sub-title");
		checkPopUpContentIsDisplayed(price, false, "Price");
		checkPopUpContentIsDisplayed(noOfBedrooms, false, "No. of Beds");
		checkPopUpContentIsDisplayed("", provider, "Provider");
		checkPopUpContentIsDisplayed("", image1, "1st Image");
		checkPopUpContentIsDisplayed("", image2, "2nd Image");
		checkPopUpContentIsDisplayed("", image3, "3rd Image");
		checkPopUpContentIsDisplayed("", image4, "4th Image");

		checkPopUpContentIsDisplayed("", close, "Close button");
		checkPopUpContentIsDisplayed("", favicon, "Favourite button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/div/p")));
		driver.findElement(By.xpath("//div[2]/div/div/p")).click();

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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//section/div/div/div/a/img")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/span")));

	}

	public void checkPopUpContentIsDisplayed(String value, Boolean result, String elementName) {

		if (value.isEmpty() && !result) {
			Reporter.log("\n The element : " + elementName + " is not displayed in the property pop up.");
		} else if (value.isEmpty()) {
			if (result)
				Reporter.log("\n The element : " + "\"" + elementName + "\"" + " is found in the property-pop.");
		} else {
			if (!value.isEmpty()) {
				Reporter.log("\n The element : " + "\"" + elementName + "\"" + " is found in the property-pop.");
				Reporter.log("\n" + elementName + " is " + value);
			}
		}
	}

	public void stringMatch(String match1, String match2, String condition) {
		Reporter.log("<b>Verify - stringMatch for - " + condition + "</b>");
		if (match1.equals(match2) == true) {
			Reporter.log("Text matching in details page for - " + condition);
			Reporter.log("\n");
		}

	}

}
