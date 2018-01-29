package selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCreators {
	public static final WebDriverCreator CHROME = new WebDriverCreator() {
		@Override
		public WebDriver create() {
			System.setProperty("webdriver.chrome.driver",
					"src/main/resources/seleniumdrivers/chromedrivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			setDefaultSettings(driver);
			return driver;
		}
	};

	public static final WebDriverCreator DEFAULT = CHROME;

	private static void setDefaultSettings(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}

}
