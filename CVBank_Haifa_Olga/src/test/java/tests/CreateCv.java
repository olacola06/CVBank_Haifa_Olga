package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCv extends TestBase{

    @BeforeMethod
    public void preCondition(){
        app.getCv().clickCreateCvBtn();
    }
    @Test
    public void createResume(){

        app.getCv().fillCvForHeader();

    }
}
