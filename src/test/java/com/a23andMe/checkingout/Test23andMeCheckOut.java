package com.a23andMe.checkingout;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.StringUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * test case for checkout out.
 * @author Yanyi
 *
 */
public class Test23andMeCheckOut {
        private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
	private static final String CART_URL ="https://store.23andme.com/";
	private static final String INVALID_FIRST_NAME_EXPECTED_MSG = "Invalid first name";
	private static final String INVALID_LAST_NAME_EXPECTED_MSG = "Invalid last name";
	private static final String INVALID_EMAIL_EXPECTED_MSG = "Invalid email";
	private static final String INVALID_CITY_EXPECTED_MSG = "Invalid city";
	private static final String INVALID_ADDRESS_EXPECTED_MSG = "Invalid address";
	private String browserType;
	
	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browser) {
		this.browserType = browser;
		if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty(WEBDRIVER_GECKO_DRIVER, "geckodriver");
		} else if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty(WEBDRIVER_GECKO_DRIVER, "chromedriver");
		}
	}

	@Test(dataProvider = "addressData", dataProviderClass = TestDataProvider.class)
	public void testCheckOut(String firstName, String lastName, String address, 
			String city, String state, String zipCode,
			String emailAddress, String phoneNo, String cardNo, 
			String cardExp, String cardCvv)
			throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(CART_URL);
		Meand23CartPage cartPage = new Meand23CartPage(driver);
		Meand23CheckOutPage checkOutPage = new Meand23CheckOutPage(driver);
		cartPage.clickAddAncestry(browserType);
		cartPage.clickCheckOutButton();
		checkOutPage.sendKeysToFirstName(firstName);
		checkOutPage.sendKeysToLastName(lastName);
		checkOutPage.sendKeysToAddress(address);
		checkOutPage.sendKeysToCity(city);
		checkOutPage.selectState(state);
		checkOutPage.sendKeysToZipCode(zipCode);
		checkOutPage.sendKeysToEmailAddress(emailAddress);
		checkOutPage.sendKeysToPhoneNo(phoneNo);
		checkOutPage.clickContinueToShippingMethodButton();
		if (StringUtil.isBlank(firstName)) {
			assertErrorMsg(driver, checkOutPage, INVALID_FIRST_NAME_EXPECTED_MSG);
			return;
		}
		if (StringUtil.isBlank(lastName)) {
			assertErrorMsg(driver, checkOutPage, INVALID_LAST_NAME_EXPECTED_MSG);
			return;
		}
		if (!emailAddress.contains("@")) {
			assertErrorMsg(driver, checkOutPage, INVALID_EMAIL_EXPECTED_MSG);
			return;
		}
		if (StringUtil.isBlank(city)) {
			assertErrorMsg(driver, checkOutPage, INVALID_CITY_EXPECTED_MSG);
			return;
		}
		if (StringUtil.isBlank(address)) {
			assertErrorMsg(driver, checkOutPage, INVALID_ADDRESS_EXPECTED_MSG);
			return;
		}
		
		checkOutPage.clickContinueToBillingButton();
		checkOutPage.sendKeysToCardNo(cardNo);
		checkOutPage.sendKeysToExpiration(cardExp);
		checkOutPage.sendKeysToCVV(cardCvv);
		checkOutPage.clickContinueToOrderReviewButton();
		checkOutPage.checkAcceptTermBox(this.browserType);
		checkOutPage.clickSubmitOrderButton();
		Assert.assertEquals(checkOutPage.getEditPaymentButton().isDisplayed(), true);
		driver.quit();
	}

	private void assertErrorMsg(WebDriver driver, Meand23CheckOutPage checkOutPage, String expectedErrorMsg) {
		Assert.assertEquals(checkOutPage.getErrorMessage().isDisplayed(), true);
		String errorMsg = checkOutPage.getErrorMessage().getText();
		Assert.assertEquals(errorMsg, expectedErrorMsg);
		driver.quit();
		return;
	}
}
