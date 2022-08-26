package com.tutorial.appium.test;

import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.AlertaPage;
import com.tutorial.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertaPage page = new AlertaPage();

    @Before
    public void acessarAlerta(){
        menu.acessarAlert();
    }

    @Test
    public void Alerta(){

        //clicar em alerta
        page.ClicarAlertaConfirm();

        //conferir texto
        Assert.assertEquals("Info", page.TituloAlerta());
        Assert.assertEquals("Confirma a operação?", page.TextoAlerta());

        //confirmar
        page.ClicarConfirmar();

        //conferir texto
        Assert.assertEquals("Confirmado", page.TextoAlerta());

        //clicar em sair
        page.ClicarSair();
    }
    @Test
    public void AlertaSimples(){
        // clicar alerta
        page.ClicarAlertSimples();


        //verificar se alerta abriu
        Assert.assertTrue(page.verificarAlertSimples());

        //verificar se  alerta sumiu
        page.clicarForaAlerta();

        Assert.assertFalse(page.verificarAlertSimples());

    }
}
