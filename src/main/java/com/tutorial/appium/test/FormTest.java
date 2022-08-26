package com.tutorial.appium.test;
import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.FormularioPage;
import com.tutorial.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;



public class FormTest extends BaseTest {


    private MenuPage menupage = new MenuPage();
    private FormularioPage formpage = new FormularioPage();

    @Before
    public void setUp() throws MalformedURLException {

        menupage.acessarFormulario();
    }

    @Test
    public void writeTest() {
        String name = "Alisson";

        formpage.EscreverNome(name);

        Assert.assertEquals(name, formpage.obterNome());
    }

    @Test
    public void SelectTest() {

        //Platoforma selecionada
        String platform = "PS4";

        formpage.SelecionarCombo(platform);

        //Verificar se foi selecionado PS4
        Assert.assertEquals(platform, formpage.ObterValorCombo());
    }
    @Test
    public void InterationCheckBox() {


        //Verificando status de cada elemento
        Assert.assertFalse(formpage.isCheckMarcado());
        Assert.assertTrue(formpage.isSwitchMarcado());

        formpage.clicarCheck();
        formpage.clicarSwitch();

        //Verificar se mudou o status de cada elemento
        Assert.assertTrue(formpage.isCheckMarcado());
        Assert.assertFalse(formpage.isSwitchMarcado());
    }
    @Test
    public void desafio() {
        // Novo método
        // Formulário
        // preencher e salvar
        // Validar campos

        List<String> resultado = Arrays.asList("Alisson", "ps4", "25", "Off", "Marcado", "01/01/2000", "09:00");

        formpage.EscreverNome(resultado.get(0));

        formpage.SelecionarCombo(resultado.get(1).toUpperCase());

        Assert.assertFalse(formpage.isCheckMarcado());
        Assert.assertTrue(formpage.isSwitchMarcado());

        formpage.clicarCheck();
        formpage.clicarSwitch();

        formpage.clicarSalvar();

        for (int i = 12; i < 19; i++) {

            //MobileElement Nome_result = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@index=" + (12 + i) + "]"));
            //String result = Nome_result.getText().substring((Nome_result.getText().indexOf(':')) + 2, Nome_result.getText().length());

            //Assert.assertEquals(resultado.get(i), result);
            Assert.assertTrue(formpage.obterResultadoCadastro(i).endsWith(resultado.get(i - 12)));
        }
    }

    @Test
    public void CadasroDemorado() {
        String name = "Alisson";

        formpage.EscreverNome(name);

        formpage.clicarSalvarDemorado();

        Assert.assertTrue(formpage.obterResultadoCadastro(12).endsWith(name));

    }

    @Test
    public void AlterarData(){
        formpage.clicarTexto("01/01/2000");
        formpage.clicarTexto("10");
        formpage.clicar(By.id("android:id/button1"));

        Assert.assertTrue(formpage.ExisteElementoTexto("10/01/2000"));
    }
    @Test
    public void AlterarTime(){
        formpage.clicarTexto("09:00");
        formpage.clicar(MobileBy.AccessibilityId("8"));
        formpage.clicar(MobileBy.AccessibilityId("35"));
        formpage.clicarTexto("OK");

        Assert.assertTrue(formpage.ExisteElementoTexto("08:35"));
    }
    @Test
    public void verificarSeekBar(){

        formpage.ClicarSeekBar(0.67);

        formpage.clicarSalvar();

        Assert.assertFalse(formpage.obterResultadoCadastro(14).endsWith("25"));
    }
}
