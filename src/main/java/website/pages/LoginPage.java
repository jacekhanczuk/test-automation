package website.pages;

import org.openqa.selenium.WebDriver;

import selenium.pagefactory.annotation.Selector;
import selenium.webelement.Element;
import utils.Sleeper;

@Page(urlPath = "/public/login.aspx")
public class LoginPage extends BasePage {

	@Selector(id = "ctl00_MainContent_txtUserName")
	private Element userEmailField;

	@Selector(id = "ctl00_MainContent_txtPassword")
	private Element userPasswordField;

	@Selector(id = "ctl00_MainContent_uxLoginButton")
	private Element submitButton;

	@Selector(xpath = "//*[@id='aspnetForm']/div[2]/div[1]/div[9]/table/tbody/tr/td[1]/div/img")
	private Element link1;

	@Selector(xpath = "//*[@id='gbwa']/div[1]/a")
	private Element link12;

	@Selector(xpath = "//*[@id='gs_ok0']")
	private Element link13;



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
		/*typeEmail(emailAddress);
		typePassword(password);

		link1.click();
*/		link12.click();
		link13.click();

		//clickSubmitButton();

		Sleeper.sleep(8);
	}

}