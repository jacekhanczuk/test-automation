package website.pages.page.url;

public enum Url {
	MAIN_PAGE("http://www.foyles.co.uk/");

	private final String baseUrl;

	Url(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getUrl() {
		return baseUrl;
	}

}