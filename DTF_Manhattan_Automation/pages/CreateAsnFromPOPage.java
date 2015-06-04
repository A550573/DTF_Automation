package pages;
import java.io.IOException;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.CheckinPage.enumPageObjects;

import com.cognizant.framework.Status;
import com.gargoylesoftware.htmlunit.util.StringUtils;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class CreateAsnFromPOPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return  Nothing is returned as of now  
	 * @param   scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public CreateAsnFromPOPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try{

		}catch(Exception e){
			report.updateTestLog("AnyManhattanPage-OBJECT IDENTIFICATION", "Error in finding Page Object/element : " + e.getMessage(), Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function to create an ASN from PO.
	 * @return  Nothing is returned as of now 
	 * @param   None
	 * @version 1.0
	 ***********************************************************************
	 */
	protected void initializeUIMap()
	{
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("CreateAsnFromPOPage"))
			report.updateTestLog("Create Asn From PO Page verification", "Create Asn From PO Page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Create Asn From PO Page verification", "Create Asn From PO Page not loaded!!!!", Status.FAIL);
	}

	public enum enumPageObjects
	{
		PO_ID, btnAdd, btnGenerate, Del_Date, btnOK, btnSave, ASN_ID, btnApplyPO, btnApplyASN, lnkexpandPO, lnkexpandASN, Quantity, QuantitytoAssign;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param          strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 *                                            Values: checkinbtn,createbtn
	 * @return          The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {
			case PO_ID: 
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find Purchase Order']", "XPATH");
				break;
			case ASN_ID:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@alt='Find ASN']", "XPATH");
				break;
			case btnApplyPO: 
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply'])[2]", "XPATH");
				break;
			case btnApplyASN: 
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply'])[4]", "XPATH");
				break;
			case lnkexpandPO:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//img[@id='dataForm:treeTable:0:treeB:adaptor:0::tn1:handle:img:collapsed']", "XPATH");
				break;
			case lnkexpandASN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//img[@id='dataForm:atreeTable:0:atreeB:aadaptor:0::j_id136:handle:img:collapsed']", "XPATH");
				break;
			case btnAdd:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Add']", "XPATH");
				break;
			case btnGenerate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Generate']", "XPATH");
				break;
			case btnOK:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='OK'])[1]", "XPATH");
				break;
			case btnSave:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Save']", "XPATH");
				break;
			case Quantity:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@name ='dataForm:atreeTable:0:atreeB:aadaptor:0:apdadaptor2:0::j_id164']", "XPATH");
				break;
			case QuantitytoAssign:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:qty']", "XPATH");
				break;
			default:
				break;
			}
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}


	/**
	 *********************************************************************** 
	 * Function enters purchase order id in search box and clicks on apply button.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   strPurchaseID
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchPurchaseOrderID(String strPurchaseID){
		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("PO_ID"), strPurchaseID, "Purchase Order ID");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApplyPO"), "Apply Button");
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("lnkexpandPO"), "Expand PO Button");
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 *********************************************************************** 
	 * Function verifies purchase order table headers
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   None
	 * @version 1.0
	 * @throws 	IOException 
	 ***********************************************************************
	 */
	public String verifyPOdetails() throws InterruptedException, IOException
	{
		libManhattanCommonFunctions.isElementPresentVerification("(//span[@class='h-outputTextH'])[1]", "XPATH", "Purchase Id");
		libManhattanCommonFunctions.isElementPresentVerification("//span[@id='dataForm:treeTable:0:treeB:adaptor:0:pdadaptor2:0::lineValue']", "XPATH", "Number of PO Lines");
		libManhattanCommonFunctions.isElementPresentVerification("(//span[@class='h-outputTextD'])[3]", "XPATH", "Ordered Quantity");
		libManhattanCommonFunctions.isElementPresentVerification("(//span[@class='h-outputTextD'])[4]", "XPATH", "Remaining Quantity To Be Shipped");
		//PoQty[0] = libManhattanCommonFunctions.getElementByProperty("(//span[@class='h-outputTextD'])[3]", "XPATH").getText();
		String Quantity = libManhattanCommonFunctions.getElementByProperty("(//span[@class='h-outputTextD'])[4]", "XPATH").getText();
		return Quantity;
	}

	/**
	 *********************************************************************** 
	 * Function validates Purchase Order Details
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   strPurchaseId,strPoLines,strStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validatePoDetails(String strPurchaseId, String strPoLines, String strStatus){                                                                                     
		try{
			String actualPurchaseId = libManhattanCommonFunctions.getElementByProperty("(//span[@class='h-outputTextH'])[1]", "XPATH").getText();
			String arractualPurchaseID =actualPurchaseId.replace("(...,", ",");
			String arractualPurchaseID1[] = arractualPurchaseID.split(",");
			actualPurchaseId = arractualPurchaseID1[0].trim();
			String actualStatus = arractualPurchaseID1[1].replace(")", "").trim();
			String actualPoLines = libManhattanCommonFunctions.getElementByProperty("(//*[@class='h-outputTextD'])[1]", "XPATH").getText();
			if((actualPurchaseId.trim().equals(strPurchaseId))&&(actualStatus.trim().equals(strStatus))&&(actualPoLines.trim().equals(strPoLines)))
			{
				report.updateTestLog("PO Details verification", "Actual PO Id : "+actualPurchaseId+ "Actual Status : "+actualStatus+ "Actual PO Lines : "+actualPoLines, Status.PASS);
			}else
			{
				report.updateTestLog("PO Details verification", "Actual PO Id : "+actualPurchaseId +" Expected PO Id : "+strPurchaseId+ "Actual Status : "+actualStatus+"Expected Status : "+strStatus+"Actual PO Lines : "+actualPoLines+"Expected PO Lines: "+strPoLines, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}          
	}

	/**
	 *********************************************************************** 
	 * Function selects the current date from the calendar.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void selectDate()
	{
		DateFormat dateFormat2 = new SimpleDateFormat("dd"); 
		Date date2 = new Date();

		String strToday = dateFormat2.format(date2); 
		int temptoday = Integer.parseInt(strToday); 
		String today =  String.valueOf(temptoday).toString();

		//find the calendar
		WebElement dateWidget = driver.findElement(By.xpath("//div[@class='calendar']"));  
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  

		//comparing the text of cell with today's date and clicking it.
		for (WebElement cell : columns) {
			if (cell.getText().equals(today)) {
				cell.click();
				break;
			}
		}

	} 

	/**
	 *********************************************************************** 
	 * Function creates a new ASN for a selected Purchase Order.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   None
	 * @version 1.0
	 ***********************************************************************
	 */
	public String[] createAsn() throws InterruptedException
	{
		String[] AsnDetails = new String[2];
		/*libManhattanCommonFunctions.clickAnyElement("//input[@id='dataForm:treeTable:0:treeB:adaptor:0::selectId']","XPATH", "CheckBox");
            Thread.sleep(2000);*/
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAdd"), "Add Button");
		Thread.sleep(4000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnGenerate"), "Generate Button");
		Thread.sleep(4000);
		AsnDetails[0] = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:asnidh1']", "XPATH").getAttribute("value");
		libManhattanCommonFunctions.clickAnyElement("//input[@id='trigger_dataForm:sdqtyhcc']","XPATH", "Calendar");
		Thread.sleep(2000);
		selectDate();
		// libManhattanCommonFunctions.clickAnyElement("//div[text()='Today']","XPATH", "Today'sDate");
		Thread.sleep(2000);
		AsnDetails[1] = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:sdqtyhcc']", "XPATH").getAttribute("value");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOK"), "OK Button");
		Thread.sleep(4000);
		return AsnDetails;

	}

	/**
	 *********************************************************************** 
	 * Function clicks on the save button.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   AsnId
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickSave()
	{
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save Button");              
	}

	/**
	 *********************************************************************** 
	 * Function validates the newly created ASN ID.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   AsnId
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateAsn(String AsnId)
	{
		try
		{
			int length= AsnId.length();
			String temp=AsnId.substring(0, 3); 
			if((length==10)&&(temp.trim().equals("ASN")))
			{
				report.updateTestLog("ASN ID verification", "Actual ASN Id : "+AsnId+ "Actual length : "+length, Status.PASS);
			}else
			{
				report.updateTestLog("ASN ID verification","ASN ID not verified", Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}     
	}

	/**
	 *********************************************************************** 
	 * Function validates ASN date assignment (Ship Date).
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   Date
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateDel_Date(String strDate)
	{
		try
		{
			String    actualDate = strDate.substring(0, strDate.length() - 5);
			//                            String arrDate[] = strDate.split(":"); 
			//                            String actualDate = arrDate[0].trim();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
			//get current date time with Date()
			Date date = new Date();
			String strToday=(dateFormat.format(date));
			if(actualDate.trim().equals(strToday.trim()))
			{
				report.updateTestLog("Delivery Date verification", "Actual Delivery Date : "+actualDate, Status.PASS);
			}else
			{
				report.updateTestLog("Delivery Date verification", "Actual Delivery Date : "+actualDate +" Expected Delivery Date : "+strToday, Status.FAIL);
			}

		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);

		}     
	}

	/**
	 *********************************************************************** 
	 * Function enters ASN id in search box and clicks on apply button.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   strAsnID
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterAsnID(String strAsnID){
		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ASN_ID"), strAsnID, "ASN ID");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApplyASN"), "Apply Button");
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("lnkexpandASN"), "Expand ASN Button");
			Thread.sleep(8000);
			System.out.println("ASN ID :"+strAsnID);
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 *********************************************************************** 
	 * Function  Validates that the ASN ID created is the incremented step value of the Previously created ASN ID.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   strAsnID
	 * @version 1.0
	 ***********************************************************************
	 */
	public void AsnNxtStepValidation(String strAsnID){
		try{
			String arrNewAsn[]=createAsn();
			String NewAsnId = arrNewAsn[0];
			int count = 0;
			for (int i = 0; i < strAsnID.length(); i++)
				if (strAsnID.charAt(i) == '0')
					count++;
			String arractualAsnID1[] = strAsnID.split("N");
			Integer x = Integer.valueOf(arractualAsnID1[1]);
			x=x+1;
			String actualAsnID = "" + x;
			String temp="";
			for(int i=0;i<count;i++){
				temp= temp +"0";
			}
			actualAsnID = "ASN"+temp+actualAsnID;
			if(NewAsnId.trim().equals(actualAsnID))
			{
				report.updateTestLog("ASN Next Step validation", "Actual ASN Id : "+strAsnID+ "New ASN Id : "+NewAsnId, Status.PASS);
			}else
			{
				report.updateTestLog("ASN Next Step validation","Actual ASN Id : "+strAsnID+ "New ASN Id :  "+NewAsnId, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 *********************************************************************** 
	 * Function assigns quantity to the asn and maps PO with the ASN.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void mapASNtoPO()
	{
		try{
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement("//input[@id='dataForm:treeTable:0:treeB:adaptor:0::selectId']","XPATH", " PO CheckBox");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement("//input[@id='dataForm:atreeTable:0:atreeB:aadaptor:0::aselectId']","XPATH", " ASN CheckBox");
			libManhattanCommonFunctions.clickAnyElement("//input[@id='dataForm:cb5']","XPATH", "Map");
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement("//input[@value='Save']","XPATH", "Save Button");
			Thread.sleep(4000);
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 
	}

	/**
	 *********************************************************************** 
	 * Function verify the ASN details.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   strAsnId,strQuantity
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyAsnDetails(String strAsnId,String strQuantity)
	{
		try
		{
			String actualstrAsnId =libManhattanCommonFunctions.getElementByProperty("(//span[@class='h-outputTextH'])[2]", "XPATH").getText();
			actualstrAsnId = actualstrAsnId.replace("(...", ",");
			String actualstrASN[] = actualstrAsnId.split(",");
			actualstrAsnId = actualstrASN[0].trim();
			String actualstrQty =  libManhattanCommonFunctions.getElementByProperty("//input[@name='dataForm:atreeTable:0:atreeB:aadaptor:0:apdadaptor2:0::j_id164']", "XPATH").getAttribute("value");
			if((actualstrAsnId.trim().equals(strAsnId))&&(actualstrQty.trim().equals(strQuantity)))
			{
				report.updateTestLog("ASN Details verification", "Actual ASN Id : "+actualstrAsnId+ "Actual Quantity : "+actualstrQty, Status.PASS);
			}else
			{
				report.updateTestLog("ASN Details verification","Actual ASN Id : "+actualstrAsnId+ "Expected Asn Id : "+strAsnId+"Actual Quantity : "+actualstrQty+ "Expected Quantity : "+strQuantity, Status.FAIL);
			}
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save Button");
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}     
	}

	/**
	 *********************************************************************** 
	 * Function verify the added ASN line from the Purchase Order.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   strPurchaseId,strlines
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyAddedAsn(String strPurchaseId,int strlines){
		try{
			int PO_Lines= 3*strlines;
			//int PO_Lines= lines+1;
			String actualstrPurchaseId=libManhattanCommonFunctions.getElementByProperty("(//span[@class='h-outputTextD'])["+PO_Lines+"]", "XPATH").getText();
			libManhattanCommonFunctions.clickAnyElement("//img[@id ='dataForm:atreeTable:0:atreeB:aadaptor:0::j_id136:handle:img:expanded']","XPATH", "ASN close link");
			if((actualstrPurchaseId.trim().equals(strPurchaseId)))
			{
				report.updateTestLog("Added ASN Details verification", "Actual Purchase Id : "+actualstrPurchaseId, Status.PASS);
			}else
			{
				report.updateTestLog("Added ASN Details verification","Actual Purchase Id : "+actualstrPurchaseId+ "Expected Purchase Id : "+strPurchaseId, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}  
	}

	/**
	 *********************************************************************** 
	 * Function edits the ASN Quantity.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   strNewQty
	 * @version 1.0
	 ***********************************************************************
	 */
	public void editAsnQty(String strNewQty)
	{
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Quantity"), strNewQty, "Quantity");
		libManhattanCommonFunctions.clickAnyElement("//img[@id ='dataForm:atreeTable:0:atreeB:aadaptor:0::j_id136:handle:img:expanded']","XPATH", "ASN close link");
	}

	/**
	 *********************************************************************** 
	 * Function verifies the edited the ASN Quantity.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   strEditedQty
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyeditedQty(String strEditedQty)
	{
		String actualstrQty=libManhattanCommonFunctions.getElementByProperty("//input[@name ='dataForm:atreeTable:0:atreeB:aadaptor:0:apdadaptor2:0::j_id164']", "XPATH").getAttribute("value");
		if((actualstrQty.trim().equals(strEditedQty)))
		{
			report.updateTestLog("Edited ASN Details verification", "Edited Quantity : "+actualstrQty, Status.PASS);
		}else
		{
			report.updateTestLog("Added ASN Details verification","Actual Quantity : "+actualstrQty+ "Expected Quantity : "+strEditedQty, Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function verify if the deleted quantity is added back to the Purchase Order.
	 * @return  Nothing is returned as of now 
	 * @Author  Nitika
	 * @param   Qty1,Qty2
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyDelQty(String strQty1,String strQty2)
	{
		if((strQty1.trim().equals(strQty2)))
		{
			report.updateTestLog("Deleted ASN Details verification", "Deleted Quantity : "+strQty1, Status.PASS);
		}else
		{
			report.updateTestLog("Deleted ASN Details verification","Quantity actually deleted : "+strQty1+ "Quantity expected to be deleted : "+strQty2, Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function retrieves the item number associated with a Purchase Order.
	 * @return  ItemNum 
	 * @Author  Nitika
	 * @param   None
	 * @version 1.0
	 ***********************************************************************
	 */
	public String getItem_Num()throws InterruptedException
	{
		String ItemNum = libManhattanCommonFunctions.getElementByProperty("(//span[@class='h-outputTextD'])[2]", "XPATH").getText();
		return ItemNum;
	}

	/**
	 *********************************************************************** 
	 * Function assigns a specific quantity to the asn and maps PO with the ASN.
	 * @return  Nothing is returned as of now 
	 * @Author  Aishwarya
	 * @param   strQtytoAssign
	 * @version 1.0
	 ***********************************************************************
	 */
	public void mapASNtoPOSplitqty(String strQtytoAssign)
	{
		try{
			//libManhattanCommonFunctions.clickAnyElement("//input[@id='dataForm:treeTable:0:treeB:adaptor:0::selectId']","XPATH", " PO CheckBox");
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement("//input[@id='dataForm:atreeTable:0:atreeB:aadaptor:0::aselectId']","XPATH", " ASN CheckBox");
			//libManhattanCommonFunctions.clickAnyElement("//img[@id='dataForm:treeTable:0:treeB:adaptor:0::tn1:handle:img:collapsed']","XPATH", " Expand PO");
			Thread.sleep(8000);
			libManhattanCommonFunctions.clickAnyElement("//a[@id='dataForm:treeTable:0:treeB:adaptor:0:pdadaptor2:0::a4jsupfgp1']/span","XPATH", "PO Qty");
			Thread.sleep(4000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("QuantitytoAssign"), strQtytoAssign, "Quantity");
			libManhattanCommonFunctions.clickAnyElement("//input[@id='dataForm:sva']","XPATH", "OK Button");
			Thread.sleep(2000);
			//libManhattanCommonFunctions.clickAnyElement("//input[@value='Save']","XPATH", "Save Button");
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 
	}

}