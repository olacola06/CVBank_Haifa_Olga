package tests;

import models.Cv;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    int i = (int)System.currentTimeMillis()/1000%3600;
    User user = User.builder().name("Bob").lastName("Tommy").email("Aadov"+i+"@gmail.com")
            .password("Bc12345%").confirmPassword("Bc12345%").build();

    @BeforeMethod
    public void preCondition(){
        app.regist().signInFirst();
        app.regist().clickSignUp();
    }

    @Test
    public void registartionPos(){
        app.regist().fillRegistrationForm(user);

        Assert.assertEquals(app.regist().RegistrationSuccess(),"Sign up success");
        logger.info("Registration was Success");
    }
    @Test
    public void registrationWrongEmail(){
        user.setEmail("Aadov"+i+"gmail.com");
        app.regist().fillRegistrationForm(user);

        Assert.assertTrue(app.regist().RegistrationFailed());
        logger.info("Error - Wrong email format");

    }
    @AfterMethod(enabled = true)
    public void postCondition(){
        app.regist().switchToTheMainPage();
    }

}
