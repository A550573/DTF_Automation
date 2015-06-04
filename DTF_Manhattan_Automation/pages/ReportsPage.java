package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;
import com.gargoylesoftware.htmlunit.javascript.host.ActiveXObject;

import functionallibraries.ManhattanCommonFunctions;

import java.awt.*;
import java.util.*;
import java.lang.reflect.Field;
import java.awt.event.*;

import javax.swing.*;

public class ReportsPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return          Nothing is returned as of now  
	 * @param          scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public ReportsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub


	}              

	/**
	 *********************************************************************** 
	 * Function to verify the current page.
	 * @return          Nothing is returned as of now 
	 * @param          None
	 * @version 1.0
	 ***********************************************************************
	 */
	@Override
	protected void initializeUIMap()
	{
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("ReportsPage"))
			report.updateTestLog("Reports link Page verification", "Reports link loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Reports link Page verification", "Reports link page loaded not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		PublicFolders,DropDownMenu,ViewHTMLFormat,PercentageUnitsHeader,PalletsHeader,UnitsHeader,AgeHeader,LockCodeHeader, PageDown
	, AsnId, btnFinish, LPN, Aisle, Size, AgingLPN, PickDateType, FromDate, ToDate, Finish;}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param          strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 *                                            Values: PublicFolders.
	 * @return          The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case PublicFolders:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[contains(text(),'Public Folders')]", "XPATH");
				break;
			case DropDownMenu:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//img[@src='/sci/skins/corporate/portal/images/dropdown_arrow_narrow.gif'])[3]", "XPATH");
				break;////img[@alt = 'View in PDF Format']
			case ViewHTMLFormat:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//td[contains(text(),'View in HTML Format')]", "XPATH");
				break;////td[contains(text(),'View in HTML Options')]
			case LockCodeHeader:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//td[@type='columnTitle']//span[text()='Lock Code']", "XPATH");
				break;
			case AgeHeader:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//td[@type='columnTitle']//span[text()='Age (Hours)']", "XPATH");
				break;
			case UnitsHeader:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//td[@type='columnTitle']//span[text()='Units']", "XPATH");
				break;
			case PalletsHeader:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//td[@type='columnTitle']//span[text()='Pallets']", "XPATH");
				break;
			case PercentageUnitsHeader:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//td[@type='columnTitle']//span[text()='% Units']", "XPATH");
				break;
			case PageDown:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[contains(text(),'Page down')]", "XPATH");
				break;
			case AsnId:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//td[@class='clsTextWidgetParseError']", "XPATH");
				break;
			case LPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@class='clsTextWidget pt']", "XPATH");
				break;
			case btnFinish:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//button[contains(text(),'Finish')]", "XPATH");
				break;
			case Aisle:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@class='clsTextWidget pt']", "XPATH");
				break;
			case Size:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@class='clsSelectControl pv']", "XPATH");
				break;
			case AgingLPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//span[contains(text(),'72+')])[1]", "XPATH");
				break;
			case PickDateType:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//div[@class='dijitInline dijitRadio']", "XPATH");
				break;//input[@id='txtDateF_N0x11e2d780x0x12d419e8_NS_']
			case FromDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@class='clsSelectDateEditBox'])[1]", "XPATH");
				break;
			case ToDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@class='clsSelectDateEditBox'])[2]", "XPATH");
				break;	
			case Finish:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//button[contains(text(),'Finish')]", "XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("ReportsPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("ReportsPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 *********************************************************************** 
	 * Function is to reports
	 * @return          Nothing is returned as of now 
	 * @Author         Yagna Priya
	 * @param          strDockDoor, strDock
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void navigateToReport(String strFolder1, String strFolder2, String strReport) throws InterruptedException{
		System.out.println("report method");
		//libManhattanCommonFunctions.waitForElementClickable("//a[contains(text(),'Public Folders')]", 10000);
		System.out.println("click public folder");
		Thread.sleep(8000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("PublicFolders"), "Public Folders");
		System.out.println("click 1st folder");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement("//a[contains(text(),'"+strFolder1+"')]", "XPATH", strFolder1);
		System.out.println("folder1");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement("//a[contains(text(),'"+strFolder2+"')]", "XPATH", strFolder2);
		System.out.println("folder2");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement("//a[contains(text(),'"+strReport+"')]", "XPATH", strReport);
		System.out.println("report");
	}

	/**
	 *********************************************************************** 
	 * Function is to select and view reports
	 * @return          Nothing is returned as of now 
	 * @Author         Yagna Priya
	 * @param          strLockCode, strAge
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void selectLockCode(String strLockCode, String strAge) throws InterruptedException{
		List<WebElement> lstRowItems = driver.findElements(By.xpath("//table[@class='pg']//table[@class='ls']//tr//td[contains(@class,'c_NS_35 lm')]//span[contains(@dttargets,'P_Age')]"));
		for (WebElement ele:lstRowItems){
			System.out.println(ele.getAttribute("dttargets"));
			System.out.println(ele.getText());
			if ((ele.getAttribute("dttargets").contains(strLockCode))&&(((ele.getText().trim()).equalsIgnoreCase(strAge)))){
				ele.click();
				Thread.sleep(8000);
				System.out.println("clicked");
				break;
			}
		}
	}

	/**
	 *********************************************************************** 
	 * Function is to download the report in excel format
	 * @return          Nothing is returned as of now 
	 * @Author         Yagna Priya
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void viewHTMLFormat() throws InterruptedException{
		Thread.sleep(5000);
		//td[contains(text(),'IBM Cognos Viewer - Lock Code Detail')]
		libManhattanCommonFunctions.switchNewWindow();
		Thread.sleep(8000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("DropDownMenu"), "DropDown Menu");
		Thread.sleep(8000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("ViewHTMLFormat"), "View HTML Format");
		Thread.sleep(8000);
	}

	/**
	 *********************************************************************** 
	 * Function validates lock code table headers are present
	 * @return Nothing is returned as of now 
	 * @Author Yagna Priya D
	 * @param None
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void validateLockCodeMasterHeaders() throws InterruptedException{
		Thread.sleep(4000);
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("LockCodeHeader"), "Lock Code");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("AgeHeader"), "Age");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("UnitsHeader"), "Units");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("PalletsHeader"), "Pallets");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("PercentageUnitsHeader"), "Percentage Units");      

	}

	/**
	 *********************************************************************** 
	 * Function validates lock code table headers are present
	 * @return Nothing is returned as of now 
	 * @Author Yagna Priya D
	 * @param None
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void validateLockCodeDetailHeaders() throws InterruptedException{
		Thread.sleep(4000);
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("LockCodeHeader"), "Lock code");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("LockDescriptionHeader"), "Lock description");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("POHeader"), "PO");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("ItemHeader"), "Item");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("ItemDescriptionHeader"), "Item description");    
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("LocationHeader"), "Location");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("FCSpecificBoxCodeHeader"), "FC specidfic box");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("LockedQtyHeader"), "Locked quantity");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("iLPNHeader"), "iLPN");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("PalletHeader"), "Pallet");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("AgeHeader"), "Age");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("CreatedDateHeader"), "Created date");
		libManhattanCommonFunctions.isElementPresentVerification(getPageElement("LastModifiedHeader"), "Last modified");
	}

	/**
	 *********************************************************************** 
	 * Function is to validate iLPN details
	 * @return          Nothing is returned as of now 
	 * @Author         Yagna Priya
	 * @param          striLPNNumber
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void validateiLPNDetails(String striLPNNumber) throws InterruptedException{
		String strLockCode,strLockDesc,strPO,strItem,strItemDesc,strLocation,strFCSpecificCode,strLockedQty,strLPN,strPallet,strAge,strCreatedDate,strLastModified;
		String[] arr = new String[15];
		String striLPN;
		int intPointr = 1,i=0,j=2;
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='ls']//tr"));
		int strtext=list.size();

		for(WebElement ele:list){            
			intPointr = intPointr+1;
			striLPN = driver.findElement(By.xpath("//table[@class='ls']//tr["+j+"]//*[@class='c_NS_83 lc']")).getText().trim();
			j=j+1;
			if (striLPN.equals(striLPNNumber)){
				System.out.println("iLPN : "+striLPN);
				List<WebElement> listValues = ele.findElements(By.xpath("//table[@class='ls']//tr["+intPointr+"]//span"));
				for(WebElement val:listValues){
					//strLockCode = val.getText().trim();
					//System.out.println("Lock Code : "+strLockCode);
					arr[i] = val.getText().trim();
					i++;
				}
				strLockCode = arr[0]; strLockDesc = arr[1]; strPO = arr[2]; strItem = arr[3]; strItemDesc = arr[4]; strLocation = arr[5]; 
				/*strFCSpecificCode = arr[6] */; strLockedQty = arr[6]; strLPN = arr[7]; strPallet = arr[8]; strAge = arr[9]; strCreatedDate = arr[10]; strLastModified = arr[11];
				System.out.println("LockCode : "+strLockCode);
				System.out.println("LockDesc : "+strLockDesc);
				System.out.println("PO : "+strPO);
				System.out.println("Item : "+strItem);
				System.out.println("ItemDesc : "+strItemDesc);
				System.out.println("Location : "+strLocation);
				//System.out.println("FCSpecificCode : "+strFCSpecificCode);
				System.out.println("LockedQty : "+strLockedQty);
				System.out.println("LPN :"+strLPN);
				System.out.println("Pallet : "+strPallet);
				System.out.println("Age : "+strAge);
				System.out.println("CreatedDate : "+strCreatedDate);
				System.out.println("LastModified : "+strLastModified);
				break;
				//                                                            break;
			}

		}              
	}


	/**
	 *********************************************************************** 
	 * Function is to validate iLPN details
	 * @return          Nothing is returned as of now 
	 * @Author         Nitika
	 * @param           strASN_Num
	 * @version		    1.0 
	 * @throws 			InterruptedException    
	 ***********************************************************************
	 */
	@SuppressWarnings("null")
	public void validateIbCurrentDockStatus(String strASN_Num) throws InterruptedException{
		String strTotalVal, strTotal,RemLPN,strRemainingLPN;
		 String[] arr = new String[3];
		strTotalVal = driver.findElement(By.xpath("//td[@class='c_NS_40 is']")).getText().trim();
		if (strTotalVal.contains(",")){
           // Thread.sleep(3000);
            arr = strTotalVal.split(",");
            strTotalVal = arr[0] + arr[1];
		}

		int strVal=0;
		int k;
		do{
			int intPointr = 1,i=0,j=2, value = 0;
			k=0;
			List<WebElement> list = driver.findElements(By.xpath("//table[@lid='List2_NS_']//tr//*[@class='c_NS_98 lm']"));
		int strtext=list.size();

		for(WebElement ele:list){
			//Thread.sleep(2000);
			intPointr = intPointr+1;
			strRemainingLPN = driver.findElement(By.xpath("//table[@lid='List2_NS_']//tr["+j+"]//*[@class='c_NS_98 lm']")).getText().trim();
			List<WebElement> listValues = ele.findElements(By.xpath("//table[@lid='List2_NS_']//tr["+intPointr+"]//*[@class='c_NS_98 lm']"));
			for(WebElement val:listValues){
				//Thread.sleep(2000);
				RemLPN = val.getText().trim();
				value = Integer.parseInt(RemLPN);
				i++;
			}
			strVal=strVal+value;
			j=j+1;
			//Thread.sleep(1000);
		}
			if(libManhattanCommonFunctions.verifyElementPresent("//td[contains(text(),'Page down')]", "XPATH"))
			{
				k=1;
				
			}
			else{
				k=0;
				libManhattanCommonFunctions.clickAnyElement(getPageElement("PageDown"), "PageDown Button");
				Thread.sleep(4000);
			} 
		}while(k==0);
		strTotal = "" + strVal;
		if(strTotal.trim().equals(strTotalVal.trim()))
		{
			report.updateTestLog("Inbound Reports verification", "The value of Total is verified successfully", Status.PASS);
		}else
		{
			report.updateTestLog("Inbound Reports verification", "Expected total: "+strTotalVal+"|| Actual Total: "+strTotal, Status.FAIL);
		}
	}
	
	
	/**
	 *********************************************************************** 
	 * Function is to retrieve the report detials
	 * @return          Nothing is returned as of now 
	 * @Author          Nitika
	 * @param           strASN_Num
	 * @version		    1.0 
	 * @throws 			InterruptedException    
	 ***********************************************************************
	 */
	@SuppressWarnings("null")
	public void getDockDetails(String strASN_Num, String[] ApptDetails, String RecLPNS) throws InterruptedException{
		String strDoor = null,strTrailer = null,strApptType = null, strItems,ASN,strRecLPN = null;
		int intPtr = 1,l=0,m=2;
		String strarr[] = new String[20];
		List<WebElement> list = driver.findElements(By.xpath("//table[@lid='List2_NS_']//tr"));
		for(WebElement ele:list){            
			intPtr = intPtr+1;
			ASN = driver.findElement(By.xpath("//table[@lid='List2_NS_']//tr["+m+"]//*[@class='c_NS_88 lc']")).getText().trim();
			m=m+1;
			if (ASN.equals(strASN_Num)){
				List<WebElement> listValues = ele.findElements(By.xpath("//table[@lid='List2_NS_']//tr["+intPtr+"]//span"));
				for(WebElement val:listValues){
					//strLockCode = val.getText().trim();    (//table[@class='ls']//tr[2]//span)[3]
					//System.out.println("Lock Code : "+strLockCode);
					strarr[l] = val.getText().trim();
					//strarr[l] = strval;
					l++;
				}
				strItems = strarr[8]; strDoor = strarr[0]; strTrailer = strarr[2]; strApptType = strarr[11];strRecLPN = strarr[7]; 
				System.out.println("Items : "+strItems);
				System.out.println("Door : "+strDoor);
				System.out.println("Trailer : "+strTrailer);
				System.out.println("ApptType : "+strApptType);
				break;
			}
			}
		if(strDoor.trim().equals(ApptDetails[1]) && strTrailer.trim().equals(ApptDetails[2]) && strApptType.trim().equals(ApptDetails[0]) && strRecLPN.trim().equals(RecLPNS))
			report.updateTestLog("Appointment Details Validation", "Appointment Type : "+strApptType+" || Door : "+strDoor+" || Trailer : "+strTrailer, Status.PASS);
		else
			report.updateTestLog("Appointment Details Validation", "Expected Appointment Type : "+strApptType+" || Actual Appointment Type : "+ApptDetails[0]+" || Expected Door : "+strDoor+" || Actual Door : "+ApptDetails[1]+" || Expected Trailer : "+strTrailer+" || Actual Trailer : "+ApptDetails[2], Status.FAIL);
	}


	
	
	
	/**
	 *********************************************************************** 
	 * Function is to Verify the 'Out of LOS' Interval details in the Summary Grid
	 * @return          Nothing is returned as of now 
	 * @Author          Nitika
	 * @param           strASN_Num
	 * @version		    1.0 
	 * @throws 			InterruptedException    
	 ***********************************************************************
	 */
	public void VerifyIntervalDetails() throws InterruptedException{
		String strTotalVal = driver.findElement(By.xpath("//td[@class='c_NS_40 is']")).getText().trim();
		if (strTotalVal.contains(",")){
				String[] arr = strTotalVal.split(",");
	            strTotalVal = arr[0] + arr[1];
			}
		List<WebElement> list = driver.findElements(By.xpath("//table[@lid='List1_NS_']//tr//*[@class='c_NS_35 lm']"));
		int strtext=list.size();
		int intPointr = 1,i=0,j=2, value = 0, strVal=0;
		String RemLPN,strTotal;
		for(WebElement ele:list){
			//Thread.sleep(2000);
			intPointr = intPointr+1;
			List<WebElement> listValues = ele.findElements(By.xpath("//table[@lid='List1_NS_']//tr["+intPointr+"]//*[@class='c_NS_35 lm']"));
			for(WebElement val:listValues){
				//Thread.sleep(2000);
				RemLPN = val.getText().trim();
				if (RemLPN.contains(",")){
						String[] arr = RemLPN.split(",");
						RemLPN = arr[0] + arr[1];
					}
				value = Integer.parseInt(RemLPN);
				i++;
			}
			strVal=strVal+value;
			j=j+1;
			//Thread.sleep(1000);
		}
		strTotal = "" + strVal;
		if(strTotal.trim().equals(strTotalVal.trim()))
		{
			report.updateTestLog("Inbound Reports verification", "Interval details verified successfully", Status.PASS);
		}else
		{
			report.updateTestLog("Inbound Reports verification", "Expected total: "+strTotalVal+"|| Actual Total: "+strTotal, Status.FAIL);
		}
		
	}
	
	
	
	
	/**
	 *********************************************************************** 
	 * Function enters ASN Number.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strASN_Num
	 * @version 1.0
	 * @throws 	InterruptedException 
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void enterASN_Num(String strASN_Num) throws InterruptedException, AWTException{
		Thread.sleep(2000);
//		strASN_Num="535345353";
		libManhattanCommonFunctions.clickAnyElement(getPageElement("AsnId"), "ASNId");
	//	libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("AsnId"), strASN_Num, "ASNId");
		Robot robot = new Robot();      
		typeCharacter(robot, strASN_Num);
		StringSelection ss = new StringSelection(strASN_Num);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
//		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnFinish"), "Finish Button");
		Thread.sleep(2000);
	}


public static void typeCharacter(Robot robot, String letter)
{
    try
    {
        boolean upperCase = Character.isUpperCase( letter.charAt(0) );
        String variableName = "VK_" + letter.toUpperCase();

        Class clazz = KeyEvent.class;
        Field field = clazz.getField( variableName );
        int keyCode = field.getInt(null);

        robot.delay(1000);

        if (upperCase) robot.keyPress( KeyEvent.VK_SHIFT );

        robot.keyPress( keyCode );
        robot.keyRelease( keyCode );

        if (upperCase) robot.keyRelease( KeyEvent.VK_SHIFT );
    }
    catch(Exception e)
    {
        System.out.println(e);
    }

}



/**
 *********************************************************************** 
 * Function is to retrieve the worksheet detials
 * @return          Nothing is returned as of now 
 * @Author          Nitika
 * @param           strASN_Num
 * @version		    1.0 
 * @throws 			InterruptedException    
 ***********************************************************************
 */
@SuppressWarnings("null")
public void VerifyWorksheetDetails(String[] AsnDetails,String[] ApptDetails) throws InterruptedException{
	String strTrailer, strPO,strItem, strItemBarcode , strDescriptn, strRecLPN;
	strTrailer = driver.findElement(By.xpath("(//span[@tabindex='0'])[7]")).getText().trim();
	strPO = driver.findElement(By.xpath("//td[@class='c_NS_92 lc']")).getText().trim();
	strItem = driver.findElement(By.xpath("//td[@class='c_NS_94 lc']")).getText().trim();
	strItemBarcode = driver.findElement(By.xpath("//td[@class='c_NS_96 lc']")).getText().trim();
	strDescriptn = driver.findElement(By.xpath("//td[@class='c_NS_98 lc']")).getText().trim();
	strRecLPN = driver.findElement(By.xpath("(//span[@tabindex='0'])[17]")).getText().trim();
	
	if(strPO.trim().equals(AsnDetails[1]) && strTrailer.trim().equals(ApptDetails[2]) && strItem.trim().equals(AsnDetails[2]) && strRecLPN.trim().equals(AsnDetails[0]) && strDescriptn.trim().equals(AsnDetails[3])){
		if(strItemBarcode.trim().contains(AsnDetails[4]))
		report.updateTestLog("Worksheet Details Validation", "PO : "+strPO+" || Item : "+strItem+" || Trailer : "+strTrailer, Status.PASS);
	}
	else
		report.updateTestLog("Worksheet Details Validation", "Expected PO : "+strPO+" || Actual PO : "+AsnDetails[1]+" || Expected Item : "+strItem+" || Actual Item : "+AsnDetails[2]+" || Expected Trailer : "+strTrailer+" || Actual Trailer : "+ApptDetails[2], Status.FAIL);
}


/**
 *********************************************************************** 
 * Function enters ASN Number.
 * @return 	Nothing is returned as of now 
 * @Author 	Nitika
 * @param 	strASN_Num
 * @version 1.0
 * @throws 	InterruptedException 
 * @throws AWTException 
 ***********************************************************************
 */
public void enterLPN_Num(String strLPN_Num) throws InterruptedException, AWTException{
	Thread.sleep(2000);
	libManhattanCommonFunctions.clickAnyElement(getPageElement("LPN"), "LPN");
	libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN"), strLPN_Num, "LPN");
	Thread.sleep(2000);
	libManhattanCommonFunctions.clickAnyElement(getPageElement("btnFinish"), "Finish Button");
	Thread.sleep(2000);
}


/**
 *********************************************************************** 
 * Function is to retrieve the worksheet detials
 * @return          Nothing is returned as of now 
 * @Author          Nitika
 * @param           strLPN_Num
 * @version		    1.0 
 * @throws 			InterruptedException    
 ***********************************************************************
 */
@SuppressWarnings("null")
public void VerifyProductPrepDetails(String[] LPNDetails, String strLPN_Num) throws InterruptedException{
	String strLPN, strItem,  strDescriptn;
	strLPN = driver.findElement(By.xpath("(//span[@tabindex='0'])[4]")).getText().trim();
	strItem = driver.findElement(By.xpath("(//span[@class='textItem'])[5]")).getText().trim();
	strDescriptn = driver.findElement(By.xpath("(//span[@class='textItem'])[7]")).getText().trim();
	
	if(strLPN.trim().equals(strLPN_Num) && strItem.trim().equals(LPNDetails[0]) && strDescriptn.trim().equals(LPNDetails[1]))
		report.updateTestLog("Product Prep Details Validation", "LPN : "+strLPN+" || Item : "+strItem+" || Description : "+strDescriptn, Status.PASS);
	else
		report.updateTestLog("Product Prep Details Validation", "Expected LPN : "+strLPN_Num+" || Actual LPN : "+strLPN+" || Expected Item : "+LPNDetails[0]+" || Actual Item : "+strItem+" || Expected Description : "+LPNDetails[1]+" || Actual Description : "+strDescriptn, Status.FAIL);
}

/**
 *********************************************************************** 
 * Function enters Open Most Summary Details.
 * @return 	Nothing is returned as of now 
 * @Author 	Nitika
 * @param 	strASN_Num
 * @version 1.0
 * @throws 	InterruptedException 
 * @throws AWTException 
 ***********************************************************************
 */
public void enterSummaryDetails(String strAisle, String Size, String strLock) throws InterruptedException, AWTException{
	//Thread.sleep(2000);
	libManhattanCommonFunctions.clickAnyElement(getPageElement("Aisle"), "Aisle");
	libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Aisle"), strAisle, "Aisle");
	Thread.sleep(2000);
	for(int i = 1; i <= 7; i++)
	{
	    String value = driver.findElement(By.xpath("(//select[@class='clsSelectControl pv']/option)["+i+"]")).getAttribute("value");
	    if(value.equals(Size))
	    {
	        driver.findElement(By.xpath("(//select[@class='clsSelectControl pv']/option)["+i+"]")).click(); 
	        break;
	    }
	}	
	// Thread.sleep(2000);
	 for(int i = 1; i <= 3; i++)
		{
		    String value = driver.findElement(By.xpath("(//input[@type='radio'])["+i+"]")).getAttribute("value");
		    if(value.equals(strLock))
		    {
		        driver.findElement(By.xpath("(//input[@type='radio'])["+i+"]")).click(); 
		        break;
		    }
		}	
	libManhattanCommonFunctions.clickAnyElement(getPageElement("btnFinish"), "Finish Button");
	//Thread.sleep(2000);
}


/**
 *********************************************************************** 
 * Function generates the Aging oLPNs report..
 * @return 	Nothing is returned as of now 
 * @Author 	Nitika
 * @version 1.0
 * @throws 	InterruptedException        (//table[@class='ls']//tr//td[@cid='0']//span[contains(text(),'Express')])[1]
 * @throws AWTException 
 ***********************************************************************
 */
public void genAgingLPNreport() throws InterruptedException, AWTException
{
	libManhattanCommonFunctions.clickAnyElement(getPageElement("AgingLPN"), "AgingLPN");
	Thread.sleep(4000);
//	libManhattanCommonFunctions.switchNewWindow();
}


/**
 *********************************************************************** 
  * Function is to download the report in excel format
 * @return  Nothing is returned as of now 
  * @Author  Rahman
 * @version 1.0
 * @throws InterruptedException 
  ***********************************************************************
 */
 public void validateCompleteByDetails(String strPickTicket,String strPickTicketStatus,String stroLPN, String strWaveNumber) throws InterruptedException{
        Thread.sleep(3000);
        //td[contains(text(),'IBM Cognos Viewer - Lock Code Detail')]
        int intRowPointer=0;                     
        String actualPickTicket = "";
        String actualPickTicketStatus = "";
        String actualoLPN = "";    
        String actualWaveNumber = "";
        WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@lid='List1_NS_']"));
        List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR")); 
        System.out.println((wbTRList.size()- 1));       
        for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
        {                                               
               intRowPointer = intPointr;
               actualPickTicket=libManhattanCommonFunctions.getElementByProperty("(//td[@cid='2'][@type='datavalue'])["+(intRowPointer+1)+"]", "XPATH").getText();               
               actualPickTicketStatus=libManhattanCommonFunctions.getElementByProperty("(//td[@cid='5'][@type='datavalue'])["+(intRowPointer+1)+"]", "XPATH").getText();                                    
               actualoLPN=libManhattanCommonFunctions.getElementByProperty("(//td[@cid='6'][@type='datavalue'])["+(intRowPointer+1)+"]", "XPATH").getText();               
               actualWaveNumber=libManhattanCommonFunctions.getElementByProperty("(//td[@cid='7'][@type='datavalue'])["+(intRowPointer+1)+"]", "XPATH").getText();
               System.out.println(actualPickTicket);
               System.out.println(actualPickTicketStatus);
               System.out.println(actualoLPN);
               System.out.println(actualWaveNumber);
               if(actualWaveNumber.trim().equals(strWaveNumber))
               {
               if(actualPickTicket.trim().equals(strPickTicket) && actualPickTicketStatus.trim().equals(strPickTicketStatus) && actualoLPN.trim().equals(stroLPN))
               {
                     report.updateTestLog("Item details verification", " Expected PickTicket : "+strPickTicket+" Actual PickTicket : "+actualPickTicket+" Expected PickTicket Status : "+strPickTicketStatus+" Actual PickTicket Status : "+actualPickTicketStatus+" Expected oLPN : "+stroLPN+" Actual oLPN : "+actualoLPN+" Expected Wave Number : "+strWaveNumber+" Actual Wave Number : "+actualWaveNumber, Status.PASS);        
                     break;
               }
               else
               {
                     report.updateTestLog("Item details verification", " Expected PickTicket : "+strPickTicket+" Actual PickTicket : "+actualPickTicket+" Expected PickTicket Status : "+strPickTicketStatus+" Actual PickTicket Status : "+actualPickTicketStatus+" Expected oLPN : "+stroLPN+" Actual oLPN : "+actualoLPN+" Expected Wave Number : "+strWaveNumber+" Actual Wave Number : "+actualWaveNumber, Status.FAIL);
               }      
               }
        }
 }
 
 /**
	 *********************************************************************** 
	 * Function is to download the report in excel format
	 * @return  Nothing is returned as of now 
	 * @Author  Rahman
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void selectDate(String strFromDate,String strToDate) throws InterruptedException{
		Thread.sleep(3000);
		//td[contains(text(),'IBM Cognos Viewer - Lock Code Detail')]
		if(!strFromDate.equals(""))
		{
			libManhattanCommonFunctions.clickAnyElement(getPageElement("PickDateType"), "Manual Date Selection Button");
			Thread.sleep(2000);		
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("FromDate"), strFromDate, "From Date");
			Thread.sleep(2000);		
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ToDate"), strFromDate, "To Date");
			Thread.sleep(2000);		
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Finish"), "Finish Button");
			Thread.sleep(8000);		
		}
//		else{
//			Thread.sleep(2000);		
//			libManhattanCommonFunctions.clickAnyElement(getPageElement("Finish"), "Finish Button");
//			Thread.sleep(4000);	
//		}
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
	public void clickOrdersLink(String strElementName) {
		try {				
			libManhattanCommonFunctions.clickAnyElement(strElementName, "XPATH", "Orders Link");
			Thread.sleep(5000);
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}
	
	
	
	/**
	 *********************************************************************** 
	 * Function is to validate iLPN details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	striLPNNumber
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	String strLockCode,strLockDesc,strPO,strItem,strItemDesc,strLocation,strFCSpecificCode,strLockedQty,strLPN,strPallet,strAge,strCreatedDate,strLastModified;
	public void validateiLPNDetails(String striLPNNumber, ArrayList<String> strLPNDetails) throws InterruptedException{
		System.out.println("LPNDetails : "+strLPNDetails);
		String[] arr = new String[15];
		String striLPN;
		int intPointr = 1,i=0,j=2;
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='ls']//tr"));
		int strtext=list.size();

		for(WebElement ele:list){	
			intPointr = intPointr+1;
			striLPN = driver.findElement(By.xpath("//table[@class='ls']//tr["+j+"]//*[@class='c_NS_83 lc']")).getText().trim();
			j=j+1;
			if (striLPN.equals(striLPNNumber)){
				System.out.println("iLPN : "+striLPN);
				List<WebElement> listValues = ele.findElements(By.xpath("//table[@class='ls']//tr["+intPointr+"]//span"));
				for(WebElement val:listValues){
					//strLockCode = val.getText().trim();
					//System.out.println("Lock Code : "+strLockCode);
					arr[i] = val.getText().trim();
					i++;
				}
				strLockCode = arr[0]; strLockDesc = arr[1]; strPO = arr[2]; strItem = arr[3]; strItemDesc = arr[4]; strLocation = arr[5]; 
				/*strFCSpecificCode = arr[6] */; strLockedQty = arr[6]; strLPN = arr[7]; strPallet = arr[8]; strAge = arr[9]; strCreatedDate = arr[10]; strLastModified = arr[11];
				System.out.println("LockCode : "+strLockCode);
				System.out.println("LockDesc : "+strLockDesc);
				System.out.println("PO : "+strPO);
				System.out.println("Item : "+strItem);
				System.out.println("ItemDesc : "+strItemDesc);
				System.out.println("Location : "+strLocation);
				//System.out.println("FCSpecificCode : "+strFCSpecificCode);
				System.out.println("LockedQty : "+strLockedQty+" Unit");
				System.out.println("LPN :"+strLPN);
				System.out.println("Pallet : "+strPallet);
				System.out.println("Age : "+strAge);
				System.out.println("CreatedDate : "+strCreatedDate);
				System.out.println("LastModified : "+strLastModified);
				if((striLPNNumber.trim().equals(strLPN))&& (strLPNDetails.contains(strLockedQty+" Unit")) && (strLPNDetails.contains(strLocation)) && (strLPNDetails.contains(strPallet)) && (strLPNDetails.contains(strItem)) && (strLPNDetails.contains(strItemDesc)) && (strLPNDetails.contains(strPO)) && (strLPNDetails.contains(strLockDesc)))
				{
					report.updateTestLog("iLPNDetails validation", "LPNNumber: "+strLPN+" || LockQty: "+strLockedQty+" || Location: "+strLocation+" || Pallet: "+strPallet+" || Item: "+strItem+" || ItemDesc: "+strItemDesc+" || PO: "+strPO+" || LockDesc: "+strLockDesc, Status.PASS);
				} 
				else {
					report.updateTestLog("iLPNDetails validation", "LPNNumber: "+strLPN+" || LockQty: "+strLockedQty+" || Location: "+strLocation+" || Pallet: "+strPallet+" || Item: "+strItem+" || ItemDesc: "+strItemDesc+" || PO: "+strPO+" || LockDesc: "+strLockDesc, Status.FAIL);
				}
				break;
			}
			}
		}

}

