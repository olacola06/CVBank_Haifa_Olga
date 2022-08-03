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
        click(By.xpath("//span[.='sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type((By.id("name")),user.getName());
        type((By.id("lastName")),user.getLastName());
        type((By.id("email")),user.getEmail());
        type((By.id("password")),user.getPassword());
        type((By.id("confirmPassword")),user.getConfirmPassword());
        click(By.xpath("//span[.='sign up']"));
    }

    public String RegistrationSuccess() {
        String message = wd.findElement(By.xpath("//h2[.='Sign up success']")).getText();
        return message;
    }

    public boolean RegistrationFailed() {
        String message = wd.findElement(By.xpath("//span[.='Wrong email format']")).getText();
        return message.contains("Wrong email format");
    }
}
