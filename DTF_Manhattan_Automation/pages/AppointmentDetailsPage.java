package pages;

import java.text.DateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class AppointmentDetailsPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public AppointmentDetailsPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("AppointmentDetailsPage"))
			report.updateTestLog("Appointment Details Page verification", "Appointment Details page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Appointment Details Page verification", "Appointment Details page not loaded!!!!", Status.FAIL);
	}

	private enum enumPageObjects
	{
		Facility;
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
	 * Function retrieves the newly created appointment Id.
	 * @return 	AppointmentId 
	 * @Author  Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public String getApptId()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		String AppointmentId = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:appointmentId_d']", "XPATH").getText();
		report.updateTestLog("AppointmentPage", "Appt id : " + AppointmentId, Status.DONE);
		return AppointmentId;
	}

}
