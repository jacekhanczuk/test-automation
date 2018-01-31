package website.pages;

import org.openqa.selenium.WebDriver;

import selenium.pagefactory.annotation.Selector;
import website.elements.Element;
import website.pages.page.BasePage;
import website.pages.page.annotation.Page;

@Page
public class HomePage extends BasePage {

	@Selector(xpath = "//a[@href='/Public/Login.aspx']")
	private Element loginButton;

	@Selector(className = "WelcomeMessage")
	private Element welcomeMessageLabel;

	@Selector(id = "ctl00_MailingList")
	public Element newsletterLink;

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
