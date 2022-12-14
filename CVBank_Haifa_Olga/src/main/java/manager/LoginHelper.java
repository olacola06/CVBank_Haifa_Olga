package manager;

import lombok.experimental.Helper;
import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginHelper extends HelperBase {

    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public void clickSingIn() {
        click(By.xpath("//span[.='sign in ']"));


    }

    public String wrongEmailPassFormatMessage() {
        String message;
        if(wd.findElements(By.xpath("//span[.='Wrong email format']")).size()>0){
            message = wd.findElement(By.xpath("//span[.='Wrong email format']")).getText();
        }
        else{
            message = wd.findElement(By.xpath("//span[.=' Password length should be minimum 8 symbols ']"))
                    .getText();
        }
        return message;
    }
}
