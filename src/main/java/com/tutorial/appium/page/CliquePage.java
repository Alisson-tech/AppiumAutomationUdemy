package com.tutorial.appium.page;

import com.tutorial.appium.core.BasePage;
import com.tutorial.appium.core.DriverFactory;
import org.openqa.selenium.By;

public class CliquePage extends BasePage {

    public void CliqueLongo(){

        LongTap(By.xpath("//*[@text='Clique Longo']"));
    }

    public String ObterTextCampo(){
        return obterTexto(By.xpath("//android.view.ViewGroup[1]/android.widget.TextView[2]"));
    }
}
