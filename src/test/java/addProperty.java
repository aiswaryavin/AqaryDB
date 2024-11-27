import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class addProperty extends MainMethods{
    String randoms  = String.valueOf(ThreadLocalRandom.current().nextInt(1, 99999));
    String randomint  = String.valueOf(ThreadLocalRandom.current().nextInt(1, 10));
    String minArea  = String.valueOf(ThreadLocalRandom.current().nextInt(1000, 2000));
    String maxArea  = String.valueOf(ThreadLocalRandom.current().nextInt(1100, 2100));
    String View  = String.valueOf(ThreadLocalRandom.current().nextInt(1, 50));
    String ServiceCharge = String.valueOf(ThreadLocalRandom.current().nextInt(1, 1000));

    @Test(priority = 1)
    public void navtoAdd(){
        click(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[12]/div/button[6]"));
        click(By.xpath("//*[@id=\"actions-popover\"]/div[3]/div[1]/a"));
    }

    @Test(priority = 2)
    public void AddProperty() throws InterruptedException {
        click(By.xpath("//a[@href='properties/add']"));
        Thread.sleep(1000);
        clickandsend(
                By.xpath("//div[contains(@class, 'MuiInputBase-root') and contains(@class, 'MuiOutlinedInput-root')]//input[@placeholder='Enter property name']"),
                "TESTproperty"
        );

    }
}
