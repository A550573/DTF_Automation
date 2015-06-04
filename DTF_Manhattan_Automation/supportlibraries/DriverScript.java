package supportlibraries;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import com.cognizant.framework.*;
import com.cognizant.framework.ReportThemeFactory.Theme;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;


/**
 * Driver script class which encapsulates the core logic of the CRAFT framework
 * @author Cognizant
 */
public abstract class DriverScript 
{
	private int currentIteration;
	private Date startTime, endTime;
	private String timeStamp;
	private String reportPath;
	
	protected CraftliteDataTable dataTable;
	protected ReportSettings reportSettings;
	protected SeleniumReport report;
	protected WebDriver driver;
	protected ScriptHelper scriptHelper;
	
	protected Properties properties;
	private ExecutionMode executionMode;
	private FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
	
	/**
	 * The {@link SeleniumTestParameters} object
	 */
	protected SeleniumTestParameters testParameters = new SeleniumTestParameters();
	
	
	/**
	 * Constructor to initialize the DriverScript
	 */
	public DriverScript()
	{
		startTime = Util.getCurrentTime();
		setRelativePath();
		properties = Settings.getInstance();
		setDefaultTestParameters();
	}
	
	private void setRelativePath()
	{
		String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath();
		if(relativePath.contains("allocator")) {
			relativePath = new File(System.getProperty("user.dir")).getParent();
		}
		frameworkParameters.setRelativePath(relativePath);
	}
	
	private void setDefaultTestParameters()
	{
		testParameters.setCurrentTestcase(this.getClass().getSimpleName());
		testParameters.setCurrentScenario(this.getClass().getPackage().getName().substring(12));
		testParameters.setIterationMode(IterationOptions.RunAllIterations);
		testParameters.setBrowser(Browser.valueOf(properties.getProperty("DefaultBrowser")));
		testParameters.setPlatform(Platform.valueOf(properties.getProperty("DefaultPlatform")));
	}
	
	/**
	 * Function to execute the given test case
	 */
	public void driveTestExecution()
	{
		initializeWebDriver();
		initializeTestIterations();
		initializeTestReport();
		initializeDatatable();
		initializeTestScript();
		
		setUp();
		
		executeTestIterations();
		tearDown();
		
		quitWebDriver();
		wrapUp();
	}
	
	private void initializeWebDriver()
	{
		executionMode = ExecutionMode.valueOf(properties.getProperty("ExecutionMode"));
		
		switch(executionMode) {
		case Local:
			driver = WebDriverFactory.getDriver(testParameters.getBrowser());
			break;
			
		case Remote:
			driver = WebDriverFactory.getDriver(testParameters.getBrowser(),
													properties.getProperty("RemoteUrl"));
			break;
			
		case Grid:
			driver = WebDriverFactory.getDriver(testParameters.getBrowser(),
													testParameters.getBrowserVersion(),
													testParameters.getPlatform(),
													properties.getProperty("RemoteUrl"));
			break;
		}
	}
	
	private synchronized void initializeTestIterations()
	{
		switch(testParameters.getIterationMode()) {
		case RunAllIterations:
			String datatablePath = frameworkParameters.getRelativePath() +
			Util.getFileSeparator() + "Datatables";
			ExcelDataAccess testDataAccess =
					new ExcelDataAccess(datatablePath, testParameters.getCurrentScenario());
			testDataAccess.setDatasheetName(properties.getProperty("DefaultDataSheet"));
			int nIterations = testDataAccess.getRowCount(testParameters.getCurrentTestcase(), 0);
			testParameters.setEndIteration(nIterations);
			
			currentIteration = 1;
			break;
			
		case RunOneIterationOnly:
			currentIteration = 1;
			break;
			
		case RunRangeOfIterations:
			if(testParameters.getStartIteration() > testParameters.getEndIteration()) {
				throw new FrameworkException("Error","StartIteration cannot be greater than EndIteration!");
			}
			currentIteration = testParameters.getStartIteration();
			break;
		}
	}
	
	private void initializeTestReport()
	{
		frameworkParameters.setRunConfiguration(properties.getProperty("RunConfiguration"));
		timeStamp = TimeStamp.getInstance();
		
		initializeReportSettings();
		ReportTheme reportTheme =
				ReportThemeFactory.getReportsTheme(Theme.valueOf(properties.getProperty("ReportsTheme")));
		
		report = new SeleniumReport(reportSettings, reportTheme);
		
		report.initialize();
		report.setDriver(driver);
		
		report.initializeTestLog();
		report.addTestLogHeading(reportSettings.getProjectName() +
									" - " + reportSettings.getReportName() +
									" Automation Execution Results");
		report.addTestLogSubHeading("Date & Time",
										": " + Util.getCurrentFormattedTime(properties.getProperty("DateFormatString")),
										"Iteration Mode", ": " + testParameters.getIterationMode());
		report.addTestLogSubHeading("Start Iteration", ": " + testParameters.getStartIteration(),
									"End Iteration", ": " + testParameters.getEndIteration());
		
		switch(executionMode) {
		case Local:
			report.addTestLogSubHeading("Browser", ": " + testParameters.getBrowser(),
					"Executed on", ": " + "Local Machine");
			break;
			
		case Remote:
			report.addTestLogSubHeading("Browser", ": " + testParameters.getBrowser(),
					"Executed on", ": " + properties.getProperty("RemoteUrl"));
			break;
			
		case Grid:
			String browserVersion = testParameters.getBrowserVersion();
			if (browserVersion == null) {
				browserVersion = "Not specified";
			}
			report.addTestLogSubHeading("Browser", ": " + testParameters.getBrowser(),
					"Version", ": " + browserVersion);
			report.addTestLogSubHeading("Platform", ": " + testParameters.getPlatform().toString(),
					"Executed on", ": " + "Grid @ " + properties.getProperty("RemoteUrl"));
			break;
		}
		
		report.addTestLogTableHeadings();
	}
	
	private void initializeReportSettings()
	{
		reportPath = frameworkParameters.getRelativePath() +
							Util.getFileSeparator() +	"Results" +
							Util.getFileSeparator() + timeStamp;
		
		reportSettings = new ReportSettings(reportPath,
										testParameters.getCurrentScenario() +
										"_" + testParameters.getCurrentTestcase());
		
		reportSettings.setDateFormatString(properties.getProperty("DateFormatString"));
		reportSettings.setLogLevel(Integer.parseInt(properties.getProperty("LogLevel")));
		reportSettings.setProjectName(properties.getProperty("ProjectName"));
		reportSettings.generateExcelReports =
				Boolean.parseBoolean(properties.getProperty("ExcelReport"));
		reportSettings.generateHtmlReports =
				Boolean.parseBoolean(properties.getProperty("HtmlReport"));
		reportSettings.takeScreenshotFailedStep =
				Boolean.parseBoolean(properties.getProperty("TakeScreenshotFailedStep"));
		reportSettings.takeScreenshotPassedStep =
				Boolean.parseBoolean(properties.getProperty("TakeScreenshotPassedStep"));
	}
	
	private void initializeDatatable()
	{
		String datatablePath = frameworkParameters.getRelativePath() +
									Util.getFileSeparator() + "Datatables";
		
		String runTimeDatatablePath;
		Boolean includeTestDataInReport =
				Boolean.parseBoolean(properties.getProperty("IncludeTestDataInReport"));
		if (includeTestDataInReport) {
			runTimeDatatablePath = reportPath + Util.getFileSeparator() + "Datatables";
			
			File runTimeDatatable = new File(runTimeDatatablePath + Util.getFileSeparator() +
									testParameters.getCurrentScenario() + ".xls");
			if (!runTimeDatatable.exists()) {
				File datatable = new File(datatablePath + Util.getFileSeparator() +
										testParameters.getCurrentScenario() + ".xls");
				
				try {
					FileUtils.copyFile(datatable, runTimeDatatable);
				} catch (IOException e) {
					e.printStackTrace();
					throw new FrameworkException("Error in creating run-time datatable: Copying the datatable failed...");
				}
			}
			
			File runTimeCommonDatatable = new File(runTimeDatatablePath +
													Util.getFileSeparator() +
													"Common Testdata.xls");
			if (!runTimeCommonDatatable.exists()) {
				File commonDatatable = new File(datatablePath +
										Util.getFileSeparator() + "Common Testdata.xls");
				
				try {
					FileUtils.copyFile(commonDatatable, runTimeCommonDatatable);
				} catch (IOException e) {
					e.printStackTrace();
					throw new FrameworkException("Error in creating run-time datatable: Copying the common datatable failed...");
				}
			}
		} else {
			runTimeDatatablePath = datatablePath;
		}
		
		dataTable = new CraftliteDataTable(runTimeDatatablePath, testParameters.getCurrentScenario());
		dataTable.setDataReferenceIdentifier(properties.getProperty("DataReferenceIdentifier"));
		
		dataTable.setCurrentRow(testParameters.getCurrentTestcase(), currentIteration);
	}
	
	private void initializeTestScript()
	{
		/*FileReader hostInFileRead;
		FileWriter hostOutFileRead;
		String strHostFilePath = "C:\\Windows\\System32\\drivers\\etc\\hosts", strLibFilePath = null;*/
		scriptHelper = new ScriptHelper(dataTable, report, driver);
		
	}
	
	/**
	 * Function to do required setup activities before starting the test execution
	 */
	protected abstract void setUp();
	
	private void executeTestIterations()
	{
		while(currentIteration <= testParameters.getEndIteration()) {
			report.addTestLogSection("Iteration: " + Integer.toString(currentIteration));
			try {
				
				System.out.println("Execution of '" + testParameters.getCurrentTestcase() + "' started");
				executeTestCase();
				System.out.println(testParameters.getCurrentTestcase() + "'--> STATUS --> " + report.testStatus);
			} catch (FrameworkException fx) {
				System.out.println("Execution of '" + testParameters.getCurrentTestcase() + "' failed.Reason - " + fx.getMessage());
				exceptionHandler(fx, fx.errorName);
			}  catch (Exception ex) {
				System.out.println(testParameters.getCurrentTestcase() + "' failed.Reason-" + ex.getMessage());
				exceptionHandler(ex, "Error");
			} 
			
			currentIteration++;
			dataTable.setCurrentRow(testParameters.getCurrentTestcase(), currentIteration);
		}
	}
	
	/**
	 * Function which implements the test case to be automated
	 * @throws Exception 
	 */
	protected abstract void executeTestCase() throws Exception;
	
	/**
	 * Function to do required teardown activities at the end of the test execution
	 */
	protected abstract void tearDown();
	
	private void exceptionHandler(Exception ex, String exceptionName)
	{
		// Error reporting
		String exceptionDescription = ex.getMessage();
		if(exceptionDescription == null) {
			exceptionDescription = ex.toString();
		}
		
		if(ex.getCause() != null) {
			report.updateTestLog(exceptionName, exceptionDescription + " <b>Caused by: </b>" +
					ex.getCause(), Status.FAIL);
		} else {
			report.updateTestLog(exceptionName, exceptionDescription, Status.FAIL);
		}
		ex.printStackTrace();
		
		// Error response
		if (frameworkParameters.getStopExecution()) {
			report.updateTestLog("CRAFTLite Info",
					"Test execution terminated by user! All subsequent tests aborted...",
					Status.DONE);
		} else {
			OnError onError = OnError.valueOf(properties.getProperty("OnError"));
			switch(onError) {
			case NextIteration:
				report.updateTestLog("CRAFTLite Info", "Test case iteration terminated by user! Proceeding to next iteration (if applicable)...", Status.DONE);
				currentIteration++;
				executeTestIterations();
				break;
				
			case NextTestCase:
				report.updateTestLog("CRAFTLite Info", "Test case terminated by user! Proceeding to next test case (if applicable)...", Status.DONE);
				break;
				
			case Stop:
				frameworkParameters.setStopExecution(true);
				break;
			}
		}
		
		// Wrap up execution
		tearDown();
		quitWebDriver();
		wrapUp();
	}
	
	private void quitWebDriver()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	private void wrapUp()
	{
		endTime = Util.getCurrentTime();
		closeTestReport();
		
		if(report.getTestStatus().equalsIgnoreCase("Failed")) {
			Assert.fail(report.getFailureDescription());
		}
	}
	
	private void closeTestReport()
	{
		String executionTime = Util.getTimeDifference(startTime, endTime);
		report.addTestLogFooter(executionTime);
	}
}