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

public class RFMenuPage extends AnyManhattanPage {
	WebElement imgManhattanLogo;

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public RFMenuPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try {

		} catch (Exception e) {
			report.updateTestLog("ActivityTrackingPage-OBJECT IDENTIFICATION"," in finding Page Object/element : " + e.getMessage(),Status.FAIL);
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
		if (getCurrentPage("RFMenuPage"))
			report.updateTestLog("RFMenu verification","RFMenu loaded as expected.", Status.DONE);
		else
			report.updateTestLog("RFMenu verification","RFMenu loaded as expected.", Status.DONE);
	}

	private enum enumPageObjects {

		btnOptions, btnChangeTaskGrp, TaskGroup, btnEnter, btnExit, Choice, btnPageUp, btnPageDown, LPN_Num, btnEndScan, Res_Loc, txtDockDoor, txtASNSelectValue, btnPrevious, txtboxASN, btnProceedWarning, txtboxLPN, txtboxItemBarcode, txtboxItemQty, LPN_Num_Mod, New_Qty, Reason_Code, LPN_Num_Lock, Lock_Code, Barcode, btnPrev, Trailer, DestinationLocation, DestLoc, btnComplete, TaskChoice, ASNnumber, iLPNnumber, R_Loc_Bulk, LPN_Num_Bulk, BtnAccptAndProceed, Pallet, FR_iLPN, SelectSeq, ReserveLoc, ActiveLoc, NumberofLPNs, btnAcceptProceed, btnNextEnd, btnEnterTask, TaskID, oLPNNumber, Task_Id, itemQty, btnAlternate, btnAccept, ChooseTaskChoice, Task_Sel, Move_Qty, btnSubstitute, R_Loc_PP, txtboxItem, txtboxPalletNbr, btnAcpt_PalletWarning, oLPN_Num, Shipment_Id, iLPN_Num, sequencecode, btnLst_Sort_Zns, btnProceedverifyASN, btnProceedvarianceWarning, btnOverrideWarning, LocationEmpty, R_Loc_Rec, btnLocateallLPNs,

	txtPO_Id, btnAlt, btnShort, Load_LTL_Shipment, Res_Loc_SingleByPass, itembarcode, btnLocAllLpns, ReplLPN, PLoc, btnToggle, tasking_itemBarcode2, tasking_sequence, tasking_itemBarcode, tasking_olpn, txt_pickerid, txt_pickcartnumber, txt_Olpn, txt_ItemNumber, txt_pickNumber, btnEndofPickCart, txt_SlotNumber, txt_OlpnNumber, CC_ItemBarcode, CC_ItemQty, BtnContinueCount, PickToteItemBarcode, btnEndTote, Tote, Location_Inq, ToteOLPN, txt_Pallet, txt_iLPN, txt_locationempty, txt_RLoc, A_Loc_LPN, txt_Item, txt_Tote, txt_itemnbr, A_Loc_Bulk, txt_Segment, txt_oLPNs, txt_LPN, txt_toteitm, txt_oLPN, CtrlKDeleteDetail, CtrlYAddDetail, CtrlGChangeDetail, Palletize_LPN, btn_EndPallet, Item_CreateLPN, Expiry_Date, Expiry_Month, Expiry_Year;}
	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: btnOptions, btnChangeTaskGrp, TaskGroup, btnEnter, btnExit, Choice, btnPageUp, btnPageDown, LPN_Num, btnEndScan, Res_Loc, txtDockDoor, txtASNSelectValue, btnPrevious, txtboxASN, btnProceedWarning, txtboxLPN, txtboxItemBarcode, txtboxItemQty, LPN_Num_Mod, New_Qty, Reason_Code, LPN_Num_Lock, Lock_Code, Barcode, btnPrev,BtnAccptAndProceed, Pallet, FR_iLPN
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)

	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {
			case btnOptions:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='tb_567']", "XPATH");
				break;
			case btnChangeTaskGrp:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Chg Task Grp']", "XPATH");
				break;
			case TaskGroup:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@name='dataForm:taskGrp']", "XPATH");
				break;
			case btnEnter:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Enter']", "XPATH");
				break;
			case btnExit:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Exit']", "XPATH");
				break;
			case Choice:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:it_1']", "XPATH");
				break;
			case btnPageUp:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Page Up']", "XPATH");
				break;
			case btnPageDown:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Page Down']", "XPATH");
				break;
			case LPN_Num:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[starts-with(@id,'barcode')]", "XPATH");
				break;
			case btnEndScan:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='End Scan']", "XPATH");
				break;
			case Res_Loc:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='sLb_Input']", "XPATH");
				break;

			case LPN_Num_Mod:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode1']", "XPATH");
				break;
			case New_Qty:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[starts-with(@id,'input1qty')]", "XPATH");
				break;
			case Reason_Code:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[starts-with(@id,'dataForm:rsn')]", "XPATH");
				break;
			case LPN_Num_Lock:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode3']", "XPATH");
				break;
			case Lock_Code:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ip01']", "XPATH");
				break;
			case Barcode:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode2Brcd']", "XPATH");
				break;
			case btnPrev:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Prev']", "XPATH");
				break;
			case Trailer:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:yms_rf_mt_input2']", "XPATH");
				break;
			case DestinationLocation:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:yms_rf_mt_input3']", "XPATH");
				break;
			case DestLoc:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:dummy']", "XPATH");
				break;
			case btnComplete:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Complete']", "XPATH");
				break;
			case TaskChoice:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:yms_rf_tl_menuSelection']", "XPATH");
				break;
			case ASNnumber:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode']", "XPATH");
				break;	 
			case iLPNnumber:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode']", "XPATH");
				break;	 
			case R_Loc_Bulk:
				elemToFind = libManhattanCommonFunctions.getElementByProperty( "//input[@id='subLocationEntry_Input']", "XPATH");
				break;
			case LPN_Num_Bulk:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='containerEntry']", "XPATH");
				break;
			case BtnAccptAndProceed:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Accpt/Proceed']", "XPATH");
				break; 
			case Pallet:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode272DirL']", "XPATH");
				break;
			case FR_iLPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[starts-with(@id,'brcd')])[2]", "XPATH");
				break;
			case SelectSeq:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:barcode217']", "XPATH");
				break;
			case ReserveLoc:
				elemToFind = libManhattanCommonFunctions.getElementByProperty( "//input[@id='locn_Input']", "XPATH");
				break;
			case ActiveLoc:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='locn_Input']", "XPATH");
				break;
			case NumberofLPNs:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:q1ty2']", "XPATH");
				break;
			case btnAcceptProceed:
				elemToFind = libManhattanCommonFunctions.getElementByProperty( "//span[@value='Accpt/Proceed']", "XPATH");
				break;
			case btnNextEnd:
				elemToFind = libManhattanCommonFunctions.getElementByProperty( "//span[@value='Next/End Locn']", "XPATH");
				break;
			case btnEnterTask:
				elemToFind = libManhattanCommonFunctions.getElementByProperty( "//span[@value='Enter Task']", "XPATH");
				break;
			case TaskID:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:input1']", "XPATH");
				break;
			case oLPNNumber:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='test']", "XPATH");
				break;
			case Task_Id:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:input1']", "XPATH");
				break;
			case itemQty:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='input1qtyQty51']", "XPATH");
				break;
			case btnAlternate:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Alternate']", "XPATH");
				break;
			case btnAccept:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Accpt/Proceed']", "XPATH");
				break;
			case ChooseTaskChoice:	
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:choice1']", "XPATH");
				break;
			case Task_Sel:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Task Selctn']", "XPATH");
				break;
			case Move_Qty:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='input1qty2']", "XPATH");
				break;
			case btnSubstitute:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Substitute']", "XPATH");
				break;

			case PickToteItemBarcode:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='itemId2Brcd']", "XPATH");
				break;

			case oLPN_Num:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode1']", "XPATH");
				break;
			case Shipment_Id:	
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode2']", "XPATH");
				break;
			case iLPN_Num:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[starts-with(@id,'barcode')]", "XPATH");
				break;
			case btnLst_Sort_Zns:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Lst Sort Zns']", "XPATH");
				break;
			case sequencecode:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:iText27ZnList']", "XPATH");
				break;

			case txtDockDoor:

				elemToFind = libManhattanCommonFunctions.getElementByProperty(
						"//input[@id='DockInp']", "XPATH");

				break;

			
			case txtASNSelectValue:

				elemToFind = libManhattanCommonFunctions.getElementByProperty(
						"//input[@id='dataForm:seqid']", "XPATH");

				break;
			case btnPrevious:

				elemToFind = libManhattanCommonFunctions.getElementByProperty(
						" //span[text()='Prev']", "XPATH");

				break;
			case txtboxASN:

				elemToFind = libManhattanCommonFunctions.getElementByProperty(
						"//input[@id='shipinpId']", "XPATH");

				break;
			case btnProceedWarning:

				elemToFind = libManhattanCommonFunctions.getElementByProperty(
						"//span[@id='rfbtn_dataForm:SCEAcceptKey']", "XPATH");

				break;
			case txtboxLPN:

				elemToFind = libManhattanCommonFunctions.getElementByProperty(
						"//input[@id='lpninput']", "XPATH");

				break;
			case txtboxItemBarcode:

				elemToFind = libManhattanCommonFunctions.getElementByProperty(
						"//input[@id='verfiyItemBrcd']", "XPATH");

				break;
			case txtboxItemQty:

				elemToFind = libManhattanCommonFunctions.getElementByProperty(
						" //input[@id='input1input2']", "XPATH");

				break;

			case txtboxItem:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='verfiyItemItemName']", "XPATH");
				break;
			case txtboxPalletNbr:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode272DirL']", "XPATH");
				break;
			case btnAcpt_PalletWarning:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//div[@id='tool_bar_buttons']//td[1]", "XPATH");
				break;
			case btnProceedverifyASN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//div[@id='tool_bar_buttons']//td[1]", "XPATH");
				break;
			case btnProceedvarianceWarning:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//div[@id='tool_bar_buttons']//td[1]", "XPATH");
				break;
			case R_Loc_PP:

				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='subLocationEntryUserDirected_Input']", "XPATH");

				break;
			case btnOverrideWarning:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//div[@id='tool_bar_buttons']//td[1]", "XPATH");
				break;
			case LocationEmpty:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:locationempty']", "XPATH");
				break;
			case R_Loc_Rec:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='locn2DirL_Input']", "XPATH");
				break;
			case btnLocateallLPNs:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[text()='Locate all LPNs']", "XPATH");
				break;
			case txtPO_Id:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:poIdinp']", "XPATH");
				break;
			case btnAlt:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Alt/Lock']", "XPATH");
				break;
			case btnShort:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Skip/Cncl/Lck']", "XPATH");
				break;
			case Load_LTL_Shipment:

                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode20']", "XPATH");

                break; 
			case Res_Loc_SingleByPass:

                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='confirmlocation_Input']", "XPATH");

                break;

			case itembarcode:

                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='verfiyItemBrcd']", "XPATH");

                break;
			case btnLocAllLpns:
				

                elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Locate all LPNs']", "XPATH");

                break;
			case ReplLPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='test1']", "XPATH");
				break;   

			case PLoc:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='sublocn1_Input']", "XPATH");
				break;   
				
			case btnToggle:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@title='CTRL-A Toggle']", "XPATH");
				break;

			case tasking_itemBarcode2:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[starts-with(@id,'itemId2')])[1]", "XPATH");
				break;
				
			case tasking_sequence:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:selectNo']", "XPATH");
				break;
				
			case tasking_itemBarcode:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[starts-with(@id,'itemId')])[1]", "XPATH");
				break;
				

			case tasking_olpn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='tote1re']", "XPATH");
				break;
				
            case txt_pickerid:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:dtltxt1_b']", "XPATH");
                break;
          case txt_pickcartnumber:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode']", "XPATH");
                break;
          case txt_OlpnNumber:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode']", "XPATH");
                break;
          case txt_SlotNumber:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:SlotNbr']", "XPATH");
                break;
          case btnEndofPickCart:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[text()='End Pick Cart']", "XPATH");
                break;
          case txt_pickNumber:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:dtltxt1_b']", "XPATH");
                break;
          case txt_ItemNumber:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@id='itemId2ItemName']", "XPATH");
                break;
          case txt_Olpn:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode1']", "XPATH");
                break;
          case CC_ItemBarcode:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='itemIdBrcd']", "XPATH");
				break;
          case CC_ItemQty:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='input1qty20']", "XPATH");
				break;
          case BtnContinueCount:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='Continue Count']", "XPATH");
				break;

			case btnEndTote:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='End Tote']", "XPATH");
				break;
			case Tote:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode']", "XPATH");
				break;
			case Location_Inq:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='SubLoc1_Input']", "XPATH");
				break;

			case ToteOLPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='tote1re']", "XPATH");
				break;	
			case txt_Pallet:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode1']", "XPATH");
				break;
			case txt_iLPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode2']", "XPATH");
				break;
			case txt_locationempty:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:locationempty']", "XPATH");
				break;
			case txt_RLoc:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='confirmlocation_Input']", "XPATH");
				break;
			case txt_Item:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='confirmlocation_Input']", "XPATH");
				break;
			case txt_Tote:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode']", "XPATH");
				break;
			case txt_itemnbr:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='itemIdItemName']", "XPATH");
				break;
			case txt_oLPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='tote1re']", "XPATH");
				break;
			case txt_toteitm:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='itemId2ItemName']", "XPATH");
				break;
			case txt_oLPNs:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode']", "XPATH");
				break;
			case txt_Segment:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='tsegt1']", "XPATH");
				break;
			case txt_LPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='ttest1']", "XPATH");
				break;
			case A_Loc_Bulk:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='sublocn1_Input']", "XPATH");
				break;
			case A_Loc_LPN:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@id='tesd3s']", "XPATH");
				break;
			case CtrlKDeleteDetail:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("(//*[@title='Ctrl-K Delete Detail'])[2]", "XPATH");
                break;
			case CtrlYAddDetail:
                elemToFind = libManhattanCommonFunctions.getElementByProperty("(//*[@title='Ctrl-Y Add Detail'])[2]", "XPATH");
                break;
			 case CtrlGChangeDetail:
	                elemToFind = libManhattanCommonFunctions.getElementByProperty("(//*[@title='Ctrl-G Chg Dtl'])[2]", "XPATH");
	                break;
			case  Palletize_LPN:
	             elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode5']", "XPATH");
	             break;
           case btn_EndPallet:
             elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[@value='End Pallet']", "XPATH");
             break;
           case  Item_CreateLPN:
             elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='barcode2ItemName']", "XPATH");
             break;
           case Expiry_Date:
               elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:exp1Part0']", "XPATH");
		      break;
		       case Expiry_Month:
		
		              elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:exp1Part2']", "XPATH");
		      break;
		       case Expiry_Year:
		               elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:exp1Part4']", "XPATH");
		      break;


				
			default:
				break;

			}

			report.updateTestLog("RFMenuPage- GET PAGE ELEMENT", ""+ strElemName + "is selected from Main MenuPage",Status.DONE);

		} catch (Exception e) {
			report.updateTestLog("RFMenuPage- GET PAGE ELEMENT", ""+ strElemName + "is not found", Status.FAIL);
		}

		return elemToFind;
	}

	/**
	 *********************************************************************** 
	 * Function clicks on option icon.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOptionsIcon() {

		try {
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			if(libManhattanCommonFunctions.verifyElementPresent(" //span[contains(text(),'Accpt')]", "XPATH"))
			{
				libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOverrideWarning"),"Pallet sort warning");
				Thread.sleep(4000);
				libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOptions"), "Options Icon");
			}
			else
			{
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOptions"), "Options Icon");
			}
		} catch (Exception e) {
			report.updateTestLog("iLPNPage Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function clicks on change task group button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnChangeTaskGrp() throws InterruptedException {
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnChangeTaskGrp"), "Change Task Group Button");
		Thread.sleep(2000);
	}

	/**
	 *********************************************************************** 
	 * Function clicks on page up button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnPageUp() throws InterruptedException {

		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnPageUp"), "PageUp Button");

	}

	/**
	 *********************************************************************** 
	 * Function clicks on previous button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnPrev() throws InterruptedException{
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnPrev"), "Previous Button");                                       
	}


	/**
	 *********************************************************************** 
	 * Function clicks on page down button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnPageDown() throws InterruptedException {

		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnPageDown"), "PageDown Button");

	}

	/**
	 *********************************************************************** 
	 * Function clicks on exit button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnExit() throws InterruptedException {

		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnExit"),"Change Task Group Button");

	}

	/**
	 *********************************************************************** 
	 * Function clicks on end scan button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnEndScan() throws InterruptedException {
		Thread.sleep(3000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEndScan"), "End Scan Button");

	}
	/**
	 *********************************************************************** 
	 * Function clicks locate All Lpns.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnLocAllLpns() throws InterruptedException {
		Thread.sleep(1000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnLocAllLpns"), "Locate All Lpns Button");

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
      * Function enters details for creating an iLPN.
     * @return    Nothing is returned as of now 
      * @Author    Nitika
     * @param     strLPNNumber, strReasonCode, strItemNumber, strQuantity
     * @version 1.0
     * @param strItemNumber 
      * @throws InterruptedException 
      * @throws AWTException 
      ***********************************************************************
     */
     public void CreateLPN(String strLPNNumber, String strReasonCode, String strItemNumber, String strQuantity) throws InterruptedException, AWTException
     {
            if (strLPNNumber.contains(";")){
                   Thread.sleep(3000);
                   String[] strLPNs = strLPNNumber.split(";");
                   String[] strItems = strItemNumber.split(";");
                   for(int intLoop=0;intLoop<strLPNs.length;intLoop++)
                   {
            enteriLPN(strLPNs[intLoop]);
            Thread.sleep(4000);
            pressEnter();
            Thread.sleep(4000);
            enterReasonCode(strReasonCode);
            Thread.sleep(4000);
            pressEnter();
            Thread.sleep(8000);
            pressEnter();
            Thread.sleep(8000);
            keyCTRLA();
            Thread.sleep(4000);
            keyCTRLA();
            Thread.sleep(4000);
            libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Item_CreateLPN"), strItems[intLoop], "Item Number");
//          System.out.println(strLPNs[intLoop]);
//          System.out.println(strItems[intLoop]);
            System.out.println(strItems[intLoop]+"  : "+strLPNs[intLoop]);
            Thread.sleep(4000);
            pressEnter();
            Thread.sleep(8000);
            enterNewQty(strQuantity);
            Thread.sleep(4000);
            pressEnter();
            Thread.sleep(4000);
            if (libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:exp1Part0']", "XPATH")){
                   libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Expiry_Date"), "4", "Expiry Date");
                   Thread.sleep(1000);
                   libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Expiry_Month"), "26", "Expiry Month");
                   Thread.sleep(1000);
                   libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Expiry_Year"), "16", "Expiry Year");
                   Thread.sleep(2000);
                   }
            }
            }
            else
            {
                   enteriLPN(strLPNNumber);
                   Thread.sleep(4000);
                   pressEnter();
                   Thread.sleep(4000);
                   enterReasonCode(strReasonCode);
                   Thread.sleep(4000);
                   pressEnter();
                   Thread.sleep(8000);
                   pressEnter();
                   Thread.sleep(8000);
                   keyCTRLA();
                   Thread.sleep(4000);
                   keyCTRLA();
                   Thread.sleep(4000);
                   libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Item_CreateLPN"), strItemNumber, "Item Number");
                   Thread.sleep(4000);
                   pressEnter();
                   Thread.sleep(8000);
                   enterNewQty(strQuantity);
                   Thread.sleep(4000);
                   pressEnter();
                   Thread.sleep(8000);
            if (libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:exp1Part0']", "XPATH")){
                   libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Expiry_Date"), "4", "Expiry Date");
                   Thread.sleep(1000);
                   libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Expiry_Month"), "26", "Expiry Month");
                   Thread.sleep(1000);
                   libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Expiry_Year"), "15", "Expiry Year");
                   Thread.sleep(2000);
            }
     }
     }




     /**
      *********************************************************************** 
       * Function palletizes an iLPN.
      * @return    Nothing is returned as of now 
       * @Author    Nitika
      * @param     strLPNNumber, strReasonCode, strItemNumber, strQuantity
      * @version 1.0
      * @param strItemNumber 
       * @throws Exception 
       ***********************************************************************
      */
      public void palletizeLPN(String strPallet, String LPN_Num) throws Exception
      {
             String[] Pallets = splitDataValues(strPallet);
             String[] strLPNs = splitDataValues(LPN_Num);
             for (int i=0;i<Pallets.length;i++){
             libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ASNnumber"), Pallets[i], "Pallet Number");
             Thread.sleep(4000);

             pressEnter();
             Thread.sleep(4000);
             clickAcceptAndProceed();
             if (LPN_Num.contains(";")){
                    Thread.sleep(3000);               
//                    for(int intLoop=2*i;intLoop<2*i+2;intLoop++)
//                    {
                           libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Palletize_LPN"), strLPNs[i], "LPN Number");
                          Thread.sleep(4000);

                          pressEnter();
                          Thread.sleep(4000);
                          clickAcceptAndProceed();
                          Thread.sleep(3000);
                          
//                          break;//for single pallet
//                    }
             }                          
             else
             {
                    libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Palletize_LPN"), LPN_Num, "LPN Number");
                    Thread.sleep(4000);
                    pressEnter();
                    Thread.sleep(4000);
                    clickAcceptAndProceed();
                    Thread.sleep(3000);
             }             
             clickAcceptAndProceed();
             libManhattanCommonFunctions.clickAnyElement(getPageElement("btn_EndPallet"),"End Pallet");
             Thread.sleep(4000);
             clickAcceptAndProceed();
             }
      }


	/**
	 *********************************************************************** 
	 * Function updates the task group and clicks on enter button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void updateTaskGrp(String strTaskGrp) throws InterruptedException {

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("TaskGroup"), strTaskGrp, "Task Group");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnter"),"Enter Button");

	}

	/**
	 *********************************************************************** 
	 * Function enters the choice in the main page.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strchoice
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterchoice(String strchoice) throws InterruptedException {
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		libManhattanCommonFunctions.waitForElementClickable("//input[@id='dataForm:it_1']", 4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Choice"), strchoice, "Choice");
	}

	/**
	 *********************************************************************** 
	 * Function verifies the updated task group.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strTaskGrp
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyupdatedTaskGrp(String strTaskGrp){
		try{
			libManhattanCommonFunctions.isElementPresentVerification("//input[@name='dataForm:taskGrp']", "XPATH", "TASK GROUP");
			String actualTaskGrp =driver.findElement(By.id("dataForm:taskGrp")).getAttribute("value");
			if(actualTaskGrp.trim().equals(strTaskGrp))
			{
				report.updateTestLog("Updated Task Group verification", "Actual Result: "+strTaskGrp, Status.PASS);
			}else
			{
				report.updateTestLog("Updated Task Group","Actual Result : "+actualTaskGrp +" Expected Result : "+strTaskGrp, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}   
	}


	/**
	 *********************************************************************** 
	 * Function enters the LPN Number.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strTaskGrp
	 * @version 1.0
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void enterLPNNum(String strLPNNum) throws InterruptedException, AWTException{ 
		if (strLPNNum.contains(";")){
			Thread.sleep(1000);
			String[] strLPNs = strLPNNum.split(";");
			for(int intLoop=0;intLoop<strLPNs.length;intLoop++)
			{
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), strLPNs[intLoop], "LPN Number");
				pressEnter();
			}
		}
		else{
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), strLPNNum, "LPN Number");
			pressEnter();
		}



	}

	/**
	 *********************************************************************** 
	 * Function enters the reserve location and clicks on enter button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strRLoc
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterRLoc(String strRLoc) throws InterruptedException{ 
		if(libManhattanCommonFunctions.verifyElementPresent("//span[text()='Locate all LPNs']", "XPATH"))
		{
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnLocateallLPNs"), "Enter Button");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Res_Loc"), strRLoc, "Reserve Location");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnter"), "Enter Button");
			Thread.sleep(2000);
		}
		else
		{
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Res_Loc"), strRLoc, "Reserve Location");
			Thread.sleep(4000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnter"), "Enter Button");
			Thread.sleep(4000);
		}
	}

	
	/**
	 *********************************************************************** 
	 * Function enters LPN number to be modified.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strLPNNum
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterLPNNumtobemodified(String strLPNNum) throws InterruptedException{ 
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num_Mod"), strLPNNum, "LPN Number to be modified");
	}


	/**
	 *********************************************************************** 
	 * Function enters quantity.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strNewQty
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterNewQty(String strNewQty) throws InterruptedException{ 

		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("New_Qty"), strNewQty, "New Quantity");

	}


	/**
	 *********************************************************************** 
	 * Function enters reason code.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strReasonCode
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterReasonCode(String strReasonCode) throws InterruptedException{ 

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Reason_Code"), strReasonCode, "Reason Code");

	}

	/**
	 *********************************************************************** 
	 * Function enters lock code.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strLockCode
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterLockCode(String strLockCode) throws InterruptedException{ 
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Lock_Code"), strLockCode, "Lock Code");
	}


	/**
	 *********************************************************************** 
	 * Function enters LPN number to be locked.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strLPNNum
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterLPNNumToLock(String strLPNNum) throws InterruptedException{ 
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num_Lock"), strLPNNum, "LPN Number");

	}

	/**
	 *********************************************************************** 
	 * Function is to switch frame.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void switchFrame() throws InterruptedException {

		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));

	}

	/**
	 *********************************************************************** 
	 * Function enters the barcode.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strBarcode
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterBarcode(String strBarcode) throws InterruptedException{ 
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Barcode"), strBarcode, "Barcode");
	}



	/**
	 *********************************************************************** 
	 * Function performs yard move task.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strTrailer, strDestinationLocation
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterYardMoveTaskDetails(String strTrailer, String strDestinationLocation) throws InterruptedException {
		libManhattanCommonFunctions.waitForElementClickable("//input[@id='dataForm:yms_rf_mt_input2']", 4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Trailer"), strTrailer, "Trailer");
		libManhattanCommonFunctions.waitForElementClickable("//input[@id='dataForm:yms_rf_mt_input3']", 4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DestinationLocation"), strDestinationLocation, "Destination Location");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnter"),"Enter Button");
		libManhattanCommonFunctions.waitForElementClickable("//span[@value='Enter']", 4000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnter"),"Enter Button");
		libManhattanCommonFunctions.waitForElementClickable("//span[@value='Complete']", 4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DestLoc"), strDestinationLocation, "DestLoc");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnComplete"),"Complete Button");

	}

	/**
	 *********************************************************************** 
	 * Function searches the item.
	 * @return    Nothing is returned as of now 
	 * @Author    Rahman
	 * @param     strSeq, strQuantity, strLocation
	 * @version 1.0
	 ***********************************************************************
	 */
	public void loopSearchitemseq(String strSeq,String strQuantity, String strLocation){
		try{
			if (strSeq.contains(";")){
				Thread.sleep(3000);
				String[] strseq = strSeq.split(";");
				String[] strqty = strQuantity.split(";");
				String[] strloc = strLocation.split(";");

				validateItemDetails(strseq,strqty,strloc);
				Thread.sleep(1000);

			}
			else{
				RetrieveSequence(strSeq, strQuantity, strLocation);                                                                    
			}

		}catch(Exception e){

		}
	}


	/**
	 *********************************************************************** 
	 * Function validates the item.
	 * @return    Nothing is returned as of now 
	 * @Author    Rahman
	 * @param     strSeq, strQuantity, strLocation
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateItemDetails(String strSeq[],String strQuantity[], String strLocation[]){                                

		try{                 
			int count=0,max=0;
			do{
				if (libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'+')]", "XPATH")){    
					RetrieveSequence(strSeq[count],strQuantity[count],strLocation[count]);
					if(count%2!=0)
					{
						clickOptionsIcon();
						clickOnPageDown();
					}
					count++;
					Thread.sleep(1000);
				}
				else{
					for(int i=max;i<=(max+1);i++)
					{                          
						RetrieveSequence(strSeq[i],strQuantity[i],strLocation[i]);
					}
				}
				max++;
			}while(count==max);
			Thread.sleep(2000);  
			max=0;count=0;
		}
		catch(Exception e){
			report.updateTestLog("Item Details", "Element Not Found", Status.FAIL);
		}              
	}


	/**
	 *********************************************************************** 
	 * Function enters the ASN value.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strASN
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterASN(String strASN) throws InterruptedException{ 
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ASNnumber"), strASN, "ASN");
	}

	/**
	 *********************************************************************** 
	 * Function validates ASN details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strASN, strASNStatusCode, strASNStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateASNDetails(String strASN,String strASNStatusCode,String strASNStatus){                                
		try{  
			if(!(strASN.isEmpty()&&strASNStatusCode.isEmpty()&&strASNStatus.isEmpty())){
				report.updateTestLog("ASN Details validation", "ASN Details validation successful", Status.DONE);
			}
			String actualASN=libManhattanCommonFunctions.getElementByProperty("//div[@id='dtltxt1_a']", "XPATH").getText();
			String stractualASN=actualASN.replace("ASN:\n", "");
			String actualStatusCode=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:dtltxt1_b1']", "XPATH").getText();
			String actualStatus=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:dtltxt1_b3']", "XPATH").getText();
			if((stractualASN.trim().equalsIgnoreCase(strASN)) &&((actualStatusCode.trim().equalsIgnoreCase(strASNStatusCode)))  && (actualStatus.trim().equalsIgnoreCase(strASNStatus)))
			{
				report.updateTestLog("ASN details verification", "Expected ASN : "+strASN+" Actual ASN :"+stractualASN+" Expected Status : "+strASNStatusCode+" "+strASNStatus+" Actual Status : "+actualStatusCode+" "+actualStatus, Status.PASS);
			}else
			{
				report.updateTestLog("ASN details verification", "Expected ASN : "+strASN+" Actual ASN :"+stractualASN+" Expected Status : "+strASNStatusCode+" "+strASNStatus+" Actual Status : "+actualStatusCode+" "+actualStatus, Status.FAIL);
			}
		}
		catch(Exception e){
			report.updateTestLog("ASN Details", "Element Not Found", Status.FAIL);
		}              
	}

	/**
	 *********************************************************************** 
	 * Function enter iLPN.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	striLPN
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enteriLPN(String striLPN) throws InterruptedException{ 
		//striLPN ="96215113797137";
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("iLPNnumber"), striLPN, "iLPN");
	}

	/**
	 *********************************************************************** 
	 * Function validates iLPN details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	striLPN, strQuantity, striLPNstatus, strLockCode
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateiLPNDetails(String striLPN,String strQuantity,String striLPNstatus,String strLockCode){                                
		try{  
			if(!(striLPN.isEmpty()&&strQuantity.isEmpty()&&striLPNstatus.isEmpty()&&strLockCode.isEmpty())){
				report.updateTestLog("iLPN Details validation", "iLPN Details validation successful", Status.DONE);
			}
			String actualLPN=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ot10']", "XPATH").getText();
			String actualQuantity=libManhattanCommonFunctions.getElementByProperty("(//div[@style='white-space:nowrap'])[3]", "XPATH").getText();
			String stractualQTY=actualQuantity.replace("Qty: ", "");
			String actualiLPNstatus=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:statusdesc']", "XPATH").getText();
			System.out.println(actualiLPNstatus);
			String stractualiLPNstatus=actualiLPNstatus.replace(" Lk:", "");
			System.out.println(stractualiLPNstatus);
			String actualLockCode=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ot23']", "XPATH").getText();
			if((actualLPN.trim().equalsIgnoreCase(striLPN)) &&((stractualQTY.trim().equalsIgnoreCase(strQuantity)))  && (stractualiLPNstatus.trim().equalsIgnoreCase(striLPNstatus)) && (actualLockCode.trim().equalsIgnoreCase(strLockCode)))                     
			{
				report.updateTestLog("iLPN details verification", "Expected iLPN : "+striLPN+" Actual iLPN :"+actualLPN+" Expected Quantity : "+strQuantity+" Actual Quantity : "+stractualQTY+" Expected Status : "+striLPNstatus+" Actual Status : "+stractualiLPNstatus+" Expected Lock Code : "+strLockCode+" Actual Lock Code : "+actualLockCode, Status.PASS);
			}else
			{
				report.updateTestLog("iLPN details verification", "Expected iLPN : "+striLPN+" Actual iLPN :"+actualLPN+" Expected Quantity : "+strQuantity+" Actual Quantity : "+stractualQTY+" Expected Status : "+striLPNstatus+" Actual Status : "+stractualiLPNstatus+" Expected Lock Code : "+strLockCode+" Actual Lock Code : "+actualLockCode, Status.FAIL);
			}
		}
		catch(Exception e){
			report.updateTestLog("iLPN Details", "Element Not Found", Status.FAIL);
		}              

	}
	/**
	 *********************************************************************** 
	 * Function to enter destination location for yard move.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strDestLoc
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterDestinationLocation(String strDestLoc) throws InterruptedException{

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DestLoc"), strDestLoc, "Destination Slot Location");                   

	}
	/**
	 *********************************************************************** 
	 * Function to enter choice for task list
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strDestLoc
	 * @version 1.0
	 ***********************************************************************
	 */

	public void enterTaskchoice(String strTaskchoice) throws InterruptedException{ 

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("TaskChoice"), strTaskchoice, "Task Choice");

	}

	/**
	 *********************************************************************** 
	 * Function enters LPN number for putaway Bulk.
	 * @return    Nothing is returned as of now 
	 * @Author    Nitika
	 * @param     strLPNNum
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterLPNNumForBulk(String strLPNNum) throws InterruptedException{ 

		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num_Bulk"), strLPNNum, "LPN Number for Putaway Bulk");

	}

	/**
	 *********************************************************************** 
	 * Function enters the reserve location for Putaway Bulk and clicks on enter button.
	 * @return    Nothing is returned as of now 
	 * @Author    Nitika
	 * @param     None
	 * @version 1.0
	 ***********************************************************************
	 */
	public String  enterRLocForBulk() throws InterruptedException{ 
		String actualRLoc1= libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:ifNotSuggestedMode']","XPATH").getText();
		String actualRLoc=actualRLoc1.replace("Rloc:", "");
		String actualRLoc2=actualRLoc.replace("-", "");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("R_Loc_Bulk"), actualRLoc2.trim(), "Reserve Location");
		return actualRLoc;
	}
	
	
	/**
	 *********************************************************************** 
	 * Function enters the reserve location for Putaway Bulk and clicks on enter button.
	 * @return    Nothing is returned as of now 
	 * @Author    Nitika
	 * @param     None
	 * @version 1.0
	 ***********************************************************************
	 */
	public String  enterRLocForBulk1() throws InterruptedException{ 
		String actualRLoc1= libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:ifNotSuggestedMode']","XPATH").getText();
		String actualRLoc=actualRLoc1.replace("Rloc:", "");
		String actualRLoc2=actualRLoc.replace("-", "");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("R_Loc_Bulk"), actualRLoc2.trim(), "Reserve Location");
		return actualRLoc2;
	}



	/**
	 *********************************************************************** 
	 * Function clicks on enter button.
	 * @return    Nothing is returned as of now 
	 * @Author    Nitika
	 * @param     None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnEnterButton() throws InterruptedException {

		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnter"), "Enter Button");

	}

	/**
	 *********************************************************************** 
	 * Function enters the pallet.
	 * @return    Nothing is returned as of now 
	 * @Author    Yagna Priya D
	 * @param     strPallet
	 * @version   1.0
	 ***********************************************************************
	 */
	public void enterPallet(String strPallet) throws InterruptedException {
		libManhattanCommonFunctions.waitForElementClickable("//input[@id='barcode272DirL']", 8000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Pallet"), strPallet, "Pallet");
		clickAcceptAndProceed();

	}

	/**
	 *********************************************************************** 
	 * Function clicks on Accept/Proceed Button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickAcceptAndProceed() {
		if (libManhattanCommonFunctions.verifyElementPresent("//span[@value='Accpt/Proceed']", "XPATH")){
			libManhattanCommonFunctions.waitForElementClickable("//span[@value='Accpt/Proceed']", 25000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnAccptAndProceed"), "Accept/Proceed Button");
		}
	}
	
	/**
     *********************************************************************** 
     * Function verifies Error Message.
     * @return      Nothing is returned as of now 
     * @Author      Rahman
     * @param       None
     * @version 1.0
     ***********************************************************************
     */
    public void verifyErrorMsg(String ErrMsg){                                
        //String ErrMsg = "iLPN is allocated or partially alloc!";                           
        try{                            
                String strActualErrMsg = libManhattanCommonFunctions.getElementByProperty("//div[@class='error']", "XPATH").getText();
                if(strActualErrMsg.trim().contains(ErrMsg))
                {
                        report.updateTestLog("RF Menu Cycle Counts details verification", "Error Msg : "+strActualErrMsg+" : generated", Status.PASS);
                }else
                {
                        report.updateTestLog("RF Menu Cycle Counts details verification", "Error Msg : "+strActualErrMsg+" : generated", Status.FAIL);
                }
        }
        catch(Exception e){
                report.updateTestLog("Element", "Element Not Found", Status.FAIL);
        }              
    }

	/**
	 *********************************************************************** 
	 * Function displays the error msg.
	 * @return 	Nothing is returned as of now 
	 * @Author Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void VerifyErrormsg()
	{
		if (libManhattanCommonFunctions.verifyElementPresent("//span[@value='Accpt/Proceed']", "XPATH")) {
			report.updateTestLog("Error Msg verification","Error Msg verified successfully", Status.PASS);
		} else {
			report.updateTestLog("Error Msg verification","Error Msg verification failed ", Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function enters iLPN Number for FR Disposition.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterFRiLPN(String striLPNNumber) {
		libManhattanCommonFunctions.waitForElementClickable("(//input[starts-with(@id,'brcd')])[2]", 8000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("FR_iLPN"), striLPNNumber, "LPN Number");
	}

	/**
	 *********************************************************************** 
	 * Function selects the sequence.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void selectSeq(String strSeq) {
		libManhattanCommonFunctions.waitForElementClickable("//input[@id='dataForm:barcode217']", 25000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("SelectSeq"), strSeq, "SelectSeq");
	}

	/**
	 *********************************************************************** 
	 * Function enters the Reserve Location for cycle count.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param strRLoc
	 * @version 1.0
	 *********************************************************************** 
	 */
	public void enterResLoc(String strRLoc) throws InterruptedException {
		libManhattanCommonFunctions.clearAndUpdateAnyElement(
				getPageElement("ReserveLoc"), strRLoc, "Reserve Location");
	}

	/**
	 *********************************************************************** 
	 * Function enters the Reserve Location for cycle count.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param strALoc
	 * @version 1.0
	 *********************************************************************** 
	 */
	public void enterActiveLoc(String strALoc) throws InterruptedException {
		libManhattanCommonFunctions.clearAndUpdateAnyElement(
				getPageElement("ActiveLoc"), strALoc, "Active Location");
	}

	/**
	 *********************************************************************** 
	 * Function enters the Number of LPNs for cycle count.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param strnumberofLPNs
	 * @version 1.0
	 *********************************************************************** 
	 */
	public void enterNumberofLPNs(String strnumberofLPNs)
			throws InterruptedException {
		libManhattanCommonFunctions.clearAndUpdateAnyElement(
				getPageElement("NumberofLPNs"), strnumberofLPNs,
				"Number of LPNs");
	}

	/**
	 *********************************************************************** 
	 * Function clicks on enter button.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param None
	 * @version 1.0
	 *********************************************************************** 
	 */
	public void clickOnAcceptProceed() throws InterruptedException {
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(
				getPageElement("btnAcceptProceed"), "Accept/Proceed Button");

	}

	/**
	 *********************************************************************** 
	 * Function enters the LPNs for cycle count.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param strnumberofLPNs
	 *            , strLPNNum
	 * @version 1.0
	 * @throws AWTException
	 *********************************************************************** 
	 */
	public void enterLPNs(String strnumberofLPNs, String strLPNNum)
			throws InterruptedException, AWTException {
		int y = Integer.parseInt(strnumberofLPNs);
		if (strLPNNum.contains(";")) {
			Thread.sleep(3000);
			String[] strLPNs = strLPNNum.split(";");

			for (int intLoop = 0; intLoop < y; intLoop++) 
			{
				enterLPNNumtobemodified(strLPNs[intLoop]);
				Thread.sleep(1000);
				pressEnter();
				Thread.sleep(2000);               
			}
			PerformActions();

		} 
		else if (strLPNNum.contains(""))
		{
			Thread.sleep(1000);
			clickOnAcceptProceed();
			Thread.sleep(2000);
		}

		else {
			enterLPNNumtobemodified(strLPNNum);
			Thread.sleep(1000);
			pressEnter();
			Thread.sleep(2000);
			PerformActions();
		}             
	}

	/**
	 *********************************************************************** 
	 * Function enters the LPNs for cycle count.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param strnumberofLPNs , strLPNNum, straddedLPNs
	 * @version 1.0
	 * @throws AWTException
	 *********************************************************************** 
	 */
	public void enternewLPNs(String strnumberofLPNs, String strLPNNum, String straddedLPNs)
			throws InterruptedException, AWTException {
		int y = Integer.parseInt(strnumberofLPNs);

		if (strLPNNum.contains(";")) {
			Thread.sleep(3000);
			String[] strLPNs = strLPNNum.split(";");
			String[] strnewLPNs = straddedLPNs.split(";");

			for (int intLoop = 0; intLoop < (y-(strnewLPNs.length)); intLoop++) 
			{
				enterLPNNumtobemodified(strLPNs[intLoop]);
				Thread.sleep(1000);
				pressEnter();
				Thread.sleep(2000);               
			}
			for (int intLoop = (y-(strnewLPNs.length)); intLoop < y; intLoop++) 
			{
				enterLPNNumtobemodified(strLPNs[intLoop]);
				Thread.sleep(1000);
				pressEnter();
				Thread.sleep(2000);        
				clickOnAcceptProceed();
				Thread.sleep(2000);  
			}

		} else {
			enterLPNNumtobemodified(strLPNNum);
			Thread.sleep(1000);
			pressEnter();
			Thread.sleep(2000);
			clickOnAcceptProceed();
			Thread.sleep(2000);  
		}
	}
	/**
	 *********************************************************************** 
	 * Function clicks on Next/End button.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param None
	 * @version 1.0
	 *********************************************************************** 
	 */
	public void clickOnNextEnd() throws InterruptedException {

		libManhattanCommonFunctions.clickAnyElement(
				getPageElement("btnNextEnd"), "Next/End Location Button");

	}
	/**
	 *********************************************************************** 
	 * Function enters the Itembarcode.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param strItemBarcode
	 * @version 1.0
	 *********************************************************************** 
	 */
	public void enterItemBarcode(String strItemBarcode) throws InterruptedException {
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ItemBarcode"), strItemBarcode, "Item Barcode");
	}
	/**
	 *********************************************************************** 
	 * Function clicks on Options Icon, Next/End and Accept/Proceed Button.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param None
	 * @version 1.0
	 *********************************************************************** 
	 */
	public void PerformActions() throws InterruptedException {

		clickOptionsIcon();
		Thread.sleep(1000);
		clickOnNextEnd();
		Thread.sleep(1000);
		clickOnAcceptProceed();
		Thread.sleep(1000);

	}
	/**
	 *********************************************************************** 
	 * Function clicks on enter Task button.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param None
	 * @version 1.0
	 *********************************************************************** 
	 */
	public void clickOnEnterTask() throws InterruptedException {

		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnterTask"), "Enter Task Button");

	}
	/**
	 *********************************************************************** 
	 * Function enters the Task ID.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param strTaskID
	 * @version 1.0
	 *********************************************************************** 
	 */
	public void enterTaskID(String strTaskID) throws InterruptedException {
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("TaskID"), strTaskID, "Task ID");              
	}
	/**
	 *********************************************************************** 
	 * Function enters the Location from the page.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param none
	 * @version 1.0
	 *********************************************************************** 
	 */
	public String enterLocation() throws InterruptedException {
		String actualLocation = libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:locnViewMdDiv00A1']","XPATH").getText();
		String strLoc = actualLocation.replace("Aloc: ", "");
		String stractualLocation = strLoc.replace("-", "");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Location"), stractualLocation.trim(), "Location");
		return strLoc;
	}

	/**
	 *********************************************************************** 
	 * Function enters the oLPN Number.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Yagna Priya D
	 * @param strLPNNumber
	 * @version 1.0
	 *********************************************************************** 
	 */
	public void enteroLPNNumber(String strLPNNumber){
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("oLPNNumber"), strLPNNumber, "oLPN Number");              
	}

	/**
	 *********************************************************************** 
	 * Function enters the task.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strTaskID
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterTask(String strTaskID) throws Exception
	{
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnterTask"), "Enter Task");	
		Thread.sleep(4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Task_Id"), strTaskID, "Task Id");	
		Thread.sleep(2000);
		clickOnEnterButton();

	}

	/**
	 *********************************************************************** 
	 * Function enters alternate LPN number suggested by the system, Quantity to be moved and the pallet Id.
	 * @return 	item 
	 * @Author 	Nitika
	 * @param 	strQty, strPallet
	 * @version 1.0
	 ***********************************************************************
	 */
	public String enterAltLPNTask(String strQty, String strPallet) throws Exception
	{
		Thread.sleep(2000);
		clickOnAlternate();
		Thread.sleep(4000);
		String striLPN = driver.findElement(By.xpath("//div[@id='labelCntr9']")).getText();
		String LPN = striLPN.replaceAll("\\D+",""); 
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num_Lock"), LPN, "iLPN_Num");
		pressEnter();
		Thread.sleep(8000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("itemQty"), strQty , "Item Quantity");
		Thread.sleep(2000);
		pressEnter();
		Thread.sleep(8000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), strPallet, "Pallet Id");
		clickOnEnterButton();
		Thread.sleep(4000);
		clickAcceptAndProceed();
		Thread.sleep(2000);
		return LPN;
	}

	/**
	 *********************************************************************** 
	 * Function clicks on alternate button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnAlternate() throws InterruptedException {
		if (libManhattanCommonFunctions.verifyElementPresent("//span[@value='Alternate']", "XPATH")){
			libManhattanCommonFunctions.waitForElementClickable("//span[@value='Alternate']", 25000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAlternate"), "Alternate Button");
		}

	}

	/**
	 *********************************************************************** 
	 * Function clicks on accept button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnAcceptButton() throws InterruptedException {

		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAccept"), "Accept Button");
		Thread.sleep(2000);

	}

	/**
	 *********************************************************************** 
	 * Function enters the LPN number suggested by the system, Quantity to be moved and the pallet Id.
	 * @return 	item 
	 * @Author 	Nitika
	 * @param 	strQty, strPallet
	 * @version 1.0  
	 ***********************************************************************
	 */
	public String enterLPNTask(String strQty, String strPallet) throws Exception
	{
		Thread.sleep(4000);
		String item = libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:id_333']", "XPATH").getText();
		String[] strarr = item.split(":");
		item = strarr[1];
		String striLPN = driver.findElement(By.xpath("//div[@id='labelCntr9']")).getText();
		String LPN = striLPN.replaceAll("\\D+","");
		Thread.sleep(8000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), LPN, "iLPN_Num");
		Thread.sleep(4000);
		pressEnter();
		Thread.sleep(8000);
		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='input1qtyQty51']", "XPATH"))
		{
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("itemQty"), strQty , "Item Quantity");
			Thread.sleep(2000);
			pressEnter();
			Thread.sleep(8000);
		}
		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:locationempty']", "XPATH"))
		{
			Thread.sleep(3000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LocationEmpty"), "Y", "Location Empty Y/N ?");
			Thread.sleep(10000);
		}
		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='barcode2']", "XPATH"))
		{
			Thread.sleep(3000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), strPallet, "Pallet Id");
			clickOnEnterButton();
			Thread.sleep(4000);
		}
		clickAcceptAndProceed();
		Thread.sleep(2000);
		return item;
	}
	
	/**
	 *********************************************************************** 
	 * Function enters the LPN number suggested by the system, Quantity to be moved and the pallet Id.
	 * @return 	item 
	 * @Author 	Nitika
	 * @param 	strQty, strPallet
	 * @version 1.0  
	 ***********************************************************************
	 */
	public String ValidateErrorInLPNTask(String strQty, String strPallet, String strIncorrectLPN) throws Exception
	{
		Thread.sleep(4000);
		String item = libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:id_333']", "XPATH").getText();
		String[] strarr = item.split(":");
		item = strarr[1];
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), strIncorrectLPN, "iLPN_Num");
		Thread.sleep(4000);
		pressEnter();
		Thread.sleep(4000);
		VerifyErrormsg();
		clickAcceptAndProceed();
		Thread.sleep(2000);
		String striLPN = driver.findElement(By.xpath("//div[@id='labelCntr9']")).getText();
		String LPN = striLPN.replaceAll("\\D+","");
		Thread.sleep(8000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), LPN, "iLPN_Num");
		Thread.sleep(4000);
		pressEnter();
		Thread.sleep(8000);
		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='input1qtyQty51']", "XPATH"))
		{
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("itemQty"), strQty , "Item Quantity");
			Thread.sleep(2000);
			pressEnter();
			Thread.sleep(8000);
		}
		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:locationempty']", "XPATH"))
		{
			Thread.sleep(3000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LocationEmpty"), "Y", "Location Empty Y/N ?");
			Thread.sleep(10000);
		}
		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='barcode2']", "XPATH"))
		{
			Thread.sleep(3000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), strPallet, "Pallet Id");
			clickOnEnterButton();
			Thread.sleep(4000);
		}
		clickAcceptAndProceed();
		Thread.sleep(2000);
		return item;
	}
	
	
	/**  
	 *********************************************************************** 
	 * Function enters the LPN number suggested by the system, Quantity to be moved and the pallet Id.
	 * @return 	item 
	 * @Author 	Nitika
	 * @param 	strQty, strPallet
	 * @version 1.0  
	 ***********************************************************************
	 */
	@SuppressWarnings("null")
	public String enterAltiLPNTask(String strQty, String strPallet) throws Exception
	{
		Thread.sleep(4000);
//		String striLPN = driver.findElement(By.xpath("//div[@id='labelCntr9']")).getText();
//		String iLPN = striLPN.replaceAll("\\D+","");
//		//strLPN[0] = LPN;
//		Thread.sleep(4000);
//		clickOptionsIcon();
//		Thread.sleep(4000);
		if(libManhattanCommonFunctions.verifyElementPresent("//span[@value='Alt/Lock']", "XPATH"))
		{
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAlt"), "Alternate iLPN");
		Thread.sleep(8000);
		}
		String striLPN = driver.findElement(By.xpath("//div[@id='labelCntr9']")).getText();
		String LPN = striLPN.replaceAll("\\D+","");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num_Lock"), LPN, "iLPN_Num");
		Thread.sleep(4000);
		pressEnter();
		Thread.sleep(4000);
		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='input1qtyQty51']", "XPATH"))
		{
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("itemQty"), strQty , "Item Quantity");
			Thread.sleep(2000);
			pressEnter();
			Thread.sleep(4000);
		}
		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:locationempty']", "XPATH"))
		{
			Thread.sleep(3000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LocationEmpty"), "Y", "Location Empty Y/N ?");
			Thread.sleep(10000);
		}
		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='barcode2']", "XPATH"))
		{
			Thread.sleep(3000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), strPallet, "Pallet Id");
			clickOnEnterButton();
			Thread.sleep(4000);
		}
		clickAcceptAndProceed();
		Thread.sleep(2000);
		return LPN;
	}
	
	/**
	 *********************************************************************** 
	 * Function enters the LPN number suggested by the system, Quantity to be moved and the pallet Id.
	 * @return 	item 
	 * @Author 	Nitika
	 * @param 	strQty, strPallet
	 * @version 1.0  
	 ***********************************************************************
	 */
	@SuppressWarnings("null")
	public String enterShortLPNTask(String strQty, String strPallet) throws Exception
	{
		Thread.sleep(4000);
		String striLPN = driver.findElement(By.xpath("//div[@id='labelCntr9']")).getText();
		String iLPN = striLPN.replaceAll("\\D+","");
		//strLPN[0] = LPN;
		Thread.sleep(4000);
		clickOptionsIcon();
		Thread.sleep(4000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnShort"), "Short iLPN");
		Thread.sleep(4000);
		clickAcceptAndProceed();
		Thread.sleep(2000);
		return iLPN;
	}

	/**
	 *********************************************************************** 
	 * Function chooses a task from the list.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strchoice
	 * @version 1.0
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void ChooseTask(String strchoice) throws InterruptedException, AWTException {

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ChooseTaskChoice"), strchoice, "Task Choice");
		Thread.sleep(2000);
		pressEnter();
		Thread.sleep(4000);

	}

	/**
	 *********************************************************************** 
	 * Function clicks on Task Selection button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnTaskSel() throws InterruptedException {

		libManhattanCommonFunctions.clickAnyElement(getPageElement("Task_Sel"), "Task Selection Button");

	}

	/**
	 *********************************************************************** 
	 * Function enters the quantity to be moved.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strMoveQty
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterQtyToBeMoved(String strMoveQty) throws InterruptedException{ 

		Thread.sleep(4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Move_Qty"), strMoveQty, "Quantity to be moved");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnter"),"Enter Button");

	}

	/**
	 *********************************************************************** 
	 * Function clicks on substitute button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickOnSubstitute() throws InterruptedException {

		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSubstitute"), "Substitute Button");

	}

	/**
	 *********************************************************************** 
	 * Function enters the reserve location.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strRLoc
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterRLocForPP(String strRLoc) throws InterruptedException{ 

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("R_Loc_PP"), strRLoc, "Reserve Location");
		Thread.sleep(2000);
	}

	/**
	 *********************************************************************** 
	 * Function enters the details to close a trailer.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strShip_Id
	 * @version 1.0
	 ***********************************************************************
	 */
	public void closeTrailer(String strShip_Id) { 
		try{
			String strShip_Seal = "4568152941";
			Thread.sleep(4000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), strShip_Id, "Shipment Id");
			Thread.sleep(4000);
			pressEnter();
			Thread.sleep(4000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), strShip_Seal, "Shipment Seal");
			pressEnter();
			Thread.sleep(4000);
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		} 
	}

	/**
	 *********************************************************************** 
	 * Function enters oLPN for oLPN inquiry.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strLPNNum
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enteroLPNForInquiry(String stroLPN)
	{
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("oLPN_Num"), stroLPN, "oLPN Number");	
	}

	/**
	 *********************************************************************** 
	 * Function validates te carton status for oLPN inquiry.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateStatusForLPNinquiry(String strStatus){
		try{
			String actualStatus =libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:statusdesc']", "XPATH").getText();
			String[] status = actualStatus.split(" ");
			actualStatus = status[0];
			if(actualStatus.trim().equals(strStatus))
			{
				report.updateTestLog("oLPN inquiry verification", "Actual Status: "+strStatus, Status.PASS);
			}else
			{
				report.updateTestLog("oLPN inquiry verification","Actual Status : "+actualStatus +" Expected Status : "+strStatus, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}   
	}

	/**
	 *********************************************************************** 
	 * Function enters the shipment id.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strShipmentId
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterShipmentId(String strShipmentId) throws InterruptedException{ 

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Shipment_Id"), strShipmentId, "Shipment Id");
		Thread.sleep(2000);
	}

	/**
	 *********************************************************************** 
	 * Function performs CTRL+E keyboard action.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void keyCTRLE() throws InterruptedException, AWTException {
		Thread.sleep(6000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
	}

	/**
	 *********************************************************************** 
	 * Function enters the LPN number suggested by the system, Quantity to 
	 * be moved and the pallet Id.
	 * @return    item 
	 * @Author    Rahman
	 * @param     strQty, strPallet, strLocationEmpty
	 * @version 1.0
	 * @return 
	 ***********************************************************************
	 */
	public String enterDetailsForTask(String strQty,String strLocationEmpty,String strPallet) throws Exception
	{

		Thread.sleep(4000);         
		String striLPN = driver.findElement(By.xpath("//div[@id='labelCntr9']")).getText();
		String LPN = striLPN.replaceAll("\\D+",""); 
		Thread.sleep(8000); 
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("iLPN_Num"), LPN, "iLPN_Num");
		Thread.sleep(3000);  
		pressEnter();
		Thread.sleep(6000);
		if (libManhattanCommonFunctions.verifyElementPresent("//input[starts-with(@id,'input1qty')]", "XPATH"))
		{           
			Thread.sleep(3000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("New_Qty"), strQty , "Item Quantity");
			Thread.sleep(6000);
			pressEnter();
			Thread.sleep(3000);
		}
		Thread.sleep(15000);
		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:locationempty']", "XPATH"))
		{
			Thread.sleep(3000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(
					getPageElement("LocationEmpty"), strLocationEmpty, "Location Empty Y/N ?");
			Thread.sleep(8000);
		}
		//            pressEnter();
		Thread.sleep(4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), strPallet, "Pallet Id");
		Thread.sleep(4000);
		clickOnEnterButton();
		Thread.sleep(4000);
		clickOnAcceptProceed();
		Thread.sleep(2000);
		return LPN;
	}

	/**
	 *********************************************************************** 
	 * Function enters details for recieving and sorting function.
	 * @return    Nothing is returned as of now 
	 * @Author    Rahman
	 * @param     strDockDoor, strLPN, strItemNumber, strItemQty, strSeqCode
	 *                   strPalletNum
	 * @version 1.0
	 ***********************************************************************
	 */
	public void RecvandSortItems(String strDockDoor, String strLPN,  String strItemNumber,String strItemQty,String strSeqCode, String strPalletNum) throws InterruptedException, AWTException {
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtDockDoor"), strDockDoor, "Dock Door");
		Thread.sleep(3000);
		pressEnter();
		Thread.sleep(4000); 
		pressEnter();
		Thread.sleep(3000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPN, "LPN");
		pressEnter();
		Thread.sleep(3000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemBarcode"), strItemNumber, "Item Number");
		pressEnter();
		Thread.sleep(3000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemQty"), strItemQty, "Item Qty");
		pressEnter();
		Thread.sleep(12000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnLst_Sort_Zns"),"Sort Button");
		Thread.sleep(3000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("sequencecode"), strSeqCode, "Sequence code");
		pressEnter();
		Thread.sleep(3000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxPalletNbr"), strPalletNum, "Pallet Number");
		pressEnter();
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAcpt_PalletWarning"),"Pallet");
		Thread.sleep(4000);
	}

	/**
	 *********************************************************************** 
	 * Function performs CTRL+B keyboard action.
	 * @return    Nothing is returned as of now 
	 * @Author    Rahman
	 * @param     None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void keyCTRLB() throws InterruptedException, AWTException {
		Thread.sleep(4000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("txtboxLPN"),"CLick Textbox");
		Thread.sleep(4000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_B);
		robot.keyRelease(KeyEvent.VK_B);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(10000);
	}



	/**
	 *********************************************************************** 
	 * Function enters details for recieving and sorting function.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strDockDoor, strSelectASN, strSelectASN, strASNNumber, strLPN
	 * 		  	strItemBarcode, strItemQty
	 * @version 1.0
	 * @param strItemNumber 
	 ***********************************************************************
	 */
	//@SuppressWarnings("null")
	public void enterRecvandSortInputs(String strDockDoor,String strASNNumber, String strLPN, String strItemQty, String strItemNumber, String strPalletnbr, String strFacility) throws InterruptedException, AWTException {//String strDataSheetname, String strDataFieldName) throws InterruptedException, AWTException {
		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtDockDoor"), strDockDoor, "Dock Door");
		Thread.sleep(2000);
		pressEnter();
		Thread.sleep(2000);
		if(libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'Select:')]", "XPATH"))
		{
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtASNSelectValue"), "1", "Select ASN");
			Thread.sleep(2000);
			pressEnter();
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnPrevious"),"Previous Button");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
			Thread.sleep(4000);
			pressEnter();
		}
		else{
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");

			Thread.sleep(2000);
			pressEnter();

		}
		Thread.sleep(2000);
		clickAcceptAndProceed();
		//libManhattanCommonFunctions.clickAnyElement(getPageElement("btnProceedWarning"),"Override Warning");
		if (strLPN.contains(";")){
			Thread.sleep(3000);
			String[] strLPNs = strLPN.split(";");
			String[] strLPNqty = strItemQty.split(";");
			String[] strPallet = strPalletnbr.split(";");
			
			
			for(int intLoop=0;intLoop<strLPNs.length;intLoop++)
			{
				Thread.sleep(2000);
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPNs[intLoop], "LPN");
				pressEnter();
				Thread.sleep(4000);
				keyCTRLA();
				Thread.sleep(4000);
				keyCTRLA();
				Thread.sleep(6000);
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItem"), strItemNumber, "Item Number");
				pressEnter();
				Thread.sleep(4000);
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemQty"), strLPNqty[intLoop], "Item Qty");
				pressEnter();
				Thread.sleep(4000);
				clickAcceptAndProceed();
				Thread.sleep(2000);
				enterRLOC(strPallet[intLoop], strFacility);
				Thread.sleep(2000);
			}
			

		}
		else{
			Thread.sleep(1000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPN, "LPN");
			pressEnter();
			Thread.sleep(4000);
			keyCTRLA();
			Thread.sleep(4000);
			keyCTRLA();
			Thread.sleep(4000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItem"), strItemNumber, "Item Number");
			pressEnter();
			Thread.sleep(4000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemQty"),strItemQty, "Item Qty");
			pressEnter(); 
			Thread.sleep(4000);
			clickAcceptAndProceed();
			Thread.sleep(4000);
			enterRLOC(strPalletnbr, strFacility);
			Thread.sleep(2000);

		}

	}


	/**
	 *********************************************************************** 
	 * Function performs CTRLA keyboard action.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void keyCTRLA() throws InterruptedException, AWTException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}

	/**
	 *********************************************************************** 
	 * Function performs verify ASN action
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyASN(String strDockDoor,String strASNNumber, String strLPN) throws InterruptedException, AWTException {

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtDockDoor"), strDockDoor, "Dock Door");
		pressEnter();
		Thread.sleep(2000);
		if(libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'Select:')]", "XPATH"))
		{
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtASNSelectValue"), "1", "Select ASN");
			Thread.sleep(2000);
			pressEnter();
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnPrevious"),"Previous Button");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
			Thread.sleep(4000);
			pressEnter();
		}
		else{
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
			Thread.sleep(2000);
			pressEnter();
}
		Thread.sleep(2000);
		clickAcceptAndProceed();
//		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPN, "LPN");
//		pressEnter();
		Thread.sleep(4000);
		clickOptionsIcon();
		Thread.sleep(4000);
		keyCTRLZ();
		Thread.sleep(4000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnProceedverifyASN"),"Verify ASN");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnProceedvarianceWarning"),"Override ASN Variance warning");






	}


	/**
	 *********************************************************************** 
	 * Function performs CTRLZ keyboard action.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void keyCTRLZ() throws InterruptedException, AWTException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_Z);
		robot.keyRelease(KeyEvent.VK_Z);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}
	/**

	 *********************************************************************** 

	 * Function to override putaway bulk warnings

	 * @return      Nothing is returned as of now 

	 * @Author      Aishwarya

	 * @param       strRLoc

	 * @version 1.0

	 ***********************************************************************

	 */

	public void putawaywarnings() throws InterruptedException{ 

		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOverrideWarning"),"Pallet sort warning");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOverrideWarning"),"User directed putaway warning");

	}

	/**
	 *********************************************************************** 
	 * Function retrieves Sequence, Quantity and Location.
	 * @return    Nothing is returned as of now 
	 * @Author    Rahman
	 * @param     None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void RetrieveSequence(String strSeq,String strQuantity, String strLocation)
	{
		int intRowPointer=0;
		boolean blnFlagValue;
		String actualseq = "";
		String actualqty = "";
		String actualloc = "";
		if(!(strSeq.isEmpty()&&strQuantity.isEmpty()&&strLocation.isEmpty())){
			report.updateTestLog("Item Details validation", "Item Details validation successful", Status.DONE);
		}
		WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:ITEMList']"));
		List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR"));
		for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
		{              
			blnFlagValue = false;
			intRowPointer = intPointr;
			actualseq=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ITEMList:"+intRowPointer+":seq']", "XPATH").getText();
			actualqty=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ITEMList:"+intRowPointer+":Qty2']", "XPATH").getText();
			actualloc=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ITEMList:"+intRowPointer+":locn1']", "XPATH").getText();
			if(actualseq.trim().equals(strSeq) && actualqty.trim().equals(strQuantity) && actualloc.trim().equals(strLocation))
			{
				report.updateTestLog("Item details verification", "Expected Sequence : "+strSeq+" Actual Sequence : "+actualseq+" Expected Quantity : "+strQuantity+" Actual Quantity : "+actualqty+" Expected Location : "+strLocation+" Actual Location : "+actualloc, Status.PASS);
				System.out.println(strSeq+" "+actualseq+" "+strQuantity+" "+actualqty+" "+strLocation+" "+actualloc);
				blnFlagValue = true;
				break;
			}else{
				blnFlagValue = false;
				System.out.println(strSeq+" "+actualseq+" "+strQuantity+" "+actualqty+" "+strLocation+" "+actualloc);
			}
			if (blnFlagValue = false){                      
				report.updateTestLog("Item details verification", "Expected Sequence : "+strSeq+" Actual Sequence : "+actualseq+" Expected Quantity : "+strQuantity+" Actual Quantity : "+actualqty+" Expected Location : "+strLocation+" Actual Location : "+actualloc, Status.FAIL);
			}
		}
	}

	/**
	 *********************************************************************** 
	 * Function enters RLOC details for recieving and sorting function.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strDockDoor, strSelectASN, strSelectASN, strASNNumber, strLPN
	 * 		  	strItemBarcode, strItemQty
	 * @version 1.0
	 * @param strItemNumber 
	 ***********************************************************************
	 */
	public String enterRLOC(String strPalletnbr, String strFacility) throws InterruptedException, AWTException {//String strDataSheetname, String strDataFieldName) throws InterruptedException, AWTException {
		String actualRLoc1= libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:RFcontent']","XPATH").getText();
		String[] Rloc = actualRLoc1.split("\n\n");
		String[] Rloc1 = Rloc[1].split("Rloc:");
		String actualRLoc3 =Rloc1[1];
		String actualRLoc2 =Rloc1[1].replace("-", "");
		String actualRLoc=actualRLoc2.replace(" ", "");
		if(strFacility.equalsIgnoreCase("ONT"))
		{
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("R_Loc_Rec"), actualRLoc.trim(), "Reserve Location");
			Thread.sleep(2000);
			pressEnter();
			    
		}
		else
		{

			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxPalletNbr"), strPalletnbr, "Pallet Nbr");
			pressEnter();
			Thread.sleep(6000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAcpt_PalletWarning"),"Pallet ");
			Thread.sleep(4000);
			}
						
				return actualRLoc3;

	}
	/**
	 *********************************************************************** 
	 * Function enters many LPN numbers for putaway Bulk .
	 * @return    Nothing is returned as of now 
	 * @Author    Nitika
	 * @param     strLPNNum
	 * @version 1.0
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void enterLPNsForBulk(String strLPNNum) throws InterruptedException, AWTException{ 

		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
		if (strLPNNum.contains(";")){
			Thread.sleep(3000);
			String[] strLPNs = strLPNNum.split(";");
			for(int intLoop=0;intLoop<strLPNs.length;intLoop++)
			{
				Thread.sleep(4000);
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num_Bulk"), strLPNs[intLoop], "LPN Number for Putaway Bulk");
				Thread.sleep(4000);
				pressEnter();
				Thread.sleep(4000);
				enterRLocForBulk();
				pressEnter();
			}
		}
		else
		{
			Thread.sleep(4000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num_Bulk"), strLPNNum, "LPN Number for Putaway Bulk");
			pressEnter();
			Thread.sleep(4000);
			enterRLocForBulk();
			pressEnter();
		}
	}

	/**

	 *********************************************************************** 

	 * Function to override GPM warnings

	 * @return      Nothing is returned as of now 

	 * @Author      Aishwarya

	 * @param       strRLoc

	 * @version 1.0

	 ***********************************************************************

	 */

	public void gpmwarnings() throws InterruptedException{ 

		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOverrideWarning"),"Pallet sort warning");
		//		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOverrideWarning"),"User directed putaway warning");

	}

	/**
	 *********************************************************************** 
	 * Function enters details for recieving and sorting function.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strDockDoor, strSelectASN, strSelectASN, strASNNumber, strLPN
	 * 		  	strItemBarcode, strItemQty
	 * @version 1.0
	 * @param strItemNumber 
	 ***********************************************************************
	 */
	public void  RecvandSortInputs(String strDockDoor,String strASNNumber, String strLPN, String strItemQty, String strItemNumber ) throws InterruptedException, AWTException {//String strDataSheetname, String strDataFieldName) throws InterruptedException, AWTException {

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtDockDoor"), strDockDoor, "Dock Door");
		Thread.sleep(2000);
		pressEnter();
		Thread.sleep(2000);
		if(libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'Select:')]", "XPATH"))
		{
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtASNSelectValue"), "1", "Select ASN");
			Thread.sleep(2000);
			pressEnter();
			Thread.sleep(2000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnPrevious"),"Previous Button");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
			Thread.sleep(4000);
			pressEnter();
		}
		else{
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
			Thread.sleep(2000);
			pressEnter();

		}
		Thread.sleep(2000);
		clickAcceptAndProceed();
		//libManhattanCommonFunctions.clickAnyElement(getPageElement("btnProceedWarning"),"Override Warning");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPN, "LPN");
			pressEnter();
			Thread.sleep(4000);
			keyCTRLA();
			Thread.sleep(4000);
			keyCTRLA();
			Thread.sleep(4000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItem"), strItemNumber, "Item Number");
			pressEnter();
			Thread.sleep(4000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemQty"),strItemQty, "Item Qty");
			pressEnter(); 
			Thread.sleep(4000);
		


		}
	
	
	
	
	/**
	 *********************************************************************** 
	 * Function enters details for recieving and sorting function.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strDockDoor, strASNNumber,  strPO_Num, strASNNumber, strLPN
	 * 		  	strItemBarcode, strItemQty
	 * @version 1.0
	 * @param strItemNumber 
	 ***********************************************************************
	 */

	public void  BlindRecvandSortInputs(String strDockDoor,String strASNNumber,String strPO_Num, String strLPN, String strItemQty, String strItemNumber, String strPalletnbr, String strFacility) throws InterruptedException, AWTException {//String strDataSheetname, String strDataFieldName) throws InterruptedException, AWTException {
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtDockDoor"), strDockDoor, "Dock Door");
	Thread.sleep(2000);
	pressEnter();
	Thread.sleep(2000);
	if(libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'Select:')]", "XPATH"))
	{
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtASNSelectValue"), "1", "Select ASN");
		Thread.sleep(2000);
		pressEnter();
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnPrevious"),"Previous Button");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
		Thread.sleep(4000);
		pressEnter();
	}
	else{
		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");

		Thread.sleep(2000);
		pressEnter();

	}
	Thread.sleep(2000);
	clickAcceptAndProceed();
	if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:poIdinp']", "XPATH"))
	{
	libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtPO_Id"), strPO_Num, "PO_Num");
	Thread.sleep(2000);
	pressEnter();
	Thread.sleep(4000);
	pressEnter();
	Thread.sleep(2000);
	}
	//libManhattanCommonFunctions.clickAnyElement(getPageElement("btnProceedWarning"),"Override Warning");
	if (strLPN.contains(";")){
		Thread.sleep(3000);
		String[] strLPNs = strLPN.split(";");
		String[] strLPNqty = strItemQty.split(";");
		String[] strPallet = strPalletnbr.split(";");
		
		
		for(int intLoop=0;intLoop<strLPNs.length;intLoop++)
		{
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPNs[intLoop], "LPN");
			pressEnter();
			Thread.sleep(4000);
			keyCTRLA();
			Thread.sleep(4000);
			keyCTRLA();
			Thread.sleep(6000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItem"), strItemNumber, "Item Number");
			pressEnter();
			Thread.sleep(4000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemQty"), strLPNqty[intLoop], "Item Qty");
			pressEnter();
			Thread.sleep(4000);
			clickAcceptAndProceed();
			Thread.sleep(2000);
			enterRLOC(strPallet[intLoop], strFacility);
			Thread.sleep(2000);
		}
		

	}
	else{
		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPN, "LPN");
		pressEnter();
		Thread.sleep(4000);
		keyCTRLA();
		Thread.sleep(4000);
		keyCTRLA();
		Thread.sleep(4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItem"), strItemNumber, "Item Number");
		pressEnter();
		Thread.sleep(4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemQty"),strItemQty, "Item Qty");
		pressEnter(); 
		Thread.sleep(4000);
		clickAcceptAndProceed();
		enterRLOC(strPalletnbr, strFacility);
		Thread.sleep(2000);

	}

}


/**
     *********************************************************************** 
      * Function enters reason code.
     * @return    Nothing is returned as of now 
      * @Author    Rahman
     * @param     striLPNNumber,strPallet,strFacility
     * @version 1.0
     * @throws AWTException 
      ***********************************************************************
     */
     public void IPDisposition(String striLPNNumber,String strPallet,String strFacility) throws InterruptedException, AWTException{             
            if(strFacility.equals("ONT")){    
                   if (striLPNNumber.contains(";")) {
                         Thread.sleep(3000);
                         String[] strLPNs = striLPNNumber.split(";");
                   
                   for (int intLoop = 0; intLoop < strLPNs.length; intLoop++){   
                         Thread.sleep(8000);
                         enterLPNNum(strLPNs[intLoop]);
                         Thread.sleep(2000);
                         pressEnter();
                         Thread.sleep(4000);
                         ONTActionsForIP(strPallet);
                         }                                               
                   }
                   else{
                         enterLPNNum(striLPNNumber);
                         Thread.sleep(2000);
                         pressEnter();
                         Thread.sleep(4000);
                         ONTActionsForIP(strPallet);
                   }
            }
            else
            {
                   if (striLPNNumber.contains(";")) {
                         Thread.sleep(3000);
                         String[] strLPNs = striLPNNumber.split(";");
                   
                   for (int intLoop = 0; intLoop < strLPNs.length; intLoop++){                
                         enterLPNNum(strLPNs[intLoop]);
                         Thread.sleep(2000);
                         pressEnter();
                         Thread.sleep(4000);
                         ActionsForIP(striLPNNumber,strPallet);
                         }                                        
                   }
                   else{
                         enterLPNNum(striLPNNumber);
                         Thread.sleep(2000);
                         pressEnter();
                         Thread.sleep(4000);
                         ActionsForIP(striLPNNumber,strPallet);
                   }
            }
            }
     /**
     *********************************************************************** 
      * Function performs actions for IP disposition in Ontario.
     * @return    Nothing is returned as of now 
      * @Author    Rahman
     * @param     strPallet
     * @version 1.0
     * @throws AWTException 
      ***********************************************************************
     */
     public void ONTActionsForIP(String strPallet) throws InterruptedException, AWTException{ 
            Thread.sleep(4000);
            clickOptionsIcon();
            Thread.sleep(2000);
            clickOnEndScan();
            Thread.sleep(2000);                      
            enterPallet(strPallet);
            Thread.sleep(8000);
            pressEnter();
            Thread.sleep(8000);        
            }             
/**
*********************************************************************** 
* Function performs actions IP disposition.
* @return    Nothing is returned as of now 
* @Author    Rahman
* @param     strPallet
* @version 1.0
* @throws AWTException 
***********************************************************************
*/
public void ActionsForIP(String striLPNNumber,String strPallet) throws InterruptedException, AWTException{ 
     Thread.sleep(4000);
     clickOptionsIcon();
     clickOnEndScan();
     clickAcceptAndProceed();
     Thread.sleep(8000);
     enterFRiLPN(striLPNNumber);
     Thread.sleep(8000);
     pressEnter();
     enterPallet(strPallet);
     Thread.sleep(8000);
     pressEnter();
     Thread.sleep(8000);
     clickAcceptAndProceed();
     Thread.sleep(8000);  
     }
/**
*********************************************************************** 
* Function enters reason code.
* @return    Nothing is returned as of now 
* @Author    Rahman
* @param     striLPNNumber,strPallet,strFacility
* @version 1.0
* @throws AWTException 
***********************************************************************
*/
public void FRDisposition(String striLPNNumber,String strPallet,String strFacility) throws InterruptedException, AWTException{             
     if(strFacility.equals("ONT")){    
            if (striLPNNumber.contains(";")) {
                   Thread.sleep(3000);
                   String[] strLPNs = striLPNNumber.split(";");
            
            for (int intLoop = 0; intLoop < strLPNs.length; intLoop++){   
                   Thread.sleep(8000);
                   enterLPNNum(strLPNs[intLoop]);                  
                   Thread.sleep(3000);
                   pressEnter();
                   Thread.sleep(4000);
                   Thread.sleep(15000);
                   enterPallet(strPallet);
                   Thread.sleep(8000);
                   pressEnter();
                   Thread.sleep(3000);
                   }                                               
            }
            else{
                   enterLPNNum(striLPNNumber);
                   Thread.sleep(3000);
                   pressEnter();
                   Thread.sleep(4000);
                   Thread.sleep(15000);
                   enterPallet(strPallet);
                   Thread.sleep(8000);
                   pressEnter();
                   Thread.sleep(3000);
            }
     }
     else
     {
            if (striLPNNumber.contains(";")) {
                   Thread.sleep(3000);
                   String[] strLPNs = striLPNNumber.split(";");
            
            for (int intLoop = 0; intLoop < strLPNs.length; intLoop++){   
                   Thread.sleep(8000);
                   enterLPNNum(strLPNs[intLoop]);
                   Thread.sleep(3000);
                   pressEnter();
                   Thread.sleep(4000);
                   Thread.sleep(15000);
                   clickAcceptAndProceed();
                   Thread.sleep(3000);
                   enterFRiLPN(striLPNNumber);
                   Thread.sleep(3000);
                   pressEnter();
                   Thread.sleep(20000);
                   enterPallet(strPallet);
                   Thread.sleep(8000);
                   pressEnter();
                   Thread.sleep(3000);
                   clickAcceptAndProceed();
                   Thread.sleep(3000);
                   }                                        
            }
            else{
                   enterLPNNum(striLPNNumber);
                   Thread.sleep(3000);
                   pressEnter();
                   Thread.sleep(4000);
                   Thread.sleep(15000);
                   clickAcceptAndProceed();
                   Thread.sleep(3000);
                   enterFRiLPN(striLPNNumber);
                   Thread.sleep(3000);
                   pressEnter();
                   Thread.sleep(20000);
                   enterPallet(strPallet);
                   Thread.sleep(8000);
                   pressEnter();
                   Thread.sleep(3000);
                   clickAcceptAndProceed();
                   Thread.sleep(3000);
            }
     }
     }

/**
 *********************************************************************** 
  * Function performs tasking functions
 * @return    item 
  * @Author    Rahman
 * @param     strQty, strPallet
 * @version 1.0
 ***********************************************************************
 */    
 public String performTasking(String strTaskID,String strQty, String strPallet) throws Exception
 {
        driver.switchTo().defaultContent();
        List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
        driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
//      libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnterTask"), "Enter Task");       
//      Thread.sleep(4000);
        libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Task_Id"), strTaskID, "Task Id");   
        Thread.sleep(2000);
        clickOnEnterButton();
        Thread.sleep(4000);
        clickAcceptAndProceed();
        String item = libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:id_333']", "XPATH").getText();
        String[] strarr = item.split(":");
        item = strarr[1];
        String striLPN = driver.findElement(By.xpath("//div[@id='labelCntr9']")).getText();
        String LPN = striLPN.replaceAll("\\D+","");
        Thread.sleep(6000);
        libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num_Lock"), LPN, "iLPN_Num");
        Thread.sleep(3000);
        pressEnter();
        Thread.sleep(6000);
        if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='input1qtyQty51']", "XPATH"))
        {
               Thread.sleep(2000);
               libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("itemQty"), strQty , "Item Quantity");
               Thread.sleep(2000);
               pressEnter();
               Thread.sleep(8000);
        }
        if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:locationempty']", "XPATH"))
        {
               Thread.sleep(3000);
               libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LocationEmpty"), "Y", "Location Empty Y/N ?");
               Thread.sleep(10000);
        }
        if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='barcode2']", "XPATH"))
        {
               Thread.sleep(3000);
               libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num"), strPallet, "Pallet Id");
               clickOnEnterButton();
               Thread.sleep(4000);
        }//input[@id='confirmlocation_Input']
        Thread.sleep(3000);
        if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='confirmlocation_Input']", "XPATH"))
        {
               Thread.sleep(3000);
               libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Res_Loc_SingleByPass"), strPallet, "Single By Pass Reserve Location");
               clickOnEnterButton();
               Thread.sleep(4000);
        }
        clickAcceptAndProceed();
        Thread.sleep(2000);            
        return item;
 }

 
 /**
  *********************************************************************** 
   * Function enters the LPN number suggested by the system
  * @return    item 
   * @Author    Rahman
  * @version 1.0
  * @return 
   ***********************************************************************
  */    
  public void loadTrailerLTL(String strShipment,String strDockDoor,String stroLPN) throws Exception
  {//input[@id='barcode20']
         if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='barcode20']", "XPATH"))
         {
                Thread.sleep(2000);
                libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Load_LTL_Shipment"), strShipment, "Shipment");
                Thread.sleep(3000);
                pressEnter();
//              Thread.sleep(3000);        
         }             
         Thread.sleep(3000);
         libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("oLPN_Num"), strDockDoor, "Dock Door");
         Thread.sleep(3000);  
         pressEnter();
         Thread.sleep(3000);
         enterLPNNum(stroLPN);
         if(libManhattanCommonFunctions.verifyElementPresent("//div[@class='error']", "XPATH"))
         {
                report.updateTestLog("Error Msg verification","Error Msg verified successfully", Status.PASS);
         }
         clickAcceptAndProceed();
         Thread.sleep(3000);
//       clickOnExit();              
//       clickAcceptAndProceed();                       
  }
  
  
  /**
   *********************************************************************** 
    * Function enters details for recieving and sorting function.
   * @return    Nothing is returned as of now 
    * @Author    Rahman
   * @param     strDockDoor, strSelectASN, strSelectASN, strASNNumber, strLPN
   *                   strItemBarcode, strItemQty
   * @version 1.0
   * @param strItemNumber 
    ***********************************************************************
   */
   public void  ReceiveMultipleiLPNs(String strDockDoor,String strASNNumber, String strLPN, String strItemQty, String strItemNumber) throws InterruptedException, AWTException {//String strDataSheetname, String strDataFieldName) throws InterruptedException, AWTException {
          
          libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtDockDoor"), strDockDoor, "Dock Door");
          Thread.sleep(4000);
          pressEnter();
          Thread.sleep(2000);
          if(libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'Select:')]", "XPATH"))
          {
                 libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtASNSelectValue"), "1", "Select ASN");
                 Thread.sleep(2000);
                 pressEnter();
                 libManhattanCommonFunctions.clickAnyElement(getPageElement("btnPrevious"),"Previous Button");
                 Thread.sleep(2000);
                 libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
                 Thread.sleep(4000);
                 pressEnter();
          }
          else{ 
                 Thread.sleep(4000);
                 libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
                 Thread.sleep(2000);
                 pressEnter();

          }
          Thread.sleep(3000);
          clickAcceptAndProceed();
          String[] strLPNs = null;
          if (strLPN.contains(";")){
//        Thread.sleep(3000);
        strLPNs = strLPN.split(";");
          }
          
        for(int intLoop=0;intLoop<strLPNs.length;intLoop++)            
          {
          libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPNs[intLoop], "LPN");
          Thread.sleep(2000);
          pressEnter();
          Thread.sleep(3000);
          keyCTRLA();
          Thread.sleep(3000);
          keyCTRLA();
          Thread.sleep(3000);
          libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItem"), strItemNumber, "Item Number");
          Thread.sleep(2000);
          pressEnter();
          Thread.sleep(3000);
          libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemQty"),strItemQty, "Item Qty");
          Thread.sleep(2000);
          pressEnter(); 
          Thread.sleep(4000);
          String actualResLoc = "";
          if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='locn2DirL_Input']", "XPATH"))
          {
                 String actualRLoc1= libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:RFcontent']","XPATH").getText();
                 String[] Rloc = actualRLoc1.split("\n\n");
                 String[] Rloc1 = Rloc[1].split("Rloc:");
                 actualResLoc=Rloc1[1].trim();
                 String actualRLoc2 =actualResLoc.replace("-", "");
                 String actualRLoc=actualRLoc2.replace(" ", "");        
                 Thread.sleep(3000);
                 libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("R_Loc_Rec"), actualRLoc.trim(), "Reserve Location");
                 Thread.sleep(2000);
                 pressEnter();        
                 Thread.sleep(3000);                      
          }
          }
   }
   
   

   /**
    *********************************************************************** 
     * Function enters details for recieving and sorting function.
    * @return    Nothing is returned as of now 
     * @Author    Nitika
    * @param     strDockDoor, strSelectASN, strSelectASN, strASNNumber, strLPN
    *                   strItemBarcode, strItemQty
    * @version 1.0
    * @param strItemNumber 
     ***********************************************************************
    */
    public void  RecMultLPNs(String strDockDoor,String strASNNumber, String strLPN, String strItemQty, String strItemNumber) throws InterruptedException, AWTException {//String strDataSheetname, String strDataFieldName) throws InterruptedException, AWTException {
           
    	libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtDockDoor"), strDockDoor, "Dock Door");
    	Thread.sleep(2000);
    	pressEnter();
    	Thread.sleep(2000);
    	libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
    	Thread.sleep(2000);
    	pressEnter();
    	//Thread.sleep(2000);
    	clickAcceptAndProceed();
    	String[] strLPNs = null;
    	if (strLPN.contains(";")){
    		//         Thread.sleep(3000);
    		strLPNs = strLPN.split(";");
    	}

    	for(int intLoop=0;intLoop<strLPNs.length;
    			intLoop++)            
    	{
    		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPNs[intLoop], "LPN");
    		Thread.sleep(1000);
    		pressEnter();
    		Thread.sleep(2000);
    		//clickAcceptAndProceed();
    		keyCTRLA();
    		Thread.sleep(2000);
    		keyCTRLA();
    		Thread.sleep(2000);
    		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItem"), strItemNumber, "Item Number");
    		Thread.sleep(1000);
    		pressEnter();
    		Thread.sleep(2000);
    		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemQty"),strItemQty, "Item Qty");
    		Thread.sleep(1000);
    		pressEnter(); 
    		Thread.sleep(2000);
    		String actualResLoc = "";
    		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='locn2DirL_Input']", "XPATH"))
    		{
    			String actualRLoc1= libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:RFcontent']","XPATH").getText();
    			String[] Rloc = actualRLoc1.split("\n\n");
    			String[] Rloc1 = Rloc[1].split("Rloc:");
    			actualResLoc=Rloc1[1].trim();
    			String actualRLoc2 =actualResLoc.replace("-", "");
    			String actualRLoc=actualRLoc2.replace(" ", "");        
    			Thread.sleep(2000);
    			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("R_Loc_Rec"), actualRLoc.trim(), "Reserve Location");
    			Thread.sleep(2000);
    			pressEnter();        
    			Thread.sleep(1000);                      
    		}
    	}
    }

    
    /**
     *********************************************************************** 
      * Function performs tasking functions
     * @return    item 
      * @Author    Nitika
     * @param     strQty, strPallet
     * @version 1.0
     ***********************************************************************
     */    
     public String performTaskingforReplnishment(String strTaskId,String strPallet, String Location) throws Exception
     {		
    	 	String item="";
            driver.switchTo().defaultContent();
            List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
            driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
    	 	enterTask(strTaskId);  
            Thread.sleep(2000);
            clickAcceptAndProceed();
            if(libManhattanCommonFunctions.verifyElementPresent("//div[@id='dataForm:divFullPlt1']", "XPATH"))
            {
            strPallet = driver.findElement(By.xpath("//div[@id='dataForm:divFullPlt1']")).getText();
            String Pallet = strPallet.replaceAll("\\D+","");
            libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Shipment_Id"), Pallet, "Pallet Number");
            Thread.sleep(2000);
            pressEnter();
            Thread.sleep(2000);
            	if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:locationempty']", "XPATH"))
            		{
            		Thread.sleep(2000);
            		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LocationEmpty"), "Y", "Location Empty Y/N ?");
            		Thread.sleep(4000);
            		}
            libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Res_Loc_SingleByPass"), Location, "iLPN_Num");	
            Thread.sleep(2000);
            pressEnter();
            Thread.sleep(4000);
            }
            else
            {
            libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LPN_Num_Mod"), strPallet, "Pallet Number");
            Thread.sleep(2000);
            pressEnter();
            Thread.sleep(2000);
            item = libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:id_333']", "XPATH").getText();
            String[] strarr = item.split(":");
            item = strarr[1];
            String striLPN = driver.findElement(By.xpath("//div[@id='labelCntr9']")).getText();
            String LPN = striLPN.replaceAll("\\D+","");
            Thread.sleep(2000);
            libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Shipment_Id"), LPN, "iLPN_Num");
            Thread.sleep(2000);
            pressEnter();
            Thread.sleep(4000);
            if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:locationempty']", "XPATH"))
            {
                   Thread.sleep(2000);
                   libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LocationEmpty"), "Y", "Location Empty Y/N ?");
                   Thread.sleep(4000);
            }
            
            if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='confirmlocation_Input']", "XPATH"))
            {
            	String Rloc = libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:div3']", "XPATH").getText();
                String[] strloc = Rloc.split(":");
                Rloc = strloc[1];
                Rloc=Rloc.trim();
                Rloc=Rloc.replace("-", "");
                Rloc=Rloc.trim();
                Thread.sleep(2000);
                libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Res_Loc_SingleByPass"), Rloc, "iLPN_Num");
                Thread.sleep(2000);
                pressEnter();
                Thread.sleep(4000);
            }
            }
            clickAcceptAndProceed();
            Thread.sleep(1000);            
            return item;
     }
     
     /**
      *********************************************************************** 
       * Function performs Replenish iLPN
      * @return    item 
       * @Author    Nitika
      * @param     strQty, strPallet
      * @version 1.0
      ***********************************************************************
      */  
     public void ReplenishLPN(String striLPNNumber) throws Exception
     {		
    	 striLPNNumber="9394782313598588";
    	 Thread.sleep(2000);
    	 libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ReplLPN"), striLPNNumber, "iLPN_Num");

    	 Thread.sleep(2000);
         pressEnter();
         Thread.sleep(4000);
         String PLoc = libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:div012']", "XPATH").getText();
         String[] strarr = PLoc.split(":");
         PLoc = strarr[1];
         PLoc=PLoc.replace("-", "");
         PLoc=PLoc.trim();
         libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("PLoc"), PLoc, "P Location");
         Thread.sleep(2000);
         pressEnter();
         Thread.sleep(4000);
     }
     
     /**
 	 *********************************************************************** 
 	 * Function performs tasking pick tote.
 	 * @return 	Nothing is returned as of now 
 	 * @Author 	Yagna Priya D
 	 * @param 	strItemBarcode,strTaskId,strToteNo,strSequenceNumber
 	 * @version 1.0
 	 * @throws Exception  
 	 ***********************************************************************
 	 */
 	public void taskingPickTote(String strTaskId, String strToteNo, String strItemBarcode, String strSequenceNumber) throws Exception{
 		enterTask(strTaskId);
 		Thread.sleep(3000);
 		clickAcceptAndProceed();
 		Thread.sleep(2000);
 		enteriLPN(strToteNo);//enter tote number
 		Thread.sleep(6000);
 		pressEnter();
 		Thread.sleep(4000);
 		//clickOptionsIcon();
 		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOptions"), "Options Icon");
 		Thread.sleep(2000);
 		clickToggleButton();
 		Thread.sleep(2000);
 		//clickOptionsIcon();
 		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOptions"), "Options Icon");
 		Thread.sleep(2000);
 		clickToggleButton();
 		Thread.sleep(6000);
 		entertaskingItemNumber2(strItemBarcode);// enter item barcode

 		Thread.sleep(6000);
 		pressEnter();
 		Thread.sleep(4000);
 		entertaskingSequenceNumber(strSequenceNumber);//enter sequence number
 		clickOnExit();
 		Thread.sleep(2000);
 	}
 	
 	
 	/**
	 *********************************************************************** 
	 * Function clicks on toggle button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public  void clickToggleButton() throws InterruptedException {
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnToggle"), "Toggle Button");	
		Thread.sleep(2000);
		
	}
	
	/**
	 *********************************************************************** 
	 * Function enters item barcod2e for tasking.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strItemBarcode
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void entertaskingItemNumber2(String strItemBarcode) throws InterruptedException
	{
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("tasking_itemBarcode2"), strItemBarcode, "Item Barcode");
	}
	

	/**
	 *********************************************************************** 
	 * Function enters item barcode for tasking.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strItemBarcode
	 * @version 1.0
	 * @throws InterruptedException 
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void entertaskingSequenceNumber(String strSequenceNumber) throws InterruptedException, AWTException
	{	if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:locationempty']", "XPATH"))
    {
        Thread.sleep(2000);
        libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("LocationEmpty"), "Y", "Location Empty Y/N ?");
        Thread.sleep(4000);
    }
		if (libManhattanCommonFunctions.verifyElementPresent("//input[@id='dataForm:selectNo']", "XPATH")){
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("tasking_sequence"), strSequenceNumber, "Sequence Number");
			Thread.sleep(6000);
			pressEnter();
			Thread.sleep(4000);
		}
	}
	
	
	/**
	 *********************************************************************** 
	 * Function performs pack tote.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strItemBarcode,strTaskId,strToteNo,strSequenceNumber
	 * @version 1.0
	 * @throws Exception  
	 ***********************************************************************
	 */
	public void taskingpackTote(String strToteNo, String strItemBarcode, String stroLPN) throws Exception{
		Thread.sleep(4000);
		enteriLPN(strToteNo);//enter tote number
		Thread.sleep(6000);
		pressEnter();
		Thread.sleep(4000);
		//clickOptionsIcon();
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOptions"), "Options Icon");
		Thread.sleep(2000);
		clickToggleButton();
		Thread.sleep(2000);
		//clickOptionsIcon();
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOptions"), "Options Icon");
		Thread.sleep(2000);
		clickToggleButton();
		Thread.sleep(2000);
		entertaskingItemNumber(strItemBarcode); // enter item barcode
		Thread.sleep(6000);

		pressEnter();
		Thread.sleep(4000);
		entertaskingoLPNNumber(stroLPN);//enter olpn number

		Thread.sleep(2000);
		pressEnter();
		Thread.sleep(2000);
		clickAcceptAndProceed();
		clickOnExit();
		Thread.sleep(2000);
	}
	
	
	/**
	 *********************************************************************** 
	 * Function enters item barcode for tasking.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strItemBarcode
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void entertaskingItemNumber(String strItemBarcode) throws InterruptedException
	{
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("tasking_itemBarcode"), strItemBarcode, "Item Barcode");
	}
	
	/**
	 *********************************************************************** 
	 * Function enters item barcode for tasking.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya D
	 * @param 	strItemBarcode
	 * @version 1.0
	 * @throws InterruptedException 
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void entertaskingoLPNNumber(String stroLPN) throws InterruptedException, AWTException
	{
		
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("tasking_olpn"), stroLPN, "oLPN Number");
			
	}
	
	
	/**
     *********************************************************************************** 
     * Function for make pick cart
     * @return    Nothing is returned as of now 
     * @Author    Aishwarya
     * @param     None
     * @version 1.0
     * @throws AWTException 
     ***********************************************************************************
     */

     public void makePickCart(String strPickerid, String strPickcartno, String strOlpn, String strSlot ) throws InterruptedException, AWTException
     { 


    	 libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_pickerid"), strPickerid, "Picker id");
            pressEnter();
            Thread.sleep(4000);
            libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_pickcartnumber"), strPickcartno, "Pick Cart Number");
            pressEnter();
            Thread.sleep(4000);
            libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_OlpnNumber"), strOlpn, "Olpn Number");
            pressEnter();
            Thread.sleep(4000);
            libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_SlotNumber"), strSlot, "Slot Number");
            pressEnter();
            Thread.sleep(4000);
            libManhattanCommonFunctions.clickAnyElement(getPageElement("btnOptions"), "Options Icon");
            Thread.sleep(4000);
            libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEndofPickCart"), "End of Pick Cart");
            Thread.sleep(2000);
            }
     
     
     /**
      *********************************************************************************** 
      * Function for pick to cart
      * @return    Nothing is returned as of now 
      * @Author    Aishwarya
      * @param     None
      * @version 1.0
      * @throws AWTException 
      ***********************************************************************************
      */

      public void picktoCart(String strPickerid, String strPickcartno ) throws InterruptedException, AWTException
      { 
             libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_pickNumber"), strPickerid, "Picker id");
             pressEnter();
             Thread.sleep(2000);
             libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_pickcartnumber"), strPickcartno, "Pick Cart Number");
             pressEnter();
             Thread.sleep(2000);
             enteritemForPickcart();
             Thread.sleep(2000);
             enterOlpnForPickcart();
             Thread.sleep(2000);
             clickAcceptAndProceed();
      }
      
      /**
       *********************************************************************************** 
       * Function enters the item number for pick cart
       * @return    Nothing is returned as of now 
       * @Author   Aishwarya
       * @param     None
       * @version 1.0
       * @throws AWTException 
       ***********************************************************************************
       */

       public void  enteritemForPickcart() throws InterruptedException, AWTException{ 

              Thread.sleep(2000);
              String actualItem1= libManhattanCommonFunctions.getElementByProperty("//*[@id='dataForm:enl3']/div[3]","XPATH").getText();
              String actualItem=actualItem1.replace("Item:", "");
              keyCTRLA();
              Thread.sleep(2000);
              keyCTRLA();
              Thread.sleep(2000);
              libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_ItemNumber"), actualItem.trim(), "Item Number");
              Thread.sleep(2000);
              pressEnter();
              Thread.sleep(2000);
       }
       
       
       /**
       *********************************************************************************** 
       * Function enters the Olpn for pick cart
       * @return    Nothing is returned as of now 
       * @Author   Aishwarya
       * @param     None
       * @version 1.0
       * @throws AWTException 
       ***********************************************************************************
       */

       public void  enterOlpnForPickcart() throws InterruptedException, AWTException{ 

              Thread.sleep(2000);
              String actualOlpn= libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:vp_8qty_crt']","XPATH").getText();
              Thread.sleep(2000);
              libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_Olpn"), actualOlpn.trim(), "Olpn Number");
              Thread.sleep(2000);
              pressEnter();
              Thread.sleep(2000);
       }
       
       /**
   	 *********************************************************************** 
   	 * Function enters the barcode.
   	 * @return 	Nothing is returned as of now 
   	 * @Author 	Rahman
   	 * @param 	strBarcode
   	 * @version 1.0
   	 ***********************************************************************
   	 */
   	public void enterCCItemBarcode(String strBarcode) throws InterruptedException{ 
   		//		switchFrame();
   		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("CC_ItemBarcode"), strBarcode, "Item Barcode");
   	}

   	/**
	 *********************************************************************** 
	 * Function enters the quantity.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strQty
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterCCItemQty(String strQty) throws InterruptedException{ 
		switchFrame();
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("CC_ItemQty"), strQty, "Item Quantity");
	}
	
	/**
	 *********************************************************************** 
	 * Function clicks on Continue Count.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	None
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void clickContinueCount() throws InterruptedException {
		if (libManhattanCommonFunctions.verifyElementPresent("//span[@value='Continue Count']", "XPATH")){	
			Thread.sleep(3000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnContinueCount"), "Continue Count Button");
			Thread.sleep(3000);
		}
	}
       
	/**
	 *********************************************************************** 
	 * Function verifies Error Message.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void verifyErrorMsg(){                                
		String ErrMsg = "iLPN is allocated or partially alloc!";                           
		try{  				
			String strActualErrMsg = libManhattanCommonFunctions.getElementByProperty("//div[@class='error']", "XPATH").getText();
			if(strActualErrMsg.trim().contains(ErrMsg))

			{
				report.updateTestLog("RF Menu Cycle Counts details verification", "Error Msg : "+strActualErrMsg+" : generated", Status.PASS);
			}else
			{
				report.updateTestLog("RF Menu Cycle Counts details verification", "Error Msg : "+strActualErrMsg+" : generated", Status.FAIL);
			}
		}
		catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}              
	}
	
	
	/**
	 *********************************************************************** 
	 * Function performs tasking pick tote.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strItemBarcode,strTaskId,strToteNo,strSequenceNumber
	 * @version 1.0
	 * @throws Exception  
	 ***********************************************************************
	 */
	public void taskingPickMultiTote(String strTaskId, String strToteNo) throws Exception{				
		enterTask(strTaskId);
		Thread.sleep(3000);
		clickAcceptAndProceed();
		Thread.sleep(2000);	
		if(strToteNo.contains(";")){			
			String[] SingleTote=splitDataValues(strToteNo);
			for(int i=0;i<SingleTote.length;i++){
				SingleTote[i]=SingleTote[i].trim();
				enteriLPN(SingleTote[i]);//enter tote number
				Thread.sleep(2000);
				pressEnter();
				Thread.sleep(3000);			
				String actualItem= libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:break3']","XPATH").getText();
				String[] actualItemBarcode = actualItem.split("Item:");
				actualItemBarcode[1]=actualItemBarcode[1].trim();				
				enterPickToteItemBarcode(actualItemBarcode[1]);// enter item barcode
				Thread.sleep(2000);				
				pressEnter();
				Thread.sleep(4000);					
				if(!((i+1)==(SingleTote.length)))
				{
					clickOptionsIcon();
					Thread.sleep(4000);
					EndTote();
					Thread.sleep(4000);
				}
			}//enter sequence number
		}else{			
			enteriLPN(strToteNo);//enter tote number
			Thread.sleep(2000);
			pressEnter();
			Thread.sleep(3000);		
			Thread.sleep(4000);
			int i=1,j=0;
			//          libManhattanCommonFunctions.waitForElementVisibility("//div[@id='dataForm:break3']", 6000);
			do{            	
				if (libManhattanCommonFunctions.verifyElementPresent("//div[@id='dataForm:break3']", "XPATH")){	   
					j=0;
					String actualItem= libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:break3']","XPATH").getText();			
					String[] actualItemBarcode = actualItem.split("Item:");
					actualItemBarcode[1]=actualItemBarcode[1].trim();				
					enterPickToteItemBarcode(actualItemBarcode[1]);// enter item barcode
					Thread.sleep(2000);				
					pressEnter();
					Thread.sleep(4000);
					j++;
				}
				else{
					j=0;
				}
			}
			while(i==j);			
		}
		clickOnExit();
		Thread.sleep(4000);	
		//		return strItemBarcode;
	}
	
	/**
	 *********************************************************************** 
	 * Function splits the string into array.
	 * @return 	strTaskId 
	 * @Author  Rahman
	 * @param 	None
	 * @version 1.0
	 * @throws 	Exception 
	 ***********************************************************************
	 */
	//	@SuppressWarnings("null")
	public String[] splitDataValues(String strDataValue) throws Exception
	{		
		int distinct=0;		
		for (int i = 0; i < strDataValue.length(); i++) {	       
			if(strDataValue.charAt(i)==(';'))
			{	                
				distinct++;
			}
		} 
		String strMultipleValues[] = new String[distinct+1];
		if (strDataValue.contains(";")){
			Thread.sleep(3000);
			strMultipleValues = strDataValue.split(";");
		}
		else{
			strMultipleValues[0]=strDataValue;
		}
		return strMultipleValues;
	}
	
	/**
	 *********************************************************************** 
	 * Function enters the barcode.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strBarcode
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterPickToteItemBarcode(String strBarcode) throws InterruptedException{ 
		//		switchFrame();
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("PickToteItemBarcode"), strBarcode, "Item Barcode");
	}
	
	/**
	 *********************************************************************** 
	 * Function clicks on end tote.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strBarcode
	 * @version 1.0
	 ***********************************************************************
	 */
	public void EndTote() throws InterruptedException{ 
		//		switchFrame();
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEndTote"), "End Tote");
	}
	
	/**
	 *********************************************************************** 
	 * Function validates Location details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	striLPN, strQuantity, striLPNstatus, strLockCode
	 * @version 1.0
	 * @throws InterruptedException 
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void taskingTotePrintandPack(String strTote) throws InterruptedException, AWTException{		
		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Tote"), strTote, "Tote Number");
		Thread.sleep(2000);
		pressEnter();
		Thread.sleep(4000);
		clickOnExit();
		Thread.sleep(4000);	
	}
	
	/**
	 *********************************************************************** 
	 * Function drops tasking
	 * @return 	item 
	 * @Author 	Rahman
	 * @param 	strQty, strPallet
	 * @version 1.0
	 ***********************************************************************
	 */	
	public void performDropTask(String strTaskID,String strQty, String strPallet) throws Exception
	{
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		//		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnterTask"), "Enter Task");	
		//		Thread.sleep(4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Task_Id"), strTaskID, "Task Id");	
		Thread.sleep(2000);
		clickOnEnterButton();
		Thread.sleep(4000);
		keyCTRLS();
		Thread.sleep(6000);		
		clickAcceptAndProceed();
		Thread.sleep(2000);            	
	}
	
	/**
	 *********************************************************************** 
	 * Function performs CTRLS keyboard action.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void keyCTRLS() throws InterruptedException, AWTException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}
	
	/**
	 *********************************************************************** 
	 * Function enters the task.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	none
	 * @version 1.0
	 ***********************************************************************
	 */
	public void clickEnterTask() throws Exception
	{
		driver.switchTo().defaultContent();
		List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
		driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnterTask"), "Enter Task");	
		Thread.sleep(4000);
	}
	
	/**
	 *********************************************************************** 
	 * Function enters the LPN number suggested by the system
	 * @return 	item 
	 * @Author 	Rahman
	 * @version 1.0
	 * @return 
	 ***********************************************************************
	 */	
	public void loadLTLwithInvalidData(String strShipment) throws Exception{
		//input[@id='barcode20']
		Thread.sleep(2000);
		if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='barcode20']", "XPATH"))
		{
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Load_LTL_Shipment"), strShipment, "Shipment");
			Thread.sleep(3000);
			pressEnter();
			Thread.sleep(3000);		
		}				
		if(libManhattanCommonFunctions.verifyElementPresent("//div[@class='error']", "XPATH"))
		{
			report.updateTestLog("Error Msg verification","Error Msg \"Invalid Shipment Status\" verified successfully", Status.PASS);
		}
		clickAcceptAndProceed();
		Thread.sleep(3000);		                   
	}
	
	/**
	 *********************************************************************** 
	 * Function searches the item.
	 * @return    Nothing is returned as of now 
	 * @Author    Rahman
	 * @param     strSeq, strQuantity, strLocation
	 * @version 1.0
	 ***********************************************************************
	 */
	public void loopSearchitemseq(String strSeq,String strQuantity, String strLocation,String strFacility){
		try{
			if (strSeq.contains(";")){
				Thread.sleep(3000);
				String[] strseq = strSeq.split(";");
				String[] strqty = strQuantity.split(";");
				String[] strloc = strLocation.split(";");

				validateItemDetails(strseq,strqty,strloc,strFacility);
				Thread.sleep(1000);

			}
			else{				
				RetrieveSequence(strSeq, strQuantity, strLocation, strFacility);				
			}

		}catch(Exception e){

		}
	}
	
	/**
	 *********************************************************************** 
	 * Function validates the item.
	 * @return    Nothing is returned as of now 
	 * @Author    Rahman
	 * @param     strSeq, strQuantity, strLocation
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void validateItemDetails(String strSeq[],String strQuantity[], String strLocation[], String strFacility) throws InterruptedException{                                
		Thread.sleep(3000);
		try{                 
			int count=0,max=0;
			do{
				if (libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'+')]", "XPATH")){    
					RetrieveSequence(strSeq[count],strQuantity[count],strLocation[count],strFacility);
					if(count%2!=0)
					{
						clickOptionsIcon();
						clickOnPageDown();
					}
					count++;
					Thread.sleep(1000);
				}
				else{
					for(int i=max;i<=(max+1);i++)
					{                          
						RetrieveSequence(strSeq[i],strQuantity[i],strLocation[i],strFacility);
					}
				}
				max++;
			}while(count==max);
			Thread.sleep(2000);  
			max=0;count=0;
		}
		catch(Exception e){
			report.updateTestLog("Item Details", "Element Not Found", Status.FAIL);
		}              
	}

	
	/**
	 *********************************************************************** 
	 * Function retrieves Sequence, Quantity and Location.
	 * @return    Nothing is returned as of now 
	 * @Author    Rahman
	 * @param     None
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void RetrieveSequence(String strSeq,String strQuantity, String strLocation, String strFacility) throws InterruptedException
	{
		int intRowPointer=0;
		boolean blnFlagValue;
		String actualseq = "";
		String actualqty = "";
		String actualloc = "";	
		if(!(strSeq.isEmpty()&&strQuantity.isEmpty()&&strLocation.isEmpty())){
			report.updateTestLog("Item Details validation", "Item Details validation successful", Status.DONE);
		}
		WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:ITEMList']"));
		List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR"));			
		for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
		{              
			System.out.println(intRowPointer+1);
			blnFlagValue = false;
			intRowPointer = intPointr;
			actualseq=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ITEMList:"+intRowPointer+":seq']", "XPATH").getText();
			Thread.sleep(1000);		
			if(strFacility.equalsIgnoreCase("ONT"))
			{				
				actualqty=libManhattanCommonFunctions.getElementByProperty("//*[@id='dataForm:ITEMList']/tbody/tr["+(intRowPointer+1)+"]/td[2]/div", "XPATH").getText();
			}
			else
			{
				actualqty=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ITEMList:"+intRowPointer+":space2']", "XPATH").getText();//span[@id='dataForm:ITEMList:"+intRowPointer+":Qty2']						
			}
			actualloc=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ITEMList:"+intRowPointer+":locn1']", "XPATH").getText();
			if(actualseq.trim().equals(strSeq) && actualqty.trim().equals(strQuantity) && actualloc.trim().equals(strLocation))
			{
				report.updateTestLog("Item details verification", "Expected Sequence : "+strSeq+" Actual Sequence : "+actualseq+" Expected Quantity : "+strQuantity+" Actual Quantity : "+actualqty+" Expected Location : "+strLocation+" Actual Location : "+actualloc, Status.PASS);
				System.out.println(strSeq+" "+actualseq+" "+strQuantity+" "+actualqty+" "+strLocation+" "+actualloc);
				blnFlagValue = true;
				break;
			}else{
				blnFlagValue = false;
				System.out.println(strSeq+" "+actualseq+" "+strQuantity+" "+actualqty+" "+strLocation+" "+actualloc);
			}
			if (blnFlagValue = false){                      
				report.updateTestLog("Item details verification", "Expected Sequence : "+strSeq+" Actual Sequence : "+actualseq+" Expected Quantity : "+strQuantity+" Actual Quantity : "+actualqty+" Expected Location : "+strLocation+" Actual Location : "+actualloc, Status.FAIL);
			}
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function enter oLPN.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	stroLPN
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enteroLPN(String stroLPN) throws InterruptedException{ 
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("oLPN_Num"), stroLPN, "oLPN");
	}
	
	
	/**
	 *********************************************************************** 
	 * Function validates oLPN details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	stroLPN, strItem, strQuantity, striLPNstatus, strLockCode, strOrder
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateoLPNDetails(String stroLPN,String strItem,String strQuantity,String striLPNstatus,String strLockCode,String strOrder){                                
		try{  
			if(!(stroLPN.isEmpty()&&strItem.isEmpty()&&strQuantity.isEmpty()&&striLPNstatus.isEmpty()&&strLockCode.isEmpty()&&strOrder.isEmpty())){
				report.updateTestLog("iLPN Details validation", "iLPN Details validation successful", Status.DONE);
			}
			String actualLPN=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ot10']", "XPATH").getText();
			String actualItem=libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:item1']", "XPATH").getText();
			String stractualItem=actualItem.replace("Item:", "");
			String actualQuantity=libManhattanCommonFunctions.getElementByProperty("(//div[@style='white-space:nowrap'])[2]", "XPATH").getText();
			String stractualQTY=actualQuantity.replace("Qty: ", "");
			String actualiLPNstatus=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:statusdesc']", "XPATH").getText();
			System.out.println(actualiLPNstatus);
			String stractualiLPNstatus=actualiLPNstatus.replace(" Lk:", "");
			System.out.println(stractualiLPNstatus);		
			String actualLockCode=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ot23']", "XPATH").getText();
			String actualOrder=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:id_info3']", "XPATH").getText();
			if((actualLPN.trim().equalsIgnoreCase(stroLPN)) && (stractualItem.trim().equalsIgnoreCase(strItem)) &&((stractualQTY.trim().equalsIgnoreCase(strQuantity)))  && (stractualiLPNstatus.trim().equalsIgnoreCase(striLPNstatus)) && (actualLockCode.trim().equalsIgnoreCase(strLockCode)) && (actualOrder.trim().equalsIgnoreCase(strOrder)))                     
			{
				report.updateTestLog("iLPN details verification", "Expected iLPN : "+stroLPN+" || Actual iLPN :"+actualLPN+" Expected Item : "+strItem+" || Actual Item :"+stractualItem+" Expected Quantity : "+strQuantity+" || Actual Quantity : "+stractualQTY+" Expected Status : "+striLPNstatus+" || Actual Status : "+stractualiLPNstatus+" Expected Lock Code : "+strLockCode+" || Actual Lock Code : "+actualLockCode+" Expected Order ID : "+strOrder+" || Actual Order ID : "+actualOrder, Status.PASS);
			}else
			{
				report.updateTestLog("iLPN details verification", "Expected iLPN : "+stroLPN+" || Actual iLPN :"+actualLPN+" Expected Item : "+strItem+" || Actual Item :"+stractualItem+" Expected Quantity : "+strQuantity+" || Actual Quantity : "+stractualQTY+" Expected Status : "+striLPNstatus+" || Actual Status : "+stractualiLPNstatus+" Expected Lock Code : "+strLockCode+" || Actual Lock Code : "+actualLockCode+" Expected Order ID : "+strOrder+" || Actual Order ID : "+actualOrder, Status.FAIL);
			}
		}
		catch(Exception e){
			report.updateTestLog("iLPN Details", "Element Not Found", Status.FAIL);
		}              
	}
	

	/**
	 *********************************************************************** 
	 * Function enter Location.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strLocation
	 * @version 1.0
	 ***********************************************************************
	 */
	public void enterLocation(String strLocation) throws InterruptedException{ 
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Location_Inq"), strLocation, "Location");
	}
	
	
	/**
	 *********************************************************************** 
	 * Function validates Location details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	striLPN, strQuantity, striLPNstatus, strLockCode
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateLocationDetails(String striLPN,String strItem,String strQuantity){                                
		try{  
			if(!(striLPN.isEmpty()&&strItem.isEmpty()&&strQuantity.isEmpty())){
				report.updateTestLog("iLPN Details validation", "iLPN Details validation successful", Status.DONE);
			}
			String actualLPN=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:LPNList:0:case']", "XPATH").getText();
			String actualItem=libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:LPNList:0:itemdiv1']", "XPATH").getText();
			String stractualItem=actualItem.replace("Item:", "");
			String actualQuantity=libManhattanCommonFunctions.getElementByProperty("(//div[@style='white-space:nowrap'])[3]", "XPATH").getText();
			String stractualQTY=actualQuantity.replace("Qty: ", "");					

			if((actualLPN.trim().equalsIgnoreCase(striLPN)) && (stractualItem.trim().equalsIgnoreCase(strItem)) &&((stractualQTY.trim().equalsIgnoreCase(strQuantity))))                     
			{
				report.updateTestLog("iLPN details verification", "Expected iLPN : "+striLPN+" || Actual iLPN :"+actualLPN+" Expected Item : "+strItem+" || Actual Item :"+stractualItem+" Expected Quantity : "+strQuantity+" || Actual Quantity : "+stractualQTY, Status.PASS);
			}else
			{
				report.updateTestLog("iLPN details verification", "Expected iLPN : "+striLPN+" || Actual iLPN :"+actualLPN+" Expected Item : "+strItem+" || Actual Item :"+stractualItem+" Expected Quantity : "+strQuantity+" || Actual Quantity : "+stractualQTY, Status.FAIL);
			}
		}
		catch(Exception e){
			report.updateTestLog("iLPN Details", "Element Not Found", Status.FAIL);
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
	public String combineDataValues(String strDataValue[]) throws Exception
	{	
		String strSingleValue="";
		for(int i=0;i<strDataValue.length;i++){
			if(i==0){
				strSingleValue=strDataValue[i];
			}else{
				strSingleValue=strSingleValue+";"+strDataValue[i];	
			}			
		}
		return strSingleValue;
	}
	

	/**
	 *********************************************************************** 
	 * Function performs tote print.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strItemBarcode,strTaskId,strToteNo
	 * @version 1.0
	 * @throws Exception  
	 ***********************************************************************
	 */
	public void taskingTotePrint(String strToteNo, String strItemBarcode, String stroLPN) throws Exception{

		Thread.sleep(4000);
		enteriLPN(strToteNo);//enter tote number
		Thread.sleep(4000);
		pressEnter();		
		Thread.sleep(3000);		
		if(stroLPN.contains(";")){
			String[] SingleItem=splitDataValues(strItemBarcode);
			String[] SingleOLPN=splitDataValues(stroLPN);
			for(int i=0;i<SingleItem.length;i++){
				entertaskingoLPNNumber(SingleOLPN[i]);//enter olpn number
				Thread.sleep(2000);
				pressEnter();
				Thread.sleep(2000);				
				enterCCItemBarcode(SingleItem[i]);				
				Thread.sleep(2000);
				pressEnter();
				Thread.sleep(2000);
			}
		}
		clickOnExit();
		Thread.sleep(2000);
	}
	
	/**
	 *********************************************************************** 
	 * Function performs tote print.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strItemBarcode,strTaskId,strToteNo
	 * @version 1.0
	 * @throws Exception  
	 ***********************************************************************
	 */
	public void taskingMultiTotePrint(String[] strToteNo, String[] strItemBarcode, String[] stroLPN) throws Exception{
		Thread.sleep(3000);
//		strToteNo[0]="96210002602530";
//		strToteNo[1]="96210002602523";
		for(int i=0;i<strToteNo.length;i++){
			enteriLPN(strToteNo[i]);//enter tote number
			Thread.sleep(4000);
			pressEnter();		
			Thread.sleep(3000);						
			entertaskingoLPNNumber(stroLPN[i]);//enter olpn number
			Thread.sleep(2000);
			pressEnter();
			Thread.sleep(2000);
			enterCCItemBarcode(strItemBarcode[i]);
			Thread.sleep(2000);
			pressEnter();
			Thread.sleep(2000);
		}	
		clickOnExit();	
		Thread.sleep(2000);
	}
	
	/**
	 *********************************************************************** 
	 * Function validates Location details.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	striLPN, strQuantity, striLPNstatus, strLockCode
	 * @version 1.0
	 * @throws InterruptedException 
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void ScanAndEnteroLPN(String striLPN, String strItemBarcode) throws InterruptedException, AWTException{
		Thread.sleep(1000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Tote"), striLPN, "oLPN");
		Thread.sleep(2000);
		pressEnter();
		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("CC_ItemBarcode"), strItemBarcode, "Item Barcode");
		Thread.sleep(2000);
		pressEnter();
		Thread.sleep(2000);
		String stroLPN = driver.findElement(By.xpath("//span[@id='dataForm:locn21']")).getText();//input[@id='tote1re']
		stroLPN=stroLPN.trim();
		Thread.sleep(2000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ToteOLPN"), stroLPN, "oLPN");
		Thread.sleep(3000);
		pressEnter();
		Thread.sleep(2000);
		clickAcceptAndProceed();
		Thread.sleep(3000);
	}
	
	/**
	 *********************************************************************** 
	 * Function enters details for recieving and sorting function.
	 * 
	 * @return Nothing is returned as of now
	 * @Author Rahman
	 * @param strDockDoor
	 *            , strSelectASN, strASNNumber, strLPN
	 *            strItemBarcode, strItemQty
	 * @version 1.0
	 *********************************************************************** 
	 */
	public void enterRecvSortInputs(String strDockDoor,
			String strASNNumber, String strLPN, String strItemBarcode,
			String strItemQty) throws InterruptedException, AWTException {
		Thread.sleep(3000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(
				getPageElement("txtDockDoor"), strDockDoor, "Dock Door");
		Thread.sleep(3000);
		pressEnter();
		Thread.sleep(3000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(
				getPageElement("txtboxASN"), strASNNumber, "ASN Number");
		Thread.sleep(3000);
		pressEnter();
		//	Thread.sleep(3000);
		//	clickOnAcceptProceed();
		Thread.sleep(3000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(
				getPageElement("txtboxLPN"), strLPN, "LPN");
		Thread.sleep(6000);
		pressEnter();
		Thread.sleep(3000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(
				getPageElement("txtboxItemBarcode"), strItemBarcode,
				"Item Barcode");

		Thread.sleep(3000);
		pressEnter();
		libManhattanCommonFunctions.clearAndUpdateAnyElement(
				getPageElement("txtboxItemQty"), strItemQty, "Item Qty");
		Thread.sleep(3000);
		pressEnter();
		Thread.sleep(3000);
		clickOnAcceptProceed();
		Thread.sleep(4000);
		String actualRLoc1 = libManhattanCommonFunctions.getElementByProperty(
				"//*[@id='dataForm:RFcontent']/text()[preceding-sibling::br]", "XPATH").getText();
		String actualRLoc = actualRLoc1.replace("Rloc:", "");
		String actualRLoc2 = actualRLoc.replace("-", "");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(
				getPageElement("R_Loc_Rec"), actualRLoc2.trim(),
				"Reserve Location");
		Thread.sleep(3000);
		pressEnter();
	}
	
	/**
	 *********************************************************************** 
	 * Function to complete iLPN Pull
	 * @return      Nothing is returned as of now 
	 * @Author Aishwarya
	 * @param       None
	 * @version 1.0
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void iLPNPull(String strTaskGrp, String strTaskId, String strPallet ) throws AWTException
	{
		try {
			clickOptionsIcon();
			Thread.sleep(3000);
			clickOnChangeTaskGrp();
			updateTaskGrp(strTaskGrp);
			clickOptionsIcon();
			enterTask(strTaskId);
			Thread.sleep(2000);
			clickAcceptAndProceed();
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_Pallet"), strPallet, "Pallet Number");
			Thread.sleep(2000);
			pressEnter();
			String ilpn = libManhattanCommonFunctions.getElementByProperty("//div[@id='labelCntr9']", "XPATH").getText();
			String striLPNvalue = 	ilpn.replace("iLPN:", "").trim();
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_iLPN"), striLPNvalue, "iLPN Number");
			pressEnter();
			Thread.sleep(4000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_locationempty"), "Y", "Location Empty");
			pressEnter();
			String actualRLoc1 = libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:div3']", "XPATH").getText();
			String actualRLoc=actualRLoc1.replace("Rloc:", "");
			String actualRLoc2=actualRLoc.replace("-", "").trim();
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_RLoc"), actualRLoc2, "RLoc");
			pressEnter();		 
		} 	
		catch(Exception e){
			report.updateTestLog("iLPN Pull Task", "Element Not Found", Status.FAIL);
		}


	}

	/**
	 *********************************************************************** 
	 * Function to complete Pack SBP
	 * @return      Nothing is returned as of now 
	 * @Author Aishwarya
	 * @param       None
	 * @version 1.0
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void PackSBP(String strTote, String strItem, int strOrderLines, String strchoice) throws AWTException
	{
		try {
			for(int intLoop=0;intLoop<=strOrderLines;intLoop++)
			{
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_Tote"), strTote, "Tote Number");
				pressEnter();
				Thread.sleep(2000);
				keyCTRLA();
				Thread.sleep(2000);
				keyCTRLA();
				Thread.sleep(2000);
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_itemnbr"), strItem, "Item Number");
				Thread.sleep(2000);
				pressEnter();
				String olpn = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:locn21']", "XPATH").getText();
				String stroLPNvalue = 	olpn.trim();
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_oLPN"), stroLPNvalue, "oLPN Number");
				clickAcceptAndProceed();
				keyCTRLX();
				enterchoice(strchoice);
				Thread.sleep(3000);
				pressEnter();
				Thread.sleep(3000);
			}
		} 	
		catch(Exception e){
			report.updateTestLog("Pack SBP", "Element Not Found", Status.FAIL);
		}


	}

	/**
	 *********************************************************************** 
	 * Function performs CTRL X keyboard action.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
	public void keyCTRLX() throws InterruptedException, AWTException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_X);
		robot.keyRelease(KeyEvent.VK_X);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}
	/**
	 *********************************************************************** 
	 * Function to end tote pick
	 * @return      Nothing is returned as of now 
	 * @Author Aishwarya
	 * @param       None
	 * @version 1.0
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void rfTotePick(String strTaskGrp, String strTaskId, String strTote, int strOrderqty ) throws AWTException
	{
		try {
			clickOptionsIcon();
			Thread.sleep(3000);
			clickOnChangeTaskGrp();
			updateTaskGrp(strTaskGrp);
			clickOptionsIcon();
			enterTask(strTaskId);
			Thread.sleep(2000);
			clickAcceptAndProceed();
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_Tote"), strTote, "Tote");
			Thread.sleep(2000);
			pressEnter();
			Thread.sleep(3000);
			String actualitem = libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:break3']", "XPATH").getText();
			String itemnbr=actualitem.replace("Item:", "").trim();
			Thread.sleep(4000);
			for(int intLoop=1;intLoop<=strOrderqty;intLoop++)
			{
				keyCTRLA();
				Thread.sleep(3000);
				keyCTRLA();
				Thread.sleep(3000);
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_toteitm"), itemnbr, "Item Number");
				Thread.sleep(3000);
				pressEnter();
				Thread.sleep(3000);
				//if(libManhattanCommonFunctions.verifyElementPresent("//input[@id='itemId2Brcd']", "XPATH"))
			}
		}
		catch(Exception e){
			report.updateTestLog("RF Tote Pick", "Element Not Found", Status.FAIL);
		}


	}

	/**
	 *********************************************************************** 
	 * Function to perform sorter packing
	 * @return      Nothing is returned as of now 
	 * @Author Aishwarya
	 * @param       None
	 * @version 1.0
	 * @throws AWTException 
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void sorterPacking(String strchoice1, String strchoice2, String stroLPN ) throws InterruptedException, AWTException
	{
		switchFrame();
		enterchoice(strchoice1);
		Thread.sleep(2000);
		pressEnter();
		Thread.sleep(4000);
		enterchoice(strchoice2);
		Thread.sleep(2000);
		pressEnter();
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_oLPNs"), stroLPN, "Item Number");
		pressEnter();		

	}
	/**

	 *********************************************************************************** 

	 * Function enters the reserve location for Putaway Bulk and clicks on enter button.

	 * @return    Nothing is returned as of now 

	 * @Author    Yagna Priya D

	 * @param     None

	 * @version 1.0

	 ***********************************************************************************

	 */

	public String  enterALocForReplenishmentiLPN() throws InterruptedException{ 

		Thread.sleep(2000);

		String actualALoc1= libManhattanCommonFunctions.getElementByProperty("//div[@id='dataForm:div012']","XPATH").getText();

		String actualALoc=actualALoc1.replace("Aloc:", "");

		String actualALoc2=actualALoc.replace("-", "");

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("A_Loc_Bulk"), actualALoc2.trim(), "Active Location");

		return actualALoc;

	}

	/**

	 *********************************************************************** 

	 * Function enters item barcod2e for tasking.

	 * @return          Nothing is returned as of now 

	 * @Author         Yagna Priya D

	 * @param          strLPNNumber

	 * @version 1.0

	 * @throws InterruptedException 

	 ***********************************************************************

	 */

	public void enteriLPNForReplenishment(String strLPNNumber) throws InterruptedException

	{

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("iLPN_Replenishment"), strLPNNumber, "iLPN Number");

	}


	/**
	 *********************************************************************** 
	 * Function to perform cart replenishment
	 * @return      Nothing is returned as of now 
	 * @Author Aishwarya
	 * @param       None
	 * @version 1.0
	 * @throws AWTException 
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void replncart(String strSegment, String strLPN ) throws AWTException, InterruptedException
	{
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_Segment"), strSegment, "Segment Number");
		Thread.sleep(2000);
		pressEnter();
		Thread.sleep(2000);
		String[] strLPNs = strLPN.split(";");
		for(int intLoop=0;intLoop<strLPNs.length;intLoop++)
		{
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_LPN"), strLPNs[intLoop], "LPN Number");
			Thread.sleep(2000);	


			pressEnter();
		}
		Thread.sleep(2000);
		keyCTRLA();
		Thread.sleep(2000);
		for(int intLoop=0;intLoop<strLPNs.length;intLoop++)
		{
			enterALocForReplenishmentiLPN();
			Thread.sleep(2000);
			pressEnter();
			Thread.sleep(2000);
			enteriLPNForReplenishmentcart();
			pressEnter();
		}

	}

	/**

	 *********************************************************************************** 

	 * Function enters the ilpn displayed in Replenishment cart screen

	 * @return    Nothing is returned as of now 

	 * @Author    Aishwarya

	 * @param     None

	 * @version 1.0

	 ***********************************************************************************

	 */

	public String  enteriLPNForReplenishmentcart() throws InterruptedException{ 

		Thread.sleep(2000);

		String actualLPN1= libManhattanCommonFunctions.getElementByProperty("//*[@id='cap_id_1']","XPATH").getText();

		String actualLPN=actualLPN1.replace("LPN:", "").trim();

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("A_Loc_LPN"), actualLPN, "LPN Number");

		return actualLPN;

	}
	
	/**
	 *********************************************************************** 
	 * Function to incomplete tote pick rf menu
	 * @return      Nothing is returned as of now 
	 * @Author Aishwarya
	 * @param       None
	 * @version 1.0
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void incompleterfTotePick(String strTaskGrp, String strTaskId, String strTote ) throws AWTException
	{
		try {
			clickOptionsIcon();
			Thread.sleep(3000);
			clickOnChangeTaskGrp();
			updateTaskGrp(strTaskGrp);
			clickOptionsIcon();
			enterTask(strTaskId);
			Thread.sleep(2000);
			clickAcceptAndProceed();
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txt_Tote"), strTote, "Tote");
			Thread.sleep(2000);
			pressEnter();
		}
		catch(Exception e){
			report.updateTestLog("RF Tote Pick", "Element Not Found", Status.FAIL);
		}
	}
	
	/**
	 *********************************************************************** 
	 * Function enters details for recieving and sorting function.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strDockDoor, strSelectASN, strSelectASN, strASNNumber, strLPN
	 * 		  	strItemBarcode, strItemQty
	 * @version 1.0
	 * @param strItemNumber 
	 ***********************************************************************
	 */
	public void enterRecvandSortInputs(String strDockDoor,String strASNNumber, String strLPN, String strItemQty, String strItemNumber, String strPalletnbr) throws InterruptedException, AWTException {

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtDockDoor"), strDockDoor, "Dock Door");
		pressEnter();
		if (driver.findElement(By.xpath("//span[@id='dataForm:asnsList']")).isDisplayed())
		{
        libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtASNSelectValue"), "1", "Select ASN");
		pressEnter();
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnPrevious"),"Previous Button");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
		}
		Thread.sleep(4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
		pressEnter();
		
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnProceedWarning"),"Override Warning");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPN, "LPN");
		pressEnter();
		Thread.sleep(4000);
		keyCTRLA();
		Thread.sleep(4000);
		keyCTRLA();
		Thread.sleep(4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItem"), strItemNumber, "Item Number");
		pressEnter();
		Thread.sleep(4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemQty"), strItemQty, "Item Qty");
		pressEnter();
		Thread.sleep(4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxPalletNbr"), strPalletnbr, "Pallet Nbr");
		pressEnter();
		Thread.sleep(4000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAcpt_PalletWarning"),"Pallet ");
		//pressEnter();

	}
	
	
	/**
	 *********************************************************************** 
	 * Function performs ctrl K function for modify ilpn
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strReasonCode
	 * @version 1.0
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void modifyiLPN_CtrlK(String strReasonCode) throws InterruptedException, AWTException {
		Thread.sleep(5000);
		clickOptionsIcon();
		Thread.sleep(5000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("CtrlKDeleteDetail"),"Ctrl K delete detail button");
		Thread.sleep(12000);
		enterReasonCode(strReasonCode);
		Thread.sleep(8000);
        pressEnter();
	}
	
	/**
	 *********************************************************************** 
	 * Function performs ctrl Y function for modify ilpn
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strItemNumber, strItemQty, strReasonCode
	 * @version 1.0
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void modifyiLPN_CtrlY(String strItemNumber, String strItemQty, String strReasonCode) throws InterruptedException, AWTException {
		Thread.sleep(5000);
		clickOptionsIcon();
		Thread.sleep(5000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("CtrlYAddDetail"),"Ctrl Y add detail button");
		Thread.sleep(8000);
        libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("CC_ItemBarcode"), strItemNumber, "Item Number");
        Thread.sleep(4000);
        pressEnter();
        Thread.sleep(4000);
        libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("New_Qty"),strItemQty, "Item Qty");
        Thread.sleep(8000);
        pressEnter();
        Thread.sleep(8000);
		enterReasonCode(strReasonCode);
		Thread.sleep(8000);
        pressEnter();
	}
	
	/**
	 *********************************************************************** 
	 * Function performs ctrl G function for modify ilpn
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strReasonCode
	 * @version 1.0
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void modifyiLPN_CtrlG(String strItemNumber, String strItemQty, String strReasonCode) throws InterruptedException, AWTException {
		Thread.sleep(5000);
		clickOptionsIcon();
		Thread.sleep(5000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("CtrlGChangeDetail"),"Ctrl G change detail button");
		Thread.sleep(8000);
        libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("CC_ItemBarcode"), strItemNumber, "Item Number");
        Thread.sleep(4000);
        pressEnter();
        Thread.sleep(4000);
        libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("New_Qty"),strItemQty, "Item Qty");
        Thread.sleep(8000);
        pressEnter();
        Thread.sleep(8000);
		enterReasonCode(strReasonCode);
		Thread.sleep(8000);
        pressEnter();
	}
	
	
	/**
	 *********************************************************************** 
	 * Function checks PO item Qty
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strDockDoor
	 * @version 1.0
	 * @throws AWTException 
	 ***********************************************************************
	 */
	public void checkPOItemQuantity(String strDockDoor,String strASNNumber, String strLPN, String strItemQty, String strItemNumber, String strFacility) throws InterruptedException, AWTException {//String strDataSheetname, String strDataFieldName) throws InterruptedException, AWTException {

        libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtDockDoor"), strDockDoor, "Dock Door");
        Thread.sleep(2000);
        pressEnter();
        Thread.sleep(2000);
        if(libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'Select:')]", "XPATH"))
        {
               libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtASNSelectValue"), "1", "Select ASN");
               Thread.sleep(2000);
               pressEnter();
               Thread.sleep(2000);
               libManhattanCommonFunctions.clickAnyElement(getPageElement("btnPrevious"),"Previous Button");
               Thread.sleep(2000);
               libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");
               Thread.sleep(4000);
               pressEnter();
        }
        else{
               Thread.sleep(2000);
               libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxASN"), strASNNumber, "ASN Number");

               Thread.sleep(2000);
               pressEnter();

        }
        Thread.sleep(2000);
        clickAcceptAndProceed();
        if (strLPN.contains(";")){
               Thread.sleep(3000);
               String[] strLPNs = strLPN.split(";");
               String[] strLPNqty = strItemQty.split(";");
               
               
               for(int intLoop=0;intLoop<strLPNs.length;intLoop++)
               {
                     Thread.sleep(2000);
                      libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPNs[intLoop], "LPN");
                     pressEnter();
                     Thread.sleep(4000);
                     keyCTRLA();
                     Thread.sleep(4000);
                     keyCTRLA();
                     Thread.sleep(6000);
                      libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItem"), strItemNumber, "Item Number");
                     pressEnter();
                     Thread.sleep(4000);
                      libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemQty"), strLPNqty[intLoop], "Item Qty");
                     pressEnter();
                     Thread.sleep(4000);
                     if(libManhattanCommonFunctions.verifyElementPresent("//*[contains(text(),'Overide: Qty > exceeds PO qty')]", "XPATH")){
             			report.updateTestLog("RFMenu Page", "SKU is not on PO", Status.PASS);
             		}else{
             			report.updateTestLog("RFMenu Page", "SKU is available on PO", Status.FAIL);
             		}
               }
               

        }
        else{
               Thread.sleep(1000);
               libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxLPN"), strLPN, "LPN");
               pressEnter();
               Thread.sleep(4000);
               keyCTRLA();
               Thread.sleep(4000);
               keyCTRLA();
               Thread.sleep(4000);
               libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItem"), strItemNumber, "Item Number");
               pressEnter();
               Thread.sleep(4000);
               libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtboxItemQty"),strItemQty, "Item Qty");
               pressEnter(); 
               Thread.sleep(4000);
        }

 }
	
	/**
	 *********************************************************************** 
	 * Function validates the yard task ID
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strTrailer, strDestinationLocation
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateInvalidTaskID(String strTaskchoice) throws InterruptedException {
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("TaskChoice"), strTaskchoice, "Task Choice");
		libManhattanCommonFunctions.waitForElementClickable("//span[@value='Enter']", 4000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnter"),"Enter Button");
		if(libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'Invalid Choice.')]", "XPATH")){
			report.updateTestLog("RFMenu Page", "Invalid Choice, task cannot be executed", Status.PASS);
		}else{
			report.updateTestLog("RFMenu Page", "Task choice is valid", Status.FAIL);
		}

	}

	
	
	/**
	 *********************************************************************** 
	 * Function validates the yard move location
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strTrailer, strDestinationLocation
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateYardMoveLocation(String strTrailer, String strDestinationLocation) throws InterruptedException {
		libManhattanCommonFunctions.waitForElementClickable("//input[@id='dataForm:yms_rf_mt_input2']", 4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Trailer"), strTrailer, "Trailer");
		libManhattanCommonFunctions.waitForElementClickable("//input[@id='dataForm:yms_rf_mt_input3']", 4000);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DestinationLocation"), strDestinationLocation, "Destination Location");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnter"),"Enter Button");
		libManhattanCommonFunctions.waitForElementClickable("//span[@value='Enter']", 4000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnEnter"),"Enter Button");
		if(libManhattanCommonFunctions.verifyElementPresent("//span[contains(text(),'Location is in use. Please choose another location.')]", "XPATH")){
			report.updateTestLog("RFMenu Page", "Location is in use. Please choose another location", Status.PASS);
		}else{
			report.updateTestLog("RFMenu Page", "Error message location in use is not displayed", Status.FAIL);
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
//   @SuppressWarnings("null")
     public String[] getMultipleTaskId() throws Exception
     {
            
            Thread.sleep(2000);
            WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:lview:dataTable_body']"));
            List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR")); 
            System.out.println("Task : "+(wbTRList.size()-1));
            String strTaskId[] = new String[(wbTRList.size()-1)];
            String strTaskGrp[] = new String[(wbTRList.size()-1)];
            String strItemNum[] = new String[(wbTRList.size()-1)];
            for(int intPointr=0; intPointr<(wbTRList.size()- 1); intPointr++)
            {
            strTaskId[intPointr] = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:"+intPointr+":taskIdVal']", "XPATH").getText();
            strTaskGrp[intPointr] = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:lview:dataTable:"+intPointr+":descVal1']", "XPATH").getText();
            strItemNum[intPointr] = libManhattanCommonFunctions.getElementByProperty("//a[@id='dataForm:lview:dataTable:"+intPointr+":ItemBOMDetailsListEV_item_popup_button']", "XPATH").getText();
            
//            System.out.println(strTaskId[intPointr]);
            System.out.println(strTaskId[intPointr]+"  : "+strTaskGrp[intPointr]+"  : "+strItemNum[intPointr]);
            }
            return strTaskId;    
     }


}














