package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LaunchApp {


    AppiumDriver driver;

    public AppiumDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public String init() throws MalformedURLException {
        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), getCapabilities());

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));

        String pageTitle = driver.findElement(By.className("android.widget.TextView")).getText();
        assertEquals("TheMovies", pageTitle);

        return pageTitle;

    }

    public DesiredCapabilities getCapabilities() throws MalformedURLException {

        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","uiautomator2");
        caps.setCapability("platformVersion", "14.0");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("appium:appActivity","com.skydoves.themovies");

        driver =new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);


        return caps;
    }
}
