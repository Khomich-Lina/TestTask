package api;

import assertion.PaymentPageSoftAssertionFactory;
import org.junit.Before;

public class PaymentCardPageBaseApiTests {

    protected PaymentPageSoftAssertionFactory softAssertionFactory;

    @Before
    public void baseSetup() {
        softAssertionFactory = new PaymentPageSoftAssertionFactory();
    }
}
