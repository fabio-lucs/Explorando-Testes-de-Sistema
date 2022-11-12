import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestsWithSelenium {

    private WebDriver driver;

    @Before
    public void makeWebDriver() {
        System.setProperty("chromedriver.exe" , "src\\driver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kabum.com.br/");
    }

    @After
    public void closeDriver() {
        this.driver.close();
        this.driver.quit();
    }

    @Test
    public void openKabumSiteTest() {
        Assert.assertEquals("https://www.kabum.com.br/", driver.getCurrentUrl());
    }

    @Test
    public void checkignTitlePageFalsetest() {
        String src = driver.getTitle();
        Assert.assertFalse(src == "Kabum");
        // Name Page is KaBuM! | Maior E-commerce de Tecnologia e Games da América
        // Latina
    }

    @Test
    public void searchExpectedOnKabumPageTest() {
        String searchTerm = "Xbox Series S".toLowerCase();
        driver.findElement(By.xpath("//*[@id=\"input-busca\"]")).sendKeys(searchTerm, Keys.ENTER);
        String result = driver
                .findElement(
                        By.xpath("//*[@id=\"listing\"]/div[3]/div/div[2]/div[1]/main/div[1]/a/div/button/div/h2/span"))
                .getText().toLowerCase();
        boolean resultTest = false;

        if (result.contains(searchTerm)) {
            resultTest = true;
        }

        Assert.assertTrue(resultTest);
    }

}
