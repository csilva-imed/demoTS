package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DemoTsPage {
    private WebDriver driver;

    public DemoTsPage (WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void abrirGoogle(){

        driver.get("https://www.google.com");

    }


}
