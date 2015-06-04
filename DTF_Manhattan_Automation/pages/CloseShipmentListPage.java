package pages;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

import java.util.List;

import org.openqa.selenium.WebElement;

public class CloseShipmentListPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public CloseShipmentListPage(ScriptHelper scriptHelper) {
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
	protected void initializeUIMap()
	{
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("CloseShipmentListPage"))
			report.updateTestLog("Close Shipments Page verification", "Close Shipments loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Close Shipments Page verification", "Close Shipments page loaded not loaded!!!!", Status.FAIL);
	}

	private enum enumPageObjects
	{
		btnSave;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Apply, OrderID
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case btnSave:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Save']", "XPATH");
				break;
			default:
				break;
			}
			report.updateTestLog("WavePage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("WavePage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 *********************************************************************** 
	 * Function clicks on save button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void SaveclosedShipment()
	{
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save");
	}

}
