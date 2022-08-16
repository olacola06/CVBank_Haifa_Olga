package tests;

import manager.MyDataProvider;
import models.Cv;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCv extends TestBase{

    @BeforeMethod
    public void preCondition() {
        app.getCv().clickCreateCvBtn();
    }

    User user = User.builder().email("office@prisma-eo.co.il").password("Bb12345%").build();
        @Test(groups ={"first"}, invocationCount = 2)
        public void createResume(){
            Cv cv = Cv.builder().name("Pavel").position("Manager").birthday("12/08/1973").country("Israel")
                    .city("haifa").phone("036485478").email("pavel@mail.ru")
                    .companyName("Neokor").companyLocation("Ramot").companyUrl("www.neokor.com")
                    .startYear("1985").endYear("1989").build();
            int cvLookNum = 3;

            Assert.assertTrue(app.getCv().fillCvForHeader(cv));

            app.getCv().fillExperienceForm(cv);
            Assert.assertTrue(app.getCv().assertExperience(cv.getStartYear(), cv.getEndYear()));

            app.getCv().previewAndPublish(cvLookNum, cv.getName());
            app.getCv().pause(2000);
            app.getCv().loginUser(user);

            Assert.assertTrue(app.getCv().cvPublished());
        }
    @Test(dataProvider = "dataForCv",dataProviderClass = MyDataProvider.class)
    public void createResumeDP(Cv cv){
            int cvLookNum = 2;

        Assert.assertTrue(app.getCv().fillCvForHeader(cv));

        app.getCv().fillExperienceForm(cv);
        Assert.assertTrue(app.getCv().assertExperience(cv.getStartYear(), cv.getEndYear()));

        app.getCv().previewAndPublish(cvLookNum, cv.getName());
        app.getCv().pause(2000);
        app.getCv().loginUser(user);

        Assert.assertTrue(app.getCv().cvPublished());
    }
    @AfterMethod
    public void postConditions(){
            app.getCv().logout();
    }

}
