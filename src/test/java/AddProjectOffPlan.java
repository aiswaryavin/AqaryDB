import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AddProjectOffPlan extends MainMethods{
    int licenseNoDigits = ThreadLocalRandom.current().nextInt(1, 999);
    int projectNoDigits = ThreadLocalRandom.current().nextInt(1, 999);
    String StartingPrice = String.valueOf(ThreadLocalRandom.current().nextInt(100000, 9999999));
    String BuiltArea = String.valueOf(ThreadLocalRandom.current().nextInt(5000, 10000));
    String plotArea = String.valueOf(ThreadLocalRandom.current().nextInt(6000, 10010));
    String noProperties = String.valueOf(ThreadLocalRandom.current().nextInt(1, 50));
    String completionPercentage = String.valueOf(ThreadLocalRandom.current().nextInt(1, 100));
    String ServiceCharge = String.valueOf(ThreadLocalRandom.current().nextInt(1, 1000));
    String randomPosition  = String.valueOf(ThreadLocalRandom.current().nextInt(1, 15));
    String randomCom  = String.valueOf(ThreadLocalRandom.current().nextInt(1, 30));
    String randomSub  = String.valueOf(ThreadLocalRandom.current().nextInt(1, 3));

    @Test(priority = 1)
    public void NavigateToNav(){
        click(By.xpath("//button[@aria-label=\"open drawer\"]//*[name()=\"svg\"]"));
        click(By.xpath("//span[normalize-space()=\"Projects\"]"));
        click(By.xpath("//span[normalize-space()=\"Add Project\"]"));
    }
    @Test(priority = 2)
    public void AddProjectDetails() throws InterruptedException {
        String[] projects = {
                "Burj Khalifa Residences", "Palm Jumeirah Villas", "Jumeirah Beach Apartments",
                "Downtown Dubai Towers", "Business Bay Heights", "Dubai Marina Skyrise",
                "Emaar Beachfront", "Bluewaters Island Residences", "Meydan Heights Villas",
                "Al Barari Oasis", "DAMAC Hills Residences", "Arabian Ranches Villas",
                "City Walk Dubai", "La Mer Beachfront", "Dubai Creek Harbour Residences",
                "Dubai Hills Estate", "Tilal Al Ghaf Residences", "Port de La Mer Apartments",
                "Madinat Jumeirah Living", "Serenia Residences Palm Jumeirah",
                "Vida Residences Downtown", "The Address Sky View", "One Za’abeel Residences",
                "Opera Grand Downtown", "Safa Two by DAMAC", "Park Ridge by Emaar",
                "The Cove Dubai Creek", "Al Furjan Residences", "Green Community Villas",
                "The Meadows Dubai", "The Springs Dubai", "Jumeirah Golf Estates",
                "Victory Heights Villas", "The Sustainable City", "Dubai South Residences",
                "Mudon Villas", "Remraam Apartments", "Dubai Silicon Oasis Residences",
                "The Executive Towers", "Zabeel Saray Villas", "Amna Tower Al Habtoor City",
                "Shams JBR Apartments", "Rimal Residences", "Sadaf Apartments JBR",
                "Golden Mile Palm Jumeirah", "Jade at the Fields", "Gardenia Villas by Nakheel",
                "Dragon City Residences", "Sobha Hartland Greens", "Mohammed Bin Rashid City",
                "Nad Al Sheba Villas", "Al Khail Heights", "Azizi Riviera Apartments",
                "Creek Palace Residences", "Sunset at Creek Beach", "Lotus Creek Beach",
                "Eden at The Valley", "Bayshore Creek Beach", "Maple Townhouses Dubai Hills",
                "Sidra Villas Dubai Hills", "Golf Place Villas", "Acacia Park Heights",
                "Park Point Residences", "The Pinnacle Dubai Hills", "Ellington Belgravia",
                "Wilton Terraces by Ellington", "Collective Apartments", "Executive Residences",
                "The Terraces Sobha Hartland", "Wilton Park Residences", "Marsa Plaza Residences",
                "Al Badia Residences", "Dubai Festival City Apartments", "Deira Islands Residences",
                "Plazzo Heights JVC", "Vincitore Boulevard", "Pantheon Boulevard",
                "District One Residences", "Azizi Mirage Apartments", "Azizi Aura Residences",
                "Signature Livings JVC", "Seventh Heaven Al Barari", "Ashjar Al Barari",
                "The Nest Al Barari", "West Yas Residences", "The Address Dubai Mall",
                "The Address Fountain Views", "Burj Royale Downtown", "South Ridge Downtown",
                "Marina Promenade Dubai", "Silverene Tower Dubai Marina", "The Torch Tower Marina",
                "Princess Tower Marina", "Marina Gate Residences", "Vida Marina Residences",
                "Jumeirah Living Marina Gate", "Cayan Tower Marina", "Le Reve Marina",
                "Jumeirah Bay X1 JLT", "Jumeirah Bay X2 JLT", "Saba Tower JLT",
                "Concorde Tower JLT", "Almas Tower JLT", "Green Lakes Towers JLT",
                "Lake Terrace JLT", "Lake View JLT", "Laguna Tower JLT", "ICON Tower JLT",
                "DAMAC Heights Marina", "The One JLT Residences", "Grosvenor House Apartments",
                "Al Seef Towers", "Bahar Residences JBR", "Shoreline Apartments Palm Jumeirah",
                "Garden Homes Palm Jumeirah", "Signature Villas Palm Jumeirah",
                "Fairmont Residences Palm Jumeirah", "One Palm Jumeirah", "Muraba Residences Palm",
                "Atlantis The Royal Residences", "W Residences Palm Jumeirah",
                "Serenia Living Palm Jumeirah", "Six Senses Residences The Palm",
                "SO/ Residences Uptown Dubai", "Signature Mansions Tilal Al Ghaf",
                "Harmony Villas Tilal Al Ghaf", "AURA Tilal Al Ghaf", "Elysian Mansions",
                "Marasi Riverside Apartments", "Central Park City Walk", "The Residences JBR",
                "Vida Dubai Marina", "St. Regis Residences Downtown", "Ritz-Carlton Residences",
                "Palm Tower Apartments", "The Royal Atlantis Palm", "Dubai Wharf Residences",
                "Sobha Hartland Forest Villas", "Imperial Avenue Downtown", "One Park Avenue",
                "Anwa Residences Dubai Maritime City", "The Opus by Zaha Hadid",
                "Meliá Desert Palm Residences", "Al Seef 2 Tower JLT", "Artesia DAMAC Hills",
                "Carson Towers DAMAC Hills", "The Legends DAMAC Hills", "DAMAC Lagoons",
                "Santorini DAMAC Lagoons", "Costa Brava DAMAC Lagoons",
                "Monte Carlo DAMAC Lagoons", "Emaar South Expo Golf Villas",
                "Al Wasl 1 Residences", "Harbour Gate Dubai Creek", "Harbour Views Towers",
                "Creek Edge Residences", "Creek Rise Residences", "Palace Residences",
                "Cedar Creek Beach", "Lotus Dubai Creek", "Marina Shores Dubai Marina",
                "Marina Vista Emaar Beachfront", "South Beach Holiday Homes",
                "Beach Isle Emaar Beachfront", "Sunrise Bay Emaar Beachfront",
                "Grand Bleu Tower by Elie Saab", "Seagate Rashid Yachts & Marina",
                "Sirdhana Residences Rashid Port", "Orchid at Creek Beach", "Rosewater Creek Beach",
                "Lime Gardens Dubai Hills", "Elvira Dubai Hills", "Park Horizon Dubai Hills",
                "Palm Views Apartments", "Al Bandar Residences", "Al Zeina Residences",
                "Al Muneera Residences", "Raha Gardens", "Al Reef Villas",
                "The Bridges Al Reem Island", "Waters Edge Yas Island",
                "Mayan Residences Yas Island", "The Cedars Yas Acres",
                "Al Ghadeer Phase 2", "Jumeirah Luxury Villas", "Silver Springs Villas",
                "Veneto Residences Dubai Waterfront", "Nikki Beach Residences",
                "Nad Al Hamar Villas", "District 2020 Residences", "One Central Residences",
                "Bayz Tower Business Bay", "DAMAC Maison Prive", "Millennium Binghatti Residences",
                "Oasis Residences Masdar City", "Al Maryah Vista", "Waterfront City Al Zorah",
                "Al Mahra Desert Resort Villas", "Sharjah Waterfront City Residences",
                "Ajmal Makan Sharjah Waterfront", "Aljada by ARADA Residences", "Reem Hills",
                "Mamsha Al Saadiyat", "Jubail Island Villas", "Nurai Island Villas",
                "Lea at Yas Acres", "Saadiyat Reserve Residences", "Bloom Gardens Abu Dhabi",
                "Faya Residences Abu Dhabi", "Park View Residences Saadiyat",
                "Pixel Residences Al Reem Island", "Louvre Abu Dhabi Residences"
        };
        Random random = new Random();
        int randomIndex = random.nextInt(projects.length);
        String selectedProject = projects[randomIndex];

        clickandsend(By.name("project_name"),selectedProject+" "+"AUTO OFFPLAN FULL DATA");
        clickandsend(By.name("license_no"),"LICENSENO"+licenseNoDigits);
        clickandsend(By.name("project_no"),"PROJECTNO"+projectNoDigits);
        clickandsend(By.name("starting_price"),StartingPrice);
        doubleClick(By.xpath("//input[@placeholder='Developer company']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()="+randomPosition+"]"));
        doubleClick(By.xpath("//input[@placeholder='Select Country']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()=1]"));
        doubleClick(By.xpath("//input[@placeholder='Select State']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()=1]"));
        doubleClick(By.xpath("//input[@placeholder='Select City']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()=1]"));
        doubleClick(By.xpath("//input[@placeholder='Select Community']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()="+randomCom+"]"));
        doubleClick(By.xpath("//input[@placeholder='Select Sub Community']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()="+randomSub+"]"));
        scrollPage(800);
        doubleClick(By.xpath("//input[@placeholder='Select Completion Status']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()=1]"));
        clickandsend(By.name("completion_percentage"),completionPercentage);
        click(By.xpath("/html/body/div[2]/main/form/div[3]/div/div[2]/div/div[3]/div/div/div/div[2]/button"));
        click(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[1]/button[2]"));
        doubleClick(By.xpath("//input[@placeholder='Select Life Style']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()=1]"));
        clickandsend(By.name("plot_area"),plotArea);
        clickandsend(By.name("built_up_area"),BuiltArea);
        doubleClick(By.xpath("//input[@placeholder='Select Furnished']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()=1]"));
        clickandsend(By.name("no_of_properties"),noProperties);
        doubleClick(By.xpath("//input[@placeholder='Select Ownership']"),By.xpath("//li[contains(@class, 'MuiAutocomplete-option') and position()=1]"));
        click(By.xpath("/html/body/div[2]/main/form/div[3]/div/div[2]/div/div[10]/div/div/div/div[2]/button"));
        click(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[1]/button[1]"));
        click(By.xpath("/html/body/div[2]/main/form/div[3]/div/div[2]/div/div[11]/div/div/div/div[2]/button"));
        click(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[5]/button[4]"));
        Thread.sleep(250);
        click(By.xpath("/html/body/div[2]/main/form/div[3]/div/div[2]/div/div[12]/div/div/div/div[2]/button"));
        click(By.xpath("//button[normalize-space()=\"29\"]"));
        doubleClick(By.xpath("/html/body/div[2]/main/form/div[3]/div/div[2]/div/div[13]/div/div/div/div[1]/div/div"),By.xpath("//li[normalize-space()=\"AED\"]"));
        clickandsend(By.name("service_charge"),ServiceCharge);
        doubleClick(By.xpath("/html/body/div[2]/main/form/div[3]/div/div[2]/div/div[13]/div/div/div/div[2]/div/div"),By.xpath("//li[normalize-space()=\"sqft\"]"));
    }
    @Test(priority = 3)
    public void PoolyGoon() throws InterruptedException {
        // Locate the map container and wait for visibility
        WebElement mapContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("map")));

        // Ensure the map is in view and ready to interact with
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mapContainer);

        // Click on the polygon tool button (if it's visible and clickable)
        WebElement polygonButton = driver.findElement(By.xpath("//html[1]/body[1]/div[2]/main[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[6]/div[2]/div[1]/div[3]/div[4]/button[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", polygonButton);

        Allure.step("Clicked on the polygon icon");

        Thread.sleep(500);

        Actions actions = new Actions(driver);

        int mapWidth = mapContainer.getSize().getWidth();
        int mapHeight = mapContainer.getSize().getHeight();
        int centerX = mapWidth / 2;
        int centerY = mapHeight / 2;

// Define the box dimensions (in pixels)
        int boxWidth = 100;  // Adjust as needed
        int boxHeight = 100; // Adjust for a perfect square, or modify for rectangle

// Calculate starting point (top-left corner of the box)
        int startX = centerX - (boxWidth / 2);  // Center the box horizontally
        int startY = centerY - (boxHeight / 2); // Center the box vertically

// Move to starting point and begin drawing
        actions.moveByOffset(startX, startY).click().perform();
        Allure.step("Started at top-left corner");
        Thread.sleep(500);

// Draw top edge
        actions.moveByOffset(boxWidth, 0).click().perform();
        Allure.step("Drew top edge");
        Thread.sleep(500);

// Draw right edge
        actions.moveByOffset(0, boxHeight).click().perform();
        Allure.step("Drew right edge");
        Thread.sleep(500);

// Draw bottom edge
        actions.moveByOffset(-boxWidth, 0).click().perform();
        Allure.step("Drew bottom edge");
        Thread.sleep(500);

// Close the box by returning to start
        actions.moveByOffset(0, -boxHeight).click().perform();
        Allure.step("Closed the box");
        Thread.sleep(500);

// Final click to complete the selection
        actions.moveByOffset(1, 1).click().perform();
        Allure.step("Completed the box selection");
        Thread.sleep(500);
        actions.release().perform();
        scrollPage(250);
    }
    @Test(priority = 4)
    public void Description() throws InterruptedException {
        scrollPage(500);
        String realEstateDescription = "This beautifully designed 2-bedroom apartment offers modern living with stunning views of the city skyline. Located in the heart of the vibrant downtown area, this apartment features spacious living areas, high-end finishes, and large windows that fill the space with natural light. The fully equipped kitchen boasts state-of-the-art appliances, while the master bedroom comes with an ensuite bathroom. Residents enjoy access to premium amenities, including a rooftop pool, fully equipped fitness center, and 24/7 security. Perfectly situated near shopping centers, restaurants, and public transport, this apartment is a must-see for those seeking both luxury and convenience. Perfectly situated near shopping centers, restaurants, and public transport, this apartment is a must-see for those seeking both luxury and convenience";

        WebElement descriptionField = driver.findElement(By.xpath("//textarea[@name='description']"));descriptionField.sendKeys(realEstateDescription);

    }
    @Test(priority = 5)
    public void AmenitiesFacilities() throws InterruptedException {
        click(By.xpath("/html/body/div[2]/main/form/div[5]/div/div[2]/div/div[1]/ul/li[2]"));
        click(By.xpath("/html/body/div[2]/main/form/div[5]/div/div[2]/div/div[2]/ul/li[3]"));
        click(By.xpath("/html/body/div[2]/main/form/div[5]/div/div[2]/div/div[3]/ul/li[1]"));
        scrollPage(500);
        click(By.xpath("/html/body/div[2]/main/form/div[5]/div/div[2]/div/div[4]/ul/li[1]"));
        click(By.xpath("/html/body/div[2]/main/form/div[5]/div/div[2]/div/div[5]/ul/li"));
        scrollPage(1950);
        Thread.sleep(100);
        click(By.xpath("/html/body/div[2]/main/form/div[6]/div/div[2]/div/div[4]/ul/li[1]"));
        click(By.xpath("/html/body/div[2]/main/form/div[6]/div/div[2]/div/div[6]/ul/li[3]"));
        click(By.xpath("/html/body/div[2]/main/form/div[6]/div/div[2]/div/div[9]/ul/li[1]"));
        click(By.xpath("/html/body/div[2]/main/form/div[6]/div/div[2]/div/div[13]/ul/li[5]"));
        click(By.xpath("/html/body/div[2]/main/form/div[7]/button[1]"));
    }
}