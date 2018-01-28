package website.pages;

import api.selenium.annotationlab.Selector;
import website.elements.Element;

public class HomePage {

	@Selector(xpath = "//a[@href='/Public/Login.aspx']")
	private Element loginButton;

	@Selector(className = "WelcomeMessage")
	private Element welcomeMessageLabel;

	public void clickLoginButton() {
		loginButton.click();
	}

	public String getWelcomeMessageLabelText() {
		return welcomeMessageLabel.getText();
	}
}
