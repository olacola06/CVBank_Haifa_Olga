package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {
    String browser;
    EventFiringWebDriver wd;
    LoginHelper login;
    RegistrationHelper regist;
    CreateCvHelper cv;
    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            logger.info("All tests start in Chrome");
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if(browser.equals(BrowserType.FIREFOX)){
            logger.info("All tests start in FireFox");
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }else if(browser.equals(BrowserType.EDGE)){
            logger.info("All tests start in Edge");
            wd = new EventFiringWebDriver(new EdgeDriver());
        }
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://www.gcvbank.com");

        wd.register(new MyListener());

        login = new LoginHelper(wd);
        regist = new RegistrationHelper(wd);
        cv = new CreateCvHelper(wd);
        logger.info("ff");

    }
    public LoginHelper login(){
        return login;
    }
    public RegistrationHelper regist(){
        return regist;
    }
    public CreateCvHelper getCv(){
        return cv;
    }
    public void stop(){
        wd.quit();
    }
}
