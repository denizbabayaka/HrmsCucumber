package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features"						
		,glue="com/hrms/steps"
		,dryRun=false
		,plugin = {"pretty","html:target/html/cucumber-dafault-report","json:target/cucumber.json"}
		,monochrome=true
		,tags= {"@smoke"}  // @sprint1 ,@AddEmployee each of we can run 
           )
public class SmokeRunner {

}
