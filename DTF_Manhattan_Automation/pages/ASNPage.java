package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class ASNPage extends AnyManhattanPage
{		

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public ASNPage(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		try{

		}catch(Exception e){
			report.updateTestLog("AnyManhattanPage-OBJECT IDENTIFICATION", "Error in finding Page Object/element : " + e.getMessage(), Status.FAIL);
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
	protected void initializeUIMap()
	{
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("ASNPage"))
			report.updateTestLog("ASN Page verification", "ASN loaded as expected.", Status.DONE);
		else
			report.updateTestLog("ASN Page verification", "ASN page loaded not loaded!!!!", Status.FAIL);
	}

	/**
	 * To use switch case we are declaring the below enum for MyAccount,Login,Logout,MiniCart 
	 */
	private enum enumPageObjects
	{
		ASN,ASNsBusinessPartner,ASNStatus,ASNNumber,lnkASNs,
		ASN_Header, ASNStatus_Header,ASNsBusinessPartner_Header, btnApply, ReceiptVariance_Header, BusinessUnit_Header, PickupFacility_Header, DeliveryFacility_Header, EstimatedDeliveryDate_Header, ShippedDate_Header, TotalShipped_Header, TotalReceived_Header, COGI_Header, Shipment_Header, btnView;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: ASN,ASNsBusinessPartner,ASNStatus,ASNNumber,lnkASNs,ASN_Header, ASNStatus_Header,ASNsBusinessPartner_Header, btnApply, ReceiptVariance_Header, BusinessUnit_Header, PickupFacility_Header, DeliveryFacility_Header, EstimatedDeliveryDate_Header, ShippedDate_Header, TotalShipped_Header, TotalReceived_Header, COGI_Header, Shipment_Header
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case ASNNumber:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@alt='Find ASN']", "XPATH");
				break;
			case ASN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td4_view", "ID");
				break;
			case ASNStatus:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td5_view", "ID");
				break;
			case ASNsBusinessPartner:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("dataForm:ASNList_entityListView:dataTable_body_tr0_td7_view", "ID");
				break;
			case lnkASNs:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'ASNs')]", "XPATH");
				break;		
			case ASN_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='ASN']", "XPATH");
				break;
			case ASNStatus_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Status']", "XPATH");
				break;
			case BusinessUnit_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Business Unit']", "XPATH");
				break;
			case ASNsBusinessPartner_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Business Partner']", "XPATH");
				break;
			case PickupFacility_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Pickup Facility']", "XPATH");
				break;
			case DeliveryFacility_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Delivery Facility']", "XPATH");
				break;
			case EstimatedDeliveryDate_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Estimated Delivery Date']", "XPATH");
				break;
			case ShippedDate_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Shipped Date']", "XPATH");
				break;
			case TotalShipped_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Total Shipped']", "XPATH");
				break;
			case TotalReceived_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Total Received']", "XPATH");
				break;
			case ReceiptVariance_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Receipt Variance']", "XPATH");
				break;
			case COGI_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='COGI']", "XPATH");
				break;
			case Shipment_Header:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Shipment']", "XPATH");
				break;
			case btnApply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(.//*[@value='Apply' and @title='Apply'])[1]", "XPATH");
				break;
			case btnView:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='View']", "XPATH");
				break;
			default:
				break;
			}
			report.updateTestLog("ASN- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("ASN- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}

	/**
	 *********************************************************************** 
	 * Function verifies any field
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree Venkatesan
	 * @param 	strFieldName, strValue
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyAnyFieldANDtextValue(String strFieldName,String strValue)
	{
		try{
			libManhattanCommonFunctions.verifyAndReportElementState(getPageElement(strFieldName), "CONTAINS-"+strValue, "Y", strFieldName);			
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 
	}

	/**
	 *********************************************************************** 
	 * Function validates ASN table headers
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree Venkatesan
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyASNTable(){
		try{

			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='ASN']", "XPATH", "ASN Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Status']", "XPATH", "Status Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Business Unit']", "XPATH", "Business Unit Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Business Partner']", "XPATH", "Business Partner Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Pickup Facility']", "XPATH", "Pickup Facility Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Delivery Facility']", "XPATH", "Delivery Facility Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Estimated Delivery Date']", "XPATH", "Estimated Delivery Date Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Shipped Date']", "XPATH", "Shipped Date Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Total Shipped']", "XPATH", "Total Shipped Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Total Received']", "XPATH", "Total Received Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Receipt Variance']", "XPATH", "Receipt Variance Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='COGI']", "XPATH", "COGI Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:ASNList_entityListView:dataTable']//span[text()='Shipment']", "XPATH", "Shipment Header");
		}catch(Exception e){

		}
	}

	/**
	 *********************************************************************** 
	 * Function enters ASN number in search box and clicks on apply button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree Venkatesan
	 * @param 	strASNsNumber
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterASNsNumber(String strASNNumber){
		try{
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ASNNumber"), strASNNumber, "ASNs Number");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");
			Thread.sleep(2000);
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 
	}

	/**
	 *********************************************************************** 
	 * Function validates ASN status
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree Venkatesan
	 * @param 	strStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyASNStatus(String strStatus){                                                                                     
		try{
			//strStatus="Receiving Verified";
			String actualStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ASNList_entityListView:dataTable:0:ASNStatusValueString']", "XPATH").getText();
			if(actualStatus.trim().equals(strStatus))
			{
				report.updateTestLog("ASN Status verification", "Actual Result : "+actualStatus+" is verified", Status.PASS);
			}else
			{
				report.updateTestLog("ASN status verification", "Actual Result : "+actualStatus +" Expected Result : "+strStatus, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}           
	}

	/**
	 *********************************************************************** 
	 * Function validates ASN status
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void ASNverification(){                                                                                     
		try{
			String actualStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ASNList_entityListView:dataTable:0:verificationAttempted_Txt']", "XPATH").getText();
			if(actualStatus.trim().equals("No"))
			{
				report.updateTestLog("ASN Status verification", "ASN is verified", Status.PASS);
			}else
			{
				report.updateTestLog("ASN status verification", "ASN not verified", Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}           
	}

	/**
	 *********************************************************************** 
	 * Function executes ASN functions for multiple ASN Numbers
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strASN,strASNStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void loopSearchiLPN(String strASN,String strASNStatus){
		try{
			if (strASN.contains(";")){
				int intLoop = 0;
				for (String strElement : strASN.split(";")){						
					enterASNsNumber(strElement);
					Thread.sleep(10000);
					String[] strStatus = strASNStatus.split(";");
					verifyASNTable();
					verifyASNStatus(strStatus[intLoop]);
					Thread.sleep(10000);
					intLoop = intLoop+1;
					driver.switchTo().defaultContent();
				}
			}

		}catch(Exception e){

		}
	}

	/**
	 *********************************************************************** 
	 * Function selects an ASN in the checkbox and clicks on View button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void ViewAsn()
	{
		try{
			libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:ASNList_entityListView:dataTable']","XPATH", " ASN CheckBox");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnView"), "View Button");
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}   
	}

}