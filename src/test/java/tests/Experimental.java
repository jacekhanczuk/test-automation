package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import selenium.webdriver.WebDriverCreators;
import selenium.webdriver.WebDriverProvider;
import website.pages.PageObjectManager;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = {
		"src/test/resources/datafile/customerServiceTest.xml" }, loaderType = LoaderType.XML, writeData = false)

public class Experimental {
	private PageObjectManager manager;
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
		manager = new PageObjectManager(driver);
	}

	@Test
	public void loginProcessTest(@Param(name = "emailAddress") String emailAddress,
			@Param(name = "password") String password,
			@Param(name = "expectedConfirmationMessage") String expectedConfirmationMessage) {
		manager.getHomePage().load();
		manager.getLoginPage().load();
		manager.getProductsPage().load();
		manager.getProductsPage().print();
		manager.getProductsPage().clickProduct("Coffee with Freud");

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
