package com.a23andMe.checkingout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * checkout page model
 * @author Yanyi
 *
 */
public class Meand23CheckOutPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Meand23CheckOutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 25);
		PageFactory.initElements(driver, this);
	}
	
	private Select sel;
	
	@FindBy(id="js-shipping-firstname")
	private WebElement firstNameElem;
	
	@FindBy(id="js-shipping-lastname")
	private WebElement lastNameElem;
	
	@FindBy(id="js-shipping-address")
	private WebElement addressElem;
	
	@FindBy(id="js-shipping-city")
	private WebElement cityElem;
	
	@FindBy(id="js-shipping-state")
	private WebElement stateElem;
	
	@FindBy(id="js-shipping-zip")
	private WebElement zipCodeElem;
	
	@FindBy(id="js-shipping-email")
	private WebElement emailAddressElem;
	
	@FindBy(id="js-shipping-phone")
	private WebElement phoneNoElem;
	
	@FindBy(xpath="//button[@class='spc-next-button']")
	private WebElement continueToShippingMethodButton;

	@FindBy(xpath="//button[@class='spc-next-button mod-ok ']")
	private WebElement continueToBillingButton;
	
	@FindBy(xpath="//input[@id='credit-card-number']")
	private WebElement cardNoElem;
	
	@FindBy(id="expiration")
	private WebElement expirationElem;
	
	@FindBy(id="cvv")
	private WebElement cvvElem;
	
	@FindBy(xpath="//button[@id='submit-order-button']")
	private WebElement continueToOrderReviewButton;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement acceptTermBoxFirefox;
	
//	@FindBy(xpath="//input[@type='checkbox' and @aria-label='I accept the Terms of Service']")
	@FindBy(css="div.spc div.spc-container div.spc-outer:nth-child(9) div.spc-wrap.spc-summary form.spc-summary-accept.mod-fade-in div.spc-form-content-wrap- div.spc-tos-wrap div.spc-checkbox-outer div.spc-checkbox-wrap:nth-child(2) > label.spc-checkbox")
	private WebElement acceptTermBoxChrome;
	
	@FindBy(xpath="//button[@class='spc-summary-accept-button spc-next-button mod-ok ']")
	private WebElement submitOrderButton;
	
	@FindBy(xpath="//button[contains(text(),'edit payment')]")
	private WebElement editPaymentButton;
	
	@FindBy(xpath="//div[@class='spc-input mod-error']//span")
	private WebElement errorMessage;
	
	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public WebElement getEditPaymentButton() {
		return editPaymentButton;
	}

	public void sendKeysToFirstName(String firstName) {
		firstNameElem.sendKeys(firstName);
	}
	
	public void sendKeysToLastName(String lastName) {
		lastNameElem.sendKeys(lastName);
	}
	
	public void sendKeysToAddress(String address) {
		addressElem.sendKeys(address);
	}
	
	public void sendKeysToCity(String city) {
		cityElem.sendKeys(city);
	}
	
	public void selectState(String state) {
		sel = new Select(stateElem);
		sel.selectByVisibleText(state);
	}
	
	public void sendKeysToZipCode(String zipCode) {
		zipCodeElem.sendKeys(zipCode);
	}
	
	public void sendKeysToEmailAddress(String email) {
		emailAddressElem.sendKeys(email);
	}
	
	public void sendKeysToPhoneNo(String phoneNo) {
		phoneNoElem.sendKeys(phoneNo);
	}
	
	public void clickContinueToBillingButton() {
		wait.until(ExpectedConditions.elementToBeClickable(continueToBillingButton));
		continueToBillingButton.click();
	}
	
	public void clickContinueToShippingMethodButton() {
		continueToShippingMethodButton.click();
	}
	
	public void sendKeysToCardNo(String cardNo) {
		driver.switchTo().frame("braintree-hosted-field-number");
		cardNoElem.sendKeys(cardNo);
		driver.switchTo().defaultContent();
	}
	
	public void sendKeysToExpiration(String cardExp) {
		driver.switchTo().frame("braintree-hosted-field-expirationDate");
		expirationElem.sendKeys(cardExp);
		driver.switchTo().defaultContent();
	}
	
	public void sendKeysToCVV(String cardCvv) {
		driver.switchTo().frame("braintree-hosted-field-cvv");
		cvvElem.sendKeys(cardCvv);
		driver.switchTo().defaultContent();
	}
	
	public void clickContinueToOrderReviewButton() {
		continueToOrderReviewButton.click();
	}
	
	public void checkAcceptTermBox(String browserType) {
		wait.until(ExpectedConditions.elementToBeClickable(acceptTermBoxChrome));

		if (browserType.equalsIgnoreCase("firefox")) {
			acceptTermBoxFirefox.click();
		} else if (browserType.equalsIgnoreCase("chrome")) {
			acceptTermBoxChrome.click();
		}
	}
	
	public void clickSubmitOrderButton() {
		submitOrderButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(editPaymentButton));
	}
}
