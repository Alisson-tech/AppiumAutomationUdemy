package com.tutorial.appium.test;

import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.MenuPage;
import com.tutorial.appium.page.abaPage;
import org.junit.Assert;
import org.junit.Test;

public class Abas extends BaseTest {

    MenuPage menu = new MenuPage();
    abaPage page = new abaPage();



    @Test
    public void deveInteragirAbas(){

        menu.acessarAba();

        Assert.assertTrue(page.IsAba1());

        page.clicarAba2();

        Assert.assertTrue(page.IsAba2());
    }
}
