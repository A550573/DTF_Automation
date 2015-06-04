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
public class ItemInventoryPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public ItemInventoryPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try {

		} catch (Exception e) {
			report.updateTestLog("ItemInventoryPage-OBJECT IDENTIFICATION","Error in finding Page Object/element : " + e.getMessage(),Status.FAIL);
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
		if (getCurrentPage("ItemInventoryPage"))
			report.updateTestLog("ItemInventoryPage Page verification","ItemInventoryPage loaded as expected.", Status.DONE);
		else
			report.updateTestLog("ItemInventoryPage Page verification","ItemInventoryPage loaded as expected.", Status.DONE);
		
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
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listViewItem:filterId:itemLookUpId']","XPATH");
				break;
			case btnApply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@title='Apply'])[1]","XPATH");
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
	 * @Author 	Nitika
	 * @param 	strItem
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SearchItem(String strItem) {
		try {
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtSearchBox"), strItem,"Item Search");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");
			Thread.sleep(4000);
		} catch (Exception e) {
			report.updateTestLog("ItemInventoryPage", "Element Not Found",Status.FAIL);
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function selects the search result displayed
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param	None 
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void selectItem() {
		
		libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:listViewItem:dataTable']","XPATH", "CheckBox");

	}
	
	/**
	 *********************************************************************** 
	 * Function clicks on Lpns button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickOnLPNsButton() {
		try {
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnLpns"), "LPNs button");
			Thread.sleep(2000);

		} catch (Exception e) {
			report.updateTestLog("ItemInventoryPage Page", "Element Not Found",Status.FAIL);

		}
	}

}
