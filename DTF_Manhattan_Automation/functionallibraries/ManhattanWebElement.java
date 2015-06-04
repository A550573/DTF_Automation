package functionallibraries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;
import supportlibraries.SeleniumReport;

import com.cognizant.framework.Status;

/**
 * Manhattan Web Element class
 * 
 * @author ManhattanDotCommACOE
 */
public class ManhattanWebElement implements WebElement {

	private final WebElement element;
	private final int SHORT_TO = 5;
	private final int MEDIUM_TO = 15;
	//private final int LONG_TO = 20;

	private ScriptHelper scriptHelper;
	private SeleniumReport report;
	private WebDriver driver;
	private ManhattanCommonFunctions libManhattanCommonFunctions;

	public ManhattanWebElement(ScriptHelper scriptHelper, final WebElement element) {
		this.element = element;
		this.scriptHelper = scriptHelper;
		this.report = scriptHelper.getReport();
		this.driver = scriptHelper.getDriver();
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
	}

	public void clickToShoppingCart() {
		clickAndWaitForFeedback();
		if (libManhattanCommonFunctions.waitForElementVisibilityByLinkText(
				"View Cart", MEDIUM_TO)) {
			ManhattanWebElement lnkViewCart = new ManhattanWebElement(scriptHelper,
					libManhattanCommonFunctions.getElementByProperty("View Cart",
							"LINKTEXT"));
			lnkViewCart.click();
		}
		if (libManhattanCommonFunctions.waitForElementVisibility(
				"//*[@id='leadtimechanged']", SHORT_TO)) {
			ManhattanWebElement lnkAddToCart = new ManhattanWebElement(scriptHelper,
					libManhattanCommonFunctions.getElementByProperty("Add to Cart",
							"LINKTEXT"));
			lnkAddToCart.click();
		}
		if (libManhattanCommonFunctions.waitForElementVisibilityByLinkText(
				"Continue to Cart", SHORT_TO)) {
			ManhattanWebElement lnkContinueToCart = new ManhattanWebElement(scriptHelper,
					libManhattanCommonFunctions.getElementByProperty(
							"Continue to Cart", "LINKTEXT"));
			lnkContinueToCart.click();
		}
	}

	private void clickAndWaitForFeedback() {
		try {
			if (driver.getTitle().contains("Certificate Error")) {
				driver.navigate()
						.to("javascript:document.getElementById('overridelink').click()");
			}
			if (element.isDisplayed() || element.isEnabled()) {
				libManhattanCommonFunctions.clickAnyElement(element,
						element.getText());
				if (libManhattanCommonFunctions.waitForElementVisibility(
						"//*[@class='fsrwin']", SHORT_TO))
					if (libManhattanCommonFunctions
							.verifyText("We'd like your feedback"))
						libManhattanCommonFunctions.clickAnyElement(
								"//*[@id='decline']", "XPATH", "No Thanks");
			}
		} catch (Exception e) {
			report.updateTestLog("Manhattan WEB ELEMENT - CLICKANDWAITFORFEEDBACK",
					"Error in identifying element:" + e.getMessage(),
					Status.DONE);
		}

	}

	@Override
	public void click() {
		clickAndWaitForFeedback();
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		element.sendKeys(keysToSend);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCssValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub

	}

}
