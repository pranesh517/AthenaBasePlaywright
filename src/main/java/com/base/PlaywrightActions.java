package com.base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;

public class PlaywrightActions {

    private Page page;

    public PlaywrightActions(Page page) {
        this.page = page;
    }

    public <T> boolean isElementVisible(T arg) {
        if (arg instanceof String) {
            try {
                page.waitForCondition(() -> page.locator((String) arg).isVisible());
                return true;
            } catch (TimeoutError e) {
                return false;
            }
        } else if (arg instanceof Locator){
            try {
                page.waitForCondition(()-> ((Locator) arg).isVisible());
                return true;
            } catch (TimeoutError e) {
                return false;
            }
        }
        return false;
    }

    public <T> boolean isElementVisible(T arg, int timeout) {
        if (arg instanceof String) {
            try {
                page.waitForCondition(() -> page.locator((String) arg).isVisible(),
                        new Page.WaitForConditionOptions().setTimeout(timeout));
                return true;
            } catch (TimeoutError e) {
                return false;
            }
        } else if (arg instanceof Locator){
            try {
                page.waitForCondition(()-> ((Locator) arg).isVisible(),
                        new Page.WaitForConditionOptions().setTimeout(timeout));
                return true;
            } catch (TimeoutError e) {
                return false;
            }
        }
        return false;
    }
}
