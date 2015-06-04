package pages;
import java.util.List;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class ActivityTrackingPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public ActivityTrackingPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try{

		}catch(Exception e){
			report.updateTestLog("ActivityTrackingPage-OBJECT IDENTIFICATION", "Error in finding Page Object/element : " + e.getMessage(), Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function to verify the current page.
	 * @return 	Nothing is returned as of now 
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	protected void initializeUIMap()
	{
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("ActivityTrackingPage"))
			report.updateTestLog("ActivityTrackingPage verification", "ActivityTrackingPage loaded as expected.", Status.DONE);
		else
			report.updateTestLog("ActivityTrackingPage verification", "ActivityTrackingPage loaded as expected.", Status.DONE);
	}

	private enum enumPageObjects{
		btnview;
	}
	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: btnview
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case btnview:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='View']", "XPATH");
				break;
			default:
				break;

			}
			report.updateTestLog("iLPNPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main iLPNPage", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("iLPNPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}

	/**
	 *********************************************************************** 
	 * Function selects the iLPN and clicks on the view button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void selectmodifiediLPN(){

		try{
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
			libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:lv1:dataTable']", "XPATH", "CheckBox");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnview"), "View Button");
			Thread.sleep(8000);
		}catch(Exception e){
			report.updateTestLog("ActivityTracking Page", "Element Not Found", Status.FAIL);
		} 	
	}

	/**
	 *********************************************************************** 
	 * Function validated the reason code.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strReasonCode
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateReasonCode(String strReasonCode){

		try{
			String actualReasonCode=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:rsn']", "XPATH").getText();
			if(actualReasonCode.trim().equals(strReasonCode))
			{
				report.updateTestLog("Reason Code verification", "Actual Reason Code: "+actualReasonCode+"is verified", Status.PASS);
			}else
			{
				report.updateTestLog("Reason Code verification", "Expected Reason Code: "+strReasonCode+"Actual Reason Code: "+actualReasonCode, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}  
	}

}
