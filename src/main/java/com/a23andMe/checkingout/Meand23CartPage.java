package com.a23andMe.checkingout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Cart page model
 * @author Yanyi
 *
 */
public class Meand23CartPage {
	private WebDriverWait wait;

	@FindBy(xpath="//body[@id='ttam-body']/div[@class='js-main main-container store cart en-us']/div[@class='main']/div[contains(@class,'main-content en-us')]/div[@class='content-wrapper mod-overline']/div[@class='quantity-row']/div[@class='quantity-row-column']/ul[@class='quantity-list mod-tall']/li/div[@class='quantity-key']/div[@class='quantity-key-value']/div[@class='quantity-control']/span[@id='button-add-ancestry-kit']/*[1]")
	private WebElement addAncestryQuantityFirefox;
	
	@FindBy(xpath="//body[@id='ttam-body']/div[@class='js-main main-container store cart en-us']/div[@class='main']/div[contains(@class,'main-content en-us')]/div[@class='content-wrapper mod-overline']/div[@class='quantity-row']/div[@class='quantity-row-column']/ul[@class='quantity-list mod-tall']/li/div[@class='quantity-key']/div[@class='quantity-key-value']/div[@class='quantity-control']/span[@id='button-add-ancestry-kit']/*[1]")
	private WebElement addAncestryQuantityChrome;	
	
	@FindBy(xpath="//input[@class='submit button-continue js-checkout-button mod-cart']")
	private WebElement checkOutButton;
	
	public Meand23CartPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddAncestry(String browserType) {
		if (browserType.equalsIgnoreCase("firefox")) {
			wait.until(ExpectedConditions.elementToBeClickable(addAncestryQuantityFirefox));
			addAncestryQuantityFirefox.click();	
		} else if (browserType.equalsIgnoreCase("chrome")) {
			wait.until(ExpectedConditions.elementToBeClickable(addAncestryQuantityChrome));
			addAncestryQuantityChrome.click();	
		}
	}
	
	public void clickCheckOutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
		checkOutButton.click();	
	}
	
	public WebElement getAddAncestryQuantity(String browserType) {
		if (browserType.equalsIgnoreCase("firefox")) {
			return addAncestryQuantityFirefox;
		} else {
			return addAncestryQuantityChrome;
		}
	}
}
