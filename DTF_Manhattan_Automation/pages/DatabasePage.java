package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class DatabasePage extends MasterPage {
	/******************************* Declaration of objects for AnyManhattanPage **************************************/
	WebElement imgManhattanLogo;
	WebElement txtSearchbox;
	WebElement btnSearch, btnCheckout;
	WebElement optVariation;
	WebElement lnkViewShoppingBag;
	ManhattanCommonFunctions libManhattanCommonFunctions;
	public DatabasePage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		try {
			report.updateTestLog("Database Connectivity","Database loaded as expected.", Status.DONE);
		} catch (Exception e) {

		}
	}

	@Override
	protected void initializeUIMap() {
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("DatabasePage")){
			report.updateTestLog("Database verification","Database loaded as expected.", Status.DONE);
		}
		else{			
		}
	}	
	private enum enumPageObjects {		

	}

	private WebElement getPageElement(String strElemName) {
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			}

		} catch (Exception e) {

		}
		return elemToFind;
	}

	public enum enumPageName {

	}

	public boolean getCurrentPage(String strPageName) {

		try {

			switch (enumPageName.valueOf(strPageName)) {		
			}
		} catch (Exception e) {
			return false;
		}
		return false;

	}
}