package A_testNGDeneme;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_NegetifLoginTesti {
    // 3 test method'u olusturun
    // 1.de yanlis email, dogru sifre
    // 2.de dogru email yanlis sifre
    // 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
    // giris yapilamadigini test edin
    QualitydemyPage qualitydemyPage=new QualitydemyPage();
    @Test
    public void yanlisEmail(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.loginButonu.click();
        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
//
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }




}
