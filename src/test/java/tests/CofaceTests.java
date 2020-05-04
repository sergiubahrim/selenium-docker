package tests;

import coface.CofaceElementsAndActions;
import org.testng.annotations.Test;

public class CofaceTests extends BaseTest {

//    @Test
//
//
//
//    public void cofaceAddOneTimeCheck() throws InterruptedException {
//
//        CofaceElementsAndActions cf1 = new CofaceElementsAndActions(driver);
//        cf1.LoginAndCountry("sergiu.bahrim+ko1@tradeshift.com", "Password123");
//        cf1.SearchRiskCheck();
//        cf1.AddRiskCheck();
//        cf1.FinishOrder();
//    }

    @Test //(dependsOnMethods = "cofaceAddOneTimeCheck" )

    public void cofaceAddScoringInquiry() throws InterruptedException {

        CofaceElementsAndActions cf1 = new CofaceElementsAndActions(driver);
        cf1.LoginAndCountry("sergiu.bahrim+ko3@tradeshift.com", "Password123");
        cf1.AddInquiry();
        cf1.FinishOrder();
    }
}
