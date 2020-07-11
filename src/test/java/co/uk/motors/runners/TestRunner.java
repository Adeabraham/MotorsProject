package co.uk.motors.runners;

/*
Test runner helps us to run our tests.
with test runner, we are able to specify the location of our feature file, hooks and step definitions files as
well as our report (plugin)
 */

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                //now specify where the feature file is:
                features = {"src/test/java/co/uk/motors/features"},  //go into the feature package and
                                                                     // run every file with .feature....(1)
                /*
                   we also specify the location of the step definition
                   we need Hook, to open and close browser, and we need step definitions
                 */
                glue = {"co/uk/motors/hooks", "co/uk/motors/stepDefinitions"},
                /*
                 Above means:
                 go into the hook package, & start with hook, then go into step definition &
                 match the feature with step defn....(2)
                 the step defn is picked up but nothing will happen
                 at this stage because it is still empty: no method is
                 written inside of it as an instruction of what to do
                 */

                //at the beginning we took a particular report, we put the report in as plug in:
                plugin = {"pretty", "json:target/report.json",
                "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"},
                /*
                 pretty means human readable,
                 save the report in json format
                 as: target/report.json....(3)
                 */

                tags = {"not @ignore"}
        )

public class TestRunner  //using tag to select what we want to run at a particular time
{

}
