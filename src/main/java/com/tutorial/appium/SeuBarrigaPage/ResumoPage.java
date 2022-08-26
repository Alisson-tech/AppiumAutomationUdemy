package com.tutorial.appium.SeuBarrigaPage;

import com.tutorial.appium.core.BasePage;
import com.tutorial.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class ResumoPage extends BasePage {

    public void excluir(String desc){
        MobileElement movimentacao = DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='"+desc+"']"));
        SwipeElement(movimentacao, 0.9, 0.1);
        clicarTexto("Del");

    }
    public void atualizarResumo(){
        clicarTexto("ATUALIZAR");
    }

}
