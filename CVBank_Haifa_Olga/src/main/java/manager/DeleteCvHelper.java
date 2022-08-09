package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DeleteCvHelper extends HelperBase{

    public DeleteCvHelper (WebDriver driver){
        super(driver);
    }

    public void deleteCvByName(String name) {
        List listCv = wd.findElements(By.cssSelector("ul[class='ng-star-inserted'] li cv-seeker-cv-row"));
        int amountStart = listCv.size();
        logger.info("Total amount of already created CV = ->>"+amountStart);
        for(Object e:listCv){
            if(wd.findElement(By.xpath("//h2[.='"+name+"']")).isDisplayed()){


            }
        }
        WebElement el = wd.findElement(By.xpath("//h2[.='"+name+"']"));
        

            // //input[@type='checkbox']


    }

}
