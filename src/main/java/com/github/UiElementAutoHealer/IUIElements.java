package com.github.UiElementAutoHealer;

import org.openqa.selenium.WebElement;

public interface IUIElements {
    WebElement getTextBoxLocator(String fieldName);
    WebElement getTextBoxLocator(String fieldName, int index);
    WebElement getTextAreaLocator(String fieldName);
    WebElement getWebBtnLocator(String fieldName);
    WebElement getWebBtnLocator(String fieldName, int index);
    WebElement getLinkLocator(String fieldName);
    WebElement getLinkLocator(String fieldName, int index);
    WebElement getListBoxLocator(String fieldName);
    WebElement getListBoxLocator(String fieldName, int index);
    WebElement getCheckboxLocator(String fieldName);
    WebElement getCheckboxLocator(String fieldName, int index);
    WebElement getRadioBtnLocator(String fieldName);
    WebElement getRadioBtnLocator(String fieldName, int index);
    WebElement getTableLocator(String fieldName);
    WebElement getWebElementLocator(String fieldName);
    WebElement getWebElementLocator(String fieldName, int index);
}