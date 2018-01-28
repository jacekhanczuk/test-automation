package utils.synchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitConfig {
	private static final int defaultTimeoutInSeconds = 30;
	private static final int defaultPollingInMilliseconds = 500;

	public static FluentWait<WebDriver> loadConfig(FluentWait<WebDriver> wait, final int timeoutInSeconds) {
		configure(wait, timeoutInSeconds);
		return wait;
	}

	public static FluentWait<WebDriver> loadConfig(FluentWait<WebDriver> wait) {
		configure(wait, defaultTimeoutInSeconds);
		return wait;
	}

	private static void setPoolingPeriod(FluentWait<WebDriver> wait) {
		wait.pollingEvery(defaultPollingInMilliseconds, TimeUnit.MILLISECONDS);
	}

	private static void setTimeoutAfterSeconds(FluentWait<WebDriver> wait, final int timeoutInSeconds) {
		wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
	}

	private static void addIgnoredExceptions(FluentWait<WebDriver> wait) {
		wait.ignoring(StaleElementReferenceException.class).ignoring(ElementNotVisibleException.class)
				.ignoring(NoSuchElementException.class).ignoring(InvalidElementStateException.class).ignoring(WebDriverException.class);
	}

	private static void configure(FluentWait<WebDriver> wait, final int timeoutInSeconds) {
		addIgnoredExceptions(wait);
		setTimeoutAfterSeconds(wait, timeoutInSeconds);
		setPoolingPeriod(wait);
	}

}
