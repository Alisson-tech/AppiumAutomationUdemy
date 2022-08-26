package com.tutorial.appium.test;

import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.DragDropPage;
import com.tutorial.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class DragDropTest extends BaseTest {

    MenuPage menu = new MenuPage();
    DragDropPage page = new DragDropPage();

    String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    String[] estadoIntermedio = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "Esta", "e arraste para", "qualquer local desejado."};
    String[] estadoFinal = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "Esta", "e arraste para", "qualquer local desejado."};

    @Test
    public void arrastarItens(){

        //acessar drag drop
        menu.acessarDragDrop();

        //verificar inicial
        Assert.assertArrayEquals(estadoInicial, page.obterItens());

        page.arrastar("Esta","Faça um clique longo,");

        Assert.assertArrayEquals(estadoIntermedio, page.obterItens());

        page.arrastar("Faça um clique longo,", "é uma lista");

        Assert.assertArrayEquals(estadoFinal, page.obterItens());

    }
}
