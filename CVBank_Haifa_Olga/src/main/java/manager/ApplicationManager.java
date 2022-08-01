package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    String browser;
    EventFiringWebDriver wd;
    LoginHelper login;
    HelperBase regist;
    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }else if(browser.equals(BrowserType.EDGE)){
            wd = new EventFiringWebDriver(new EdgeDriver());
        }
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://www.gcvbank.com");

        wd.register(new MyListener());

        login = new LoginHelper(wd);
        regist = new RegistrationHelper(wd);

    }
    public LoginHelper login(){
        return login;
    }

        public RegistrationHelper regist(){
        return (RegistrationHelper) regist;
    }
    public void stop(){
        wd.quit();
    }
}
