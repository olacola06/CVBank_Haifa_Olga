package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class DeleteCvHelper extends HelperBase {

    public DeleteCvHelper(WebDriver driver) {
        super(driver);
    }

    public boolean deleteCvByName(String name) {
        List<WebElement> listCvNames = wd.findElements(By.xpath("//h2[.='" + name + "']"));
        int amountStart = listCvNames.size();
        logger.info("Total amount CVs with name: " + name + " = ->>" + amountStart);
        if (amountStart > 0) {
           listCvNames.get(0).click();
           deleteCv();
        }
        listCvNames = wd.findElements(By.xpath("//h2[.='" + name + "']"));
        int amountFinish = listCvNames.size();
        logger.info("Total amount left of CVs with name: " + name + " = ->>" + amountFinish);
        return assertCvDeleted(amountStart,amountFinish);
}

    public void deleteCvByName2(String name) {
        List<WebElement> listCv = wd.findElements(By.cssSelector("ul[class='ng-star-inserted'] li cv-seeker-cv-row"));
        int amountStart = listCv.size();
        logger.info("Total amount of already created CV = ->>" + amountStart);
        int i=0;
        do{
            if (listCv.get(i).getText().contains(name)) {
                logger.info("Cv with name ->>"+name+ " to be deleted");
                markCheckBox(listCv.get(i));
                deleteCv();
                i--;
                listCv = wd.findElements(By.cssSelector("ul[class='ng-star-inserted'] li cv-seeker-cv-row"));
                pause(3000);
            }
            amountStart--;
            i++;
        }
        while(amountStart>0);
        int amountFinish = listCv.size();
        logger.info("Total amount of CVs left = " + amountFinish);
    }

    private void markCheckBox(WebElement element) {
        Rectangle rect = element.getRect();
        int x = rect.getWidth() / 2;
        int xOffset = (int) (x * 0.95);
        int yOffset = 0;

        Actions action = new Actions(wd);
        action.moveToElement(element).moveByOffset(-xOffset, yOffset).click().release().perform();
    }

    public void deleteCv() {
        click(By.xpath("//button[. = 'delete']"));
        click(By.xpath("//button[. = 'Delete ']"));
        WebElement el = wd.findElement(By.xpath("//cv-toast-message[@class='ng-star-inserted']"));
        String message = el.getText();
        logger.info("After delete action Message received:->>"+message);
        new WebDriverWait(wd, 15).until(ExpectedConditions.invisibilityOf(el));
        //Assert.assertTrue(message.contains("Success") && message.contains("CV was deleted"));
    }
    public boolean assertCvDeleted(int amountStart, int amountFinish) {
        if(amountStart>amountFinish){
            return true;
        }
        return false;
    }

    public boolean allDeleted(String name) {
        List<WebElement> listCvNames = wd.findElements(By.xpath("//h2[.='" + name + "']"));
        if(listCvNames.size()==0){
            logger.info("All CVs with name: "+name+" were deleted");
            return true;
        }
        else
            return false;
    }
}
