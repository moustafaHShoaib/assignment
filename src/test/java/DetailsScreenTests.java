import  io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DetailsScreenTests {
    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","uiautomator2");
        caps.setCapability("platformVersion", "14.0");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("appium:appActivity","com.skydoves.themovies");

        driver =new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);

    }

    @Test
    public void CheckMovieDetailsScreen() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Barbie')]")).click();
        Thread.sleep(4000);
        String title = driver.findElement(By.id("com.skydoves.themovies:id/detail_header_title")).getText();
        String releaseDate = driver.findElement(By.id("com.skydoves.themovies:id/detail_header_release")).getText();
        String rating = driver.findElement(By.id("com.skydoves.themovies:id/detail_header_star")).getText();

        Assert.assertEquals(title,"Barbie");
        Assert.assertEquals(releaseDate,"Release Date : 2023-07-19");
        Assert.assertEquals(rating,"7.0");

        //navigate back to the main screen
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
        // wait until main screen is loaded
        Thread.sleep(4000);
        // check the navigation back is done
        String mainScreenTitle=driver.findElement(By.id("com.skydoves.themovies:id/toolbar_title")).getText();
        Assert.assertEquals(mainScreenTitle,"TheMovies");
        }



    @AfterTest
    public  void tearDown()
    {
        if (null!=driver)
        {
            driver.quit();
        }
    }
}
