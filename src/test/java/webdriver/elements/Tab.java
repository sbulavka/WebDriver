package webdriver.elements;

import org.openqa.selenium.By;

public class Tab extends BaseElement {

	public Tab(final By locator, final String name) {
		super(locator, name);
	}

	public Tab(String string, String name) {
		super(string, name);
	}



	public Tab(By locator) {
		super(locator);
	}

	protected String getElementType() {
		return getLoc("loc.tab");
	}

}
