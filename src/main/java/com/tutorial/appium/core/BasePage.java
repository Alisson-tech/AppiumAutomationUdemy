package com.tutorial.appium.core;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;
import java.util.List;

import static com.tutorial.appium.core.DriverFactory.getDriver;

public class BasePage {

    public void espera(int temp){
        try {
            Thread.sleep(temp);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void escrever(By by, String texto){
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by){
        return getDriver().findElement(by).getText();
    }

    public void tap(int x, int y){

        new TouchAction(getDriver()).press(PointOption.point(x, y)).perform();
    }
    public void tapRelease(int x, int y){

        new TouchAction(getDriver()).press(PointOption.point(x, y)).release().perform();
    }

    public void LongTap(By by){

        MobileElement element = getDriver().findElement(by);

        new TouchAction(getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
                .release()
                .perform();
    }

    public void selecionarCombo(By by, String texto){
        getDriver().findElement(by).click();
        clicarTexto(texto);
    }
    public void clicarTexto(String texto){
        clicar(By.xpath("//*[@text='"+texto+"']"));
    }

    public void clicar(By by){
        getDriver().findElement(by).click();
    }
    public boolean isChecked(By by){
        return Boolean.parseBoolean(getDriver().findElement(by).getAttribute("checked"));
    }

    public boolean ExisteElementoTexto(String texto){

        List<MobileElement> elemento = (List<MobileElement>) getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
        boolean result = !elemento.isEmpty();
        return result;
    }

    public String TituloAlerta(){
        return obterTexto(By.id("android:id/alertTitle"));
    }
    public String TextoAlerta(){
        return obterTexto(By.id("android:id/message"));
    }

    public void Scroll(double inicial, double fim){

        Dimension size = getDriver().manage().window().getSize();

        espera(2000);
        int x = (size.width/ 2);

        int star_y = (int) (size.height * inicial);
        int end_y = (int) (size.height * fim);

        espera(1500);
        new TouchAction(DriverFactory.getDriver())
                .longPress(PointOption.point(x, star_y))
                .moveTo(PointOption.point(x, end_y))
                .release().perform();

    }

    public void Swipe(double inicial, double fim){

        Dimension size = getDriver().manage().window().getSize();

        int y = (size.height/ 2);

        int star_x = (int) (size.width * inicial);
        int end_x = (int) (size.width * fim);

        espera(1000);

        new TouchAction(DriverFactory.getDriver())
                .longPress(PointOption.point(star_x,y))
                .moveTo(PointOption.point(end_x,y))
                .release().perform();
    }

    public void SwipeElement(MobileElement Element, double inicial, double fim){

        int y = Element.getLocation().y + (Element.getSize().height / 2);

        int star_x = (int) (Element.getSize().width * inicial);
        int end_x = (int) (Element.getSize().width * fim);

        espera(1000);

        new TouchAction(DriverFactory.getDriver())
                .longPress(PointOption.point(star_x,y))
                .moveTo(PointOption.point(end_x,y))
                .release().perform();
    }

    public void ScrollDown(){
        Scroll(0.9, 0.1);
    }
    public void ScrollUp(){
        Scroll(0.1, 0.9);
    }

    public void SwipeRight(){
        Swipe(0.9, 0.1);
    }
    public void SwipeLeft(){
        Swipe(0.1, 0.9);
    }
}
