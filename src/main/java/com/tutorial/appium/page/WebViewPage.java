package com.tutorial.appium.page;

import com.tutorial.appium.core.BasePage;
import com.tutorial.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.util.Set;

public class WebViewPage extends BasePage {

    public void alterarContextoWeb() {

        espera(1000);
        Set<String> contextNames = DriverFactory.getDriver().getContextHandles();

        DriverFactory.getDriver().context((String) contextNames.toArray()[1]);

        //DriverFactory.getDriver().context("WEBVIEW_com.ctappium");


        System.out.print(DriverFactory.getDriver().getContext() + "\n");


    }

    public void WriteEmail(String text){

        espera(1500);
        escrever(By.xpath("//*[@id='email']"), text);
    }

    public void SairContextoWeb() {

        espera(1000);
        Set<String> contextNames = DriverFactory.getDriver().getContextHandles();

        DriverFactory.getDriver().context((String) contextNames.toArray()[0]);
        System.out.print(DriverFactory.getDriver().getContext());

    }
    public void writePass(String text){
        escrever(By.xpath("//*[@id='senha']"), text);
    }
    public void entrar(){
        clicar(By.xpath("//button[@type='submit']"));
    }
    public String msg(){
        espera(500);
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
