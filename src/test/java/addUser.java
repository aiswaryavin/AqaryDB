import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class addUser extends MainMethods{

    @Test(priority = 1)
    public void AddUser(){
        click(By.xpath("//button[@aria-label=\"open drawer\"]//*[name()=\"svg\"]"));
        click(By.xpath("/html/body/div[2]/div/div/nav[2]/div[1]"));
        click(By.xpath("/html/body/div[2]/div/div/nav[2]/div[2]/div/div/a/div"));
        clickandsend(By.xpath("//input[@placeholder='Enter username']"),"Marko");
        clickandsend(By.xpath("//input[@placeholder='Enter first name']"),"Marko");
    }
}