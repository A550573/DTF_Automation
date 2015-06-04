package pages;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

/**
 * Any Manhattan Page class
 * 
 * @author Cognizant
 */
public class AnyManhattanPage extends MasterPage {
	/******************************* Declaration of objects for AnyManhattanPage **************************************/
	WebElement imgManhattanLogo;
	WebElement txtSearchbox;
	WebElement btnSearch, btnCheckout;
	WebElement optVariation;
	WebElement lnkViewShoppingBag;
	ManhattanCommonFunctions libManhattanCommonFunctions;

	/**
	 * Constructor to initialize the page
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link TestScript}
	 */

	public AnyManhattanPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try {


		} catch (Exception e) {
			report.updateTestLog("AnyManhattanPage-OBJECT IDENTIFICATION","Error in finding Page Object/element : " + e.getMessage(),Status.FAIL);
		}
	}

	@Override
	protected void initializeUIMap() {
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("AnyManhattanPage"))
			report.updateTestLog("Any Manhattan Page verification","Any Manhattan page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Any Manhattan Page verification","Any Manhattan page loaded not loaded!!!!", Status.FAIL);
	}

	/**
	 * To use switch case we are declaring the below enum for
	 * MyAccount,Login,Logout,MiniCart
	 */
	private enum enumPageObjects {
		Configuration, Distribution, contractManagement, LaborManagement, Integration, Tools;

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
			case Configuration:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("tab-1057-btnIconEl", "ID");
				break;
			case Distribution:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("tab-1058-btnIconEl", "ID");
				break;
			case contractManagement:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("tab-1059-btnIconEl", "ID");
				break;
			case LaborManagement:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("tab-1060-btnIconEl", "ID");
				break;
			case Integration:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("tab-1061-btnIconEl", "ID");
				break;
			case Tools:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("tab-1062-btnIconEl", "ID");
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

	public enum enumPageName {
		MenuPage, LoginPage, AnyManhattanPage, HomePage, YardSlotsPage, TrailersPage, DockDoorPage, TaskPage, YardTaskPage, LPNLockUnlockPage, iLPNPage, AppointmentPage, AddYardTaskPage, TrailerActivityTrailPage, oLPNPage, ShipmentsPage, WavesPage, DistributionOrderPage, PixTransactionPage, RunWavesPage, CycleCountsPage, ASNPage, RecallInventoryRulesPage, CheckinPage, iLPNDetailsPage, ActivityTrackingPage, AdjustInventoryPage, CheckinDetailsPage, RFMenuPage, PostMessagePage, CheckoutPage, PurchaseOrderPage, SortingZonesPage, LanePage, TariffPage, OrderDetailsPage, ManifestsPage, AddAppointmentPage, ShipConfirmRulesPage, AppointmentDetailsPage, CloseTrailerPage, CreateAsnFromPOPage, AsnDetailsPage, CloseShipmentListPage, WaveDetailsPage, ManifestedOLPNsPage, ItemInventoryPage, LPNBulkUpdatesPage, TaskEligibiltyGpPage, TaskPathDefnPage, ReportDefnPage, RunReportPage, EventsPage, ReportsPage, DistributionOrderDetailsPage, ItemInventoryByLocPage, PackWavePage;
	}

	public boolean getCurrentPage(String strPageName) {

		try {

			switch (enumPageName.valueOf(strPageName)) {
			case AnyManhattanPage:
				if (libManhattanCommonFunctions.getElementByProperty("//span[@id='button-1029-btnIconEl']","XPATH") != null)
					return true;
				break;
			case HomePage:
				if (libManhattanCommonFunctions.getElementByProperty("(//*[@show-ticker='true'])[1]/a/img", "XPATH") != null)
					return true;
				break;
			case LoginPage:
				Thread.sleep(4000);
				if ((driver.findElement(By.xpath("//label[contains(text(),'Supply Chain Optimization...Planning through Execution')]")) != null))
					return true;
				break;
			case MenuPage:                          
				libManhattanCommonFunctions.waitForElementVisibility(".//*[@class='x-btn-icon wt-home']", 2000);
				if (driver.findElement(By.xpath(".//*[@class='x-btn-icon wt-home']"))!= null)
					return true;
				break;
			case YardSlotsPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Yard Slots')]")) != null)
					return true;
				break;
			case AppointmentPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Appointments')]")) != null)
					return true;
				break;
			case AddYardTaskPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'New Yard Task')]")) != null)
					return true;
				break;
			case TrailerActivityTrailPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Trailer Activity Trail')]")) != null)
					return true;
				break;
			case ReportsPage:
				if (driver.findElement(By.xpath("//div[contains(text(),'SCI Reports Link')]")) != null)
					return true;
				break;
			case LPNLockUnlockPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Lock Unlock LPNs')]")) != null)
					return true;
				break;
			case iLPNPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'iLPNs')]")) != null)
					return true;
				break;
			case oLPNPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'oLPNs')]")) != null)
					return true;
				break;
			case ItemInventoryPage:
				if (driver.findElement(By.xpath("(//span[contains(text(),'Item Inventory')])[1]")) != null)
					return true;
				break;
			case LPNBulkUpdatesPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'LPN Bulk Updates')]")) != null)
					return true;
				break;
			case DistributionOrderPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Distribution Orders')]")) != null)
					return true;
				break;
			case PixTransactionPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'PIX Transactions')]")) != null)
					return true;
				break;
			case WavesPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Waves')]")) != null)
					return true;
				break;
			case RunWavesPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Run Waves')]")) != null)
					return true;
				break;
			case ShipmentsPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Shipments')]")) != null)
					return true;
				break;
			case CycleCountsPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Cycle Counts')]")) != null)
					return true;
			case YardTaskPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Yard Tasks')]")) != null)
					return true;
			case DockDoorPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Dock Door List')]")) != null)
					return true;
			case TaskPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Tasks')]")) != null)
					return true;
			case TrailersPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Trailers')]")) != null)
					return true;
			case ASNPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'ASNs')]")) != null)
					return true;
			case RecallInventoryRulesPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Recall Inventory Rules')]")) != null)
					return true;
			case CheckinPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Check-In')]")) != null)
					return true;
			case CheckinDetailsPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Check-In')]")) != null)
					return true;
			case CheckoutPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Check-Out')]")) != null)
					return true;
			case AdjustInventoryPage:
				//if (driver.findElement(By.xpath("//span[contains(text(),'Adjust Inventory')]")) != null)
				if (driver.findElement(By.xpath("//span[@id='screen-821191_header_hd-textEl']")) != null)
					return true;
			case iLPNDetailsPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'iLPN Details')]")) != null)
					return true;
			case PurchaseOrderPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Purchase Orders')]")) != null)
					return true;
			case SortingZonesPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Sorting Zones')]")) != null)
					return true;
			case ActivityTrackingPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Activity Tracking')]")) != null)
					return true;
			case RFMenuPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'RF Menu')]")) != null)
					return true;			
			case PostMessagePage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Post Message')]")) != null)
					return true;
			case LanePage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Lane')]")) != null)
					return true;
				//				if(driver.getCurrentUrl().contains("manh"))
				//				return true;
			case TariffPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Tariff')]")) != null)
					return true;
			case OrderDetailsPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Order Details')]")) != null)
					return true;
			case ManifestsPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Manifests')]")) != null)
					return true;
				break;
			case AddAppointmentPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Add Appointment')]")) != null)
					return true;
				break;	
			case ShipConfirmRulesPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Ship Confirm Rules')]")) != null)
					return true;
				break;
			case AppointmentDetailsPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Appointment Details')]")) != null)
					return true;
				break;
			case CloseTrailerPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Close Trailer')]")) != null)
					return true;
				break;
			case CreateAsnFromPOPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Create ASN from PO')]")) != null)
					return true;
				break;
			case AsnDetailsPage:
				if (driver.findElement(By.xpath("//span[@id='screen-1011206_header_hd-textEl']")) != null)
					return true;
			case CloseShipmentListPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Close Shipment List')]")) != null)
					return true;
			case WaveDetailsPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Wave Details')]")) != null)
					return true;
			case ManifestedOLPNsPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Manifested oLPNs')]")) != null)
					return true;
			case TaskEligibiltyGpPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Task Group Eligibility')]")) != null)
					return true;
				break;
			case TaskPathDefnPage:
				if (driver.findElement(By.xpath("(//span[contains(text(),'Task Path Definition')])[1]")) != null)
					return true;
				break;
			case DistributionOrderDetailsPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Distribution Order Details')]")) != null)
					return true;
				break;
			case ReportDefnPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Report Definitions')]")) != null)
					return true;
				break;
			case RunReportPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Run report')]")) != null)
					return true;
				break;
			case EventsPage:
				if (driver.findElement(By.xpath("(//span[contains(text(),'Events')])[8]")) != null)
					return true;
				break;
			case ItemInventoryByLocPage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Item Inventory by Location')]")) != null)
					return true;
				break;
			case PackWavePage:
				if (driver.findElement(By.xpath("//span[contains(text(),'Pack Wave')]")) != null)
					return true;
				break;
			default:
				break;
			}
		} catch (Exception e) {
			return false;
		}
		return false;

	}

	/**
	 ************************************************************* 
	 * Function to click window maximize button
	 * @return Nothing is returned as of now
	 * @Author Yagna Priya
	 * @param none
	 * @version 1.0
	 ************************************************************* 
	 */
	public void clickWindowMaximize() {
		try {
			List<WebElement> listWindow = libManhattanCommonFunctions.getElementsByProperty("x-tool-maximize", "CLASS");
			libManhattanCommonFunctions.clickAnyElement(listWindow.get(listWindow.size() - 1), "Maximize Button");
			Thread.sleep(2000);
		} catch (Exception e) {
			report.updateTestLog("Menu Page","Maximize Button Element Not Found", Status.FAIL);
		}
	}

	/**
	 ************************************************************* 
	 * Function to click the close window button
	 * @return Nothing is returned as of now
	 * @Author Yagna Priya
	 * @param none
	 * @version 1.0
	 ************************************************************* 
	 */
	public void closeWindow() {
		try {
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("(//img[@class='x-tool-close'])[2]")).click();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 ************************************************************* 
	 * Function to click the refresh window button
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
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 ************************************************************* 
	 * Function to launch new browser
	 * @return Nothing is returned as of now
	 * @Author Yagna Priya
	 * @param strUrl
	 * @version 1.0
	 ************************************************************* 
	 */
	public void launchBrowser(String strUrl) {
		try {
			driver.get(strUrl);
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	/**
	 ************************************************************* 
	 * Function to click the close window button
	 * 
	 * @return Nothing is returned as of now
	 * @Author Yagna Priya
	 * @param none
	 * @version 1.0
	 ************************************************************* 
	 */
	public void signOut() {
		try {
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//*[@class='x-btn-icon wt-user']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'Sign out')]")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function splits the string into array.
	 * @return 	strTaskId 
	 * @Author  Rahman
	 * @param 	None
	 * @version 1.0
	 * @throws 	Exception 
	 ***********************************************************************
	 */
	//	@SuppressWarnings("null")
	public String[] splitDataValues(String strDataValue) throws Exception
	{		
		int distinct=0;		
		for (int i = 0; i < strDataValue.length(); i++) {	       
			if(strDataValue.charAt(i)==(';'))
			{	                
				distinct++;
			}
		} 
		String strMultipleValues[] = new String[distinct+1];
		if (strDataValue.contains(";")){
			Thread.sleep(3000);
			strMultipleValues = strDataValue.split(";");
		}
		else{
			strMultipleValues[0]=strDataValue;
		}
		return strMultipleValues;
	}
	
	/**

     *********************************************************************** 

     * Function splits the string into array.

     * @return      strTaskId 

     * @Author  Rahman

     * @param       None

     * @version 1.0

     * @throws      Exception 

     ***********************************************************************

     */

    //      @SuppressWarnings("null")

    public String[] splitDataValuesWithComa(String strDataValue) throws Exception
    {                                       
            int distinct=0;         
            for (int i = 0; i < strDataValue.length(); i++) {              
                    if(strDataValue.charAt(i)==(','))
                    {                       
                            distinct++;
                    }
            } 
            String strMultipleValues[] = new String[distinct+1];
            if (strDataValue.contains(",")){
                    Thread.sleep(3000);
                    strMultipleValues = strDataValue.split(",");
            }
            else{
                    strMultipleValues[0]=strDataValue;
            }
            return strMultipleValues;
    }



}
