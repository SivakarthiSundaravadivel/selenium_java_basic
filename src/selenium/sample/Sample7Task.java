package selenium.sample;

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

public class Sample7Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void selectCheckBox() throws Exception {

        WebElement opt1 = driver.findElement(By.id("vfb-6-0"));

        WebElement opt2 = driver.findElement(By.id("vfb-6-1"));

        WebElement opt3= driver.findElement(By.id("vfb-6-2"));

        assertFalse(opt1.isSelected());

        assertFalse(opt2.isSelected());

        assertFalse(opt3.isSelected());

        driver.findElement(By.id("vfb-6-1")).click();
        assertFalse(opt1.isSelected());
        assertFalse(opt3.isSelected());
        assertTrue(opt2.isSelected());

        driver.findElement(By.id("result_button_checkbox")).click();

        assertEquals("You selected value(s): Option 2",driver.findElement(By.id("result_checkbox")).getText());

        Thread.sleep(2000);


//         TODO:
//        check that none of the checkboxes are ticked
//        tick  "Option 2"
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
//        click result
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
    }


    @Test
    public void selectRadioButton() throws Exception {


        WebElement radiobutton1 = driver.findElement(By.id("vfb-7-1"));

        WebElement radiobutton2 = driver.findElement(By.id("vfb-7-2"));

        WebElement radiobutton3 = driver.findElement(By.id("vfb-7-3"));

        assertFalse(radiobutton1.isSelected());

        assertFalse(radiobutton2.isSelected());

        assertFalse(radiobutton3.isSelected());

        driver.findElement(By.id("vfb-7-3")).click();

        assertFalse(radiobutton1.isSelected());

        assertFalse(radiobutton2.isSelected());

        assertTrue(radiobutton3.isSelected());

        driver.findElement(By.id("vfb-7-1")).click();

        assertTrue(radiobutton1.isSelected());

        assertFalse(radiobutton2.isSelected());

        assertFalse(radiobutton3.isSelected());

        driver.findElement(By.id("result_button_ratio")).click();

        Thread.sleep(2000);

        assertEquals("You selected option: Option 1",driver.findElement(By.id("result_radio")).getText());


//         TODO:
//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed
    }

    @Test
    public void selectOption() throws Exception {


        WebElement dropdown = driver.findElement(By.id("vfb-12"));
        Select dropdownselect = new Select(dropdown);
        List<WebElement> allSelections;
        dropdownselect.selectByVisibleText("Option 3");
        allSelections = dropdownselect.getAllSelectedOptions();
        assertEquals(1,allSelections.size());
        assertEquals("Option 3", allSelections.get(0).getText());
        dropdownselect.selectByVisibleText("Option 2");
        allSelections = dropdownselect.getAllSelectedOptions();
        assertEquals(1,allSelections.size());
        assertEquals("Option 2", allSelections.get(0).getText());



        driver.findElement(By.id("vfb-12")).click();


//        select "Option 3" in Select
//        check that selected option is "Option 3"
//        select "Option 2" in Select
//        check that selected option is "Option 2"
//        click result
//        check that 'You selected option: Option 2' text is being displayed
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added
    }
}
