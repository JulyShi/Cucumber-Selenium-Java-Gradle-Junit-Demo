package com.xy.demo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by xyShi on 3/27/18.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:build/cucumber-report.json","pretty", "html:build/cucumber-html-report"},
        features = "classpath:features",
        glue = {"com.xy.demo.step_Definitions"}
        //tags = {}
)
public class RunCukesTest {

}
