package UiElementAutoHealer;

import org.apache.commons.text.WordUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static UiElementAutoHealer.UIElements.driver;


public class ValidateElement extends GetElementLoc {

    public static boolean insideFrameElement;
    public static WebElement frameElement;
    private static WebDriver jsWaitDriver;
    private static WebDriverWait jsWait;
    private static JavascriptExecutor jsExec;
    public static String tagName;


    public static void waitAllRequest() {
        waitUntilJSReady();
        ajaxComplete();
        waitUntilJQueryReady();
        waitUntilAngularReady();
        waitUntilAngular5Ready();
    }

    public static boolean verifyTagName(String elementLocator, String childTag){
        String tagName1 = "";
        try {
            if (!driver.findElements(By.xpath(elementLocator)).isEmpty()) {
                try {
                    tagName1 = driver.findElement(By.xpath(elementLocator)).getTagName();
                } catch (Exception _) {
                }
                if (tagName1.toLowerCase().contains(childTag.toLowerCase())) {
                    return true;
                }
            }
        }catch(Exception _){}
        return false;
    }

    public static String getTagName(String caseXpath, String childTag){
        String elementLocator;

        for(int i=1;i<=20;i++){
            elementLocator = caseXpath + "/following::*["+i+"]";
            try {
                tagName = driver.findElement(By.xpath(elementLocator)).getTagName();
            }catch(Exception _){}
            if(tagName.toLowerCase().contains(childTag.toLowerCase())){
                return tagName;
            }
        }
        for(int i=1;i<=20;i++) {
            elementLocator = caseXpath + "/preceding::*[" + i + "]";
            try {
                tagName = driver.findElement(By.xpath(elementLocator)).getTagName();
            } catch (Exception e) {
            }
            if (tagName.toLowerCase().contains(childTag.toLowerCase())) {
                return tagName;
            }
        }

        if(tagName.equalsIgnoreCase("")){
            tagName =  childTag;
        }
        return tagName;
    }

    public static WebElement searchElementByXpath(String xpath) {
        WebElement element = null;
        try {
            element = driver.findElement(By.xpath(xpath));
        } catch (Exception e) {
        }
        return element;
    }

    public static String validateXpath(String caseXpath, String childTag) {
        String elementLocator;
        String containsCondition = "contains(@type, 'submit') or contains(@type, 'checkbox')";
        childTag = getTagName(caseXpath, childTag);

        elementLocator = caseXpath + "/"+childTag + "[not(" + containsCondition + ")][1]";
        if (verifyTagName(elementLocator, childTag)) {
            return elementLocator;
        }

        return elementLocator;
    }

    public static boolean verifyCheckRadioElements(String elementLocator, String field){
        try {
            if (!driver.findElements(By.xpath(elementLocator)).isEmpty()) {
                String fieldName = Objects.requireNonNull(driver.findElement(By.xpath(elementLocator)).getAccessibleName()).trim();
                //String fieldName = driver.findElement(By.xpath(elementLocator)).getText().trim();
                if (fieldName.equalsIgnoreCase(field.trim())) {
                    //return true;
                }
                return true;
            }
        }catch(Exception _){}
        return false;
    }

    public static WebElement shiftAndGetElement(String xpath) {
        frameElement = null;
        shiftAndGetElementInFrame(xpath);
        return frameElement;
    }

    public static void shiftAndGetElementInFrame(String xpath) {
        if (frameElement == null) {
            List<WebElement> listOfFrames = driver.findElements(By.tagName("frame"));
            listOfFrames.addAll(driver.findElements(By.tagName("iframe")));
            for (WebElement frame : listOfFrames) {
                try {
                    try {
                        if (!frame.isDisplayed()) {
                            continue;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                    driver.switchTo().frame(frame);
                } catch (Exception e) {

                    continue;
                }
                frameElement = searchElementByXpath(xpath);
                if (frameElement == null) {
                    List<WebElement> framesList = driver.findElements(By.tagName("frame"));
                    framesList.addAll(driver.findElements(By.tagName("iframe")));
                    if (!framesList.isEmpty()) {
                        shiftAndGetElementInFrame(xpath);
                        if (frameElement != null && !driver.findElements(By.xpath(xpath)).isEmpty()) {
                            break;
                        }
                    }
                    driver.switchTo().parentFrame();
                } else {
                    if (!driver.findElements(By.xpath(xpath)).isEmpty()) {
                        break;
                    } else {
                        driver.switchTo().parentFrame();
                    }
                }
            }
        }
    }

    public static String getElement(String textNormlisation, String fieldCase) {

        String getElement="";
        getElement= "//*[normalize-space(.)='" + textNormlisation.trim()+"']";
        if (!driver.findElements(By.xpath(getElement)).isEmpty()) {
            return getElement;
        }
        getElement= "//*[normalize-space(.)='" + textNormlisation.toLowerCase().trim()+"']";
        if (!driver.findElements(By.xpath(getElement)).isEmpty()) {
            return getElement;
        }
        getElement= "//*[normalize-space(.)='" + textNormlisation.toUpperCase().trim()+"']";
        if (!driver.findElements(By.xpath(getElement)).isEmpty()) {
            return getElement;
        }
        getElement= "//*[normalize-space(.)='" + fieldCase.trim()+"']";
        if (!driver.findElements(By.xpath(getElement)).isEmpty()) {
            return getElement;
        }
        getElement= "//*[normalize-space(text())='" + fieldCase.trim()+"']";
        if (!driver.findElements(By.xpath(getElement)).isEmpty()) {
            return getElement;
        }
        getElement= "//*[normalize-space(text())='" + textNormlisation.toLowerCase().trim()+"']";
        if (!driver.findElements(By.xpath(getElement)).isEmpty()) {
            return getElement;
        }
        getElement= "//*[normalize-space(text())='" + textNormlisation.toUpperCase().trim()+"']";
        if (!driver.findElements(By.xpath(getElement)).isEmpty()) {
            return getElement;
        }
        getElement= "//*[normalize-space(text())='" + fieldCase.trim()+"']";
        if (!driver.findElements(By.xpath(getElement)).isEmpty()) {
            return getElement;
        }

        return getElement;
    }

    public String getFieldValue(String field) {

        if (!driver.findElements(By.xpath(getElementXpath(field, "WebElement"))).isEmpty()) {
            //System.out.println(getElementXpath(field, "WebElement"));
            String elementLocator = "" + getElementXpath(field, "WebElement") + "/following-sibling::td[1]";
            if (!driver.findElements(By.xpath(elementLocator)).isEmpty()) {
                WebElement getValue=driver.findElement(By.xpath(elementLocator));
                return getValue.getAttribute("textContent");
            }
            elementLocator = "" + getElementXpath(field, "WebElement") + "/following::span[1]";
            if (!driver.findElements(By.xpath(elementLocator)).isEmpty()) {
                WebElement getValue=driver.findElement(By.xpath(elementLocator));
                return getValue.getAttribute("textContent");
            }else {
                return "";
            }
        }
        return null;
    }

    public void setFieldValueinTable(String fieldVal, String ColumnName, int RowNum, String TableName ) {
        WebElement htmltable=driver.findElement(By.xpath(getElementXpath(TableName, "Table")));
        List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
        int colNum = 0;
        outerloop:
        for(int rnum=0;rnum<rows.size();rnum++)
        {
            List<WebElement> columns=rows.get(rnum).findElements(By.tagName("th"));
            //System.out.println("Number of columns:"+columns.size());
            for(int cnum=0;cnum<columns.size();cnum++)
            {
                //System.out.println(columns.get(cnum).getText());
                if(columns.get(cnum).getText().equalsIgnoreCase(ColumnName)) {
                    colNum=cnum;
                    break outerloop;
                }
            }
        }
        htmltable=driver.findElement(By.xpath("//*[normalize-space(.)='"+TableName+"']/following::table/tbody"));
        rows=htmltable.findElements(By.tagName("tr"));
        List<WebElement> columns=rows.get(RowNum-1).findElements(By.tagName("td"));
        StringSelection stringSelection = new StringSelection(fieldVal);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        columns.get(colNum).click();
        //columns.get(colNum).sendKeys("H");

        Actions actions = new Actions(driver);
        actions.sendKeys(fieldVal).build().perform();

    }

    public static void isElementReady(String field) {
        try {
            Thread.sleep(50);
        } catch (Exception e) {}
        for (int i=0; i<30; i++){
            try {
                waitAllRequest();
            }catch (Exception _) {}
            try {
                if (!driver.findElements(By.xpath(field)).isEmpty()) {
                    break;
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (Exception _) {
                    }
                }
            }catch(Exception _){
                break;
            }

        }
    }

    private static void ajaxComplete() {
        jsExec = (JavascriptExecutor) jsWaitDriver;
        jsExec.executeScript("var callback = arguments[arguments.length - 1];"
                + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
                + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
                + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
    }

    private static void waitForJQueryLoad() {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, Duration.ofSeconds(10));
        jsExec = (JavascriptExecutor) jsWaitDriver;
        try {
            ExpectedCondition<Boolean> jQueryLoad = jsWaitDriver -> (Boolean) ((Long) ((JavascriptExecutor) driver)
                                .executeScript("return jQuery.active") == 0);
            boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");
            if (!jqueryReady) {
                jsWait.until(jQueryLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    private static void waitForAngularLoad() {
        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
        angularLoads(angularReadyScript);
    }

    private static void waitUntilJSReady() {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, Duration.ofSeconds(10));
        jsExec = (JavascriptExecutor) jsWaitDriver;
        try {
            ExpectedCondition<Boolean> jsLoad = jsWaitDriver -> (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState").toString().equals("complete");
            boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");
            if (!jsReady) {
                jsWait.until(jsLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    private static void waitUntilJQueryReady() {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, Duration.ofSeconds(10));
        jsExec = (JavascriptExecutor) jsWaitDriver;
        Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined) {
            poll();
            waitForJQueryLoad();
            poll();
        }
    }

    public static void waitUntilAngularReady() {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, Duration.ofSeconds(10));
        jsExec = (JavascriptExecutor) jsWaitDriver;
        try {
            Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
            if (!angularUnDefined) {
                Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
                if (!angularInjectorUnDefined) {
                    poll();
                    waitForAngularLoad();
                    poll();
                }
            }
        } catch (WebDriverException ignored) {
        }
    }

    public static boolean verifyCheckElements(String elementLocator, String field){
        try {
            if (!driver.findElements(By.xpath(elementLocator)).isEmpty()) {
                String fieldName = Objects.requireNonNull(driver.findElement(By.xpath(elementLocator)).getAccessibleName()).trim();
                //String fieldName = driver.findElement(By.xpath(elementLocator)).getText().trim();
                if (fieldName.equalsIgnoreCase(field.trim())) {
                    //return true;
                }
                return true;
            }
        }catch(Exception _){}
        return false;
    }

    public static boolean verifyRadioElements(String elementLocator, String field){
        try {
            if (!driver.findElements(By.xpath(elementLocator)).isEmpty()) {
                String fieldName = Objects.requireNonNull(driver.findElement(By.xpath(elementLocator)).getAccessibleName()).trim();
                //String fieldName = driver.findElement(By.xpath(elementLocator)).getText().trim();
                if (fieldName.equalsIgnoreCase(field.trim())) {
                    //return true;
                }
                return true;
            }
        }catch(Exception _){}
        return false;
    }

    public static void waitUntilAngular5Ready() {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, Duration.ofSeconds(10));
        jsExec = (JavascriptExecutor) jsWaitDriver;
        try {
            Object angular5Check = jsExec.executeScript("return getAllAngularRootElements()[0].attributes['ng-version']");
            if (angular5Check != null) {
                Boolean angularPageLoaded = (Boolean) jsExec.executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1");
                if (Boolean.FALSE.equals(angularPageLoaded)) {
                    poll();
                    waitForAngular5Load();
                    poll();
                }
            }
        } catch (WebDriverException ignored) {
        }
    }

    private static void waitForAngular5Load() {
        String angularReadyScript = "return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1";
        angularLoads(angularReadyScript);
    }

    private static void angularLoads(String angularReadyScript) {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, Duration.ofSeconds(10));
        jsExec = (JavascriptExecutor) jsWaitDriver;
        try {
            ExpectedCondition<Boolean> angularLoad = jsWaitDriver -> {
                assert jsWaitDriver != null;
                return Boolean.valueOf(Objects.requireNonNull(((JavascriptExecutor) jsWaitDriver)
                        .executeScript(angularReadyScript)).toString());
            };
            boolean angularReady = Boolean.parseBoolean(Objects.requireNonNull(jsExec.executeScript(angularReadyScript)).toString());
            if (!angularReady) {
                jsWait.until(angularLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    public String getElementXpath(String field, String fieldType) {
        String xPath = "";
        WebElement element = null;
        if (!field.equalsIgnoreCase("") && !fieldType.equalsIgnoreCase("")) {
            String fieldCase = null;
            fieldCase = field.substring(0, 1).toUpperCase() + field.substring(1).toLowerCase();
            String fieldCaseCap = WordUtils.capitalizeFully(field);
            String textNormlisation = field.trim().replaceAll("[\\t\\n\\r]+", "");
            String caseSenXpath = "";
            String s = "\"" + field.trim() + "\"";
            String xPath123 = "contains(text(), "+s+")";
            String normalizeSpaceDot = "normalize-space(.)='" + textNormlisation.trim() + "' or normalize-space(.)='"
                    + textNormlisation.toLowerCase().trim() + "' or normalize-space(.)='"
                    + textNormlisation.toUpperCase().trim() + "' or normalize-space(.)='" + fieldCase.trim()
                    + "' or normalize-space(.)='" + fieldCaseCap.trim() + "'";

            String normalizeSpaceText = "normalize-space(text())='" + textNormlisation.trim()
                    + "' or normalize-space(text())='" + textNormlisation.toLowerCase().trim()
                    + "' or normalize-space(text())='" + textNormlisation.toUpperCase().trim()
                    + "' or normalize-space(text())='" + fieldCase.trim()
                    + "' or @placeholder = '"+ textNormlisation.trim()
                    + "' or normalize-space(text())='" + fieldCaseCap.trim() + "'";

            boolean elementDisplayed;
            try {
                element = searchElementByXpath(caseSenXpath);
                if (element == null) {
                    driver.switchTo().defaultContent();
                    element = searchElementByXpath(caseSenXpath);
                }
                if (element == null) {
                    driver.switchTo().defaultContent();
                    element = shiftAndGetElement(caseSenXpath);
                }
            }catch(Exception e){}


            fieldCase = field.substring(0, 1).toUpperCase() + field.substring(1).toLowerCase();
            textNormlisation = field.trim().replaceAll("[\\t\\n\\r]+", "");
            caseSenXpath=getElement(textNormlisation, fieldCase);
            if (!fieldType.equalsIgnoreCase("Button")) {
                try {
                    if (driver.findElements(By.xpath(caseSenXpath)).size() <= 0) {
                        normalizeSpaceDot = "contains(text(),'" + textNormlisation.trim() + "') or contains(text(),'"
                                + textNormlisation.toLowerCase().trim() + "') or contains(text(),'"
                                + textNormlisation.toUpperCase().trim() + "') or contains(text(),'" + fieldCase.trim()
                                + "')";
                        caseSenXpath = "//*[" + normalizeSpaceDot + "]";
                        element = searchElementByXpath(caseSenXpath);
                        if (element == null) {
                            driver.switchTo().defaultContent();
                            element = searchElementByXpath(caseSenXpath);
                        }
                        if (element == null) {
                            driver.switchTo().defaultContent();
                            element = shiftAndGetElement(caseSenXpath);
                        }
                    }
                } catch (Exception e) {
                    normalizeSpaceDot = "contains(text(),'" + textNormlisation.trim() + "') or contains(text(),'"
                            + textNormlisation.toLowerCase().trim() + "') or contains(text(),'"
                            + textNormlisation.toUpperCase().trim() + "') or contains(text(),'" + fieldCase.trim()
                            + "')";
                    caseSenXpath = "//*[" + normalizeSpaceDot + "]";
                    element = searchElementByXpath(caseSenXpath);
                    if (element == null) {
                        driver.switchTo().defaultContent();
                        element = searchElementByXpath(caseSenXpath);
                    }
                    if (element == null) {
                        driver.switchTo().defaultContent();
                        element = shiftAndGetElement(caseSenXpath);
                    }
                }
            }
        }

        //System.out.println(xPath);
        if(xPath!="") {
            WebElement elementLocated = driver.findElement(By.xpath(xPath));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].scrollIntoView();", elementLocated);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(
                    ExpectedConditions.and(
                            ExpectedConditions.elementToBeClickable(By.xpath(xPath)),
                            ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))
                    )
            );
        }
        return xPath;
    }

    public boolean verifyElements(String xpath){
        try {
            if (!driver.findElements(By.xpath(xpath)).isEmpty()) {
                return true;
            }
        }catch(Exception _){}
        return false;
    }

    public void waitForElementAreComplete(By by, int expected) {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, Duration.ofSeconds(10));
        jsExec = (JavascriptExecutor) jsWaitDriver;
        ExpectedCondition<Boolean> angularLoad = driver -> {
            int loadingElements = driver.findElements(by).size();
            return (Boolean) (loadingElements >= expected);
        };
        jsWait.until(angularLoad);
    }

    public void waitForAnimationToComplete(String css) {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, Duration.ofSeconds(10));
        jsExec = (JavascriptExecutor) jsWaitDriver;
        ExpectedCondition<Boolean> angularLoad = driver -> {
            int loadingElements = driver.findElements(By.cssSelector(css)).size();
            return (Boolean) (loadingElements == 0);
        };
        jsWait.until(angularLoad);
    }

    private static void poll() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }


}