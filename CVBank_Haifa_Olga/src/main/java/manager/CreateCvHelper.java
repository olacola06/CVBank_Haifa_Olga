package manager;

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

    public void fillCvForHeader() {
        click(By.xpath("(//div[@class='cover'])[1]"));

    }
}
