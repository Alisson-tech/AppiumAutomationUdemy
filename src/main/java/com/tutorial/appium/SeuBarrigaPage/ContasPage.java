package com.tutorial.appium.SeuBarrigaPage;

import com.tutorial.appium.core.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void InserirConta(String text){
        escrever(By.xpath("//android.widget.EditText[@text='Conta']"), text);
    }
    public void SalvarConta(){
        clicarTexto("SALVAR");
    }
    public boolean ExisteMensagem(String Text){
        return ExisteElementoTexto(Text);
    }
    public String ObterElementoSalvo(By by){
        return obterTexto(by);
    }
    public void SelecionarConta(String text){
        LongTap(By.xpath("//android.widget.TextView[@text='"+text+"']"));
    }
    public void clicarExcluir(){
        clicar(By.xpath("//android.widget.TextView[@text='EXCLUIR']"));
    }
}
