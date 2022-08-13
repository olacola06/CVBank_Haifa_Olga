package manager;

import javafx.scene.control.Tab;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver driver) {
        this.wd = driver;
    }
    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement el = wd.findElement(locator);
        el.click();
        el.clear();
        el.sendKeys(text);

    }
    public void loginUser(User user) {
        new WebDriverWait(wd, 10).until(ExpectedConditions
                .visibilityOf(wd.findElement(By.cssSelector("input#email"))));
        type((By.cssSelector("input#email")),user.getEmail());
        type((By.cssSelector("input#password")),user.getPassword());
        wd.findElement(By.cssSelector(" button[type='submit']")).click();
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
    public void signIn(User user) {
        click(By.xpath("//*[.='sign in']"));
        goToTheNextTab();
        type((By.cssSelector("input#email")),user.getEmail());
        type((By.cssSelector("input#password")),user.getPassword());
        wd.findElement(By.cssSelector(" button[type='submit']")).click();

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
    public boolean logoutBtnPresent(){
        if(wd.findElements(By.xpath("//*[text()=' logout ']")).size()>0){
            return true;
        }else{
            return false;
        }
    }

    public void logout() {
        click(By.xpath("//*[text()=' logout ']"));
    }
}
