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

public class EventsPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public EventsPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("EventsPage"))
			report.updateTestLog("Events Page verification", "Events Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Events Page verification", "Events Page not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		btnApply, lnkExpand, FromDate, ToDate;
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

			case btnApply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply'])[2]", "XPATH");
				break;
			case lnkExpand:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@title='Expand']", "XPATH");
				break;
			case FromDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='as_bas1_in']", "XPATH");
				break;
			case ToDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='as_bas2_in']", "XPATH");
				break;
				
			default:
				break;
			}
			report.updateTestLog("EventsPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("EventsPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}	


	/**
	 *********************************************************************** 
	 * Function selects UserId and Activity Name.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strUserId,StrActivity,strDate
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchevents(String strUserId, String StrActivity, String strDate){                                
		try{    
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("lnkExpand"), "Expand Button");
			Thread.sleep(2000);
			libManhattanCommonFunctions.selectAnyElement("//select[@id='dataForm:listView:filterId1:field0value1']", "XPATH",strUserId,"Select User Id");
			Thread.sleep(4000);
			libManhattanCommonFunctions.selectAnyElement("//select[@id='dataForm:listView:filterId1:field10value1']", "XPATH",StrActivity,"Select Activity Name");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("FromDate"), strDate, "Select From Date");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ToDate"), strDate, "Select To Date");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");

		}catch(Exception e){
			report.updateTestLog("Pix Transaction", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 *********************************************************************** 
	 * Function retrieves the transaction number for Blind receiving.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strRefNum
	 * @version 1.0   
	 ***********************************************************************
	 */
	public String getTransNum(String strRefNum){                                
		int intRowPointer=0;  
		String strTransNum = null;
		libManhattanCommonFunctions.waitForElementVisibility(".//*[@id='checkAll_c0_dataForm:listView:dataTable']", 4000); 
		try{  
			WebElement wbLPNTable1 = driver.findElement(By.xpath("//div[@class='lTableoScrollDiv']"));
			List<WebElement> wbTRList = wbLPNTable1.findElements(By.tagName("TR"));
			int intPointr = 0;
			//			for(WebElement el: wbTRList){
			//				String strRowValue = el.getText();
			//				if(strRowValue.contains(strRefNum)){
			//					intRowPointer = intPointr;
			//					break;
			//				}
			//				intPointr = intPointr+1;
			//			}
			libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+intPointr+"_dataForm:listView:dataTable']", "XPATH", "CheckBox");
			strTransNum = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:"+intRowPointer+":tranNbr']", "XPATH").getText();	 
			//			String stractualRefNum = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:"+intRowPointer+":adjTime5']", "XPATH").getText();			
			//			if(stractualRefNum.trim().equals(strRefNum))
			//
			//			{
			//				report.updateTestLog("Events verification", "Reference Number : "+strRefNum, Status.PASS);
			//			}else
			//			{
			//				report.updateTestLog("Events verification", "Expected Reference Number : "+strRefNum+" Actual Reference Number : "+stractualRefNum, Status.FAIL);
			//			}
		}
		catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}  
		return strTransNum;
	}
	
}