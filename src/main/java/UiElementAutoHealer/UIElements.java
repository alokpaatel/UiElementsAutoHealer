package UiElementAutoHealer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UIElements implements IUIElements {
	
	public static WebDriver driver;
    GetElementLoc GetElementLoc = new ValidateElement();

	public UIElements(WebDriver driver) {
        UIElements.driver = driver;
	}

    public  WebElement getTextBoxLocator(String fieldName) {
        return driver.findElement(By.xpath(GetElementLoc.getElementXpath(fieldName, "TextBox")));
    }

    public  WebElement getTextBoxLocator(String fieldName, int index) {
        String xPath = GetElementLoc.getElementXpath(fieldName, "TextBox");
        return driver.findElement(By.xpath("("+xPath+")["+index+"]"));
    }

    public  WebElement getTextAreaLocator(String fieldName) {
        return driver.findElement(By.xpath(GetElementLoc.getElementXpath(fieldName, "Textarea")));
    }

    public  WebElement getWebBtnLocator(String fieldName) {
        return driver.findElement(By.xpath(GetElementLoc.getElementXpath(fieldName, "Button")));
    }

    public  WebElement getWebBtnLocator(String fieldName, int index) {
        String xPath = GetElementLoc.getElementXpath(fieldName, "Button");
        return driver.findElement(By.xpath("("+xPath+")["+index+"]"));
    }

    public  WebElement getLinkLocator(String fieldName) {
        return driver.findElement(By.xpath(GetElementLoc.getElementXpath(fieldName, "Link")));
    }

    public  WebElement getLinkLocator(String fieldName, int index) {
        String xPath = GetElementLoc.getElementXpath(fieldName, "Link");
        return driver.findElement(By.xpath("("+xPath+")["+index+"]"));
    }

    public  WebElement getListBoxLocator(String fieldName) {
        return driver.findElement(By.xpath(GetElementLoc.getElementXpath(fieldName, "ListBox")));
    }

    public  WebElement getListBoxLocator(String fieldName, int index) {
        String xPath = GetElementLoc.getElementXpath(fieldName, "ListBox");
        return driver.findElement(By.xpath("("+xPath+")["+index+"]"));
    }

    public  WebElement getCheckboxLocator(String fieldName) {
        return driver.findElement(By.xpath(GetElementLoc.getElementXpath(fieldName, "Checkbox")));
    }

    public  WebElement getCheckboxLocator(String fieldName, int index) {
        String xPath = GetElementLoc.getElementXpath(fieldName, "Checkbox");
        return driver.findElement(By.xpath("("+xPath+")["+index+"]"));
    }

    public  WebElement getRadioBtnLocator(String fieldName) {
        return driver.findElement(By.xpath(GetElementLoc.getElementXpath(fieldName, "Radiobutton")));
    }

    public  WebElement getRadioBtnLocator(String fieldName, int index) {
        String xPath = GetElementLoc.getElementXpath(fieldName, "Radiobutton");
        return driver.findElement(By.xpath("("+xPath+")["+index+"]"));
    }

    public  WebElement getTableLocator(String fieldName) {
        return driver.findElement(By.xpath(GetElementLoc.getElementXpath(fieldName, "Table")));
    }

    public  WebElement getWebElementLocator(String fieldName) {
        return driver.findElement(By.xpath(GetElementLoc.getElementXpath(fieldName, "WebElement")));
    }

    public  WebElement getWebElementLocator(String fieldName, int index) {
        String xPath = GetElementLoc.getElementXpath(fieldName, "WebElement");
        return driver.findElement(By.xpath("("+xPath+")["+index+"]"));
    }


}