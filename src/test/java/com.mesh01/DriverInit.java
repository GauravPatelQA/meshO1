package com.mesh01;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class DriverInit {

    final static Logger logger = LogManager.getLogger(DriverInit.class);

    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    public static ChromeOptions options;

    public static synchronized void initialization() {
        if (driverThread.get() == null) {
            logger.debug("Driver init " + Thread.currentThread().getName());
            options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driverThread.set(new ChromeDriver(options));
            driverThread.get().manage().window().maximize();
            driverThread.get().manage().deleteAllCookies();
            driverThread.get().manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
            logger.debug("Driver init done" + Thread.currentThread().getName());
        }
    }

    public static synchronized WebDriver getDriverThread() {
        logger.debug("Driver get " + Thread.currentThread().getName());
        if (driverThread.get() == null) {
            logger.error("!!!!no driver available !!! " + Thread.currentThread().getName());
        }
        return driverThread.get();
    }

    public static synchronized void quitDriver() {
        logger.debug("Driver close" + Thread.currentThread().getName());
        driverThread.get().quit();
        driverThread.remove();
    }
}