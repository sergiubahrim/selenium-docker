//package Utils;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class DriverUtils {
//
//    protected WebDriver driver;
//
//    public WebDriver initDriver() throws MalformedURLException {
//        // BROWSER  variable : chrome or firefox
//        //HUB_HOST => localhost / ip / name
//
////        String host = "localhost";
////        DesiredCapabilities dc = DesiredCapabilities.chrome();
////
////        if(System.getProperty("BROWSER") != null &&
////                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
////            dc = DesiredCapabilities.firefox();
////        }
////
////        if (System.getProperty("HUB_HOST") != null) {
////            host = System.getProperty("HUB_HOST");
////        }
////
////        String completeUrl = "http://" + host + ":4446/wd/hub";
////        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
////
//
//        //System.getProperty("webdriver.chrome.driver" ,  "/Users/sergiu.bahrim/IdeaProjects/selenium_test/src/main/resources/drivers/chromedriver")
//
//    }
//
//    public void closeDriver() {
//
//        driver.quit();
//    }
//
//}
