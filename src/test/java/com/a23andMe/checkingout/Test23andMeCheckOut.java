package com.a23andMe.checkingout;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.a23andMe.checkingout.Meand23CartPage;

public class Test23andMeCheckOut {
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    private WebDriver driver;
	private WebDriverWait wait;
	private static final String cartUrl ="https://store.23andme.com/";
	Meand23CartPage cartPage;
	
//	@Parameters({"browserType", "platform"})

//	public void setUp(String browserType, String platform) throws InterruptedException {
//        if (browserType.equalsIgnoreCase("firefox") && platform.equalsIgnoreCase("mac")) {
//            System.setProperty(WEBDRIVER_GECKO_DRIVER, "geckodriverMac");
//            driver = new FirefoxDriver();
//        } else if (browserType.equalsIgnoreCase("chrome") && platform.equalsIgnoreCase("mac")) {
//            System.setProperty(WEBDRIVER_CHROME_DRIVER, "chromedriverMac");
//            driver = new ChromeDriver();
//        } else if (browserType.equalsIgnoreCase("firefox") && platform.equalsIgnoreCase("linux64")) {
//            System.setProperty(WEBDRIVER_GECKO_DRIVER, "geckodriverLinux64");
//            driver = new FirefoxDriver();
//        } else if (browserType.equalsIgnoreCase("chrome") && platform.equalsIgnoreCase("linux64")) {
//            System.setProperty(WEBDRIVER_CHROME_DRIVER, "chromedriverLinux64");
//            driver = new ChromeDriver();
//        }
	//41-43 will be replace by 23-38
	@BeforeClass
	public void beforeClass() {		    
		System.setProperty("webdriver.gecko.driver", "/Users/Yanyi/JavaFile/workspace/W1/workspace/Selenium/geckodriver");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.get(cartUrl);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Other Store FAQs')]")));
	    cartPage = new Meand23CartPage(driver);
  }
  
  @Test
  public void checkOut() throws InterruptedException {
//      wait.until(ExpectedConditions.elementToBeClickable(cartPage.getAddAncestryQuantity()));
	  cartPage.clickAddAncestry();
//	  WebElement closePopUp = driver.findElement(By.className("bx-close-xsvg"));
//	  closePopUp.click();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
