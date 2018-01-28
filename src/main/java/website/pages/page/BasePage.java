package website.pages.page;

import org.openqa.selenium.WebDriver;
import website.actions.DriverActions;

public abstract class BasePage {
	protected WebDriver driver;
	protected DriverActions action;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		action = new DriverActions(driver);
	}

}
