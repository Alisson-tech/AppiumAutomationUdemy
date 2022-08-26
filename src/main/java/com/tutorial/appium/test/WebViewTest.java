package com.tutorial.appium.test;

import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.MenuPage;
import com.tutorial.appium.page.WebViewPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WebViewTest extends BaseTest {

    MenuPage menu = new MenuPage();
    WebViewPage page = new WebViewPage();


    @Test
    public void Login(){
        menu.acessarWebView();

        page.alterarContextoWeb();


        page.WriteEmail("a@tester");

        page.writePass("t123");
        page.entrar();
        Assert.assertEquals("Bem vindo, Teste!", page.msg());

    }

    @After
    public void sairContext(){
        page.SairContextoWeb();
    }
}
