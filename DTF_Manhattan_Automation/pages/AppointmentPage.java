package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class AppointmentPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public AppointmentPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("AppointmentPage"))
			report.updateTestLog("Appointment Page verification", "Appointment loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Appointment Page verification", "Appointment page not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		AppointmentNumber, Apply, actions, addAppt, editAppt, btnEdit,lnkDockDetails,DockAssgnd, btnSave, DoorAssgnd;
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

			case AppointmentNumber:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:filterId1:field10value1']", "XPATH");
				break;
			case Apply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:filterId1:filterId1apply']", "XPATH");
				break;
			case actions:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[@class='moimg -icons_mopt'])[1]", "XPATH");
				break;
			case addAppt:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//a[@id='apptList_menu_1_menuItem'])[1]", "XPATH");
				break;
			case editAppt:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='apptList_menu_2_menuItem']", "XPATH");
				break;
			case btnEdit:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Edit']", "XPATH");
				break;
			case btnSave:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Save'])[2]", "XPATH");
				break;
			case 
				lnkDockDetails: elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='tab3_lnk']", "XPATH");
				break;
			case 
				DockAssgnd: elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:dockNameText1']", "XPATH");
				break;
			case 
				DoorAssgnd:elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:dockDoorNameText1']", "XPATH");
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
	 * Function enters appointment number in search box and click apply button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strAppointmentNumber
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void searchAppointment(String strAppointmentNumber){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("AppointmentNumber"), strAppointmentNumber, "AppointmentNumber");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");			
		libManhattanCommonFunctions.waitForElementClickable(".//*[@id='dataForm:listView:dataTable:0:apptId']", 8000);
	}

	/**
	 *********************************************************************** 
	 * Function validates appointment details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strAppointmentNumber,strTrailer,strASNNumber,strCarrier
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void validateAppointmentDetails(String strAppointmentNumber,String strTrailer,String strASNNumber,String strCarrier){

		try{
			String actualAppointmentNumber = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:apptId']", "XPATH").getText();
			String actualTrailer = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:trailer']", "XPATH").getText();
			String actualASNNumber = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:out6']", "XPATH").getText();
			String actualCarrier = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:carrier']", "XPATH").getText();
			if(actualAppointmentNumber.trim().equals(strAppointmentNumber) && actualTrailer.trim().equals(strTrailer) && actualASNNumber.trim().equals(strASNNumber) && actualCarrier.trim().equals(strCarrier))
				report.updateTestLog("Appointment Details Validation", "Appointment Number : "+actualAppointmentNumber+" || Trailer : "+actualTrailer+" || ASN Number :"+actualASNNumber+" || Carrier :"+actualCarrier, Status.PASS);
			else
				report.updateTestLog("Appointment Details Validation", "Expected AppointmentNumber : "+strAppointmentNumber+" || Actual ApointmentNumber : "+actualAppointmentNumber+" || Expected Trailer : "+strTrailer+" || Actual Trailer : "+actualTrailer+" || Expected ASN : "+strASNNumber+" || Actual ASN : "+actualASNNumber+" || Expected Carrier : "+strCarrier+" || Actual Carrier : "+actualCarrier, Status.FAIL);
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);


		} 	
	}

	/**
	 *********************************************************************** 
	 * Function validates the appoitnment Status
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void validateAppointmentStatus()
	{
		try{
			String strStatus="Scheduled";
			String actualStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:apptType']", "XPATH").getText();
			if(actualStatus.trim().equals(strStatus))
			{
				report.updateTestLog("Appointment Status verification", "Actual Status : "+actualStatus, Status.PASS);
			}else
			{
				report.updateTestLog("Appointment Status verification", "Actual Status : "+actualStatus +" Expected Status : "+strStatus, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 	
	}

	/**
	 *********************************************************************** 
	 * Function adds a new appointment
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void addAppointment()
	{
		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clickAnyElement(getPageElement("actions"), "Actions");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("addAppt"), "Add Appointment");
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 	
	}

	/**
	 *********************************************************************** 
	 * Function edits an existing appointment and clicks on Save button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strNewApptType,strNewDoor
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void editAppointment(String strNewApptType, String strNewDoor)
	{
		try{
			libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:listView:dataTable']","XPATH", "CheckBox");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEdit"), "Edit Button");
			Thread.sleep(4000);
			Select AppointmentType = new Select(driver.findElement(By.id("dataForm:cd10")));
			AppointmentType.selectByVisibleText(strNewApptType);
			Thread.sleep(4000);
			//		libManhattanCommonFunctions.clickAnyElement(getPageElement("lnkDockDetails"), "Dock Details");
			//		Thread.sleep(4000);
			//		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DoorAssgnd"), strNewDoor, "Assigned Door");
			//		Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save Button");
			Thread.sleep(3000);
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function verifies the edited appointment details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strNewApptType,strNewDoor
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void verifyeditedDetails(String strNewApptType, String strNewDoor)
	{
		try{
			Thread.sleep(2000);
			String actualApptType = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:type']", "XPATH").getText();
			String actualDoor = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:doorAssigned']", "XPATH").getText();
			if(actualApptType.trim().equals(strNewApptType) && actualDoor.trim().equals(strNewDoor))
				report.updateTestLog("Appointment Details Validation", "Appointment Type : "+actualApptType+" || Door : "+actualDoor, Status.PASS);
			else
				report.updateTestLog("Appointment Details Validation", "Expected Appointment Type : "+strNewApptType+" || Actual Appointment Type : "+actualApptType+" || Expected Door : "+strNewDoor+" || Actual Door : "+actualDoor, Status.FAIL);
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function retrieves appointment details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public String[] retreiveApptDetails(){
		String strarr[] = new String[3];
		try{String ApptType = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:type']", "XPATH").getText();
		String Door = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:doorAssigned']", "XPATH").getText();
		String Trailer = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:dataTable:0:trailer']", "XPATH").getText();
		strarr[0]=ApptType;strarr[1]=Door;strarr[2]=Trailer;
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 	
		return strarr;
	}

}
