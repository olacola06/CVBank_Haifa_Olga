package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void methodStart(Method m){
        logger.info("start to test method ->>"+m.getName());
    }
    @AfterMethod
    public void methodFinished(Method m){
        logger.info("end to test method ->>"+m.getName());
    }
    @BeforeSuite
    public void start(){
        app.init();
    }
    @AfterSuite(enabled = false)
    public void end(){
        app.stop();
    }

}
