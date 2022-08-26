package com.tutorial.appium.page;

import com.tutorial.appium.core.BasePage;
import com.tutorial.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class FormularioPage extends BasePage
{
    public void EscreverNome(String valor){
        escrever(MobileBy.AccessibilityId("nome"), valor);
    }

    public String obterNome(){

        return obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void SelecionarCombo(String valor){
        selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }
    public String ObterValorCombo(){
        return obterTexto(By.id("android:id/text1"));
    }
    public void clicarCheck(){
        clicar(MobileBy.AccessibilityId("check"));
    }
    public void clicarSwitch(){
        clicar(MobileBy.AccessibilityId("switch"));
    }
    public boolean isCheckMarcado(){
        return isChecked(MobileBy.AccessibilityId("check"));
    }
    public boolean isSwitchMarcado(){
        return isChecked(MobileBy.AccessibilityId("switch"));
    }
    public void clicarSalvar(){
        clicarTexto("SALVAR");
    }
    public void clicarSalvarDemorado(){
        clicarTexto("SALVAR DEMORADO");
        espera(2500);
    }
    public String obterResultadoCadastro(int id){

        return obterTexto(By.xpath("//android.widget.TextView[@index=" + (id) + "]"));
    }
    public void ClicarSeekBar(double porcent){

        int delta = 30;

        MobileElement seek = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));

        int y = seek.getLocation().y + (seek.getSize().height/2);

        int inicial = seek.getLocation().x + delta;

        int x = (int) (inicial + ((seek.getSize().width - 2* delta) * porcent));

        tapRelease(x,y);

    }
}
