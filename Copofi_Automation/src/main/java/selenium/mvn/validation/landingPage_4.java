package selenium.mvn.validation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class landingPage_4 {

	public WebDriver driver;

	public landingPage_4(WebDriver driver) {

		this.driver = driver;
	}

	public void executeStep() throws Exception {

		Reporter.log("<b> Description : </b>" + "\n" + "Configure filter for property type");
		Reporter.log("\n");

		driver.findElement(By.id("typeDropDown")).click();

		checkPropertyTypeList();
		driver.findElement(By.xpath("//div[@class='searchBox']")).click();
	}


	public void checkPropertyTypeList() throws InterruptedException {
		Reporter.log("<b>Verify - checkPropertyTypeList</b>");
		Reporter.log("\n");
		List<WebElement> options = driver.findElements(By.className("btn"));
		ArrayList<String> propertyTypeOptions = new ArrayList<String>();
		
		propertyTypeOptions.add("ALL");
		propertyTypeOptions.add("HOUSE");
		propertyTypeOptions.add("FLAT");	
		propertyTypeOptions.add("BUNGALOW");
	
		
		ArrayList<String> availableMin = new ArrayList<String>();
		for (WebElement option : options) {
			if (option.getText().isEmpty() == false) {
				availableMin.add(option.getText());
			}
		}
		
		for (int i = 0; i < propertyTypeOptions.size(); i++) {
			Assert.assertTrue(availableMin.contains(propertyTypeOptions.get(i)),
					propertyTypeOptions.get(i).toString() + " - Text/Option Not Available");
			
			
			Reporter.log(propertyTypeOptions.get(i).toString() + " - Text/Option is Available");
			Reporter.log("\n");
		}
	}
}
