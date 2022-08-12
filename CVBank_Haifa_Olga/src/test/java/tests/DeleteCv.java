package tests;

import models.User;
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
        String nameToDelete = "Pavel";
        app.delCv().deleteCvByName(nameToDelete);

    }
}
