package pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class DistributionOrderPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	ScriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public DistributionOrderPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("DistributionOrderPage"))
			report.updateTestLog("Distribution Order Page verification", "Distribution Order loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Distribution Order Page verification", "Distribution Order page loaded not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		Apply, DistributionOrderID, BtnView, BtnCancel, ShippingTab, Btn_Back, Btn_More, Btn_Wave, lnkShipmentid, btn_EditDate, CheckALL, DOLineTab;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Apply, DistributionOrderID, BtnView, BtnCancel
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case DistributionOrderID:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Distribution Order']", "XPATH");
				break;
			case Apply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@title='Apply'])[1]", "XPATH");
				break;
			case BtnView:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='View Distribution Order Details']", "XPATH");
				break;
			case BtnCancel:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@alt='Cancel']", "XPATH");
				break;
			case ShippingTab:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='DODetailsMainHeader_Shipping_lnk']", "XPATH");
				break;
			case Btn_Back:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='backButton']", "XPATH");   
				break;
			case Btn_More:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='j_id129moreButton']", "XPATH");
				break;
			case Btn_Wave:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='DO_List_Wave_Order_button']", "XPATH");    
				break; 
			case lnkShipmentid:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:shipmentIdRepeat1:0:DODtlHdr_ShpId_OpLnk_Txt__']", "XPATH");
				break;
			case btn_EditDate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Edit Dates']", "XPATH");
				break;

			case CheckALL:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@name='dataForm:DOList_entityListView:DOList_MainListTable_checkAll']", "XPATH");
				break;
			case DOLineTab:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='DODetailsMainHeader_DOLines_lnk']", "XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("DistributionOrderPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("DistributionOrderPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 ************************************************************************ 
	 * Function enters order number in search box and clicks on apply button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strDistributionOrderID
	 * @version 1.0
	 ************************************************************************
	 */
	public void searchDistributionOrderID(String strDistributionOrderID){
		try{		
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			refreshWindow();
			libManhattanCommonFunctions.clearAndEnterText("//input[@alt='Find Distribution Order']", "XPATH", strDistributionOrderID);
			Thread.sleep(3000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");
			Thread.sleep(3000);
		}catch(Exception e){

		}
	}

	/**
	 *********************************************************************** 
	 * Function validates Distribution Order details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strDistributionOrderID, strFulfillmentStatus, strOrderDate
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateDistributionOrderDetails(String strDistributionOrderID, String strFulfillmentStatus, String strOrderDate){
		try{
			Thread.sleep(2000);
			WebElement wbWavesCheckbox = driver.findElement(By.id("checkAll_c0_dataForm:DOList_entityListView:DOList_MainListTable"));
			wbWavesCheckbox.click();
			libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnView"), "ViewButton");

			libManhattanCommonFunctions.waitForElementVisibility(".//*[@id='dataForm:DODetailsMainHeader_Out_DOID']", 2000);
			String actualDistributionOrderID=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:DODetailsMainHeader_Out_DOID']", "XPATH").getText();
			String actualFulfillmentStatus=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:DODetailsMainHeader_Out_FulfillmentStatus']", "XPATH").getText();
			String actualOrderDate=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:DODetailsMainHeader_Out_ODateTime']", "XPATH").getText();
			if(actualDistributionOrderID.trim().equals(strDistributionOrderID) && actualFulfillmentStatus.trim().equals(strFulfillmentStatus) && actualOrderDate.trim().equals(strOrderDate))
			{
				report.updateTestLog("Distribution Order Details verification", "Distribution Order Details verified successfully", Status.PASS);
			}else
			{
				report.updateTestLog("Distribution Order Details verification", "Distribution Order Details verification failed ", Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		} 
	}

	/**
	 *********************************************************************** 
	 * Function validates Distribution Order status
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strFulfillmentStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateDistributionOrderStatus(String strFulfillmentStatus){
		try{
			Thread.sleep(2000);
			String actualFulfillmentStatus=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:DOList_entityListView:DOList_MainListTable:0:DOList_OrderFulfillmentStatus_Output2']", "XPATH").getText();
			if(actualFulfillmentStatus.trim().equals(strFulfillmentStatus))
			{
				report.updateTestLog("Distribution Order Status verification", "Status : "+actualFulfillmentStatus+" is verified", Status.PASS);
			}else
			{
				report.updateTestLog("Distribution Order Status verification", "Expected status : "+strFulfillmentStatus+" || Actual Status : "+actualFulfillmentStatus, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 
	}

	/**
	 **************************************************************************************************************** 
	 * Function searches order number and validates order status for multiple order numbers seperated by semicolon(;)
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strOrderNumbers, strFulfillmentStatus
	 * @version 1.0
	 *****************************************************************************************************************
	 */
	public void loopSearchDistributionOrder(String strOrderNumbers,String strFulfillmentStatus){
		try{
			if (strOrderNumbers.contains(";")){
				int intLoop = 0;
				for (String strElement : strOrderNumbers.split(";")){						
					searchDistributionOrderID(strElement);
					Thread.sleep(10000);
					String[] strFulfillment =strFulfillmentStatus.split(";");
					validateDistributionOrderStatus(strFulfillment[intLoop]);
					Thread.sleep(10000);
					intLoop = intLoop+1;
					driver.switchTo().defaultContent();
				}
			}else{
				searchDistributionOrderID(strOrderNumbers);
				validateDistributionOrderStatus(strFulfillmentStatus);
			}
		}catch(Exception e){

		}
	}

	/**
	 *********************************************************************** 
	 * Function validates Distribution Order table headers
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyDistributionOrderTableHeaders(){
		try{
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:DOList_entityListView:DOList_MainListTable']//span[text()='Distribution Order']", "XPATH", "Distribution Order Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:DOList_entityListView:DOList_MainListTable']//span[text()='Fulfillment Status']", "XPATH", "Fulfillment Status Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:DOList_entityListView:DOList_MainListTable']//span[text()='Origin']", "XPATH", "Origin Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:DOList_entityListView:DOList_MainListTable']//span[text()='Pickup Start']", "XPATH", "Pickup Start Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:DOList_entityListView:DOList_MainListTable']//span[text()='Destination']", "XPATH", "Destination Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:DOList_entityListView:DOList_MainListTable']//span[text()='Delivery End']", "XPATH", "Delivery End Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:DOList_entityListView:DOList_MainListTable']//span[text()='Staging Location']", "XPATH", "Staging Location Header");
		}catch(Exception e){
		}
	}

	/**
	 *********************************************************************** 
	 * Function validates Distribution Order status
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strDistributionOrderID, strFulfillmentStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateDistributionOrderDetails(String strDistributionOrderID, String strFulfillmentStatus){
		try{
			Thread.sleep(2000);
			WebElement wbWavesCheckbox = driver.findElement(By.id("checkAll_c0_dataForm:DOList_entityListView:DOList_MainListTable"));
			wbWavesCheckbox.click();
			libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnView"), "ViewButton");

			libManhattanCommonFunctions.waitForElementVisibility(".//*[@id='dataForm:DODetailsMainHeader_Out_DOID']", 2000);
			String actualDistributionOrderID=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:DODetailsMainHeader_Out_DOID']", "XPATH").getText();
			String actualFulfillmentStatus=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:DODetailsMainHeader_Out_FulfillmentStatus']", "XPATH").getText();
			//String actualOrderDate=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:DODetailsMainHeader_Out_ODateTime']", "XPATH").getText();
			if(actualDistributionOrderID.trim().equals(strDistributionOrderID) && actualFulfillmentStatus.trim().equals(strFulfillmentStatus))
			{
				report.updateTestLog("Distribution Order Details verification", "Distribution Order Id : "+actualDistributionOrderID+" || Actual Fullfillment Status: "+actualFulfillmentStatus, Status.PASS);
			}else
			{
				report.updateTestLog("Distribution Order Details verification", "Expected Distibution Order Id : "+strDistributionOrderID+" || Actual Distribution Order Id : "+actualDistributionOrderID+" || Expected FullFillment Status : "+strFulfillmentStatus+" || Actual Fullfillment Status: "+actualFulfillmentStatus, Status.FAIL);;
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		} 
	}

	/**
	 *********************************************************************** 
	 * Function validates RouteTo, Route Type1, Route Type 2 fields
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strRouteTo,strRouteType1,strRouteType2
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateRouteInfo(String strRouteTo, String strRouteType1, String strRouteType2){
		try{
			libManhattanCommonFunctions.clickAnyElement(getPageElement("ShippingTab"), "Shipping Tab");
			String strActualRouteTo = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:DODetailsShipping_OutText_Routeto']", "XPATH").getText();
			String strActualRouteType1 = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:DODetailsShipping_OutText_Routetype1']", "XPATH").getText();
			String strActualRouteType2 = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:DODetailsShipping_OutText_Routetype2']", "XPATH").getText();
			if(strActualRouteTo.trim().equals(strRouteTo) && strActualRouteType1.trim().equals(strRouteType1) && strActualRouteType2.trim().equals(strRouteType2))

			{
				report.updateTestLog("Validate Route Details", "Route To : "+strActualRouteTo+" || Route Type1 : "+strActualRouteType1+" || Route Type2 : "+strActualRouteType2, Status.PASS);
			}else
			{
				report.updateTestLog("Validate Route Details", "Expected Route To : "+strRouteTo+" || Actual Route To : "+strActualRouteTo+" || Expected Route Type1: "+strRouteType1+" || Actual Route Type1 : "+strActualRouteType1+" || Expected Route Type2 : "+strRouteType2+" || Actual Route Type2 : "+strActualRouteType2, Status.FAIL);
			}
		}
		catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 ************************************************************************ 
	 * Function clicks on back button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	null
	 * @version 1.0
	 ************************************************************************
	 */
	public void clickBackButton(){
		try{		

			libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_Back"), "Back Button");			
		}catch(Exception e){

		}
	}

	/**
	 ************************************************************************ 
	 * Function clicks on wave button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	null
	 * @version 1.0
	 ************************************************************************
	 */
	public void clickWaveOption(){
		try{		
			WebElement wbWavesCheckbox = driver.findElement(By.id("checkAll_c0_dataForm:DOList_entityListView:DOList_MainListTable"));
			wbWavesCheckbox.click();
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_More"), "More Button");	
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_Wave"), " Select Wave Option");	
		}catch(Exception e){

		}
	}
	
	/**
	 *********************************************************************** 
	 * Function validates the Transportation status.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strTransportationstatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateTransportationStatus(String strTransportationStatus){			
		try{
			String actualTransportationStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:DODetailsMainHeader_Out_TransStatus']", "XPATH").getText();
			String strDistributionOrderid = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:DODetailsMainHeader_Out_DOID']", "XPATH").getText();
			if(actualTransportationStatus.trim().equals(strTransportationStatus))
			{
				report.updateTestLog("Transportation Status Validation for  Distribution Order id: "+strDistributionOrderid, "Actual Transportation status : "+actualTransportationStatus+ " is verified", Status.PASS);
			}else
			{
				report.updateTestLog("Transportation Status Validation for  Distribution Order id: "+strDistributionOrderid, "Actual Transportation status : "+actualTransportationStatus+ " is verified", Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);


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
			String actualServiceLevel = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:DODetailsHeader_OutText_Assigned_Servicelevel']", "XPATH").getText();
			String strDistributionOrderid = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:DODetailsMainHeader_Out_DOID']", "XPATH").getText();
			if(actualServiceLevel.trim().equals(strServiceLevel))
			{
				report.updateTestLog("Validate the service level assigned to  Distribution Order id: "+strDistributionOrderid, "Expected ServiceLevel : "+strServiceLevel+" Actual ServiceLevel : "+actualServiceLevel, Status.PASS);
			}else
			{
				report.updateTestLog("Validate the service level assigned to  Distribution Order id: "+strDistributionOrderid, "Expected ServiceLevel : "+strServiceLevel+" Actual ServiceLevel : "+actualServiceLevel, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);


		}              
	}

	/**
	 *********************************************************************** 
	 * Function to verify the shipment id generated.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateShipmentid(){			
		try{
			String ShipmentIdGenerated = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:shipmentIdRepeat1:0:DODtlHdr_ShpId_OpLnk_Txt__']", "XPATH").getText();
			if(ShipmentIdGenerated != null)
			{
				report.updateTestLog("Verify Shipment id generation ", "Shipment id "+ShipmentIdGenerated+" is generated successfully ", Status.PASS);
			}else
			{
				report.updateTestLog("Verify Shipment id generation ", "Shipment id "+ShipmentIdGenerated+" is generated successfully ", Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 ************************************************************************ 
	 * Function clicks on shipment id
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	None
	 * @version 1.0
	 ************************************************************************
	 */
	public void clickShipmentId(){
		try{		
			libManhattanCommonFunctions.clickAnyElement(getPageElement("lnkShipmentid"), "Shipment Id Link");	
		}catch(Exception e){

		}
	}

	/**
	 ************************************************************************ 
	 * Function edits the delivery date
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ************************************************************************
	 */
	public void EditDeliveryDate(){
		try{		
			WebElement wbWavesCheckbox = driver.findElement(By.id("checkAll_c0_dataForm:DOList_entityListView:DOList_MainListTable"));
			wbWavesCheckbox.click();
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btn_EditDate"), "Edit Date Button");	
			Thread.sleep(2000);
		}catch(Exception e){

		}
	}

	/**
	 ************************************************************************ 
	 * Function selects all DOs and runs the wave
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	None
	 * @version 1.0
	 ************************************************************************
	 */
	public void WaveAllDO(){
		try{		
			libManhattanCommonFunctions.clickAnyElement(getPageElement("CheckALL"), "Check All");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_More"), "More Button");	
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_Wave"), " Select Wave Option");	
		}catch(Exception e){

		}
	}

	/**
	 ************************************************************************ 
	 * Function clicks on wave button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	null
	 * @version 1.0
	 ************************************************************************
	 */
	public void selectAllWave(){
		try{		
			WebElement wbWavesCheckbox = driver.findElement(By.xpath("//input[@name='dataForm:DOList_entityListView:DOList_MainListTable_checkAll']"));
			wbWavesCheckbox.click();
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_More"), "View Button");	
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_Wave"), " Select Wave Option");	
		}catch(Exception e){

		}
	}

	/**
	 *********************************************************************** 
	 * Function to selects and views distribution order
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void viewDistributionOrder(){
		try{
			Thread.sleep(2000);
			WebElement wbWavesCheckbox = driver.findElement(By.id("checkAll_c0_dataForm:DOList_entityListView:DOList_MainListTable"));
			wbWavesCheckbox.click();
			libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnView"), "ViewButton");
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}
	}

	/**
	 **************************************************************************************************************** 
	 * Function validates line status for multiple items separated by semicolon (;)
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strItem, strLineStatus
	 * @version 1.0
	 *****************************************************************************************************************
	 */
	public void validateMultipleDOLines(String strItem, String strLineStatus){
		try{
			if (strItem.contains(";")){
				int intLoop = 0;
				for (String strElement : strItem.split(";")){
					String[] strDOStatus =strLineStatus.split(";");
					validateDOLines(strElement, strDOStatus[intLoop]);
					Thread.sleep(6000);
					intLoop = intLoop+1;
				}
			}else{
				validateDOLines(strItem, strLineStatus);
			}
		}catch(Exception e){

		}
	}

	/**
	 *********************************************************************** 
	 * Function validates item and line status in DO Lines tab
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strItem, strLineStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateDOLines(String strItem, String strLineStatus){
		int strRowNum = 0;
		libManhattanCommonFunctions.clickAnyElement(getPageElement("DOLineTab"), "DO Lines Tab");
		List<WebElement> list = driver.findElements(By.xpath("//tr[starts-with(@class,'advtbl_row -dg_t')]//td[@class='advtbl_col advtbl_body_col'][3]"));/*(By.xpath(".//*[@id='dataForm:DODetailOrderLinesList_lv:DODetailsOrderLinelist:"+strRowNum+":DODetailOrderLinesList_ItemID_Link_NameText']"));*/
		for(WebElement ele:list){
			if(ele.getText().trim().contains(strItem.trim())){
				System.out.println("Item : "+strItem);
				break;
			}else{
				strRowNum= strRowNum + 1;
				continue;
			}	
		}
		String actualLineStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:DODetailOrderLinesList_lv:DODetailsOrderLinelist:"+strRowNum+":DODetailOrderLinesList_LineItemStatusLink_NameText']", "XPATH").getText();
		if(actualLineStatus.trim().equals(strLineStatus))
		{
			report.updateTestLog("LineStatus validation","Item :"+strItem+" || LineStatus : "+actualLineStatus+ "is verified", Status.PASS);
		}else
		{
			report.updateTestLog("LineStatus validation","Item : "+strItem+" || Expected LineStatus : "+strLineStatus+" Item : "+strItem+" || Actual LineStatus : "+actualLineStatus, Status.FAIL);
		}
	}
	
	/**
     *********************************************************************** 
      * Function retrieves oLPN, validates oLPN status
     * @return    Nothing is returned as of now 
      * @Author    Rahman
     * @param     None
     * @version 1.0
     * @return 
      * @throws Exception 
      ***********************************************************************
     */
     public String[] RetreiveandValidateOrder(String strDOorder) throws Exception
     {                       
            String[] actualDO = splitDataValuesWithComa(strDOorder);
            WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:DOList_entityListView:DOList_MainListTable_body']"));
            List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR")); 
            System.out.println("DO : "+(wbTRList.size()-1));
            String strDO[] = new String[(wbTRList.size()-1)];             
            for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
            {
                   strDO[intPointr] = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:DOList_entityListView:DOList_MainListTable:"+intPointr+":DOList_DOId_Link_Param_Out']", "XPATH").getText();
                   System.out.println(strDO[intPointr]);
            }  
            for(int i=0; i<actualDO.length; i++)
            {
                   FileWriter file = new FileWriter("H:\\DO_Missing.txt",true);
                   BufferedWriter output = new BufferedWriter((file)); 
                   PrintWriter out = new PrintWriter(output);
                   System.out.println();
                   for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
                   {                                                           
                         if(actualDO[i].trim().equals(strDO[intPointr].trim()))
                         {
                                System.out.println(" =============== ");
                                report.updateTestLog("DO details verification", "DO : "+strDO[intPointr], Status.PASS); 
                                System.out.println(actualDO[i]);  
                                out.println(" =================== ");  
                                output.write(actualDO[i]);
                                output.write("\r\n");
                                break;                            
                         }else{

                         }                    
                   }
                   System.out.println(" =============== ");
                   System.out.println(actualDO[i]);  
                   System.out.println(" =============== ");
                   out.println(" =================== ");  
                   output.write(actualDO[i]);
                   output.write("\r\n");
                   output.close();
            }             
            return strDO;      
     }

}
