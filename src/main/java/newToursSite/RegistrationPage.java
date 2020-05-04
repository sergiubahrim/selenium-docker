package newToursSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy (name = "firstName")
    private WebElement firstNameTxt;
    //private final By firstNameTxt = By.name("firstName");

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, 30);
    }

    public void goTo(){

        driver.get("http://newtours.demoaut.com/mercuryregister.php");
        wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
    }



}
