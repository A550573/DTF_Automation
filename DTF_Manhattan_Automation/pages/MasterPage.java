package pages;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;


/**
 * MasterPage Abstract class
 * @author Cognizant
 */
abstract class MasterPage extends ReusableLibrary
{		
	/**
	 * Constructor to initialize the functional library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 */
	protected MasterPage(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		initializeUIMap();
	}	
	/**
	 * Function to initialize the UI Map
	 */
	protected abstract void initializeUIMap();
}