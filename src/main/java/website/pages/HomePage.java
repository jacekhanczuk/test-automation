package website.pages;

import org.openqa.selenium.WebDriver;

import selenium.pagefactory.annotation.Page;
import selenium.pagefactory.annotation.Selector;
import selenium.pagefactory.page.BasePage;
import website.webelement.Element;

@Page
public class HomePage extends BasePage {

	@Selector(xpath = "//a[@href='/Public/Login.aspx']")
	private Element loginButton;

	@Selector(className = "WelcomeMessage")
	private Element welcomeMessageLabel;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String getWelcomeMessageLabelText() {
		return welcomeMessageLabel.getText();
	}

}
