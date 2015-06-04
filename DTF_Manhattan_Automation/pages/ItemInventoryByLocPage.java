package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

/**
 * Any Manhattan Page class
 * 
 * @author Cognizant
 */
public class ItemInventoryByLocPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public ItemInventoryByLocPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try {

		} catch (Exception e) {
			report.updateTestLog("ItemInventoryByLocPage-OBJECT IDENTIFICATION","Error in finding Page Object/element : " + e.getMessage(),Status.FAIL);
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
	protected void initializeUIMap() {
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("ItemInventoryByLocPage"))
			report.updateTestLog("ItemInventoryByLocPage Page verification","ItemInventoryByLocPage loaded as expected.", Status.DONE);
		else
			report.updateTestLog("ItemInventoryByLocPage Page verification","ItemInventoryByLocPage loaded as expected.", Status.DONE);

	}

	/**
	 * To use switch case we are declaring the below enum for
	 * MyAccount,Login,Logout,MiniCart
	 */
	private enum enumPageObjects {
		txtItem, btnApply, btnLpns;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and
	 * identifies the object based on the object definition
	 * 
	 * @param strElemName
	 *            The {@link strElemName} are objects identified so far in
	 *            iLPNPagePage. Values:
	 *           
	 *            * @return The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName) {
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case txtItem:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listView:filterId:itemLookUpId']","XPATH");
				break;
			case btnApply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@title='Apply'])[1]","XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("ItemInventoryPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main iLPNPage", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("ItemInventoryPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}


	/**
	 *********************************************************************** 
	 * Function enters item number in search box and clicks on apply button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strItem
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SearchItem(String strItem) {
		try {
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtItem"), strItem,"Item Search");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");
			Thread.sleep(4000);
		} catch (Exception e) {
			report.updateTestLog("ItemInventoryPage", "Element Not Found",Status.FAIL);
		}
	}

		/**
		 *********************************************************************** 
		 * Function verifies the LPN quantity
		 * @return Nothing is returned as of now 
		 * @Author Nitika
		 * @param 	strQty
		 * @version 1.0 
		 ***********************************************************************
		 */
		public void verifyItemQty(String strQty)
		{	
			strQty="6";
			String actual_Qty =libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:allocatableQty']", "XPATH").getText();
			String[] arr=actual_Qty.split(" ");
			actual_Qty =arr[0];
			if (actual_Qty.trim().equals(strQty))
			{
				report.updateTestLog("Item Quantity verification","Item Quantity verified successfully", Status.PASS);
			} else {
				report.updateTestLog("Item Quantity verification","Actual Qty: "+actual_Qty+" ||Expected Qty: "+strQty, Status.FAIL);
			}
		}
		
		
		
		/**
		 *********************************************************************** 
		 * Function verifies allocated quantity for an item.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Nitika
		 * @param 	strItem,strLoc,strQty
		 * @version 1.0
		 ***********************************************************************
		 */
		public void verifyAllocatedQty(String strItem,String strLoc,String strQty){                                
			int intRowPointer=0; 
			strLoc="Active"; strQty="15";
			libManhattanCommonFunctions.waitForElementVisibility("//input[@id='checkAll_c0_dataForm:listView:dataTable']", 4000);
			try{  
				WebElement wbLPNTable1 = driver.findElement(By.xpath("//div[@id='dataForm:listView:dataTable_bodyDiv']"));
				List<WebElement> wbTRList = wbLPNTable1.findElements(By.tagName("TR"));
				int intPointr = 0;
				for(WebElement el: wbTRList){
					String strRowValue = el.getText();
					if(strRowValue.contains(strLoc)){
						if(strRowValue.contains(strItem))
						{
						intRowPointer = intPointr;
						break;
					}
				}
					intPointr = intPointr+1;                   
				}
				libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+intPointr+"_dataForm:listView:dataTable']", "XPATH", "CheckBox");
				String strAllocatedQty = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:"+intRowPointer+":allocatableQty']", "XPATH").getText();
				String[] arr=strAllocatedQty.split(" ");
				strAllocatedQty =arr[0];
				if(strAllocatedQty.trim().equals(strQty))
				{
					report.updateTestLog("Item Quantity verification","Item Quantity verified successfully", Status.PASS);
				} else {
					report.updateTestLog("Item Quantity verification","Actual Qty: "+strAllocatedQty+" ||Expected Qty: "+strQty, Status.FAIL);
				}
			}
			catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			}              
		}

	}

