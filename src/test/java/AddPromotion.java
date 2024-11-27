import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class AddPromotion extends MainMethods{

    String randomint  = String.valueOf(ThreadLocalRandom.current().nextInt(1, 15));

    @Test(priority = 1)
    public void NavtoPromotion(){
        click(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[12]/div/button[6]"));
        click(By.xpath("//*[@id=\"actions-popover\"]/div[3]/div[3]"));
    }
    @Test(priority = 2)
    public void addPromotion() throws InterruptedException {
            click(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div[2]/button[1]"));
            doubleClick(By.xpath("//input[@placeholder='Select Promotion Type']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()="+randomint+"]"));
            doubleClick(By.xpath("/html/body/div[5]/div[3]/div/div/div[1]/form/div[1]/div[2]/div/div/div/div/button"),By.xpath("/html/body/div[6]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[5]/button[6]"));
            String realEstateDescription = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate";
            WebElement descriptionField = driver.findElement(By.xpath("//textarea[@name='description']"));descriptionField.sendKeys(realEstateDescription);
            click(By.xpath("/html/body/div[5]/div[3]/div/div/div[1]/form/div[2]/button[1]"));
            Thread.sleep(200);
            click(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div[2]/button[2]"));
    }
}
