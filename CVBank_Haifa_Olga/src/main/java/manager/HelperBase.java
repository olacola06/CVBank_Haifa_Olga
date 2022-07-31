package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Time;

public class HelperBase {
    WebDriver wd;
    public HelperBase(WebDriver driver){
        this.wd = driver;
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
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
    public void refresh(){
        wd.navigate().refresh();
    }

}
