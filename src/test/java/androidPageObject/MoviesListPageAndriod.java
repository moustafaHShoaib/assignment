package androidPageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utils.LaunchApp;

public class MoviesListPageAndriod extends LaunchApp {
    By MovieTitle =  By.id("com.skydoves.themovies:id/detail_header_title");
    By ReleaseDate=    By.id("com.skydoves.themovies:id/detail_header_release");

    By MovieRating=By.id("com.skydoves.themovies:id/detail_header_star");
    By NavigateBackButton=By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    By ScreenTitle=By.id("com.skydoves.themovies:id/toolbar_title");


    public void ClickOnMovieName(AppiumDriver driver ,String MovieName) throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+MovieName+"')]")).click();
        Thread.sleep(4000);
    }

    public void ClickOnMoviePoster(AppiumDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.ImageView")).click();
        Thread.sleep(4000);
    }

    public String getMovie_Title(AppiumDriver driver ) {

        return driver.findElement(MovieTitle).getText();

    }

    public String getRelease_Date(AppiumDriver driver ) {

        return driver.findElement(ReleaseDate).getText();

    }

    public String getMovieRating(AppiumDriver driver ) {

        return driver.findElement(MovieRating).getText();

    }
    public void BackToListScreen(AppiumDriver driver ) throws InterruptedException {
          driver.findElement(NavigateBackButton).click();
        Thread.sleep(4000);

    }
    public  String getScreenTitle(AppiumDriver driver)
    {
      return   driver.findElement(ScreenTitle).getText();
    }
}
