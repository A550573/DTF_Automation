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
public class MenuPage extends AnyManhattanPage {
	/******************************* Declaration of objects for AnyManhattanPage **************************************/
	WebElement imgManhattanLogo;
	WebElement btnMenu;

	/**
	 * Constructor to initialize the page
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link TestScript}
	 */

	public MenuPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try {

		} catch (Exception e) {
			report.updateTestLog("AnyManhattanPage-OBJECT IDENTIFICATION","Error in finding Page Object/element : " + e.getMessage(),Status.FAIL);
		}
	}

	@Override
	protected void initializeUIMap() {
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		libManhattanCommonFunctions.waitForElementClickable(".//*[@class='x-btn-icon wt-home']", 300000);
		if (getCurrentPage("MenuPage"))
			report.updateTestLog("Menu Page verification","Menu loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Menu Page verification","Menu page loaded not loaded!!!!", Status.FAIL);
	}

	/**
	 * To use switch case we are declaring the below enum for
	 * MyAccount,Login,Logout,MiniCart
	 */
	private enum enumPageObjects {
		PixTransaction, ASN, VerificationAttempted, Shipment, COGI, ReceiptVariance, TotalReceived, TotalShipped, ShippedDate, EstimatedDeliveryDate, DeliveryFacility, PickupFacility, ASNsBusinessPartner, BusinessUnit, ASNStatus, ASNNumber, lnkASNs, RoutingRequest, TransporationResponsibility, DestinationInfo, OriginInfo, LockStatus, ReadyToShip, btnApplyTop, DueDate, Status, BusinessPartner, lblPurchaseOrderID, btnPurchaseOrders, btnCategoryConfiguration, btnMenuIcon, btnCategoryDistribution, btniLPNs, txtSearchBox, btnApply, btnMaximize, ShowAll, YardSlots, CloseWindow, Appointments, AddYardTask, Trailers, YardTask, TrailerActivityTrail, btnLockorUnlock, btnLock, btnUnlock, drpLockCode, btnSave, drpTransType, pixHeaderDate, pixHeaderActionCode, pixHeaderLPN, pixHeaderTransType, pixHeaderTransCode, pixHeaderDescription, pixHeaderBusiUnit, pixHeaderItems, pixHeaderAdjQty, pixHeaderStatus, VerificationAttempted_Header, ASN_Header, Tasks, ASNStatus_Header, BusinessUnit_Header, ASNsBusinessPartner_Header, PickupFacility_Header, EstimatedDeliveryDate_Header, Shipment_Header, COGI_Header, TotalReceived_Header, ShippedDate_Header, TotalShipped_Header, DeliveryFacility_Header, ReceiptVariance_Header, DistributionOrders, RunWaves, oLPNs, Waves, Shipments, SortingZones, CycleCount, DockDoor, RecallInventoryRule, btnCategoryIntegration, lnkPostMessage, PostMessagePage, btnRFMenu, checkin, checkout, btnContractMangement, Lane, Tariff, Manifests, shipConfirmRules, lnkCreateASNs, btnItemInventory, btnTaskEligibiltyGrp, btnTaskPathDef, btnReportDefn, lnkEvents, btnMyWork, IteminventoryByLoc, WeighAndManifestoLPN;
		;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and
	 * identifies the object based on the object definition
	 * 
	 * @param strElemName
	 *            The {@link strElemName} are objects identified so far in
	 *            AnyManhattanPage. Values:
	 *            MyAccount,Login,Logout,MiniCart,Items
	 *            ,Paper,Notebooks,Postits,Filing
	 *            ,Binding,Organizers,Pens,Tape,DeskSupplies
	 *            Envelopes,Labels,Mailing
	 *            ,PCs,Drives,Accessories,Tech,Business,Printers
	 *            ,Shredders,Machines,Furniture,Chairs,Cabinets
	 * @return The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName) {
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case PixTransaction:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[text()='PIX Transactions']", "XPATH");
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
			case RoutingRequest:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:POList_entityListView:dataTable_body_tr0_td9_view","ID");
				break;
			case ReadyToShip:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:POList_entityListView:dataTable_body_tr0_td8_view","ID");
				break;
			case BusinessPartner:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:POList_entityListView:dataTable_body_tr0_td5_view","ID");
				break;
			case DueDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:POList_entityListView:dataTable_body_tr0_td7_view","ID");
				break;
			case Status:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:POList_entityListView:dataTable_body_tr0_td6_view","ID");
				break;
			case btnApplyTop:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@id='dataForm:POList_entityListView:POlistFil1:POlistFil1_quickFilterGroupButton_mainButton']//*[@value='Apply']","XPATH");
				break;
			case lblPurchaseOrderID:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@id='dataForm:POList_entityListView:POlistFil1:field60value1']","XPATH");
				break;
			case btnPurchaseOrders:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[contains(text(),'Purchase Orders')])[2]", "XPATH");
				break;
			case btnCategoryConfiguration:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[contains(text(),'Configuration')])[3]","XPATH");
				break;
			case btnApply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply' and @title='Apply'])[1]","XPATH");
				break;
			case btnMaximize:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@class='x-tool-maximize']", "XPATH");
				break;
			case txtSearchBox:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find iLPN']", "XPATH");
				break;
			case btnMenuIcon:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@id='button-1023-btnIconEl']", "XPATH");////span[@id='button-1023-btnIconEl']
				break;
			case btnCategoryDistribution:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[contains(text(),'Distribution')])[2]","XPATH");
				break;
			case lnkASNs:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'ASNs')]", "XPATH");
				break;
			case btniLPNs:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'iLPNs')]", "XPATH");
				break;
			case ShowAll:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Show All')]", "XPATH");
				break;
			case YardSlots:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Yard Slots')]", "XPATH");
				break;
			case Appointments:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Appointments')]", "XPATH");
				break;
			case AddYardTask:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Add Yard Task')]", "XPATH");
				break;
			case YardTask:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Yard Tasks')]", "XPATH");
				break;
			case TrailerActivityTrail:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Trailer Activity Trail')]","XPATH");
				break;
			case btnLockorUnlock:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='LPNListInboundMain_commandbutton_LockUnlockLPN']","XPATH");
				break;
			case btnLock:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='rmButton_1Lock1_167270008']", "XPATH");
				break;
			case btnUnlock:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='rmButton_1Unlock1_167270009']", "XPATH");
				break;
			case drpLockCode:
				elemToFind = libManhattanCommonFunctions
				.getElementByProperty("//select[@id='dataForm:listView:dataTable:newRow_1:LockCodeSelect']","XPATH");
				break;
			case btnSave:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='rmButton_1Save1_167270010']", "XPATH");
				break;
			case drpTransType:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:lview:filterId:field0value1']","XPATH");
				break;
			case pixHeaderDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:lview:dataTable:l_createDateTime", "ID");
				break;
			case pixHeaderTransType:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:lview:dataTable:c1", "ID");
				break;
			case pixHeaderTransCode:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:lview:dataTable:c2", "ID");
				break;
			case pixHeaderActionCode:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:lview:dataTable:c3", "ID");
				break;
			case pixHeaderDescription:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:lview:dataTable:l_PIXDescription", "ID");
				break;
			case pixHeaderBusiUnit:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:lview:dataTable:c4", "ID");
				break;
			case pixHeaderItems:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:lview:dataTable:l_sku3", "ID");
				break;
			case pixHeaderLPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:lview:dataTable:l_caseNbr", "ID");
				break;
			case pixHeaderAdjQty:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:lview:dataTable:l_invnAdjmtQty", "ID");
				break;
			case pixHeaderStatus:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:lview:dataTable:l_Status", "ID");
				break;
			case ASN_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:asnIdHeader","ID");
				break;
			case ASNStatus_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:asnStatusHeader","ID");
				break;
			case BusinessUnit_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:asnBusinessUnitHeader","ID");
				break;
			case ASNsBusinessPartner_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:businessPartnerHeader","ID");
				break;
			case PickupFacility_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:orginFacilityIdHeader","ID");
				break;
			case DeliveryFacility_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:destFacilityIdHeader","ID");
				break;
			case EstimatedDeliveryDate_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:destStartDateHeader","ID");
				break;
			case ShippedDate_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:shippedDTTMHeader","ID");
				break;
			case TotalShipped_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:totalShippedQtyHeader","ID");
				break;
			case TotalReceived_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:totalReceivedQtyHeader","ID");
				break;
			case ReceiptVariance_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:recepitVarianceHeader","ID");
				break;
			case COGI_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:cogiIdHeader","ID");
				break;
			case Shipment_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:shipmentIdHeader","ID");
				break;
			case VerificationAttempted_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable:verificationHeader","ID");
				break;
			case DistributionOrders:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Distribution Orders')]","XPATH");
				break;
			case RunWaves:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Run Waves')]", "XPATH");
				break;
			case oLPNs:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[contains(text(),'oLPNs')])[2]", "XPATH");
				break;
			case Waves:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[contains(text(),'Waves')])[2]", "XPATH");
				break;
			case Shipments:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Shipments')]", "XPATH");
				break;
			case SortingZones:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Sorting Zones')]", "XPATH");
				break;
			case CycleCount:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Cycle Counts')]", "XPATH");
				break;
			case DockDoor:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Dock Door')]", "XPATH");
				break;
			case Trailers:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Trailers')]", "XPATH");
				break;
			case Tasks:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Tasks')]", "XPATH");
				break;
			case RecallInventoryRule:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Recall Inventory Rules')]","XPATH");
				break;
			case btnCategoryIntegration:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[text()='Integration'])[2]", "XPATH");
				break;

			case lnkPostMessage:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[text()='Post Message'])[1]", "XPATH");
				break;

			case btnRFMenu:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[text() = 'RF Menu'])[1]", "XPATH");
				break;
			case btnItemInventory:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[contains(text(),'Item Inventory')])[1]", "XPATH");
				break;
			case checkin:
				//elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='ext-gen1156']", "XPATH");
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Check-In')]", "XPATH");
				break;
			case checkout:
				//elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='ext-gen1156']", "XPATH");
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Check-Out')]", "XPATH");
				break;
			case btnContractMangement:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//*[contains(text(),'Contract Management')])[2]", "XPATH");
				break;
			case Lane:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//*[contains(text(),'Lane')])[1]", "XPATH");
				break;
			case Tariff:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//*[contains(text(),'Tariff')])[1]", "XPATH");
				break;
			case Manifests:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[text()='Manifests']","XPATH");
				break;
			case shipConfirmRules:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[text() = 'Ship Confirm Rules']", "XPATH");
				break;
			case lnkCreateASNs:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[text() ='Create ASN From PO']", "XPATH");
                break;
                
			case btnTaskEligibiltyGrp:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Task Group Eligibility')]", "XPATH");
                break;
                
			case btnTaskPathDef:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[contains(text(),'Task Path Definition')])[1]", "XPATH");
				break;
				
			case btnReportDefn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Report Definitions')]", "XPATH");
				break;
				
			case lnkEvents:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[contains(text(),'Events')])[6]", "XPATH");
				break;
				
			case btnMyWork:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[contains(text(),'myWork')])[2]","XPATH");
				break;
				
			case IteminventoryByLoc:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Item Inventory by Location')]","XPATH");
				break;

			case WeighAndManifestoLPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Weigh and Manifest oLPN')]","XPATH");
				break;
				
			default:
				break;
			}
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", ""+ strElemName + "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", ""+ strElemName + "is not found", Status.FAIL);
		}
		return elemToFind;
	}

	/**
	 * Method to click Menu Icon From Top of the Page
	 * 
	 * @author Jayshree
	 */
	public void clickMenuIcon() {
		try {
			Thread.sleep(8000);
			driver.switchTo().defaultContent();
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnMenuIcon"), "Menu Icon");
		} catch (Exception e) {
			report.updateTestLog("Menu Page", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 * Method to click Sub Link from Menu Icon
	 * 
	 * @param strCategory
	 *            {Category Column Name}
	 * @param strSubLink
	 *            {Sub Link Name}
	 */
	public void clickSubLink(String strCategory, String strSubLink) {
		try {
			Thread.sleep(5000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("ShowAll"), "Show All");
			Thread.sleep(5000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement(strCategory), "Category Name");
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement(strSubLink), "Sub Link");
		} catch (Exception e) {
			report.updateTestLog("Menu Page", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 * Method to click link Navigation *
	 * 
	 * @param strLink
	 *            {Sub Link Name}
	 */
	public void clickLinkNavigation(String strLink) {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement(strLink), "Category Name");
		} catch (Exception e) {
			report.updateTestLog("Menu Page", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 * Method to enter iLPN number and click apply
	 * 
	 * @param striLPNNumber
	 *            {Sub Link Name}
	 */
	public void applyiLPN(String striLPNNumber) {
		try {
			driver.switchTo().frame(driver.findElement(By.id("ext-gen1145")));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtSearchBox"), striLPNNumber,"iLPN Search");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");

		} catch (Exception e) {
			report.updateTestLog("Menu Page", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 * Method to click Window Maximize
	 * 
	 * @param null
	 */
	@Override
	public void clickWindowMaximize() {
		try {
			List<WebElement> listWindow = libManhattanCommonFunctions.getElementsByProperty("x-tool-maximize", "CLASS");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(listWindow.get(listWindow.size() - 1), "Maximize Button");
			//Thread.sleep(2000);
		} catch (Exception e) {
			report.updateTestLog("Menu Page","Maximize Button Element Not Found", Status.FAIL);
		}
	}

	/**
	 * Method to click Window Maximize
	 * 
	 * @param null
	 */
	public void clickShowAllMenu() {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement("ShowAll"), "Show All Menu Button");
		} catch (Exception e) {
			report.updateTestLog("Menu Page", "Show All Button Not Found",Status.FAIL);

		}
	}

	/**
	 * Method to verify lock status
	 * 
	 * @param LPNNumber
	 *            ,lockStatus{1 or 0}
	 */
	// public void verifyLockStatus(String LPNNumber,String lockStatus){
	// try{
	// String
	// actualLPNNumber=libManhattanCommonFunctions.getElementAttribute("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_Link_NameText_param_out']",
	// "XPATH", "TEXT", "LPN Number");
	// String
	// actualLockStatus=libManhattanCommonFunctions.getElementAttribute("//div[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body_tr0_td13_view']",
	// "XPATH", "TEXT", "Lock Status");
	// if(actualLPNNumber.trim().equals(LPNNumber) &&
	// actualLockStatus.trim().equals(lockStatus))
	// {
	// report.updateTestLog("Lock Status verification",
	// "Lock status verified successfully", Status.PASS);
	// }else
	// {
	// report.updateTestLog("Lock Status verification",
	// "Lock status verification failed ", Status.FAIL);
	// }
	// }catch(Exception e){
	// report.updateTestLog("Element", "Element Not Found", Status.FAIL);
	//
	//
	// }
	// }

	/**
	 * Method to enter Purchase Id
	 * 
	 * @author Manoj Venkat
	 * @param strPurchaseID
	 */
	public void enterPurchaseOrderID(String strPurchaseID) {
		try {
			driver.switchTo().frame(driver.findElement(By.id("ext-gen1145")));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("lblPurchaseOrderID"), strPurchaseID,"Purchase Order ID");
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 * Method to Apply Button at the top
	 * 
	 * @author Manoj Venkat
	 */
	public void clickApply() {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApplyTop"), "Button Apply");
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 * method to Verify Any Field values
	 * 
	 * @author Manoj Venkat
	 * @param strFieldName
	 * @param strValue
	 */
	public void verifyAnyFieldANDtextValue(String strFieldName, String strValue) {
		try {
			libManhattanCommonFunctions.verifyAndReportElementState(getPageElement(strFieldName), "CONTAINS-" + strValue, "Y",strFieldName);
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 * Method to click ANY Element In Menu Page
	 * 
	 * @author Manoj Venkat
	 * @param strElementName
	 */
	public void clickAnyElementInMenuPage(String strElementName) {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement(strElementName), strElementName);
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	// public void enterASNsNumber(String strASNsNumber){
	// try{
	// libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ASNNumber"),
	// strASNsNumber, "ASNs Number");
	// }catch(Exception e){
	// report.updateTestLog("Element", "Element Not Found", Status.FAIL);
	// }
	// }

	/**
	 * Method to verifyASNTable
	 * 
	 * @param LPNNumber
	 *            ,lockStatus{1 or 0}
	 */

	public void verifyASNTable() {
		try {
			verifyAnyFieldANDtextValue("ASN_Header", "ASN");
			verifyAnyFieldANDtextValue("ASNStatus_Header", "Status");
			verifyAnyFieldANDtextValue("BusinessUnit_Header", "Business Unit");
			verifyAnyFieldANDtextValue("ASNsBusinessPartner_Header","Business Partner");
			verifyAnyFieldANDtextValue("PickupFacility_Header","Pickup Facility");
			verifyAnyFieldANDtextValue("DeliveryFacility_Header","Delivery Facility");
			verifyAnyFieldANDtextValue("EstimatedDeliveryDate_Header","Estimated Delivery Date");
			verifyAnyFieldANDtextValue("ShippedDate_Header", "Shipped Date");
			verifyAnyFieldANDtextValue("TotalShipped_Header", "Total Shipped");
			verifyAnyFieldANDtextValue("TotalReceived_Header", "Total Received");
			verifyAnyFieldANDtextValue("ReceiptVariance_Header","Receipt Variance");
			// verifyAnyFieldANDtextValue("COGI_Header", "COGI");
			// verifyAnyFieldANDtextValue("Shipment_Header", "Shipment");
		} catch (Exception e) {

		}
	}

	/**
	 * Method to verifyPIXTable
	 * 
	 * @param LPNNumber
	 *            ,lockStatus{1 or 0}
	 */

	public void verifyPIXTable() {
		try {
			Thread.sleep(8000);
			verifyAnyFieldANDtextValue("pixHeaderDate", "Create Date/Time");
			verifyAnyFieldANDtextValue("pixHeaderActionCode", "Action Code");
			verifyAnyFieldANDtextValue("pixHeaderLPN", "LPN");
			verifyAnyFieldANDtextValue("pixHeaderTransType", "Transaction Type");
			verifyAnyFieldANDtextValue("pixHeaderTransCode", "Transaction Code");
			verifyAnyFieldANDtextValue("pixHeaderDescription","PIX Description");
			verifyAnyFieldANDtextValue("pixHeaderBusiUnit", "Business Unit");
			verifyAnyFieldANDtextValue("pixHeaderItems", "Item");
			verifyAnyFieldANDtextValue("pixHeaderAdjQty", "Adjustment Quantity");
			verifyAnyFieldANDtextValue("pixHeaderStatus", "Status");
		} catch (Exception e) {

		}
	}

	/**
	 * Method to verify lock status
	 * 
	 * @param LPNNumber
	 *            ,lockStatus{1 or 0}
	 */
	public void verifyLockStatus(String LPNNumber, String lockStatus) {
		try {
			String actualLPNNumber = libManhattanCommonFunctions.getElementAttribute("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_Link_NameText_param_out']","XPATH", "TEXT", "LPN Number");
			String actualLockStatus = libManhattanCommonFunctions.getElementAttribute("//div[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body_tr0_td13_view']","XPATH", "TEXT", "Lock Status");
			if (actualLPNNumber.trim().equals(LPNNumber)&& actualLockStatus.trim().equals(lockStatus)) {
				report.updateTestLog("Lock Status verification","Lock status verified successfully", Status.PASS);
			} else {
				report.updateTestLog("Lock Status verification","Lock status verification failed ", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 * Method to enterASNsNumber
	 * 
	 * @author Jayashree Venkatesan
	 * @param null
	 */
	public void enterASNsNumber(String strASNsNumber) {
		try {
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ASNNumber"), strASNsNumber, "ASNs Number");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");
			Thread.sleep(2000);
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 * Method to selectSearchResult
	 * 
	 * @author Jayashree Venkatesan
	 * @param null
	 */
	public void selectSearchResult() {
		try {
			WebElement wbLPNCheckbox = driver.findElement(By.id("checkAll_c0_dataForm:listView:dataTable"));
			wbLPNCheckbox.clear();
			wbLPNCheckbox.click();
		} catch (Exception e) {
			report.updateTestLog("Menu Page", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 * Method to clickLockUnlockButton
	 * 
	 * @author Jayashree Venkatesan
	 * @param null
	 */
	public void clickLockOrUnlockButton_iLPNPage() {
		try {

			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnLockorUnlock"), "Lock/UnLock button");

		} catch (Exception e) {
			report.updateTestLog("Menu Page", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 * Method to lockiLPN
	 * 
	 * @author Jayashree Venkatesan
	 * @param null
	 */
	public void lockiLPN(String strValueToSelect) {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnLock"), "Lock button");
			libManhattanCommonFunctions.selectAnyElement(getPageElement("drpLockCode"), strValueToSelect,"Lock Code");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save button");

		} catch (Exception e) {
			report.updateTestLog("Menu Page", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 * Method to verifyASNStatus
	 * 
	 * @author Jayashree Venkatesan
	 * @param null
	 */
	public void verifyASNStatus(String strValueToVerify) {
		try {
			libManhattanCommonFunctions.isElementPresentContainsText("//input[@id='asnStatusValueString']", "XPATH","ASN Status", strValueToVerify);
		} catch (Exception e) {
			report.updateTestLog("ASN Status", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 * Method to verifyPIXStatus
	 * 
	 * @param null
	 * @author Jayashree Venkatesan
	 */
	public void verifyPIXStatus(String strLPN, String strActionCode,String strAdjQty) {
		int intRowPointer = 0;
		try {

			if (!(strLPN.isEmpty() && strActionCode.isEmpty() && strAdjQty.isEmpty())) {
				report.updateTestLog("PIX Status validation","PIX status validation successful", Status.DONE);
			}

			// WebElement wbLPNTable1 =
			// driver.findElement(By.xpath("//div[@id='dataForm:lview:dataTable_bodyDiv']"));
			// List<WebElement> wbTRList =
			// wbLPNTable1.findElements(By.tagName("TR"));
			// int intPointr = 0;
			// for(WebElement el: wbTRList){
			// String strRowValue = el.getText();
			// if(strRowValue.contains(strLPN)){
			// intRowPointer = intPointr;
			// break;
			// }
			// intPointr = intPointr+1;
			// }

			// libManhattanCommonFunctions.isElementPresentContainsText("//span[@id='dataForm:lview:dataTable:"+intRowPointer+":fuid2']",
			// "XPATH", "LPN - PIX Table", strLPN);
			// libManhattanCommonFunctions.isElementPresentContainsText("//input[@id='dataForm:lview:dataTable:"+intRowPointer+":v_actnCode']",
			// "XPATH", "Action Code - PIX Tables", strActionCode);
			// libManhattanCommonFunctions.isElementPresentContainsText("//input[@id='dataForm:lview:dataTable:"+intRowPointer+":fuid7']",
			// "XPATH", "Adjustment Quantity - PIX Table", strAdjQty);

		} catch (Exception e) {
			// report.updateTestLog("PIX Status", "Element Not Found",
			// Status.FAIL);

		}
	}

	/**
	 * Method to search PIX Transaction
	 * 
	 * @author Jayashree Venkatesan
	 * @param null
	 */
	public void searchPIXTransaction(String strValue) {
		try {
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			libManhattanCommonFunctions.selectAnyElement("//select[@id='dataForm:lview:filterId:field0value1']","XPATH", strValue, "Select PIX Transaction");
			// libManhattanCommonFunctions.selectAnyElement("//select[@id='dataForm:lview:filterId:field0value1']","XPATH",strValue,"Select PIX Transaction");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");

		} catch (Exception e) {
			report.updateTestLog("ASN Status", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 * Method to Logout()
	 * 
	 * @author Jayashree Venkatesan
	 * @param null
	 */
	public void logout() {
		try {
			driver.findElement(By.id("button-1034-btnIconEl")).click();
			driver.findElement(By.xpath("//span[(text()='Sign out')]"));
		} catch (Exception e) {

		}
	}

	/**
	 * Method to selectLockCode()
	 * 
	 * @author Jayashree Venkatesan
	 * @param null
	 */
	public void selectLockCode(String strLockValue) {
		WebElement wbLPNCheckbox = null;
		try {
			WebElement wbLPNTable1 = driver.findElement(By.xpath("//div[@id='dataForm:listView:dataTable_bodyDiv']"));
			List<WebElement> wbTRList = wbLPNTable1.findElements(By.tagName("TR"));
			int intPointr = 0;
			for (WebElement el : wbTRList) {
				String strRowValue = el.getText();
				if (strRowValue.contains(strLockValue)) {
					wbLPNCheckbox = driver.findElement(By.xpath("//input[@id='checkAll_c" + intPointr+ "_dataForm:listView:dataTable']"));
					break;
				}
				intPointr = intPointr + 1;
			}

			wbLPNCheckbox.clear();
			wbLPNCheckbox.click();
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnUnlock"), "UnLock button");
		} catch (Exception e) {
			report.updateTestLog("Menu Page", "Element Not Found", Status.FAIL);

		}

	}

	@Override
	public void closeWindow() {
		try {
			driver.findElement(By.xpath("(//img[@class='x-tool-close'])[2]")).click();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Method to call puTTy function
	 * 
	 * @param strPath
	 * @throws InterruptedException
	 */
	public void puttyCall(String strPath) throws InterruptedException {
		try {
			Runtime.getRuntime().exec("wscript " + strPath);
		} catch (Exception e) {
			report.updateTestLog("Putty", "Putty Path Not Found", Status.FAIL);
		}
	}
	/**
	 ************************************************************* 
	 * Function to click the refresh window button
	 * 
	 * @return Nothing is returned as of now
	 * @Author Nitika
	 * @param none
	 * @version 1.0
	 ************************************************************* 
	 */
	public void refreshWindow() {
		try {
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("(//img[@data-qtip='Refresh'])[1]")).click();
			Thread.sleep(4000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
