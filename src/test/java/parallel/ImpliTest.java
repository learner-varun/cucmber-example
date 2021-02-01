package parallel;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ImpliTest {

    private WebDriver driver;
    String appURL = "http://google.com";
    @Given("^Initiate driver$")
    public void initiateDriver() {
        WebDriverManager.chromedriver().version("2.40").setup();
        driver = new ChromeDriver();
    }

    @And("^Do actions$")
    public void doActions() {
        driver.get(appURL);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.navigate().to("https://facebook.com");
        System.out.println(driver.getTitle());
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='1px solid red'", element);
        element.sendKeys("Testing Testing");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {


        }

    }

    @Then("^Close driver$")
    public void closeDriver() {
        driver.quit();
    }
}
