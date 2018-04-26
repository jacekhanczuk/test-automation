package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import selenium.Listeners;

public class WebDriverCreators {
	public static final WebDriverCreator CHROME = () -> {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/seleniumdrivers/chromedrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        setDefaultSettings(driver);


		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		Listeners EL = new Listeners();
		eventDriver.register(EL);



		return eventDriver;
    };

	public static final WebDriverCreator DEFAULT = CHROME;

	private static void setDefaultSettings(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}

}
