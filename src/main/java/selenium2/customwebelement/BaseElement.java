package selenium.customwebelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.location.ByTypeCreator;
import selenium.location.Locator;
import utils.CustomFluentWait;

public abstract class BaseElement implements CustomElement {
	private By by;
	private WebDriver driver;
	private Locator locator;
	protected CustomFluentWait customFluentWait;
	private final static int DEFAULT_TIMEOUT = 10;

	public BaseElement(Locator locator, WebDriver driver) {
		customFluentWait = new CustomFluentWait(driver);
		this.driver = driver;
		this.locator = locator;
		initLocationData();
	}

	private void initLocationData() {
		by = ByTypeCreator.getTypeOfFindByObject(locator);
	}

	private void updateLocationDataWithValue(Object... args) {
		this.by = ByTypeCreator.getByTypeObjectWithValue(locator, args);
	}

	protected By getByObject() {
		return by;
	}

	public CustomElement withValue(Object... args) {
		updateLocationDataWithValue(args);
		return this;
	}

	public Locator getLocator() {
		return locator;
	}

	public WebElement getWebElement() {
		return driver.findElement(by);
	}

	public List<WebElement> getWebElementList() {
		return driver.findElements(by);
	}

	public List<CustomElement> getCustomElementList() {
		return ElementListGenerator.generateListByIndex(this, driver);
	}

	public boolean isDisplayed() {
		customFluentWait.waitForElementDisplayed(getByObject(), DEFAULT_TIMEOUT);
		return getWebElement().isDisplayed();
	}

	public boolean isEnabled() {
		return getWebElement().isEnabled();
	}

	public boolean isSelected() {
		return getWebElement().isSelected();
	}
	
}
