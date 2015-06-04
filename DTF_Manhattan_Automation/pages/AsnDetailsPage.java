package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class AsnDetailsPage extends AnyManhattanPage
{		

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public AsnDetailsPage(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		try{

		}catch(Exception e){
			report.updateTestLog("AsnDetailsPage-OBJECT IDENTIFICATION", "Error in finding Page Object/element : " + e.getMessage(), Status.FAIL);
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
		if (getCurrentPage("ASNPage"))
			report.updateTestLog("ASN Details Page verification", "ASN Details loaded as expected.", Status.DONE);
		else
			report.updateTestLog("ASN Details Page verification", "ASN Details page loaded not loaded!!!!", Status.FAIL);
	}

	/**
	 * To use switch case we are declaring the below enum for MyAccount,Login,Logout,MiniCart 
	 */
	private enum enumPageObjects
	{
		lnkLines, delLine, Item;		}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: ASN,ASNsBusinessPartner,ASNStatus,ASNNumber,lnkASNs,ASN_Header, ASNStatus_Header,ASNsBusinessPartner_Header, btnApply, ReceiptVariance_Header, BusinessUnit_Header, PickupFacility_Header, DeliveryFacility_Header, EstimatedDeliveryDate_Header, ShippedDate_Header, TotalShipped_Header, TotalReceived_Header, COGI_Header, Shipment_Header
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case lnkLines:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@name='ASNDetailASNLinesTab']", "XPATH");
				break;
			case delLine:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Delete Line']", "XPATH");
				break;
			case Item: 
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ASNDetailPOListTable:0:SKUId']", "XPATH");
				break;
			default:
				break;
			}
			report.updateTestLog("ASN Details- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("ASN Details- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}

	/**
	 *********************************************************************** 
	 * Function returns the number of lines.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public int getNumberOfLines()
	{
		Integer x=0;
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		libManhattanCommonFunctions.clickAnyElement(getPageElement("lnkLines"), "Lines");
		String Lines = libManhattanCommonFunctions.getElementByProperty("(//span[@class='pagerNoWrap'])[2]", "XPATH").getText();
		String lines = Lines.substring(Lines.lastIndexOf("f")+1).trim();
		x = Integer.parseInt( lines );
		//	System.out.println(x);
		return x;
	}

	/**
	 *********************************************************************** 
	 * Function performs enter keyboard action.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
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
	 * Function clicks OK on the new pop up dialog Box.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickUndoWave() throws InterruptedException, AWTException{
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}

	/**
	 *********************************************************************** 
	 * Function deletes the last line item.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public String deleteLastLine()
	{
		int strRow=getNumberOfLines();
		strRow = strRow-1;
		String Quantity = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ASNDetailPOListTable:"+strRow+":shippedQtyuom']", "XPATH").getText();
		String arrQty[] = Quantity.split("U");
		Quantity = arrQty[0].trim();
		libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c"+strRow+"_dataForm:ASNDetailPOListTable']","XPATH", "CheckBox");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("delLine"), "Delete Lines Button");
		return Quantity;
	}

	/**
	 *********************************************************************** 
	 * Function returns the Appointment Id.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public String getAppointmentId()
	{
		//Integer x=0;
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		String ApptId = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ASN_Details_ASN_appointmentIdString']", "XPATH").getText();
		//x = Integer.parseInt( ApptId );
		//	System.out.println(x);
		return ApptId;
	}

	/**
	 *********************************************************************** 
	 * Function returns the number of recieved iLPNs.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public String getRecievedLPN() throws InterruptedException
	{
		//Integer x=0;
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		libManhattanCommonFunctions.clickAnyElement(getPageElement("lnkLines"), "Lines");
		Thread.sleep(4000);
		String RecLPNs = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ASNDetailsASNLines_OT_LPNsRecevied']", "XPATH").getText();
		//x = Integer.parseInt( lines );
		//	System.out.println(x);
		return RecLPNs;
	}


	/**
	 *********************************************************************** 
	 * Function returns the number of recieved iLPNs.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public String[] retrieveAsnDetails() throws InterruptedException
	{
		String asnDetails[] = new String[6];
		String RecLPNS = getRecievedLPN();
		String PO = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ASNDetailsASNLines_OT_POId']", "XPATH").getText();
		String Item_Num = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ASNDetailsASNLines_OT_ItemId']", "XPATH").getText();
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Item"), "Item");
		Thread.sleep(2000);
		String Item_Desc = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:Item_popup_Description_out']", "XPATH").getText();
		String Item_BarCode = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:Item_popup_barcode_outText']", "XPATH").getText();
		asnDetails[0] = RecLPNS; asnDetails[1] = PO;asnDetails[2] = Item_Num; asnDetails[3] = Item_Desc; asnDetails[4] = Item_BarCode;
		return asnDetails;
	}

}
