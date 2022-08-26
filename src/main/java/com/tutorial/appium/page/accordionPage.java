package com.tutorial.appium.page;

import com.tutorial.appium.core.BasePage;
import org.openqa.selenium.By;

public class accordionPage extends BasePage {

    public void SelecionarOp1(){
        clicarTexto("Opção 1");
    }

    public String obterValor1(){
        return obterTexto(By.xpath("//*[@text='Opção 1']/../../following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }
}
