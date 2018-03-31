package website.pages;

import org.openqa.selenium.WebDriver;
import website.actions.DriverAction;
import website.url.UrlResolver;

public abstract class BasePage {
	protected WebDriver driver;
	protected DriverAction action;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		action = new DriverAction(driver);
	}

	public void load() {
		driver.get(UrlResolver.getUrl(this.getClass()));
	}

}
