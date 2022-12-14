package manager;

import models.Cv;

import org.apache.fontbox.FontBoxFont;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;



public class CreateCvHelper extends HelperBase {

    public CreateCvHelper(WebDriver driver) {
        super(driver);
    }

    public void clickCreateCvBtn() {
        click(By.xpath("//span[.='create CV']"));
        goToTheNextTab();
    }

    public boolean fillCvForHeader(Cv cv) {
        click(By.xpath("(//div[@class='cover'])[1]"));
        type((By.id("name")), cv.getName());
        type((By.id("position")), cv.getPosition());
        typeDateOfBirth(cv.getBirthday());
        type((By.id("country")), cv.getCountry());
        type((By.id("city")), cv.getCity());
        type((By.id("phone")), cv.getPhone());
        type((By.id("email")), cv.getPhone());
        click(By.xpath("//span[.='Save']"));
        String checkMessage = wd.findElement(By.cssSelector("section#header div[class=title] h2")).getText();
        return checkMessage.contains(cv.getName().toUpperCase());
    }

    private void typeDateOfBirth(String birthday) {
        click(By.xpath("//*[@aria-label='Open calendar']"));
        click(By.cssSelector("button[aria-label='Choose month and year']"));
        String[] data = birthday.split("/");
        int yearOfBirth = Integer.parseInt(data[2]);
        chooseYearBirth(yearOfBirth);
        //chooseMonthBirth(Integer.parseInt(data[1]));
        String month = chooseMonthBirth(data[1]);
        String monthLocator = String.format("//td[.=' %s ']", month);
        click(By.xpath(monthLocator));
//        String dayLocator = String.format("//div[.=' %s ']",data[0]);
//        click(By.xpath(dayLocator));
        click(By.xpath("//div[.=' " + data[0] + " ']"));

    }

    private String chooseMonthBirth(String month) {
        switch (month) {
            case ("01"):
                month = "JAN";
                break;
            case ("02"):
                month = "FEB";
                break;
            case ("03"):
                month = "MAR";
                break;
            case ("04"):
                month = "APR";
                break;
            case ("05"):
                month = "MAY";
                break;
            case ("06"):
                month = "JUN";
                break;
            case ("07"):
                month = "JUL";
                break;
            case ("08"):
                month = "AUG";
                break;
            case ("09"):
                month = "SEP";
                break;
            case ("10"):
                month = "OCT";
                break;
            case ("11"):
                month = "NOV";
                break;
            case ("12"):
                month = "DEC";
                break;
            default:
                break;
        }
        return month;
    }

//    private void chooseMonthBirth(int month) {
//
//        switch (month) {
//            case 1: wd.findElement(By.xpath("//td[.=' JAN ']")).click();
//                 break;
//            case 2: wd.findElement(By.xpath("//td[.=' FEB ']")).click();
//                break;
//            case 3: wd.findElement(By.xpath("//td[.=' MAR ']")).click();
//                break;
//            case 4: wd.findElement(By.xpath("//td[.=' APR ']")).click();
//                break;
//            case 5: wd.findElement(By.xpath("//td[.=' MAY ']")).click();
//                break;
//            case 6: wd.findElement(By.xpath("//td[.=' JUN ']")).click();
//                break;
//            case 7: wd.findElement(By.xpath("//td[.=' JUL ']")).click();
//                break;
//            case 8: wd.findElement(By.xpath("//td[.=' AUG ']")).click();
//                break;
//            case 9: wd.findElement(By.xpath("//td[.=' SEP ']")).click();
//                break;
//            case 10: wd.findElement(By.xpath("//td[.=' OCT ']")).click();
//                break;
//            case 11: wd.findElement(By.xpath("//td[.=' NOV ']")).click();
//                break;
//            case 12: wd.findElement(By.xpath("//td[.=' DEC ']")).click();
//                break;
//            default:break;
//        }
//    }

    private void chooseYearBirth(int year) {
        int yearToCompare = Integer.parseInt(wd.findElement
                (By.cssSelector("tbody[role='grid'] tr:first-child td:first-child div")).getText());
        while (year < yearToCompare) {
            click(By.xpath("//*[@aria-label='Previous 20 years']"));
            yearToCompare = Integer.parseInt(wd.findElement
                    (By.cssSelector("tbody[role='grid'] tr:first-child td:first-child")).getText());
        }
        click(By.xpath("//*[.=' " + year + " ']"));

    }

    public void fillExperienceForm(Cv cv) {
        click(By.id("experience"));
        fillYears(cv.getStartYear(), cv.getEndYear());
        type(By.id("companyName"), cv.getCompanyName());
        type(By.id("companyLocation"), cv.getCompanyLocation());
        type(By.id("url"), cv.getCompanyUrl());
        type(By.id("position"), cv.getPosition());
        click(By.cssSelector("button[type='submit']"));

    }

    private void fillYears(String startYear, String endYear) {
        WebElement el = wd.findElement(By.id("startDate"));
        pause(2000);
        el.sendKeys(Keys.CONTROL + "a");
        el.sendKeys(Keys.DELETE);
        el.sendKeys(startYear);
        WebElement el2 = wd.findElement(By.id("endDate"));
        el2.sendKeys(Keys.CONTROL + "a");
        el2.sendKeys(Keys.DELETE);
        el2.sendKeys(endYear);
    }

    public boolean assertExperience(String startYear, String endYear) {
        String message = wd.findElement(By.cssSelector("section#experience ul")).getText();
        return message.contains(startYear) && message.contains(endYear);
    }

    public void previewAndPublish(int cvLookNum, String candidateName) {
        click(By.xpath("//*[.=' Preview ']"));
        click(By.cssSelector("div[class=slider] div:nth-child(" + cvLookNum + ")"));
        click(By.cssSelector("div[class=header] button:first-of-type"));

        pause(2000);
        File directory = new File("C:/Users/Olga/Downloads");
        File[] listFiles = directory.listFiles();
        for (File file : listFiles) {
            if (file.getName().contains(candidateName)) {
                logger.info("CV with candidate named: " + candidateName + " was saved");
                Assert.assertTrue(file.exists());
                break;
            }
        }

            click(By.cssSelector("div[class=header] button:last-of-type"));
            click(By.xpath("//*[.='Publish ']"));
            click(By.xpath("//a[.='Sign In']"));
}

    public boolean cvPublished() {
        WebElement el = new WebDriverWait(wd,10).until(ExpectedConditions
                .visibilityOf(wd.findElement(By.xpath("//cv-toast-message[@class='ng-star-inserted']"))));
        String message = el.getText();
        System.out.println(message);
        new WebDriverWait(wd,10).until(ExpectedConditions.invisibilityOf(el));
        return message.contains("Success") && message.contains("Your CV was saved");
    }

}
