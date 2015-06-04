package pages;


import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class PixTransactionPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public PixTransactionPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("PixTransactionPage"))
			report.updateTestLog("Pix Transaction Page verification", "Pix Transaction loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Pix Transaction Page verification", "Pix Transaction page loaded not loaded!!!!", Status.FAIL);
	}

	private enum enumPageObjects
	{
		Apply, OrderID, pixHeaderDate, pixHeaderTransType, pixHeaderTransCode, pixHeaderActionCode, pixHeaderDescription, pixHeaderBusiUnit, pixHeaderItems, pixHeaderLPN, pixHeaderAdjQty, pixHeaderStatus, btnApply;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Apply, OrderID, pixHeaderDate, pixHeaderTransType, pixHeaderTransCode, pixHeaderActionCode, pixHeaderDescription, pixHeaderBusiUnit, pixHeaderItems, pixHeaderLPN, pixHeaderAdjQty, pixHeaderStatus, btnApply
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

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
			case btnApply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(.//*[@value='Apply' and @title='Apply'])[1]", "XPATH");
				break;


			default:
				break;
			}
			report.updateTestLog("PixTransactionPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("PixTransactionPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 *********************************************************************** 
	 * Function selects PIX transaction type and code.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree
	 * @param 	strType,strCode
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchPIXTransaction(String strType, String strCode){                                
		try{    
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
			Thread.sleep(2000);
			libManhattanCommonFunctions.selectAnyElement("//select[@id='dataForm:lview:filterId:field0value1']", "XPATH",strType,"Select PIX Transaction");
		//	libManhattanCommonFunctions.waitForElementVisibility("//select[@id='dataForm:lview:filterId:field1value1']", 2000);
			Thread.sleep(4000);
			libManhattanCommonFunctions.selectAnyElement("//select[@id='dataForm:lview:filterId:field1value1']", "XPATH",strCode,"Select PIX Transaction Code");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");

		}catch(Exception e){
			report.updateTestLog("Pix Transaction", "Element Not Found", Status.FAIL);


		}              
	}

	/**
	 *********************************************************************** 
	 * Function verifies any field value.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree
	 * @param 	strFieldName,strValue
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
	 * Function verifies PIX transaction table headers.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyPIXTable(){
		try{
			verifyAnyFieldANDtextValue("pixHeaderDate", "Create Date/Time");
			verifyAnyFieldANDtextValue("pixHeaderActionCode", "Action Code");
			verifyAnyFieldANDtextValue("pixHeaderLPN", "LPN");
			verifyAnyFieldANDtextValue("pixHeaderTransType", "Transaction Type");
			verifyAnyFieldANDtextValue("pixHeaderTransCode", "Transaction Code");
			verifyAnyFieldANDtextValue("pixHeaderDescription", "PIX Description");
			verifyAnyFieldANDtextValue("pixHeaderBusiUnit", "Business Unit");
			verifyAnyFieldANDtextValue("pixHeaderItems", "Item");
			verifyAnyFieldANDtextValue("pixHeaderAdjQty", "Adjustment Quantity");
			verifyAnyFieldANDtextValue("pixHeaderStatus", "Status");                        
		}catch(Exception e){

		}
	}

	/**
	 *********************************************************************** 
	 * Function verifies PIX transaction status.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree
	 * @param 	strLPN,strActionCode,strAdjQty
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyPIXStatus(String strLPN, String strActionCode, String strAdjQty){                                
		int intRowPointer=0; 
		libManhattanCommonFunctions.waitForElementVisibility(".//*[@id='checkAll_c0_dataForm:lview:dataTable']", 4000);
		try{  
			WebElement wbLPNTable1 = driver.findElement(By.xpath("//div[@id='dataForm:lview:dataTable_bodyDiv']"));
			List<WebElement> wbTRList = wbLPNTable1.findElements(By.tagName("TR"));
			int intPointr = 0;
			for(WebElement el: wbTRList){
				String strRowValue = el.getText();
				if(strRowValue.contains(strLPN)){
					intRowPointer = intPointr;
					break;
				}
				intPointr = intPointr+1;
			}
			libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+intPointr+"_dataForm:lview:dataTable']", "XPATH", "CheckBox");
			String strPixTableiLPN = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:"+intRowPointer+":fuid2']", "XPATH").getText();
			String strPixTableActionCode = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:"+intRowPointer+":v_actnCode']", "XPATH").getText();
			String strPixTableAdjustmentQty = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:"+intRowPointer+":fuid7']", "XPATH").getText();
			if(strPixTableiLPN.trim().equals(strLPN) && strPixTableActionCode.trim().equals(strActionCode) && strPixTableAdjustmentQty.trim().equals(strAdjQty))

			{
				report.updateTestLog("Pix Transaction details verification", "Expected iLPN : "+strLPN+" Actual iLPN : "+strPixTableiLPN+" Expected ActionCode : "+strActionCode+" Actual ActionCode : "+strPixTableActionCode+" Expected AdjustmentQty : "+strAdjQty+" Actual AdjustmentQty : "+strPixTableAdjustmentQty, Status.PASS);
			}else
			{
				report.updateTestLog("Pix Transaction details verification", "Expected iLPN : "+strLPN+" Actual iLPN : "+strPixTableiLPN+" Expected ActionCode : "+strActionCode+" Actual ActionCode : "+strPixTableActionCode+" Expected AdjustmentQty : "+strAdjQty+" Actual AdjustmentQty : "+strPixTableAdjustmentQty, Status.FAIL);
			}
		}
		catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 *********************************************************************** 
	 * Function enters the LPNs for cycle count.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param  strLPNNum,strActionCode,strAdjQty
	 * @version 1.0
	 * @throws AWTException
	 *********************************************************************** 
	 */
	public void verifyAdjQtyforLpns(String strLPNNum,String strActionCode,String strAdjQty)throws InterruptedException, AWTException {
		
		if (strLPNNum.contains(";")) {
			Thread.sleep(3000);
			String[] strLPNs = strLPNNum.split(";");
			String[] strCode = strActionCode.split(";");
			String[] strQty = strAdjQty.split(";");

			for (int intLoop = 0; intLoop < strLPNs.length; intLoop++) {
				verifyPIXStatus(strLPNs[intLoop], strCode[intLoop], strQty[intLoop]);
				Thread.sleep(1000);				
			}
		} 
			else {
			verifyPIXStatus(strLPNNum, strActionCode, strAdjQty);
			Thread.sleep(1000);			
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function verifies PIX transaction Adjustment Quantity.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strItemBarcode,strAdjQty
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyPIXAdjQty(String strItemBarcode, String strAdjQty){                                
		int intRowPointer=0;                                
		try{  
			WebElement wbLPNTable1 = driver.findElement(By.xpath("//div[@id='dataForm:lview:dataTable_bodyDiv']"));
			List<WebElement> wbTRList = wbLPNTable1.findElements(By.tagName("TR"));
			int intPointr = 0;
			for(WebElement el: wbTRList){
				String strRowValue = el.getText();
				if(strRowValue.contains(strItemBarcode)){
					intRowPointer = intPointr;
					break;
				}
				intPointr = intPointr+1;
			}
			String strPixTableAdjustmentQty = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:"+intRowPointer+":fuid7']", "XPATH").getText();
			String strPixTableItemBarcode = libManhattanCommonFunctions.getElementByProperty("//a[@id='dataForm:lview:dataTable:"+intRowPointer+":ItemBOMDetailsListEV_item_popup_button']", "XPATH").getText();			
			if(strPixTableItemBarcode.trim().equals(strItemBarcode) && strPixTableAdjustmentQty.trim().equals(strAdjQty))

			{
				report.updateTestLog("Pix Transaction details verification", "Expected Item Barcode : "+strItemBarcode+" Actual Item Barcode : "+strPixTableItemBarcode+" Expected AdjustmentQty : "+strAdjQty+" Actual AdjustmentQty : "+strPixTableAdjustmentQty, Status.PASS);
			}else
			{
				report.updateTestLog("Pix Transaction details verification", "Expected Item Barcode : "+strItemBarcode+" Actual Item Barcode : "+strPixTableItemBarcode+" Expected AdjustmentQty : "+strAdjQty+" Actual AdjustmentQty : "+strPixTableAdjustmentQty, Status.FAIL);
			}
		}
		catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}

}


