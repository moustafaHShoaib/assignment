import  io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import androidPageObject.MoviesListPageAndriod;
import utils.LaunchApp;

public class DetailsScreenTests extends LaunchApp {
    public  MoviesListPageAndriod LandingPage=new MoviesListPageAndriod();
    AppiumDriver driver;



    @Test
    public void CheckMovieDetailsScreenViaClickingOnMovieName() throws InterruptedException {
     LandingPage.ClickOnMovieName(getDriver(),"Barbie");
        Assert.assertEquals(LandingPage.getMovie_Title(getDriver()),"Barbie");
        Assert.assertEquals(LandingPage.getRelease_Date(getDriver()),"Release Date : 2023-07-19");
        Assert.assertEquals(LandingPage.getMovieRating(getDriver()),"7.0");

        //navigate back to the main screen
        LandingPage.BackToListScreen(getDriver());
        Assert.assertEquals(LandingPage.getScreenTitle(getDriver()),"TheMovies");
        }
    @Test
    public void CheckMovieDetailsScreenViaClickingOnMoviePoster() throws InterruptedException {
        LandingPage.ClickOnMoviePoster(getDriver());
        Assert.assertEquals(LandingPage.getMovie_Title(getDriver()),"Barbie");
        Assert.assertEquals(LandingPage.getRelease_Date(getDriver()),"Release Date : 2023-07-19");
        Assert.assertEquals(LandingPage.getMovieRating(getDriver()),"7.0");

        //navigate back to the main screen
        LandingPage.BackToListScreen(getDriver());
        Assert.assertEquals(LandingPage.getScreenTitle(getDriver()),"TheMovies");
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
