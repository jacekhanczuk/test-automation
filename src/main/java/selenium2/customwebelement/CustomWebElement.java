package selenium.customwebelement;

import org.openqa.selenium.WebDriver;

import selenium.location.Locator;
import utils.CustomFluentWait;


public class CustomWebElement extends BaseElement {
	private final static int DEFAULT_TIMEOUT = 10;

	public CustomWebElement(Locator locator, WebDriver driver) {
		super(locator, driver);
	}

	public void click() {
		customFluentWait.clickElement(getByObject(), DEFAULT_TIMEOUT);
	}

	public String getText() {
	return customFluentWait.getElementText(getByObject(), DEFAULT_TIMEOUT);
	}

	public String getAttribute(String attribute) {
		return customFluentWait.getElementAttribute(getByObject(), attribute ,DEFAULT_TIMEOUT);
	}

	public void sendKeys(String text) {
		customFluentWait.waitForElementDisplayed(getByObject(), DEFAULT_TIMEOUT);
		getWebElement().sendKeys(text);
	}
}
