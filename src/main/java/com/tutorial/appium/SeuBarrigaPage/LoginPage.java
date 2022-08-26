package com.tutorial.appium.SeuBarrigaPage;

import com.tutorial.appium.core.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public void preencherEmail(){
        escrever(By.xpath("//android.widget.EditText[1]"),"a@tester");
    }
    public void preencherSenha(){
        escrever(By.xpath("//android.widget.EditText[2]"),"t123");
    }
    public void ClicarEntrar(){
        clicarTexto("ENTRAR");
    }
}
