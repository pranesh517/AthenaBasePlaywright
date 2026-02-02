package com.locatorsStrgy;

import com.microsoft.playwright.Locator;

import java.util.List;

public interface AppLocators {

    Locator getCurrentLocator(String locator);

    Locator getCurrentLocator(Locator locator);

    Locator getChildInputLocator(String locator);

    Locator getChildInputLocator(Locator locator);

    Locator getChildButtonLocator(String locator);

    Locator getChildButtonLocator(Locator locator);

    Locator getChildInputLocatorAtIndex(String locator, int index);

    Locator getChildInputLocatorAtIndex(Locator locator, int index);

    Locator getChildButtonLocatorAtIndex(String locator, int index);

    Locator getChildButtonLocatorAtIndex(Locator locator, int index);

    List<Locator> getAllLocators(String locator);

    List<Locator> getAllLocators(Locator locator);
}
