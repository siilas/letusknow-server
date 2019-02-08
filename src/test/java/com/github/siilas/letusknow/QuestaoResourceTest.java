package com.github.siilas.letusknow;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.github.siilas.letusknow", monochrome = true, dryRun = false, plugin = {
        "pretty",
        "html:target/cucumber-reports/html",
        "json:target/cucumber-reports/CucumberTestReport.json" })
public class QuestaoResourceTest {

}
