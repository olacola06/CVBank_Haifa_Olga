package manager;

import models.Cv;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase{

    public RegistrationHelper(WebDriver driver) {
        super(driver);
    }

    public void clickCloseSign() {
        click(By.xpath("//*[.='close']"));
    }

    public void clickSignUp() {
        click(By.xpath("[.='sign up ']"));
    }

    public void fillRegistrationForm(User user) {

    }
}
