package com.tutorial.appium.page;

import com.tutorial.appium.core.BasePage;
import com.tutorial.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.List;

public class DragDropPage extends BasePage {

    public void arrastar(String origem, String destino){

        MobileElement inicio = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
        MobileElement fim = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));

        new TouchAction(DriverFactory.getDriver())
                .longPress(ElementOption.element(inicio))
                .moveTo(ElementOption.element(fim))
                .release().perform();
    }
    public String[] obterItens(){

        espera(1500);
        List<MobileElement> elements = (List<MobileElement>) DriverFactory.getDriver().findElements(By.className("android.widget.TextView"));

        String[] retorno = new String[elements.size()];


        String a = elements.get(0).getText();

        for(int i =0; i < retorno.length;i++){

            retorno[i] = elements.get(i).getText();
        }

        return retorno;
    }
}
