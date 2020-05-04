package coface;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import static Utils.SeleniumUtils.*;

public class CofaceElementsAndActions {

    public WebDriver driver;
    private final String url1 = "https://sandbox.tradeshift.com";
    private final By usernameBox = By.id("j_username");
    private final By passwordBox = By.id("j_password");
    private final By continueButton = By.id("proceed");
    private final String url2 = "https://sandbox.tradeshift.com/#/PlatformApps.Coface";
    private final By iframe = By.name("main-app-iframe");
    private final By acceptTerms = By.xpath("//*[@id=\'root\']/div/div/form/button");
    private final By viewPortfolio = By.cssSelector("button.ts-primary");
    private final By addCompany = By.cssSelector("button.ts-secondary");
    //private final By addCompany = By.xpath("//*[@id=\'root\']/div/div/header/button");
    private final By countrySelect = By.cssSelector("button#show-filters");
    //private final By countrySelect = By.xpath("//*[@id=\'show-filters\']");
    private final By countrySelect2 = By.cssSelector("input.ts-fakeselectinput");
    //private final By countrySelect2 = By.xpath("//*[@id=\'filters-form\']/fieldset[1]/label/input");
    private final By countrySelect3 = By.xpath("//*[@id=\'countries-aside\']/form/fieldset/label/input");
    private final By countryName = By.xpath("//*[@id=\'countries-aside\']/div/menu/li");
    private final By countryName2 = By.xpath("//*[@id='countries-aside']/form/fieldset/label/input");
    private final By searchCountry = By.xpath("//*[@id='search-filters']/div/menu/li/button");
    private final By searchWord = By.xpath("//*[@id=\'modal-root\']/div/div/div/div/form/fieldset[2]/label/input");
    private final By firstResult = By.xpath("//*[@id=\'modal-root\']/div/div/div/div/menu/li[1]");
    private final By continue1 = By.xpath("(//button[@data-ts='Button'])[4]");
    private final By proceedToCheckout = By.xpath("(//button[@data-ts='Button'])[6]");
    //private final By proceedToCheckout = By.cssSelector("button.ts-button:nth-of-type(6)");
    //private final By proceedToCheckout = By.cssSelector("button.ts-primary");
    private final By acceptTandC = By.xpath("//*[@id=\'terms-agree\']/fieldset/label/span[1]");
    // private final By acceptTandC = By.cssSelector("input#terms-and-conditions-check");
    private final By proceedToPayment = By.cssSelector("button.ts-primary");
    private final By cardNumber = By.cssSelector("input.adyen-card-number");
    private final By cvc = By.cssSelector("input#adyen-cvc");
    //private final By expMonth = By.cssSelector("(input.ts-fakeselectinput");
    private final By holderName = By.cssSelector("input#adyen-holder-name");
    private final By closeYear = By.xpath("(//button[@data-ts='Button'])[5]");
    public final By clickYear = By.xpath("(//input[@data-ts-spirit='ts.ui.FakeSelectInputSpirit'])[2]");
    private final By pay = By.cssSelector("button.ts-primary");
    private final By viewPortfolioAfterPurchase = By.xpath("//*[@id=\'modal-root\']/div/div/div/div/button");
    private final By selectOneTimeCheck = By.xpath("//*[@id=\'modal-root\']/div/div/div/div/div[2]/div/form/label[2]/span");
    private final By clickScoringInquiry = By.linkText("Create a Scoring Inquiry");
    private final By city = By.id("city");
    // private final By continue1 = By.xpath("//*[@id=\'buttonkey015843776\']");

    public CofaceElementsAndActions(WebDriver driver) {
        this.driver = driver;
    }

    public void LoginAndCountry(String username, String password) throws InterruptedException {

        goToUrl(driver, url1);
        fill(driver, usernameBox, username);
        fill(driver, passwordBox, password);
        click(driver, continueButton);
        goToUrl(driver, url2);
        Thread.sleep(5000);
        switchIframe();
        waitAndClick(driver, viewPortfolio);
        System.out.println("Portfolio accessed! \nAdd monitoring process started!");

        waitAndClick(driver, addCompany);
        waitAndClick(driver, countrySelect);
        Thread.sleep(1000);
        waitAndClick(driver, countrySelect2);
        waitAndClick(driver, countrySelect3);
        driver.findElement(countryName2).sendKeys("romania");
        waitAndClick(driver, countryName);
        waitAndClick(driver, searchCountry);
        System.out.println("Country selected!");


    }

    public void SearchMonitoring() throws InterruptedException {

        monitoringSearch(driver, searchWord);
        System.out.println("Company searched!");
        Thread.sleep(8000);
        waitAndClick(driver, firstResult);
        Thread.sleep(2000);
        waitElement(driver, continue1);
        driver.findElement(continue1).sendKeys(Keys.RETURN);
        System.out.println("Monitoring service selected!");


    }

    public void SearchRiskCheck() throws InterruptedException {
        riskCheckSearch(driver, searchWord);
        System.out.println("Company searched!");
        Thread.sleep(8000);
        waitAndClick(driver, firstResult);
        Thread.sleep(2000);


    }


    public void AddRiskCheck() throws InterruptedException {

        waitAndClick(driver, selectOneTimeCheck);
        System.out.println("Risk check selected!");
        waitElement(driver, continue1);
        driver.findElement(continue1).sendKeys(Keys.RETURN);

    }

    public void FinishOrder() throws InterruptedException {

        waitElement(driver, proceedToCheckout);
        waitAndClick(driver, proceedToCheckout);
        System.out.println("Basket reached; proceed to checkout!");
        Thread.sleep(3000);

        waitAndClick(driver, acceptTandC);
        Thread.sleep(2000);
        waitAndClick(driver, proceedToPayment);
        System.out.println("T&C accepted; proceed to payment!");

        waitElementToBeClickable(driver, cardNumber);
        driver.findElement(cardNumber).sendKeys("4111111145551142");
        waitElementToBeClickable(driver, cvc);
        driver.findElement(cvc).sendKeys("737");
        Select dropdownMonth = new Select(driver.findElement(By.id("adyen-expiry-month")));
        dropdownMonth.selectByIndex(9);
        waitElementToBeClickable(driver, closeYear);
        driver.findElement(closeYear).sendKeys(Keys.RETURN);
        Select dropdownYear = new Select(driver.findElement(By.id("adyen-expiry-year")));
        dropdownYear.selectByIndex(1);
        waitElementToBeClickable(driver, closeYear);
        driver.findElement(closeYear).sendKeys(Keys.RETURN);
        waitElementToBeClickable(driver, holderName);
        driver.findElement(holderName).sendKeys("gogonel");
        waitElementToBeClickable(driver, pay);
        driver.findElement(pay).sendKeys(Keys.RETURN);
        System.out.println("Payment made!");

        waitElementToBeClickable(driver, viewPortfolioAfterPurchase);
        driver.findElement(viewPortfolioAfterPurchase).sendKeys(Keys.RETURN);
        System.out.println("Back to portfolio! \nTest finished successfully!!");
        Thread.sleep(6000);

    }

    public void AddInquiry() throws InterruptedException {
        inquirySearch(driver, searchWord);
        waitAndClick(driver, clickScoringInquiry);
        driver.findElement(city).sendKeys("TESTCITY2");
        waitElement(driver, proceedToPayment);
        driver.findElement(proceedToPayment).sendKeys(Keys.RETURN);
    }

    public void switchIframe() {

        waitElement(driver, iframe);
        driver.switchTo().frame(driver.findElement(iframe));
    }


    public void GetChromeVersion() {
        ChromeOptions options = new ChromeOptions();
        System.out.println(options.getCapabilityNames());

        System.out.println("SUccess");

    }

}
