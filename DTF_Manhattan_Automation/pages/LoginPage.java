package pages;

import org.openqa.selenium.WebElement;
import supportlibraries.ScriptHelper;
import com.cognizant.framework.Status;


import functionallibraries.ManhattanCommonFunctions;

/**
 * Any Manhattan Page class
 * @author Cognizant
 */
public class LoginPage extends AnyManhattanPage
{		
	/*******************************Declaration of objects for AnyManhattanPage**************************************/ 
	WebElement imgManhattanLogo;
	WebElement lblUserName,lblPassword,btnLogin;
	
	


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public LoginPage(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		try{
			lblUserName = libManhattanCommonFunctions.getElementByProperty("j_username", "NAME");
			lblPassword = libManhattanCommonFunctions.getElementByProperty("j_password", "NAME");
			btnLogin = libManhattanCommonFunctions.getElementByProperty("button-1022-btnInnerEl", "ID");
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
		if (getCurrentPage("LoginPage"))
			report.updateTestLog("Login Page verification", "Login page loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Login Page verification", "Login page loaded not loaded!!!!", Status.FAIL);
	}

	/**
	 * To use switch case we are declaring the below enum for MyAccount,Login,Logout,MiniCart 
	 */
	private enum enumPageObjects
	{
		
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: MyAccount,Login,Logout,MiniCart,Items,Paper,Notebooks,Postits,Filing,Binding,Organizers,Pens,Tape,DeskSupplies
	 * 			Envelopes,Labels,Mailing,PCs,Drives,Accessories,Tech,Business,Printers,Shredders,Machines,Furniture,Chairs,Cabinets
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
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	}

	
	/**
	 *********************************************************************** 
	 * Function to login.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Jayashree
	 * @param 	strUserName,strPassword
	 * @version 1.0
	 ***********************************************************************
	 */
	public void loginWithValidUser(String strUserName, String strPassword){
		try{
			libManhattanCommonFunctions.clearAndUpdateAnyElement(lblUserName, strUserName, "UerName");
			libManhattanCommonFunctions.clearAndUpdateAnyElement(lblPassword, strPassword, "Password");
			libManhattanCommonFunctions.waitForElementClickable(".//*[@id='button-1022-btnInnerEl']", 4000);
			libManhattanCommonFunctions.clickAnyElement(btnLogin, "Login Button");
		}catch(Exception e){
			report.updateTestLog("Login Page", "Element Not Found", Status.FAIL);
		}
	}


} 	



