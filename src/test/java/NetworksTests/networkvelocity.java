package NetworksTests;

import androidPageObject.MoviesListPageAndriod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.mitmproxy.InterceptedMessage;
import io.appium.mitmproxy.MitmproxyJava;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class networkvelocity {

    private AppiumDriver driver;
    private MitmproxyJava proxy;
    public MoviesListPageAndriod LandingPage=new MoviesListPageAndriod();
    @After
    public void Quit() throws IOException, InterruptedException {
        proxy.stop();
        driver.quit();
    }

// to do  capture post requests during app is performing

    @Test
    public void captureAndroidEmulatorTrafficInCaseOfNoNetwork() throws IOException, URISyntaxException, InterruptedException, ExecutionException, TimeoutException {
        List<InterceptedMessage> messages = new ArrayList<InterceptedMessage>();

        // remember to set local OS proxy settings in the Network Preferences
        proxy = new MitmproxyJava("/opt/homebrew/bin/mitmdump", (InterceptedMessage m) -> {
            System.out.println("intercepted request for " + m.toString());
            messages.add(m);
            return m;
        });

        proxy.start();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","uiautomator2");
        caps.setCapability("platformVersion", "14.0");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("appium:appActivity","com.skydoves.themovies");
        caps.setCapability("proxy", proxy);
        caps.setCapability("networkProfile", "no-network");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        LandingPage.ClickOnMovieName(driver,"Barbie");

        Assert.assertFalse(messages.isEmpty());

        InterceptedMessage appiumIORequest = messages.stream().filter((m) -> m.requestURL.getPath().equals("/generate_204")).findFirst();

        assertTrue(appiumIORequest.responseCode == 204);
    }

    @Test
    public void captureAndroidEmulatorTrafficInCaseOf2GNetwork() throws IOException, URISyntaxException, InterruptedException, ExecutionException, TimeoutException {
        List<InterceptedMessage> messages = new ArrayList<InterceptedMessage>();

        // remember to set local OS proxy settings in the Network Preferences
        proxy = new MitmproxyJava("/opt/homebrew/bin/mitmdump", (InterceptedMessage m) -> {
            System.out.println("intercepted request for " + m.toString());
            messages.add(m);
            return m;
        });

        proxy.start();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","uiautomator2");
        caps.setCapability("platformVersion", "14.0");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("appium:appActivity","com.skydoves.themovies");
        caps.setCapability("proxy", proxy);
        caps.setCapability("networkProfile", "2g-gprs-good");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        LandingPage.ClickOnMovieName(driver,"Barbie");

        Assert.assertFalse(messages.isEmpty());

        InterceptedMessage appiumIORequest = messages.stream().filter((m) -> m.requestURL.getPath().equals("/generate_204")).findFirst();

        assertTrue(appiumIORequest.responseCode == 204);
    }
}