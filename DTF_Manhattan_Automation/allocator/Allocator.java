package allocator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.Platform;

import supportlibraries.*;

import com.cognizant.framework.*;
import com.cognizant.framework.ReportThemeFactory.Theme;


/**
 * Class to manage the batch execution of test scripts within the framework
 * @author Cognizant
 * @version 3.0
 * @since October 2011
 */
public class Allocator
{
	private static ArrayList<SeleniumTestParameters> testInstancesToRun;
	private static SeleniumReport report;
	private static Properties properties;
	private static FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
	
	private static Date startTime, endTime;
	private static ReportSettings reportSettings;
	private static String timeStamp;
	private static String reportPath;
	private static ResultSet getExecutionRowInfo(String sSheetName)
	{
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String path= frameworkParameters.getRelativePath()+"\\Run Manager.xls";
		Connection connection = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ="+ path + ";DriverID=22;READONLY=false;");
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from ["+sSheetName+"$] where Execute='Yes'");
		return rs;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	public static void main(String[] args) throws Exception
	{
		setRelativePath();			
		initializeTestBatch();
		initializeSummaryReport();
		setupErrorLog();		
		driveBatchExecution();		
		wrapUp();
	}
	
	private static void setRelativePath()
	{
		String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath();
		if(relativePath.contains("allocator")) {
			relativePath = new File(System.getProperty("user.dir")).getParent();
		}
		frameworkParameters.setRelativePath(relativePath);
	}
	
	private static void initializeTestBatch()throws Exception
	{
		startTime = Util.getCurrentTime();
		
		properties = Settings.getInstance();
		testInstancesToRun = getRunInfo(properties.getProperty("RunConfiguration"));
	}
	
	private static void initializeSummaryReport()
	{
		frameworkParameters.setRunConfiguration(properties.getProperty("RunConfiguration"));
		timeStamp = TimeStamp.getInstance();
		
		reportSettings = initializeReportSettings();
		ReportTheme reportTheme =
				ReportThemeFactory.getReportsTheme(Theme.valueOf(properties.getProperty("ReportsTheme")));
		report = new SeleniumReport(reportSettings, reportTheme);
		
		report.initialize();
				
		report.initializeResultSummary();
		report.addResultSummaryHeading(reportSettings.getProjectName() +
											" - " +	" Automation Execution Result Summary");
		report.addResultSummarySubHeading("Date & Time",
										": " + Util.getCurrentFormattedTime(properties.getProperty("DateFormatString")),
										"OnError", ": " + properties.getProperty("OnError"));
		
		report.addResultSummaryTableHeadings();

	}
	
	private static ReportSettings initializeReportSettings()
	{
		reportPath = frameworkParameters.getRelativePath() +
						Util.getFileSeparator() + "Results" +
						Util.getFileSeparator() + timeStamp;
		ReportSettings reportSettings = new ReportSettings(reportPath, "");
		
		reportSettings.setDateFormatString(properties.getProperty("DateFormatString"));
		reportSettings.setProjectName(properties.getProperty("ProjectName"));
		reportSettings.generateExcelReports = Boolean.parseBoolean(properties.getProperty("ExcelReport"));
		reportSettings.generateHtmlReports = Boolean.parseBoolean(properties.getProperty("HtmlReport"));
		return reportSettings;
	}
	
	private static void setupErrorLog() throws FileNotFoundException
	{
		String errorLogFile = reportPath + Util.getFileSeparator() + "ErrorLog.txt";
		System.setErr(new PrintStream(new FileOutputStream(errorLogFile)));
	}
	
	/*private static ArrayList<SeleniumTestParameters> getRunInfo(String sheetName)
	{
		ExcelDataAccess runManagerAccess = new ExcelDataAccess(frameworkParameters.getRelativePath(), "Run Manager");			
		runManagerAccess.setDatasheetName(sheetName);
		
		int nTestInstances = runManagerAccess.getLastRowNum();
		ArrayList<SeleniumTestParameters> testInstancesToRun = new ArrayList<SeleniumTestParameters>();
		
		for (int currentTestInstance = 1; currentTestInstance <= nTestInstances; currentTestInstance++) {
			String executeFlag = runManagerAccess.getValue(currentTestInstance, "Execute");
			
			if (executeFlag.equalsIgnoreCase("Yes")) {
				SeleniumTestParameters testParameters = new SeleniumTestParameters();
				
				testParameters.setCurrentScenario(runManagerAccess.getValue(currentTestInstance, "Test_Scenario"));
				testParameters.setCurrentTestcase(runManagerAccess.getValue(currentTestInstance, "Test_Case"));
				testParameters.setCurrentTestDescription(runManagerAccess.getValue(currentTestInstance, "Description"));
				
				testParameters.setIterationMode(IterationOptions.valueOf(runManagerAccess.getValue(currentTestInstance, "Iteration_Mode")));
				String startIteration = runManagerAccess.getValue(currentTestInstance, "Start_Iteration");
				if (!startIteration.equals("")) {
					testParameters.setStartIteration(Integer.parseInt(startIteration));
				}
				String endIteration = runManagerAccess.getValue(currentTestInstance, "End_Iteration");
				if (!endIteration.equals("")) {
					testParameters.setEndIteration(Integer.parseInt(endIteration));
				}
				
				String browser = runManagerAccess.getValue(currentTestInstance, "Browser");
				if (!browser.equals("")) {
					testParameters.setBrowser(Browser.valueOf(browser));
				}
				String browserVersion = runManagerAccess.getValue(currentTestInstance, "Browser_Version");
				if (!browserVersion.equals("")) {
					testParameters.setBrowserVersion(browserVersion);
				}
				String platform = runManagerAccess.getValue(currentTestInstance, "Platform");
				if (!platform.equals("")) {
					testParameters.setPlatform(Platform.valueOf(platform));
				}
				
				testInstancesToRun.add(testParameters);
			}
		}
		
		return testInstancesToRun;
	}*/
	

	private static ArrayList<SeleniumTestParameters> getRunInfo(String sheetName)throws SQLException
	{
		ResultSet rs = getExecutionRowInfo(sheetName);
		//System.out.println("The result set "+rs+" and the count is "+rs.getRow());
		ArrayList<SeleniumTestParameters> testInstancesToRun = new ArrayList<SeleniumTestParameters>();
		while(rs.next()){
			SeleniumTestParameters testParameters = new SeleniumTestParameters();
			
			testParameters.setCurrentScenario(rs.getString("Test_Scenario"));
			testParameters.setCurrentTestcase(rs.getString("Test_Case"));
			testParameters.setCurrentTestDescription(rs.getString("Description"));
			
			testParameters.setIterationMode(IterationOptions.valueOf(rs.getString("Iteration_Mode")));
			/*String startIteration = rs.getString("Start_Iteration");
			if (!startIteration.equals("")) {
				testParameters.setStartIteration(Integer.parseInt(startIteration));
			}
			String endIteration = rs.getString("End_Iteration");
			if (!endIteration.equals("")) {
				testParameters.setEndIteration(Integer.parseInt(endIteration));
			}*/
			
			String browser = rs.getString("Browser");
			if (!browser.equals("")) {
				testParameters.setBrowser(Browser.valueOf(browser));
			}
//			String browserVersion = rs.getString( "Browser_Version");
//			if (!browserVersion.equals("")) {
//				testParameters.setBrowserVersion(browserVersion);
//			}
//			String platform = rs.getString( "Platform");
//			if (!platform.equals("")) {
//				testParameters.setPlatform(Platform.valueOf(platform));
//			}
				
		
			testInstancesToRun.add(testParameters);

		}
		return testInstancesToRun;
	}
	private static void driveBatchExecution()
	{
		int nThreads = Integer.parseInt(properties.getProperty("NumberOfThreads"));
		ExecutorService parallelExecutor = Executors.newFixedThreadPool(nThreads);
		
		for (int currentTestInstance = 0; currentTestInstance < testInstancesToRun.size() ; currentTestInstance++ ) {
			ParallelRunner testRunner =	new ParallelRunner(testInstancesToRun.get(currentTestInstance), report);
			parallelExecutor.execute(testRunner);
			
			if(frameworkParameters.getStopExecution()) {
				break;
			}
		}
		
		parallelExecutor.shutdown();
		while(!parallelExecutor.isTerminated()) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void wrapUp()
	{
		endTime = Util.getCurrentTime();
		closeSummaryReport();
		
		if (reportSettings.generateHtmlReports) {
			try {
				Runtime.getRuntime().exec("RunDLL32.EXE shell32.dll,ShellExec_RunDLL " +
												reportPath + "\\HTML Results\\Summary.Html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (reportSettings.generateExcelReports) {
			try {
				Runtime.getRuntime().exec("RunDLL32.EXE shell32.dll,ShellExec_RunDLL " +
												reportPath + "\\Excel Results\\Summary.xls");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void closeSummaryReport()
	{
		String totalExecutionTime = Util.getTimeDifference(startTime, endTime);
		report.addResultSummaryFooter(totalExecutionTime);
	}
}