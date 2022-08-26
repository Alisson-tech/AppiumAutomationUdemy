package com.tutorial.appium.page;

import com.tutorial.appium.core.BasePage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class AlertaPage extends BasePage {

    public  void ClicarAlertaConfirm(){
        clicarTexto("ALERTA CONFIRM");
    }

    public void ClicarAlertSimples(){
        clicarTexto("ALERTA SIMPLES");
    }
    public void ClicarConfirmar(){
        clicar(By.id("android:id/button2"));
    }
    public boolean verificarAlertSimples(){
        return ExisteElementoTexto("Pode clicar no OK ou fora da caixa para sair");
    }
    public void clicarForaAlerta() {
        tap(60,100);
    }
    public void ClicarSair(){
        clicar(By.id("android:id/button1"));
    }
}
