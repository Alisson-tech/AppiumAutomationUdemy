package com.tutorial.appium.test;

import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTest extends BaseTest {

    MenuPage menu = new MenuPage();

    @Test
    public void testarSwipe(){
        // acessar tela
        menu.acessarSwipe();

        //verificar texto
        Assert.assertTrue(menu.ExisteElementoTexto("Mova a tela para"));

        //swipe direita
        menu.SwipeRight();

        //Verificar texto
        Assert.assertTrue(menu.ExisteElementoTexto("E veja se"));

        //Clique a direita
        menu.clicarTexto("›");

        //Verificar texto
        Assert.assertTrue(menu.ExisteElementoTexto("Chegar até o fim!"));

        //clique a esquerda
        menu.clicarTexto("‹");

        //Swipe esquerda
        menu.SwipeLeft();

        //Verificar texto
        Assert.assertTrue(menu.ExisteElementoTexto("Mova a tela para"));

    }
}
