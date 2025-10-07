package com.mesh01.steps;

import Utility.LogCollector;
import com.mesh01.DriverInit;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseSteps {

    public static void logMessagewithoutscreenshot(String message) {
        Allure.step(message);
        LogCollector.addLog(message);
    }

    public static void logMessageWithScreenshot(String message) {
        Allure.step(message, () -> {
            LogCollector.addLog(message);
            return attachScreenshot();

        });
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot() {
        if (DriverInit.getDriverThread() instanceof TakesScreenshot) {
            try {
                return ((TakesScreenshot) DriverInit.getDriverThread()).getScreenshotAs(OutputType.BYTES);
            } catch (Exception e) {
                // Optionally log the error
            }
        }
        // Optionally log a warning if screenshot is not available
        return new byte[0];
    }
}