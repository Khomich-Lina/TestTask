package ui;

import assertion.PaymentPageSoftAssertionFactory;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public abstract class BaseUiTests {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PaymentPageSoftAssertionFactory softAssertionFactory;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        softAssertionFactory = new PaymentPageSoftAssertionFactory();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected String getPageUrl(Response response) {
        return response.jsonPath().getString("url");
    }
}