package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import api.selenium.webdriver.WebDriverCreators;
import api.selenium.webdriver.WebDriverProvider;
import commons.CommonTestSteps;
import utils.Sleeper;
import website.pages.PageObjectManager;
import website.pages.page.url.Url;

public class ExperimentalTest {
	private PageObjectManager manager;
	private CommonTestSteps commonTestSteps;
	private WebDriver driver;
	private String url;
	
	@Before
	public void setUp() {
		driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
		manager = new PageObjectManager(driver);
		commonTestSteps = new CommonTestSteps(driver);
		url = Url.MAIN_PAGE.getUrl();
	}

	@Test
	public void experimentalArea() {
		commonTestSteps.loadMainPage(url);
		
		Sleeper.sleep(1);
		manager.getHomePage();
		Sleeper.sleep(3);
		
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
