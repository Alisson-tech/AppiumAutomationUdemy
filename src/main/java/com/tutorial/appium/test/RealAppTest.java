package com.tutorial.appium.test;

import com.sun.source.tree.AssertTree;
import com.tutorial.appium.SeuBarrigaPage.*;
import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RealAppTest extends BaseTest {


    MenuPage menu = new MenuPage();
    LoginPage SBLogin = new LoginPage();
    HomePage SBHome = new HomePage();
    ContasPage conta = new ContasPage();
    MovimentacaoPage mov = new MovimentacaoPage();
    ResumoPage resumo = new ResumoPage();
    @Before
    public void Logar(){
        menu.acessarRealApp();

        SBLogin.preencherEmail();
        SBLogin.preencherSenha();
        SBLogin.ClicarEntrar();

        SBHome.resetarDados();
    }

    @Test
    public void InserirConta(){
        String conta = "Saldo";
        SBHome.ClicarContas();
        this.conta.InserirConta(conta);
        this.conta.SalvarConta();

        Assert.assertTrue(this.conta.ExisteMensagem("Conta adicionada com sucesso"));
        Assert.assertEquals(this.conta.ObterElementoSalvo(By.xpath("//android.widget.TextView[@text='Saldo']")), conta);

    }
    @Test
    public void ExcluirConta(){

        //acessar contas
        SBHome.ClicarContas();

        //Segurar em uma conta
        conta.SelecionarConta("Conta para alterar");


        //Clicar em excluir
        conta.clicarExcluir();

        //Verificar mensagem
        Assert.assertTrue(conta.ExisteMensagem("Conta excluída com sucesso"));

    }
    @Test
    public void movimentacoes(){
        //acessar movimentação
        SBHome.ClicarMOV();

        //Validar descricao
        mov.clicarSalvar();
        Assert.assertTrue(conta.ExisteMensagem("Descrição é um campo obrigatório"));

        //validar interessado
        mov.SetDesc("investimento");
        mov.clicarSalvar();
        Assert.assertTrue(conta.ExisteMensagem("Interessado é um campo obrigatório"));

        //validar valor
        mov.SetInteressado("eu");
        mov.clicarSalvar();
        Assert.assertTrue(conta.ExisteMensagem("Valor é um campo obrigatório"));

        //validar conta
        mov.SetValor("200");
        mov.clicarSalvar();
        Assert.assertTrue(conta.ExisteMensagem("Conta é um campo obrigatório"));

        //verificar se foi salvo
        mov.SetConta("Conta para saldo");
        mov.clicarSalvar();
        Assert.assertTrue(conta.ExisteMensagem("Movimentação cadastrada com sucesso"));
    }

    @Test
    public void excluirMovimentacaoVerificarSaldo(){
        String saldoInicial = "534.00";
        String SaldoModificado = "1534.00";

        //verificar saldo
        Assert.assertEquals(SBHome.verificarSaldo(saldoInicial), saldoInicial);

        //acessar resumo
        SBHome.ClicarResumo();

        //atualizar
        resumo.atualizarResumo();

        //excluir conta
        resumo.excluir("Movimentacao 2, calculo saldo");

        //acessar home
        SBHome.ClicarHome();

        //Atualizar
        SBHome.atualizar();

        //verificar saldo
        Assert.assertEquals(SBHome.verificarSaldo(SaldoModificado), SaldoModificado);


    }
}
