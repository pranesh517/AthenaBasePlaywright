package com.locatorsStrgy;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class BaseLocators implements AppLocators {

    private Page page;

    public BaseLocators(Page page) {
        this.page = page;
    }

    @Override
    public Locator getCurrentLocator(String locator) {
        return page.locator(locator);
    }

    @Override
    public Locator getCurrentLocator(Locator locator) {
        return locator;
    }

    @Override
    public Locator getChildInputLocator(String locator) {
        return page.locator(locator).locator("input");
    }

    @Override
    public Locator getChildInputLocator(Locator locator) {
        return locator.locator("input");
    }

    @Override
    public Locator getChildButtonLocator(String locator) {
        return page.locator(locator).locator("button");
    }

    @Override
    public Locator getChildButtonLocator(Locator locator) {
        return locator.locator("button");
    }

    @Override
    public Locator getChildInputLocatorAtIndex(String locator, int index) {
        return page.locator(locator).locator("input").nth(index);
    }

    @Override
    public Locator getChildInputLocatorAtIndex(Locator locator, int index) {
        return locator.locator("input").nth(index);
    }

    @Override
    public Locator getChildButtonLocatorAtIndex(String locator, int index) {
        return page.locator("button").nth(index);
    }

    @Override
    public Locator getChildButtonLocatorAtIndex(Locator locator, int index) {
        return locator.locator("button").nth(index);
    }

    @Override
    public List<Locator> getAllLocators(String locator) {
        page.waitForCondition(()-> page.locator(locator).all().size() >= 1);
        return page.locator(locator).all();
    }

    @Override
    public List<Locator> getAllLocators(Locator locator) {
        page.waitForCondition(()-> locator.all().size() >= 1);
        return locator.all();
    }
}
