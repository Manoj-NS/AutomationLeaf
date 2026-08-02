package leaf_utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	public static String captureScreenshot(WebDriver driver, String fileName) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String timeStamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String path="./screenshots/"+fileName+"_"+timeStamp+".jpeg";
		
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		
		return path;
		
	}

}
