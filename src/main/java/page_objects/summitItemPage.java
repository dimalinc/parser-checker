package page_objects;

import elements_web.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class summitItemPage {

    Button checkTheFit_Button = new Button("btnApplicationTab");

    private WebDriver driver;
    WebElement button_checkTheFit = driver.findElement(By.id("btnApplicationTab"));



}
