package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TabsTest {
    public static void main(String[] args){
        try{
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://qatabs.ccbp.tech/");

            // click on button About
            WebElement aboutButton = driver.findElement(By.xpath("//button[starts-with(@id, 'about')]"));
            aboutButton.click();

            // to find the content of the text
            WebElement aboutContent = driver.findElement(By.xpath("//div[starts-with(@id, 'about')]//p"));
            String actualContent = aboutContent.getText();

            String expectedContent = "Varanasi is one of the oldest living cities in the world. Its Prominence in Hindu mythology is virtually unrevealed. Mark Twain, the English author and literature, who was enthralled by the legend and sanctity of Benaras, once wrote, \"Benaras is older than history, older than tradition, older even than legend and looks twice as old as all of them put together\".";

            // verify the content
            if (expectedContent.equals(actualContent)) {
                System.out.println("About Content Matched");
            } else {
                System.out.println("Mismatch in the 'About' Content");
            }
            // time to visit button
            WebElement timeToVisit=driver.findElement(By.xpath("//button[starts-with(@id, 'timeToVisit')]"));
            timeToVisit.click();
            // to find the content of the visit
            WebElement aboutTimeTo=driver.findElement(By.xpath("//div[starts-with(@id, 'timeToVisit')]//p"));
            // to retrive current text
            String timeTextContent=aboutTimeTo.getText();
            // to expected text
            String expectedAboutTimeTo="October to March is the best time to visit Varanasi because most of the fairs here are held during this time of the year. Festivities begin with Diwali and continue to Dev Diwali celebrated on the 15th day from Diwali. In between, there is also Annakut. During this time, the ghats are lit with lights and diyas. Earthen lamps adorn the staircase of the ghats and are also afloat in the river. Firecrackers burn through the night, and it's a sight no one should miss.";
            // to verify the text
            if(expectedAboutTimeTo.equals(timeTextContent)){
                System.out.println("Time to Visit Content Matched");
            }else{
                System.out.println("Mismatch in the 'Time to Visit' Content");
            }
            // test the attractions
            WebElement attractionsText=driver.findElement(By.xpath("//button[starts-with(@id, 'attractions')]"));
            attractionsText.click();
            //get the Text on attractions
            WebElement attractionsTextElement=driver.findElement(By.xpath("//div[starts-with(@id,'attractions')]//p"));
            // retrive the current text
            String attractionsTextPara=attractionsTextElement.getText();
            // expected text
            String CurrentTextPara="When visiting Varanasi, one comes across plenty of ghats, but among them, Dashashwamedh Ghat is said to be one of the oldest and most important. This ghat, leading to the Ganges, is located close to the famous old Vishwanath temple in Kashi (today’s Banaras). Another famous attraction is River Ganges which is the holiest river by the Hindus and many more.";
            // check the current text and expected text equall or not
            if(CurrentTextPara.equals(attractionsTextPara)){
                System.out.println("Attractions Content Matched");
            }else{
                System.out.println("Attractions' Content");
            }
            driver.quit();

        }catch (Exception e){
            System.out.println("An exception occurred: "+e.getMessage());
        }

    }

}
