package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=//{".//Features/"}, 
                         //{".//Features/Login13.feature"},
                          {".//Features/Login13.feature",".//Features/Createcustomer.feature"},
                          glue="Stepdefinition")
public class Demo {

}
