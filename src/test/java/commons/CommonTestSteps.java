package commons;

import org.openqa.selenium.WebDriver;
import website.javascript.Javascript;

public class CommonTestSteps {
	private Javascript javascript;

	public CommonTestSteps(WebDriver driver) {
		javascript = new Javascript(driver);
	}

	public void moveToFooterContent() {
		javascript.fullScrollDownPage();
	}

}
