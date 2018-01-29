package website.pages;

import org.openqa.selenium.WebDriver;

import selenium.pagefactory.annotation.Selector;
import website.elements.Element;
import website.pages.page.BasePage;

public class ProductsPage extends BasePage {

	@Selector(xpath = "//div[@data-sku='%s']")
	private Element product;

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public void clickProductBySku(String productSku) {
		product.withValue(productSku).click();
	}

}