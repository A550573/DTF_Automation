package databaseaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.*;
import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

import com.cognizant.framework.Status;


public class AccessingSQLDataBase extends DatabasePage 
{			
	 static  Connection conn = null;
	 static Statement stmt ;
	
	public AccessingSQLDataBase(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		try {
			
		} catch (Exception e) {
			
		}
	}
	/**
	 *********************************************************************** 
	 * Function retreives Scheduled IDs and validates report from DB
	 * @return 	strTaskId 
	 * @Author  Rahman
	 * @param 	None
	 * @version 1.0
	 * @throws 	Exception 
	 ***********************************************************************
	 */
	public void getSCHD_IDandToteReport(String stroLPN[],String strToteNo[]) {

		int[] oLPN_REP_SCHD_ID=new int[stroLPN.length*2];
		int[] tote_REP_SCHD_ID=new int[strToteNo.length*2];
//		String[] createdDateandTime=new String[stroLPN.length*2];
		String[] oLPN_EventName=new String[stroLPN.length*2];        
		String[] tote_EventName=new String[strToteNo.length*2];
//		String strconnection= "jdbc:oracle:thin:@rcld11-scan:1522/WMSD24";
		 
		try {
			int intPointer=0,intRowPointer=0;			
			
			for(intPointer=0;intPointer<stroLPN.length;intPointer++)
			{
				ResultSet rsREP_SCHD_ID = stmt.executeQuery("select REP_SCHD_ID from lrf_rep_schd_param where filter_value1 in ('"+stroLPN[intPointer]+"')");                        
				while (rsREP_SCHD_ID.next()) {
					oLPN_REP_SCHD_ID[intRowPointer] = rsREP_SCHD_ID.getInt("REP_SCHD_ID");
					System.out.println(stroLPN[intPointer]+" "+oLPN_REP_SCHD_ID[intRowPointer]);
					report.updateTestLog("oLPN details DB Validation", " oLPN : "+stroLPN[intPointer]+" REP_SCHD_ID : "+oLPN_REP_SCHD_ID[intRowPointer], Status.PASS);
					intRowPointer++;
				}
			}      
			intRowPointer=0;
			for(intPointer=0;intPointer<(strToteNo.length);intPointer++)
			{
				
				ResultSet rsREP_SCHD_ID = stmt.executeQuery("select REP_SCHD_ID from lrf_rep_schd_param where filter_value1 in ('"+strToteNo[intPointer]+"')");                       
				while (rsREP_SCHD_ID.next()) {					
					tote_REP_SCHD_ID[intRowPointer] = rsREP_SCHD_ID.getInt("REP_SCHD_ID");
					report.updateTestLog("Tote details DB Validation", " Tote : "+strToteNo[intPointer]+" REP_SCHD_ID : "+tote_REP_SCHD_ID[intRowPointer], Status.PASS);
					System.out.println(strToteNo[intPointer]+" "+tote_REP_SCHD_ID[intRowPointer]);
					intRowPointer++;
				}
			}
			for(intPointer=0;intPointer<(oLPN_REP_SCHD_ID.length);intPointer++)
			{
				ResultSet rsCreatedDateandTime = stmt.executeQuery("select lrf_event_id, lrf_event_name, event_start_dttm, created_dttm from LRF_EVENT  where lrf_event_id in ('"+oLPN_REP_SCHD_ID[intPointer]+"')");
				while (rsCreatedDateandTime.next()) {
					//                        	 createdDateandTime[intPointer] = rsCreatedDateandTime.getString("event_start_dttm");
					oLPN_EventName[intPointer] = rsCreatedDateandTime.getString("lrf_event_name");
					//                         	System.out.println(createdDateandTime[intPointer]);
					report.updateTestLog("oLPN details DB Validation", " oLPN Event Name: "+oLPN_EventName[intPointer]+" REP_SCHD_ID : "+oLPN_REP_SCHD_ID[intPointer], Status.PASS);
					System.out.println(oLPN_REP_SCHD_ID[intPointer]+" "+oLPN_EventName[intPointer]);
				}
			}
			for(intPointer=0;intPointer<(tote_REP_SCHD_ID.length);intPointer++)
			{
				ResultSet rsCreatedDateandTime = stmt.executeQuery("select lrf_event_id, lrf_event_name, event_start_dttm, created_dttm from LRF_EVENT  where lrf_event_id in ('"+tote_REP_SCHD_ID[intPointer]+"')");
				while (rsCreatedDateandTime.next()) {
					//                        	 createdDateandTime[intPointer] = rsCreatedDateandTime.getString("event_start_dttm");
					tote_EventName[intPointer] = rsCreatedDateandTime.getString("lrf_event_name");
					//                         	System.out.println(createdDateandTime[intPointer]);
					report.updateTestLog("Tote details DB Validation", " Tote Event Name: "+tote_EventName[intPointer]+" REP_SCHD_ID : "+tote_REP_SCHD_ID[intPointer], Status.PASS);
					System.out.println(tote_REP_SCHD_ID[intPointer]+" "+tote_EventName[intPointer]);
				}
			}		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
	}
	/**
	 *********************************************************************** 
	 * Function splits the values and stores in array
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
	 * Function connects Database
	 * @return 	strTaskId 
	 * @Author  Rahman
	 * @param 	None
	 * @version 1.0
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws 	Exception 
	 ***********************************************************************
	 */
	public void connectDatabase(String strDBUsername,String strDBPassword,String strConnectionString) throws ClassNotFoundException, SQLException {		
		try{		
		Class.forName("oracle.jdbc.driver.OracleDriver");
//		strConnectionString= "jdbc:oracle:thin:@rcld11-scan:1522/WMSD24";
		conn = DriverManager.getConnection(strConnectionString,strDBUsername,strDBPassword);
//		conn = DriverManager.getConnection("jdbc:oracle:thin:@rcld11-scan:1522/WMSD24","WM_LM", "ZDQxNmIzOT");
		stmt = conn.createStatement();
		report.updateTestLog("DB Connection Details", " DB : "+strDBUsername+" is Connected.", Status.DONE);
		System.out.println("=========================");
		System.out.println("DB Connected");
		System.out.println("=========================");
		}
		catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		 }	
	}
	/**
	 *********************************************************************** 
	 * Function closes the Database Connection
	 * @return 	strTaskId 
	 * @Author  Rahman
	 * @param 	None
	 * @version 1.0
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws 	Exception 
	 ***********************************************************************
	 */
	public void closeDatabase() throws ClassNotFoundException, SQLException {		
		try{
			conn.close();
			report.updateTestLog("DB Connection Details", " DB Disconnected.", Status.DONE);
			System.out.println("=========================");
			System.out.println("DB Disconnected");
			System.out.println("=========================");
		}
		 catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
		 }	
	}
	/**
	 *********************************************************************** 
	 * Function retreives Instr Code and validates Promised Delivery Date
	 * @Author  Rahman
	 * @param 	stroLPN, strMisc_Instr_code
	 * @version 1.0
	 * @throws 	Exception 
	 ***********************************************************************
	 */
	public void getMISC_INSTR_CODE(String stroLPN, String strMisc_Instr_code) {

		String actualstrMisc_Instr_code = "";		
		 
		try {						
				ResultSet rsMISC_INSTR_CODE = stmt.executeQuery("select misc_instr_code_1 from lpn where tc_lpn_id = '"+stroLPN+"'");                        
				while (rsMISC_INSTR_CODE.next()) {
					actualstrMisc_Instr_code= rsMISC_INSTR_CODE.getString("misc_instr_code_1");
					System.out.println(actualstrMisc_Instr_code);									
				}	
				if(strMisc_Instr_code.trim().equals(actualstrMisc_Instr_code.trim())){
					report.updateTestLog("Promised Delivery Date Validation", " Misc_Instr_Code : "+actualstrMisc_Instr_code, Status.PASS);
				}
				else{
					report.updateTestLog("Promised Delivery Date Validation", " Expected Misc_Instr_Code : "+strMisc_Instr_code+" Actual Misc_Instr_Code : "+actualstrMisc_Instr_code, Status.FAIL);
				}					
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());	
			report.updateTestLog("Promised Delivery Date Validation", " Error Message : "+e.getMessage(), Status.FAIL);
		}	      
	}
	
	/**
	 *********************************************************************** 
	 * Function retreives values from DB and validates
	 * @return 	strTaskId 
	 * @Author  Rahman
	 * @param 	None
	 * @version 1.0
	 * @throws 	Exception 
	 ***********************************************************************
	 */
	public void getWaveCapacitiesValue(String strWaveNumber,String strMinSinglesOrders,String strMinSinglesUnits,String strMaxSinglesOrders,String strMaxSinglesUnits,String strMinMultiLineOrders,String strMinMultiLineUnits,String strMinSinglesBypassiLPN,String strMaxMultiLineOrders,String strMaxMultiLineUnits) {		
		try {		
			String actualMinSinglesOrders,actualMinSinglesUnits,actualMaxSinglesOrders,actualMaxSinglesUnits,actualMinMultiLineOrders,actualMinMultiLineUnits,actualMinSinglesBypassiLPN,actualMaxMultiLineOrders,actualMaxMultiLineUnits;			
			ResultSet rsREP_SCHD_ID = stmt.executeQuery("select c_min_ord_sngl, c_min_units_sngl, c_max_ord_sngl, c_max_units_sngl, c_min_ord_multi, c_min_units_multi,c_min_sbp_olpns, c_max_ord_multi, c_max_units_multi from WAVE_PARM where WAVE_NBR ='"+strWaveNumber+"'");                              
			while (rsREP_SCHD_ID.next()) {
				actualMinSinglesOrders = rsREP_SCHD_ID.getString("c_min_ord_sngl");
				actualMinSinglesUnits = rsREP_SCHD_ID.getString("c_min_units_sngl");
				actualMaxSinglesOrders = rsREP_SCHD_ID.getString("c_max_ord_sngl");
				actualMaxSinglesUnits = rsREP_SCHD_ID.getString("c_max_units_sngl");
				actualMinMultiLineOrders = rsREP_SCHD_ID.getString("c_min_ord_multi");
				actualMinMultiLineUnits = rsREP_SCHD_ID.getString("c_min_units_multi");
				actualMinSinglesBypassiLPN = rsREP_SCHD_ID.getString("c_min_sbp_olpns");
				actualMaxMultiLineOrders = rsREP_SCHD_ID.getString("c_max_ord_multi");
				actualMaxMultiLineUnits = rsREP_SCHD_ID.getString("c_max_units_multi");
//				System.out.println();
				if(strMinSinglesOrders.trim().equals(actualMinSinglesOrders.trim())&&strMinSinglesUnits.trim().equals(actualMinSinglesUnits.trim())&&strMaxSinglesOrders.trim().equals(actualMaxSinglesOrders.trim())&&strMaxSinglesUnits.trim().equals(actualMaxSinglesUnits.trim())&&strMinMultiLineOrders.trim().equals(actualMinMultiLineOrders.trim())&&strMinMultiLineUnits.trim().equals(actualMinMultiLineUnits.trim())&&strMinSinglesBypassiLPN.trim().equals(actualMinSinglesBypassiLPN.trim())&&strMaxMultiLineOrders.trim().equals(actualMaxMultiLineOrders.trim())&&strMaxMultiLineUnits.trim().equals(actualMaxMultiLineUnits.trim())){
					 report.updateTestLog("Wave capacities validation", "MinSinglesOrders : "+actualMinSinglesOrders+" || MinSinglesUnits : "+actualMinSinglesUnits+" || MaxSinglesOrders : "+actualMaxSinglesOrders+" || MaxSinglesUnits : "+actualMaxSinglesUnits+" || MinMultiLineOrders : "+actualMinMultiLineOrders+" || MinMultiLineUnits : "+actualMinMultiLineUnits+" || MaxMultiLineOrders : "+actualMaxMultiLineOrders+" || MaxMultiLineUnits : "+actualMaxMultiLineUnits+" || MinSinglesBypassiLPN : "+actualMinSinglesBypassiLPN, Status.PASS);
				}
				else{
					report.updateTestLog("Wave capacities validation", "Expected MinSinglesOrders : "+strMinSinglesOrders+" || Actual MinSinglesOrders : "+actualMinSinglesOrders+" || Expected MinSinglesUnits : "+strMinSinglesUnits+"|| Actual MinSinglesUnits : "+actualMinSinglesUnits+" || Expected MaxSinglesOrders : "+strMaxSinglesOrders+"|| Actual MaxSinglesOrders : "+actualMaxSinglesOrders+" || Expected MaxSinglesUnits : "+strMaxSinglesUnits+" || Actual MaxSinglesUnits : "+actualMaxSinglesUnits+"Expected MinMuliLineOrders : "+strMinMultiLineOrders+" || Actual MinMultiLineOrders : "+actualMinMultiLineOrders+"Expected MinMultiLineUnits : "+strMinMultiLineUnits+" || Actaul MinMultiLineUnits : "+actualMinMultiLineUnits+" || Expected MaxMultiLineOrders : "+strMaxMultiLineOrders+" || Actual MaxMultiLineOrders : "+actualMaxMultiLineOrders+"Expected MaxMultiLineUnits : "+strMaxMultiLineUnits+" || Actual MaxMultiLineUnits : "+actualMaxMultiLineUnits+"Expected MinSinglesBypassiLPN : "+strMinSinglesBypassiLPN+" || Actual MinSinglesBypassiLPN : "+actualMinSinglesBypassiLPN, Status.FAIL);
				}
//				report.updateTestLog("Wave Capacities Validation", " oLPN : "+stroLPN[intPointer]+" REP_SCHD_ID : "+oLPN_REP_SCHD_ID[intRowPointer], Status.PASS);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
//			report.updateTestLog("SQL Exception", " "+e.printStackTrace(), Status.FAIL);
		}	      
	}
}