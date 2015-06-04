package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class TaskPathDefnPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public TaskPathDefnPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("TaskPathDefnPage"))
			report.updateTestLog("Task Path Definition Page verification", "Task Path Definition Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Task Path Definition Page verification", "Task Path Definition Page not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		btnApply;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: AppointmentNumber, Apply
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case btnApply: elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@title='Apply'])[1]", "XPATH");
				break;
			
			default:
				break;
			}
			report.updateTestLog("TaskPathDefnPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("TaskPathDefnPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}	
	
	/**
	 *********************************************************************** 
	 * Function selects Task Group Type and clicks on aplly button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strInventoryType
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchInventoryType(String strInventoryType){                                
		try{    
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
			Thread.sleep(2000);
			libManhattanCommonFunctions.selectAnyElement("//select[@id='dataForm:listView:filterId:field0value1']", "XPATH",strInventoryType,"Select Inventory Type");
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");

		}catch(Exception e){
			report.updateTestLog("Inventory Type", "Element Not Found", Status.FAIL);


		}              
	}
	
	/**
	 *************************************************************************** 
	 * Function validates Task Group details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strLPN,strType,strLPNFacilityStatus,strBusinessUnit,strFacility
	 * 			strLPNQuantity,strPallet,strItem,strASN,strShipment,strLocks
	 * 			strDistributionOrder
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validatePathDefnDetails(String strInventoryType,String strTaskGp, String strCurrentWorkGp,String strCurrentWorkArea,String strDestinationWorkGp,String strDestinationWorkArea,String strNextWorkGp,String strNextWorkArea, String strPriority, String strStatus) {
		try {
			String actualInventoryType = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:task']","XPATH").getText();
			String actualTaskGp = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:taskGrpVal']","XPATH").getText();
			String actualCurrentWorkGp = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:cwrkgrp']","XPATH").getText();
			String actualCurrentWorkArea = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:cwrkare']","XPATH").getText();
			String actualDestinationWorkGp = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:dwrkgrp']","XPATH").getText();
			String actualDestinationWorkArea = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:dwrkare']","XPATH").getText();
			String actualNextWorkGp = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:nwrkgrp']","XPATH").getText();
			String actualNextWorkArea = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:nwrkare']","XPATH").getText();
			String actualPriority = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:prty4']","XPATH").getText();
			String actualStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:stat4']","XPATH").getText();
			if (actualNextWorkArea.trim().equals(strNextWorkArea)&& actualDestinationWorkArea.trim().equals(strDestinationWorkArea)&& actualDestinationWorkGp.trim().equals(strDestinationWorkGp)&& actualCurrentWorkArea.trim().equals(strCurrentWorkArea)&& actualTaskGp.trim().equals(strTaskGp)&& actualInventoryType.trim().equals(strInventoryType)&& actualCurrentWorkGp.trim().equals(strCurrentWorkGp)&& actualStatus.trim().equals(strStatus)&& actualNextWorkGp.trim().equals(strNextWorkGp)&& actualPriority.trim().equals(strPriority)) {
				report.updateTestLog("Task Path Defn Details verification","Task Path Defn Details verified successfully", Status.PASS);
			} else {
				report.updateTestLog("Task Path Defn Details verification","Expected Task Grp : "+strTaskGp+" || Actual Task Grp : "+actualTaskGp+" || Expected Inventory Type : "+strInventoryType+" || Actual Inventory Type : "+actualInventoryType+" || Expected Current Work Gp : "+strCurrentWorkGp+" || Actual Current Work Gp : "+actualCurrentWorkGp+"  || Expected Next Work Gp : "+strNextWorkGp+" || Actual Next Work Gp : "+actualNextWorkGp+"  || Expected Priority : "+strPriority+" || Actual Priority : "+actualPriority+"  || Expected Status : "+strStatus+" || Actual Status : "+actualStatus, Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}
	}
	
	
	}
	
