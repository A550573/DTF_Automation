package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class TaskPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public TaskPage(ScriptHelper scriptHelper) {
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
			if (getCurrentPage("TaskPage"))
				report.updateTestLog("Task Page verification", "Task loaded as expected.", Status.DONE);
			else
				report.updateTestLog("Task Page verification", "Task page loaded not loaded!!!!", Status.FAIL);
		}
		
		
		private enum enumPageObjects
		{
			TaskID, TaskType, TaskStatus, Apply, View, ExpandFilter, btnBack, btnRelease, Btn_ReleaseTask, Btn_LPNtab;
		}

		/**
		 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
		 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
		 * 			Values: TaskID, TaskType, TaskStatus, Apply, View, ExpandFilter.
		 * @return	The WebElement object if it exists. Else returns null
		 */
		private WebElement getPageElement(String strElemName)
		{
			WebElement elemToFind = null;
			try {
				switch (enumPageObjects.valueOf(strElemName)) {
				
				case TaskID:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Task ID']", "XPATH");
					break;
				case TaskType:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:lview:filterId:field20value1']", "XPATH");
					break;
				case TaskStatus:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:lview:filterId:field30value1']", "XPATH");
					break;
				case Apply:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply' and @title='Apply'])[1]", "XPATH");
					break;
				case View:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='View']", "XPATH");
					break;
				case ExpandFilter:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='filterId_fltrExpCol']", "XPATH");
					break;
				case btnBack:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//img[@id='backImage']", "XPATH");
					break;
				case btnRelease:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Release Task']", "XPATH");
					break;
				case Btn_ReleaseTask:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Release Task']", "XPATH");
					break;
				case Btn_LPNtab:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='LPNsTab_lnk']", "XPATH");
					break;
				
			default:
				break;
			}
			report.updateTestLog("TasksPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("TasksPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	
		}
	
		/**
		 *********************************************************************** 
		 * Function TaskID in the search box and clicks apply button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strTaskID
		 * @version 1.0
		 ***********************************************************************
		 */
		public void searchTaskID(String strTaskID){
			
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("TaskID"), strTaskID, "TaskID");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");					
		}
		
		/**
		 *********************************************************************** 
		 * Function selects TaskType and Status and clicks apply button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strTaskType, strTaskStatus
		 * @version 1.0
		 * @throws 	Exception 
		 ***********************************************************************
		 */
		public void searchTaskByType(String strTaskType, String strStatus) throws Exception{
			libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("TaskType"), strTaskType);
			libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("TaskStatus"), strStatus);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");					
		}
		
		/**
		 *********************************************************************** 
		 * Function clicks on expand filter button.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	None
		 * @version 1.0
		 * @throws 	Exception 
		 ***********************************************************************
		 */
		public void expandFilter(){
			
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clickAnyElement(getPageElement("ExpandFilter"), "Expand Filter");					
		}
		
		/**
		 *********************************************************************** 
		 * Function validates Task Type and Header Status
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strTaskType, strHeaderStatus
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateTaskDetails(String strTaskType,String strHeaderStatus){
			try{
				//strTaskType = "Full Pallet (F1E)";
				String actualTaskType = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][2]", "XPATH").getText();
				String actualHeaderStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][4]", "XPATH").getText();
				if(actualTaskType.trim().equals(strTaskType) && actualHeaderStatus.trim().equals(strHeaderStatus))
				{
					report.updateTestLog("Task details verification", "Task Type : "+actualTaskType+" and Status : "+actualHeaderStatus +" is verified", Status.PASS);
				}else
				{
					report.updateTestLog("Task details verification", "Expected Task type : "+strTaskType+" Actual Task Type : "+actualTaskType+" Expected Status : "+strHeaderStatus+" Actual Status : "+actualHeaderStatus, Status.FAIL);
				}
				}catch(Exception e){
					report.updateTestLog("Element", "Element Not Found", Status.FAIL);
				}              
			}
		
		/**
		 *********************************************************************** 
		 * Function verifies task table headers
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void verifyTaskTableHeaders(){
			try {
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Task ID']", "XPATH", "Task ID");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Task Type']", "XPATH", "Task Type");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Priority']", "XPATH", "Priority");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Header Status']", "XPATH", "Header Status");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='# of Details']", "XPATH", "# of Details");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Item']", "XPATH", "Item");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Start Work Group']", "XPATH", "Start Work Group");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Start Work Area']", "XPATH", "Start Work Area");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Current Location']", "XPATH", "Current Location");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Owner']", "XPATH", "Owner");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Create Date Time']", "XPATH", "Create Date Time");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Modified Date Time']", "XPATH", "Modified Date Time");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:lview:dataTable']//span[text()='Inventory Need Type']", "XPATH", "Inventory Need type");
			} catch (IOException e) {
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			}
		}
		
		/**
		 *********************************************************************** 
		 * Function selects the check box of the appropriate item and click on view button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strItem
		 * @version 1.0
		 * @throws 	InterruptedException 
		 ***********************************************************************
		 */
		public void selectByItemAndView(String strItem) throws InterruptedException{
			Thread.sleep(3000);
			List<WebElement> list = driver.findElements(By.xpath(".//*[@class='advtbl_col advtbl_body_col'][6]"));
			int strRowNumToBeChecked = 0;
			for(WebElement ele:list){
				if(ele.getText().trim().contains(strItem.trim())){
					break;
				}else{
					strRowNumToBeChecked = strRowNumToBeChecked + 1;
					continue;
				}
				
			}	
			libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+strRowNumToBeChecked+"_dataForm:lview:dataTable']", "XPATH", "CheckBox");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("View"), "View");
		}

		/**
		 *********************************************************************** 
		 * Function checks task present and item assigned
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strItem
		 * @version 1.0
		 * @throws 	InterruptedException 
		 ***********************************************************************
		 */
		public void checkTasksCreated(String strItem) throws InterruptedException{
			List<WebElement> list = driver.findElements(By.xpath(".//*[@class='advtbl_col advtbl_body_col'][3]//span[1]"));
			int strRowNumToBeChecked = 0;
			for(WebElement ele:list){
				if(ele.getText().trim().contains(strItem.trim())){
					report.updateTestLog("Task Verification", "Task is created for the Item "+strItem , Status.PASS);
					break;
				}else{
					strRowNumToBeChecked = strRowNumToBeChecked + 1;
					continue;
				}
				
			}
		}
		
		/**
		 *********************************************************************** 
		 * Function selects the check box of the appropriate item and click on view button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strItem
		 * @version 1.0
		 * @throws 	InterruptedException 
		 ***********************************************************************
		 */
		public void selectTasksCreated() throws InterruptedException{
			Thread.sleep(3000);	
			libManhattanCommonFunctions.clickAnyElement(".//*[@id='dataForm:lview:dataTable_checkAll']", "XPATH", "CheckBox");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("View"), "View");
		}
		
		/**
		 *********************************************************************** 
		 * Function gets the Task Id of the selected Task.
		 * @return 	strTaskId 
		 * @Author  Nitika
		 * @param 	None
		 * @version 1.0
		 * @throws 	Exception 
		 ***********************************************************************
		 */
		public String getTaskId() throws Exception
		{
			Thread.sleep(2000);
			String strTaskId = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:0:taskIdVal']", "XPATH").getText();
			return strTaskId;	
		}
		
		
		/**
         *********************************************************************** 
          * Function retrieves Task Type, Task Status and Task Priority.
         * @return    Nothing is returned as of now 
          * @Author    Rahman
         * @param     None
         * @version 1.0
         * @throws InterruptedException 
          ***********************************************************************
         */
         public void validateMultipleTaskStatus(String strTaskType,String strTaskstatus,String strTaskPriority) throws InterruptedException
         {	
        	 strTaskType="Tote Pick - Sorter"; strTaskstatus="Locked/Disabled";
        	 if (!(strTaskType.contains(";"))){
        		 validateTaskDetails(strTaskType,strTaskstatus);
        	 }
        	 else{
                int intRowPointer=0;
                String[] arrTaskType = null,arrTaskStatus = null,arrTaskPriority = null;
                boolean blnFlagValue;
                String actualTaskType ="";
                String actualTaskPriority ="";
                String actualStatus ="";
                if (strTaskType.contains(";")){
        			Thread.sleep(1000);
        			 arrTaskType = strTaskType.split(";");
        			 arrTaskStatus = strTaskstatus.split(";");
        			 arrTaskPriority = strTaskPriority.split(";");
                }
                WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:lview:dataTable_body']"));
                List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR")); 
                System.out.println("Task : "+(wbTRList.size()-1));
                for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
                {              
                      blnFlagValue = false;
                      intRowPointer = intPointr;
                       actualTaskType=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:"+intRowPointer+":descVal1']", "XPATH").getText();
                       actualTaskPriority=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:"+intRowPointer+":descVal3']", "XPATH").getText();
                       actualStatus=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:"+intRowPointer+":statusVal']", "XPATH").getText();
                      Thread.sleep(1000);                                    
                       if(actualTaskType.trim().equals(arrTaskType[intPointr])&&actualStatus.trim().equals(arrTaskStatus[intPointr])&&actualTaskPriority.trim().equals(arrTaskPriority[intPointr]))
                      {
                             report.updateTestLog("Task Status details verification", "Task : "+(intPointr+1)+" Task Type : "+actualTaskType+" Task Status : "+actualStatus+" Task Priority : "+actualTaskPriority, Status.PASS);
                             blnFlagValue = true;                            
                      }else{
                             blnFlagValue = false;                                  
                      }
                      if (blnFlagValue = false){                      
                             report.updateTestLog("Task Status details verification", "Task : "+(intPointr+1)+" Expected Task Type : "+strTaskType+" Actual Task Type : "+actualTaskType+" Expected Task Status : "+strTaskstatus+" Actual Task Status : "+actualStatus+" Expected Task Priority : "+strTaskPriority+" Actual Task Priority : "+actualTaskPriority, Status.FAIL);
                      }
                }
         }
         }

/**
         *********************************************************************** 
          * Function gets the Task Id of the selected Task.
         * @return    strTaskId 
          * @Author  Rahman
         * @param     None
         * @version 1.0
         * @throws    Exception 
          ***********************************************************************
         */
//       @SuppressWarnings("null")
         public String[] getMultipleTaskId() throws Exception
         {
                
                Thread.sleep(2000);
                WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:lview:dataTable_body']"));
                List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR")); 
                System.out.println("Task : "+(wbTRList.size()-1));
                String strTaskId[] = new String[(wbTRList.size()-1)];
                for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
                {
                strTaskId[intPointr] = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:"+intPointr+":taskIdVal']", "XPATH").getText();
                System.out.println(strTaskId[intPointr]);
                }
                return strTaskId;    
         }
         
         /**
 		 *********************************************************************** 
 		 * Function clicks on the back button
 		 * @return 	Nothing is returned as of now 
 		 * @Author 	Nitika
 		 * @version 1.0
 		 * @throws 	InterruptedException 
 		 ***********************************************************************
 		 */
 		public void ClickOnBack() throws InterruptedException{
 			Thread.sleep(3000);	
 			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnBack"), "Back Button");
 		}
 		
 		
 		/**
 		 *********************************************************************** 
 		 * Function releases the task from locked/disabled.
 		 * @return 	Nothing is returned as of now 
 		 * @Author 	Nitika
 		 * @version 1.0
 		 * @throws 	InterruptedException 
 		 ***********************************************************************
 		 */
 		public void ReleaseTask() throws InterruptedException{
 			Thread.sleep(2000);	
 			libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:lview:dataTable']", "XPATH", "CheckBox");
 			Thread.sleep(1000);	
 			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnRelease"), "Release Button");
 			Thread.sleep(1000);	
 		}
 		
 		/**
 		 *********************************************************************** 
 		 * Function clicks OK on the new pop up dialog Box.
 		 * @return 	Nothing is returned as of now 
 		 * @Author 	Nitika
 		 * @param 	None
 		 * @version 1.0
 		 ***********************************************************************
 		 */
 		public void clickOKRelease() throws InterruptedException, AWTException{

 			Thread.sleep(3000);

 			driver.switchTo().alert().accept();

 			Thread.sleep(3000);


 		}

 		/**
		 *********************************************************************** 
		 * Function selects the check box of the appropriate item and click on view button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strTaskID
		 * @version 1.0
		 * @throws 	InterruptedException 
		 ***********************************************************************
		 */
		public void selectAndReleaseTasks() throws InterruptedException{
			Thread.sleep(3000);	
			libManhattanCommonFunctions.clickAnyElement(".//*[@name='dataForm:lview:dataTable_checkAll']", "XPATH", "CheckBox");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_ReleaseTask"), "Release Task Button");
			if(driver.switchTo().alert() != null){
				String alert1 = driver.switchTo().alert().getText();
				System.out.println("alert1 : "+alert1);
				driver.switchTo().alert().accept();
				Thread.sleep(5000);
				
//				if(driver.switchTo().alert() != null){
//					String alert2 = driver.switchTo().alert().getText();
//					System.out.println("alert2 : "+alert2);
//					driver.switchTo().alert().accept();
//				}else{
//					System.out.println("1 alert present");
//				}
			}else{
				System.out.println("alert not present");
			}
		}
		
		
		/**
		 *********************************************************************** 
		 * Function validates Task Type and Header Status
		 * @return 	Nothing is returned as of now 
		 * @Author 	Rahman
		 * @param 	strTaskType, strHeaderStatus, strTaskPriority
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateTask(String strTaskType,String strHeaderStatus, String strTaskPriority){
			try{
//				strTaskPriority="40";
//				strHeaderStatus="Tote Pick - Regular";
				String actualTaskType = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:0:descVal1']", "XPATH").getText();//span[@id='dataForm:lview:dataTable:0:descVal3']
				String actualTaskPriority = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:0:descVal3']", "XPATH").getText();
				String actualHeaderStatus = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:0:statusVal']", "XPATH").getText();
				if(actualTaskType.trim().equals(strTaskType) && actualHeaderStatus.trim().equals(strHeaderStatus) && actualTaskPriority.trim().equals(strTaskPriority))
				{
					report.updateTestLog("Task details verification", "Task Type : "+actualTaskType+", Task Priority : "+actualTaskPriority+" and Status : "+actualHeaderStatus +" is verified", Status.PASS);
				}else
				{
					report.updateTestLog("Task details verification", "Expected Task type : "+strTaskType+" Actual Task Type : "+actualTaskType+" Expected Task Priority : "+strTaskPriority+" Actual Task Priority : "+actualTaskPriority+" Expected Status : "+strHeaderStatus+" Actual Status : "+actualHeaderStatus, Status.FAIL);
				}
				}catch(Exception e){
					report.updateTestLog("Element", "Element Not Found", Status.FAIL);
				}              
			}
		
		/**
		 *********************************************************************** 
		 * Function assigns the user
		 * @return 	Nothing is returned as of now 
		 * @Author 	Rahman
		 * @param 	strItem
		 * @version 1.0
		 * @throws 	InterruptedException 
		 * @throws AWTException 
		 ***********************************************************************
		 */
		public void AssignUser(String strUser) throws InterruptedException, AWTException{
			Thread.sleep(3000);	
			libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:lview:dataTable']", "XPATH", "CheckBox");
			Thread.sleep(3000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("AssignUser"), "Assign User");
			Thread.sleep(3000);
			pressEnter();
			Thread.sleep(3000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("TaskGroup"), strUser, "Task Group");
			Thread.sleep(3000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Submit"), "Submit");
			Thread.sleep(3000);
			
		}
		

		/**
		 *********************************************************************** 
		 * Function performs enter keyboard action.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Rahman
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void pressEnter() throws InterruptedException, AWTException {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		
		/**
		 *********************************************************************** 
		 * Function gets the LPN Id
		 * @return 	strTaskId 
		 * @Author  Aishwarya
		 * @param 	None
		 * @version 1.0
		 * @throws 	Exception 
		 ***********************************************************************
		 */
		public String getLPNId() throws Exception
		{
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement("//input[@name='dataForm:lview:dataTable_checkAll']", "XPATH", "CheckBox");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("View"), "View Button");	
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Btn_LPNtab"), "LPN Tab");
            String strLPNId = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNList_entityListView:LPNList_MainListTable:0:LPNList_Outbound_Link_NameText_param_out']", "XPATH").getText();
			return strLPNId;	
		}
		
}
