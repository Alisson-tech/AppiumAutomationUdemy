package com.tutorial.appium.page;

import com.tutorial.appium.core.BasePage;
import org.openqa.selenium.By;

public class abaPage extends BasePage {

    public void clicarAba2(){
        clicarTexto("Aba 2");
    }

    public boolean IsAba1(){
        return ExisteElementoTexto("Este é o conteúdo da Aba 1");
    }
    public boolean IsAba2(){
        return ExisteElementoTexto("Este é o conteúdo da Aba 2");
    }
}
