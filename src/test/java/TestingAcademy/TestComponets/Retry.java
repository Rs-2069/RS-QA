package TestingAcademy.TestComponets;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	public int count =0;
	public int maxtry =2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
	if(count<maxtry)
	{
		count++;
		return true;
	}
		return false;
	}

}