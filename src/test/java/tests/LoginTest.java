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

import api.selenium.webdriver.WebDriverCreators;
import api.selenium.webdriver.WebDriverProvider;
import commons.CommonTestSteps;
import website.pages.PageObjectManager;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = {
		"src/test/resources/datafile/customerServiceTest.xml" }, loaderType = LoaderType.XML, writeData = false)

public class LoginTest {
	private PageObjectManager manager;
	private CommonTestSteps commonTestSteps;
	private WebDriver driver;
	private String url;

	@Before
	public void setUp() {
		driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
		manager = new PageObjectManager(driver);
		commonTestSteps = new CommonTestSteps(driver);
		url = "http://www.foyles.co.uk/";
	}

	@Test
	public void loginProcessTest(@Param(name = "emailAddress") String emailAddress,
			@Param(name = "password") String password,
			@Param(name = "expectedConfirmationMessage") String expectedConfirmationMessage) {
		commonTestSteps.loadMainPage(url);
		manager.getHomePage().clickLoginButton();
		manager.getLoginPage().loginProcess(emailAddress, password);

		assertEquals(expectedConfirmationMessage, manager.getHomePage().getWelcomeMessageLabelText());
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
