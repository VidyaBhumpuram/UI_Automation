package GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * This class provides implementation to iRetryAnalyser
 * @author Vidya
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
		int count =0;
		int retryCount = 3;//Manual analysis
		
		
		@Override
		public boolean retry(ITestResult result) {
			
			while(count<retryCount) {
				count ++;
				return true;
			}
			
			return false;
		}
		
		
}
