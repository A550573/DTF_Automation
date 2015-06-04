package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class CloseTrailerPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public CloseTrailerPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("CloseTrailerPage"))
			report.updateTestLog("CloseTrailers Page verification", "CloseTrailers Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("CloseTrailers Page verification", "CloseTrailers page loaded not loaded!!!!", Status.FAIL);
	}

	private enum enumPageObjects
	{
		btnSave, Ship_Seal;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Apply, Trailer
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
			case Ship_Seal:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:sealNumOut']", "XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("CloseTrailerPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("CloseTrailerPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 *********************************************************************** 
	 * Function enters the seal number and clicks on save button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void  SaveClosedTrailer()
	{
		String strShip_Seal = "4568152941";
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Ship_Seal"), strShip_Seal, "Shipment Seal");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save Button");
	}
	
}
