package Utility;

import com.defaultproject.DriverInit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

    /*
    To Take the screenshot utilty this use the type casting fo driver as driver do not have
    screenshot method so now we can use type cast when required this is typecasting
     */

    public static String takeScreenshot() {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) DriverInit.getDriverThread();
            String userDir = System.getProperty("user.dir");
            String dayWiseFolderPath = DayWiseFolderUtility.getDayWiseFolderPath(userDir + File.separator + "Screenshots");
            String timestamp = new SimpleDateFormat("HHmmssSSS").format(new Date());
            String screenshotPath = dayWiseFolderPath + File.separator + "screenshot_" + timestamp + ".png";
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotPath);
            FileUtils.copyFile(source, destination);
            return screenshotPath; // Return the file path for use in reports
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}