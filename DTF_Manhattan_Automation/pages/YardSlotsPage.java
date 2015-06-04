package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class YardSlotsPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public YardSlotsPage(ScriptHelper scriptHelper) {
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
			if (getCurrentPage("YardSlotsPage"))
				report.updateTestLog("Yard Slots Page verification", "Yards Slots loaded as expected.", Status.DONE);
			else
				report.updateTestLog("Yard Slots Page verification", "Yards Slots page loaded not loaded!!!!", Status.FAIL);
		}
		
		
		private enum enumPageObjects
		{
			Yard, YardZone, YardSlot,Apply, Trailer, Save, AlertOKBtn, Carrier;
		}

		/**
		 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
		 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
		 * 			Values: Yard, YardZone, YardSlot,Apply, Trailer, Save, AlertOKBtn, Carrier
		 * @return	The WebElement object if it exists. Else returns null
		 */
		private WebElement getPageElement(String strElemName)
		{
			WebElement elemToFind = null;
			try {
				switch (enumPageObjects.valueOf(strElemName)) {
				
				case Yard:
					elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:lview:filterId:yardLookUpFilterId']", "XPATH");
					break;
				case YardZone:
					elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:lview:filterId:yardZoneLookUpFilterId']", "XPATH");
					break;
				case YardSlot:
					elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:lview:filterId:yardZoneSlotLookUpFilterId']", "XPATH");
					break;
				case Apply:
					elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:lview:filterId:filterIdapply']", "XPATH");
					break;
				case Trailer:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:trailer']", "XPATH");
					break;
				case Save:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Save']", "XPATH");
					break;
				case AlertOKBtn:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:SlotOK']", "XPATH");
					break;
				case Carrier:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:carrierText']", "XPATH");
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
		 * Function Yard, YardSlot and  YardZone in the search box and clicks apply button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strYard, strYardZone, strYardSlot
		 * @version 1.0
		 ***********************************************************************
		 */
		public void searchYardZone(String strYard, String strYardZone, String strYardSlot){
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Yard"), strYard, "Yard");
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("YardZone"), strYardZone, "YardZone");
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("YardSlot"), strYardSlot, "YardSlot");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");	
			libManhattanCommonFunctions.waitForElementClickable(strYardSlot, strYardSlot, 1000);
			
		}
		
		/**
		 *********************************************************************** 
		 * Function click on any element in yard slot page
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strElementName
		 * @version 1.0
		 ***********************************************************************
		 */
		public void clickAnyElementInYardSlotsPage(String strElementName){
			try{
				libManhattanCommonFunctions.clickAnyElement(getPageElement(strElementName), strElementName);
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			} 
		}
		
		/**
		 *********************************************************************** 
		 * Function verifies yard slot table headers
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void verifyYardSlotTableHeaders(){
			try {
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Yard']", "XPATH", "Yard Header");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Yard Zone']", "XPATH", "Yard Zone Header");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Yard Zone Slot']", "XPATH", "Yard Zone Slot Header");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Status']", "XPATH", "Status Header");
			} catch (IOException e) {
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			}
		}
		
		/**
		 *********************************************************************** 
		 * Function selects the yard slot and verifies datas in details tab 
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strYardZoneSlotNum
		 * @version 1.0
		 ***********************************************************************
		 */
		public void clickCheckBoxAndVerifyYardSlotDeatils(String strYardZoneSlotNum){
			List<WebElement> list = driver.findElements(By.xpath(".//*[@class='advtbl_col advtbl_body_col'][3]//span[1]"));
			int strRowNumToBeChecked = 0;
			for(WebElement ele:list){
				if(ele.getText().trim().contains(strYardZoneSlotNum.trim())){
					break;
				}else{
					strRowNumToBeChecked = strRowNumToBeChecked + 1;
					continue;
				}
				
			}
			libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+strRowNumToBeChecked+"_dataForm:lview:dataTable']", "XPATH", "CheckBox");
			String strYard = driver.findElement(By.xpath(".//*[@id='dataForm:lview:dataTable:"+strRowNumToBeChecked+":dis1']")).getText();
			String strYardZone = driver.findElement(By.xpath(".//*[@id='dataForm:lview:dataTable:"+strRowNumToBeChecked+":custId52']")).getText();
			String strYardZoneSlot = driver.findElement(By.xpath(".//*[@id='dataForm:lview:dataTable:"+strRowNumToBeChecked+":custId524']")).getText();
			String strStatus = driver.findElement(By.xpath(".//*[@id='dataForm:lview:dataTable:"+strRowNumToBeChecked+":dis3']")).getText();
			try {
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:glid1']//span[text()='Yard:']", "XPATH", "Yard Under Details Tab");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:glid1']//span[text()='Yard Zone:']", "XPATH", "Yard Zone Under Details Tab");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:glid1']//span[text()='Yard Zone Slot:']", "XPATH", "Yard Zone Slot Under Details Tab");
				//libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:glid1']//span[text()='Current Capacity:']", "XPATH", "Current Capacity Under Details Tab");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:glid1']//span[text()='Trailer:']", "XPATH", "Trailer Under Details Tab");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:glid1']//span[text()='Carrier:']", "XPATH", "Carrier Under Details Tab");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:glid1']//span[text()='Status:']", "XPATH", "Status Under Details Tab");
				
			} catch (IOException e) {
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			}
			try {
				libManhattanCommonFunctions.isElementPresentContainsText(".//*[@id='dataForm:yardTextBx']", "XPATH", "Yard text box", strYard);
				libManhattanCommonFunctions.isElementPresentContainsText(".//*[@id='dataForm:zoneNameText']", "XPATH", "Yard Zone Name Text", strYardZone);
				libManhattanCommonFunctions.isElementPresentContainsText(".//*[@id='dataForm:slotNameText']", "XPATH", "Yard Zone Slot Name Text", strYardZoneSlot);
				libManhattanCommonFunctions.isElementPresentContainsText(".//*[@id='dataForm:statDtlTextOut']", "XPATH", "Status Text", strStatus);
				
			} catch (IOException e) {
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			}	
		}
		
		/**
		 *********************************************************************** 
		 * Function enters trailer in trailer text box in details tab 
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strTrailer
		 * @version 1.0
		 ***********************************************************************
		 */
		public void enterTrailerDetails(String strTrailer){
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Trailer"), strTrailer, "Trailer");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Carrier"), "Carrier");
		}
		
		/**
		 *********************************************************************** 
		 * Function clicks on save button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void clickSaveButton(){
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Save"), "Save");
		}
		
		/**
		 *********************************************************************** 
		 * Function create task alert
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	None
		 * @version 1.0
		 * @throws 	InterruptedException 
		 ***********************************************************************
		 */
		public void createLiveTrailerAlert() throws InterruptedException{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='dataForm:SlotOK']")).click();
			Thread.sleep(3000);						
		}
		
		/**
		 *********************************************************************** 
		 * Function validates yard slot status
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strStatus
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateYardSlotStatus(String strStatus){
			try{
				String actualStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:statDtlTextOut']", "XPATH").getText();
				
				if(actualStatus.trim().equals(strStatus))
				{
					report.updateTestLog("Yard slot status verification", "Yard slot status : "+actualStatus+" is verified", Status.PASS);
				}else
				{
					report.updateTestLog("Yard slot status verification", "Expected Status :"+strStatus+" Actual Status : "+actualStatus, Status.FAIL);
				}
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);


			}  						
		}
		
		/**
		 *********************************************************************** 
		 * Function checks if carrier is updated in the details tab
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	None
		 * @version 1.0
		 * @throws 	InterruptedException 
		 ***********************************************************************
		 */
		public void checkCarrierExists() throws InterruptedException{
			
			Thread.sleep(4000);
			String strCarrier = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:carrierTextOut']", "XPATH").getText();
			if (!(strCarrier.isEmpty()))
				report.updateTestLog("Carrier verification", "Carrier : "+strCarrier+" is present", Status.PASS);
			else
				report.updateTestLog("Carrier verification", "Carrier : "+strCarrier+" is not present", Status.FAIL);
		}

		/**
		 *********************************************************************** 
		 * Function checks trailer status in the details tab
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void checkTrailerExists(){
			String strStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:statDtlTextOut']", "XPATH").getText();
			String strTrailer = libManhattanCommonFunctions.getElementByProperty(".//*[starts-with(@id,'dataForm:trailer')]", "XPATH").getText();
			if (strStatus.trim().equals("In Use (Full)") && (!strTrailer.trim().isEmpty()))
				report.updateTestLog("Trailer verification", "Status : "+strStatus+" and Trailer :"+strTrailer+"is validated", Status.PASS);
			else if (strStatus.trim().equals("Open") && strTrailer.trim().isEmpty())
				report.updateTestLog("Trailer verification", "Status : "+strStatus+" and Trailer is not assigned", Status.PASS);
			else if (strStatus.trim().equals("Pending In Use") && strTrailer.trim().isEmpty())
				report.updateTestLog("Trailer verification", "Status : "+strStatus+" and Trailer is not assigned", Status.PASS);
			else if (strStatus.trim().equals("Close") && !strTrailer.trim().isEmpty())
				report.updateTestLog("Trailer verification", "Status : "+strStatus+" and Trailer :"+strTrailer+"is validated", Status.PASS);
			else
				report.updateTestLog("Trailer verification", "Status : "+strStatus+" and Trailer :"+strTrailer, Status.FAIL);
		}
}
