package selenium.pagefactory.page;

import org.openqa.selenium.WebDriver;
import website.actions.DriverActions;
import website.url.UrlResolver;

public abstract class BasePage {
	protected WebDriver driver;
	protected DriverActions action;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		action = new DriverActions(driver);
	}

	public void load() {
		driver.get(UrlResolver.getUrl(this.getClass()));
	}

}
