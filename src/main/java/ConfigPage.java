import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Denis Emelyanov on 4/30/17.
 */
public class ConfigPage extends TabPage {

    public ConfigPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "contentTab3")
    @CacheLookup
    public WebElement tab;

    @FindBy(how = How.LINK_TEXT, using = "Save All Changes")
    @CacheLookup
    private WebElement saveAllChangesBtn;

    public void SaveChanges() {
        saveAllChangesBtn.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notifyUserOKButton")));
        getDriver().findElement(By.id("notifyUserOKButton")).click();
    }

    //*** Security section ***
    public SecuritySettings security = new SecuritySettings(getDriver());

    public class SecuritySettings {

        public SecuritySettings(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        //Allow credentials to be saved on device
        public boolean getAllowCredentialsToBeSavedOnDevice() {
            return allowSaveCredentialsYes.isSelected();
        }
        public void setAllowCredentialsToBeSavedOnDevice(boolean state) {
            if (state)
                allowSaveCredentialsYes.click();
            else
                allowSaveCredentialsNo.click();
        }

        @FindBy(how = How.ID, using = "allowSaveCredentialsYes")
        @CacheLookup
        private WebElement allowSaveCredentialsYes;

        @FindBy(how = How.ID, using = "allowSaveCredentialsNo")
        @CacheLookup
        private WebElement allowSaveCredentialsNo;
    }

    //*** Clinical Summary Config Settings section ***
    public ClinicalSummaryConfigSettings clinicalSummaryConfig = new ClinicalSummaryConfigSettings(getDriver());

    public class ClinicalSummaryConfigSettings {

        public ClinicalSummaryConfigSettings(WebDriver driver)
        {
            PageFactory.initElements(driver, this);
        }

        //Vitals View Name
        public String getVitalsViewName() {
            Select oSelect = new Select(vitalsViewNameDropdown);
            return oSelect.getFirstSelectedOption().getText();
        }

        public void setVitalsViewName(String viewName) {
            Select oSelect = new Select(vitalsViewNameDropdown);
            oSelect.selectByVisibleText(viewName);
        }

        @FindBy(how = How.ID, using = "vitalsViewNameDropdown")
        @CacheLookup
        private WebElement vitalsViewNameDropdown;
    }
}
