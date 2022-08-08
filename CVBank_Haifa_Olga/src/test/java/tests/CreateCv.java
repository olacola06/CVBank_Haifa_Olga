package tests;

import models.Cv;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCv extends TestBase{

    @BeforeMethod
    public void preCondition(){
        app.getCv().clickCreateCvBtn();
    }
    @Test
    public void createResume(){
        Cv cv = Cv.builder().name("Pavel").position("Manager").birthday("12/08/1973").country("Israel")
                .city("haifa").phone("036485478").email("pavel@mail.ru")
                .companyName("Neokor").companyLocation("Ramot").companyUrl("www.neokor.com")
                .build();
        User user = User.builder().email("office@prisma-eo.co.il").password("Bb12345%").build();
        String startYear = "1995";
        String endYear = "2001";
        int cvLookNum = 4;

        Assert.assertTrue(app.getCv().fillCvForHeader(cv));

        app.getCv().fillExperienceForm(cv, startYear,endYear);
        Assert.assertTrue(app.getCv().assertExperience(startYear,endYear));

        app.getCv().previewAndPublish(cvLookNum, user);
        app.getCv().loginUser(user);

        Assert.assertTrue(app.getCv().cvPublished());
   }

}
