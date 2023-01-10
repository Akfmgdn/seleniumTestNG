package A_testNGDeneme;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class C01_NegativeLoginTest {

    @Test
    public void Test01(){


    // 1. “http://zero.webappsecurity.com/” Adresine gidin
    Driver.getDriver().get("http://zero.webappsecurity.com");

    // 2. Sign in butonuna basin
        ZeroWebAppPage ZeroWebAppPage=new ZeroWebAppPage();
        ZeroWebAppPage.signInButonu.click();

    // 3. Login kutusuna “username” yazin
        ZeroWebAppPage.usernameKutusu.sendKeys("username");

    // 4. Password kutusuna “password” yazin
        ZeroWebAppPage.passwordKutusu.sendKeys("password");

    // 5. Sign in tusuna basin
        ZeroWebAppPage.signInSubmitButonu.click();
        Driver.getDriver().navigate().back();

    // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        ZeroWebAppPage.onlineBanking.click();
        ZeroWebAppPage.payBillLinki.click();

    // 7. “Purchase Foreign Currency” tusuna basin
        ZeroWebAppPage.purchaseFCButonu.click();

    // 8. “Currency” drop down menusunden Eurozone’u secin
        Select select =new Select(ZeroWebAppPage.currencyDropdown);
        select.deselectByVisibleText("Eurozone (euro)");

    // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String aktual =select.getFirstSelectedOption().getText();
        String expected ="Eurozone (euro)";
        softAssert.assertEquals(aktual,expected,"eurozone testi FAİLT");

        List<WebElement> dropDawnList=select.getOptions();




    // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
    // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
    // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
    // "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
    // "Thailand (baht)"



    }

}
