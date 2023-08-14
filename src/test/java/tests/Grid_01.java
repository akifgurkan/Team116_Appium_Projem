package tests;

import manager.DriverManage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Grid_01 {

    // Selenium Gridi çalıştırmak için önce www.selenium.dev dowland sitesinden Selenium Grid son sürümünü indirin (şu an: selenium-server-4.11.0 var)
    // Ayrıca kullanacağımız bigisayarımızda yüklü brovserlerin
    // sürümüne göre ( browserde sağ üst 3 noktaya tıklayıp yardım dan son kullandığımız sürümü öğrenebiliriz)
    // Bilgisayarda (mesel masaüstünde bir boş klasör açıp bu indirdiklerimizi atıyoruz. Ve Komut İsteminden(CMS) bu klasörün adresine gelerek,
    // ya da bu klasördeyken adres çubuğuna bir kere tıklayıp cms yazarak direk de ulaşabiliriz. ya da
    // komut istemini açık klasör adresini kopyaladıktan sonra cd boşluk klasör adresini yapıştırıyoruz enrere basıyoruz VE

    // java -jar selenium-server-4.11.0.jar standalone

    // satırını buraya yaıştırıyoruz entere basıp çıkan adrese tıklıyoruz
    // Grid sayfası açılıyor burada çıkan URI adresini RemoteWebDriver e yapıştırıyoruz. Artık Gridi intellij den kullanabiliriz

    DriverManage driverManage = new DriverManage();
    static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.1.107:4444"), new ChromeOptions()); //Grid sayfasında çıkan url yi yapıştır.
        driver.get("https://www.youtube.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @Test
    void firefoxTest() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.1.107:4444"), new FirefoxOptions()); //Grid sayfasında çıkan url ui yapıştır.
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

    }

    @Test
    void remoteFirefoxDriverTest() {
        driver = driverManage.setUpFirefoxDriver();
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    void remoteChromeDriverTest() {
        driver = driverManage.setUpChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }


}