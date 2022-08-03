package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        app.login().signInFirst();
        app.login().clickSingIn();
    }

    @Test
    public void loginPos() {
        User user = User.builder().email("office@prisma-eo.co.il").password("Bb12345%").build();
        logger.info("Login user with email:->>" + user.getEmail());
        app.login().loginUser(user);

        Assert.assertTrue(app.login().logoutBtnPresent());

    }

    @Test
    public void loginWrongEmail() {
        User user = User.builder().email("officeprisma-eo.co.il").password("Bb12345%").build();
        logger.info("Login user with email:->>" + user.getEmail());
        app.login().loginUser(user);

        Assert.assertEquals(app.login().wrongEmailPassFormatMessage(),"Wrong email format");
        logger.info("Wrong email format");
    }
    @Test
    public void loginWrongPassword(){
        User user = User.builder().email("office@prisma-eo.co.il").password("Bb123").build();
        logger.info("Login user with email:->>" + user.getEmail());
        app.login().loginUser(user);

        Assert.assertEquals(app.login().wrongEmailPassFormatMessage(),"Password length should be minimum 8 symbols");
        logger.info("Password length should be minimum 8 symbols");


    }

    @AfterMethod
    public void postCondition(){
        app.login().switchToTheMainPage();
    }
}