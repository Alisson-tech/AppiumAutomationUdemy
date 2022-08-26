package com.tutorial.appium.test;

import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class OpcaoEscondidaTest extends BaseTest {

    MenuPage menupage = new MenuPage();

    @Test
    public void VerificarScroll(){
        // Scroll Down
        menupage.ScrollDown();

        //Clicar menu
        menupage.acessarEscondido();

        //Verificar msg
        Assert.assertEquals("Você achou essa opção", menupage.TextoAlerta());

        //sair
        menupage.clicarTexto("OK");
    }
}
