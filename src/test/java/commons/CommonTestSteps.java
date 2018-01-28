package commons;

import org.openqa.selenium.WebDriver;
import website.javascript.Javascript;

public class CommonTestSteps {
	private WebDriver driver;
	private Javascript javascript;

	public CommonTestSteps(WebDriver driver) {
		this.driver = driver;
		javascript = new Javascript(driver);
	}

	public void loadMainPage(String url) {
		driver.get(url);
	}

	public void moveToFooterContent() {
		javascript.fullScrollDownPage();
	}

	public void dismissCookieInfoPopup() {
		javascript.closeCookieInfoPopup();
	}
}
