package manager;

import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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
    public void signIn(){
        click(By.xpath("//*[text()='sign in ']"));
    }
    public void clickLogout(){
        wd.findElement(By.xpath("//*[text()=' logout ']")).click();
    }
//    public void switchTabs(){
//        ArrayList<Tab> arrayTabs = new ArrayList<>() wd.findElement("");
//    }

}
