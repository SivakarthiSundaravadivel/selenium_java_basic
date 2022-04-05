package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class Task2 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void initialFeedbackPage() throws Exception {

        String name = driver.findElement(By.id("fb_name")).getText();
        String age = driver.findElement(By.id("fb_age")).getText();
        String comment = driver.findElement(By.name("comment")).getText();
        Select dropdownselect = new Select(driver.findElement(By.id("like_us")));

        assertEquals("",name);
        assertEquals("",age);
        assertFalse(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/input[1]")).isSelected());
        assertFalse(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/input[2]")).isSelected());
        assertFalse(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/input[3]")).isSelected());
        assertFalse(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/input[4]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[2]")).isSelected());
        assertEquals("",comment);

        List<WebElement> allSelections;
        allSelections = dropdownselect.getAllSelectedOptions();
        dropdownselect.selectByVisibleText("Choose your option");
        assertEquals(1,allSelections.size());

        String color = "rgba(255, 255, 255, 1)";
        assertEquals(color,driver.findElement(By.tagName("button")).getCssValue("color").trim());

        String background = "rgba(33, 150, 243, 1)";
        assertEquals(background,driver.findElement(By.tagName("button")).getCssValue("background-color").trim());









//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
    }

    @Test
    public void emptyFeedbackPage() throws Exception {

        String name = "";
        String age = "";
        String language = "";
        String gender = "null";
        String option = "null";
        String comment = "";

        driver.findElement(By.tagName("button")).click();
        assertEquals(name,driver.findElement(By.id("name")).getText());
        assertEquals(age,driver.findElement(By.id("age")).getText());
        assertEquals(language,driver.findElement(By.id("language")).getText());
        assertEquals(gender,driver.findElement(By.id("gender")).getText());
        assertEquals(option,driver.findElement(By.id("option")).getText());
        assertEquals(comment,driver.findElement(By.id("comment")).getText());

        String ycolor = "rgba(255, 255, 255, 1)";
        assertEquals(ycolor,driver.findElement(By.className("w3-green")).getCssValue("color").trim());

        String ybackground = "rgba(76, 175, 80, 1)";
        assertEquals(ybackground,driver.findElement(By.className("w3-green")).getCssValue("background-color").trim());


        String rcolor = "rgba(255, 255, 255, 1)";
        assertEquals(rcolor,driver.findElement(By.className("w3-red")).getCssValue("color").trim());

        String rbackground = "rgba(244, 67, 54, 1)";
        assertEquals(rbackground,driver.findElement(By.className("w3-red")).getCssValue("background-color").trim());







//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {


        String name = "siva";
        String age = "25";
        String comment = "This is Sivakarthi Sundaravadivel";

        WebElement option = driver.findElement(By.id("like_us"));
        Select dropdown = new Select(option);

        driver.findElement(By.id("fb_name")).sendKeys(name);
        driver.findElement(By.id("fb_age")).sendKeys(age);
        driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]")).click();
        dropdown.selectByVisibleText("Good");
        driver.findElement(By.name("comment")).sendKeys(comment);
        driver.findElement(By.tagName("button")).click();

        String ycolor = "rgba(255, 255, 255, 1)";
        assertEquals(ycolor,driver.findElement(By.className("w3-green")).getCssValue("color").trim());

        String ybackground = "rgba(76, 175, 80, 1)";
        assertEquals(ybackground,driver.findElement(By.className("w3-green")).getCssValue("background-color").trim());


        String rcolor = "rgba(255, 255, 255, 1)";
        assertEquals(rcolor,driver.findElement(By.className("w3-red")).getCssValue("color").trim());

        String rbackground = "rgba(244, 67, 54, 1)";
        assertEquals(rbackground,driver.findElement(By.className("w3-red")).getCssValue("background-color").trim());



//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {

        String name = "siva";
        driver.findElement(By.id("fb_name")).sendKeys(name);
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.className("w3-green")).click();
        assertEquals("Thank you, "+name+", for your feedback!",driver.findElement(By.id("message")).getText());

        String rcolor = "rgba(255, 255, 255, 1)";
        assertEquals(rcolor,driver.findElement(By.id("message")).getCssValue("color").trim());

        String rbackground = "rgba(76, 175, 80, 1)";
        assertEquals(rbackground,driver.findElement(By.className("w3-green")).getCssValue("background-color").trim());

//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {

        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.className("w3-green")).click();
        assertEquals("Thank you for your feedback!",driver.findElement(By.id("message")).getText());

        String rcolor = "rgba(255, 255, 255, 1)";
        assertEquals(rcolor,driver.findElement(By.id("message")).getCssValue("color").trim());

        String rbackground = "rgba(76, 175, 80, 1)";
        assertEquals(rbackground,driver.findElement(By.className("w3-green")).getCssValue("background-color").trim());


//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
    }

    @Test
    public void noOnFeedbackPage() throws Exception {


        String name = "siva";
        String age = "25";
        String comment = "This is Sivakarthi Sundaravadivel";

        WebElement option = driver.findElement(By.id("like_us"));
        Select dropdown = new Select(option);

        driver.findElement(By.id("fb_name")).sendKeys(name);
        driver.findElement(By.id("fb_age")).sendKeys(age);
        driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]")).click();
        dropdown.selectByVisibleText("Good");
        driver.findElement(By.name("comment")).sendKeys(comment);

        driver.findElement(By.tagName("button")).click();

        driver.findElement(By.className("w3-red")).click();

        assertEquals(name, driver.findElement(By.xpath("//*[@id=\"fb_name\"]")).getAttribute("value"));
        assertEquals(age, driver.findElement(By.id("fb_age")).getAttribute("value"));
        assertTrue(driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]")).isSelected());
        assertTrue(driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]")).isSelected());


        Select select = new Select(driver.findElement(By.id("like_us")));
        WebElement options = select.getFirstSelectedOption();
        String defaultItem = options.getText();

        assertEquals(defaultItem, driver.findElement(By.id("like_us")).getAttribute("value"));

        Thread.sleep(10000);


//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
    }
}
