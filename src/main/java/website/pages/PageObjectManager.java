package website.pages;

import org.openqa.selenium.WebDriver;

import api.selenium.annotationlab.PageElementsFactory;

public class PageObjectManager {
	private WebDriver driver;

	private HomePage homePage;
	private LoginPage loginPage;
	private ProductsPage productsPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = PageElementsFactory.initElements(LoginPage.class, driver);
		}
		return loginPage;
	}

	public HomePage getHomePage() {
		if (homePage == null) {
			homePage = PageElementsFactory.initElements(HomePage.class, driver);
		}
		return homePage;
	}

	public ProductsPage getProductsPage() {
		if (productsPage == null) {
			productsPage = PageElementsFactory.initElements(ProductsPage.class, driver);
		}
		return productsPage;
	}

}
