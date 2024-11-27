import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Start extends MainMethods{
    @Test
    public void VerifyAqarySite(){
        getUrl("http://192.168.1.193:3000/");
        driver.findElement(By.xpath("//button[text()='Go to Dashboard']")).click();
    }
}
