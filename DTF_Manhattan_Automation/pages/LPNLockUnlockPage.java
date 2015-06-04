package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

/**
 * LPNLockUnlockPage class
 * @author Cognizant
 */
public class LPNLockUnlockPage extends AnyManhattanPage
{		
	/*******************************Declaration of objects for AnyManhattanPage**************************************/ 
	WebElement imgManhattanLogo;
	WebElement btnLPNLockUnlock;
	


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public LPNLockUnlockPage(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		try{
			
						
		}catch(Exception e){
			report.updateTestLog("LPNLockUnlockPage-OBJECT IDENTIFICATION", "Error in finding Page Object/element : " + e.getMessage(), Status.FAIL);
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
		if (getCurrentPage("LPNLockUnlockPage"))
			report.updateTestLog("LPNLockUnlock Page verification", "LPNLockUnlock Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("LPNLockUnlock Page verification", "LPNLockUnlock Page loaded not loaded!!!!", Status.FAIL);
	}

	/**
	 * To use switch case we are declaring the below enum for MyAccount,Login,Logout,MiniCart 
	 */
	private enum enumPageObjects
	{
		 btnLock, btnUnlock, drpLockCode, btnSave, tblLockCode, btnCancel;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: btnLock, btnUnlock, drpLockCode, btnSave, tblLockCode, btnCancel
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {			

            case btnLock:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='rmButton_1Lock1_167270008']", "XPATH");
                break;
            case btnUnlock:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='rmButton_1Unlock1_167270009']", "XPATH");
                break;
            case drpLockCode:
            	elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:listView:dataTable:newRow_1:LockCodeSelect']","XPATH");
            break;
            case btnSave:
            	elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='rmButton_1Save1_167270010']","XPATH");
            	break;
            case btnCancel:
            	elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='rmButton_1Cancel1_167270011']","XPATH");
            	break;
            case tblLockCode:
            	elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:LockCodeSelect12']","XPATH");
            	break;	
            	
            
            default:
            	break;

			}
			report.updateTestLog("LPNLockUnlock- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main LPNLockUnlock", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("LPNLockUnlock- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;}

	
     
      
	/**
	 *********************************************************************** 
	 * Function selects the lock and clicks on save button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree
	 * @param 	strValueToSelect
	 * @version 1.0 
	 ***********************************************************************
	 */
       public void lockiLPN(String strValueToSelect){                                
			   try{                                                         	                                                    
					libManhattanCommonFunctions.clickAnyElement(getPageElement("btnLock"), "Lock button");
					libManhattanCommonFunctions.selectAnyElement(getPageElement("drpLockCode"), strValueToSelect, "Lock Code");
					libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save button");    
					libManhattanCommonFunctions.clickAnyElement(getPageElement("btnCancel"), "Cancel button");	                                 
			   }catch(Exception e){
			                   report.updateTestLog("LPNLockUnlock Page", "Element Not Found", Status.FAIL);			                 
			   }              
       }
      
     /**
   	 *********************************************************************** 
   	 * Function verifies the lock code.
   	 * @return 	Nothing is returned as of now 
   	 * @Author 	Jayashree
   	 * @param 	strValueToVerify
   	 * @version 1.0 
   	 ***********************************************************************
   	 */
        public void verifyLockCodeTable(String strValueToVerify){                                
 			   try{                                                         
 				                                             
 					libManhattanCommonFunctions.verifyAndReportElementState(getPageElement("tblLockCode"),"CONTAINS-"+strValueToVerify,"Y","Lock Code table"); 		                         
 			   }catch(Exception e){
 			                   report.updateTestLog("Lock Code table", "Element Not Found", Status.FAIL);			
 			                   
 			   }              
        }
       

        /**
       	 *********************************************************************** 
       	 * Function selects the lock value and clicks on unlock button .
       	 * @return 	Nothing is returned as of now 
       	 * @Author 	Jayashree
       	 * @param 	strLockValue
       	 * @version 1.0 
       	 ***********************************************************************
       	 */
	 public void unLockiLPN(String strLockValue){  
			WebElement wbLPNCheckbox = null;
			 try{  
                    wbLPNCheckbox = driver.findElement(By.xpath("//input[@id='checkAll_c0_dataForm:listView:dataTable']"));
					wbLPNCheckbox.click();                                                    
					libManhattanCommonFunctions.clickAnyElement(getPageElement("btnUnlock"), "UnLock button");
					libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save button");
					libManhattanCommonFunctions.clickAnyElement(getPageElement("btnCancel"), "Cancel button");
			 }catch(Exception e){
			     report.updateTestLog("LPNLockUnlock Page", "Element Not Found", Status.FAIL);
			
			     
			 } 
	                                     
	 }
	 
	 /**
    	 *********************************************************************** 
    	 * Function clicks on lock button and selects the lock value and saves it.
    	 * @return 	Nothing is returned as of now 
    	 * @Author 	Jayashree
    	 * @param 	strValue
    	 * @version 1.0 
    	 ***********************************************************************
    	 */
	 public void clickAndSelectLock(String strValue){
		 try{
			 libManhattanCommonFunctions.clickAnyElement("//*[@value='Lock']", "XPATH", "LOCK");
			 Thread.sleep(2000);
			 WebElement elemDrb = libManhattanCommonFunctions.getElementByProperty("dataForm:listView:dataTable:newRow_1:LockCodeSelect", "ID");
			 libManhattanCommonFunctions.clickAnyElement(elemDrb, "Lock DropDown");
			 libManhattanCommonFunctions.selectAnyElement(elemDrb, strValue, "Drop Down Value");
			 Thread.sleep(2000);
			 libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save button");
			 
		 }catch(Exception e){
		     report.updateTestLog("LPNLockUnlock Page", "Element Not Found", Status.FAIL);			
		     
		 } 
	 }
}
