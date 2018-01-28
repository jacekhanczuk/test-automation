package utils.synchronization;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

public class ExpectedEvents {
	private WebDriver driver;
	private String callerClassName;
	private JavascriptExecutor js;
	private Actions actions;

	public ExpectedEvents(WebDriver driver, String callerClassName) {
		this.driver = driver;
		this.callerClassName = callerClassName;
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);
	}

	public ExpectedCondition<Boolean> elementIsClicked(final WebElement element) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				element.click();
				return true;
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> elementIsClicked(final By locator) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				input.findElement(locator).click();
				return true;
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, locator, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> firstDisplayedElementFromTheListIsClicked(final List<WebElement> elements) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				if (elements.size() > 0)
					for (WebElement element : elements) {
						if (element.isDisplayed()) {
							element.click();
							return true;
						}
					}
				return false;
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, callerClassName);
			}
		};
	}

	public ExpectedCondition<String> getElementText(final WebElement element) {
		return new ExpectedCondition<String>() {

			@Override
			public String apply(WebDriver input) {
				return element.getText().isEmpty() ? null : element.getText();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element, callerClassName);
			}
		};
	}

	public ExpectedCondition<String> getElementText(final By locator) {
		return new ExpectedCondition<String>() {

			@Override
			public String apply(WebDriver input) {
				return input.findElement(locator).getText().isEmpty() ? null : input.findElement(locator).getText();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, locator, callerClassName);
			}
		};
	}

	public ExpectedCondition<String> getElementAttribute(final WebElement element, final String attribute) {
		return new ExpectedCondition<String>() {

			@Override
			public String apply(WebDriver input) {
				return element.getAttribute(attribute);
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element, callerClassName);
			}
		};
	}

	public ExpectedCondition<String> getElementAttribute(final By locator, final String attribute) {
		return new ExpectedCondition<String>() {

			@Override
			public String apply(WebDriver input) {
				return input.findElement(locator).getAttribute(attribute);
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, locator, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> selectValue(final WebElement element, final String value) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				new Select(element).selectByValue(value);
				return true;
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> selectValue(final By locator, final String value) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				new Select(input.findElement(locator)).selectByValue(value);
				return true;
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, locator, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> moveToElementAndDisplayTarget(final By moveToElement,
			final By targetToBeDisplayedAfterMove) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				actions.moveToElement(input.findElement(moveToElement)).perform();
				return input.findElement(targetToBeDisplayedAfterMove).isDisplayed();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, targetToBeDisplayedAfterMove, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> moveToElementAndDisplayTarget(final WebElement moveToElement,
			final WebElement targetToBeDisplayedAfterMove) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				actions.moveToElement(moveToElement).perform();
				return targetToBeDisplayedAfterMove.isDisplayed();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, targetToBeDisplayedAfterMove, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> moveToElementAndDisplayTarget(final WebElement moveToElement,
			final By targetToBeDisplayedAfterMove) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				actions.moveToElement(moveToElement).perform();
				return input.findElement(targetToBeDisplayedAfterMove).isDisplayed();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, targetToBeDisplayedAfterMove, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> moveToElementAndDisplayTarget(final By moveToElement,
			final WebElement targetToBeDisplayedAfterMove) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				actions.moveToElement(input.findElement(moveToElement)).perform();
				return targetToBeDisplayedAfterMove.isDisplayed();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, targetToBeDisplayedAfterMove, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> elementIsPresent(final By locator) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				return input.findElement(locator).isDisplayed();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, locator, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> elementIsPresent(final WebElement element) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				return element.isDisplayed();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> elementIsNotPresent(final WebElement element) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				try {
					element.isDisplayed();
				} catch (WebDriverException e) {
					return true;
				}
				return false;
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> elementIsNotPresent(final By locator) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				try {
					input.findElement(locator).isDisplayed();
				} catch (WebDriverException e) {
					return true;
				}
				return false;
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, locator, callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> jQueryIsNotActive() {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				return (boolean) js.executeScript(" return jQuery.active == 0");
			}
		};
	}

}