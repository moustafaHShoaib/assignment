package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class Capabilities extends LaunchApp {
    protected AndroidDriver androidDriver;
    private AppiumDriverLocalService service;
    protected void preparation() throws Exception {

        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        String service_url = service.getUrl().toString();
        System.out.println("Appium Service Address: " + service_url);
        androidDriver = new AndroidDriver(new URL(service_url), getCapabilities());
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void stopServer() {
        service.stop();
    }
}