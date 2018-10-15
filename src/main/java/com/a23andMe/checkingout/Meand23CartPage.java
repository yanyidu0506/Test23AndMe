package com.a23andMe.checkingout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Meand23CartPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath="//body[@id='ttam-body']/div[@class='js-main main-container store cart en-us']/div[@class='main']/div[contains(@class,'main-content en-us')]/div[@class='content-wrapper mod-overline']/div[@class='quantity-row']/div[@class='quantity-row-column']/ul[@class='quantity-list mod-tall']/li/div[@class='quantity-key']/div[@class='quantity-key-value']/div[@class='quantity-control']/span[@id='button-add-ancestry-kit']/*[1]")
	private WebElement addAncestryQuantity;
	
	@FindBy(xpath="//input[@class='submit button-continue js-checkout-button mod-cart']")
	private WebElement checkOutButton;
	
	public Meand23CartPage(WebDriver driver) {
		this.driver = driver;
		this.wait =new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddAncestry() {
		wait.until(ExpectedConditions.elementToBeClickable(addAncestryQuantity));
		addAncestryQuantity.click();	
	}
	
	public void clickCheckOutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
		checkOutButton.click();	
	}
	
	public WebElement getAddAncestryQuantity() {
		return addAncestryQuantity;
	}
}
