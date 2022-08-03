package tests;

import models.Cv;
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
                .city("haifa").phone("036485478").email("pavel@mail.ru").build();

        app.getCv().fillCvForHeader(cv);

    }
}
