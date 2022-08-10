package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DeleteCvHelper extends HelperBase{

    public DeleteCvHelper (WebDriver driver){
        super(driver);
    }

    public void deleteCvByName(String name) {
        List<WebElement>listCv = wd.findElements(By.cssSelector("ul[class='ng-star-inserted'] li cv-seeker-cv-row"));
       // List<WebElement>listCvNames = wd.findElements(By.xpath("//h2[.='"+name+"']"));
        int amountStart = listCv.size();
        logger.info("Total amount of already created CV = ->>"+amountStart);
        while (!listCv.isEmpty()){
               for(WebElement el:listCv){
                new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(el));
                el.isSelected();
                el.click();
                //wd.findElement(By.xpath("//label[@for='mat-checkbox-77-input']")).click();
                click(By.xpath("//button[. = 'delete']"));
                click(By.xpath("//button[. = 'Delete ']"));

            }


        }

//            if(wd.findElements(By.xpath("//h2[.='"+name+"']")).size()>0){
//                int index = listCv.indexOf(e);
//                logger.info("Index of CV to be deleted = "+index);
//                click(By.xpath("//label[@for='mat-checkbox-"+index+"-input']"));
//                click(By.xpath("//button[. = 'delete']"));
//            }
        }

}
