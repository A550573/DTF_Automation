package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class DockDoorPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public DockDoorPage(ScriptHelper scriptHelper) {
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
		libManhattanCommonFunctions.waitForElementClickable("//span[contains(text(),'Dock Door List')]", 3000);
		if (getCurrentPage("DockDoorPage"))
			report.updateTestLog("Dock door Page verification", "Dock door loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Dock door Page verification", "Dock door page loaded not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		DockDoor, Dock, Apply, DockDoorHeader, DockHeader, DockField, DockDoorField, ShipmentField, FacilityField, StatusField, ASNField, TrailerField, CarrierField, DockDoorStatus;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: DockDoor, Dock, Apply, DockDoorHeader, DockHeader, DockField, DockDoorField, ShipmentField, FacilityField, StatusField, ASNField, TrailerField, CarrierField, DockDoorStatus.
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case DockDoor:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Dock Door']", "XPATH");
				break;
			case Dock:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@alt='Find Dock'])", "XPATH");//for ONT add [2] to the xpath
				break;
			case Apply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply' and @title='Apply'])[1]", "XPATH");
				break;
			case DockField:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//table[@id='dataForm:glid1']//span[text()='Dock:']", "XPATH");
				break;	
			case DockDoorField:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//table[@id='dataForm:glid1']//span[text()='Dock Door:']", "XPATH");
				break;
			case ShipmentField:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//table[@id='dataForm:glid1']//span[text()='Shipment:']", "XPATH");
				break;
			case FacilityField:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//table[@id='dataForm:glid1']//span[text()='Facility:']", "XPATH");
				break;
			case StatusField:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//table[@id='dataForm:glid1']//span[text()='Status:']", "XPATH");
				break;
			case ASNField:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//table[@id='dataForm:glid1']//span[text()='ASN:']", "XPATH");
				break;
			case TrailerField:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//table[@id='dataForm:glid1']//span[text()='Trailer:']", "XPATH");
				break;
			case CarrierField:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//table[@id='dataForm:glid1']//span[text()='Carrier:']", "XPATH");
				break;
			case DockDoorStatus:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:OdoorStatusId']", "XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("DockDoorPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("DockDoorPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 *********************************************************************** 
	 * Function DockDoor and Dock in the search box and clicks apply button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strDockDoor, strDock
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchDockDoor(String strDock,String strDockDoor){

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Dock"), strDock, "Dock");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DockDoor"), strDockDoor, "DockDoor");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");					
	}

	/**
	 *********************************************************************** 
	 * Function validates dock door details (Trailer and ASN)
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strTrailer, strASN
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateDockDoorDetails(String strTrailer,String strASN){
		try{
			String actualTrailer = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:TrailerIdDet']", "XPATH").getText();
			String actualASN = libManhattanCommonFunctions.getElementByProperty("(.//*[@class='captionData'])[10]", "XPATH").getText();
			if(actualTrailer.trim().equals(strTrailer) && actualASN.trim().equals(strASN))
			{
				report.updateTestLog("Dock door details verification", "Trailer : "+actualTrailer+" and ASN : "+actualASN +" is verified", Status.PASS);
			}else
			{
				report.updateTestLog("Dock door details verification", "Expected Trailer : "+strTrailer+" || Actual Trailer : "+actualTrailer+" || Expected ASN : "+strASN+" || Actual ASN : "+actualASN, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 *********************************************************************** 
	 * Function validates dock door status
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateDockDoorStatus(String strStatus){
		try{
			String actualStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:OdoorStatusId']", "XPATH").getText();
			if(actualStatus.trim().equals(strStatus))
			{
				report.updateTestLog("Dock door details verification", "Status : "+actualStatus+" is verified", Status.PASS);
			}else
			{
				report.updateTestLog("Dock door details verification", "Expected Status : "+strStatus+" || Actual Status : "+actualStatus, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 *********************************************************************** 
	 * Function validates dock door table headers are present.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	None
	 * @version 1.0
	 * @throws 	InterruptedException 
	 ***********************************************************************
	 */
	public void validateDockDoorHeaders() throws InterruptedException{
		libManhattanCommonFunctions.waitForElementClickable("//table[@id='dataForm:glid1']//span[text()='ASN:']", 4000);
		Thread.sleep(4000);
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("DockField"), "Dock Field");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("DockDoorField"), "Dock Door Field");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("ShipmentField"), "Shipment Field");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("StatusField"), "Status Field");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("ASNField"), "ASN Field");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("FacilityField"), "Facility Field");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("TrailerField"), "Trailer Field");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("CarrierField"), "Carrier Field");	

	}

}
