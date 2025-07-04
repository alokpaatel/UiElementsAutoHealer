
package io.github.autohealer;

import org.openqa.selenium.WebElement;

public interface IUIElements {
    WebElement getTextBoxLocator(String var1);

    WebElement getTextBoxLocator(String var1, int var2);

    WebElement getTextAreaLocator(String var1);

    WebElement getWebBtnLocator(String var1);

    WebElement getWebBtnLocator(String var1, int var2);

    WebElement getLinkLocator(String var1);

    WebElement getLinkLocator(String var1, int var2);

    WebElement getListBoxLocator(String var1);

    WebElement getListBoxLocator(String var1, int var2);

    WebElement getCheckboxLocator(String var1);

    WebElement getCheckboxLocator(String var1, int var2);

    WebElement getRadioBtnLocator(String var1);

    WebElement getRadioBtnLocator(String var1, int var2);

    WebElement getTableLocator(String var1);

    WebElement getWebElementLocator(String var1);

    WebElement getWebElementLocator(String var1, int var2);
}
