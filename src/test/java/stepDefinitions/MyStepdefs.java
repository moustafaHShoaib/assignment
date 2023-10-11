package stepDefinitions;

import androidPageObject.MoviesListPageAndriod;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.LaunchApp;

import java.net.MalformedURLException;
import java.net.URL;

public class MyStepdefs extends LaunchApp {
    public MoviesListPageAndriod LandingPage=new MoviesListPageAndriod();
    @Given("i launch the app")
    public void iLaunchTheApp() throws InterruptedException, MalformedURLException {
        AppiumDriver driver;
        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), getCapabilities());

    }
    @When("i click on movie name")
    public void i_click_on_movie_name() throws InterruptedException {
        LandingPage.ClickOnMovieName(getDriver(),"Barbie");
        throw new io.cucumber.java.PendingException();
    }
    @Then("i can validate movie details on details screen")
    public void i_see_movie_details() {

        Assert.assertEquals(LandingPage.getMovie_Title(getDriver()),"Barbie");
        Assert.assertEquals(LandingPage.getRelease_Date(getDriver()),"Release Date : 2023-07-19");
        Assert.assertEquals(LandingPage.getMovieRating(getDriver()),"7.0");
    }

    @Then("i can navigate back to the main movies list screen")
    public void iCanNavigateBackToTheMainMoviesListScreen() throws InterruptedException {
        LandingPage.BackToListScreen(getDriver());
        Assert.assertEquals(LandingPage.getScreenTitle(getDriver()),"TheMovies");
    }

    @When("i click on movie Poster")
    public void iClickOnMoviePoster() throws InterruptedException {
        LandingPage.ClickOnMoviePoster(getDriver());
    }
}
