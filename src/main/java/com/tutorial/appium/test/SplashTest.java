package com.tutorial.appium.test;

import com.tutorial.appium.core.BaseTest;
import com.tutorial.appium.page.MenuPage;
import com.tutorial.appium.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

public class SplashTest extends BaseTest {

    private MenuPage menu= new MenuPage();
    private SplashPage page = new SplashPage();

    @Test
    public void DeveAguardarSplash(){
        menu.acessarSplash();
        Assert.assertTrue(page.IsTelaSplashVisivel());
        page.AguardarSplashSumir();
        Assert.assertTrue(page.IsMenuPage());

    }

}
