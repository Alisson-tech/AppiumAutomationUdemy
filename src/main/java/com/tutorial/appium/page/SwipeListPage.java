package com.tutorial.appium.page;

import com.tutorial.appium.core.BasePage;
import com.tutorial.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;


public class SwipeListPage extends BasePage {

    public void SwipeElementLeft(String opcao){
        SwipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);

    }
    public void SwipeElementRight(String opcao){
        SwipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
    }

    public void clicarAdicao(){
        MobileElement element = DriverFactory.getDriver().findElement(By.xpath("//*[@text='(+)']"));

        Point center = element.getCenter();

        new TouchAction(DriverFactory.getDriver())
                .press(PointOption.point(center.x -50, center.y)).release().perform();
    }
    public void clicarSub(){
        clicarTexto("(-)");
    }
}
