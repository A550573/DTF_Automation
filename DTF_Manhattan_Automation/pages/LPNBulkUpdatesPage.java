package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



import org.openqa.selenium.support.ui.Select;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class LPNBulkUpdatesPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public LPNBulkUpdatesPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("LPNBulkUpdatesPage"))
			report.updateTestLog("LPN Bulk Updates Page verification", "LPNBulkUpdates Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("LPN Bulk Updates Page verification", "LPNBulkUpdates Page not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		btnAdd, btnSave, lockCode;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: AppointmentNumber, Apply
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case btnAdd: elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Add >']", "XPATH");
				break;
				
			case btnSave: elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Save']", "XPATH");
			break;
			
			case lockCode: elemToFind = libManhattanCommonFunctions.getElementByProperty("//option[@value='ER']", "XPATH");
			break;
				
			
			default:
				break;
			}
			report.updateTestLog("LPNBulkUpdatesPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("LPNBulkUpdatesPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}	
	
	
	/**
	 *********************************************************************** 
	 * Function enters lock code and clicks on Save button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	striLPNNumber
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void enterLockCode(String strLockOperatn, String strLockCode) {
		try {
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			Select LockOperation = new Select(driver.findElement(By.id("dataForm:ilpnlockop")));
			LockOperation.selectByVisibleText(strLockOperatn);
			SelectLockCode(strLockCode);
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAdd"), "Add Button");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save Button");
			Thread.sleep(4000);
		} catch (Exception e) {
			report.updateTestLog("LPNBulkUpdates Page", "Element Not Found",Status.FAIL);
		}
	}
	
	
	
	
	/**
	 *********************************************************************** 
	 * Function selects an item from the list.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strPropertyValue, strPropType, strObjName, strItemNames
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SelectItemsInList(String strPropertyValue, String strPropType,String strObjName, String strItemNames) {
		boolean blnFlag;
		try {
			if (libManhattanCommonFunctions.isElementPresentVerification(strPropertyValue, strPropType,strObjName)) {
				WebElement elemToClick = libManhattanCommonFunctions.getElementByProperty(strPropertyValue,strPropType);
				// clickAnyElement(elemToClick,strObjName);
				String[] arrListNames = strItemNames.split(";");
				//List<WebElement> lstElement = libManhattanCommonFunctions.getElementsByProperty(elemToClick, "*", "XPATH");
				List<WebElement> lstElement = libManhattanCommonFunctions.getElementsByProperty(elemToClick, "*", "XPATH");
				for (String strItemName : arrListNames) {
					blnFlag = false;
					libManhattanCommonFunctions.clickAnyElement(getPageElement("lockCode"), "Lock Code");
					for (WebElement webElement : lstElement) {
						String strText = webElement.getText();
						if (strText.equalsIgnoreCase(strItemName)) {
							report.updateTestLog("Verify Item " + strItemName+ " is present", strItemName+ " is present and clicked", Status.PASS);
							blnFlag = true;
							break;
						}
						else{
							pressDown();
						}
					}
					if (blnFlag = false)
						report.updateTestLog("Verify Item " + strItemName+ " is present", strItemName+ " is not present", Status.FAIL);
				}

			} else
				report.updateTestLog("Verify if the Element(" + strObjName+ ") is present", strObjName + " is not present",Status.FAIL);
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("VerifyItemsInList: " + strObjName, strObjName+ " object does not exist in page", Status.FAIL);
		} catch (Exception e) {
			//report.updateTestLog("VerifyItemsInList","Error in method - Error Description - " + e.toString(),Status.FAIL);
		}
	}
	
	
	/**
	 *********************************************************************** 
	 * Function selects a lock code from the list.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 * @param strLockCode 
	 ***********************************************************************
	 */
	public void SelectLockCode(String strLockCode){
		try{
			SelectItemsInList("//select[@id='addLockDualList_SourceListId']", "XPATH", "Selected Locations List", strLockCode);
			Thread.sleep(2000);
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 	
	}
	
	
	/**
	 *********************************************************************** 
	 * Function performs press down action.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void pressDown() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
	
	}
	
