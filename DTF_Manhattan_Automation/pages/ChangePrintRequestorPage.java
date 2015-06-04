package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class ChangePrintRequestorPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public ChangePrintRequestorPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	/**
	 *********************************************************************** 
	 * Function to verify the current page.
	 * @return 	Nothing is returned as of now 
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	@Override
	protected void initializeUIMap() {
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("ChangePrintRequestorPage"))
			report.updateTestLog("Change Print Requestor Page verification","Change Print Requestor loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Change Print Requestor Page verification","Change Print Requestor loaded not loaded!!!!", Status.FAIL);
	}

	public enum enumPageObjects {
		PrintRequestor, Btn_Save, 

	}
	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: btnHeader, btnLocks
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName) {
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case PrintRequestor:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:smfacilityId']", "XPATH");
				break;
			case Btn_Save:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Save']", "XPATH");   
				break;	

			default:
				break;
			}
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", ""+ strElemName + "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", ""+ strElemName + "is not found", Status.FAIL);
		}
		return elemToFind;
	}

	/**
	 *********************************************************************** 
	 * Function selects Print Requestor
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strPrintRequestor
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void selectPrintRequestor(String strPrintRequestor){
		try {	
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("PrintRequestor"), strPrintRequestor);
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_Save"), "Save Button");
			Thread.sleep(4000);
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}		
	}	
}
