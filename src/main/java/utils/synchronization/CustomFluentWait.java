package utils.synchronization;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomFluentWait {
	private FluentWaitFactory waitFactory;
	private ExpectedEvents expectedEvents;

	public CustomFluentWait(WebDriver driver) {
		waitFactory = new FluentWaitFactory(driver);
		expectedEvents = new ExpectedEvents(driver, this.getClass().getName());
	}

	public void waitForElementDisplayed(final By locator) {
		waitFactory.getCustomWait().until(expectedEvents.elementIsPresent(locator));
	}

	public void waitForElementDisplayed(final By locator, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.elementIsPresent(locator));
	}

	public void waitForElementDisplayed(final WebElement element) {
		waitFactory.getCustomWait().until(expectedEvents.elementIsPresent(element));
	}

	public void waitForElementDisplayed(final WebElement element, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.elementIsPresent(element));
	}

	public void waitForElementIsNotPresent(final WebElement element) {
		waitFactory.getCustomWait().until(expectedEvents.elementIsNotPresent(element));
	}

	public void waitForElementIsNotPresent(final WebElement element, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.elementIsNotPresent(element));
	}

	public void waitForElementIsNotPresent(final By locator) {
		waitFactory.getCustomWait().until(expectedEvents.elementIsNotPresent(locator));
	}

	public void waitForElementIsNotPresent(final By locator, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.elementIsNotPresent(locator));
	}

	public void clickElement(final By locator) {
		waitFactory.getCustomWait().until(expectedEvents.elementIsClicked(locator));
	}

	public void clickElement(final By locator, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.elementIsClicked(locator));
	}

	public void clickElement(final WebElement element) {
		waitFactory.getCustomWait().until(expectedEvents.elementIsClicked(element));
	}

	public void clickElement(final WebElement element, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.elementIsClicked(element));
	}

	public void clickFirstDisplayedElementFromTheList(final List<WebElement> elements, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds)
				.until(expectedEvents.firstDisplayedElementFromTheListIsClicked(elements));
	}

	public void clickFirstDisplayedElementFromTheList(final List<WebElement> elements) {
		waitFactory.getCustomWait().until(expectedEvents.firstDisplayedElementFromTheListIsClicked(elements));
	}

	public void selectDropdownValue(final WebElement element, final String value) {
		waitFactory.getCustomWait().until(expectedEvents.selectValue(element, value));
	}

	public void selectDropdownValue(final WebElement element, final String value, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.selectValue(element, value));
	}

	public void selectDropdownValue(final By locator, final String value) {
		waitFactory.getCustomWait().until(expectedEvents.selectValue(locator, value));
	}

	public void selectDropdownValue(final By locator, final String value, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.selectValue(locator, value));
	}

	public String getElementText(final WebElement element) {
		return waitFactory.getCustomWait().until(expectedEvents.getElementText(element));
	}

	public String getElementText(final WebElement element, final int timeoutInSeconds) {
		return waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.getElementText(element));
	}

	public String getElementText(final By locator) {
		return waitFactory.getCustomWait().until(expectedEvents.getElementText(locator));
	}

	public String getElementText(final By locator, final int timeoutInSeconds) {
		return waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.getElementText(locator));
	}

	public String getElementAttribute(final WebElement element, final String attribute) {
		return waitFactory.getCustomWait().until(expectedEvents.getElementAttribute(element, attribute));
	}

	public String getElementAttribute(final WebElement element, final String attribute, final int timeoutInSeconds) {
		return waitFactory.getCustomWait(timeoutInSeconds)
				.until(expectedEvents.getElementAttribute(element, attribute));
	}

	public String getElementAttribute(final By locator, final String attribute) {
		return waitFactory.getCustomWait().until(expectedEvents.getElementAttribute(locator, attribute));
	}

	public String getElementAttribute(final By locator, final String attribute, final int timeoutInSeconds) {
		return waitFactory.getCustomWait(timeoutInSeconds)
				.until(expectedEvents.getElementAttribute(locator, attribute));
	}

	public void moveToElementUntilTargetIsDisplayed(final WebElement moveToElement, By targetToBeDisplayedAfterMove,
			final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds)
				.until(expectedEvents.moveToElementAndDisplayTarget(moveToElement, targetToBeDisplayedAfterMove));
	}

	public void moveToElementUntilTargetIsDisplayed(final WebElement moveToElement,
			WebElement targetToBeDisplayedAfterMove, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds)
				.until(expectedEvents.moveToElementAndDisplayTarget(moveToElement, targetToBeDisplayedAfterMove));
	}

	public void waitForContentIsLoaded(int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.jQueryIsNotActive());
	}

}