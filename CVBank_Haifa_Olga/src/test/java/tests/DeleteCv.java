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
            //app.delCv().loginOneStep(user);// to use while run Task reg - smoke
            app.delCv().signIn(user);
       }
    }

    @Test
    public void deleteByName(){
        String nameToDelete = "Pavel";
        Assert.assertTrue(app.delCv().deleteCvByName(nameToDelete));
    }
    @Test(groups = {"first"})
    public void deleteAllByName(){
        String name = "Pasha";
        app.delCv().deleteCvByName2(name);
        Assert.assertTrue(app.delCv().allDeleted(name));
    }
    @AfterClass
    public void postConditions(){
        app.delCv().logout();
    }
}
