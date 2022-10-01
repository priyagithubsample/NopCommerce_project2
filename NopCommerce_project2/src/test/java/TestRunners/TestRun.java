package TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
         (
        	features=".//Features/Loginnop.feature",
        	glue="StepDefinations",
        	dryRun=false,
        
        	monochrome=true,
        	plugin= {"pretty","html:test-output"}
        		 
         )
public class TestRun {

}
