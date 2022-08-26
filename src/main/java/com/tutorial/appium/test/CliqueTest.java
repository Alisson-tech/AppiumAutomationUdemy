package com.tutorial.appium.test;

import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.AlertaPage;
import com.tutorial.appium.page.CliquePage;
import com.tutorial.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class CliqueTest extends BaseTest {

    MenuPage menu = new MenuPage();
    CliquePage page = new CliquePage();

    @Before
    public void setUp() throws MalformedURLException {

        menu.acessarCliques();
    }

    @Test
    public void RealizarCliqueLong() {

        //Realizar clique longo
        page.CliqueLongo();

        System.out.print(page.ObterTextCampo());

        //Verificar texto
        Assert.assertEquals("Clique Longo",page.ObterTextCampo());

    }

    @Test
    public void RealizarCliqueDuplo(){
        page.clicarTexto("Clique duplo");
        page.clicarTexto("Clique duplo");

        Assert.assertEquals("Duplo Clique",page.ObterTextCampo());

    }

}
