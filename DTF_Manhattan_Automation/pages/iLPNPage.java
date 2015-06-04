package pages;

import java.awt.AWTException;
import java.util.ArrayList;
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
public class iLPNPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public iLPNPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try {

		} catch (Exception e) {
			report.updateTestLog("iLPNPagePage-OBJECT IDENTIFICATION","Error in finding Page Object/element : " + e.getMessage(),Status.FAIL);
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
		if (getCurrentPage("iLPNPage"))
			report.updateTestLog("iLPNPage Page verification","iLPNPage loaded as expected.", Status.DONE);
		else
			report.updateTestLog("iLPNPage Page verification","iLPNPage loaded as expected.", Status.DONE);
	}

	/**
	 * To use switch case we are declaring the below enum for
	 * MyAccount,Login,Logout,MiniCart
	 */
	private enum enumPageObjects {
		AllCheckBox, DistributionOrderID, DistributionOrders, ASN, VerificationAttempted, Shipment, COGI, ReceiptVariance, TotalReceived, TotalShipped, ShippedDate, EstimatedDeliveryDate, DeliveryFacility, PickupFacility, ASNsBusinessPartner, BusinessUnit, ASNStatus, ASNNumber, lnkASNs, RoutingRequest, TransporationResponsibility, DestinationInfo, OriginInfo, LockStatus, ReadyToShip, btnApplyTop, DueDate, Status, BusinessPartner, lblPurchaseOrderID, btnPurchaseOrders, btnCategoryConfiguration, btniLPNPageIcon, btnCategoryDistribution, btniLPNs, txtSearchBox, btnApply, btnMaximize, btnLockorUnlock, btnLock, btnUnlock, drpLockCode, btnSave, btnView, actionsbtn, activitytrackingbtn, lockunlockbtn, adjustbtn, BulkUpdate, LocksTab;
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

			case AllCheckBox:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@name='dataForm:LPNListInOutboundMain_lv:dataTable_checkAll']","XPATH");
				break;
			case DistributionOrderID:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@alt='Find Distribution Order']", "XPATH");
				break;
			case DistributionOrders:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("Distribution Orders", "LINKTEXT");
				break;
			case ASNNumber:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@alt='Find ASN']", "XPATH");
				break;
			case ASN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td4_view","ID");
				break;
			case ASNStatus:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td5_view","ID");
				break;
			case BusinessUnit:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td6_view","ID");
				break;
			case ASNsBusinessPartner:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td7_view","ID");
				break;
			case PickupFacility:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td8_view","ID");
				break;
			case DeliveryFacility:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td9_view","ID");
				break;
			case EstimatedDeliveryDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td9_view","ID");
				break;
			case ShippedDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td11_view","ID");
				break;
			case TotalShipped:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td12_view","ID");
				break;
			case TotalReceived:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td13_view","ID");
				break;
			case ReceiptVariance:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td14_view","ID");
				break;
			case COGI:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td15_view","ID");
				break;
			case Shipment:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td16_view","ID");
				break;
			case VerificationAttempted:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td17_view","ID");
				break;
			case TransporationResponsibility:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:POList_entityListView:dataTable_body_tr0_td13_view","ID");
				break;
			case DestinationInfo:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:POList_entityListView:dataTable_body_tr0_td12_view","ID");
				break;
			case OriginInfo:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:POList_entityListView:dataTable_body_tr0_td11_view","ID");
				break;
			case LockStatus:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:POList_entityListView:dataTable_body_tr0_td9_view","ID");
				break;
			case btnApplyTop:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@id='dataForm:POList_entityListView:POlistFil1:POlistFil1_quickFilterGroupButton_mainButton']//*[@value='Apply']","XPATH");
				break;
			case btnApply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply' and @title='Apply'])[1]","XPATH");
				break;
			case btniLPNPageIcon:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("button-1023-btnIconEl", "ID");
				break;
			case btniLPNs:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'iLPNs')]", "XPATH");
				break;
			case btnLockorUnlock:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='LPNListInboundMain_commandbutton_LockUnlockLPN']","XPATH");
				break;
			case txtSearchBox:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find iLPN']", "XPATH");
				break;
			case btnView:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='LPNListInboundMain_commandbutton_view']","XPATH");
				break;
			case actionsbtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='Actions']", "XPATH");
				break;
			case activitytrackingbtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@title='Activity Tracking']", "XPATH");
				break;
			case lockunlockbtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//a[@title='Lock/Unlock'])[1]", "XPATH");
				break;
			case adjustbtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Adjust']", "XPATH");
				break;
			case BulkUpdate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Bulk Updates']", "XPATH");
				break;
			case LocksTab:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='LPN_Locks_Tab_lnk']", "XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("iLPNPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main iLPNPage", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("iLPNPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}

	/**
	 *********************************************************************** 
	 * Function clicks on iLPN page icon
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayshree
	 * @param	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickiLPNPageIcon() {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btniLPNPageIcon"), "iLPNPage Icon");
		} catch (Exception e) {
			report.updateTestLog("iLPNPage Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function enters iLPN nbr in search box and clicks on apply button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna
	 * @param 	striLPNNumber
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void applyiLPN(String striLPNNumber) {
		try {
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtSearchBox"), striLPNNumber,"iLPN Search");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");
			Thread.sleep(8000);
		} catch (Exception e) {
			report.updateTestLog("iLPNPage Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function validates iLPN search results
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateSearchResult() {
		try {

			String strHeader = driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:dataTable_headDiv")).getText();
			System.out.println(strHeader);
			if ((strHeader.indexOf("LPN") != -1)&& (strHeader.indexOf("Type") != -1)&& (strHeader.indexOf("LPN Facility Status") != -1)&& (strHeader.indexOf("Business Unit") != -1)&& (strHeader.indexOf("Facility") != -1)&& (strHeader.indexOf("LPN Quantity") != -1)&& (strHeader.indexOf("Pallet") != -1)&& (strHeader.indexOf("Item") != -1)&& (strHeader.indexOf("ASN") != -1)&& (strHeader.indexOf("Shipment") != -1)&& (strHeader.indexOf("Distribution Order") != -1)&& (strHeader.indexOf("Locks") != -1)) {
				report.updateTestLog("iLPN Search Result","iLPN Search Result has all the fields displayed",Status.PASS);
			}

		} catch (Exception e) {
			report.updateTestLog("iLPN Search Result", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function verifies iLPN number and lock status for the iLPN
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna
	 * @param 	strLPNNumber, strlockStatus
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void verifyLockStatus(String strLPNNumber, String strlockStatus) {
		try {
			String actualLPNNumber = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_Link_NameText_param_out']","XPATH").getText();
			String actualLockStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Inbound_LockCount_param_out']","XPATH").getText();
			if (actualLPNNumber.trim().equals(strLPNNumber.trim())&& actualLockStatus.trim().equals(strlockStatus.trim())) {
				report.updateTestLog("Lock Status verification","Lock status verified successfully", Status.PASS);
			} else {
				report.updateTestLog("Lock Status verification","Lock status verification failed , Expected LPN:"+strLPNNumber+" || Actual LPN : "+actualLPNNumber+"Expected Lockstatus: "+strlockStatus+" ||Actual Lock Status: "+actualLockStatus+"", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function verifies any field values in iLPN table
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayshree
	 * @param 	strFieldName, strValue
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void verifyAnyFieldANDtextValue(String strFieldName, String strValue) {
		try {
			libManhattanCommonFunctions.verifyAndReportElementState(getPageElement(strFieldName), "CONTAINS-" + strValue, "Y",strFieldName);
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function to click any element in iLPN page
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayshree
	 * @param 	strElementName
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickAnyElementIniLPNPagePage(String strElementName) {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement(strElementName), strElementName);
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function selects the search result displayed
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayshree
	 * @param	None 
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void selectSearchResult() {
		try {
			WebElement wbLPNCheckbox = driver.findElement(By.id("checkAll_c0_dataForm:listView:dataTable"));
			wbLPNCheckbox.clear();
			wbLPNCheckbox.click();
		} catch (Exception e) {
			report.updateTestLog("iLPNPage Page", "Element Not Found",Status.FAIL);

		}
	}

	/**
	 *********************************************************************** 
	 * Function clicks on Lock/Unlock button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickLockOrUnlockButton_iLPNPage() {
		try {
			//
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnLockorUnlock"), "Lock/UnLock button");
			Thread.sleep(2000);

		} catch (Exception e) {
			report.updateTestLog("iLPNPage Page", "Element Not Found",Status.FAIL);

		}
	}

	/**
	 *********************************************************************** 
	 * Function clicks on BulkUpdate button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickBulkUpdateButton() {
		try {
			//
			libManhattanCommonFunctions.clickAnyElement(getPageElement("BulkUpdate"), "Bulk Update button");
			Thread.sleep(2000);

		} catch (Exception e) {
			report.updateTestLog("iLPNPage Page", "Element Not Found",Status.FAIL);

		}
	}

	/**
	 *********************************************************************** 
	 * Function clicks on select all check box for the displayed search results
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayshree
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */

	public void SelectAllCheckBox() {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement("AllCheckBox"), "All Check Box");
		} catch (Exception e) {
			report.updateTestLog("iLPNPage Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *************************************************************************** 
	 * Function validates iLPN details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna
	 * @param 	strLPN,strType,strLPNFacilityStatus,strBusinessUnit,strFacility
	 * 			strLPNQuantity,strPallet,strItem,strASN,strShipment,strLocks
	 * 			strDistributionOrder
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateiLPNDetails(String strLPN, String strType,String strLPNFacilityStatus, String strBusinessUnit,String strFacility, String strLPNQuantity, String strPallet,String strItem, String strASN, String strShipment,String strDistributionOrder, String strLocks) {
		try {
			String actualLPN = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][3]","XPATH").getText();
			String actualType = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][4]","XPATH").getText();
			String actualLPNFacilityStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][5]","XPATH").getText();
			String actualBusinessUnit = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][6]","XPATH").getText();
			String actualFacility = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][7]","XPATH").getText();
			String actualLPNQuantity = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][8]","XPATH").getText();
			String actualPallet = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][9]","XPATH").getText();
			String actualItem = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][10]","XPATH").getText();
			String actualASN = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][11]","XPATH").getText();
			String actualShipment = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][12]","XPATH").getText();
			String actualDistributionOrder = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][13]","XPATH").getText();
			String actualLocks = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][14]","XPATH").getText();
			if (actualLPN.trim().equals(strLPN)&& actualType.trim().equals(strType)&& actualLPNFacilityStatus.trim().equals(strLPNFacilityStatus)&& actualBusinessUnit.trim().equals(strBusinessUnit)&& actualFacility.trim().equals(strFacility)&& actualLPNQuantity.trim().equals(strLPNQuantity)&& actualPallet.trim().equals(strPallet)&& actualItem.trim().equals(strItem)&& actualASN.trim().equals(strASN)&& actualShipment.trim().equals(strShipment)&& actualDistributionOrder.trim().equals(strDistributionOrder)&& actualLocks.trim().equals(strLocks)) {
				report.updateTestLog("iLPN Details verification","iLPN Details verified successfully", Status.PASS);
			} else {
				report.updateTestLog("iLPN Details verification","iLPN Details verification failed ", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}
	}
	/**
	 *********************************************************************** 
	 * Functions to search multiple iLPNS and validate the status
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree
	 * @param 	strLPN, strLPNFacilityStatus
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void loopSearchiLPN(String strLPN, String strLPNFacilityStatus) {
		try {
//			strLPNFacilityStatus="Case consumed to active;Case consumed to active";
			if (strLPN.contains(";")) {
				int intLoop = 0;
				for (String strElement : strLPN.split(";")) {
					applyiLPN(strElement);
					Thread.sleep(10000);
					String[] strLPNFacility = strLPNFacilityStatus.split(";");

					validateiLPNStatus(strLPNFacility[intLoop]);
					Thread.sleep(10000);
					intLoop = intLoop + 1;
					driver.switchTo().defaultContent();
				}
			}else{
				applyiLPN(strLPN);
				validateiLPNStatus(strLPNFacilityStatus);
			}

		} catch (Exception e) {

		}
	}



	/**
	 *********************************************************************** 
	 * Functions to select multiple iLPNS from the checkbox
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strLPN
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SelectMultipleiLPN(String strLPN)
	{
		try {
			if (strLPN.contains(";")) {
				int intLoop = 0;
				int intRowPointer=0;
				WebElement wbLPNTable1 = driver.findElement(By.xpath("//div[@id='dataForm:LPNListInOutboundMain_lv:dataTable_bodyDiv']"));
				List<WebElement> wbTRList;
				for (String strElement : strLPN.split(";")) {                                
					wbTRList = wbLPNTable1.findElements(By.tagName("TR"));
					try{  


						int intPointr = 0;
						for(WebElement el: wbTRList){
							String strRowValue = el.getText();
							if(strRowValue.contains(strElement)){
								intRowPointer = intPointr;
								break;
							}
							intPointr = intPointr+1;
						}						
						libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+intPointr+"_dataForm:LPNListInOutboundMain_lv:dataTable']", "XPATH", "CheckBox");
					}
					catch(Exception e){
						report.updateTestLog("Element", "Element Not Found", Status.FAIL);
					}    
					intLoop = intLoop + 1;
					//driver.switchTo().defaultContent();
				}
			}else{
				SelectAllCheckBox();
			}

		} catch (Exception e) {

		}


	}


	/**
	 *********************************************************************** 
	 * Functions to search multiple iLPNS and validate the status and lock Code
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strLPN, strLPNFacilityStatus, strLocks
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SearchMultipleiLPN(String strLPN, String strLPNFacilityStatus, String strLocks) {
		try {
			if (strLPN.contains(";")) {
				int intLoop = 0;
				for (String strElement : strLPN.split(";")) {
					applyiLPN(strElement);
					Thread.sleep(10000);
					String[] strLPNFacility = strLPNFacilityStatus.split(";");

					validateiLPNStatus(strLPNFacility[intLoop]);
					verifyLockStatus(strElement,strLocks);
					Thread.sleep(10000);
					intLoop = intLoop + 1;
					driver.switchTo().defaultContent();
				}
			}else{
				applyiLPN(strLPN);
				validateiLPNStatus(strLPNFacilityStatus);
				verifyLockStatus(strLPN,strLocks);
			}

		} catch (Exception e) {

		}
	}


	/**
	 *********************************************************************** 
	 * Function validates the facility status of iLPN
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree
	 * @param 	strLPNFacilityStatus
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateiLPNStatus(String strLPNFacilityStatus) {

		try {
			String actualLPNFacilityStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_lpnFacilityStatus_param_out']","XPATH").getText();
			if (actualLPNFacilityStatus.trim().equals(strLPNFacilityStatus)) {
				report.updateTestLog("iLPN Status verification","iLPN Status : "+actualLPNFacilityStatus+" is verified", Status.PASS);
			} else {
				report.updateTestLog("iLPN Status verification","Expected iLPN Status : "+strLPNFacilityStatus+" || Actual iLPN Status : "+actualLPNFacilityStatus, Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 *********************************************************************** 
	 * Function validates iLPN facility status and facility
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna
	 * @param 	striLPNFacilityStatus, strFacility
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateiLPN(String striLPNFacilityStatus, String strFacility) {
		try {
			String actualiLPNFacilityStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_lpnFacilityStatus_param_out']","XPATH").getText();
			String actualFacility = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:CTO_LPNListTPM_Current_Facility_param_out_link']","XPATH").getText();
			if (actualiLPNFacilityStatus.trim().equals(striLPNFacilityStatus)&& actualFacility.trim().equals(strFacility)) {
				report.updateTestLog("iLPN verification","iLPN verified successfully", Status.PASS);
			} else {
				report.updateTestLog("iLPN verification","iLPN verification failed ", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function clicks on view button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */

	public void clickViewButton() {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnView"), "View Button");
		} catch (Exception e) {
			report.updateTestLog("iLPNPage Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function selects iLPN that is displayed
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void selectiLPN() {

		libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:LPNListInOutboundMain_lv:dataTable']","XPATH", "CheckBox");

	}
	/**
	 *********************************************************************** 
	 * Function clicks on actions button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickOnActions() throws InterruptedException{

		libManhattanCommonFunctions.clickAnyElement(getPageElement("actionsbtn"), "Actions Button");                     

	}

	/**
	 *********************************************************************** 
	 * Function clicks on activity tracking page
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */

	public void clickOnActivityTracking() throws InterruptedException{

		libManhattanCommonFunctions.clickAnyElement(getPageElement("activitytrackingbtn"), "Activity Tracking Button");                

	}

	/**
	 *********************************************************************** 
	 * Function clicks on Lock and Unlock displayed in actions list
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */

	public void clickOnLockUnlock() throws InterruptedException{

		libManhattanCommonFunctions.clickAnyElement(getPageElement("lockunlockbtn"), "Lock/Unlock Button");                  

	}
	/**
	 *********************************************************************** 
	 * Function clicks on adjust button
	 * @return Nothing is returned as of now 
	 * @Author Nitika
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickAdjustButton() throws InterruptedException{

		libManhattanCommonFunctions.clickAnyElement(getPageElement("adjustbtn"), "Adjust Button");                      

	}

	/**
	 *********************************************************************** 
	 * Function verifies the LPN quantity
	 * @return Nothing is returned as of now 
	 * @Author Nitika
	 * @param 	strQty
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void verifyLPNQty(String strQty)
	{
		String actual_Qty =libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:CTO_LPNListTPM_LPN_Qty_param_out2']", "XPATH").getText();
		String[] arr=actual_Qty.split(" ");
		actual_Qty =arr[0];
		if (actual_Qty.trim().equals(strQty))
		{
			report.updateTestLog("iLPN Quantity verification","iLPN Quantity verified successfully", Status.PASS);
		} else {
			report.updateTestLog("iLPN Quantity verification","iLPN Quantity verification failed ", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function validates the facility status of iLPN
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree
	 * @param 	strLPNFacilityStatus
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateiLPNQuantity(String strQuantity) {

		try {
			String actualLPNQuantity = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][8]","XPATH").getText();
			if (actualLPNQuantity.trim().equals(strQuantity)) {
				report.updateTestLog("iLPN Quantity verification","iLPN Quantity verified successfully", Status.PASS);
			} else {
				report.updateTestLog("iLPN Quantity verification","iLPN Quantity verified successfully", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 *************************************************************************** 
	 * Function validates iLPN details QTY, FacilityStatus and ASN Mapping
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strLPN,strType,strLPNFacilityStatus,strLPNQuantity,strASN,strLocks
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateiLPNDetails(String strLPN, String strLPNFacilityStatus, String strLPNQuantity, String strASN,String strLocks) {

		try {
			WebElement elem = driver.findElement(By.xpath("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNCommonHeader_ASN_param_out']"));
			String strtext =elem.getText();
			System.out.println(strtext);

			List <WebElement> objSpanList = driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Inbound_ASN_output_Link_id")).findElements(By.tagName("span"));
			for (WebElement e : objSpanList) {
				System.out.println("The element text is : "+e.getText());
			}
			strLocks = "1";
			String actualLPN = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_Link_NameText_param_out']","XPATH").getText();
			String actualLPNFacilityStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_lpnFacilityStatus_param_out']","XPATH").getText();
			String actualLPNQuantity = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:CTO_LPNListTPM_LPN_Qty_param_out2']","XPATH").getText();
			//String[] LPNQty = actualLPNQuantity.split(" ");
			//actualLPNQuantity = LPNQty[0];
			String actualASN = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNCommonHeader_ASN_param_out']","XPATH").getText();
			String actualLocks = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Inbound_LockCount_param_out']","XPATH").getText();
			if (actualLPN.trim().equals(strLPN)&& actualLPNFacilityStatus.trim().equals(strLPNFacilityStatus)&& (actualLPNQuantity.trim()).equals(strLPNQuantity)&& actualASN.trim().equals(strASN)&& actualLocks.trim().equals(strLocks)) {
				report.updateTestLog("iLPN details verification", "Expected iLPN : "+strLPN+" Actual iLPN : "+actualLPN+" Expected FacilityStatus : "+strLPNFacilityStatus+" Actual FacilityStatus : "+actualLPNFacilityStatus+" Expected Qty : "+strLPNQuantity+" Actual Qty : "+actualLPNQuantity+" Expected Locks : "+strLocks+" Actual Locks : "+actualLocks, Status.PASS);
			} else {
				report.updateTestLog("iLPN details verification", "Expected iLPN : "+strLPN+" Actual iLPN : "+actualLPN+" Expected FacilityStatus : "+strLPNFacilityStatus+" Actual FacilityStatus : "+actualLPNFacilityStatus+" Expected Qty : "+strLPNQuantity+" Actual Qty : "+actualLPNQuantity+" Expected Locks : "+strLocks+" Actual Locks : "+actualLocks, Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}
	}


	/**
	 *********************************************************************** 
	 * Function splits the iLPN.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	striLPNNumber
	 * @version 1.0
	 * @return 
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public String[] SplitiLPNs(String striLPNNumber) throws InterruptedException, AWTException{ 		
		Thread.sleep(4000);	
		String[] strLPNs = striLPNNumber.split(";");		
		return strLPNs;		
	}
	/**
	 *********************************************************************** 
	 * Functions to search multiple iLPNS and validate the facility statuses
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strLPN, strLPNFacilityStatus, strLocks
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validatemultipleIlpnFacilityStatus(String strLPN, String strLPNFacilityStatus) {
		try {
			if (strLPN.contains(";")) {
				int intLoop = 0;
				for (String strElement : strLPN.split(";")) {
					applyiLPN(strElement);
					Thread.sleep(10000);
					String[] strLPNFacility = strLPNFacilityStatus.split(";");

					validateiLPNStatus(strLPNFacility[intLoop]);
					Thread.sleep(10000);
					intLoop = intLoop + 1;
				}
			}else{
				applyiLPN(strLPN);
				validateiLPNStatus(strLPNFacilityStatus);
			}

		} catch (Exception e) {

		}
	}

	/**
	 *********************************************************************** 
	 * Function validates the facility status of iLPN
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strLPNFacilityStatus
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateCurrentLoc(String strCurrentLoc) {

		try {
			String actualcurrentLoc = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Inbound_CurrLocationId_param_out']","XPATH").getText();
			if (actualcurrentLoc.trim().equals(strCurrentLoc)) {
				report.updateTestLog("Dynamic Active Location Validation","Expected iLPN Current Loc : "+strCurrentLoc+" || Actual iLPN Current Loc : "+actualcurrentLoc, Status.PASS);
			} else {
				report.updateTestLog("Dynamic Active Location Validation","Expected iLPN Current Loc : "+strCurrentLoc+" || Actual iLPN Current Loc : "+actualcurrentLoc, Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 *************************************************************************** 
	 * Function retrieves iLPN values
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strItemName, strLPNQty, strLocation,strPalletNum, strItemDesc,
	 *  		strPO, strLockDesc, strDate
	 * @version 1.0 
	 ***********************************************************************
	 */


	public ArrayList<String> getLPNDetails() {
		String strItemName, strLPNQty, strLocation,strPalletNum, strItemDesc, strPO, strLockDescp, strDate;
		ArrayList<String> strLPNDetails = new ArrayList<String>();
		try {
			strLPNQty = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:CTO_LPNListTPM_LPN_Qty_param_out2']","XPATH").getText();
			//strLPNQty = strLPNQty.split("\\s+");
			System.out.println("qty : "+strLPNQty);
			strLocation = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Inbound_CurrLocationId_param_out']","XPATH").getText();
			strPalletNum = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][9]","XPATH").getText();

			selectiLPN();
			clickViewButton();
			Thread.sleep(4000);
			strItemName = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ViewCaseLPNContents_LPN_Item_param_out']","XPATH").getText();
			strItemDesc = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ViewCaseLPNContents_LPNItemDesc_outputText']","XPATH").getText();
			strPO = null;//libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:LPNCommonHeader_PO_outputText']","XPATH").getText();
			if (libManhattanCommonFunctions.verifyElementPresent(".//*[@id='dataForm:LPNCommonHeader_PO_outputText']", "XPATH")){
				strPO = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:LPNCommonHeader_PO_outputText']","XPATH").getText();
			}
			libManhattanCommonFunctions.clickAnyElement(getPageElement("LocksTab"), "Locks Tab");
			Thread.sleep(4000);
			strLockDescp = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:lockTable:0:ViewLPNLocksList_LockCode_out']","XPATH").getText();
			strDate = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:lockTable:0:ViewLPNLocksList_LockDateTime_out']","XPATH").getText();

			//			strLPNDetails[0] = strLPNQty; strLPNDetails[1] = strLocation; strLPNDetails[2] = strPalletNum;
			//			strLPNDetails[3] = strItemName; strLPNDetails[4] = strItemDesc; strLPNDetails[5] = strPO;
			//			strLPNDetails[6] = strLockDescp; strLPNDetails[7] = strDate;
			strLPNDetails.add(strLPNQty);
			strLPNDetails.add(strLocation);
			strLPNDetails.add(strPalletNum);
			strLPNDetails.add(strItemName);
			strLPNDetails.add(strItemDesc);
			strLPNDetails.add(strPO);
			strLPNDetails.add(strLockDescp);
			strLPNDetails.add(strDate);
			System.out.println("LPNDetails:"+strLPNDetails);
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}
		return strLPNDetails;
	}

	/**
     *********************************************************************** 
      * Function validates the Pallet of iLPN
     * @return    Nothing is returned as of now 
      * @Author    Nitika
     * @param     strPallet
     * @version 1.0 
      ***********************************************************************
     */
     public void validatePalletOfLPN(String strPallet) {

            try {
                   String actualPallet = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNListTPM_parentLPNLink_NameText_param_out']","XPATH").getText();
                   if (actualPallet.trim().equals(strPallet)) {
                         report.updateTestLog("iLPN Pallet Validation","Expected Pallet : "+strPallet+" || Actual Pallet : "+actualPallet, Status.PASS);
                   } else {
                         report.updateTestLog("iLPN Pallet Validation","Expected Pallet : "+strPallet+" || Actual Pallet : "+actualPallet, Status.FAIL);
                   }
            } catch (Exception e) {
                   report.updateTestLog("Element", "Element Not Found", Status.FAIL);

            }
     }

}
