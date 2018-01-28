package website.pages;

import api.selenium.pagefactory.annotation.Selector;
import website.elements.Element;

public class ProductsPage  {

	@Selector(xpath = "//div[@data-sku='%s']")
	private Element product;

	public Element getProduct(String productSku) {
		return product.withValue(productSku);
	}

}
