
package io.github.autohealer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIElements implements IUIElements {
    public static WebDriver driver;
    GetElementLoc GetElementLoc = new ValidateElement();

    public UIElements(WebDriver var1) {
        driver = var1;
    }

    public WebElement getTextBoxLocator(String var1) {
        return driver.findElement(By.xpath(this.GetElementLoc.a(var1, "TextBox")));
    }

    public WebElement getTextBoxLocator(String var1, int var2) {
        String var3 = this.GetElementLoc.a(var1, "TextBox");
        return driver.findElement(By.xpath("(" + var3 + ")[" + var2 + "]"));
    }

    public WebElement getTextAreaLocator(String var1) {
        return driver.findElement(By.xpath(this.GetElementLoc.a(var1, "Textarea")));
    }

    public WebElement getWebBtnLocator(String var1) {
        return driver.findElement(By.xpath(this.GetElementLoc.a(var1, "Button")));
    }

    public WebElement getWebBtnLocator(String var1, int var2) {
        String var3 = this.GetElementLoc.a(var1, "Button");
        return driver.findElement(By.xpath("(" + var3 + ")[" + var2 + "]"));
    }

    public WebElement getLinkLocator(String var1) {
        return driver.findElement(By.xpath(this.GetElementLoc.a(var1, "Link")));
    }

    public WebElement getLinkLocator(String var1, int var2) {
        String var3 = this.GetElementLoc.a(var1, "Link");
        return driver.findElement(By.xpath("(" + var3 + ")[" + var2 + "]"));
    }

    public WebElement getListBoxLocator(String var1) {
        return driver.findElement(By.xpath(this.GetElementLoc.a(var1, "ListBox")));
    }

    public WebElement getListBoxLocator(String var1, int var2) {
        String var3 = this.GetElementLoc.a(var1, "ListBox");
        return driver.findElement(By.xpath("(" + var3 + ")[" + var2 + "]"));
    }

    public WebElement getCheckboxLocator(String var1) {
        return driver.findElement(By.xpath(this.GetElementLoc.a(var1, "Checkbox")));
    }

    public WebElement getCheckboxLocator(String var1, int var2) {
        String var3 = this.GetElementLoc.a(var1, "Checkbox");
        return driver.findElement(By.xpath("(" + var3 + ")[" + var2 + "]"));
    }

    public WebElement getRadioBtnLocator(String var1) {
        return driver.findElement(By.xpath(this.GetElementLoc.a(var1, "Radiobutton")));
    }

    public WebElement getRadioBtnLocator(String var1, int var2) {
        String var3 = this.GetElementLoc.a(var1, "Radiobutton");
        return driver.findElement(By.xpath("(" + var3 + ")[" + var2 + "]"));
    }

    public WebElement getTableLocator(String var1) {
        return driver.findElement(By.xpath(this.GetElementLoc.a(var1, "Table")));
    }

    public WebElement getWebElementLocator(String var1) {
        return driver.findElement(By.xpath(this.GetElementLoc.a(var1, "WebElement")));
    }

    public WebElement getWebElementLocator(String var1, int var2) {
        String var3 = this.GetElementLoc.a(var1, "WebElement");
        return driver.findElement(By.xpath("(" + var3 + ")[" + var2 + "]"));
    }
}
