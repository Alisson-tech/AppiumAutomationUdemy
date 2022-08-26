package com.tutorial.appium.core;


import com.tutorial.appium.core.DriverFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void finalizarClasse(){
        DriverFactory.killDriver();
    }

    @After
    public void tearDown() {

        gerarScreenShot();
        DriverFactory.getDriver().resetApp();
        //DriverFactory.permicoes();
    }

    public void gerarScreenShot() {

        try {
            File img = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(img, new File("target/ScreenShot/"+testName.getMethodName()+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
