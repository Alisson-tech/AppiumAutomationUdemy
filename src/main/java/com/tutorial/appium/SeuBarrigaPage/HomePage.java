package com.tutorial.appium.SeuBarrigaPage;

import com.tutorial.appium.core.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public void resetarDados(){
        clicarTexto("RESET");
    }
    public void ClicarHome(){
        clicarTexto("Home");
    }
    public void ClicarContas(){
        clicarTexto("Contas");
    }
    public void ClicarMOV(){
        clicarTexto("Mov...");
    }
    public void ClicarResumo(){
        clicarTexto("Resumo");
    }
    public String verificarSaldo(String conta){
        return obterTexto(By.xpath("//android.widget.TextView[@text='"+conta+"']"));
    }
    public void atualizar (){
        Scroll(0.25, 0.90);
    }
}
