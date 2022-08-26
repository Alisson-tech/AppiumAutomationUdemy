package com.tutorial.appium.page;

import com.tutorial.appium.core.BasePage;
import com.tutorial.appium.core.DriverFactory;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class SplashPage extends BasePage {

    public boolean IsTelaSplashVisivel(){
        return ExisteElementoTexto("Splash!");
    }

    public void AguardarSplashSumir(){

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text=Splash!]")));

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public boolean IsMenuPage(){
        return ExisteElementoTexto("Formulário");
    }
}
