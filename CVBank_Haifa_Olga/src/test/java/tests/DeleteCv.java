package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteCv extends TestBase {

    @BeforeClass
    public void preCondition(){
        if(!app.getCv().logoutBtnPresent()){
            User user = User.builder().email("office@prisma-eo.co.il").password("Bb12345%").build();
            app.delCv().signIn(user);
       }
    }

    @Test
    public void deleteByName(){
        String nameToDelete = "John";
        Assert.assertTrue(app.delCv().deleteCvByName(nameToDelete));
    }
    @Test
    public void deleteAllByName(){
        String name = "Haim";
        app.delCv().deleteCvByName2(name);
        Assert.assertTrue(app.delCv().allDeleted(name));
    }
    @AfterClass
    public void postConditions(){
        app.delCv().logout();
    }
}
