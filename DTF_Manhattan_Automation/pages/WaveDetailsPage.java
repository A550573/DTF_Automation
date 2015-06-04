package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class WaveDetailsPage extends AnyManhattanPage
{		

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public WaveDetailsPage(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		try{

		}catch(Exception e){
			report.updateTestLog("AnyManhattanPage-OBJECT IDENTIFICATION", "Error in finding Page Object/element : " + e.getMessage(), Status.FAIL);
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
		if (getCurrentPage("WaveDetailsPage"))
			report.updateTestLog("Wave Details Page verification", "Wave Details Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Wave Details Page verification", "Wave Details page loaded not loaded!!!!", Status.FAIL);
	}

	/**
	 * To use switch case we are declaring the below enum for MyAccount,Login,Logout,MiniCart 
	 */
	private enum enumPageObjects
	{
		 Statistics, Tasks, btnTaskDetails, oLPNs, btnLPNDetails, btnRefresh, StatisticsTab, oLPNsTab, TasksTab, OrdersTab, btnAllocationDetails, btnBack;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: ASN
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {
			                                   
			case Statistics:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='statisticsTab_lnk']", "XPATH");
				break;
				
			case Tasks:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='TasksTab_lnk']", "XPATH");
				break;
			
			case btnTaskDetails:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value ='Task Details']", "XPATH");
				break;
				
			case oLPNs:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@name='OLPNsTab']", "XPATH");
				break;
				
			case btnLPNDetails:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='LPN Details']", "XPATH");
				break;
				
			case btnRefresh:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Refresh']", "XPATH");
				break;
				
			case StatisticsTab:

                elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='statisticsTab_lnk']", "XPATH");

                break;
                
			 case oLPNsTab:

                 elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@name='OLPNsTab']", "XPATH");

                 break;

			 case TasksTab:

                 elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='TasksTab_lnk']", "XPATH");

                 break;
                 
			 case OrdersTab:
				 
				 elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@name='OrdersTab']", "XPATH");

                 break;
                 
			 case btnAllocationDetails:
				 
				 elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Allocation Details']", "XPATH");

                 break;
                 
			 case btnBack:
                 elemToFind = libManhattanCommonFunctions.getElementByProperty("//img[@id='backImage']", "XPATH");
                 break; 



				
			default:
				break;
			}
			report.updateTestLog("ASN- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("ASN- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}
	
	
	
	/**
	 *********************************************************************** 
	 * Function clicks on refresh button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void ClickRefresh()
	{
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnRefresh"), "Refresh Button");
	}
	
	
	/**
	 *********************************************************************** 
	 * Function clicks on refresh button until the wave process is completed.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void WaitForWave(String strWaveStatus)
	{
		try{
			Thread.sleep(8000);
			String actualWaveStatus;
			libManhattanCommonFunctions.waitForElementVisibility("//span[contains(text(),'Wave status:')]", 6000);
			do{
				actualWaveStatus = driver.findElement(By.xpath("//span[@id='dataForm:status']")).getText();
				Thread.sleep(4000);
				ClickRefresh();
				Thread.sleep(4000);
			}
			while(!(actualWaveStatus.trim().equals(strWaveStatus.trim())));
		}catch(Exception e){
			report.updateTestLog("Wave Number", "Element Not Found", Status.FAIL);
		}
	}
	
	
	/**
	 *********************************************************************** 
	 * Function views the task details of the wave generated.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void ViewTaskDetails()
	{
		try{
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Statistics"), "Statistics Tab");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Tasks"), "Tasks Tab");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnTaskDetails"), "Task Details Button");
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}  
	}
	
	/**
	 *********************************************************************** 
	 * Function views the oLPN details of the wave generated.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void ViewLPNDetails()
	{
		try{
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Statistics"), "Statistics Tab");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("oLPNs"), "oLPNs Tab");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnLPNDetails"), "LPN Details Button");
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}  
	}
	
	
	/**
     *********************************************************************** 
      * Function validates the oLPN status.
     * @return    Nothing is returned as of now 
      * @Author    Rahman
     * @param     strLPNStatus
     * @version 1.0
     ***********************************************************************
     */
     public int validateoLPNStatus(String strLPNStatus){           
            libManhattanCommonFunctions.clickAnyElement(getPageElement("StatisticsTab"), "StatisticsTab");
            libManhattanCommonFunctions.clickAnyElement(getPageElement("oLPNsTab"), "oLPNsTab");
            String oLPNs = null;
            int NumberOfOLPNS = 0;
            if(libManhattanCommonFunctions.verifyElementPresent("//span[@id='dataForm:dataLstTbl:0:colval_viewcol_id11']", "XPATH"))
            {
            oLPNs=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:dataLstTbl:0:colval_viewcol_id11']","XPATH").getText();
            NumberOfOLPNS = Integer.parseInt(oLPNs);
            }             
            //span[@id='dataForm:dataLstTbl:0:colval_viewcol_id11']
            if(libManhattanCommonFunctions.verifyElementPresent("//span[@id='dataForm:dataLstTbl:_colhdr_id1']", "XPATH")){
                   try{
                         String actualLPNStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:dataLstTbl:_colhdr_id1']", "XPATH").getText();
                         
                         if(actualLPNStatus.trim().equals(strLPNStatus))
                         {
                                report.updateTestLog("oLPN Status verification", "Actual oLPn status : "+actualLPNStatus+ " is verified", Status.PASS);
                         }else
                         {
                                report.updateTestLog("oLPN Status verification", "Expected oLPN status :"+strLPNStatus+" || Actual oLPN status : "+actualLPNStatus, Status.FAIL);
                         }                          
                   }catch(Exception e){
                         report.updateTestLog("Element", "Element Not Found", Status.FAIL);
                   }
            }else{
                   report.updateTestLog("oLPN Status", "oLPN is not created", Status.PASS);
            }
            return NumberOfOLPNS;             
     }
     
     
     /**
      *********************************************************************** 
       * Function validates the task status.
      * @return    Nothing is returned as of now 
       * @Author    Yagna Priya D
      * @param     strTaskStatus
      * @version 1.0
      ***********************************************************************
      */
      public void validateTaskStatus(String strTaskStatus){
             libManhattanCommonFunctions.clickAnyElement(getPageElement("StatisticsTab"), "StatisticsTab");
             libManhattanCommonFunctions.clickAnyElement(getPageElement("TasksTab"), "TasksTab");
             if(libManhattanCommonFunctions.verifyElementPresent("//span[@id='dataForm:tskLstTbl:_colhdr_id1']", "XPATH")){
                    String actualTaskStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:tskLstTbl:_colhdr_id1']", "XPATH").getText();
                    try{
                          if(actualTaskStatus.trim().equals(strTaskStatus))
                          {
                                 report.updateTestLog("Task Status verification", "Actual task status : "+actualTaskStatus+ " is verified", Status.PASS);
                          }else
                          {
                                 report.updateTestLog("Task Status verification", "Expected task status :"+strTaskStatus+" || Actual task status : "+actualTaskStatus, Status.FAIL);
                          }

                    }catch(Exception e){
                          report.updateTestLog("Element", "Element Not Found", Status.FAIL);
                    }
             }else{
                    report.updateTestLog("Task Status", "Task is not created", Status.FAIL);
             }

      }
      
      /**
       *********************************************************************** 
        * Function validates the allocation details based on the LPn.
       * @return    Nothing is returned as of now 
        * @Author   Nitika
       * @param     strTaskStatus
       * @version 1.0
     * @throws InterruptedException 
       ***********************************************************************  
       */
       public void verifyAllocationdetails(String striLPNNumber) throws InterruptedException{
    	   int intRowPointer=0;
              libManhattanCommonFunctions.clickAnyElement(getPageElement("StatisticsTab"), "StatisticsTab");
              libManhattanCommonFunctions.clickAnyElement(getPageElement("OrdersTab"), "OrdersTab");
              Thread.sleep(2000);
              libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAllocationDetails"), "btnAllocationDetails");
              String[] arrLPN_Num = null;
              if (striLPNNumber.contains(";")){
      			Thread.sleep(1000);
      			 arrLPN_Num = striLPNNumber.split(";");
              }
              else
              {
            	  arrLPN_Num[0]=striLPNNumber;
              }
              WebElement wbAlloctnTable = driver.findElement(By.xpath("//table[@id='dataForm:listView:dataTable_body']"));
              List<WebElement> wbTRList = wbAlloctnTable.findElements(By.tagName("TR")); 
              System.out.println("Task : "+(wbTRList.size()-1));
              for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
              {              
                    intRowPointer = intPointr;                                        
                     String actualLPN=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:"+intRowPointer+":lpnId']", "XPATH").getText();
                    Thread.sleep(1000); 
                    if(!actualLPN.equals(""))
                    {
                     if(actualLPN.trim().equals(arrLPN_Num[intPointr+1]))
                    {
                           report.updateTestLog("Allocation details verification", "Actual LPN : "+actualLPN+ "|| Expected LPN: "+arrLPN_Num[intPointr+1], Status.PASS);
                           }
                     else
                           {
                                  report.updateTestLog("Allocation details verification", "Actual LPN : "+actualLPN+ "|| Expected LPN: "+arrLPN_Num[intPointr+1], Status.FAIL);
                           }
              }
              }
       }
       
       /**
        *********************************************************************** 
         * Function validates the allocation details based on the location.
        * @return    Nothing is returned as of now 
         * @Author   Nitika
        * @param     strTaskStatus
        * @version 1.0
      * @throws InterruptedException 
        ***********************************************************************  
        */
        public void verifyAllocdetailByLoc(String strLoc) throws InterruptedException{
     	   int intRowPointer=0;
               libManhattanCommonFunctions.clickAnyElement(getPageElement("StatisticsTab"), "StatisticsTab");
               libManhattanCommonFunctions.clickAnyElement(getPageElement("OrdersTab"), "OrdersTab");
               Thread.sleep(2000);
               libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAllocationDetails"), "btnAllocationDetails");
               String[] arrLoc = null;
               if (strLoc.contains(";")){
       			Thread.sleep(1000);
       			 arrLoc = strLoc.split(";");
               }
               else
               {
            	   arrLoc[0]=strLoc;
               }
               WebElement wbAlloctnTable = driver.findElement(By.xpath("//table[@id='dataForm:listView:dataTable_body']"));
               List<WebElement> wbTRList = wbAlloctnTable.findElements(By.tagName("TR")); 
               System.out.println("Task : "+(wbTRList.size()-1));
               for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
               {              
                     intRowPointer = intPointr;                                        		
                     String actualLoc=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:"+intRowPointer+":c003']", "XPATH").getText();
                     Thread.sleep(1000); 
                     if(!actualLoc.equals(""))
                     {
                      if(actualLoc.trim().equals(arrLoc[intPointr]))
                     {
                            report.updateTestLog("Allocation details verification", "Actual Loc : "+actualLoc+ "|| Expected Loc: "+arrLoc[intPointr], Status.PASS);
                            }
                      else
                            {
                                   report.updateTestLog("Allocation details verification", "Actual Loc : "+actualLoc+ "|| Expected Loc: "+arrLoc[intPointr], Status.FAIL);
                            }
               }
               }
        }


        /**
         *********************************************************************** 
          * Function clicks on refresh button.
         * @return          Nothing is returned as of now 
          * @Author         Nitika
         * @param          None
         * @version 1.0
         ***********************************************************************
         */
         public void ClickBackbtn()
         {
                         libManhattanCommonFunctions.clickAnyElement(getPageElement("btnBack"), "Back Button");
         }

}
