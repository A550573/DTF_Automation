package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class RunReportPage extends AnyManhattanPage{
	
	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public RunReportPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try{
			}catch(Exception e){
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
		if (getCurrentPage("RunReportPage"))
			report.updateTestLog("Run Report Page verification", "Run Report Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Run Report Page verification", "Run Report Page loaded not loaded!!!!", Status.FAIL);
	}
	
	public enum enumPageObjects
	{
		FromTransNum, ToTransNum, EmpList, btnAdd, btnAddAll, btnRun;
	}
	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Facility,Carrier, Trailer, btnSave ,CurrLoc, TrailerCondition, Equipment, AppointmentType
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {
		case FromTransNum: elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:REPORT_FROM_TO_ITEM1_From_Val']", "XPATH");
			break;
		case ToTransNum: elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:REPORT_FROM_TO_ITEM1_To_Val']", "XPATH");
		break;
		case EmpList: elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='REPORT_DUAL_LIST_ITEM2_SourceListId']", "XPATH");
		break;
		case btnAdd: elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Add >'])[1]", "XPATH");
		break;
		case btnAddAll: elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Add All >>'])[2]", "XPATH");
		break;
		case btnRun: elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Run']", "XPATH");
		break;
			
		default:
			break;
			}
			report.updateTestLog("RunReportPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("RunReportPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}
	
	
	/**
	 *********************************************************************** 
	 * Function enters report details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strFacility,strApptType,strAsnId
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void enterRunReportDetails(String strFormat, String strTransNumber, String strEmployee) throws InterruptedException{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		driver.findElement(By.xpath("//label[contains(text(),'Excel')]")).click();
		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("FromTransNum"), strTransNumber, "From Transaction Number");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ToTransNum"), strTransNumber, "To Transaction Number");
		Thread.sleep(2000);
		libManhattanCommonFunctions.selectAnyElement(getPageElement("EmpList"), strEmployee, "Employee Used");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAdd"), "Add button");	
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAddAll"), "Add all button");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnRun"), "Run button");
		}
	
	
}
