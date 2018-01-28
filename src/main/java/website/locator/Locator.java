package website.locator;

public class Locator {
	private String expression;
	private Class<?> selectorType;

	public Locator(Class<?> selectorType, String expression) {
		this.selectorType = selectorType;
		this.expression = expression;
	}

	public String getExpression() {
		return expression;
	}

	public void insertValueIntoExpression(String valueToInsertIntoExpression) {
		expression = String.format(expression, valueToInsertIntoExpression);
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public Class<?> getSelectorType() {
		return selectorType;
	}

	public void setSelectorType(Class<?> selectorType) {
		this.selectorType = selectorType;
	}

}
