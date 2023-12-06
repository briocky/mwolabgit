package pl.edu.pw.ee.mwo_l5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FrontendTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new FirefoxDriver();
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
