package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class WavesPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public WavesPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("WavesPage"))
			report.updateTestLog("Waves Page verification", "Waves loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Waves Page verification", "Waves page loaded not loaded!!!!", Status.FAIL);
	}

	private enum enumPageObjects
	{
		Apply, WaveNumber, AllCheckBox, BtnView, StatisticsTab, TasksTab, BtnTaskDetails, oLPNsTab, BtnLPNDetails, StatusTab, BtnOrderDetails, OrdersTab, BtnUndoWave, actionsbtn, OrdersLnk, btnPackWaves, BtnMore, BtnPackWaves, BtnRelease, Packwavecheckbox, BtnAllocationDetails;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Apply, WaveNumber, AllCheckBox, BtnView, StatisticsTab, TasksTab, BtnTaskDetails, oLPNsTab, BtnLPNDetails
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case WaveNumber:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Ship Wave number']", "XPATH");
				break;
			case Apply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@title='Apply'])[1]", "XPATH");
				break;
			case AllCheckBox:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@name='dataForm:listView:dataTable_checkAll']", "XPATH");
				break;
			case BtnView:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='View']", "XPATH");
				break;
			case StatisticsTab:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@name='statisticsTab']", "XPATH");
				break;
			case TasksTab:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@name='TasksTab']", "XPATH");
				break;
			case BtnTaskDetails:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Task Details']", "XPATH");
				break;
			case oLPNsTab:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@name='OLPNsTab']", "XPATH");
				break;
			case BtnLPNDetails:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='LPN Details']", "XPATH");
				break;
			case StatusTab:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@name='statusTab']", "XPATH");
				break;
			case BtnOrderDetails:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Order Details']", "XPATH");
				break;
			case OrdersTab:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@id='OrdersTab_lnk']", "XPATH");
				break;
			case BtnUndoWave:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Undo Wave']", "XPATH");
				break;
			case actionsbtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='Actions']", "XPATH");
				break; 
			case OrdersLnk:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//a[@title='Orders'])[1]", "XPATH");
				break; 
			case btnPackWaves:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//a[@title='Pack Waves'])[1]", "XPATH");
				break;
			case BtnMore:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='rmbuttons_1moreButton']", "XPATH");
                break;
          case BtnPackWaves:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[contains(@id,'rmButton_2PackWaves')]", "XPATH");
                break;
          case BtnRelease:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Release']", "XPATH");
                break;
          case Packwavecheckbox:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@name='dataForm:lv1:dataTable_checkAll']", "XPATH");
                break;
         case BtnAllocationDetails:
      	   elemToFind = libManhattanCommonFunctions.getElementByProperty("(//a[text()='Allocation Details'])[3]", "XPATH");
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
	 * Function enters the wave number in search box and clicks on apply button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strWaveNumber
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchWaveNumber(String strWaveNumber){
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("WaveNumber"), strWaveNumber, "WaveNumber");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");			

	}			

	/**
	 *********************************************************************** 
	 * Function views the wave details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void viewWaveDetails(){
		try{
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			Thread.sleep(4000);
			WebElement wbWavesCheckbox = driver.findElement(By.id("checkAll_c0_dataForm:listView:dataTable"));
			wbWavesCheckbox.click();
			libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnView"), "ViewButton");
			libManhattanCommonFunctions.waitForElementClickable("//*[@name='statisticsTab']", 12000);
		}catch(Exception e){
			report.updateTestLog("WavesPage Page", "Element Not Found", Status.FAIL);
		} 
	}

	/**
	 *********************************************************************** 
	 * Function validates the wave details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strWaveStatus, strWaveRunDate, strOrderLines, strUnitsRequired
	 * 			strUnitsAllocated, strUnitsShorted, strTasks, stroLPN
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateWaveDetails(String strWaveStatus, String strWaveRunDate, String strOrderLines, String strUnitsRequired, String strUnitsAllocated, String strUnitsShorted, String strTasks, String stroLPNs){
		try{
			String actualWaveNumber=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:wave']", "XPATH").getText();
			String actualWaveStatus=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:status']", "XPATH").getText();
			String actualWaveRunDate=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:waveRunDate']", "XPATH").getText();
			String actualOrderLines=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:OrderLinesSelected']", "XPATH").getText();
			String actualUnitsRequired=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:UnitsRequired']", "XPATH").getText();
			String actualUnitsAllocated=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:UnitsAllocated']", "XPATH").getText();
			String actualUnitsShorted=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:UnitsShorted']", "XPATH").getText();
			String actualTasks=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:Tasks']", "XPATH").getText();
			String actualoLPNs=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:OLPNsSelected']", "XPATH").getText();
			if(actualWaveStatus.trim().equals(strWaveStatus) && actualWaveRunDate.trim().equals(strWaveRunDate) && actualOrderLines.trim().equals(strOrderLines) && actualUnitsRequired.trim().equals(strUnitsRequired) && actualUnitsAllocated.trim().equals(strUnitsAllocated) && actualUnitsShorted.trim().equals(strUnitsShorted) && actualTasks.trim().equals(strTasks) && actualoLPNs.trim().equals(stroLPNs))
			{
				report.updateTestLog("Wave Details verification", "Wave Details verified successfully", Status.PASS);
			}else
			{
				report.updateTestLog("Wave Details verification", "Wave Details verification failed ", Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);


		}              
	}

	/**
	 *********************************************************************** 
	 * Function validates the wave status.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strWaveStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateWaveStatus(String strWaveStatus){			
		try{
			Thread.sleep(12000);
			String actualWaveStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][3]", "XPATH").getText();

			if(actualWaveStatus.trim().equals(strWaveStatus))
			{
				report.updateTestLog("Wave Status verification", "Actual wave status : "+actualWaveStatus+ " is verified", Status.PASS);
			}else
			{
				report.updateTestLog("Wave Status verification", "Expected wave status :"+strWaveStatus+" || Actual wave status : "+actualWaveStatus, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 *********************************************************************** 
	 * Function validates the task status.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strTaskStatus
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
	 * Function validates the oLPN status.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strLPNStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateoLPNStatus(String strLPNStatus){  		
		libManhattanCommonFunctions.clickAnyElement(getPageElement("StatisticsTab"), "StatisticsTab");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("oLPNsTab"), "oLPNsTab");
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
			report.updateTestLog("oLPN Status", "oLPN is not created", Status.FAIL);
		}

	}

	/**
	 ************************************************************************ 
	 * Function selects the given wave number.
	 * @return Nothing is returned as of now 
	 * @Author Yagna Priya D
	 * @param strWaveNumber
	 * @version 1.0
	 * @throws InterruptedException 
	 ************************************************************************
	 */
	public void selectWave(String strWaveNumber) throws InterruptedException{
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath(".//*[@class='advtbl_col advtbl_body_col'][1]//span[1]"));
		int strRowNumToBeChecked = 0;
		for(WebElement ele:list){
			if(ele.getText().trim().contains(strWaveNumber.trim())){
				break;
			}else{
				strRowNumToBeChecked = strRowNumToBeChecked + 1;
				continue;
			}

		}
		System.out.println("wave number : "+strWaveNumber);
		System.out.println("row number : "+strRowNumToBeChecked);
		libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+strRowNumToBeChecked+"_dataForm:listView:dataTable']", "XPATH", "CheckBox");	
	}

	/**
	 ************************************************************************ 
	 * Function clicks on undo wave button.
	 * @return Nothing is returned as of now 
	 * @Author Yagna Priya D
	 * @param None
	 * @version 1.0
	 * @throws InterruptedException 
	 * @throws AWTException 
	 ************************************************************************
	 */
	public void clickUndoWave() throws InterruptedException, AWTException{
		Thread.sleep(3000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnUndoWave"), "Undo Wave Button");
		Thread.sleep(3000);
		//			if(driver.switchTo().alert() != null){
		//				String alert1 = driver.switchTo().alert().getText();
		//				System.out.println("alert1 : "+alert1);
		//				driver.switchTo().alert().accept();
		//			}
		//			Thread.sleep(3000);
		//			if(driver.switchTo().alert() != null){
		//				String alert2 = driver.switchTo().alert().getText();
		//				System.out.println("alert2 : "+alert2);
		//				driver.switchTo().alert().accept();
		//			}
		if(driver.switchTo().alert() != null){
			String alert1 = driver.switchTo().alert().getText();
			System.out.println("alert1 : "+alert1);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);

			if(driver.switchTo().alert() != null){
				String alert2 = driver.switchTo().alert().getText();
				System.out.println("alert2 : "+alert2);
				driver.switchTo().alert().accept();
			}else{
				System.out.println("1 alert present");
			}
		}else{
			System.out.println("alert not present");
		}

		Thread.sleep(3000);
	}

	/**
	 ************************************************************************ 
	 * Function clicks on undo wave button.
	 * @return Nothing is returned as of now 
	 * @Author Yagna Priya D
	 * @param None
	 * @version 1.0
	 * @throws InterruptedException 
	 * @throws AWTException 
	 ************************************************************************
	 */
	public void viewOrderDetails(){
		libManhattanCommonFunctions.clickAnyElement(getPageElement("StatisticsTab"), "StatisticsTab");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("OrdersTab"), "OrdersTab");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnOrderDetails"), "Order Details Button");	
	}

	/**
	 *********************************************************************** 
	 * Function checks if wave cannot be undone
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void checkUndoWave() throws IOException, InterruptedException{
		Thread.sleep(3000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnUndoWave"), "Undo Wave Button");
		Thread.sleep(3000);
		if(libManhattanCommonFunctions.verifyElementPresent("(//*[contains(text(),'All orders for the wave have been shipped or canceled, Cannot undo')])[1]", "XPATH")){
			report.updateTestLog("Waves Page", "Undo wave is not possible", Status.PASS);
		}else{
			report.updateTestLog("Waves Page", "Undo is possible", Status.FAIL);
		}	
	}

	/**
	 *********************************************************************** 
	 * Function views task details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void viewTaskDetails(){
		libManhattanCommonFunctions.clickAnyElement(getPageElement("StatisticsTab"), "StatisticsTab");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("TasksTab"), "TasksTab");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnTaskDetails"), "Task Details Button");

	}

	/**
	 *********************************************************************** 
	 * Function views task details.
	 * @return    Nothing is returned as of now 
	 * @Author    Rahman
	 * @param     None
	 * @version 1.0
	 * @throws InterruptedException 
	 *******
	 */
	public void SelectWave() throws InterruptedException{
		Thread.sleep(1000);
		libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:listView:dataTable']", "XPATH", "CheckBox");
		Thread.sleep(2000);
	}
	/**
	 *********************************************************************** 
	 * Function clicks on actions button
	 * @return    Nothing is returned as of now 
	 * @Author    Rahman
	 * @param     None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickAction() throws InterruptedException{
		Thread.sleep(1000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("actionsbtn"), "Actions Button");
		Thread.sleep(1000);
	}
	/**
	 *********************************************************************** 
	 * Function clicks on Orders Link
	 * @return    Nothing is returned as of now 
	 * @Author    Rahman
	 * @param     None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickOrders() throws InterruptedException{
		Thread.sleep(1000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("OrdersLnk"), "Orders");                     
		Thread.sleep(1000);
	}

	/**
	 *********************************************************************** 
	 * Function clicks on actions button
	 * @return    Nothing is returned as of now 
	 * @Author    Nitika
	 * @param     None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickPackWaves() throws InterruptedException{
		clickAction();
		Thread.sleep(1000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnPackWaves"), "Pack Waves Button");
		Thread.sleep(1000);
	}
	
	/**
     *********************************************************************** 
      * Function to release a pack wave
     * @return    Nothing is returned as of now 
      * @Author    Aishwarya
     * @param     None
     * @version 1.0
     ***********************************************************************
     */
     public void releasePackwave(){
            libManhattanCommonFunctions.clickAnyElement(getPageElement("AllCheckBox"), "Select Wave");
            libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnMore"), "More Button");
            libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnPackWaves"), "Pack Waves Option");
            libManhattanCommonFunctions.clickAnyElement(getPageElement("Packwavecheckbox"), "Select Pack Wave");
            libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnRelease"), "Release Button");

     }
     
     /**
 	 *********************************************************************** 
 	 * Function validates the wave status.
 	 * @return 	Nothing is returned as of now 
 	 * @Author 	Rahman
 	 * @param 	strWaveStatus
 	 * @version 1.0
 	 ***********************************************************************
 	 */
 	public void validateWaveParameter(String strWaveParameter){			
 		try{
 			Thread.sleep(12000);
 			String actualWaveParameter = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:c003']", "XPATH").getText();

 			if(actualWaveParameter.trim().equals(strWaveParameter))
 			{
 				report.updateTestLog("Wave Status verification", "Actual wave status : "+actualWaveParameter+ " is verified", Status.PASS);
 			}else
 			{
 				report.updateTestLog("Wave Status verification", "Expected wave status :"+strWaveParameter+" || Actual wave status : "+actualWaveParameter, Status.FAIL);
 			}
 		}catch(Exception e){
 			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
 		}              
 	}
 	
 	/**
	 *********************************************************************** 
	 * Function validates the wave summary table
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strOrderLines, strUnitsRequired,strUnitsAllocated, strTasks, stroLPN
	 * 			
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateWavesummary(String strOrderLines, String strUnitsRequired, String strUnitsAllocated, String strTasks){
		try{
			
			String actualOrderLines=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:OrderLinesSelected']", "XPATH").getText();
			String actualUnitsRequired=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:UnitsRequired']", "XPATH").getText();
			String actualUnitsAllocated=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:UnitsAllocated']", "XPATH").getText();
			String actualTasks=libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:Tasks']", "XPATH").getText();
			
			if(actualOrderLines.trim().equals(strOrderLines) && actualUnitsRequired.trim().equals(strUnitsRequired) && actualUnitsAllocated.trim().equals(strUnitsAllocated) && actualTasks.trim().equals(strTasks))
			{
				report.updateTestLog("Wave Details verification", "Expected Order Lines:" +strOrderLines+ "Actual Order Lines:" +actualOrderLines+ "Expected Units Required:" +strUnitsRequired+ "Actual Units Required:" +actualUnitsRequired+ "Expected Units Allocated:" +strUnitsAllocated+ "Actual Units Allocated:" +actualUnitsAllocated+ "Expected Tasks:" +strTasks+ "Actual Tasks:" +actualTasks, Status.PASS);
			}else
			{
				report.updateTestLog("Wave Details verification", "Expected Order Lines:" +strOrderLines+ "Actual Order Lines:" +actualOrderLines+ "Expected Units Required:" +strUnitsRequired+ "Actual Units Required:" +actualUnitsRequired+ "Expected Units Allocated:" +strUnitsAllocated+ "Actual Units Allocated:" +actualUnitsAllocated+ "Expected Tasks:" +strTasks+ "Actual Tasks:" +actualTasks, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);


		}              
	}
	
	/**
	 *********************************************************************** 
	 * Function to view allocation details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	None
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void validateAllocationdetails(int strOrderLines, String strTempLoc) throws InterruptedException{
		libManhattanCommonFunctions.clickAnyElement(getPageElement("AllCheckBox"), "Select Wave");
		Thread.sleep(4000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnMore"), "More Button");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnAllocationDetails"), "Allocation Details Option");
		Thread.sleep(4000);
		for(int intLoop=1;intLoop<=strOrderLines;intLoop++)
		{
			String actualTempLoc = libManhattanCommonFunctions.getElementByProperty("//*[@id='dataForm:listView:dataTable:"+intLoop+":c003']", "XPATH").getText();
			if(actualTempLoc.trim().contains(strTempLoc))
					{
				report.updateTestLog("Allocation Details verification", "Expected Temp Location for item line"+intLoop+":"+strTempLoc+"|| Actual Temp Location for item line"+intLoop+":"+actualTempLoc, Status.PASS);
					}
			else
				{
				report.updateTestLog("Allocation Details verification", "Expected Temp Location for item line"+intLoop+":"+strTempLoc+"|| Actual Temp Location for item line"+intLoop+":"+actualTempLoc, Status.FAIL);
				}
			
		}
	}

}
