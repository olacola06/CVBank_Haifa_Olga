package tests;

import models.Cv;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        app.regist().signInFirst();
        app.regist().clickCloseSign();
    }

    @Test
    public void registartionPos(){
        User user = User.builder().name("").lastName("").email("")
                .password("").confirmPassword("").build();
        app.regist().clickSignUp();
        app.regist().fillRegistrationForm(user);

    }

}
