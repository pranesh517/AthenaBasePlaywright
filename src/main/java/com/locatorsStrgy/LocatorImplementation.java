package com.locatorsStrgy;

import com.microsoft.playwright.Locator;

import java.util.List;

public class LocatorImplementation implements AppLocators{

    private final AppLocators wrapper;

    public LocatorImplementation(AppLocators wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public Locator getCurrentLocator(String locator) {
        return wrapper.getCurrentLocator(locator);
    }

    @Override
    public Locator getCurrentLocator(Locator locator) {
        return wrapper.getCurrentLocator(locator);
    }

    @Override
    public Locator getChildInputLocator(String locator) {
        return wrapper.getChildInputLocator(locator);
    }

    @Override
    public Locator getChildInputLocator(Locator locator) {
        return wrapper.getChildInputLocator(locator);
    }

    @Override
    public Locator getChildButtonLocator(String locator) {
        return wrapper.getChildButtonLocator(locator);
    }

    @Override
    public Locator getChildButtonLocator(Locator locator) {
        return wrapper.getChildButtonLocator(locator);
    }

    @Override
    public Locator getChildInputLocatorAtIndex(String locator, int index) {
        return wrapper.getChildInputLocatorAtIndex(locator, index);
    }

    @Override
    public Locator getChildInputLocatorAtIndex(Locator locator, int index) {
        return wrapper.getChildInputLocatorAtIndex(locator, index);
    }

    @Override
    public Locator getChildButtonLocatorAtIndex(String locator, int index) {
        return wrapper.getChildButtonLocatorAtIndex(locator, index);
    }

    @Override
    public Locator getChildButtonLocatorAtIndex(Locator locator, int index) {
        return wrapper.getChildButtonLocatorAtIndex(locator, index);
    }

    @Override
    public List<Locator> getAllLocators(String locator) {
        return wrapper.getAllLocators(locator);
    }

    @Override
    public List<Locator> getAllLocators(Locator locator) {
        return wrapper.getAllLocators(locator);
    }
}
