package tests.day14_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_NutellaTesti {




    @Test
    public void test01(){
        //
        Driver.getDriver().get("https:www.amazon.com");
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

    }
}
