package com.base;

import com.microsoft.playwright.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaunchBrowser {

    private Playwright playwright;
    private Browser browser;
    private BrowserType browserType;
    private BrowserContext browserContext;
    private Page page;

    private browserNames getBrowser(String browserName) {
        for (browserNames browserNames: browserNames.values()) {
            if (browserName.toUpperCase().trim().equals(browserNames.name())) {
                return browserNames;
            } else {
                System.out.println("Non supported browser !!!");
            }
        }
        return null;
    }

    private enum browserNames {
        CHROME,
        FIREFOX,
        SAFARI,
        CHROMIUM,
        EDGE
    }

    /**
     * Launches the specified browser, navigates to the given URL, and returns a list containing
     * the Playwright Page, Playwright instance, and BrowserContext objects.
     *
     * @param browserToLaunch the name of the browser to launch (e.g., "chrome", "firefox")
     * @return a List containing the Page, Playwright, and BrowserContext objects, in that order
     * @throws IllegalArgumentException if the specified browser is not supported
     */
    public List<Object> getBrowserPage(String browserToLaunch) {
        List<Object> playwrightsObjects = new ArrayList<>();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();

        playwright = Playwright.create();
        String browserName = getBrowser(browserToLaunch).name();
        if (browserName.equals(browserNames.CHROMIUM.name())) {
            browserType = playwright.chromium();
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        } else if (browserName.equals(browserNames.FIREFOX.name())) {
            browserType = playwright.firefox();
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false)
                    .setArgs(Arrays.asList("--start-maximized")));
        } else if (browserName.equals(browserNames.CHROME.name())) {
            browserType = playwright.chromium();
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        } else if (browserName.equals(browserNames.EDGE.name())) {
            browserType = playwright.chromium();
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
        }
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        page = browserContext.newPage();
        playwrightsObjects.add(playwright);
        playwrightsObjects.add(browserContext);
        playwrightsObjects.add(page);
        return playwrightsObjects;
    }

    public void CleanUpAndGarbageCollect() {
        if(browser.isConnected()) {
            browserContext.close();
            browser.close();
            playwright.close();
        }
    }
}
