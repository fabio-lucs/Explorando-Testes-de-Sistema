import org.asynchttpclient.util.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestsWithSelenium {

    WebDriver driver;

    @Before
    public void makeWebDriverInstance() {
        this.driver = new ChromeDriver();
    }

    public void openWebSite() {

    }

    @After
    public void closeDriver() {
        this.driver.close();
        this.driver.quit();
    }


    @Test
    public void openKabumSiteTest() {

        driver.manage().window().maximize();
        driver.get("https://www.kabum.com.br/");
        Assert.assertEquals("https://www.kabum.com.br/", driver.getCurrentUrl());
    }

    @Test
    public void searchExpectedOnKabumPageTest() {
        String searchTerm = "Xbox Series S".toLowerCase();
        driver.get("https://www.kabum.com.br/");
        driver.findElement(By.xpath("//*[@id=\"input-busca\"]")).sendKeys(searchTerm, Keys.ENTER);
        String result = driver.findElement(By.xpath("//*[@id=\"listing\"]/div[3]/div/div[2]/div[1]/main/div[1]/a/div/button/div/h2/span")).getText().toLowerCase();
        boolean resultTest = false;

        if (result.contains(searchTerm)) {
            resultTest = true;
        }

        Assert.assertTrue(resultTest);
    }

//    @Test
//    public void searchNotExpectedKabumPageTest() {
//        driver.manage().window().maximize();
//        driver.get("https://www.kabum.com.br/");
//        Actions actions = new Actions(driver);
//        WebElement lancamentosButton = driver.findElement(By.xpath("//*[@id=\"lancamentosMenuSuperior\"]"));
//
//        actions.moveToElement(lancamentosButton).perform();
//
//
//
//    }
}
