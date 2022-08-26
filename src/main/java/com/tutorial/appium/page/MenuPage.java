package com.tutorial.appium.page;

import com.tutorial.appium.core.BasePage;
import com.tutorial.appium.core.DriverFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class MenuPage extends BasePage {

    public void acessarFormulario(){

        clicarTexto("Formulário");
    }

    public void acessarSplash(){

        clicarTexto("Splash");
    }
    public void acessarAlert(){

        clicarTexto("Alertas");
    }
    public void acessarAba(){

        clicarTexto("Abas");
    }
    public void acessarAccordion(){

        clicarTexto("Accordion");
    }

    public void acessarCliques(){
        clicarTexto("Cliques");
    }

    public void acessarEscondido(){
        clicarTexto("Opção bem escondida");
    }
    public void acessarSwipe(){
        clicarTexto("Swipe");
    }

    public void acessarSwipeList(){

        ScrollDown();

        clicarTexto("Swipe List");
    }

    public void acessarDragDrop(){

        ScrollDown();

        clicarTexto("Drag and drop");
    }

    public void acessarWebView(){
        clicarTexto("SeuBarriga Híbrido");
    }

    public void acessarRealApp(){
        clicarTexto("SeuBarriga Nativo");
    }


}
