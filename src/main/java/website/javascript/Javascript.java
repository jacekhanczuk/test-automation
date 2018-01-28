package website.javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Javascript {
	private JavascriptExecutor js;

	public Javascript(WebDriver driver) {
		js = ((JavascriptExecutor) driver);
	}

	private void execute(String script) {
		js.executeScript(script);
	}

	public void fullScrollDownPage() {
		execute("window.scrollTo(0, document.body.scrollHeight)");
	}

}
