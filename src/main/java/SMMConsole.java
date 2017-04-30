import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Denis Emelyanov on 4/30/17.
 */
public class SMMConsole {
    private WebDriver driver = null;

    public SMMConsole(String smmcURL) {
        System.setProperty("webdriver.chrome.driver", "/Users/d752103/Documents/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get(smmcURL);
    }

    public SMMConsole() {
        this("https://127.0.0.1");
    }

    public SMMConsole login(String user, String pass) {
        //submit login form
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userName.sendKeys(user);
        loginPage.password.sendKeys(pass);
        loginPage.loginBtn.click();
        //wait till tabs will be visible
        waitForVisibility(By.id("contentTabs"), 30);

        return this;
    }

    public ConfigPage selectConfigTab(){
        ConfigPage configPage = new ConfigPage(driver);
        configPage.tab.click();
        //wait until Loading... will disappear for VitalsViewName field
        int maxAttempts = 60;
        while (configPage.clinicalSummaryConfig.getVitalsViewName().startsWith("Loading") && maxAttempts > 0)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            maxAttempts--;
        }
        return configPage;
    }

    public void waitForVisibility(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForVisibility(By by) {
        waitForVisibility(by, 5);
    }

}
