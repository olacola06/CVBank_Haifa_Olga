package manager;

import lombok.experimental.Helper;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        Boolean check = wd.findElement(By.xpath("//*[text()=' logout ']")).isDisplayed();
        return check;
    }
}
