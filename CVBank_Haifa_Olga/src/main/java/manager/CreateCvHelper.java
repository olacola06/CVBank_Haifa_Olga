package manager;

import models.Cv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCvHelper extends HelperBase{

    public CreateCvHelper(WebDriver driver) {
        super(driver);
    }

    public void clickCreateCvBtn() {
        click(By.xpath("//span[.='create CV']"));
        goToTheNextTab();
    }

    public void fillCvForHeader(Cv cv) {
        click(By.xpath("(//div[@class='cover'])[1]"));
        type((By.id("name")),cv.getName());
        type((By.id("position")),cv.getPosition());
        typeDateOfBirth(cv.getBirthday());
        type((By.id("country")),cv.getCountry());
        type((By.id("city")),cv.getCity());
        type((By.id("phone")),cv.getPhone());
        type((By.id("email")),cv.getPhone());
    }

    private void typeDateOfBirth(String birthday) {
        String[] data = birthday.split("/");
        int yearOfBirth = Integer.parseInt(data[2]);
        click(By.xpath("//*[@aria-label='Open calendar']"));
        click(By.cssSelector("button[aria-label='Choose month and year']"));
        int yearToCompare = Integer.parseInt(wd.findElement
                (By.cssSelector("tbody[role='grid'] tr:first-child td:first-child")).getText());
        while (yearOfBirth<yearToCompare)
        {click(By.xpath("//*[@aria-label='Previous 20 years']"));
        }
        click(By.xpath("//*[.=' "+yearOfBirth+" ']"));

    }

}
