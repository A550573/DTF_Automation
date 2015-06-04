package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class ShipmentsPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public ShipmentsPage(ScriptHelper scriptHelper) {
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
			if (getCurrentPage("ShipmentsPage"))
				report.updateTestLog("Shipments Page verification", "Shipments loaded as expected.", Status.DONE);
			else
				report.updateTestLog("Shipments Page verification", "Shipments page loaded not loaded!!!!", Status.FAIL);
		}
		
		private enum enumPageObjects
		{
			Apply, OrderID, ShipmentID, Expand, Actions, CloseShipment, Add, newShipmentID, ShipViaTable, checkMasterShipment, Addbtn, More, Shipment_ID, AssignReleaseDock, DockDoor, TrailerNumber, AddAll, CheckShipment, Save;
		}

		/**
		 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
		 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
		 * 			Values: Apply, OrderID
		 * @return	The WebElement object if it exists. Else returns null
		 */
		private WebElement getPageElement(String strElemName)
		{
			WebElement elemToFind = null;
			try {
				switch (enumPageObjects.valueOf(strElemName)) {
				
				case OrderID:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ShpList_entityListView:Shipmentlist1:field10value1']", "XPATH");
					break;
				case Apply:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@title='Apply'])[1]", "XPATH");
					break;
				case ShipmentID:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Shipment']", "XPATH");
					break;
				case Expand:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@title='Expand']", "XPATH");
					break;
				case Actions:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='Actions']", "XPATH");
					break;
				case CloseShipment:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("(//a[@title='Close'])[1]", "XPATH");
					break;
				case Add:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Add']", "XPATH");
					break;
				case newShipmentID:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:sc_hdr_IP_Ship']", "XPATH");
					break;
				case checkMasterShipment:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:MasterShipmentCustomCheckBox']", "XPATH");
					break;
				case ShipViaTable:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@name='duallistBox_SourceListId']", "XPATH");
					break;//input[@id='dataForm:duallistBoxAdd']
				case Addbtn:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:duallistBoxAdd']", "XPATH");
					break;//input[@id='dataForm:ShpList_entityListView:Shipmentlist1:field20value1']
				case Shipment_ID:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ShpList_entityListView:Shipmentlist1:field20value1']", "XPATH");
					break;
				case More:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='j_id120moreButton']", "XPATH");
					break;
				case AssignReleaseDock:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='AssignDockdoor_button']", "XPATH");
					break;
				case DockDoor:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Dock door']", "XPATH");
					break;
				case TrailerNumber:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:TrailerNumber']", "XPATH");
					break;//input[starts-with(@value,'Add All')]
				case AddAll:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[starts-with(@value,'Add All')]", "XPATH");
					break;//input[@id='checkAll_c0_dataForm:ShpList_entityListView:ShpList_MainListTable']
				case CheckShipment:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='checkAll_c0_dataForm:ShpList_entityListView:ShpList_MainListTable']", "XPATH");
					break;

				case Save:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Save']", "XPATH");
					break;
				
		
			default:
				break;
			}
			report.updateTestLog("WavePage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("WavePage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	
		}
		
		/**
		 *********************************************************************** 
		 * Function enters the order id in search box and clicks on apply button.
		 * @return 	Nothing is returned as of now 
		 * @param 	strOrderID
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void searchOrderID(String strOrderID) throws InterruptedException{
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("OrderID"), strOrderID, "OrderID");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");			
		}
		

		/**
		 *********************************************************************** 
		 * Function validates the shipment status.
		 * @return 	Nothing is returned as of now 
		 * @param 	strShipmentStatus
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateShipmentStatus(String strShipmentStatus){
			try{
				Thread.sleep(3000);
				String actualShipmentStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ShpList_entityListView:ShpList_MainListTable:0:ShpList_ShpStatus_Output2']", "XPATH").getText();
				
				if(actualShipmentStatus.trim().equals(strShipmentStatus))
				{
					report.updateTestLog("Shipment Status verification", "Shipment Status : "+actualShipmentStatus+" is verified", Status.PASS);
				}else
				{
					report.updateTestLog("Shipment Status verification", "Expected Shipment Status : "+strShipmentStatus+" || Actual Shipment Status : "+actualShipmentStatus, Status.FAIL);
				}
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);


			} 
			
		}
		
		/**
		 *********************************************************************** 
		 * Function searches and validates multiple shipment order.
		 * @return 	Nothing is returned as of now 
		 * @param 	strShipmentStatus
		 * @version 1.0
		 ***********************************************************************
		 */
		public void searchAndValidateMultipleShipment(String strOrderID,String strStatus){
			try{
				if (strOrderID.contains(";")){
					int intLoop = 0;
					for (String strElement : strOrderID.split(";")){						
						searchOrderID(strElement);
						Thread.sleep(10000);
						String[] strShipmentStatus = strStatus.split(";");
						
						validateShipmentStatus(strShipmentStatus[intLoop]);
						Thread.sleep(10000);
						intLoop = intLoop+1;
						driver.switchTo().defaultContent();
					}
				}else{
					searchOrderID(strOrderID);					
					validateShipmentStatus(strStatus);
				}
				
			}catch(Exception e){
				
			}
		}
		
		/**
		 *********************************************************************** 
		 * Function validates the service level assigned.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Aishwarya
		 * @param 	strServiceLevel
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateServiceLevel(String strServiceLevel){			
			try{
				String actualServiceLevel = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ShpDtlGen_OutText_FEAS_Servicelevel']", "XPATH").getText();
	            String strshipmentid = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ShpDtl_Out_ShipID']", "XPATH").getText();
				if(actualServiceLevel.trim().equals(strServiceLevel))
				{
					report.updateTestLog("Validate the service level assigned to  Shipment id: "+strshipmentid, "Expected ServiceLevel : "+strServiceLevel+" Actual ServiceLevel : "+actualServiceLevel, Status.PASS);
				}else
				{
					report.updateTestLog("Validate the service level assigned to  Shipment id: "+strshipmentid, "Expected ServiceLevel : "+strServiceLevel+" Actual ServiceLevel : "+actualServiceLevel, Status.FAIL);
				}
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);


			}              
		}
		
		/**
		 *********************************************************************** 
		 * Function checks if shipment exists or not
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	None
		 * @version 1.0
		 * @throws IOException 
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void checkShipmentNotPresent() throws IOException, InterruptedException{
			Thread.sleep(5000);
			if(libManhattanCommonFunctions.verifyElementPresent("//tr[@class='advtbl_row trshow']//td[contains(text(),'No data found')]", "XPATH")){
				report.updateTestLog("Shipments Page", "Shipment is not present", Status.PASS);
			}else{
				report.updateTestLog("Shipments Page", "Shipment is present", Status.FAIL);
			}
			
		}
		
		/**
		 *********************************************************************** 
		 * Function searches and checks if multiple shipment order is present.
		 * @return 	Nothing is returned as of now 
		 * @param 	strShipmentStatus
		 * @version 1.0
		 ***********************************************************************
		 */
		public void checkMultipleShipmentPresent(String strOrderID){
			try{
				if (strOrderID.contains(";")){
					int intLoop = 0;
					for (String strElement : strOrderID.split(";")){						
						searchOrderID(strElement);
						Thread.sleep(10000);			
						checkShipmentNotPresent();
						Thread.sleep(10000);
						intLoop = intLoop+1;
						driver.switchTo().defaultContent();
					}
				}else{
					searchOrderID(strOrderID);					
					checkShipmentNotPresent();
				}
				
			}catch(Exception e){
				
			}
		}
		
		/**
		 *********************************************************************** 
		 * Function enters the shipment id in search box and clicks on apply button.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Nitika
		 * @param 	strShipmentID
		 * @version 1.0
		 ***********************************************************************
		 */
		public void searchShipmentID(String strShipmentID){
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Expand"), "Expand");
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ShipmentID"), strShipmentID, "ShipmentID");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");			
			
		}
		
		/**
		 *********************************************************************** 
		 * Function validates the assigned carrier.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Nitika
		 * @param 	strCarrier
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateAssgndCarrier(String strCarrier){
			try{
				Thread.sleep(2000);
				String actualCarrier=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ShpList_entityListView:ShpList_MainListTable:0:ShpList_AsgnCrrCS_Output2']", "XPATH").getText();
				
				if(actualCarrier.trim().equals(strCarrier))
				{
					report.updateTestLog("Assigned Carrier verification", "Actual Carrier :"+strCarrier, Status.PASS);
				}else
				{
					report.updateTestLog("Assigned Carrier verification", "Actual Carrier :"+actualCarrier+" Expected Carrier :"+strCarrier, Status.FAIL);
				}
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
				} 
		}
		
		
		
		/**
		 *********************************************************************** 
		 * Function selects a shipment and closes it.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Nitika
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void closeShipment()
		{
			try{
			libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:ShpList_entityListView:ShpList_MainListTable']","XPATH", "CheckBox");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Actions"), "Actions");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("CloseShipment"), "Close Shipment");
			Thread.sleep(4000);
			}catch(Exception e){
				
			}
		}
		
		/**
		 *********************************************************************** 
		 * Function validates whether the shipment is closed or not.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Nitika
		 * @param 	strShipmentStatus
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateifShipmentClosed(){
			try{
				Thread.sleep(2000);
				String strShipmentStatus="Yes";
				String actualShipmentStatus=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ShpList_entityListView:ShpList_MainListTable:0:ShpList_shpClosedInd_11']", "XPATH").getText();
				
				if(actualShipmentStatus.trim().equals(strShipmentStatus))
				{
					report.updateTestLog("Shipment Status verification", "Shipment closed successfully", Status.PASS);
				}else
				{
					report.updateTestLog("Shipment Status verification", "Shipment closing failed ", Status.FAIL);
				}
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
				} 
		}
		
		/**
		 *********************************************************************** 
		 * Function clicks on Add button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Rahman
		 * @param 	None
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void clickAdd() throws InterruptedException
		{		
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Add"), "Add Button");		
			Thread.sleep(2000);		
		}
		
		/**
		 *********************************************************************** 
		 * Function enters the shipment id, selects ship via
		 * @return 	Nothing is returned as of now 
		 * @Author 	Rahman
		 * @param 	strShipmentID,strShipVia
		 * @version 1.0
		 * @throws Exception 
		 ***********************************************************************
		 */
		public void enterDetailsforMasterShipment(String strShipmentID,String strShipVia) throws Exception{
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));		
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("newShipmentID"), strShipmentID, "ShipmentID");
			Thread.sleep(3000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("checkMasterShipment"), "Check Master Shipment");
			Thread.sleep(3000);		
			if(strShipVia.equals(""))
			{
				libManhattanCommonFunctions.clickAnyElement(getPageElement("AddAll"), "Add All Button");
				Thread.sleep(3000);
			}
			else{
			libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("ShipViaTable"), strShipVia);
			Thread.sleep(3000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Addbtn"), "Add Button");
			Thread.sleep(3000);
			}
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Save"), "Save Button");

		}
		
		/**
		 *********************************************************************** 
		 * Function enters the order id in search box and clicks on apply button.
		 * @return 	Nothing is returned as of now 
		 * @author 	Rahman
		 * @param 	None
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void checkShipment() throws InterruptedException{
			//driver.switchTo().defaultContent();		
			libManhattanCommonFunctions.clickAnyElement(getPageElement("CheckShipment"), "Click Shipment");
			Thread.sleep(2000);	
	}
		
		/**
		 *********************************************************************** 
		 * Function clicks on more button.
		 * @return 	Nothing is returned as of now 
		 * @author 	Rahman
		 * @param 	None
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void clickMore() throws InterruptedException{
			//driver.switchTo().defaultContent();		
			libManhattanCommonFunctions.clickAnyElement(getPageElement("More"), "More Button");
			Thread.sleep(2000);			
		}
		
		/**
		 *********************************************************************** 
		 * Function assigns release dock door.
		 * @return 	Nothing is returned as of now 
		 * @author 	Rahman
		 * @param 	None
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void clickAssignReleaseDock() throws InterruptedException{
			//driver.switchTo().defaultContent();		
			libManhattanCommonFunctions.clickAnyElement(getPageElement("AssignReleaseDock"), "Assign Release Dock Button");
			Thread.sleep(6000);	
		}
		
		/**
		 *********************************************************************** 
		 * Function enters the Dock Door, Trailer
		 * @return 	Nothing is returned as of now 
		 * @author 	Rahman
		 * @param 	strDockDoor, strTrailer
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void enterAssignReleaseDockDetails(String strDockDoor,String strTrailer) throws InterruptedException{
			driver.switchTo().defaultContent();		
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DockDoor"), strDockDoor, "Shipment ID");
			Thread.sleep(2000);	
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("TrailerNumber"), strTrailer, "Trailer");
			Thread.sleep(2000);			
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Save"), "Save Button");
			Thread.sleep(5000);			
		}

}
