package website.webelement;

import org.openqa.selenium.WebDriver;

import selenium.pagefactory.element.BaseElement;
import selenium.pagefactory.location.ElementLocator;
import utils.synchronization.CustomFluentWait;

public class Element extends BaseElement {
	protected static final int TIMEOUT = 10;
	protected CustomFluentWait fluentWait;

	public Element(ElementLocator locator, WebDriver driver) {
		super(locator, driver);
		fluentWait = new CustomFluentWait(driver);
	}

	@Override
	public Element withValue(String value) {
		return (Element) super.withValue(value);
	}

	public void click() {
		fluentWait.clickElement(this, TIMEOUT);
	}

	public String getText() {
		return fluentWait.getElementText(this, TIMEOUT);
	}

	public String getAttribute(String attribute) {
		return fluentWait.getElementAttribute(this, attribute, TIMEOUT);
	}

	public void sendKeys(String text) {
		fluentWait.waitForElementDisplayed(this, TIMEOUT);
		getWebElement().sendKeys(text);
	}

}
