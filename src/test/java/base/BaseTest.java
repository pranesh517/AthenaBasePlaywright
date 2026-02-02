package base;

import com.base.LaunchBrowser;
import com.base.ReadConfigData;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Properties;

public class BaseTest {
    LaunchBrowser launchBrowser = new LaunchBrowser();
    ReadConfigData readConfigData = new ReadConfigData();
    private Page page;
    private Playwright athenaPlaywright;
    private BrowserContext athenaBrowserContext;

    @BeforeMethod
    public void getBrowserAndLaunchUrl() {
        Properties baseProperties = readConfigData.getBaseProperties();
        List<Object> objectList = launchBrowser.getBrowserPage(baseProperties.getProperty("browser"));
        page = (Page) objectList.get(2);
        athenaPlaywright = (Playwright) objectList.get(0);
        athenaBrowserContext = (BrowserContext) objectList.get(1);
    }

    @AfterMethod
    public void closeBrowser() {
        if (page != null) {
            page.close();
        }
    }

    public Page getPage() {
        return page;
    }

    public Playwright gethenaPlaywright() {
        return athenaPlaywright;
    }

    public BrowserContext getAthenaBrowserContext() {
        return athenaBrowserContext;
    }
}
