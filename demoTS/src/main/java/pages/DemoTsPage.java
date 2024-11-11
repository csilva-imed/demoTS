package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoTsPage {
    private WebDriver driver;

    public DemoTsPage (WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath ="//*[@id='APjFqb']")
    private WebElement inputGoogle;

    public void abrirGoogle(){
        driver.get("https://www.google.com");
    }
    public void rellenarInputGoogle(String texto){
        inputGoogle.clear();
        inputGoogle.sendKeys(texto);
    }

}
