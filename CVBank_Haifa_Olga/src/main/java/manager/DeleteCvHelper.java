package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class DeleteCvHelper extends HelperBase{

    public DeleteCvHelper (WebDriver driver){
        super(driver);
    }

    public void deleteCvByName(String name) {
        List<WebElement> listCv = wd.findElements(By.cssSelector("ul[class='ng-star-inserted'] li cv-seeker-cv-row"));
        List<WebElement>listCvNames = wd.findElements(By.xpath("//h2[.='"+name+"']"));
        int amountStart = listCv.size();
        logger.info("Total amount of already created CV = ->>" + amountStart);
        for(WebElement elN : listCvNames) {
                if (elN.getText().contains(name)) {
                    int number = listCvNames.indexOf(elN);
                    wd.findElement(By.xpath("//label[@for='mat-checkbox-"+number+"-input']")).click();
                    click(By.xpath("//button[. = 'delete']"));
                    click(By.xpath("//button[. = 'Delete ']"));
                    Assert.assertTrue(cvDeleted());
                }
            }
                //new WebDriverWait(wd, 15).until(ExpectedConditions.visibilityOf(el));
//                click(By.xpath("//button[. = 'delete']"));
//                click(By.xpath("//button[. = 'Delete ']"));
//                Assert.assertTrue(cvDeleted());

    }
    public void deleteCvByName2(String name) {
        //List<WebElement>listCvNames = wd.findElements(By.xpath("//h2[.='"+name+"']"));
        List<WebElement> listCv = wd.findElements(By.cssSelector("ul[class='ng-star-inserted'] li cv-seeker-cv-row"));
        int amountStart = listCv.size();
        int count = 0;
        logger.info("Total amount of already created CV = ->>"+amountStart);
        for(int i=0;i<amountStart;i++){
        if (listCv.get(i).getText().contains(name)) {
               markCheckBox(listCv.get(i));
//                count++;
            click(By.xpath("//button[. = 'delete']"));
            click(By.xpath("//button[. = 'Delete ']"));
            Assert.assertTrue(cvDeleted());

        }
            //logger.info("Total CV to be deleted = "+count);
        }
        int amountFinish = listCv.size();
        logger.info("Total amount of CVs = "+amountFinish);
        //logger.info("Total CV to be deleted = "+count);
//        click(By.xpath("//button[. = 'delete']"));
//        click(By.xpath("//button[. = 'Delete ']"));
//        Assert.assertTrue(cvDeleted());
    }

//            wd.findElement(By.xpath("//label[@for='mat-checkbox-77-input']")).click();
//            if(wd.findElements(By.xpath("//h2[.='"+name+"']")).size()>0){
//                int index = listCv.indexOf(e);
//                logger.info("Index of CV to be deleted = "+index);
//                click(By.xpath("//label[@for='mat-checkbox-"+index+"-input']"));
//                click(By.xpath("//button[. = 'delete']"));
//

    private void markCheckBox(WebElement element) {
        Rectangle rect = element.getRect();
        int x = rect.getWidth()/2;
        int xOffset = (int)(x*0.95);
        int yOffset = 0;

        Actions action = new Actions(wd);
        action.moveToElement(element).moveByOffset(-xOffset,yOffset).click().release().perform();
    }
    public boolean cvDeleted() {

        WebElement el = wd.findElement(By.xpath("//cv-toast-message[@class='ng-star-inserted']"));
        String message = el.getText();
        System.out.println(message);
        new WebDriverWait(wd,15).until(ExpectedConditions.invisibilityOf(el));
        return message.contains("Success") && message.contains("CV was deleted");
    }

}
