package pages;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class CheckinPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public CheckinPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("CheckinPage"))
			report.updateTestLog("Checkin Page verification", "Checkin loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Checkin verification", "Checkin loaded not loaded!!!!", Status.FAIL);
	}

	public enum enumPageObjects
	{
		checkinbtn,createbtn, checkinWPAbtn, AppointmentID, Apply;
	}
	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: checkinbtn,createbtn
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {
			case checkinbtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Check-In']", "XPATH");
				break;
			case checkinWPAbtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Check-In without prior Appointment']", "XPATH");
				break;
			case AppointmentID:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Appointment']", "XPATH");
				break;
			case Apply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@name='dataForm:listView:filterId:filterIdapply']", "XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}

	/**
	 *********************************************************************** 
	 * Function searches the appointment and clicks on apply button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strAppointmentID
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchAppointmentID(String strAppointmentID){
		try{		

			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("AppointmentID"), strAppointmentID, "AppointmentID");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");		
		}catch(Exception e){

		}
	}

	/**
	 *********************************************************************** 
	 * Function clicks on check in button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickCheckinButton() throws InterruptedException{

		libManhattanCommonFunctions.clickAnyElement(getPageElement("checkinbtn"), "Checkin Button");			
	}

	/**
	 *********************************************************************** 
	 * Function selects the given appointment Number.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strAppointmentNum
	 * @version 1.0
	 ***********************************************************************
	 */
	public void selectAppointment(String strAppointmentNum){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		List<WebElement> list = driver.findElements(By.xpath(".//*[@class='advtbl_col advtbl_body_col'][1]//span[1]"));
		int strRowNumToBeChecked = 0;
		for(WebElement ele:list){
			if(ele.getText().contains(strAppointmentNum)){
				break;
			}else{
				strRowNumToBeChecked = strRowNumToBeChecked + 1;
			}

		}
		libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c"+strRowNumToBeChecked+"_dataForm:listView:dataTable']", "XPATH", "CheckBox");
	}

	/**
	 *********************************************************************** 
	 * Function verifies the appointment table headers.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyAppointmentTableHeaders(){
		try {
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Appointment']", "XPATH", "Appointment");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Appointment Status']", "XPATH", "Appointment Status");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Trailer']", "XPATH", "Trailer");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Shipment']", "XPATH", "Shipment");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Purchase Order']", "XPATH", "Purchase Order");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='ASN']", "XPATH", "ASN");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Appointment Date/Time']", "XPATH", "Appointment Date/Time");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Carrier Code']", "XPATH", "Carrier Code");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='BOL']", "XPATH", "BOL");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Facility']", "XPATH", "Facility");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Tractor']", "XPATH", "Tractor");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Driver']", "XPATH", "Driver Slot");

		} catch (IOException e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function clicks on check-in without prior appointment button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickCheckinWithoutPriorAppointmentButton(){

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clickAnyElement(getPageElement("checkinWPAbtn"), "Checkin Without Prior Appointment Button");			

	}

}