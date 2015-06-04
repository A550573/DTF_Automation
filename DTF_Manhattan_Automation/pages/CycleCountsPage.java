package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class CycleCountsPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public CycleCountsPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("CycleCountsPage"))
			report.updateTestLog("Cycle Count Page verification", "Cycle Count loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Cycle Count Page verification", "Cycle Count page loaded not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		Apply, FromDate, ToDate;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Apply
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case Apply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply' and @title='Apply'])[1]", "XPATH");
				break;
			case FromDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='as_bas1_in']", "XPATH");
				break;
			case ToDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='as_bas2_in']", "XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("YardSlotsPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("YardSlotsPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 ************************************************************* 
	 * Function selects from date and to date and click apply button 
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strFromDate, strToDate
	 * @version 1.0
	 * @throws Exception 
	 ************************************************************* 
	 */
	public void searchCycleCount(String strFromDate, String strToDate) throws Exception{
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		//			Select FromDate = new Select(driver.findElement(By.id("as_bas1_in")));
		//			FromDate.selectByVisibleText(strFromDate);
		//			Select ToDate = new Select(driver.findElement(By.id("as_bas2_in")));
		//			ToDate.selectByVisibleText(strToDate);
		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("FromDate"), strFromDate, "From Date");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ToDate"), strToDate, "To Date");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");			
	}

	/**
	 ************************************************************* 
	 * Function is to verify the cycle count table headers
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	none
	 * @version 1.0
	 ************************************************************* 
	 */
	public void verifyCycleCountsTableHeaders(){
		try {
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Count Date']", "XPATH", "Count Date Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Description']", "XPATH", "Description Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Location']", "XPATH", "Location Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Status']", "XPATH", "Status Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Last Updated User']", "XPATH", "Last Updated User Header");
		} catch (IOException e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 **************************************************************** 
	 * Function is to verify the cycle count details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strCountDate, strDescription, strLocation, strStatus,
	 * 			strLastUpdatedUser
	 * @version 1.0
	 **************************************************************** 
	 */
	public void validateCycleCountDetails(String strCountDate,String strDescription, String strLocation, String strStatus, String strLastUpdatedUser){
		try{
			String actualCountDate = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][1]", "XPATH").getText();
			String actualDescription = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][2]", "XPATH").getText();
			String actualLocation = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][3]", "XPATH").getText();
			String actualStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][4]", "XPATH").getText();
			String actualLastUpdatedUser = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][5]", "XPATH").getText();
			if(actualCountDate.trim().equals(strCountDate) && actualDescription.trim().equals(strDescription) && actualLocation.trim().equals(strLocation) && actualStatus.trim().equals(strStatus) && actualLastUpdatedUser.trim().equals(strLastUpdatedUser))
			{
				report.updateTestLog("Cycle Count verification", "Count Date : "+actualCountDate+" || Description : "+actualDescription+" || Location : "+actualLocation+" || Status : "+actualStatus+" || Last Updated User : "+actualLastUpdatedUser, Status.PASS);
			}else
			{
				report.updateTestLog("Cycle Count verification", "Actual Count Date : "+actualCountDate+" || Expected Count Date : "+strCountDate+" || Actual Description : "+actualDescription+" || Expected Description : "+strDescription+" || Actual Location : "+actualLocation+" || Expected Location : "+strLocation+" || Actual Status : "+actualStatus+" || Expected Status : "+strStatus+" || Actulal Last Updated User : "+actualLastUpdatedUser+" || Expected Last updated User : "+strLastUpdatedUser, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 *************************************************************** 
	 * Function validates cycle count details for multiple records
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strCountDate, strDescription, strLocation, strStatus
	 * 			strLastUpdatedUser
	 * @version 1.0
	 ***************************************************************
	 */
	public void loopValidateCycleCount(String strCountDate,String strDescription, String strLocation, String strStatus, String strLastUpdatedUser){
		try{
			if (strCountDate.contains(";")){
				int intLoop = 0;
				for (String strElement : strCountDate.split(";")){						
					String[] strDescriptionValue = strDescription.split(";");
					String[] strLocationValue = strLocation.split(";");
					String[] strStatusValue = strStatus.split(";");
					String[] strLastUpdatedUserValue = strLastUpdatedUser.split(";");
					validateCycleCountDetails(strElement,strDescriptionValue[intLoop],strLocationValue[intLoop],strStatusValue[intLoop],strLastUpdatedUserValue[intLoop]);
					Thread.sleep(10000);
					intLoop = intLoop+1;
					driver.switchTo().defaultContent();
				}
			}

		}catch(Exception e){

		}
	}

	/**
	 *************************************************************** 
	 * Function validates the status of the latest record
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strStatus
	 * @version 1.0
	 ***************************************************************
	 */
	public void ValidateStatus(String strStatus)
	{
		try {
			String stractualStatus = driver.findElement(By.id("dataForm:listView:dataTable:0:statCode")).getText();
			if (strStatus.equals(stractualStatus.trim())){
				report.updateTestLog("Cycle Count Verification","Status is verified as "+stractualStatus,Status.PASS);
			}
			else
			{
				report.updateTestLog("Cycle Count Verification","Expected Status : "+strStatus+" || Actual Status : "+stractualStatus,Status.FAIL);
			}				
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Verification", "Element Not Found",Status.FAIL);
		}
	}
}
