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

public class TaskEligibiltyGpPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public TaskEligibiltyGpPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("TaskEligibiltyGpPage"))
			report.updateTestLog("Task Eligibilty Group Page verification", "Task Eligibilty Group Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Task Eligibilty Group Page verification", "Task Eligibilty Group Page not loaded!!!!", Status.FAIL);
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
			report.updateTestLog("TaskEligibiltyGpPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("TaskEligibiltyGpPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}	
	
	/**
	 *********************************************************************** 
	 * Function selects Task Group Type and clicks on aplly button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strTaskGp
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchTaskGroup(String strTaskGp){                                
		try{    
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
			Thread.sleep(2000);
			libManhattanCommonFunctions.selectAnyElement("//select[@id='dataForm:listView:filterId:field1value1']", "XPATH",strTaskGp,"Select Task Group");
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");

		}catch(Exception e){
			report.updateTestLog("Pix Transaction", "Element Not Found", Status.FAIL);


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
	public void validateTaskGpDetails(String strTaskGp, String strInventoryType,String strTaskType, String strWorkGp,String strWorkArea, String strTaskUsed) {
		try {
			String actualTaskGp = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:task']","XPATH").getText();
			String actualInventoryType = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:invnNeedTypeVal']","XPATH").getText();
			String actualTaskType = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:taskTypeVal']","XPATH").getText();
			String actualWorkGp = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:wrkgrp']","XPATH").getText();
			String actualWorkArea = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:wrkare']","XPATH").getText();
			String actualTaskUsed = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:tused']","XPATH").getText();
			if (actualTaskGp.trim().equals(strTaskGp)&& actualInventoryType.trim().equals(strInventoryType)&& actualTaskType.trim().equals(strTaskType)&& actualWorkGp.trim().equals(strWorkGp)&& actualWorkArea.trim().equals(strWorkArea)&& actualTaskUsed.trim().equals(strTaskUsed)) {
				report.updateTestLog("Task group Details verification","Task group Details verified successfully", Status.PASS);
			} else {
				report.updateTestLog("Task group Details verification","Expected Task Grp : "+strTaskGp+" || Actual Task Grp : "+actualTaskGp+" || Expected Inventory Type : "+strInventoryType+" || Actual Inventory Type : "+actualInventoryType+" || Expected Task Type : "+strTaskType+" || Actual Task Type : "+actualTaskType+"  || Expected Work Gp : "+strWorkGp+" || Actual Work Gp : "+actualWorkGp+"  || Expected Work Area : "+strWorkArea+" || Actual Work Area : "+actualWorkArea+"  || Expected Task Used : "+strTaskUsed+" || Actual Task Used : "+actualTaskUsed, Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}
	}
	
	
	}
	
