package runners;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinition"},
        monochrome = false,dryRun = false)

@Test
public class TestRunner extends AbstractTestNGCucumberTests{

}