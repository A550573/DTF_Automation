package pages;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;
import com.google.common.collect.Iterables;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class YardTaskPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public YardTaskPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
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
		if (getCurrentPage("YardTaskPage"))
			report.updateTestLog("Yard Task Page verification", "Yards Task loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Yard Task Page verification", "Yards Task page not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		Facility, Carrier, Trailer, AssignedUser, DestinationLocation, TaskType, Priority, Save, YardTask, Apply, SearchDestinationBtn, Find, SelectDestination, SelectBtn, CreatedDate, FindCarrier, Expand;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Facility, Carrier, Trailer, AssignedUser, DestinationLocation, TaskType, Priority, Save, YardTask, Apply, SearchDestinationBtn, Find, SelectDestination, SelectBtn, CreatedDate
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case YardTask:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:filterId:field10value1']", "XPATH");
				break;
			case Apply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:filterId:filterIdapply']", "XPATH");
				break;
			case SearchDestinationBtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:dstLkp']", "XPATH");
				break;
			case Find:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ymLocn_locgetlist1']", "XPATH");
				break;
			case SelectDestination:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ymslocnText1']//option", "XPATH");
				break;
			case SelectBtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ymLocn_SelectButton1']", "XPATH");
				break;
			case CreatedDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable']//span[text()='Created Date/Time']", "XPATH");
				break;
			case FindCarrier:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Carrier']", "XPATH");
				break;
			case Expand:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@title='Expand']", "XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("YardTaskPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("YardTaskPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 *********************************************************************** 
	 * Function enters yard task ID in search box and clicks apply button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strYardTask
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchYardTask(String strYardTask){
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("YardTask"), strYardTask, "Yard Task");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");					
	}

	/**
	 *********************************************************************** 
	 * Function validates yard task table headers
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyYardTaskTableHeaders(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		try {
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Task Type']", "XPATH", "Yard Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Task Priority']", "XPATH", "Yard Zone Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Task Status']", "XPATH", "Yard Zone Slot Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Trailer']", "XPATH", "Status Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Carrier Code']", "XPATH", "Yard Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Assigned User']", "XPATH", "Yard Zone Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Release Date/Time']", "XPATH", "Yard Zone Slot Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Created Date/Time']", "XPATH", "Status Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Task Origin']", "XPATH", "Yard Zone Slot Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Task Destination']", "XPATH", "Status Header");
		} catch (IOException e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function validates task details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strTaskStatus, strPriority, strAssignedUser
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateTaskDetails(String strTaskStatus, String strPriority, String strAssignedUser){
		try{
			String actualTaskStatus=libManhattanCommonFunctions.getElementAttribute(".//*[@id='dataForm:listView:dataTable:0:dis5']", "XPATH", "TEXT", "Task Status");
			String actualPriority=libManhattanCommonFunctions.getElementAttribute(".//*[@id='dataForm:listView:dataTable:0:dis3']", "XPATH", "TEXT", "Priority");
			String actualAssignedUser=libManhattanCommonFunctions.getElementAttribute(".//*[@id='dataForm:listView:dataTable:0:dis8']", "XPATH", "TEXT", "Assigned User");
			if(actualTaskStatus.trim().equals(strTaskStatus) && actualPriority.trim().equals(strPriority) && actualAssignedUser.trim().equals(strAssignedUser))
			{
				report.updateTestLog("Task Details verification", "Task Details verified successfully", Status.PASS);
			}else
			{
				report.updateTestLog("Task Details verification", "Task Details verification failed ", Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 	
	}


	/**
	 *********************************************************************** 
	 * Function validates the task status
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strTaskStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateTaskStatus(String strTaskStatus){
		try{
			libManhattanCommonFunctions.waitForElementClickable(".//*[@id='dataForm:listView:dataTable:0:dis5']", 3000);			
			String actualTaskStatus = driver.findElement(By.xpath(".//*[@id='dataForm:listView:dataTable:0:dis5']")).getText();

			if(actualTaskStatus.trim().equals(strTaskStatus))
			{
				report.updateTestLog("Task Status verification", "Status : "+strTaskStatus+" is verified", Status.PASS);
			}else
			{
				report.updateTestLog("Task Status verification", "Expected status : "+strTaskStatus+" || Actual status : "+actualTaskStatus, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function selects the yard task and verifies yard task details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strTaskType, strPriority, strPriority, strStatus, strTrailer
	 * 			strCarrier, strAssignedUser, strDestination
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void clickCheckBoxAndVerifyYardTaskDeatils(String strTaskType, String strPriority, String strStatus, String strTrailer, String strCarrier, String strAssignedUser, String strDestination) throws InterruptedException{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");
		Thread.sleep(8000);
		//libManhattanCommonFunctions.waitForElementClickable(".//*[@class='advtbl_col advtbl_body_col'][12]//span[1]", 6000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("CreatedDate"), "CreatedDate");
		Thread.sleep(8000);
		libManhattanCommonFunctions.waitForElementClickable(".//*[@class='sortImgDiv -icons_srtup']", 6000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("CreatedDate"), "CreatedDate");
		Thread.sleep(8000);
		libManhattanCommonFunctions.waitForElementClickable(".//*[@class='sortImgDiv -icons_sdown']", 6000);
		int strRowNumToBeChecked = 0;
		List<WebElement> lstRowItems = driver.findElements(By.xpath(".//*[@class='advtbl_row -dg_tr' or @class='advtbl_row -dg_tar']"));
		for (WebElement ele:lstRowItems){
			String strTaskTrailer = ele.findElement(By.xpath(".//*[@class='advtbl_col advtbl_body_col'][6]//span[1]")).getText();
			String strTaskDestination = ele.findElement(By.xpath(".//*[@class='advtbl_col advtbl_body_col'][12]//span[1]")).getText();
			if ((strTrailer.trim().equals(strTaskTrailer)) && (strDestination.trim().equals(strTaskDestination))){
				break;
			}else{
				strRowNumToBeChecked = strRowNumToBeChecked + 1;
				continue;
			}
		}

		libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+strRowNumToBeChecked+"_dataForm:listView:dataTable']", "XPATH", "CheckBox");
		Thread.sleep(5000);
		String actualTaskType = driver.findElement(By.xpath(".//*[@id='dataForm:listView:dataTable:"+strRowNumToBeChecked+":custId52']")).getText();
		String actualPriority = driver.findElement(By.xpath(".//*[@id='dataForm:listView:dataTable:"+strRowNumToBeChecked+":dis3']")).getText();
		String actualStatus = driver.findElement(By.xpath(".//*[@id='dataForm:listView:dataTable:"+strRowNumToBeChecked+":dis5']")).getText();
		String actualTrailer = driver.findElement(By.xpath(".//*[@id='dataForm:listView:dataTable:"+strRowNumToBeChecked+":dis6']")).getText();
		String actualCarrier = driver.findElement(By.xpath(".//*[@id='dataForm:listView:dataTable:"+strRowNumToBeChecked+":dis7']")).getText();
		String actualAssignedUser = driver.findElement(By.xpath(".//*[@id='dataForm:listView:dataTable:"+strRowNumToBeChecked+":dis8']")).getText();
		String actualDestination = driver.findElement(By.xpath(".//*[@id='dataForm:listView:dataTable:"+strRowNumToBeChecked+":dis83']")).getText();
		try{

			if(actualTaskType.trim().equals(strTaskType) && actualPriority.trim().equals(strPriority) && actualStatus.trim().equals(strStatus) && actualTrailer.trim().equals(strTrailer) && actualCarrier.trim().equals(strCarrier) && actualAssignedUser.trim().equals(strAssignedUser) && actualDestination.trim().equals(strDestination))
			{
				report.updateTestLog("Yard task verification", "Task type : "+actualTaskType+ " || Priority : "+actualPriority+" || Status : "+actualStatus+" || Trailer : "+actualTrailer+" || Carrier : "+actualCarrier+" || Assigned User : "+actualAssignedUser+" || Destination : "+actualDestination+" is verified", Status.PASS);
			}else
			{
				report.updateTestLog("Yard task verification", " Expected task type : "+strTaskType+" || Actual task type : "+actualTaskType+" || Expected Priority : "+strPriority+" || Actual priority : "+actualPriority+" || Expected status : "+strStatus+" || Actual status : "+actualStatus+" || Expected trailer : "+strTrailer+" || Actual trailer : "+actualTrailer+" || Expected carrier : "+strCarrier+" || Actual carrier : "+actualCarrier+" || Expected assigned user : "+strAssignedUser+" || Actual assigned user : "+actualAssignedUser+" || Expected destination : "+strDestination+" || Actual destination : "+actualDestination, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}

	}
	
	/**
	 *********************************************************************** 
	 * Function enters yard task ID in search box and clicks apply button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strYardTask
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void searchYardTaskbyCarrier(String strCarrier) throws InterruptedException{
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Expand"), "Expand");	
		Thread.sleep(4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("FindCarrier"), strCarrier, "Find Carrier");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");	
		Thread.sleep(4000);
	}

}
