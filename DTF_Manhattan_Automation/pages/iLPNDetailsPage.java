package pages;

import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class iLPNDetailsPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public iLPNDetailsPage(ScriptHelper scriptHelper) {
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
	protected void initializeUIMap() {
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("iLPNDetailsPage"))
			report.updateTestLog("iLPN Deatils verification","iLPN loaded as expected.", Status.DONE);
		else
			report.updateTestLog("iLPN verification","iLPN loaded not loaded!!!!", Status.FAIL);
	}

	public enum enumPageObjects {
		btnHeader, btnLocks
	}
	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: btnHeader, btnLocks
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName) {
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case btnHeader:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='LPN_Header_Tab_lnk']", "XPATH");
				break;
			case btnLocks:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='LPN_Locks_Tab_lnk']", "XPATH");
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
	 *********************************************************************** 
	 * Function validates the reason code for ilpn adjustments
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strReasonCode
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateRefernceFrame(String strReasonCode) {
		try {
			String actualReasonCode = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:rsn']", "XPATH").getText();
			if (actualReasonCode.trim().equals(strReasonCode)) {
				report.updateTestLog("Refernce Frame verification","Expected Reason Code : " + strReasonCode+ "is verified", Status.PASS);
			} else {
				report.updateTestLog("Refernce Frame","Expected Reason Code : " + strReasonCode+ "  Actual  Reason Code : " + actualReasonCode,Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function validates the ILPN current and destination locations.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strFromLocation,strToLocation
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateiLPNLocationDetails(String strFromLocation,String strToLocation) {
		try {

			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnHeader"), "Header Button");
			String stractualFromLocation = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ViewLPNInbound_Header_PreviousLocation_Text']","XPATH").getText();
			String stractualToLocation = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ViewLPNInbound_Header_CurrentLocation_Text']","XPATH").getText();
			if (stractualFromLocation.trim().equals(strFromLocation.trim())&& stractualToLocation.trim().equals(strToLocation.trim())) {
				report.updateTestLog("iLPN Location details verification","Expected From Location : " + strFromLocation+ " Actual From Location : "+ stractualFromLocation+ " Expected To Location : " + strToLocation+ " Actual To Location : "+ stractualToLocation, Status.PASS);
			} else {
				report.updateTestLog("iLPN Location details verification","Expected From Location : " + strFromLocation+ " Actual From Location : "+ stractualFromLocation+ " Expected To Location : " + strToLocation+ " Actual To Location : "+ stractualToLocation, Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function validates the lock status in ILPN details page
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strLockcode
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateiLPNLockCode(String strLockCode) {
		try {
			libManhattanCommonFunctions.waitForElementClickable("//*[@name='LPN_Locks_Tab']", 5000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnLocks"), "Locks Button");
			Thread.sleep(4000);
			//strLockCode = "First Receipt";
			if (strLockCode.contains(";")) {
				int intLoop = 0,i =0;
				for (String strElement : strLockCode.split(";")) {
					String strActualLockCode = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lockTable:"+i+":ViewLPNLocksList_LockCode_out']","XPATH").getText();
					if (strActualLockCode.trim().equals(strElement)) {
						report.updateTestLog("iLPN Lock Code verification","Expected Lock Code : " + strElement+ " Actual Lock code: " + strActualLockCode,Status.PASS);
					} else {
						report.updateTestLog("iLPN Location details verification","Expected Lock Code : " + strElement+ " Actual Lock code : " + strActualLockCode,Status.FAIL);
					}
					Thread.sleep(10000);
					intLoop = intLoop + 1;
					i = i + 1;
				}
			}
			else{
				String stractualLockCode = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lockTable:0:ViewLPNLocksList_LockCode_out']","XPATH").getText();
				if (stractualLockCode.trim().equals(strLockCode.trim())) {
					report.updateTestLog("iLPN Lock Code verification","Actual Lock code: " + stractualLockCode+ " is verified",Status.PASS);
				} else {
					report.updateTestLog("iLPN Location details verification","Expected Lock Code : " + strLockCode+ " Actual Lock code : " + stractualLockCode,Status.FAIL);
				}
			}

		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function validates the lock status in ILPN details page
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	striLPN,strASN,strLPNStatus,strCurrentLocation,strPallet
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateiLPNHeaderPage(String striLPN,String strASN, String strLPNStatus,String strCurrentLocation,String strPallet) {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnHeader"), "Header Button");
			String stractualiLPN = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNCommonHeader_LPNId_outputText']","XPATH").getText();
			String stractualASN = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNCommonHeader_ASN_param_out']","XPATH").getText();
			String stractualLPNStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNCommonHeader_LPNFacilityStatus_outputText']","XPATH").getText();
			String stractualCurrentLocation = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ViewLPNInbound_Header_CurrentLocation_Text']","XPATH").getText();
			String stractualPallet = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ViewLPNHeader_ParentLpnId_outputText']","XPATH").getText();
			if (stractualiLPN.trim().equals(striLPN) && stractualASN.trim().equals(strASN) && stractualLPNStatus.trim().equals(strLPNStatus) && stractualCurrentLocation.trim().equals(strCurrentLocation) && stractualPallet.trim().equals(strPallet)) 
			{
				report.updateTestLog("iLPN Lock Code verification",
						"Expected iLPN : " + striLPN
						+ " Actual iLPN : " + stractualiLPN +
						"Expected ASN : " + strASN
						+ " Actual ASN : " + stractualASN +
						"Expected LPN Status : " + strLPNStatus
						+ " Actual LPN Status : " + stractualLPNStatus +
						"Expected Current Location : " + strCurrentLocation
						+ " Actual Current Location : " + stractualCurrentLocation +
						"Expected Pallet : " + strPallet
						+ " Actual Pallet : " + stractualPallet,
						Status.PASS);
			} else {
				report.updateTestLog("iLPN Lock Code verification",
						"Expected iLPN : " + striLPN
						+ " Actual iLPN : " + stractualiLPN +
						"Expected ASN : " + strASN
						+ " Actual ASN : " + stractualASN +
						"Expected LPN Status : " + strLPNStatus
						+ " Actual LPN Status : " + stractualLPNStatus +
						"Expected Current Location : " + strCurrentLocation
						+ " Actual Current Location : " + stractualCurrentLocation +
						"Expected Pallet : " + strPallet
						+ " Actual Pallet : " + stractualPallet,
						Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function retrieves LPN details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public String[] getiLPNDetails() {
		String[] LPNDetails = new String[2];
		try {
			Thread.sleep(2000);
			String strItem = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:viewLPNPOLineItemsList:0:ViewPOLineItemList_LPN_POLine_Item_param_out_Commnd']","XPATH").getText();
			String strItemDesc = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:viewLPNPOLineItemsList:0:ViewPOLineItemList_LPN_Desc_param_out']","XPATH").getText();
			LPNDetails[0] = strItem; LPNDetails[1] =strItemDesc;
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
		return LPNDetails;
	}

}
