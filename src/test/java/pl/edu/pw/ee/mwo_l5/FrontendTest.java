package pl.edu.pw.ee.mwo_l5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FrontendTest {

    private static WebDriver driver;
    public final static int TIMEOUT = 10;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }

    @Test
    public void testProductsPage() {
        driver.get("http://localhost:8080/products/all");

        WebElement productsTable = driver.findElement(By.id("table"));
        assert productsTable.isDisplayed();
    }

    @Test
    public void testAddProduct() {
        driver.get("http://localhost:8080/products/add");

        WebElement productNameInput = driver.findElement(By.id("name"));
        productNameInput.sendKeys("New Product");

        WebElement productDescriptionInput = driver.findElement(By.id("description"));
        productDescriptionInput.sendKeys("Great Product");

        WebElement productPriceInput = driver.findElement(By.id("price"));
        productPriceInput.sendKeys("100");

        WebElement addProductButton = driver.findElement(By.id("submit"));
        addProductButton.click();

        Assertions.assertEquals(driver.getCurrentUrl(), "http://localhost:8080/products/all");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
