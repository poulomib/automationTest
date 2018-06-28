package copofi.testRun;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import selenium.mvn.settings.launchBrowser;
import selenium.mvn.validation.landingPage_1_5;
import selenium.mvn.validation.landingPage_2;
import selenium.mvn.validation.landingPage_3;
import selenium.mvn.validation.landingPage_4;
import selenium.mvn.validation.loginPage_74;
import selenium.mvn.validation.loginPage_76;
import selenium.mvn.validation.mapView_16;
import selenium.mvn.validation.mapView_17_30;
import selenium.mvn.validation.mapView_28_29;
import selenium.mvn.validation.mapView_41;
import selenium.mvn.validation.propertyDetail_40;
import selenium.mvn.validation.searchFlow_7;
import selenium.mvn.validation.signUp_73;

public class testSuite extends launchBrowser {

	public WebDriver driver;
	public landingPage_1_5 lp_1_5;
	public landingPage_2 lp_2;
	public landingPage_3 lp_3;
	public landingPage_4 lp_4;
	public searchFlow_7 sf_7;
	public mapView_16 mp_16;
	public mapView_17_30 mp_17_30;
	public mapView_28_29 mp_28_29;
	public propertyDetail_40 pd_40;
	public mapView_41 mp_41;
	public loginPage_74 lp_74;
	public loginPage_76 lp_76;
	public signUp_73 sp_73;

	@BeforeClass
	public void setdriver() {

		driver = getdriver();
	}
	
	@Test(priority = 1)
	public void testCaseNo74() throws Exception {
		String expURL = "http://34.228.214.228/frontend/landing";
		urlCheck(expURL);
		lp_74 = new loginPage_74(driver);
		lp_74.executeStep();
	}

	@Test(priority = 2)
	public void testCaseNo76() throws Exception {
		String expURL = "http://34.228.214.228/frontend/landing";
		urlCheck(expURL);
		lp_76 = new loginPage_76(driver);
		lp_76.executeStep();
	}

	@Test(priority = 3)
	public void testCaseNo2() throws Exception {
		String expURL = "http://34.228.214.228/frontend/landing";
		urlCheck(expURL);
		lp_2 = new landingPage_2(driver);
		lp_2.executeStep();
	}

	@Test(priority = 4)
	public void testCaseNo3() throws Exception {
		String expURL = "http://34.228.214.228/frontend/landing";
		urlCheck(expURL);
		lp_3 = new landingPage_3(driver);
		lp_3.executeStep();
	}

	@Test(priority = 5)
	public void testCaseNo4() throws Exception {
		String expURL = "http://34.228.214.228/frontend/landing";
		urlCheck(expURL);
		lp_4 = new landingPage_4(driver);
		lp_4.executeStep();
	}

	@Test(priority = 6)
	public void testCaseNo1_n_testCaseNo5() throws Exception {
		String expURL = "http://34.228.214.228/frontend/landing";
		urlCheck(expURL);
		lp_1_5 = new landingPage_1_5(driver);
		lp_1_5.executeStep();
	}

	@Test(priority = 7)
	public void testCaseNo7() throws Exception {
		String expURL = "http://34.228.214.228/frontend/landing";
		urlCheck(expURL);
		sf_7 = new searchFlow_7(driver);
		sf_7.executeStep();
	}

	@Test(priority = 8)
	public void testCaseNo16() throws Exception {

		mp_16 = new mapView_16(driver);
		mp_16.executeStep();
	}

	@Test(priority = 9)
	public void testCaseNo17_n_testCaseNo30() throws Exception {

		mp_17_30 = new mapView_17_30(driver);
		mp_17_30.executeStep();

	}

	@Test(priority = 10)
	public void testCaseNo28_n_testCaseNo29() throws Exception {
		String expURL = "http://34.228.214.228/frontend/landing";
		urlCheck(expURL);
		mp_28_29 = new mapView_28_29(driver);
		mp_28_29.executeStep();
	}

	@Test(priority = 11)
	public void testCaseNo40() throws Exception {
		String expURL = "http://34.228.214.228/frontend/landing";
		urlCheck(expURL);
		pd_40 = new propertyDetail_40(driver);
		pd_40.executeStep();
	}

	@Test(priority = 12)
	public void testCaseNo41() throws Exception {
		String expURL = "http://34.228.214.228/frontend/landing";
		urlCheck(expURL);
		mp_41 = new mapView_41(driver);
		mp_41.executeStep();
	}
	
	@Test(priority = 13)
	public void testCaseNo73() throws Exception {
		String expURL = "http://34.228.214.228/frontend/landing";
		urlCheck(expURL);
		sp_73 = new signUp_73(driver);
		sp_73.executeStep();
	}

	public void urlCheck(String expectedURL) {
		String cURL = driver.getCurrentUrl();

		if (cURL.equals(expectedURL) != true) {
			driver.get(expectedURL);
		}
	}

}