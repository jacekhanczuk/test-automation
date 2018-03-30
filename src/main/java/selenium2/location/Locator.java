package selenium.location;


public class Locator {
	private String expression;
	private Class<?> selectorType;

	public Locator(Class<?> selectorType, String expression) {
		this.selectorType = selectorType;
		this.expression = expression;
	}

	public Class<?> getSelectorType() {
		return selectorType;
	}

	public String getExpression() {
		return expression;
	}

	public String getExpressionWithValue(Object... args) {
		return  String.format(expression, args);
	}

}
