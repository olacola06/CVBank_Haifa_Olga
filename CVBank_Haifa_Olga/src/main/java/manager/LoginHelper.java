package manager;

import lombok.experimental.Helper;
import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginHelper extends HelperBase {

    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public void loginUser(User user) {
        type((By.cssSelector("input#email")),user.getEmail());
        type((By.cssSelector("input#password")),user.getPassword());
        wd.findElement(By.cssSelector(" button[type='submit']")).click();
    }
    public boolean logoutBtnPresent(){
        if(wd.findElement(By.xpath("//*[text()=' logout ']")).isDisplayed()){
            wd.findElement(By.xpath("//*[text()=' logout ']")).click();
            return true;
        }else{
            return false;
        }
    }

    public void clickSingIn() {
        click(By.xpath("//span[.='sign in ']"));


    }
    public String isAlertPresent() {
        Alert alert = new WebDriverWait(wd,10).until(ExpectedConditions.alertIsPresent());
        if(alert==null) {
            return "There is no alert";
        }
        wd.switchTo().alert().accept();
            String message = alert.getText();

        return message;
    }
}
