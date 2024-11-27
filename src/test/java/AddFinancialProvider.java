import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class AddFinancialProvider extends MainMethods{
    @Test(priority = 1)
    public void NavtoFinancial(){
//        click(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[12]/div/button[6]"));
        click(By.xpath("//*[@id=\"actions-popover\"]/div[3]/div[6]/a"));
    }
    @Test(priority = 2)
    public void addProvider(){
        click(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/div[1]/div[3]/button"));
        String randomint  = String.valueOf(ThreadLocalRandom.current().nextInt(1, 2));
        doubleClick(By.xpath("//input[@placeholder='Select Provider Type']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()=1]"));
        doubleClick(By.xpath("//input[@placeholder='Select Provider Name']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()="+randomint+"]"));
        click(By.xpath("/html/body/div[3]/div[3]/div/div/div[1]/form/div[2]/button[1]"));
        click(By.xpath("/html/body/div[2]/main/div/div/div[1]/div/a"));
    }
}
