package commons;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
//		System.out.println("starting::::: "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("success::::: "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("failed::::: "+result.getName());
	}

}
