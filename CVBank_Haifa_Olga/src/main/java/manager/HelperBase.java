package manager;

import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver driver) {
        this.wd = driver;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement el = wd.findElement(locator);
        el.click();
        el.clear();
        el.sendKeys(text);

    }

    public void pause(int milles) {
        try {
            Thread.sleep(milles);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void signInFirst() {
        click(By.xpath("//*[.='sign in']"));
        goToTheNextTab();
        click(By.xpath("//span[.='close']"));

    }
    public void goToTheNextTab() {
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
    }

    public void switchToTheMainPage() {
        List <String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1)).close();
        wd.switchTo().window(tabs.get(0));
    }
}
