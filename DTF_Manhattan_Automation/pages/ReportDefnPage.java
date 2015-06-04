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

public class ReportDefnPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public ReportDefnPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("ReportDefnPage"))
			report.updateTestLog("Report Definition Page verification", "Report Definition Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Report Definition Page verification", "Report Definition Page not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		btnApply, btnRunNow;
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
			case btnRunNow: elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Run Now']", "XPATH");
			break;
			default:
				break;
			}
			report.updateTestLog("Report Definition Page- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("Report Definition Page- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}	
	
	
	/**
	 *********************************************************************** 
	 * Function selects the category and subcategory for Report Definitions.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strCategory,strSubCategory
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchPIXTransaction(String strCategory, String strSubCategory){                                
		try{    
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
			Thread.sleep(2000);
			libManhattanCommonFunctions.selectAnyElement("//select[@id='dataForm:listView:filterId:field0value1']", "XPATH",strCategory,"Select Category");
			//libManhattanCommonFunctions.waitForElementVisibility("//select[@id='dataForm:lview:filterId:field1value1']", 2000);
			Thread.sleep(4000);
			libManhattanCommonFunctions.selectAnyElement("//select[@id='dataForm:listView:filterId:field1value1']", "XPATH",strSubCategory,"Select SubCategory");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");

		}catch(Exception e){
			report.updateTestLog("Pix Transaction", "Element Not Found", Status.FAIL);
		}              
	}

	
	
	/**
	 *********************************************************************** 
	 * Function selects the report to be run.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strReportName
	 * @version 1.0
	 ***********************************************************************
	 */
	public void SelectReport(String strReportName){                                
		int intRowPointer=0;  
		libManhattanCommonFunctions.waitForElementVisibility(".//*[@id='checkAll_c0_dataForm:listView:dataTable']", 6000);
		try{  
			WebElement wbLPNTable1 = driver.findElement(By.xpath("//div[@id='dataForm:listView:dataTable_bodyDiv']"));
			List<WebElement> wbTRList = wbLPNTable1.findElements(By.tagName("TR"));
			int intPointr = 0;
			for(WebElement el: wbTRList){
				String strRowValue = el.getText();
				if(strRowValue.contains(strReportName)){
					intRowPointer = intPointr;
					break;
				}
				intPointr = intPointr+1;
			}
			libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+intPointr+"_dataForm:listView:dataTable']", "XPATH", "CheckBox");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnRunNow"), "Run Now Button");
			Thread.sleep(2000);
		}
		catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}
	
	}
	
