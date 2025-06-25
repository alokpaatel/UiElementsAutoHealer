# uielements-autohealer
A smart XPath locator machanism to locate any UI element to adapt to AUT changes (Auto/Self healing) and automate test cases without creating XPath/CSS locators (Object Repository) manually for selenium based projects. One approach for reducing test maintainance and assocaited costs and ensure a higher success rate in test automation.

# How to start

## 1. Add dependency

for Maven projects:

        <dependency>
            <groupId>io.github.alokpaatel</groupId>
            <artifactId>uielements-autoHealer</artifactId>
            <version>1.0.0</version>
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
            uiElements.getTableLocator("Table name").click();

  Note: You need to provide only element name inside methods. No need to create Xpath manually.
  Example: If you want to click on 'Submit' button then you need to write below code:
  
           uiElements.getWebBtnLocator("Submit").click();
           
  Autohealer will locate element by creating dynamic xpath in run-time based on Element name.


#About
uielements-autohealer (Copyright © 2025) is a project created and maintained by  Alok Patel and licensed under the terms of the https://www.apache.org/licenses/LICENSE-2.0.
           

  



