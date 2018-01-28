package website.pages;

import api.selenium.pagefactory.annotation.Selector;
import website.elements.Element;

public class LoginPage {

	@Selector(id = "ctl00_MainContent_txtUserName")
	private Element userEmailField;

	@Selector(id = "ctl00_MainContent_txtPassword")
	private Element userPasswordField;

	@Selector(id = "ctl00_MainContent_uxLoginButton")
	private Element submitButton;

	public void typeEmail(String emailAddress) {
		userEmailField.sendKeys(emailAddress);
	}

	public void typePassword(String password) {
		userPasswordField.sendKeys(password);
	}

	public void submitLoginForm() {
		submitButton.click();
	}

	public void loginProcess(String emailAddress, String password) {
		typeEmail(emailAddress);
		typePassword(password);
		submitLoginForm();
	}

}
