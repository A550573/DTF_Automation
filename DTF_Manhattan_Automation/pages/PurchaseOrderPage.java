package pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class PurchaseOrderPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public PurchaseOrderPage(ScriptHelper scriptHelper) {
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
			if (getCurrentPage("PurchaseOrderPage"))
				report.updateTestLog("Purchase Order Page verification", "Purchase Orderpage loaded as expected.", Status.DONE);
			else
				report.updateTestLog("Purchase Order Page verification", "Purchase Order page loaded not loaded!!!!", Status.FAIL);
		}
		
		
		private enum enumPageObjects
		{
			PurchaseOrderID,Apply, btnView, lnkLines;
		}

		/**
		 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
		 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
		 * 			Values: PurchaseOrderID,Apply
		 * @return	The WebElement object if it exists. Else returns null
		 */
		private WebElement getPageElement(String strElemName)
		{
			WebElement elemToFind = null;
			try {
				switch (enumPageObjects.valueOf(strElemName)) {
				
				case PurchaseOrderID:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Purchase Order']", "XPATH");
					break;
				case Apply:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply' and @title='Apply'])[1]", "XPATH");
					break;
				case btnView:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='View']", "XPATH");
					break;
				case lnkLines:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='PODetail_Line_Item_Tab_lnk']", "XPATH");
					break;
		
			default:
				break;
			}
			report.updateTestLog("YardSlotsPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("YardSlotsPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	
		}
		
		
		/**
		 *********************************************************************** 
		 * Function enters order id in search box and clicks on apply button.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strPurchaseID
		 * @version 1.0
		 ***********************************************************************
		 */
		public void searchPurchaseOrderID(String strPurchaseID){
			try{
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("PurchaseOrderID"), strPurchaseID, "Purchase Order ID");
				libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			} 	
		}
		
		/**
		 *********************************************************************** 
		 * Function validates iLPN status.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strStatus
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateiLPN(String strStatus){
			try{
				String actualStatus=libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][7]", "XPATH").getText();
				if(actualStatus.trim().equals(strStatus))
				{
					report.updateTestLog("Purchase Order Status verification", "Actual Result : "+actualStatus, Status.PASS);
				}else
				{
					report.updateTestLog("Purchase Order status verification", "Actual Result : "+actualStatus +" Expected Result : "+strStatus, Status.FAIL);
				}
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);

			}              
		}
		
		/**
		 *********************************************************************** 
		 * Function verifies purchase order table headers
		 * @return 	Nothing is returned as of now 
		 * @Author 	Aishwarya
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void verifyPOTableHeaders(){
			try {
				libManhattanCommonFunctions.isElementPresentVerification("//span[text()='Purchase Order ID']", "XPATH", "Purchase Order Id");
				libManhattanCommonFunctions.isElementPresentVerification("//span[text()='Business Partner']", "XPATH", "Business Partner");
				libManhattanCommonFunctions.isElementPresentVerification("//span[text()='Status']", "XPATH", "Status");
				libManhattanCommonFunctions.isElementPresentVerification("//span[text()='Ready to Ship']", "XPATH", "Ready to Ship");
				libManhattanCommonFunctions.isElementPresentVerification("//span[text()='Routing request']", "XPATH", "Routing Request");
				libManhattanCommonFunctions.isElementPresentVerification("//span[text()='Lock Status']", "XPATH", "Lock Status");
				libManhattanCommonFunctions.isElementPresentVerification("//span[text()='Origin Info.']", "XPATH", "Origin Info.");
				libManhattanCommonFunctions.isElementPresentVerification("//span[text()='Transportation Responsibility']", "XPATH", "Transportation Responsibility");
				
			} catch (IOException e) {
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			}
		}
		
		/**
		 *********************************************************************** 
		 * Function validates the number of iLPN lines.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Nitika
		 * @param 	striLPNlines
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateiLPNlines(String striLPNlines){
			try{
				libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:POList_entityListView:dataTable']","XPATH", "CheckBox");
				libManhattanCommonFunctions.clickAnyElement(getPageElement("btnView"), "View Button");
				Thread.sleep(4000);
				libManhattanCommonFunctions.clickAnyElement(getPageElement("lnkLines"), "Lines");
				Thread.sleep(2000);
				String actualiLPNlines=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lvLineItems1:dataTablePOLineItem:0:cd1']", "XPATH").getText();
				if(actualiLPNlines.trim().equals(striLPNlines))
				{
					report.updateTestLog("Purchase Order iLPN Lines verification", "Actual Result : "+actualiLPNlines, Status.PASS);
				}else
				{
					report.updateTestLog("Purchase Order iLPN Lines verification", "Actual Result : "+actualiLPNlines +" Expected Result : "+striLPNlines, Status.FAIL);
				}
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);

			}   	
		}
		
		/**
		 *********************************************************************** 
		 * Function validates PO status
		 * @return 	Nothing is returned as of now 
		 * @Author 	Aishwarya
		 * @param 	strPOStatus
		 * @version 1.0 
		 ***********************************************************************
		 */
		public void verifyPOStatus(String strPOStatus) {
			try {
				String stractualPOstatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:POList_entityListView:dataTable:0:aicp2_2']","XPATH").getText();
				if (stractualPOstatus.trim().equals(strPOStatus))
				 {
					report.updateTestLog("Purchase Order Status Verification", "Expected PO Status : "+strPOStatus+" Actual PO Status: "+stractualPOstatus, Status.PASS);
				} else {
					report.updateTestLog("Purchase Order Status Verification", "Expected PO Status : "+strPOStatus+" Actual PO Status: "+stractualPOstatus, Status.FAIL);
				}
			} catch (Exception e) {
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);

			}
		}


}
