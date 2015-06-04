package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class CheckinDetailsPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public CheckinDetailsPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("CheckinDetailsPage"))
			report.updateTestLog("Checkin Page Deatils verification", "Checkin loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Checkin Details verification", "Checkin loaded not loaded!!!!", Status.FAIL);
	}

	public enum enumPageObjects
	{
		Facility,Carrier, Trailer, btnSave ,CurrLoc, TrailerCondition, Equipment, AppointmentType, AppointmentWPA, TrailerWPA, CurrentLocationWPA, EquipmentWPA, AppointmentIDWPA, addbtn;
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
			case Facility:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find facility']", "XPATH");
				break;
			case Carrier:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@alt='Find carrier'])[3]", "XPATH");
				break;
			case Trailer:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listViewTrailer:dataTableTrailer:0:trailerV']", "XPATH");
				break;
			case CurrLoc:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listViewTrailer:dataTableTrailer:0:currentLocationV']", "XPATH");
				break;
			case TrailerCondition:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@id='dataForm:listViewTrailer:dataTableTrailer:0:trailerConditionV']", "XPATH");
				break;
			case Equipment:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listViewTrailer:dataTableTrailer:0:equipmentV']", "XPATH");
				break;
			case AppointmentType:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@id='dataForm:listView:apptListTable:0:appointmentTypeV']", "XPATH");
				break;
			case  btnSave:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Save'])[2]", "XPATH");
				break;
			case  AppointmentWPA: 
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listViewTrailer:dataTableTrailer:newRow_1:tcAppointmentId']", "XPATH");
				break;																												
			case  TrailerWPA: 
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@id='dataForm:listViewTrailer:dataTableTrailer:newRow_1:trailer'])[1]", "XPATH");
				break;
			case CurrentLocationWPA:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listViewTrailer:dataTableTrailer:newRow_1:currentLocation']", "XPATH");
				break;
			case EquipmentWPA:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listViewTrailer:dataTableTrailer:newRow_1:equipment']", "XPATH");
				break;
			case  AppointmentIDWPA: 
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listView:apptListTable:newRow_1:tcAppointmentId']", "XPATH");
				break;
			case addbtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Add'])[1]", "XPATH");
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
	 * Function enters the check in details and clicks on save button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strFacility, strCarrier, strTrailer, strCurrLoc,
	 * 		  	strTrailerCondition, strEquipment, strAppointmentType
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void enterCheckinDetails(String strFacility, String strCarrier, String strTrailer, String strCurrLoc, String strTrailerCondition, String strEquipment, String strAppointmentType) throws InterruptedException {

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Facility"), strFacility, "Facility");
		//libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Carrier"), strCarrier, "Carrier");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Trailer"), strTrailer, "Trailer");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("CurrLoc"), strCurrLoc, "CurrLoc");
		Select TrailerCondition = new Select(driver.findElement(By.id("dataForm:listViewTrailer:dataTableTrailer:0:trailerConditionV")));
		TrailerCondition.selectByVisibleText(strTrailerCondition);

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Equipment"), strEquipment, "Equipment");

		Select AppointmentType = new Select(driver.findElement(By.id("dataForm:listView:apptListTable:0:appointmentTypeV")));
		AppointmentType.selectByVisibleText(strAppointmentType);
		Thread.sleep(1000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save");		

	}

	/**
	 *********************************************************************** 
	 * Function enters the check in without prior appointment details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strCarrierWPA, strAppointmentWPA, strTrailerWPA,
	 * 		  	strCurrentLocationWPA, strTrailerConditionWPA, strEquipmentWPA,
	 * 		  	strAppointmentTypeWPA
	 * @version 1.0
	 ***********************************************************************
	 */
	public void CheckinWPADetails(String strCarrierWPA,String strAppointmentWPA,String strTrailerWPA, String strCurrentLocationWPA, String strTrailerConditionWPA, String strEquipmentWPA, String strAppointmentTypeWPA) {

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Carrier"), strCarrierWPA, "Carrier");

		libManhattanCommonFunctions.clickAnyElement(getPageElement("addbtn"), "Add Button");	

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("AppointmentWPA"), strAppointmentWPA, "Appointment");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("TrailerWPA"), strTrailerWPA, "Trailer");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("CurrentLocationWPA"), strCurrentLocationWPA, "CurrentLocation");

		Select TrailerConditionWPA = new Select(driver.findElement(By.name("dataForm:listViewTrailer:dataTableTrailer:newRow_1:trailerCondition")));
		TrailerConditionWPA.selectByVisibleText(strTrailerConditionWPA);

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("EquipmentWPA"), strEquipmentWPA, "Equipment");

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("AppointmentIDWPA"), strAppointmentWPA, "AppointmentID");
		Select AppointmentTypeWPA = new Select(driver.findElement(By.name("dataForm:listView:apptListTable:newRow_1:appointmentType")));
		AppointmentTypeWPA.selectByVisibleText(strAppointmentTypeWPA);

		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save");		

	}

	/**
	 *********************************************************************** 
	 * Function verifies the check in details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strFacility, strCarrier
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyCheckinDetails(String strFacility,String strCarrier){
		try{
			String actualFacility=libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find facility']", "XPATH").getText();
			String actualCarrier=libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find carrier']", "XPATH").getText();
			if(actualFacility.trim().equals(strFacility) && actualCarrier.trim().equals(strCarrier))
			{
				report.updateTestLog("Checkin Details verification", "Checkin Details verified successfully", Status.PASS);
			}else
			{
				report.updateTestLog("Checkin Details", "Checkin Details verification failed ", Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}   
	}

	/**
	 *********************************************************************** 
	 * Function enters the check in details and clicks on save button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strFacility, strCarrier, strTrailer, strCurrLoc,
	 * 		  	strTrailerCondition, strEquipment, strAppointmentType
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void entertrailerDetails(String strTrailer, String strCurrLoc, String strTrailerCondition) throws InterruptedException {

		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Trailer"), strTrailer, "Trailer");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("CurrLoc"), strCurrLoc, "CurrLoc");
		Select TrailerCondition = new Select(driver.findElement(By.id("dataForm:listViewTrailer:dataTableTrailer:0:trailerConditionV")));
		TrailerCondition.selectByVisibleText(strTrailerCondition);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save");		
		Thread.sleep(4000);

	}

}
