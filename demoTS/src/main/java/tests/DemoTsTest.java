package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DemoTsPage;

public class DemoTsTest {
    private WebDriver driver;
    private static DemoTsPage demoTsPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        demoTsPage = new DemoTsPage(driver);
    }

    @Test
    public void abrirGoogleTest()  {

        demoTsPage.abrirGoogle();

    }

    @AfterClass
    public void tearDown(){

        if(driver != null){

            driver.quit();

        }

    }


}
