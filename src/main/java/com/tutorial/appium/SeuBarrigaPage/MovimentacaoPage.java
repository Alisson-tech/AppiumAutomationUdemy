package com.tutorial.appium.SeuBarrigaPage;

import com.tutorial.appium.core.BasePage;
import org.openqa.selenium.By;

public class MovimentacaoPage extends BasePage {

    public void clicarSalvar(){
        clicarTexto("SALVAR");
    }

    public void SetDesc(String desc){
        escrever(By.xpath("//android.widget.EditText[@text='Descrição']"),desc);
    }
    public void SetInteressado(String interessado){
        escrever(By.xpath("//android.widget.EditText[@text='Interessado']"),interessado);
    }
    public void SetValor(String valor){
        escrever(By.xpath("//android.widget.EditText[@text='Valor']"),valor);
    }
    public void SetConta(String conta){
        selecionarCombo(By.xpath("//android.widget.TextView[@text='Selecione uma conta...']"), conta);
    }
}
