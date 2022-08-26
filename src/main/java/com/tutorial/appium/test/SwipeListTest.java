package com.tutorial.appium.test;

import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.MenuPage;
import com.tutorial.appium.page.SwipeListPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeListTest extends BaseTest {

    MenuPage menu = new MenuPage();
    SwipeListPage page = new SwipeListPage();

    @Test
    public void desafio(){
        menu.acessarSwipeList();

        //op1 esquerda
        page.SwipeElementLeft("Opção 1");

        //op1 clicar +
        page.clicarAdicao();

        //verificar
        Assert.assertTrue(page.ExisteElementoTexto("Opção 1 (+)"));

        //op4 esquerda
        page.SwipeElementLeft("Opção 4");

        //clica -
        page.clicarSub();

        //Verificar texto
        Assert.assertTrue(page.ExisteElementoTexto("Opção 4 (-)"));

        //op 5 direita
        page.SwipeElementRight("Opção 5 (-)");

        //Verificar 5
        Assert.assertTrue(page.ExisteElementoTexto("Opção 5"));
    }
}
