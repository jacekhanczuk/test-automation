package website.pages;

import org.openqa.selenium.WebDriver;

import selenium.pagefactory.annotation.Selector;
import selenium.webelement.Element;

@Page(urlPath = "/public/login.aspx")
public class LoginPage extends BasePage {

	@Selector(id = "ctl00_MainContent_txtUserName")
	private Element userEmailField;

	@Selector(id = "ctl00_MainContent_txtPassword")
	private Element userPasswordField;

	@Selector(id = "ctl00_MainContent_uxLoginButton")
	private Element submitButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void typeEmail(String emailAddress) {
		userEmailField.sendKeys(emailAddress);
	}

	public void typePassword(String password) {
		userPasswordField.sendKeys(password);
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public void loginProcess(String emailAddress, String password) {
		typeEmail(emailAddress);
		typePassword(password);
		clickSubmitButton();
	}

}