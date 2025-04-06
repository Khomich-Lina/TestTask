package ui.steps;

import pages.PaymentCardPage;

public class PaymentSteps {

    public static void completeSuccessfulCardPayment( String cardNumber, String expiryDate,
                                                     String cvv, String email) {
        PaymentCardPage paymentPage = new PaymentCardPage();
        paymentPage.enterCardNumber(cardNumber);
        paymentPage.enterCardExpiryDate(expiryDate);
        paymentPage.enterCardCvv(cvv);
        paymentPage.enterEmail(email);
        paymentPage.clickPayButton();
    }
}
