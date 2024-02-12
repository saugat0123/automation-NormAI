package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import commons.BaseClass;

public class CaptureScreenshot extends BaseClass{
	
	public void getScreenshot() throws IOException {
		Date currentDateTime = new Date();
		String screenshotName = currentDateTime.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshots//"+ screenshotName +".png"));

		
	}

}
