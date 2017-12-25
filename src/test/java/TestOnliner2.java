import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TestOnliner2 {

    private final String URL = "https://catalog.onliner.by/mobile";
    private final By loginButtonLocator = By.cssSelector("div.auth-bar__item:nth-child(1)");
    private final By loginFieldLocator = By.cssSelector("div.auth-box__part:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
    private final By passwordFieldLocator = By.cssSelector("div.auth-box__part:nth-child(1) > div:nth-child(2) > input:nth-child(1)");
    private final By enterButtonLocator = By.cssSelector("div.auth-box__field > form > div:nth-child(3) > div > button");
    private final By phoneLinkLocator = By.cssSelector("div.schema-product__part.schema-product__part_2 >" +
            " div.schema-product__part.schema-product__part_4 > div.schema-product__title > a");
    private final By offersLocator = By.cssSelector("div.offers-description__part.offers-description__part_1 > a");
    private final By buttonBasketLocator = By.linkText("В корзину");
    private final By basketOpenLocator = By.xpath("//*[@id=\"b-top-navigation-cart\"]/li/a/span");
    private final By basketPageLocator = By.xpath("//*[@id=\"cart-main-container\"]/div[3]/div[2]/a");
    private final By productLocator = By.cssSelector("div.cart-product__part.cart-product__part_2 > div.cart-product-title > div > span");

    @Test
    public void checkOnliner() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/dev-tools/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        waitCssSearch(driver, loginButtonLocator);
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
        waitCssSearch(driver, loginFieldLocator);
        WebElement loginField = driver.findElement(loginFieldLocator);
        loginField.sendKeys("fanhead86");
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys("123onliner");
        WebElement enterButton = driver.findElement(enterButtonLocator);
        enterButton.click();
        sleep(30000);
        waitCssSearch(driver, phoneLinkLocator);
        WebElement phoneLink = driver.findElement(phoneLinkLocator);
        phoneLink.click();
        waitCssSearch(driver, offersLocator);
        WebElement offersLink = driver.findElement(offersLocator);
        offersLink.click();
        waitLinkTextSearch(driver, buttonBasketLocator);
        WebElement buttonBasket = driver.findElement(buttonBasketLocator);
        buttonBasket.click();
        waitXpathSearch(driver, basketOpenLocator);
        WebElement basketOpen = driver.findElement(basketOpenLocator);
        basketOpen.click();
        waitXpathSearch(driver, basketPageLocator);
        WebElement product = driver.findElement(productLocator);
            }

    private void waitCssSearch(WebDriver driver, final By cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (driver.findElement(cssSelector) != null) ? Boolean.TRUE : null;
            }
        });
    }

    private void waitLinkTextSearch(WebDriver driver, final By linkText) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (driver.findElement(linkText) != null) ? Boolean.TRUE : null;
            }
        });
    }
    private void waitXpathSearch(WebDriver driver, final By xPath) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (driver.findElement(xPath) != null) ? Boolean.TRUE : null;
            }
        });
    }
}