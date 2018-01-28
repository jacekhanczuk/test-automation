package website.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import api.selenium.annotationlab.ByTypeCreator;
import utils.synchronization.CustomFluentWait;
import website.locator.Locator;

public class Element {
	public static final int TIMEOUT = 10;
	private WebDriver driver;
	private CustomFluentWait wait;
	private Locator locator;
	private By by;

	public Element(Locator locator, WebDriver driver) {
		this.driver = driver;
		this.locator = locator;
		wait = new CustomFluentWait(driver);
		initLocationData();
	}

	private void initLocationData() {
		by = ByTypeCreator.getByTypeObject(locator);
	}

	private void updateLocation() {
		initLocationData();
	}

	private WebElement getWebElement() {
		return driver.findElement(by);
	}

	public Element withValue(String value) {
		locator.insertValueIntoExpression(value);
		updateLocation();
		return this;
	}

	public String getText() {
		return wait.getElementText(by, TIMEOUT);
	}

	public String getAttribute(String attribute) {
		return wait.getElementAttribute(by, attribute, TIMEOUT);
	}

	public boolean isDisplayed() {
		return getWebElement().isDisplayed();
	}

	public void click() {
		wait.clickElement(by, TIMEOUT);
	}

	public void sendKeys(String text) {
		wait.waitForElementDisplayed(by, TIMEOUT);
		getWebElement().sendKeys(text);
	}

}
