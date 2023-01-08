package A_testNGDeneme;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C05_zeroSiteTesti extends TestBaseRapor {
//
    @Test
    public void Test01(){

    extentTest=extentReports.createTest("Zero Testi","Açılır Sekme Kontrol testi");

    // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
    // 2. Sign in butonuna basin

        ZeroWebAppPage zeroWebAppPage=new ZeroWebAppPage();
        zeroWebAppPage.signInButonu.click();

    // 3. Login kutusuna “username” yazin
        zeroWebAppPage.usernameKutusu.sendKeys("username");

    // 4. Password kutusuna “password” yazin
        zeroWebAppPage.passwordKutusu.sendKeys("password");

    // 5. Sign in tusuna basin
        zeroWebAppPage.signInSubmitButonu.click();

    // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        zeroWebAppPage.payBillLinki.click();

    // 7. “Purchase Foreign Currency” tusuna basin
        zeroWebAppPage.purchaseFCButonu.click();

    // 8. “Currency” drop down menusunden Eurozone’u secin

        Select select=new Select(zeroWebAppPage.currencyDropdown);
        select.selectByVisibleText("Eurozone (euro)");

    // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String aktualSelect=select.getFirstSelectedOption().getText();
        String expectedSelect="Eurozone (euro)";
        softAssert.assertEquals(aktualSelect,expectedSelect,"drop down menüsü ilk select testi");

    // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin

        List<WebElement> dropDownList=select.getOptions();
        List<String> actualOptionsListesiStr=new ArrayList<>();

        for (WebElement each:dropDownList
             ) {
            actualOptionsListesiStr.add(each.getText());
        }

        String [] arr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                 "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                 "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
                 "Thailand (baht)"};
        List<String> expectedOptionsListesi=Arrays.asList(arr);

        Collections.sort(actualOptionsListesiStr);
        Collections.sort(expectedOptionsListesi);

        softAssert.assertEquals(actualOptionsListesiStr,expectedOptionsListesi,"Drop dawn liste testi FAİLD");




    // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
    // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
    // "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
    // "Thailand (baht)"

    }






}
