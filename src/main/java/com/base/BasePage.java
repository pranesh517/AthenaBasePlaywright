package com.base;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class BasePage {

    public void attachScreenshot(Page page, String screenshotName) {
        byte[] screenshot = page.screenshot();
        Allure.addAttachment(screenshotName, "image/png",new ByteArrayInputStream(screenshot), "png");
    }
}
