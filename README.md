# UIElementsAutoHealer
A smart XPath locator machanism to locate UI elements to adapt to AUT changes (Auto/Self healing) by generating element locators in run-time dynamically and automate test cases without creating manual XPath/CSS locators (Object Repository) for selenium based projects. One approach for reducing test maintainance and assocaited costs and ensure a higher success rate in test automation.

# How to start

## 1. Add dependency

for Maven projects:

        <dependency>
            <groupId>io.github.alokpaatel</groupId>
            <artifactId>uihealerpro</artifactId>
            <version>1.6.0</version>
        </dependency>

## 2. Init driver instance of Auto Healing object

        //create driver instance
        WebDriver driver = new ChromeDriver();
        //create auto-healing object
        IUIElements uiElements = new UIElements(driver);

## 3. Call auto-healing methods to get automated XPath locator

       uiElements.getTextBoxLocator("Textbox field Name").sendKeys("Test");
       uiElements.getWebBtnLocator("Button Name").click();
       uiElements.getCheckboxLocator("Checkbox Name").click();
       uiElements.getRadioBtnLocator("Radio Button Name").click();
       uiElements.getLinkLocator("Hyperlink name").click();
       uiElements.getListBoxLocator("Listbox name").click();
       uiElements.getWebElementLocator("Webelement name").click();

  Note: You need to provide only element name inside methods. No need to create Xpath manually.
  Example: If you want to click on 'Submit' button then you need to write below code:
  
       uiElements.getWebBtnLocator("Submit").click();
           
  Autohealer will locate element by creating dynamic xpath in run-time based on Element name.


# About
UIElementsAutoHealer (Copyright © 2025) is a project created and maintained by [Alok Patel](https://github.com/alokpaatel) and licensed under the terms of the [Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0).
           

  



