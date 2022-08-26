package com.tutorial.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver(){
        if(driver==null){
            CreatDrive();
        }

        return driver;
    }


    private static void CreatDrive() {

        //Configuração capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName", "UIAutomator2");
        desiredCapabilities.setCapability("platformVersion", "7.1.1");
        //desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("app", "C:\\Users\\aliss\\IdeaProjects\\Curso-appium\\src\\main\\apk\\CTAppium_2_0.apk");
        //desiredCapabilities.setCapability("appWaitPackage", "com.google.android.permissioncontroller");
        //desiredCapabilities.setCapability("appWaitActivity", "com.android.permissioncontroller.permission.ui.ReviewPermissionsActivity");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("nativeWebScreenshot", true);

        //Conexão appium
        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        //Criando driver e configurando time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //permicoes();

    }
    public static void permicoes(){
        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
    }

    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
