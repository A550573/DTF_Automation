package functionallibraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverBackedSelenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

@SuppressWarnings("unused")
public class ManhattanCommonFunctions extends ReusableLibrary {
	public String ORName = "Common_OR";

	public ManhattanCommonFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	public static Wait wait;
	Selenium selenium = new WebDriverBackedSelenium(driver,
			properties.getProperty("ApplicationUrl"));

	/**
	 ************************************************************* 
	 * Function to verify whether a given Element is present within the page and
	 * click
	 * 
	 * @param strObjProperty
	 *            The {@link strObjProperty} defines the property value used for
	 *            identifying the object
	 * @param strObjPropertyType
	 *            The {@link strObjPropertyType} describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean clickAnyElement(String strObjProperty,
			String strObjPropertyType, String strObjName) {
		try {
			if (isElementPresentVerification(strObjProperty,
					strObjPropertyType, strObjName)) {
				WebElement elemToClick = getElementByProperty(strObjProperty,
						strObjPropertyType);
				clickAnyElement(elemToClick, strObjName);
			} else
				report.updateTestLog("Verify if the Element(" + strObjName
						+ ") is present and Click", strObjName
						+ " is not present", Status.FAIL);
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("CLICK Any Element : " + strObjName,
					strObjName + " object does not exist in page", Status.FAIL);
		} catch (Exception e) {
			report.updateTestLog("CLICK ANY ELEMENT",
					"Error in method - Error Description - " + e.toString(),
					Status.FAIL);
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to click a given element
	 * 
	 * @param elemToClick
	 *            The {@link strObjProperty} element to be clicked
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean clickAnyElement(WebElement elemToClick, String strObjName) {
		try {
			if (elemToClick.isEnabled()) {
				elemToClick.click();
				report.updateTestLog("Verify if the Element(" + strObjName
						+ ") is present and Click", strObjName
						+ " is present and clicked", Status.DONE);
				return true;
			} else
				report.updateTestLog("Verify if the Element(" + strObjName
						+ ") is present and Click", strObjName
						+ " is not enabled", Status.FAIL);
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Select Any Element : " + strObjName,
					strObjName + " object does not exist in page", Status.FAIL);
		} catch (Exception e) {
			report.updateTestLog("CLICK ANY ELEMENT",
					"Error in finding object - " + strObjName
					+ ". Error Description - " + e.toString(),
					Status.FAIL);
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify whether a given Element is present within the page and
	 * update the value
	 * 
	 * @param strObjProperty
	 *            The {@link strObjProperty} defines the property value used for
	 *            identifying the object
	 * @param strObjPropertyType
	 *            The {@link strObjPropertyType} describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean updateAnyElement(String strObjProperty,
			String strObjPropertyType, String strValueToUpdate,
			String strObjName) {
		if (strValueToUpdate.trim().equalsIgnoreCase("IGNORE")) {
			try {
				if (isElementPresentVerification(strObjProperty,
						strObjPropertyType, strObjName)) {
					WebElement elemToClick = getElementByProperty(
							strObjProperty, strObjPropertyType);
					updateAnyElement(elemToClick, strValueToUpdate, strObjName);
				} else
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is present and updated", strObjName
							+ " is not present", Status.FAIL);
			} catch (org.openqa.selenium.NoSuchElementException nsee) {
				report.updateTestLog("UPDATE Any Element : " + strObjName,
						strObjName + " object does not exist in page",
						Status.FAIL);
			} catch (Exception e) {
				report.updateTestLog(
						"UPDATE ANY ELEMENT",
						"Error in method - Error Description - " + e.toString(),
						Status.FAIL);
			}
			return false;
		} else
			return true;
	}

	/**
	 ************************************************************* 
	 * Function to clear and update value in the given element
	 * 
	 * @param elemToUpdate
	 *            The {@link elemToUpdate} element to be updated
	 * @param strValueToUpdate
	 *            The {@link strValueToUpdate} value to be updated
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean clearAndUpdateAnyElement(WebElement elemToUpdate,
			String strValueToUpdate, String strObjName) {
		if (!strValueToUpdate.trim().equalsIgnoreCase("IGNORE")) {
			try {
				if (elemToUpdate.isDisplayed() && elemToUpdate.isEnabled()) {
					elemToUpdate.clear();
					updateAnyElement(elemToUpdate, strValueToUpdate, strObjName);
				} else
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is present and update", strObjName
							+ " is not enabled", Status.FAIL);
			} catch (org.openqa.selenium.NoSuchElementException nsee) {
				report.updateTestLog("UPDATE ANY ELEMENT : " + strObjName,
						strObjName + " object does not exist in page",
						Status.FAIL);
			} catch (Exception e) {
				report.updateTestLog("UPDATE ANY ELEMENT",
						"Error in finding object - " + strObjName
						+ ". Error Description - " + e.toString(),
						Status.FAIL);
			}
			return false;
		} else
			return true;
	}

	/**
	 ************************************************************* 
	 * Function to click a given element
	 * 
	 * @param elemToClick
	 *            The {@link strObjProperty} element to be updated
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean updateAnyElement(WebElement elemToUpdate,
			String strValueToUpdate, String strObjName) {
		if (!strValueToUpdate.trim().equalsIgnoreCase("IGNORE")) {
			try {
				if (elemToUpdate.isDisplayed() && elemToUpdate.isEnabled()) {
					elemToUpdate.click();
					elemToUpdate.clear();
					elemToUpdate.sendKeys(strValueToUpdate);
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is present and updated", strObjName
							+ " is present and updated with value : "
							+ strValueToUpdate, Status.DONE);
					return true;
				} else
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is present and updated", strObjName
							+ " is not enabled", Status.FAIL);
			} catch (org.openqa.selenium.NoSuchElementException nsee) {
				report.updateTestLog("UPDATE ANY ELEMENT : " + strObjName,
						strObjName + " object does not exist in page",
						Status.FAIL);
			} catch (Exception e) {
				report.updateTestLog("UPDATE ANY ELEMENT",
						"Error in finding object - " + strObjName
						+ ". Error Description - " + e.toString(),
						Status.FAIL);
			}
			return false;
		} else
			return true;
	}

	/**
	 ************************************************************* 
	 * Method to select an option directly from combo box/list box
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strElemStateToVerify} describes the state to be
	 *            verified which can be either one of ENABLED/SELECTED/VALUE
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for reporting purposes.
	 * @return A boolean value indicating if selecting an option is done.
	 ************************************************************* 
	 */
	public void selectAnyElement(String strObjProperty,
			String strObjPropertyType, String strValueToSelect,
			String strObjName) {
		if (!(strValueToSelect.trim().equalsIgnoreCase("IGNORE"))) {
			try {
				WebElement elementToSelect = getElementByProperty(
						strObjProperty, strObjPropertyType);
				selectAnyElement(elementToSelect, strValueToSelect, strObjName);
			} catch (org.openqa.selenium.NoSuchElementException nsee) {
				report.updateTestLog("Select Any Element : " + strObjName,
						strObjName + " object does not exist in page",
						Status.FAIL);
			} catch (Exception e) {
				report.updateTestLog("SELECT ANY ELEMENT",
						"Error in finding element - " + strObjProperty
						+ ", by " + "" + "" + ": " + strObjPropertyType
						+ ". Error Description - " + e.toString(),
						Status.FAIL);
			}
		}
	}

	/**
	 ************************************************************* 
	 * Method to select an option directly from combo box/list box
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strElemStateToVerify} describes the state to be
	 *            verified which can be either one of ENABLED/SELECTED/VALUE
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for reporting purposes.
	 * @return A boolean value indicating if selecting an option is done.
	 ************************************************************* 
	 */
	public void selectAnyElement(WebElement elementToSelect,
			String strValueToSelect, String strObjName) {
		if (!(strValueToSelect.trim().equalsIgnoreCase("IGNORE"))) {
			if (elementToSelect.isEnabled()) {
				Select comSelElement = new Select(elementToSelect);
				comSelElement.selectByVisibleText(strValueToSelect.trim());
				report.updateTestLog("Verify if the Element(" + strObjName
						+ ") is present and selected", strObjName
						+ " value : '" + strValueToSelect + "' is selected",
						Status.PASS);
			} else
				report.updateTestLog("Verify if the Element(" + strObjName
						+ ") is present and selected", strObjName
						+ " object is not enabled", Status.FAIL);
		}
	}

	/**
	 ************************************************************* 
	 * Method to check/uncheck a checkbox based on the given option
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strElemStateToVerify} describes the state to be set
	 *            which can be one of: Y/N
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for reporting purposes.
	 * @return None
	 ************************************************************* 
	 */
	public void checkAnyElement(WebElement elementToSelect,
			String strValueToSelect, String strObjName) {
		String strStateToReport = " ";
		boolean blnValueToSelect = true;
		if (!(strValueToSelect.trim().equalsIgnoreCase("IGNORE"))) {
			if (strValueToSelect.trim().equalsIgnoreCase("N")) {
				blnValueToSelect = false;
				strStateToReport = " not ";
			}
			if (elementToSelect.isEnabled()) {
				if (!blnValueToSelect && !elementToSelect.isSelected()) {
					if (blnValueToSelect && elementToSelect.isSelected())
						elementToSelect.click();
				}
				elementToSelect.click();
				report.updateTestLog("Select the element (" + strObjName + ")",
						strObjName + " is" + strStateToReport
						+ "checked as required", Status.PASS);

			} else
				report.updateTestLog("Verify if the Element(" + strObjName
						+ ") is present and selected", strObjName
						+ " object is not enabled", Status.FAIL);
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify whether a given Element is present within the page and
	 * click
	 * 
	 * @param strObjProperty
	 *            The {@link strObjProperty} defines the property value used for
	 *            identifying the object
	 * @param strObjPropertyType
	 *            The {@link strObjPropertyType} describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean clickIfElementPresent(String strObjProperty,
			String strObjPropertyType, String strObjName) {
		try {
			if (isElementPresentVerification(strObjProperty,
					strObjPropertyType, strObjName)) {
				getElementByProperty(strObjProperty, strObjPropertyType)
				.click();
				report.updateTestLog("Verify if the Element(" + strObjName
						+ ") is present and Click", strObjName
						+ " is present and clicked", Status.DONE);
				return true;
			} else {
				report.updateTestLog("Verify if the Element(" + strObjName
						+ ") is present and Click", strObjName
						+ " is not present", Status.FAIL);
				return false;
			}
		} catch (Exception e) {
			report.updateTestLog("CLICK IF ELEMENT PRESENT",
					"Error in method - Error Description - " + e.toString(),
					Status.FAIL);
			return false;
		}
	}

	/**
	 ************************************************************* 
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {@link WebElement} object.
	 ************************************************************* 
	 */
	public WebElement getElementByProperty(String strObjectProperty,
			String strFindElementType) {
		try {
			if (strFindElementType.equalsIgnoreCase("CSS"))
				return driver.findElement(By.cssSelector(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("XPATH"))
				return driver.findElement(By.xpath(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("ID"))
				return driver.findElement(By.id(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("NAME"))
				return driver.findElement(By.name(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("LINKTEXT"))
				return driver.findElement(By.linkText(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("TAG"))
				return driver.findElement(By.tagName(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("CLASS"))
				return driver.findElement(By.className(strObjectProperty));
			else
				return null;
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Verify if the expected search text = "
					+ strObjectProperty + " is present", nsee.toString(),
					Status.FAIL);
			return null;
		}

		catch (Exception e) {
			report.updateTestLog("GET ELEMENT BY PROPERTY",
					"Error in finding element - " + strObjectProperty + ", by "
							+ "" + "" + ": " + strFindElementType
							+ ". Error Description - " + e.toString(),
							Status.FAIL);
			return null;
		}
	}

	/**
	 ************************************************************* 
	 * Method to verify an element state based on given input conditions and
	 * report
	 * 
	 * @param elemToVerify
	 *            The {@link strObjProperty} element to be verified
	 * @param strElemStateToVerify
	 *            The {@link strElemStateToVerify} describes the state to be
	 *            verified which can be either one of ENABLED/SELECTED/VALUE
	 * @param strExpValue
	 *            The {@link strExpValue} corresponds to each state
	 *            representations of {@link strElemStateToVerify} namely
	 *            Y/N/<the actual text>
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean verifyAndReportElementState(String strObjProperty,
			String strObjPropertyType, String strElemStateToVerify,
			String strExpValue, String strObjName) {
		String strExpStateToReport = " ";
		boolean blnExpValue = true;
		if (!strExpValue.trim().equalsIgnoreCase("IGNORE")) {
			if (strExpValue.trim().equalsIgnoreCase("N")) {
				strExpStateToReport = " not ";
				blnExpValue = false;
			}
			WebElement elemToVerify = getElementByProperty(strObjProperty,
					strObjPropertyType);

			// ****************To verify the element is enabled or
			// not***********
			if (strElemStateToVerify.equalsIgnoreCase("ENABLED")) {
				if ((elemToVerify.isEnabled() && blnExpValue)
						|| (!elemToVerify.isEnabled() && !blnExpValue)) {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is" + strExpStateToReport + "enabled",
							strObjName + " is" + strExpStateToReport
							+ "enabled", Status.DONE);
					return true;
				}
				// else if ((elemToVerify.isEnabled() &&
				// strExpValue.trim().equalsIgnoreCase("N")) ||
				// (!elemToVerify.isEnabled() &&
				// strExpValue.trim().equalsIgnoreCase("Y")) ){
				else {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is" + strExpStateToReport + "enabled",
							strObjName
							+ " property do not match as expected : "
							+ strExpStateToReport + "ENABLED",
							Status.FAIL);
					return false;
				}
			}

			// ****************To verify the element is selected or
			// not***********
			else if (strElemStateToVerify.equalsIgnoreCase("SELECTED")) {
				if ((elemToVerify.isSelected() && blnExpValue)
						|| (!elemToVerify.isSelected() && !blnExpValue)) {
					report.updateTestLog(
							"Verify if the Element(" + strObjName + ") is"
									+ strExpStateToReport + "selected/checked",
									strObjName + " is" + strExpStateToReport
									+ "selected", Status.DONE);
					return true;
				} else {
					report.updateTestLog(
							"Verify if the Element(" + strObjName + ") is"
									+ strExpStateToReport + "selected/checked",
									strObjName
									+ " property do not match as expected : "
									+ strExpStateToReport + "SELECTED",
									Status.FAIL);
					return false;
				}
			}

			// ****************To verify the element has the exact
			// value***********
			else if (strElemStateToVerify.equalsIgnoreCase("VALUE")) {
				if ((elemToVerify.getText().trim()
						.equalsIgnoreCase(strExpValue.trim()) && blnExpValue)
						|| (!elemToVerify.getText().trim()
								.equalsIgnoreCase(strExpValue.trim()) && !blnExpValue)) {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") value is" + strExpStateToReport + "displayed",
							strObjName + " value: '" + strExpValue + "'"
									+ strExpStateToReport
									+ "displayed as expected", Status.PASS);
					return true;
				} else {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") value is" + strExpStateToReport + "displayed",
							"Expected: '" + strExpValue + "' Actual: '"
									+ elemToVerify.getText() + "'", Status.FAIL);
					return false;
				}
			}

			// ****************To verify the element contains the expected
			// value***********
			else if (strElemStateToVerify.equalsIgnoreCase("CONTAINS")) {
				if ((elemToVerify.getText().toUpperCase()
						.contains(strExpValue.trim().toUpperCase()) && blnExpValue)
						|| (!elemToVerify.getText().toUpperCase()
								.contains(strExpValue.trim().toUpperCase()) && !blnExpValue)) {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ")" + strExpStateToReport + "contains value",
							strObjName + " value: '" + strExpValue + "'"
									+ strExpStateToReport
									+ "displayed as expected", Status.PASS);
					return true;
				} else {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ")" + strExpStateToReport + "contains value",
							"Expected: '" + strExpValue + "' Actual: '"
									+ elemToVerify.getText() + "'", Status.FAIL);
					return false;
				}
			}

			// ***************To verify if the selected value of a list/combo
			// box is same**************
			else if (strElemStateToVerify.equalsIgnoreCase("SELECTED VALUE")) {
				Select comSelElement = new Select(elemToVerify);
				if ((comSelElement.getFirstSelectedOption().getText().trim()
						.equalsIgnoreCase(strExpValue.trim()) && blnExpValue)
						|| (!comSelElement.getFirstSelectedOption().getText()
								.trim().equalsIgnoreCase(strExpValue.trim()) && !blnExpValue)) {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") value is " + strExpStateToReport + "selected",
							strObjName + " value: '" + strExpValue + "' is"
									+ strExpStateToReport
									+ "selected from list", Status.PASS);
					return true;
				} else {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is" + strExpStateToReport + "selected",
							strObjName + " value : " + strExpValue + " is"
									+ strExpStateToReport
									+ "SELECTED from list", Status.FAIL);
					return false;
				}
			}
		} else
			return true;
		return false;
	}

	/**
	 ************************************************************* 
	 * Method to verify an element state based on given input conditions and
	 * report
	 * 
	 * @param elemToVerify
	 *            The {@link strObjProperty} element to be verified
	 * @param strElemStateToVerify
	 *            The {@link strElemStateToVerify} describes the state to be
	 *            verified which can be either one of
	 *            ENABLED/SELECTED/TEXT/SELECTED VALUE
	 * @param strExpValue
	 *            The {@link strExpValue} corresponds to each state
	 *            representations of {@link strElemStateToVerify} namely
	 *            Y/N/<the actual text>
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean verifyAndReportElementState(WebElement elemToVerify,String strElemStateToVerify, String strExpValue, String strObjName) {
		String strExpStateToReport = " ";
		String strExpValueToCompare = "", strActValue = "", strActAttribute = "";
		boolean blnExpValue = true;
		if ((!strExpValue.trim().equalsIgnoreCase("IGNORE"))
				&& (!strElemStateToVerify.trim().contains("IGNORE"))) {
			if (strExpValue.trim().equalsIgnoreCase("N")) {
				strExpStateToReport = " not ";
				blnExpValue = false;
			}

			// ****************To verify the element is enabled or
			// not***********
			if (strElemStateToVerify.equalsIgnoreCase("ENABLED")) {
				if ((elemToVerify.isEnabled() && blnExpValue)
						|| (!elemToVerify.isEnabled() && !blnExpValue)) {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is" + strExpStateToReport + "enabled",
							strObjName + " is" + strExpStateToReport
							+ "enabled", Status.PASS);
					return true;
				}
				// else if ((elemToVerify.isEnabled() &&
				// strExpValue.trim().equalsIgnoreCase("N")) ||
				// (!elemToVerify.isEnabled() &&
				// strExpValue.trim().equalsIgnoreCase("Y")) ){
				else {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is" + strExpStateToReport + "enabled",
							strObjName
							+ " property do not match as expected : "
							+ strExpStateToReport + "ENABLED",
							Status.FAIL);
					return false;
				}
			}

			// ****************To verify the element is displayed or
			// not***********
			if (strElemStateToVerify.equalsIgnoreCase("DISPLAYED")) {
				if ((elemToVerify.isDisplayed() && blnExpValue)
						|| (!elemToVerify.isDisplayed() && !blnExpValue)) {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is" + strExpStateToReport + "displayed",
							strObjName + " is" + strExpStateToReport
							+ "displayed", Status.PASS);
					return true;
				}
				// else if ((elemToVerify.isEnabled() &&
				// strExpValue.trim().equalsIgnoreCase("N")) ||
				// (!elemToVerify.isEnabled() &&
				// strExpValue.trim().equalsIgnoreCase("Y")) ){
				else {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is" + strExpStateToReport + "displayed",
							strObjName
							+ " property do not match as expected : "
							+ strExpStateToReport + "displayed",
							Status.FAIL);
					return false;
				}
			}

			// ****************To verify the element is selected or
			// not***********
			else if (strElemStateToVerify.equalsIgnoreCase("SELECTED")) {
				if ((elemToVerify.isSelected() && blnExpValue)
						|| (!elemToVerify.isSelected() && !blnExpValue)) {
					report.updateTestLog(
							"Verify if the Element(" + strObjName + ") is"
									+ strExpStateToReport + "selected/checked",
									strObjName + " is" + strExpStateToReport
									+ "selected", Status.PASS);
					return true;
				} else {
					report.updateTestLog(
							"Verify if the Element(" + strObjName + ") is"
									+ strExpStateToReport + "selected/checked",
									strObjName
									+ " property do not match as expected : "
									+ strExpStateToReport + "SELECTED",
									Status.FAIL);
					return false;
				}
			}

			// ****************To verify the element has the exact
			// value***********
			else if (strElemStateToVerify.substring(0, 6).equalsIgnoreCase(
					"VALUE-")) {
				strExpValueToCompare = strElemStateToVerify.substring(6).trim();
				strActValue = elemToVerify.getText().trim();
				strActValue = RemoveSpecialcharacters(strActValue);
				strExpValueToCompare = RemoveSpecialcharacters(strExpValueToCompare);
				if (elemToVerify.getTagName().trim().equalsIgnoreCase("input")) {
					strActAttribute = elemToVerify.getAttribute("value").trim();
					strActAttribute = RemoveSpecialcharacters(strActAttribute);
				} else {
					strActAttribute = "";
				}
				if ((strActValue.equalsIgnoreCase(strExpValueToCompare) && blnExpValue)
						|| (!strActValue.equalsIgnoreCase(strExpValue.trim()) && !blnExpValue)
						|| (strActAttribute.trim().equalsIgnoreCase(
								strExpValueToCompare.trim()) && blnExpValue)
								|| (!strActAttribute.trim().equalsIgnoreCase(
										strExpValueToCompare.trim()) && !blnExpValue)) {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") value is" + strExpStateToReport + "displayed",
							strObjName + " value: '" + strExpValueToCompare
							+ "'" + strExpStateToReport
							+ "displayed as expected", Status.PASS);
					return true;
				} else {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") value is" + strExpStateToReport + "displayed",
							"Expected: '" + strExpValueToCompare
							+ "' Actual: '" + elemToVerify.getText()
							+ "'", Status.FAIL);
					return false;
				}
			}

			// ****************To verify the element contains the expected
			// value***********
			else if (strElemStateToVerify.substring(0, 9).equalsIgnoreCase(
					"CONTAINS-")) {
				strExpValueToCompare = strElemStateToVerify.substring(9).trim();
				strActValue = elemToVerify.getText().trim();
				if (elemToVerify.getTagName().trim().equalsIgnoreCase("input"))
					strActAttribute = elemToVerify.getAttribute("value").trim();
				else
					strActAttribute = "";
				if ((strActValue.contains(strExpValueToCompare) && blnExpValue)
						|| (!strActValue.contains(strExpValue.trim()) && !blnExpValue)
						|| (strActAttribute.contains(strExpValueToCompare) && blnExpValue)
						|| (!strActAttribute.contains(strExpValueToCompare) && !blnExpValue)) {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ")" + strExpStateToReport + "contains value",
							strObjName + " value: '" + strExpValueToCompare
							+ "'" + strExpStateToReport
							+ "displayed as expected", Status.PASS);
					return true;
				} else {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ")" + strExpStateToReport + "contains value",
							"Expected: '" + strExpValueToCompare
							+ "' Actual: '" + elemToVerify.getText()
							+ "'", Status.FAIL);
					return false;
				}

			}

			// ***************To verify if the selected value of a list/combo
			// box is same**************
			else if (strElemStateToVerify.substring(0, 15).equalsIgnoreCase(
					"SELECTED VALUE-")) {
				Select comSelElement = new Select(elemToVerify);
				strExpValueToCompare = strElemStateToVerify.substring(15)
						.trim();
				strActValue = comSelElement.getFirstSelectedOption().getText()
						.trim();
				if ((strActValue.contains(strExpValueToCompare) && blnExpValue)
						|| (!strActValue.contains(strExpValueToCompare.trim()) && !blnExpValue)) {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") value is " + strExpStateToReport + "selected",
							strObjName + " value: '" + strExpValueToCompare
							+ "' is" + strExpStateToReport
							+ "selected from list", Status.PASS);
					return true;
				} else {
					report.updateTestLog("Verify if the Element(" + strObjName
							+ ") is" + strExpStateToReport + "selected",
							strObjName + " value : " + strExpValueToCompare
							+ " is" + strExpStateToReport
							+ "SELECTED from list", Status.FAIL);
					return false;
				}
			}

			// ***************To verify if the combo box has the list of given
			// values**************
			else if (strElemStateToVerify.substring(0, 15).equalsIgnoreCase(
					"LIST OF VALUES-")) {
				List<String> arExpLst;
				boolean blnResult = false, blnActCompare = true;
				List<WebElement> lstOptions = new Select(elemToVerify)
				.getOptions();
				strExpValueToCompare = strElemStateToVerify.substring(15)
						.trim();

				arExpLst = Arrays.asList(strExpValueToCompare.toLowerCase()
						.split(","));
				List<String> arActLst = new ArrayList<String>();
				for (WebElement elemOption : lstOptions)
					arActLst.add(elemOption.getText().toString().trim()
							.toLowerCase());
				for (int i = 0; i < arExpLst.size(); i++) {
					blnActCompare = arActLst.indexOf(arExpLst.get(i).trim()) != -1;
					if ((blnActCompare && blnExpValue)
							|| !(blnActCompare || blnExpValue))
						blnResult = true;
					else {
						blnResult = false;
						break;
					}

				}
				if (blnResult) {
					report.updateTestLog("Verify if the list : (" + strObjName
							+ ") " + strExpStateToReport + "has values",
							strObjName + " " + strExpStateToReport
							+ " has values : " + strExpValueToCompare
							+ " as expected in the drop down box",
							Status.PASS);
					return true;
				} else {
					report.updateTestLog(
							"Verify if the list : (" + strObjName + ") "
									+ strExpStateToReport + "has values",
									strObjName
									+ " "
									+ strExpStateToReport
									+ " has values : "
									+ strExpValueToCompare
									+ " ; Actual: "
									+ arActLst.toArray(
											new String[arActLst.size()])
											.toString(), Status.FAIL);
					return false;
				}
			}

		} else
			return true;
		return false;
	}


	/**
	 ************************************************************* 
	 * Method to verify an element state based on given input conditions
	 * 
	 * @param elemToVerify
	 *            The {@link strObjProperty} element to be verified
	 * @param strElemStateToVerify
	 *            The {@link strElemStateToVerify} describes the state to be
	 *            verified which can be either one of
	 *            ENABLED/SELECTED/TEXT/SELECTED VALUE
	 * @param strExpValue
	 *            The {@link strExpValue} corresponds to each state
	 *            representations of {@link strElemStateToVerify} namely
	 *            Y/N/<the actual text>
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean verifyElementState(WebElement elemToVerify,
			String strElemStateToVerify, String strExpValue) throws IOException {

		if (!strExpValue.trim().equalsIgnoreCase("IGNORE")) {
			if (strElemStateToVerify.equalsIgnoreCase("ENABLED")) {
				if (!elemToVerify.isEnabled())
					return false;
			} else if (strElemStateToVerify.equalsIgnoreCase("SELECTED")) {
				if (!elemToVerify.isSelected())
					return false;
			} else if (strElemStateToVerify.equalsIgnoreCase("TEXT")) {
				if (!elemToVerify.getText().trim()
						.equalsIgnoreCase(strExpValue.trim()))
					return false;
			} else if (strElemStateToVerify.equalsIgnoreCase("SELECTED VALUE")) {
				Select comSelElement = new Select(elemToVerify);
				if (!comSelElement.getFirstSelectedOption().getText().trim()
						.equalsIgnoreCase(strExpValue.trim()))
					return false;
			}
		}
		return true;
	}

	public WebElement isElementPresentContainsText(String strObjectProperty,
			String strFindElementType, String StrObjName, String textToVerify)
					throws IOException {
		try {
			if (isElementPresentVerification(strObjectProperty,
					strFindElementType, StrObjName)) {
				getElementByProperty(strObjectProperty, strFindElementType)
				.getText().contains(textToVerify);
				report.updateTestLog("The Element(" + StrObjName
						+ ") is present and Contains the text", textToVerify,
						Status.PASS);
				return null;
			} else {
				report.updateTestLog("The Element(" + StrObjName
						+ ") is not present and does not contain the text",
						textToVerify, Status.FAIL);
				return null;
			}
		} catch (Exception e) {
			report.updateTestLog("IS ELEMENT PRESENTCONTAINS TEXT",
					"Error in method - Error Description - " + e.toString(),
					Status.FAIL);
			return null;
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify text present in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */

	public boolean verifyElementPresentContainsText(WebElement element,
			String StrObjName, String textToVerify) throws IOException {
		if (!textToVerify.trim().equalsIgnoreCase("IGNORE")) {
			try {
				textToVerify = textToVerify.replace(" ", "");
				String pageSource = element.getText().toLowerCase();
				String[] pageSourceLines = pageSource.trim().split("\\n");
				String pageSourceWithoutNewlines = "";
				textToVerify = textToVerify.toLowerCase().replaceAll(" ", "");

				for (String pageSourceLine : pageSourceLines) {
					pageSourceWithoutNewlines += pageSourceLine + " ";
				}

				pageSourceWithoutNewlines = pageSourceWithoutNewlines.trim()
						.replaceAll(" ", "").replaceAll("\\$", "");
				Pattern p = Pattern.compile(textToVerify);
				Matcher m = p.matcher(pageSourceWithoutNewlines);

				if (m.find()) {
					report.updateTestLog(StrObjName, "'" + StrObjName
							+ "' value : " + textToVerify
							+ " Verification is Success", Status.PASS);
					return true;
				} else {
					report.updateTestLog(StrObjName, StrObjName
							+ "Verification is Failure. Expected : "
							+ textToVerify + " Actual : "
							+ pageSourceWithoutNewlines, Status.FAIL);
				}

			} catch (Exception e) {
				report.updateTestLog(
						("Error in method description").toUpperCase(),
						e.toString(), Status.FAIL);
			}
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to get element attribute
	 * 
	 * @param Element
	 *            The {@link String} object that contains the page element
	 *            identification variable in OR.
	 * @param ElementName
	 *            The {@link String} Attribute name of the element which is to
	 *            be fetched
	 * @return
	 ************************************************************* 
	 */
	public String getElementAttribute(String strObjectProperty,
			String strFindElementType, String attributeToGet, String strObjName) {
		String attributVal = null;
		try {
			if (isElementPresentVerification(strObjectProperty,
					strFindElementType, strObjName))
				attributVal = getElementByProperty(strObjectProperty,
						strFindElementType).getAttribute(attributeToGet);
		} catch (Exception e) {
			report.updateTestLog("", "Error in method - Error Description - "
					+ e.toString(), Status.FAIL);
		}
		return attributVal;
	}

	/**
	 ************************************************************* 
	 * Function to verify if an Text is present in the application.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification variable in OR.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean isTextPresent(String text) throws IOException {

		String x = text;
		try {
			if (x != null) {
				report.updateTestLog("Verification of ", x + "Is Present",
						Status.PASS);

				return true;
			} else {
				return false;

			}
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Error in identifying element with property "
					+ text, nsee.toString(), Status.FAIL);
			return false;
		} catch (Exception e) {
			report.updateTestLog("IS ELEMENT PRESENT VERIFICATION",
					"Error in method - Error Description - " + e.toString(),
					Status.FAIL);
			return false;
		}
	}

	/**
	 ************************************************************* 
	 * @Purpose - Method to verify a text on the application
	 * @Input - text to be verified
	 * @throws IOException
	 ************************************************************* 
	 */
	// Added the section to verify multiple texts
	public boolean verifyText(String strTextToVerify) {
		strTextToVerify = strTextToVerify.replace(" ", "\\s*").trim();
		String pageSource = driver.getPageSource();
		String[] pageSourceLines = pageSource.trim().split("\\n"), arrTextsToVerify = null;
		String pageSourceWithoutNewlines = "";
		int Iterator = 0, flag = 0;
		for (String pageSourceLine : pageSourceLines) {
			pageSourceWithoutNewlines += pageSourceLine + " ";
		}
		pageSourceWithoutNewlines = pageSourceWithoutNewlines.trim();

		try {
			if (strTextToVerify.contains("~")) {
				arrTextsToVerify = strTextToVerify.split("~");
				for (Iterator = 0; Iterator < arrTextsToVerify.length; Iterator++) {
					Pattern p = Pattern.compile(arrTextsToVerify[Iterator]);
					Matcher m = p.matcher(pageSourceWithoutNewlines);
					if (m.find()) { // INCLUDED THIS TO HAVE CLEAR REPORTS, TO
						// VERIFY THOSE TEXT's THAT ARE PRESENT AND
						// THOSE THAT ARE'NT
						// Report.updateStatus("Verify If Text is present in the Application",
						// arrTextsToVerify[Iterator].replace("\\s*",
						// " ")+" is present in the Application as expected.",
						// "PASS");
						flag++;
					} else {
						// Report.updateStatus("Verify If Text is present in the Application",
						// arrTextsToVerify[Iterator].replace("\\s*",
						// " ")+" is not present in the Application.", "FAIL");
					}
				}

				// RETURNS TRUE ONLY IF ALL THE TEXTS ARE PRESENT
				if (flag == arrTextsToVerify.length) {
					return true;
				} else {
					return false;
				}
			} else {
				Pattern p = Pattern.compile(strTextToVerify);
				Matcher m = p.matcher(pageSourceWithoutNewlines);
				if (m.find()) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			// Report.updateStatus("Unable to Verify Text",
			// "Error in method - Error Description - " + e.toString(), "FAIL");
			return false;
		}
	}

	/**
	 ************************************************************* 
	 * Method to verify multiple lines in a web-element text
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * @param textToVerify
	 *            The {@text String} text value to be verified
	 * @param strObjName
	 *            The name of object for reference
	 * @return
	 ************************************************************* 
	 */
	public boolean verifyMultiLine(WebElement element, String StrObjName,
			String textToVerify) throws IOException {
		boolean blnFound = true;
		if (!textToVerify.trim().equalsIgnoreCase("IGNORE")) {
			try {
				String[] arrLinesToVerify = textToVerify.trim().split("\\n");
				String[] arrPageSrcLines = element.getText().trim()
						.split("\\n");
				for (int itPageSrc = 0; itPageSrc < arrPageSrcLines.length; itPageSrc++)
					if (arrPageSrcLines[itPageSrc].trim().equalsIgnoreCase(
							arrLinesToVerify[0].trim())) {
						for (int itLines = 0; itLines < arrLinesToVerify.length; itLines++)
							if (!arrPageSrcLines[itPageSrc + itLines].trim()
									.equalsIgnoreCase(
											arrLinesToVerify[itLines].trim())) {
								blnFound = false;
								break;
							}
					} else if (!blnFound && itPageSrc == arrPageSrcLines.length) {
						report.updateTestLog(
								"verifyMultiLineText".toUpperCase(), StrObjName
								+ " do not have expected text : "
								+ textToVerify + " ; Actual : "
								+ element.getText(), Status.FAIL);
						return false;
					} else if (blnFound) {
						report.updateTestLog(
								"verifyMultiLineText".toUpperCase(), StrObjName
								+ " has the text : " + textToVerify
								+ " as expected.", Status.PASS);
						return true;
					}
			} catch (Exception e) {
				report.updateTestLog("verifyMultiLineText".toUpperCase(),
						"Error in verifying elements :  " + e.getMessage(),
						Status.FAIL);
			}
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify if an element is present in the application, not using
	 * OR.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean isElementPresentVerification(String strObjectProperty,
			String strFindElementType, String strObjName) throws IOException {

		try {
			if (getElementByProperty(strObjectProperty, strFindElementType) != null) {
				report.updateTestLog(
						(strObjName + " element is present").toUpperCase(),
						strObjName + " is verified successfully", Status.PASS);
				return true;
			} else {
				return false;
			}
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Error in identifying element with string "
					+ strObjectProperty, nsee.toString(), Status.FAIL);
			return false;
		} catch (Exception e) {
			report.updateTestLog(
					"IS ELEMENT PRESENT VERIFICATION",
					"Error in identifying object (" + strObjName + ") -"
							+ e.toString(), Status.FAIL);
			return false;
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify if an element is present in the application, not using
	 * OR.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean isElementPresentVerification(WebElement elemToVerify,
			String strObjName) {

		try {
			if (elemToVerify.isDisplayed()) {
				report.updateTestLog(
						(strObjName + " element is present").toUpperCase(),
						strObjName + " is verified successfully", Status.PASS);
				return true;
			} else {
				return false;
			}
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Error in identifying element (" + strObjName
					+ ")", nsee.toString(), Status.FAIL);
			return false;
		} catch (Exception e) {
			report.updateTestLog(
					"IS ELEMENT PRESENT VERIFICATION",
					"Error in identifying object (" + strObjName + ") -"
							+ e.toString(), Status.FAIL);
			return false;
		}
	}

	/**
	 ************************************************************* 
	 * Function to clear existing text in a field and enter required data.
	 * 
	 * @param ElementName
	 *            The {@link String} object that contains the page element
	 *            identification variable in OR.
	 * @param Text
	 *            The {@link String} object that contains the string to be
	 *            entered in the text field.
	 * @return void
	 ************************************************************* 
	 */
	public void clearAndEnterText(String strObjectProperty,
			String strFindElementType, String Text) throws IOException {
		try {
			getElementByProperty(strObjectProperty, strFindElementType).clear();
			getElementByProperty(strObjectProperty, strFindElementType)
			.sendKeys(Text);
		} catch (Exception e) {
			report.updateTestLog(("Unable to enter data").toUpperCase(),
					e.toString(), Status.FAIL);
		}
	}

	/**
	 ************************************************************* 
	 * Function to read properties file
	 * 
	 * @param propertiesFileName
	 *            The {@link String} object that contains the OR name.
	 * @param propertyName
	 *            The {@link String} object that contains the property name to
	 *            read.
	 * @return The {@link String} object that contains the property value.
	 ************************************************************* 
	 */
	public String readPropertiesFile(String propertiesFileName,
			String propertyName) {

		Locale locale = new Locale("en", "US");
		ResourceBundle bundle = ResourceBundle.getBundle(propertiesFileName,
				locale);
		String propertyValue = bundle.getString(propertyName);
		return propertyValue;

	}

	/**
	 ************************************************************* 
	 * Function to write into properties file
	 * 
	 * @param propertiesFileName
	 *            The {@link String} object that contains the OR name.
	 * @param propertyName
	 *            The {@link String} object that contains the property name to
	 *            write.
	 * @param newValue
	 *            The {@link String} object that contains the new property value
	 *            to be written.
	 * @return void
	 ************************************************************* 
	 */
	public void writePropertiesFile(String propertiesFileName,
			String propertyName, String newValue) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(System.getProperty("user.dir")
					+ "\\" + propertiesFileName + ".properties"));
			properties.setProperty(propertyName, newValue);
			properties.store(
					new FileOutputStream(System.getProperty("user.dir") + "\\"
							+ propertiesFileName + ".properties"), "");
		} catch (IOException e) {
			System.out.println("File read Error - " + e);
		}

	}

	/**
	 ************************************************************* 
	 * Function to select a particular Value from any List box.
	 * 
	 * @param ListBoxObject
	 *            The {@link WebElement} object that has reference to the List
	 *            Box.
	 * @param strSelectOption
	 *            The {@link String} object that has the item to be selected.
	 * @return void
	 ************************************************************* 
	 */
	public void genericListBoxOptionSelector(WebElement ListBoxObject,
			String strSelectOption) throws Exception {
		try {
			new Select(ListBoxObject).selectByVisibleText(strSelectOption);
			report.updateTestLog("GENERIC LIST BOX SELECTOR", "The option "
					+ strSelectOption + " is selected.", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("GENERIC LIST BOX SELECTOR",
					"Error in method - Error Description - " + e.toString(),
					Status.FAIL);
		}
	}

	public void mouseOver(WebElement element) {
		String code = "var fireOnThis = arguments[0];"
				+ "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'mouseover', true, true );"
				+ "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, element);
	}

	public void mouseOver1(WebElement element) {
		String code = "if(document.createEvent) {"
				+ "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent('mouseover', true, false); "
				+ "arguments[0].dispatchEvent(evObj);"
				+ "arguments[0].click();" + "} "
				+ "else if(document.createEventObject) "
				+ "{ arguments[0].fireEvent('onmouseover'); }";
		((JavascriptExecutor) driver).executeScript(code, element);
	}

	public void mouseOverWebElement(WebElement element) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(element).build().perform();
		} catch (Exception e) {
			report.updateTestLog(
					("Mouse Over Event doesnt occur").toUpperCase(),
					e.toString(), Status.FAIL);
		}
	}

	public void pageLoad(String x) {
		selenium.waitForPageToLoad(x);
	}

	public boolean waitForElementVisibility(String xpathVal, long time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(xpathVal)));
			report.updateTestLog("Wait For Element - element found",
					"Waited for " + time
					+ " seconds to find element with xpath : "
					+ xpathVal, Status.DONE);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean waitForElementVisibilityByLinkText(String strlinkText,
			long time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			WebElement element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By
							.partialLinkText(strlinkText)));
			report.updateTestLog("Wait For Element - element found",
					"Waited for " + time
					+ " seconds to find element with xpath : "
					+ strlinkText, Status.DONE);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForElementClickable(String xpathVal, long time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			WebElement element = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(xpathVal)));
		} catch (NoSuchElementException e) {
			System.err.print(e.getMessage());
		}
	}

	public void waitForElementClickable(String strElementValue,
			String strElementType, long time) {
		try {
			if (strElementType.equalsIgnoreCase("XPATH")) {
				WebDriverWait wait = new WebDriverWait(driver, time);
				WebElement element = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(strElementValue)));
				element.click();
			} else if (strElementType.equalsIgnoreCase("ID")) {
				WebDriverWait wait = new WebDriverWait(driver, time);
				WebElement element = wait.until(ExpectedConditions
						.elementToBeClickable(By.id(strElementValue)));
				element.click();
			} else if (strElementType.equalsIgnoreCase("NAME")) {
				WebDriverWait wait = new WebDriverWait(driver, time);
				WebElement element = wait.until(ExpectedConditions
						.elementToBeClickable(By.name(strElementValue)));
				element.click();
			} else if (strElementType.equalsIgnoreCase("LINKTEXT")) {
				WebDriverWait wait = new WebDriverWait(driver, time);
				WebElement element = wait.until(ExpectedConditions
						.elementToBeClickable(By.linkText(strElementValue)));
				element.click();
				report.updateTestLog("(" + strElementValue
						+ ") button is Clicked", strElementValue
						+ " button is  present", Status.PASS);
			} else if (strElementType.equalsIgnoreCase("CSS")) {
				WebDriverWait wait = new WebDriverWait(driver, time);
				WebElement element = wait.until(ExpectedConditions
						.elementToBeClickable(By.cssSelector(strElementValue)));
				element.click();
			}
		} catch (NoSuchElementException e) {
			System.err.print(e.getMessage());
		}
	}

	public void mouseOverIE(WebElement element) {

		String code = " function sleep(milliseconds) {"
				+ " var start = new Date().getTime();"
				+ " while ((new Date().getTime() - start) < milliseconds){"
				+
				// Do nothing
				"} }" + "if(document.createEvent) {"
				+ "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent('mouseover', true, false); "
				+ "sleep(50000);" + "arguments[0].dispatchEvent(evObj);"
				+ "arguments[0].click();" + "} "
				+ "else if(document.createEventObject) "
				+ "{ arguments[0].fireEvent('onmouseover'); }";
		((JavascriptExecutor) driver).executeScript(code, element);

	}

	public void driverGet() {
		driver.navigate().to(
				readPropertiesFile("Global Settings", "ApplicationUrl"));
	}

	public void openTab(String url) {
		WebElement a = (WebElement) ((JavascriptExecutor) driver)
				.executeScript(
						"var d=document,a=d.createElement('a');a.target='_blank';a.href=arguments[0];a.innerHTML='.';d.body.appendChild(a);return a",
						url);
		a.click();
	}

	/**
	 * Switches to the non-current window
	 */
	public void switchWindow() throws NoSuchWindowException {
		Set<String> handles = driver.getWindowHandles();
		String current = driver.getWindowHandle();
		handles.remove(current);
		String newTab = handles.iterator().next();
		driver.switchTo().window(newTab);
	}

	public void click(WebElement element) {
		// String code = "arguments[0].click();"
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				element);
	}

	/**
	 * This is identical to the selenium.isAlertPresent() method for
	 * WebDriverBackedSelenium, in that it checks to see if an alert message is
	 * present, except this one works. It uses WebDriver methods to check to see
	 * if a JavaScript alert() message is on the screen.
	 * 
	 * @return This will return true is an alert message is on the screen.
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert().accept();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	} // isAlertPresent()

	public String generateNewUserName() {
		String strTimeStamp = getCurrentTimeStamp();
		return "TestUser" + strTimeStamp;
	}

	public String getCurrentTimeStamp() {
		String strTimestamp;
		Date currentDate = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMdd_mm_ss");
		strTimestamp = dateFormatter.format(currentDate);
		return strTimestamp;
	}

	/**
	 * Method to Verify Element is Not Present For Negative Scenario
	 * 
	 * @param elemToVerify
	 * @param strObjName
	 */

	public void verifyIsElementNotPresent(String strObjectProperty,
			String strFindElementType, String strObjName) {
		WebElement elemToFind;
		try {

			if (strFindElementType.equalsIgnoreCase("CSS"))
				elemToFind = driver.findElement(By
						.cssSelector(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("XPATH"))
				elemToFind = driver.findElement(By.xpath(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("ID"))
				elemToFind = driver.findElement(By.id(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("NAME"))
				elemToFind = driver.findElement(By.name(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("LINKTEXT"))
				elemToFind = driver.findElement(By.linkText(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("TAG"))
				elemToFind = driver.findElement(By.tagName(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("CLASS"))
				elemToFind = driver
				.findElement(By.className(strObjectProperty));
			else
				elemToFind = null;
			if (driver.findElement(By.linkText(strObjectProperty))
					.isDisplayed())
				report.updateTestLog("identifying element (" + strObjName,
						")  Is Present", Status.FAIL);

		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("identifying element (" + strObjName,
					")  Is Not Present", Status.PASS);
		}

	}

	/**
	 * Function name: verifyElementAttribute Description: To verify an attribute
	 * of an object Parameters: strPropertyValue - Object property value,
	 * strPropertyBy - Property type strAttributeName - attribute type,
	 * strAttributeValue - expected attribute value Developed by: VaibhavS
	 * */
	public void verifyElementAttribute(String strPropertyValue,
			String strPropertyBy, String strObjName, String strAttributeName,
			String strAttributeValue) {
		String strActualValue = getElementAttribute(strPropertyValue,
				strPropertyBy, strAttributeName, strObjName);
		if (strActualValue.equalsIgnoreCase(strAttributeValue))
			report.updateTestLog("Attribute Verify", strAttributeName
					+ " attribute for " + strObjName + " verified as "
					+ strAttributeValue, Status.PASS);
		else
			report.updateTestLog("Attribute Verify", strAttributeName
					+ " attribute for " + strObjName + " is not verified.",
					Status.FAIL);
	}

	/**
	 ************************************************************* 
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param webElement
	 *            WebElement for which child elements to be found
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {@link WebElement} object.
	 ************************************************************* 
	 */
	public List<WebElement> getElementsByProperty(WebElement webElement,
			String strObjectProperty, String strFindElementType) {
		try {
			// GlobalVariables.strImplicitWait="1";
			if (strFindElementType.equalsIgnoreCase("CSS"))
				return webElement.findElements(By
						.cssSelector(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("XPATH"))
				return webElement.findElements(By.xpath(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("ID"))
				return webElement.findElements(By.id(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("NAME"))
				return webElement.findElements(By.name(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("LINKTEXT"))
				return webElement.findElements(By.linkText(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("TAG"))
				return webElement.findElements(By.tagName(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("CLASS"))
				return webElement.findElements(By.className(strObjectProperty));
			else
				return null;
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Verify if the expected search text = "
					+ strObjectProperty + " is present", nsee.toString(),
					Status.FAIL);
			return null;
		}

		catch (Exception e) {
			report.updateTestLog(
					"GET ELEMENT BY PROPERTY , PROPERTY NOT FROM OR",
					"Error in finding element - " + strObjectProperty + ", by "
							+ "" + "" + ": " + strFindElementType
							+ ". Error Description - " + e.toString(),
							Status.FAIL);
			return null;
		}
	}

	/**
	 ************************************************************* 
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {@link WebElement} object.
	 ************************************************************* 
	 */
	public List<WebElement> getElementsByProperty(String strObjectProperty,
			String strFindElementType) {
		try {
			// GlobalVariables.strImplicitWait="1";
			if (strFindElementType.equalsIgnoreCase("CSS"))
				return driver.findElements(By.cssSelector(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("XPATH"))
				return driver.findElements(By.xpath(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("ID"))
				return driver.findElements(By.id(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("NAME"))
				return driver.findElements(By.name(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("LINKTEXT"))
				return driver.findElements(By.linkText(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("TAG"))
				return driver.findElements(By.tagName(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("CLASS"))
				return driver.findElements(By.className(strObjectProperty));
			else
				return null;
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Verify if the expected search text = "
					+ strObjectProperty + " is present", nsee.toString(),
					Status.FAIL);
			return null;
		}

		catch (Exception e) {
			report.updateTestLog(
					"GET ELEMENT BY PROPERTY , PROPERTY NOT FROM OR",
					"Error in finding element - " + strObjectProperty + ", by "
							+ "" + "" + ": " + strFindElementType
							+ ". Error Description - " + e.toString(),
							Status.FAIL);
			return null;
		}
	}

	/**
	 * Description: Function to validate items in a list
	 * 
	 * @param strPropertyValue
	 *            = object property value
	 * @param strPropType
	 *            = type of property to be used
	 * @param strObjName
	 *            = object label for reporting
	 * @param strItemNames
	 *            = items to be verified seperated by semi-colin(;) returns:
	 *            nothing Author: VaibhavS
	 */
	public void verifyItemsInList(String strPropertyValue, String strPropType,
			String strObjName, String strItemNames) {
		boolean blnFlag;
		try {
			if (isElementPresentVerification(strPropertyValue, strPropType,
					strObjName)) {
				WebElement elemToClick = getElementByProperty(strPropertyValue,
						strPropType);
				// clickAnyElement(elemToClick,strObjName);
				String[] arrListNames = strItemNames.split(";");
				List<WebElement> lstElement = getElementsByProperty(
						elemToClick, "*", "XPATH");
				for (String strItemName : arrListNames) {
					blnFlag = false;
					for (WebElement webElement : lstElement) {
						String strText = webElement.getText();
						if (strText.equalsIgnoreCase(strItemName)) {
							report.updateTestLog("Verify Item " + strItemName
									+ " is present", strItemName
									+ " is present", Status.PASS);
							blnFlag = true;
							break;
						}
					}
					if (blnFlag = false)
						report.updateTestLog("Verify Item " + strItemName
								+ " is present", strItemName
								+ " is not present", Status.FAIL);
				}

			} else
				report.updateTestLog("Verify if the Element(" + strObjName
						+ ") is present", strObjName + " is not present",
						Status.FAIL);
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("VerifyItemsInList: " + strObjName, strObjName
					+ " object does not exist in page", Status.FAIL);
		} catch (Exception e) {
			report.updateTestLog("VerifyItemsInList",
					"Error in method - Error Description - " + e.toString(),
					Status.FAIL);
		}
	}

	/**
	 * Method To Get The Window Size
	 * 
	 * @author Manoj Venkat
	 * @param Null
	 * @return strSize {@link dimSize} Size Of The Window
	 */
	public Dimension getWindowSize() {
		Dimension dimSize = driver.manage().window().getSize();
		return dimSize;
	}

	/**
	 * Method To Get the window handle result
	 * 
	 * @author Lavannya
	 * @param List
	 * @return boolean
	 */
	public boolean switchToDifferentWindow(WebDriver driver,
			String strWindowTitle) {
		WebDriver popup = null;
		Boolean blnPopupFound = false;
		String parentWindowHandle = driver.getWindowHandle();
		@SuppressWarnings("rawtypes")
		java.util.Iterator obj = (java.util.Iterator) driver.getWindowHandles()
		.iterator();
		// Window handle iterator object initiated
		while (obj.hasNext()) {
			String windowHandle = (String) obj.next();
			popup = driver.switchTo().window(windowHandle);
			if (popup.getTitle().contains(strWindowTitle)) {
				popup.get(popup.getCurrentUrl());
				blnPopupFound = true;
				return true;
			}
		}
		if (blnPopupFound)
			return true;
		else
			return false;
	}

	/**
	 * @description Function to update the TC status
	 * @author SanVa002
	 * @param strTCName
	 *            - Name of the test case
	 * @modified_date Mar 28, 2013
	 */
	public void updateTCStatus(String strTCName) {
		if (report.nCounter == 0) {
			report.addTestCaseStatus(strTCName + " - Passed", Status.PASS);
		} else {
			report.addTestCaseStatus(strTCName + " - Failed", Status.FAIL);
			report.nCounter = 0;
		}
	}

	/**
	 * function to remove special characters in a string
	 * 
	 * @param strring
	 *            to remove the characteres
	 * @return string
	 */
	public String RemoveSpecialcharacters(String str) {
		String st = "";
		for (int i = 0; i < str.length(); i++) {
			int ch = str.charAt(i);

			if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {

				st = st + (char) ch;
			}

		}

		return st;
	}



	/**
	 ************************************************************* 
	 * Function to verify if element present
	 * @return Nothing is returned as of now 
	 * @Author Yagna Priya
	 * @param strObjectProperty, strElementType
	 * @version 1.0
	 ************************************************************* 
	 */
	public boolean verifyElementPresent(String strObjectProperty, String strElementType){
		List <WebElement> wbObject;
		try {
			if (strElementType.equalsIgnoreCase("CSS"))
				wbObject = driver.findElements(By.cssSelector(strObjectProperty));
			else if (strElementType.equalsIgnoreCase("XPATH"))
				wbObject = driver.findElements(By.xpath(strObjectProperty));
			else if (strElementType.equalsIgnoreCase("ID"))
				wbObject = driver.findElements(By.id(strObjectProperty));
			else if (strElementType.equalsIgnoreCase("NAME"))
				wbObject = driver.findElements(By.name(strObjectProperty));
			else if (strElementType.equalsIgnoreCase("LINKTEXT"))
				wbObject = driver.findElements(By.linkText(strObjectProperty));
			else if (strElementType.equalsIgnoreCase("TAG"))
				wbObject = driver.findElements(By.tagName(strObjectProperty));
			else if (strElementType.equalsIgnoreCase("CLASS"))
				wbObject = driver.findElements(By.className(strObjectProperty));
			else
				wbObject = null;
			
			if (!wbObject.isEmpty()){
				return true;
			}else{
				return false;
			}		
			
		}catch(Exception e){
//			'report '
		}	
		return false;
	}
	
	/**

     ************************************************************* 

     * Function to verify if element present

     * @return Nothing is returned as of now 

     * @Author Yagna Priya

     * @param strWindowTitle

     * @version 1.0

     ************************************************************* 

     */

    public void switchNewWindow() throws NoSuchWindowException {

            String mainWindow = driver.getWindowHandle();

            Set<String> handles = driver.getWindowHandles();

            for (String handler:handles){

                    if (!handler.equals(mainWindow)){

                            driver.switchTo().window(handler);

                            break;

                    }

                    

            }

//          String strCurrentTitle = driver.getTitle();

//          System.out.println("current window" +strCurrentTitle);

//          if (strWindowTitle.trim().equalsIgnoreCase(strCurrentTitle.trim())){

//                  driver.switchTo().window(strCurrentTitle);

//                  System.out.println("switch to window");

//          }

    }
}
