import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Denis Emelyanov on 4/30/17.
 */
public class SMMCTests extends Assert {
    @Test
    public void SMMCTest() {
        SMMConsole smmc = new SMMConsole("...");
        ConfigPage configPage = smmc.login("xxx", "yyy").selectConfigTab();
        System.out.println(configPage.security.getAllowCredentialsToBeSavedOnDevice());
        configPage.security.setAllowCredentialsToBeSavedOnDevice(false);
    }
}
