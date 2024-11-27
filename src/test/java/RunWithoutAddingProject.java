import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RunWithoutAddingProject extends MainMethods{
    @Test
    public void navigatetoListing(){
        click(By.xpath("//button[@aria-label=\"open drawer\"]//*[name()=\"svg\"]"));
        click(By.xpath("//span[normalize-space()=\"Projects\"]"));
        click(By.xpath("//span[normalize-space()=\"Local Projects\"]"));
    }
}
