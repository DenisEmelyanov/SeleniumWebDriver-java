# SeleniumWebDriver-java

SeleniumWebDriver

Page Factory concept example.

Usage:
```java
public class SMMCTests extends Assert {
    @Test
    public void SMMCTest() {
        SMMConsole smmc = new SMMConsole("...");
        ConfigPage configPage = smmc.login("xxx", "yyy").selectConfigTab();
        System.out.println(configPage.security.getAllowCredentialsToBeSavedOnDevice());
        configPage.security.setAllowCredentialsToBeSavedOnDevice(false);
    }
}
```
