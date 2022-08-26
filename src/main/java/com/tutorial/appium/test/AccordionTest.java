package com.tutorial.appium.test;

import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.MenuPage;
import com.tutorial.appium.page.accordionPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class AccordionTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private accordionPage page = new accordionPage();

    @Test
    public void VerificarAccordion() throws InterruptedException {

        menu.acessarAccordion();
        page.SelecionarOp1();

        TimeUnit time = TimeUnit.SECONDS;

        time.sleep(1);
        Assert.assertEquals("Esta é a descrição da opção 1",page.obterValor1());
    }
}
