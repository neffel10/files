import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ALE\\Downloads\\chromedriver.exe");

        //Creamos una nueva instancia de Chrome Driver
        WebDriver driver = new ChromeDriver();

        driver.get("https://fer.org.mx/contacto/");

        submitForm(driver);
        waitForAlertBanner(driver);
        assertEquals("This field is required.",getAlertBannerText(driver));
        //otherStuff(driver);
        //driver.quit();
    }
    public static void submitForm(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("evf-472-field_lVizlNhYus-1")).sendKeys("Alessandro");
        driver.findElement(By.id("evf-472-field_XYnMdkQDKM-3")).sendKeys("aletl10@hotmail.com");
        driver.findElement(By.id("evf-submit-472")).click();
    }

    public static void waitForAlertBanner(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("evf-472-field_xJivsqAS2c-2-error")));
    }

    public static String getAlertBannerText(WebDriver driver){
        return driver.findElement(By.id("evf-472-field_xJivsqAS2c-2-error")).getText();
    }

    /*
    public static void otherStuff(WebDriver driver){
        driver.findElement(By.xpath("//*[@id=\"menu-item-547\"]/a")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2750)", "");

        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.findElement(By.xpath("//*[@id=\"i114\"]/div[2]")).click();

    }*/
}

