package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

/**
 * Any Manhattan Page class
 * 
 * @author Cognizant
 */
public class ItemInventoryByLocationPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public ItemInventoryByLocationPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try {

		} catch (Exception e) {
			report.updateTestLog("ItemInventoryByLocationPage-OBJECT IDENTIFICATION","Error in finding Page Object/element : " + e.getMessage(),Status.FAIL);
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
	@Override
	protected void initializeUIMap() {
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("ItemInventoryByLocationPage"))
		{
			report.updateTestLog("ItemInventoryByLocationPage Page verification","Item Inventory By Location Page loaded as expected.", Status.DONE);
		}
			else
			{
				report.updateTestLog("ItemInventoryByLocationPage Page verification","Item Inventory By Location Page not loaded!!!!!", Status.FAIL);
			}
		
	}

	/**
	 * To use switch case we are declaring the below enum for
	 * MyAccount,Login,Logout,MiniCart
	 */
	private enum enumPageObjects {
		txtSearchBox, btnApply, btnLpns;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and
	 * identifies the object based on the object definition
	 * 
	 * @param strElemName
	 *            The {@link strElemName} are objects identified so far in
	 *            iLPNPagePage. Values:
	 *            AllCheckBox, DistributionOrderID, DistributionOrders, ASN, VerificationAttempted, Shipment, COGI, ReceiptVariance, TotalReceived, TotalShipped, ShippedDate, EstimatedDeliveryDate, DeliveryFacility, PickupFacility, ASNsBusinessPartner, BusinessUnit, ASNStatus, ASNNumber, lnkASNs, RoutingRequest, TransporationResponsibility, DestinationInfo, OriginInfo, LockStatus, ReadyToShip, btnApplyTop, DueDate, Status, BusinessPartner, lblPurchaseOrderID, btnPurchaseOrders, btnCategoryConfiguration, btniLPNPageIcon, btnCategoryDistribution, btniLPNs, txtSearchBox, btnApply, btnMaximize, btnLockorUnlock, btnLock, btnUnlock, drpLockCode, btnSave, btnView, actionsbtn, activitytrackingbtn, lockunlockbtn, adjustbtn;
	 * @return The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName) {
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case txtSearchBox:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listView:filterId:itemLookUpId']","XPATH");
				break;
			case btnApply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listView:filterId:filterIdapply']","XPATH");
				break;
			case btnLpns:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='LPNs']","XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("ItemInventoryPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main iLPNPage", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("ItemInventoryPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}


	/**
	 *********************************************************************** 
	 * Function enters item number in search box and clicks on apply button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strItem
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SearchItem(String strItem) {
		try {
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			Thread.sleep(3000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtSearchBox"), strItem,"Item Search");
			Thread.sleep(3000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");
			Thread.sleep(4000);
		} catch (Exception e) {
			report.updateTestLog("ItemInventoryPage", "Element Not Found",Status.FAIL);
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function to validate Dynamic Active Location is displayed
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param	None 
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void ValidateDAloc() {
		
		if(libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'DA-')]", "XPATH"))
		{
			String strDAloc = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'DA-')]", "XPATH").getText().trim();
			
			report.updateTestLog("Dynamic Active Location Validation", "Dynamic Active Location is displayed:"+strDAloc,Status.PASS);
		    
		}
		else
		{
			report.updateTestLog("Dynamic Active Location Validation", "Dynamic Active Location is not displayed",Status.FAIL);
		}
	
	}
	
	/**
	 *********************************************************************** 
	 * Function to validate Dynamic Active Location is not displayed
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param	None 
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void ValidateNoDAloc() {
		if(!(libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'DA-')]", "XPATH")))
		{
			
			report.updateTestLog("No Dynamic Active Location Validation", "Dynamic Active Location is not displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("No Dynamic Active Location Validation", "Dynamic Active Location is displayed",Status.FAIL);
		}

	}
	
	/**
	 *********************************************************************** 
	 * Function to get dynamic active location
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param	None 
	 * @version 1.0 
	 ***********************************************************************
	 */
	
     public String getDAloc() {
		
			String strDAloc = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'DA-')]", "XPATH").getText().trim();
            return strDAloc;
	}
	
	
}
