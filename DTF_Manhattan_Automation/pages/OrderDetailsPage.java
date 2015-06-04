package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class OrderDetailsPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public OrderDetailsPage(ScriptHelper scriptHelper) {
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
			if (getCurrentPage("OrderDetailsPage"))
				report.updateTestLog("Order Details Page verification", "Order Details Page loaded as expected.", Status.DONE);
			else
				report.updateTestLog("Order Details Page verification", "Order Details Page loaded not loaded!!!!", Status.FAIL);
		}
		
		private enum enumPageObjects
		{
			
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
				
			default:
				break;
			}
			report.updateTestLog("OrderDetailsPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("OrderDetailsPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	
		}
		
		
		/**
		 *********************************************************************** 
		 * Function validates the order details.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Aishwarya
		 * @param 	strOrderNumber, strOrderStatus, strTransportationStatus
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateOrderDetails(String strOrderNumber, String strLineStatus, String strTransportationStatus){
			try{
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
				String actualOrderNumber = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][1]", "XPATH").getText();
				String actualLineStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][3]", "XPATH").getText();
				String actualTransportationStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@class='advtbl_col advtbl_body_col'][4]", "XPATH").getText();
				
				if(actualOrderNumber.trim().equals(strOrderNumber) && actualLineStatus.trim().equals(strLineStatus) && actualTransportationStatus.trim().equals(strTransportationStatus))
				{
					report.updateTestLog("Order Details verification", "Expected OrderNumber : "+strOrderNumber+" Actual iLPN : "+actualOrderNumber+" Expected Order Status : "+strLineStatus+" Actual Order Status: "+actualLineStatus+" Expected Transportation Status : "+strTransportationStatus+" Actual Transportation Status : "+actualTransportationStatus, Status.PASS);
				}else
				{
					report.updateTestLog("Order Details verification", "Expected OrderNumber : "+strOrderNumber+" Actual iLPN : "+actualOrderNumber+" Expected Order Status : "+strLineStatus+" Actual Order Status: "+actualLineStatus+" Expected Transportation Status : "+strTransportationStatus+" Actual Transportation Status : "+actualTransportationStatus, Status.FAIL);
				}
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);


			}              
		}
		
		
		/**
	       *********************************************************************** 
	        * Function retrieves Orders.
	       * @return    Nothing is returned as of now 
	        * @Author    Rahman
	       * @param     None
	       * @version 1.0
	       * @return 
	        * @throws InterruptedException 
	        ***********************************************************************
	       */
	       public String[] RetreiveOrders() throws InterruptedException
	       {             
	                     int intRowPointer=0;       
	                     
	                     WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:OrderDtlist:OrderDtlDataTable_body']"));
	                     List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR")); 
	                     System.out.println("Order : "+(wbTRList.size()-1));
	                     String actualOrderNumber[]=new String[(wbTRList.size()-1)];
	                     for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
	                     {                                        
	                           intRowPointer = intPointr;
	                            actualOrderNumber[intPointr]=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:OrderDtlist:OrderDtlDataTable:"+intRowPointer+":DOrderId']", "XPATH").getText();
	                           Thread.sleep(1000);                                    
	                     }
	                     return actualOrderNumber;
           }      

	       /**
	   	 *********************************************************************** 
	   	 * Function validates multiple orders.
	   	 * @return    Nothing is returned as of now 
	   	 * @Author    Rahman
	   	 * @param     strOrderNumber,strLineStatus,strTransportationStatus
	   	 * @version 1.0
	   	 * @throws InterruptedException 
	   	 ***********************************************************************
	   	 */
	   	public void validateMultipleOrderDetails(String strOrderNumber, String strLineStatus, String strTransportationStatus) throws InterruptedException
	   	{
	   		//			if(libManhattanCommonFunctions.verifyElementPresent("//td[contains(text(),' No data found')]", "XPATH"))
	   		//			{
	   		//				report.updateTestLog("Order details verification", "No Orders Found", Status.PASS);
	   		//			}
	   		//			else
	   		{
	   			int intRowPointer=0;
	   			boolean blnFlagValue;
	   			String actualOrderNumber ="";
	   			String actualLineStatus ="";
	   			String actualTransportationStatus ="";		
	   			WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:OrderDtlist:OrderDtlDataTable_body']"));
	   			List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR"));	
	   			System.out.println("Order : "+(wbTRList.size()-1));
	   			for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
	   			{              
	   				blnFlagValue = false;
	   				intRowPointer = intPointr;
	   				actualOrderNumber=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:OrderDtlist:OrderDtlDataTable:"+intRowPointer+":DOrderId']", "XPATH").getText();
	   				actualLineStatus=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:OrderDtlist:OrderDtlDataTable:"+intRowPointer+":uilogDataTd1']", "XPATH").getText();
	   				actualTransportationStatus=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:OrderDtlist:OrderDtlDataTable:"+intRowPointer+":uilogDataTd10']", "XPATH").getText();
	   				Thread.sleep(1000);						
	   				if(actualOrderNumber.trim().equals(strOrderNumber)&&actualLineStatus.trim().equals(strLineStatus)&&actualTransportationStatus.trim().equals(strTransportationStatus))
	   				{
	   					report.updateTestLog("Order details verification", "Order : "+(intPointr+1)+" Order Number : "+actualOrderNumber+" Order Line Status : "+actualLineStatus+" Order Transportation Status : "+actualTransportationStatus, Status.PASS);
	   					blnFlagValue = true;					
	   				}else{
	   					blnFlagValue = false;					
	   				}
	   				if (blnFlagValue = false){                      
	   					report.updateTestLog("Order details verification", "Order : "+(intPointr+1)+" Expected Order Number : "+strOrderNumber+" Actual Order Number : "+actualOrderNumber+" Expected Line Status : "+strLineStatus+" Actual Line Status : "+actualLineStatus+" Expected Transportation Status : "+strTransportationStatus+" Actual Transportation Status : "+actualTransportationStatus, Status.FAIL);
	   				}
	   			}
	   		}
	   	}

		
}
