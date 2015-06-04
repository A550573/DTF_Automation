package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class AdjustInventoryPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public AdjustInventoryPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try{

		}catch(Exception e){
			report.updateTestLog("AdjustInventory-OBJECT IDENTIFICATION", "Error in finding Page Object/element : " + e.getMessage(), Status.FAIL);
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
	protected void initializeUIMap()
	{
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("AdjustInventoryPage"))
			report.updateTestLog("AdjustInventoryPage verification", "AdjustInventoryPage loaded as expected.", Status.DONE);
		else
			report.updateTestLog("AdjustInventoryPage verification", "AdjustInventoryPage loaded as expected.", Status.DONE);
	}

	private enum enumPageObjects{
		CurrentQty, NewQty,Reasoncode, btnSave, backbtn;
	}
	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: CurrentQty, NewQty,Reasoncode, btnSave, backbtn;
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case CurrentQty:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@name='dataForm:CurrentQty']", "XPATH");
				break;
			case NewQty:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@name='dataForm:NewQty']", "XPATH");
				break;
			case Reasoncode:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@name='dataForm:adjustReasonSelect']", "XPATH");
				break;
			case btnSave:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Save']", "XPATH");
				break;
			case backbtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//img[@id='backImage']", "XPATH");
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
	 * Function verifies the quantity.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strQuantity
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyQuantity(String strQuantity){

		try{
			libManhattanCommonFunctions.waitForElementVisibility("//input[@id='dataForm:CurrentQty']", 2000);
			String actualCurrentQty=libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:CurrentQty']", "XPATH").getAttribute("value");
			if(actualCurrentQty.trim().equals(strQuantity))
			{
				report.updateTestLog("CurrentQty verification", "Expected Current Quantity : "+strQuantity+"is verified", Status.PASS);
			}else
			{
				report.updateTestLog("CurrentQty verification", "Expected Current Quantity : "+strQuantity+"  Actual Quantity : "+actualCurrentQty , Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}  
	}

	/**
	 *********************************************************************** 
	 * Function enters the new quantity and clicks on save button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strNewQty, strReasonCode
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterNewQty(String strNewQty, String strReasonCode){
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("NewQty"), strNewQty, "New Quantity");
		Select ReasonCode = new Select(driver.findElement(By.id("dataForm:adjustReasonSelect")));
		ReasonCode.selectByVisibleText(strReasonCode);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save");
	}

	/**
	 *********************************************************************** 
	 * Function clicks on back button to go to previous screen.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickBackButton() throws InterruptedException{
		libManhattanCommonFunctions.clickAnyElement(getPageElement("backbtn"), "Back Button");			
	}

}
