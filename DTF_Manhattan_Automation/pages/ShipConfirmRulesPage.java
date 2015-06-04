package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import pages.CreateAsnFromPOPage.enumPageObjects;
import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class ShipConfirmRulesPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */

	public ShipConfirmRulesPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try{

		}catch(Exception e){
			report.updateTestLog("AnyManhattanPage-OBJECT IDENTIFICATION", "Error in finding Page Object/element : " + e.getMessage(), Status.FAIL);
		}
	}
	
	protected void initializeUIMap()
	{
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("ShipConfirmRulesPage"))
			report.updateTestLog("Ship Confirm Rules Page verification", "Ship Confirm Rules Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Ship Confirm Rules Page verification", "Ship Confirm Rules Page not loaded!!!!", Status.FAIL);
	}

	public enum enumPageObjects
	{
		btnShipConfirm, btnView, lnkDefinition, DO_ID;
	}
	
	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: btnShipConfirm
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {
			
			case btnShipConfirm: elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Ship Confirm']", "XPATH");
			break;
			
			case btnView: elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='View']", "XPATH");
			break;
			
			case lnkDefinition: elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='definitionTab_lnk']", "XPATH");
			break;
			
			case DO_ID: elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ruleSelDtlDataTable:0:ruleSelDtlRuleCmparValue']", "XPATH");
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
	 * Function enters purchase order id in search box and clicks on apply button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strPurchaseID
	 * @version 1.0
	 ***********************************************************************
	 */
	public void shipConfirmTest(String strDO_Id)
	{
		try{
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
		libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:listView:dataTable']", "XPATH", "CheckBox");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnView"), "View Button");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("lnkDefinition"), "Definition");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DO_ID"), strDO_Id, "Order Id");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnShipConfirm"), "Ship Confirm Button");
		Thread.sleep(4000);
		pressOKonPopUp();
		Thread.sleep(8000);
		}catch (Exception e) {
			report.updateTestLog("Ship Confirm Rules Page", "Element Not Found", Status.FAIL);
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function clicks OK on the pop up dialog box.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void pressOKonPopUp() throws InterruptedException, AWTException {

		if(driver.switchTo().alert() != null){
			driver.switchTo().alert().accept();
			}else{
			System.out.println("1 alert present");
			}
	}


	/**
	 *********************************************************************** 
	 * Function confirms shipment.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void shipConfirmation()
	{
		try{
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
		libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c1_dataForm:listView:dataTable']", "XPATH", "CheckBox");
		Thread.sleep(2000);		
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnShipConfirm"), "Ship Confirm Button");
		Thread.sleep(4000);
		pressOKonPopUp();
		Thread.sleep(8000);
		}catch (Exception e) {
			report.updateTestLog("Ship Confirm Rules Page", "Element Not Found", Status.FAIL);
		}

	}

}
