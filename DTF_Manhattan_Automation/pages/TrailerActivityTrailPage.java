package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class TrailerActivityTrailPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public TrailerActivityTrailPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("TrailerActivityTrailPage"))
			report.updateTestLog("Trailer Activity Trail Page verification", "Trailer Activity Trail Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Trailer Activity Trail Page verification", "Trailer Activity Trail page loaded not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		Apply, Trailer;
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

			case Trailer:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Trailer']", "XPATH");
				break;
			case Apply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:filterId:filterIdapply']", "XPATH");
				break;


			default:
				break;
			}
			report.updateTestLog("TrailerActivityTrailPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("TrailerActivityTrailPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 *********************************************************************** 
	 * Function enters trailer name in search box and clicks apply button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strTrailer
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void searchTrailer(String strTrailer){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Trailer"), strTrailer, "Trailer");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");			
		libManhattanCommonFunctions.waitForElementClickable(".//*[@id='dataForm:listView:dataTable:0:carr']", 5000);
	}

	/**
	 *********************************************************************** 
	 * Function validates trailer table headers
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	None
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void verifyTrailerTableHeaders(){
		try {
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Trailer']", "XPATH", "Trailer Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Carrier']", "XPATH", "Carrier Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Appointment']", "XPATH", "Appointment Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Appointment Type']", "XPATH", "Appointment type Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Trailer Status']", "XPATH", "Trailer Status Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Task Type']", "XPATH", "Task type Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Activity Type']", "XPATH", "Activity type Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Date/Time']", "XPATH", "Date/Time Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Yard Slot']", "XPATH", "Yard Slot Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Dock Door']", "XPATH", "Dock Door Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Driver']", "XPATH", "Driver Slot Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Activity Source']", "XPATH", "Activity Source Header");
		} catch (IOException e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
     *********************************************************************** 
     * Function validates trailer details
     * @return 	Nothing is returned as of now 
     * @Author 	Yagna Priya
     * @param 	strCarrier,strTaskType,strDockDoor,strYardSlot,strTrailerStatus
     * @version 1.0
     * @throws 	InterruptedException 
      ***********************************************************************
     */
     public void validateTrailerActivityDetails(String strCarrier, String strTaskType, String strDockDoor, String strYardSlot, String strTrailerStatus){
         try{
	             String actualCarrier = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:carr']", "XPATH").getText();
	             String actualTaskType = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:tskType']", "XPATH").getText();
	             String actualDockDoor = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:ddoor']", "XPATH").getText();
	             String actualYardSlot = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:ySlot']", "XPATH").getText();
	             String actualTrailerStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:status']", "XPATH").getText();
	             if(actualCarrier.trim().equals(strCarrier) && actualTaskType.trim().equals(strTaskType) && actualDockDoor.trim().equals(strDockDoor) && actualYardSlot.trim().equals(strYardSlot))
                     report.updateTestLog("Trailer Details Validation", "Carrier : "+actualCarrier+" || Task type : "+actualTaskType+" || Dock door :"+actualDockDoor+ " || Yard slot : "+actualYardSlot+" || Trailer Status :"+actualTrailerStatus, Status.PASS);
	             else
                     report.updateTestLog("Trailer Details Validation", "Expected Carrier : "+strCarrier+"  || Actual Carrier : "+actualCarrier+"  || Expected Task Type : "+strTaskType+"  || Actual task Type : "+actualTaskType+"  || Expected Dock Door : "+strDockDoor+"  || Actual Dock Door : "+actualDockDoor+" || Expected Yard Slot :"+strYardSlot+" || Actual Yard Slot :"+actualYardSlot+" || Expected Trailer Status : "+strTrailerStatus+" || Actual Trailer Status : "+actualTrailerStatus, Status.FAIL);
         }catch(Exception e){
                     report.updateTestLog("Element", "Element Not Found", Status.FAIL);
         } 
     }


}
