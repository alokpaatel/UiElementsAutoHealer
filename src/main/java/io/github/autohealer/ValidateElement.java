
package io.github.autohealer;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ValidateElement.b;
import static ValidateElement.b;

public class ValidateElement extends GetElementLoc {
    public static boolean a;
    public static WebElement b;
    private static WebDriver e;
    private static WebDriverWait f;
    private static JavascriptExecutor g;
    public static String c;

    public static void a() {
        g();
        d();
        h();
        b();
    }

    public static boolean b(String var0, String var1) {
        String var2 = "";

        try {
            if (!UIElements.driver.findElements(By.xpath(var0)).isEmpty()) {
                try {
                    var2 = UIElements.driver.findElement(By.xpath(var0)).getTagName();
                } catch (Exception var4) {
                }

                if (var2.equalsIgnoreCase(var1)) {
                    return true;
                }
            }
        } catch (Exception var5) {
        }

        return false;
    }

    public static String c(String var0, String var1) {
        String var3 = "";

        for(int var4 = 1; var4 <= 20; ++var4) {
            String var2 = var0 ;

            try {
                c = UIElements.driver.findElement(By.xpath(var2)).getTagName();
            } catch (Exception var7) {
            }

            if (c.equalsIgnoreCase(var1)) {
                return c;
            }

            if (c.contains(var1)) {
                var3 = c;
            }
        }

        for(int var9 = 1; var9 <= 20; ++var9) {
            String var8 = var0;

            try {
                c = UIElements.driver.findElement(By.xpath(var8)).getTagName();
            } catch (Exception var6) {
            }

            if (c.equalsIgnoreCase(var1)) {
                return c;
            }

            if (c.contains(var1)) {
                var3 = c;
            }
        }

        if (!var3.equalsIgnoreCase("")) {
            c = var3;
        }

        return c;
    }

    public static WebElement a(String var0) {
        WebElement var1 = null;

        try {
            var1 = UIElements.driver.findElement(By.xpath(var0));
        } catch (Exception var3) {
        }

        return var1;
    }

    public static WebElement b(String var0) {
        b = null;
        c(var0);
        return b;
    }

    public static void c(String var0) {
        if (b == null) {
            List var1 = UIElements.driver.findElements(By.tagName("frame"));
            var1.addAll(UIElements.driver.findElements(By.tagName("iframe")));
            Iterator var3 = var1.iterator();

            while(true) {
                while(true) {
                    if (!var3.hasNext()) {
                        return;
                    }

                    WebElement var2 = (WebElement)var3.next();

                    try {
                        try {
                            if (!var2.isDisplayed()) {
                                continue;
                            }
                        } catch (Exception var5) {
                            continue;
                        }

                        UIElements.driver.switchTo().frame(var2);
                        break;
                    } catch (Exception var6) {
                    }
                }

                b = a(var0);
                if (b == null) {
                    List var4 = UIElements.driver.findElements(By.tagName("frame"));
                    var4.addAll(UIElements.driver.findElements(By.tagName("iframe")));
                    if (var4.size() > 0) {
                        c(var0);
                        if (b != null && UIElements.driver.findElements(By.xpath(var0)).size() > 0) {
                            break;
                        }
                    }

                    UIElements.driver.switchTo().parentFrame();
                } else {
                    if (UIElements.driver.findElements(By.xpath(var0)).size() > 0) {
                        break;
                    }

                    UIElements.driver.switchTo().parentFrame();
                }
            }
        }

    }


    public String d(String var1) {
        if (!UIElements.driver.findElements(By.xpath(this.a(var1, "WebElement"))).isEmpty()) {
            String var2 = this.a(var1, "WebElement") + "/::td[1]";
            if (!UIElements.driver.findElements(By.xpath(var2)).isEmpty()) {
                WebElement var5 = UIElements.driver.findElement(By.xpath(var2));
                return var5.getAttribute("textContent");
            } else {
                var2 = this.a(var1, "WebElement") + "/::span[1]";
                if (!UIElements.driver.findElements(By.xpath(var2)).isEmpty()) {
                    WebElement var3 = UIElements.driver.findElement(By.xpath(var2));
                    return var3.getAttribute("textContent");
                } else {
                    return "";
                }
            }
        } else {
            return null;
        }
    }

    public void a(String var1, String var2, int var3, String var4) {
        WebElement var5 = UIElements.driver.findElement(By.xpath(this.a(var4, "Table")));
        List var6 = var5.findElements(By.tagName("tr"));
        int var7 = 0;

        label24:
        for(int var8 = 0; var8 < var6.size(); ++var8) {
            List var9 = ((WebElement)var6.get(var8)).findElements(By.tagName("th"));

            for(int var10 = 0; var10 < var9.size(); ++var10) {
                if (((WebElement)var9.get(var10)).getText().equalsIgnoreCase(var2)) {
                    var7 = var10;
                    break label24;
                }
            }
        }

        var5 = UIElements.driver.findElement(By.xpath("//*[normalize-space(.)='" + var4 + "']/following::table/tbody"));
        var6 = var5.findElements(By.tagName("tr"));
        List var14 = ((WebElement)var6.get(var3 - 1)).findElements(By.tagName("td"));
        StringSelection var15 = new StringSelection(var1);
        Clipboard var16 = Toolkit.getDefaultToolkit().getSystemClipboard();
        var16.setContents(var15, (ClipboardOwner)null);
        ((WebElement)var14.get(var7)).click();
        Actions var11 = new Actions(UIElements.driver);
        var11.sendKeys(new CharSequence[]{var1}).build().perform();
    }

    public static void e(String var0) {
        String var1 = WordUtils.capitalizeFully(var0);
        String var2 = var0.trim().replaceAll("[\\t\\n\\r]+", "");

        try {
            Thread.sleep(50L);
        } catch (Exception var7) {
        }

        for(int var3 = 0; var3 < 30; ++var3) {
            try {
                a();
            } catch (Exception var5) {
            }

            try {
                if (f(var0.trim()) || f(var1.trim()) || f(var2.trim())) {
                    break;
                }

                try {
                    Thread.sleep(100L);
                } catch (Exception var6) {
                }
            } catch (Exception var8) {
                break;
            }
        }

    }

    public static boolean f(String var0) {
        String var1 = UIElements.driver.getPageSource();
        var1 = var1.replaceAll("\\s", "");
        var0 = var0.replaceAll("\\s", "");
        String var2 = ">" + var0 + "<";
        String var3 = ">" + var0 + "[^a-zA-Z]+";
        String var4 = "[^a-zA-Z]+" + var0 + "<";
        String var5 = "\"" + var0 + "\"";
        String var6 = "[^a-zA-Z]+" + var0 + "\"";
        String var7 = "\"" + var0 + "[^a-zA-Z]+";
        return var1.contains(var2) || var1.matches(var3) || var1.matches(var4) || var1.contains(var5) || var1.matches(var6) || var1.matches(var7);
    }

    private static void d() {
        g = (JavascriptExecutor)UIElements.driver;
        g.executeScript("var callback = arguments[arguments.length - 1];var xhr = new XMLHttpRequest();xhr.open('GET', '/Ajax_call', true);xhr.onreadystatechange = function() {  if (xhr.readyState == 4) {    callback(xhr.responseText);  }};xhr.send();", new Object[0]);
    }

    private static void e() {
        f = new WebDriverWait(UIElements.driver, Duration.ofSeconds(10L));
        g = (JavascriptExecutor)UIElements.driver;

        try {
            ExpectedCondition var0 = (var0x) -> (Long)((JavascriptExecutor)UIElements.driver).executeScript("return jQuery.active", new Object[0]) == 0L;
            boolean var1 = (Boolean)g.executeScript("return jQuery.active==0", new Object[0]);
            if (!var1) {
                f.until(var0);
            }
        } catch (WebDriverException var2) {
        }

    }

    private static void f() {
        String var0 = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
        h(var0);
    }

    private static void g() {
        e = UIElements.driver;
        f = new WebDriverWait(e, Duration.ofSeconds(10L));
        g = (JavascriptExecutor)e;

        try {
            ExpectedCondition var0 = (var0x) -> ((JavascriptExecutor)UIElements.driver).executeScript("return document.readyState", new Object[0]).toString().equals("complete");
            boolean var1 = g.executeScript("return document.readyState", new Object[0]).toString().equals("complete");
            if (!var1) {
                f.until(var0);
            }
        } catch (WebDriverException var2) {
        }

    }

    private static void h() {
        f = new WebDriverWait(UIElements.driver, Duration.ofSeconds(10L));
        g = (JavascriptExecutor)UIElements.driver;
        Boolean var0 = (Boolean)g.executeScript("return typeof jQuery != 'undefined'", new Object[0]);
        if (Boolean.TRUE.equals(var0)) {
            j();
            e();
            j();
        }

    }

    public static void b() {
        f = new WebDriverWait(UIElements.driver, Duration.ofSeconds(10L));
        g = (JavascriptExecutor)UIElements.driver;

        try {
            Boolean var0 = (Boolean)g.executeScript("return window.angular === undefined", new Object[0]);
            if (Boolean.FALSE.equals(var0)) {
                Boolean var1 = (Boolean)g.executeScript("return angular.element(document).injector() === undefined", new Object[0]);
                if (Boolean.FALSE.equals(var1)) {
                    j();
                    f();
                    j();
                }
            }
        } catch (WebDriverException var2) {
        }

    }

    public static void c() {
        e = UIElements.driver;
        f = new WebDriverWait(e, Duration.ofSeconds(10L));
        g = (JavascriptExecutor)e;

        try {
            Object var0 = g.executeScript("return getAllAngularRootElements()[0].attributes['ng-version']", new Object[0]);
            if (var0 != null) {
                Boolean var1 = (Boolean)g.executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1", new Object[0]);
                if (Boolean.FALSE.equals(var1)) {
                    j();
                    i();
                    j();
                }
            }
        } catch (WebDriverException var2) {
        }

    }

    private static void i() {
        String var0 = "return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1";
        h(var0);
    }

    private static void h(String var0) {
        e = UIElements.driver;
        f = new WebDriverWait(e, Duration.ofSeconds(10L));
        g = (JavascriptExecutor)e;

        try {
            ExpectedCondition var1 = (var1x) -> {
                assert var1x != null;

                return Boolean.valueOf(Objects.requireNonNull(((JavascriptExecutor)var1x).executeScript(var0, new Object[0])).toString());
            };
            boolean var2 = Boolean.parseBoolean(Objects.requireNonNull(g.executeScript(var0, new Object[0])).toString());
            if (!var2) {
                f.until(var1);
            }
        } catch (WebDriverException var3) {
        }

    }

    public static String e(String var0, String var1) {
        var1 = c(var0, var1);
        String var3 = "";
        String var2 = var0 + "/" + var1 + "[not(" + var3 + ")]";
        if (b(var2, var1)) {
            return var2;
        } else {
            var2 = var0 + "[not(" + var3 + ")]";
            if (b(var2, var1)) {
                return var2;
            } else {

                }
            }
        }
    }

    public String a(String var1, String var2) {
        String var3 = "";
        WebElement var4 = null;
        if (!var1.equalsIgnoreCase("") && !var2.equalsIgnoreCase("")) {
            Object var5 = null;
            String var37 = var1.substring(0, 1).toUpperCase() + var1.substring(1).toLowerCase();
            String var6 = WordUtils.capitalizeFully(var1);
            String var7 = var1.trim().replaceAll("[\\t\\n\\r]+", "");
            e(var1);
            String var9 = "\"" + var1.trim() + "\"";

            String var8;
            if (var1.contains("'")) {
                String var10;
                var8 = "//*[" + var10 + "]";
            } else {
                var8 = "//*[" + var11 + " or " + var12 + "]";
            }

            try {
                var4 = a(var8);
                if (var4 == null) {
                    UIElements.driver.switchTo().defaultContent();
                    var4 = a(var8);
                }

                if (var4 == null) {
                    UIElements.driver.switchTo().defaultContent();
                    var4 = b(var8);
                }
            } catch (Exception var27) {
            }

            if (var1.contains("*") && var4 == null) {
                String var14 = var1.replaceAll("\\*", "").replaceAll("[^a-zA-Z0-9]+", " ");
                var37 = var14.substring(0, 1).toUpperCase() + var14.substring(1).toLowerCase();
                String var15 = "//*[normalize-space(.)='" + var14.trim() + "' or normalize-space(.)='" + var14.toLowerCase().trim() + "' or normalize-space(.)='" + var14.toUpperCase().trim() + "' or normalize-space(.)='" + var37.trim() + "']";
                if (UIElements.driver.findElements(By.xpath(var15)).isEmpty()) {
                    var4 = a(var15);
                    if (var4 == null) {
                        UIElements.driver.switchTo().defaultContent();
                        var4 = a(var15);
                    }

                    if (var4 == null) {
                        var4 = b(var15);
                    }

                    boolean var13 = false;

                    try {
                        if (UIElements.driver.findElement(By.xpath(var15)).isDisplayed()) {
                            var13 = true;
                        }
                    } catch (Exception var26) {
                    }

                    if (!var13) {
                        UIElements.driver.switchTo().defaultContent();
                        var4 = b(var15);
                    }

                    if (var4 != null) {
                        var1 = var14.trim();
                    }
                } else {
                    var4 = UIElements.driver.findElement(By.xpath(var15));
                    var1 = var14.trim();
                }
            }
            
        }

        if (var3 != "") {
            WebElement var39 = UIElements.driver.findElement(By.xpath(var3));
            JavascriptExecutor var40 = (JavascriptExecutor)UIElements.driver;
            var40.executeScript("arguments[0].scrollIntoView();", new Object[]{var39});

            try {
                WebDriverWait var41 = new WebDriverWait(UIElements.driver, Duration.ofSeconds(5L));
                var41.until(ExpectedConditions.and(new ExpectedCondition[]{ExpectedConditions.elementToBeClickable(By.xpath(var3)), ExpectedConditions.visibilityOfElementLocated(By.xpath(var3))}));
            } catch (Exception var22) {
            }
        }

        return var3;
    }

private WebElement a(String var15) {
}

public static String a(String var0, String var1, String var2) {
        var1 = c(var0, var1);
        String var3 = var0 + "/preceding-sibling::input[@type='" + var2 + "']";
        if (b(var3, var1)) {
            return var3;
        } else {
            var3 = var0 + "/following-sibling::input[@type='" + var2 + "']";
            if (b(var3, var1)) {
                return var3;
            } else {
                var3 = var0 + "/../input[@type='" + var2 + "']";
                if (b(var3, var1)) {
                    return var3;
                } else {
                    var3 = var0 + "/input[@type='" + var2 + "']";
                    if (b(var3, var1)) {
                        return var3;
                    } else {
                        var3 = var0 + "/preceding::input[@type='" + var2 + "']";
                        if (b(var3, var1)) {
                            return var3;
                        } else {
                            var3 = var0 + "/following::input[@type='" + var2 + "']";
                            return b(var3, var1) ? var3 : var3;
                        }
                    }
                }
            }
        }
    }

    public boolean g(String var1) {
        try {
            if (!UIElements.driver.findElements(By.xpath(var1)).isEmpty()) {
                return true;
            }
        } catch (Exception var3) {
        }

        return false;
    }

    private static void j() {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException var1) {
        }

    }
}

void main() {
}
