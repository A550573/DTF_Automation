package pages;

import java.io.IOException;










import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

/**
 * Any Manhattan Page class
 * @author Cognizant
 */
public class oLPNPage extends AnyManhattanPage
{		

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public oLPNPage(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		try{

		}catch(Exception e){
			report.updateTestLog("oLPNPage-OBJECT IDENTIFICATION", "Error in finding Page Object/element : " + e.getMessage(), Status.FAIL);
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
		if (getCurrentPage("oLPNPage"))
			report.updateTestLog("oLPN Page verification", "oLPN page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("oLPN Page verification", "oLPN page not loaded!!!!", Status.FAIL);
	}

	/**
	 * To use switch case we are declaring the below enum for MyAccount,Login,Logout,MiniCart 
	 */
	private enum enumPageObjects
	{
		btnApply, oLPNNumber, Actions, CanceloLPN, TransitionalInventoryType, BtnConfirm, BtnView, lnkexpand, ItemNum, PalletId, BtnNextPage, HeaderTab;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in oLPNPagePage.
	 * 			Values: btnApply, oLPNNumber, Actions, CanceloLPN, TransitionalInventoryType, BtnConfirm, BtnView
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case oLPNNumber:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find oLPN']", "XPATH");
				break;		
			case btnApply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply' and @title='Apply'])[1]", "XPATH");
				break;
			case Actions:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='Actions']", "XPATH");
				break;
			case CanceloLPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//a[@title='Cancel'])[1]", "XPATH");
				break;
			case TransitionalInventoryType:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:TIType']", "XPATH");
				break;
			case BtnConfirm:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Confirm']", "XPATH");
				break;
			case BtnView:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='View']", "XPATH");
				break;
			case lnkexpand:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='LPNList_Outbound_filterId1_fltrExpCol']", "XPATH");
				break;
			case ItemNum:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:LPNListInOutboundMain_lv:LPNList_Outbound_filterId1:itemLookUpId']", "XPATH");
				break;
			case PalletId:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find oPallet']", "XPATH");
				break;
			case BtnNextPage:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@src='/lps/resources/themes/icons/mablue/arrow_right.gif']", "XPATH");
				break;
			case HeaderTab:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@id='LPN_Header_Tab_lnk']", "XPATH");
				break;
			default:
				break;

			}
			report.updateTestLog("oLPNPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main iLPNPage", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("oLPNPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}



	/**
	 *********************************************************************** 
	 * Function enters oLPN number in search box and click apply button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	stroLPNNumber
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void searchoLPN(String stroLPNNumber) throws InterruptedException{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("oLPNNumber"), stroLPNNumber, "oLPNNumber");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "btnApply");			
		Thread.sleep(6000);
	}

	/**
	 *********************************************************************** 
	 * Function verifies oLPN table headers
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyoLPNTableHeaders(){
		try {
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='LPN']", "XPATH", "LPN Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Type']", "XPATH", "Type Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='LPN Facility Status']", "XPATH", "LPN Facility Status Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Business Unit']", "XPATH", "Bussiness Unit Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Facility']", "XPATH", "Facility Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='LPN Quantity']", "XPATH", "LPN Quantity Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Pallet']", "XPATH", "Pallet Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Item']", "XPATH", "Item Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Shipment']", "XPATH", "Shipment Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Distribution Order']", "XPATH", "Distribution Order Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Locks']", "XPATH", "Locks Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Regulation Set']", "XPATH", "Regulation Set Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Contains Dry Ice']", "XPATH", "Contains Dry Ice Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Overpack']", "XPATH", "Overpack Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Salvage Pack']", "XPATH", "Salvage Pack Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='All Packed In One']", "XPATH", "All Packed In One Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Dry Ice Weight']", "XPATH", "Dry Ice Weight Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Salvage Pack Quantity']", "XPATH", "Salvage Pack Quantity Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Q Value']", "XPATH", "Q Value Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='Special Permits']", "XPATH", "Special Permits Header");
			libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:LPNListInOutboundMain_lv:dataTable_headDiv']//span[text()='CN22 Tracking Number']", "XPATH", "CN22 Tracking Number Header");

		} catch (IOException e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function validates oLPN Status
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateoLPNStatus(String strStatus){
		try{
			//strStatus = "Printed";
			String actualStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_lpnFacilityStatus_param_out']", "XPATH").getText();
			if(actualStatus.trim().equals(strStatus))
			{
				report.updateTestLog("oLPn Status verification", "Status : "+actualStatus +" is verified", Status.PASS);
			}else
			{
				report.updateTestLog("oLPN Status verification","Expected Status : "+strStatus+" Actual Status : "+actualStatus, Status.FAIL);
			}
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			}  
	}
	
	/**
	 *********************************************************************** 
	 * Function search and validates multiple oLPNs.
	 * @return Nothing is returned as of now 
	 * @Author Yagna Priya D
	 * @param strLPN, strLPNFacilityStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchAndValidateMultipleoLPN(String strLPN,String strLPNFacilityStatus){
		try{
			if (strLPN.contains(";")){
				int intLoop = 0;
				for (String strElement : strLPN.split(";")){						
					searchoLPN(strElement);
					Thread.sleep(10000);
					String[] strLPNFacility = strLPNFacilityStatus.split(";");
					
					validateoLPNStatus(strLPNFacility[intLoop]);
					Thread.sleep(10000);
					intLoop = intLoop+1;
					driver.switchTo().defaultContent();
				}
			}else{
				searchoLPN(strLPN);
				validateoLPNStatus(strLPNFacilityStatus);
			}
			
		}catch(Exception e){
			
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function checks if oLPN number exists or not
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	None
	 * @version 1.0
	 * @throws IOException 
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void checkoLPNNotPresent() throws IOException, InterruptedException{
		Thread.sleep(5000);
		if(libManhattanCommonFunctions.verifyElementPresent("//tr[@class='advtbl_row trshow']//td[contains(text(),'No data found')]", "XPATH")){
			report.updateTestLog("oLPn Page", "oLPN is not present", Status.PASS);
		}else{
			report.updateTestLog("oLPn Page", "oLPN is present", Status.FAIL);
		}
		
	}
	
	/**
	 *********************************************************************** 
	 * Function search and checks if multiple oLPNs is present.
	 * @return Nothing is returned as of now 
	 * @Author Yagna Priya D
	 * @param strLPN, strLPNFacilityStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void checkMultipleoLPNpresent(String strLPN){
		try{
			if (strLPN.contains(";")){
				int intLoop = 0;
				for (String strElement : strLPN.split(";")){						
					searchoLPN(strElement);
					Thread.sleep(10000);
					
					checkoLPNNotPresent();
					Thread.sleep(10000);
					intLoop = intLoop+1;
					driver.switchTo().defaultContent();
				}
			}else{
				searchoLPN(strLPN);
				checkoLPNNotPresent();
			}
			
		}catch(Exception e){
			
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function selects the oLPN.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void selectoLPN(){
		try{
			Thread.sleep(8000);
			WebElement wbLPNCheckbox = driver.findElement(By.id("checkAll_c0_dataForm:LPNListInOutboundMain_lv:dataTable"));
			wbLPNCheckbox.click();
		}catch(Exception e){
			report.updateTestLog("oLPN Page", "Element Not Found", Status.FAIL);
		} 
	}
	
	/**
	 *********************************************************************** 
	 * Function cancels carton.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strInventoryType
	 * @version 1.0
	 * @throws Exception 
	 ***********************************************************************
	 */
	public void cancelCarton(String strInventoryType) throws Exception{
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Actions"), "Actions Button");			
		libManhattanCommonFunctions.clickAnyElement(getPageElement("CanceloLPN"), "Cancel Button");
		if(driver.switchTo().alert() != null){
			String alert1 = driver.switchTo().alert().getText();
			System.out.println("alert1 : "+alert1);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
		}else{
			System.out.println("alert not present");
		}
		Thread.sleep(4000);
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("TransitionalInventoryType"), strInventoryType);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnConfirm"), "Confirm Button");
		Thread.sleep(4000);
	}
	
	/**
	 *********************************************************************** 
	 * Function clicks on view button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	None
	 * @version 1.0
	 * @throws InterruptedException  
	 ***********************************************************************
	 */
	public void viewoLPN() throws InterruptedException{			
		libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnView"), "View Button");
		Thread.sleep(4000);
	}
	
	/**
	 *********************************************************************** 
	 * Function cancels carton.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strInventoryType
	 * @version 1.0
	 * @throws Exception 
	 ***********************************************************************
	 */
	public void checkCancelCartonNotPossible() throws Exception{
		if(libManhattanCommonFunctions.verifyElementPresent("(//*[starts-with(text(),'oLPN is in')])[1]", "XPATH")){//"(//*[contains(text(),'oLPN is in loaded status - you must unload it before cancelling')])[1]", "XPATH")){
			report.updateTestLog("oLPn Page", "Cancel carton not possible", Status.PASS);
		}else{
			report.updateTestLog("oLPn Page", "Cancel carton is possible", Status.FAIL);
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function gets the LPN Id of the wave generated.
	 * @return 	strLPNId 
	 * @Author  Nitika
	 * @param 	None
	 * @version 1.0
	 * @throws 	Exception 
	 ***********************************************************************
	 */
	public String getLPNId() throws Exception
	{
		Thread.sleep(2000);
		String strLPNId = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_Link_NameText_param_out']", "XPATH").getText();
		return strLPNId;	
	}
	
	/**
	 *********************************************************************** 
	 * Function enters item number in search box and click apply button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strItemNum,strPallet
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchLPNbyItemNum(String strItemNum, String strPallet)throws InterruptedException{
		
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		libManhattanCommonFunctions.clickAnyElement(getPageElement("lnkexpand"), "expand button");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ItemNum"), strItemNum, "ItemNum");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("PalletId"), strPallet, "PalletId");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "btnApply");
		Thread.sleep(4000);
		
	}
	
	
	/**
     *********************************************************************** 
      * Function retrieves oLPN, validates oLPN status
     * @return    Nothing is returned as of now 
      * @Author    Rahman
     * @param     None
     * @version 1.0
     * @return 
      * @throws InterruptedException 
      ***********************************************************************
     */
     public String[] RetreiveandValidateMultipleOlpn(String stroLPNStatus) throws InterruptedException
     {
            int intRowPointer=0;
            boolean blnFlagValue;             
            String actualStatus ="";
            WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']"));
            List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR")); 
            System.out.println("Task : "+(wbTRList.size()-1));
            String stroLPN[] = new String[(wbTRList.size()-1)];
            for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
            {
                   stroLPN[intPointr] = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:"+intPointr+":LPNList_Outbound_Link_NameText_param_out']", "XPATH").getText();
                   System.out.println(stroLPN[intPointr]);
            }             
            for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
            {              
                   blnFlagValue = false;
                   intRowPointer = intPointr;
                   actualStatus=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:"+intRowPointer+":LPNList_Outbound_lpnFacilityStatus_param_out']", "XPATH").getText();               
                   Thread.sleep(1000);                             
                   if(actualStatus.trim().equals(stroLPNStatus))
                   {
                         report.updateTestLog("oLPN details verification", "oLPN : "+stroLPN[intPointr]+" oLPN Status : "+actualStatus, Status.PASS);
                         blnFlagValue = true;                            
                   }else{
                         blnFlagValue = false;                                  
                   }
                   if (blnFlagValue = false){                      
                         report.updateTestLog("oLPN details verification", "oLPN : "+stroLPN[intPointr]+" Expected oLPN Status : "+stroLPNStatus+" Actual oLPN Status : "+actualStatus, Status.FAIL);
                   }
            }
            return stroLPN;      
     }
     
     
     
     
     
     /**
      *********************************************************************** 
       * Function validates oLPN Status
      * @return    Nothing is returned as of now 
       * @Author    Rahman
      * @param     strStatus,strOLPNs
      * @version 1.0
      ***********************************************************************
      */
      public void validateMultipleoLPNStatus(int stroLPNs, String strStatus){
             try{
                    if (stroLPNs>16)
                    {
                          stroLPNs=16;
                    }
                    for(int i=0;i<stroLPNs;i++)
                    {
                    String actualoLPN = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:"+i+":LPNList_Outbound_Link_NameText_param_out']", "XPATH").getText();  
                    String actualStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:"+i+":LPNList_Outbound_lpnFacilityStatus_param_out']", "XPATH").getText();               
                    if(actualStatus.trim().equals(strStatus))
                    {
                          report.updateTestLog("oLPn Status verification", "oLPN "+(i+1)+" : "+actualoLPN+" || Status : "+actualStatus+" is verified", Status.PASS);
                    }else
                    {
                          report.updateTestLog("oLPN Status verification","oLPN "+(i+1)+" : "+actualoLPN+" || Expected Status : "+strStatus+" Actual Status : "+actualStatus, Status.FAIL);
                    }
                    }
                    }catch(Exception e){
                          report.updateTestLog("Element", "Element Not Found", Status.FAIL);
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
        * @throws InterruptedException 
  	 * @throws IOException 
        ***********************************************************************
       */
       public ArrayList<String> RetreiveandValidateMultipleOlpnStatus(String stroLPNStatus) throws InterruptedException, IOException
       {
      	 	ArrayList<String> strLPNs = new ArrayList<String>();
              int intRowPointer=0, k=0;
              boolean blnFlagValue;             
              String actualStatus ="";
              String stroLPN[];
              do{
  	            WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']"));
  	            List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR")); 
  	            System.out.println("oLPNs : "+(wbTRList.size()-1));
  	            stroLPN = new String[(wbTRList.size()-1)];             
  	            for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
  	            {              
  	                   blnFlagValue = false;
  	                   intRowPointer = intPointr;
  	                   actualStatus=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:"+intRowPointer+":LPNList_Outbound_lpnFacilityStatus_param_out']", "XPATH").getText();               
  	                   Thread.sleep(1000);                             
  	                   if(actualStatus.trim().equals(stroLPNStatus))
  	                   {
  	                	   stroLPN[intPointr] = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:"+intPointr+":LPNList_Outbound_Link_NameText_param_out']", "XPATH").getText();
  	                       System.out.println(stroLPN[intPointr]);
  	                       strLPNs.add(stroLPN[intPointr]);
  	                         report.updateTestLog("oLPN details verification", "oLPN : "+stroLPN[intPointr]+" oLPN Status : "+actualStatus, Status.PASS);
  	                         blnFlagValue = true;                            
  	                   }else{
  	                         blnFlagValue = false;                                  
  	                   }
  	                   if (blnFlagValue = false){                      
  	                         report.updateTestLog("oLPN details verification", "oLPN : "+stroLPN[intPointr]+" Expected oLPN Status : "+stroLPNStatus+" Actual oLPN Status : "+actualStatus, Status.FAIL);
  	                   }
//  	                   if(libManhattanCommonFunctions.verifyElementPresent("//div[@id='dataForm:LPNListInOutboundMain_lv:dataTable_scrollDiv']", "XPATH"))
//  	                   {
////  	                	   Actions actions = new Actions(driver);
////  	                	   actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
////  	                	  WebElement element = driver.findElement(By.id("dataForm:LPNListInOutboundMain_lv:dataTable_scrollDiv"));
////  	                	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
////  	                	 JavascriptExecutor jse = (JavascriptExecutor)driver;
////  	                	 jse.executeScript("scroll(0,250)");
//  	                	   
//  	                	   libManhattanCommonFunctions.clickAnyElement(getPageElement("ScrollDown"), "NextPage Button");
//  	   	                  Thread.sleep(4000);
//  	                   }
  	            }
  	            if(!libManhattanCommonFunctions.verifyElementPresent("//input[@src='/lps/resources/themes/icons/mablue/arrow_right_disabled.gif']", "XPATH"))
  	            {
  	                  k=0;
  	                  libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnNextPage"), "NextPage Button");
  	                  Thread.sleep(4000);
  	            }
  	            else{
  	                  k=1;
  	                  
  	            } 
              }while(k==0);
              return strLPNs;      
       }
       
       

    	/**
   	 *********************************************************************** 
   	 * Function selects the oLPN.
   	 * @return 	Nothing is returned as of now 
   	 * @Author 	Yagna Priya D
   	 * @param 	None
   	 * @version 1.0
   	 * @throws InterruptedException 
   	 ***********************************************************************
   	 */
   	public void selectoLPN(String strLPNNumber) throws InterruptedException{
   		Thread.sleep(3000);
   		List<WebElement> list = driver.findElements(By.xpath(".//*[@class='advtbl_col advtbl_body_col'][4]//span[1]"));
   		int strRowNumToBeChecked = 0;
   		for(WebElement ele:list){
   			if(ele.getText().trim().contains(strLPNNumber.trim())){
   				break;
   			}else{
   				strRowNumToBeChecked = strRowNumToBeChecked + 1;
   				continue;
   			}

   		}
   		libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+strRowNumToBeChecked+"_dataForm:LPNListInOutboundMain_lv:dataTable']", "XPATH", "CheckBox");
   		Thread.sleep(3000);
   	}
   	
   	/**
	 *********************************************************************** 
	 * Function validates oLPN Type
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strLPNType
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void validateoLPNType(String strLPNType) throws InterruptedException{
		libManhattanCommonFunctions.clickAnyElement(getPageElement("HeaderTab"), "Header Tab");
		Thread.sleep(4000);
		try{
			String actualLPNType = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ViewLPNHeaderOutbound_Type_outputText']", "XPATH").getText();
			if(actualLPNType.trim().equals(strLPNType))
			{
				report.updateTestLog("oLPn type verification", "oLPN Type : "+actualLPNType +" is verified", Status.PASS);
			}else
			{
				report.updateTestLog("oLPN type verification","Expected oLPN Type : "+strLPNType+" Actual oLPN Type : "+actualLPNType, Status.FAIL);
			}
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			}  
	}
	
	/**
	 *********************************************************************** 
	 * Function gets the Task Id of the selected Task.
	 * @return 	strTaskId 
	 * @Author  Rahman
	 * @param 	None
	 * @version 1.0
	 * @throws 	Exception 
	 ***********************************************************************
	 */
//	@SuppressWarnings("null")
	public String[] getMultipleItems() throws Exception
	{
		
		Thread.sleep(2000);
		WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']"));
		List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR"));	
		System.out.println("Task : "+(wbTRList.size()-1));
		String strItem[] = new String[(wbTRList.size()-1)];
		for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
		{
		strItem[intPointr] = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:"+intPointr+":Case_LPN_With_PO_LPN_POLine_Item_param_out1_Commnd2']", "XPATH").getText();
		System.out.println(strItem[intPointr]);//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:Case_LPN_With_PO_LPN_POLine_Item_param_out1_Commnd2']
		}
		return strItem;	
	}
	
	/**
	 *********************************************************************** 
	 * Function gets the OLPN Id of the wave generated.
	 * @return 	strLPNId 
	 * @Author  Aishwarya
	 * @param 	None
	 * @version 1.0
	 * @throws 	Exception 
	 ***********************************************************************
	 */
	public String getOLPN() throws Exception
	{	
		String strOLPNId = null;
		try{
			Thread.sleep(8000);
			libManhattanCommonFunctions.waitForElementVisibility("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_Link_NameText_param_out']", 90000);
			strOLPNId = driver.findElement(By.xpath("//span[@id='dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_Link_NameText_param_out']")).getText();
			System.out.println("OLPN number generated is : "+strOLPNId);
			report.updateTestLog("OLPN Number", "OLPN number : "+strOLPNId, Status.PASS);
		}catch(Exception e){
			report.updateTestLog("OLPN Number", "OLPN number : "+strOLPNId, Status.FAIL);
		}
		return strOLPNId;
	}
}
	
	


