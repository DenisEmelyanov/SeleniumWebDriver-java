import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Denis Emelyanov on 4/30/17.
 */
public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "loginUsernameTextbox")
    @CacheLookup
    public WebElement userName;

    @FindBy(how = How.ID, using = "loginPasswordTextbox")
    @CacheLookup
    public WebElement password;

    @FindBy(how = How.ID, using = "loginButton")
    @CacheLookup
    public WebElement loginBtn;
}
