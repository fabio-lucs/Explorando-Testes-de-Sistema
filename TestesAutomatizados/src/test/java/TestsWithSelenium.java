import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsWithSelenium {


    @Test
    public void openKabumSite(){
        System.setProperty("webdriver.chrome.driver" , "F:\\Users\\fabio\\Projects\\Eng Sof 1\\Explorando-Testes-de-Sistema\\TestesAutomatizados\\src\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kabum.com.br/");
        WebElement searchBox =  driver.findElement(By.xpath("//*[@id=\"input-busca\"]"));
        searchBox.click();
        searchBox.sendKeys("xbox series s" , Keys.ENTER);
    }
}
