package pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.cognizant.framework.Status;
import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class CheckoutPage extends AnyManhattanPage{

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public CheckoutPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("CheckoutPage"))
			report.updateTestLog("Checkout Page verification", "Checkout Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Checkout Page verification", "Checkout Page page loaded not loaded!!!!", Status.FAIL);
	}

	private enum enumPageObjects
	{
		Apply, AppointmentID, BtnView, BtnCancel,checkoutbtn;
	}
	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param          strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 *                                            Values: Apply, AppointmentID, BtnView, BtnCancel,checkoutbtn
	 * @return          The WebElement object if it exists. Else returns null
	 */

	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {
			case AppointmentID:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Appointment']", "XPATH");
				break;
			case Apply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listView:filterId:filterIdapply']", "XPATH");
				break;
			case BtnView:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='View Checkin Details']", "XPATH");
				break;
			case checkoutbtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Check-Out']", "XPATH");
				break;
			case BtnCancel:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@alt='Cancel']", "XPATH");
			default:
				break;
			}
			report.updateTestLog("CheckinPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("CheckinPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}
	
	/**
	 *********************************************************************** 
	 * Function searches the appointment and clicks on apply button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strAppointmentID
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchAppointmentID(String strAppointmentID){
		try{                         
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clearAndEnterText(".//*[@alt='Find Appointment']", "XPATH", strAppointmentID);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("AppointmentID"), strAppointmentID, "AppointmentID");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");                                                
		}catch(Exception e){
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function clicks on checkout button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickCheckoutButton(){
		libManhattanCommonFunctions.clickAnyElement(getPageElement("checkoutbtn"), "Checkout Button");                                             
	}

	/**
	 *********************************************************************** 
	 * Function selects the appointment that is displayed.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strAppointmentID
	 * @version 1.0
	 ***********************************************************************
	 */

	public void selectAppointmentID(String strAppointmentID){
		try{                         
			libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:listView:dataTable']", "XPATH", "CheckBox");
		}catch(Exception e){
		}
	}
	/**
	 *********************************************************************** 
	 * Function validates the check out table header.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyCheckOutTableHeaders(){
		try {
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Appointment']", "XPATH", "Trailer Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Appointment Status']", "XPATH", "Carrier Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Appointment Type']", "XPATH", "Appointment type Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Trailer']", "XPATH", "Trailer Status Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Shipment']", "XPATH", "Task type Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Purchase Order']", "XPATH", "Activity type Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='ASN']", "XPATH", "Date/Time Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Appointment Date/Time']", "XPATH", "Yard Slot Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Carrier Code']", "XPATH", "Dock Door Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='BOL']", "XPATH", "Driver Slot Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Facility']", "XPATH", "Activity Source Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Tractor']", "XPATH", "Yard Slot Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Driver']", "XPATH", "Dock Door Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='DriverStatus']", "XPATH", "Driver Slot Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Check-Out Driver']", "XPATH", "Activity Source Header");
		} catch (IOException e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

}
