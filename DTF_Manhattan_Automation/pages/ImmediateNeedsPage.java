package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class ImmediateNeedsPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 * @author Rahman
	 ***********************************************************************
	 */
	public ImmediateNeedsPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("ImmediateNeedsPage"))
			report.updateTestLog("Immediate Needs Page verification", "Immediate Needs Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Immediate Needs Page verification", "Immediate Needs Page loaded not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		Apply, DistributionOrderID, BtnView, BtnCancel, ShippingTab, Btn_Back, Btn_More, Btn_Wave, lnkShipmentid, Btn_Add, Business_Unit, Permanent_Need, Priority, Item, SingleUseItemiLPN, QuantityRequired, NeedUOM, ExcessAllowance, UnlockNeed, Putaway_Type, Lock_Code, Need_Status, Btn_Save, Btn_Edit, Check_Single_Item, Prep_Code, searchItem, Btn_View;
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
				break;//input[@value='Save']
			case Btn_Add:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Add']", "XPATH");   
				break;//select[@id='dataForm:cdMasterId']
			case Btn_Save:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Save']", "XPATH");   
				break;//select[@id='dataForm:cdMasterId']//input[@value='Edit']			
			case Business_Unit:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:cdMasterId']", "XPATH");   
				break;
			case Permanent_Need:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:permanentNeed']", "XPATH");   
				break;
			case Priority:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:prty_text']", "XPATH");   
				break;
			case Item:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:skuEditCtrl']", "XPATH");   
				break;
			case SingleUseItemiLPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:singleSKUCaseOnly']", "XPATH");   
				break;
			case QuantityRequired:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:required']", "XPATH");   
				break;
			case NeedUOM:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:needUOM']", "XPATH");   
				break;
			case ExcessAllowance:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:percentExcessAllowed']", "XPATH");   
				break;//input[@id='dataForm:percentExcessAllowed']
			case UnlockNeed:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:removeLockFlag']", "XPATH");   
				break;
			case Putaway_Type:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:casePutawayType']", "XPATH");   
				break;
			case Lock_Code:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:caseLock']", "XPATH");   
				break;
			case Need_Status:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:statusUpdate']", "XPATH");   
				break;//input[@id='dataForm:ItemFacilityList_lv:ItemFacilityList_filterId:itemLookUpId']
			case searchItem:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ItemFacilityList_lv:ItemFacilityList_filterId:itemLookUpId']", "XPATH");   
				break;//input[@id='checkAll_c0_dataForm:ItemFacilityList_lv:dataTable']
			case Btn_Edit:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Edit']", "XPATH");   
				break;//input[@id='checkAll_c0_dataForm:ItemFacilityList_lv:dataTable']
			case Check_Single_Item:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='checkAll_c0_dataForm:ItemFacilityList_lv:dataTable']", "XPATH");   
				break;//input[@id='dataForm:ItemFacilityDetails_ITIWMSLOTMisc6']
			case Prep_Code:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ItemFacilityDetails_ITIWMSLOTMisc6']", "XPATH");   
				break;//img[@id='backImage']//input[@value='View']
			case Btn_View:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='View']", "XPATH");   
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
	 * Function clicks on back button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	null
	 * @version 1.0
	 * @throws InterruptedException 
	 ************************************************************************
	 */
	public void clickAddButton() throws InterruptedException{	
		driver.switchTo().defaultContent();		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_Add"), "Add Button");		
		Thread.sleep(5000);		
	}
	/**
	 ************************************************************************ 
	 * Function clicks on back button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	null
	 * @version 1.0
	 * @throws InterruptedException 
	 ************************************************************************
	 */
	public void clickSaveButton() throws InterruptedException{
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_Save"), "Save Button");			
		Thread.sleep(5000);		
	}
	/**
	 ************************************************************************ 
	 * Function applies FR immediate needs
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	null
	 * @version 1.0
	 * @throws Exception 
	 ************************************************************************
	 */
	public void immediateneedsFR(String strItem,String strQtyReq) throws Exception{
		driver.switchTo().defaultContent();		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Business_Unit"), "Target");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Priority"), "3", "Priority");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Permanent_Need"), "Permanent Need");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Item"), strItem, "Item");
		//		Thread.sleep(1000);	
		libManhattanCommonFunctions.clickAnyElement(getPageElement("SingleUseItemiLPN"), "Use Single Item iLPN only");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("QuantityRequired"), strQtyReq, "Required Quantity");
		//		Thread.sleep(1000);	
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("NeedUOM"), "iLPN");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Lock_Code"), "First Receipt");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Need_Status"), "Completed");
		Thread.sleep(1000);		
	}	
	/**
	 ************************************************************************ 
	 * Function applies FR immediate needs
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	null
	 * @version 1.0
	 * @throws Exception 
	 ************************************************************************
	 */
	public void immediateneedsF1(String strItem,String strQtyReq) throws Exception{
		driver.switchTo().defaultContent();		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Business_Unit"), "Target");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Priority"), "2", "Priority");
		//		Thread.sleep(1000);	
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Item"), strItem, "Item");
		//		Thread.sleep(1000);	
		libManhattanCommonFunctions.clickAnyElement(getPageElement("SingleUseItemiLPN"), "Use Single Item iLPN only");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("QuantityRequired"), strQtyReq, "Required Quantity");
		//		Thread.sleep(1000);	
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("NeedUOM"), "iLPN");
		//		Thread.sleep(1000);ExcessAllowance
		//		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ExcessAllowance"), "100", "Excess Allowed");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Lock_Code"), "FR First Case");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Need_Status"), "In process");
		//		Thread.sleep(1000);		
		libManhattanCommonFunctions.clickAnyElement(getPageElement("UnlockNeed"), "Unlock Need");
		Thread.sleep(1000);
	}	
	/**
	 ************************************************************************ 
	 * Function applies FR immediate needs
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	null
	 * @version 1.0
	 * @throws Exception 
	 ************************************************************************
	 */
	public void immediateneedsIP(String strItem,String strQtyReq) throws Exception{
		driver.switchTo().defaultContent();		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Business_Unit"), "Target");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Priority"), "1", "Priority");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Permanent_Need"), "Permanent Need");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Item"), strItem, "Item");
		//		Thread.sleep(1000);	
		libManhattanCommonFunctions.clickAnyElement(getPageElement("SingleUseItemiLPN"), "Use Single Item iLPN only");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("QuantityRequired"), strQtyReq, "Required Quantity");
		//		Thread.sleep(1000);	
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("NeedUOM"), "iLPN");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ExcessAllowance"), "100", "Excess Allowed");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Putaway_Type"), "Product Prep");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Lock_Code"), "In Prep");
		//		Thread.sleep(1000);
		libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Need_Status"), "In process");
		//		Thread.sleep(1000);		
		libManhattanCommonFunctions.clickAnyElement(getPageElement("UnlockNeed"), "Unlock Need");
		Thread.sleep(1000);
	}	
	/**
	 ************************************************************************ 
	 * Function enters Item and updates the Prep Code
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strItem, strPrepCodes
	 * @version 1.0
	 * @throws Exception 
	 ************************************************************************
	 */
	public void editItemPrepcodes(String strItem,String strPrepCodes) throws Exception{
		driver.switchTo().defaultContent();		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		//		String strSingleItem[]=new String[];
		if(strItem.contains(";")){			
			String[] strSinglePrepCode =  strPrepCodes.split(";"); 
			int intLoop = 0;
			for (String strSingleItem : strItem.split(";")) {	
				System.out.println(" ============================== ");
				System.out.println(strSingleItem);
				System.out.println(strSinglePrepCode[intLoop]);
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("searchItem"), strSingleItem, "Item");
				Thread.sleep(1000);	
				libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");
				Thread.sleep(3000);	
				libManhattanCommonFunctions.clickAnyElement(getPageElement("Check_Single_Item"), "Check Item");
				Thread.sleep(1000);
				libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_Edit"), "Edit Button");
				Thread.sleep(1000);
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Prep_Code"), strSinglePrepCode[intLoop], "FC Specific Prod Prep Code");
				Thread.sleep(1000);	
				libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_Save"), "Save Button");
				Thread.sleep(3000);
				libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_Back"), "Back Button");
				Thread.sleep(3000);
				intLoop = intLoop+1;
			}
		}
	}
	/**
	 ************************************************************************ 
	 * Function retreives Prep Code
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strItem
	 * @version 1.0
	 * @throws Exception 
	 ************************************************************************
	 */
	public void getPrepCodes(String strItem) throws Exception{
		driver.switchTo().defaultContent();		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		//	String strSingleItem[]=new String[];
		if(strItem.contains(";")){					
			for (String strSingleItem : strItem.split(";")) {	
				System.out.println(" ============================== ");
				System.out.println(strSingleItem);
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("searchItem"), strSingleItem, "Item");
				Thread.sleep(1000);	
				libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");
				Thread.sleep(5000);	
				libManhattanCommonFunctions.clickAnyElement(getPageElement("Check_Single_Item"), "Check Item");
				Thread.sleep(1000);
				libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_View"), "Edit Button");
				Thread.sleep(5000);
				String actualPrepCode = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ItemFacilityDetails_ITIWMSLOTMisc6']","XPATH").getText();	
				System.out.println(actualPrepCode);
				Thread.sleep(1000);
				libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_Back"), "Back Button");
				Thread.sleep(5000);
			}
		}
	}
}

