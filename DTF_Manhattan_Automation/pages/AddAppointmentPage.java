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

public class AddAppointmentPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public AddAppointmentPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("AddAppointmentPage"))
			report.updateTestLog("Add Appointment Page verification", "Add Appointment loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Add Appointment Page verification", "Add Appointment page not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		Facility, AsnId, lnkDockDetails, DockAssgnd, DoorAssgnd, BtnSaveWidBestFit, EquipmentCode, Carrier;
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

			case Facility:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@alt='Find facility'])[1]", "XPATH");
				break;
			case AsnId:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find ASN']", "XPATH");
				break;
			case lnkDockDetails:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='tab3_lnk']", "XPATH");
				break;
			case DockAssgnd:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:dockNameText1']", "XPATH");
				break;
			case DoorAssgnd:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:dockDoorNameText1']", "XPATH");
				break;
			case BtnSaveWidBestFit:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Save with Best Fit']", "XPATH");
				break;
			case EquipmentCode:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:equipment_det']", "XPATH");
				break;
			case Carrier: 
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:carrierId_det0']", "XPATH");
				break;
			default:
				break;
			}
			report.updateTestLog("AppointmentPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("AppointmentPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}	

	/**
	 *********************************************************************** 
	 * Function selects the current date from the calendar.
	 * @return 	Nothing is returned as of now 
	 * @Author  Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void selectDate()
	{
		DateFormat dateFormat2 = new SimpleDateFormat("dd"); 
		Date date2 = new Date();

		String strToday = dateFormat2.format(date2); 
		int temptoday = Integer.parseInt(strToday); 
		String today =  String.valueOf(temptoday).toString();

		//find the calendar
		WebElement dateWidget = driver.findElement(By.xpath("//div[@class='calendar']"));  
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  

		//comparing the text of cell with today's date and clicking it.
		for (WebElement cell : columns) {
			if (cell.getText().equals(today)) {
				cell.click();
				break;
			}
		}

	} 


	/**
	 *********************************************************************** 
	 * Function enters appointment details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strFacility,strApptType,strAsnId,strEquipmentCode,strCarrier
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void enterAppointmentDetails(String strFacility, String strApptType, String strAsnId, String strEquipmentCode, String strCarrier ) throws InterruptedException{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Facility"), strFacility, "Facility");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("AsnId"), strAsnId, "ASNId");
		Thread.sleep(6000);
		libManhattanCommonFunctions.clickAnyElement("//input[@id='trigger_dataForm:startTime_det']","XPATH", "Calendar");
		//selectDate();
		Thread.sleep(4000);
		libManhattanCommonFunctions.clickAnyElement("(//td[@class='button nav'])[3]","XPATH", "Select Date");
		Thread.sleep(4000);
		libManhattanCommonFunctions.clickAnyElement("(//td[@class='day'])[1]","XPATH", "Select Date");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("EquipmentCode"), strEquipmentCode, "Equipment Code");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Carrier"), strCarrier, "Carrier id");
		Select AppointmentType = new Select(driver.findElement(By.id("dataForm:cd10")));
		AppointmentType.selectByVisibleText(strApptType);
	}


	/**
	 *********************************************************************** 
	 * Function enters dock details and clicks on Save with Best Fit button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strDock,strDoor
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void enterDockDetails(String strDock, String strDoor){
		try{
			libManhattanCommonFunctions.clickAnyElement(getPageElement("lnkDockDetails"), "Dock Details");
			Thread.sleep(4000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DockAssgnd"), strDock, "Assigned Dock");
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DoorAssgnd"), strDoor, "Assigned Door");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnSaveWidBestFit"), "Save With Best Fit");
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 
	}

}

