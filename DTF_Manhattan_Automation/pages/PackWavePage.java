package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class PackWavePage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public PackWavePage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("PackWavePage"))
			report.updateTestLog("Pack Waves Page verification", "Pack Waves loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Pack Waves Page verification", "Pack Waves page loaded not loaded!!!!", Status.FAIL);
	}

	private enum enumPageObjects
	{
		btnRelease;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Apply, WaveNumber, AllCheckBox, BtnView, StatisticsTab, TasksTab, BtnTaskDetails, oLPNsTab, BtnLPNDetails
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case btnRelease:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Release']", "XPATH");
				break;
				


			default:
				break;
			}
			report.updateTestLog("PackWavePage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("PackWavePage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}
	
	/**
	 *********************************************************************** 
	 * Function releases a locked/disabled task.
	 * @return    Nothing is returned as of now 
	 * @Author    Nitika
	 * @param     None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void ReleaseTask() throws InterruptedException{
		Thread.sleep(1000);
		libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:lv1:dataTable']", "XPATH", "CheckBox");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnRelease"), "Release Button");
		Thread.sleep(1000);
	}


	

}
