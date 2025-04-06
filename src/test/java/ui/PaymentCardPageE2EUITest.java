package ui;

import dto.CheckOrderStatusResponseDto;
import dto.CreatePageApiRequestDto;
import io.restassured.response.Response;
import org.junit.Test;
import pages.PaymentResultPage;

import static api.CheckoutSolutionSvcApi.createPage;
import static api.PaymentsSvcApi.checkOrderStatus;
import static com.codeborne.selenide.Selenide.open;
import static ui.steps.PaymentSteps.completeSuccessfulCardPayment;
import static util.Constants.*;
import static util.PaymentPageDtoBuilder.*;
import static util.PaymentPageDtoBuilder.createPageRequestBodyDto;

public class PaymentCardPageE2EUITest extends BaseUiTests {

    @Test
    public void testProvidingPaymentAndCheckTheStatus() {
        String orderId = generateOrderId();
        CreatePageApiRequestDto createPageRequestBodyDto = createPageRequestBodyDto(orderId);
        String createPageRequestBody = createPageRequestBodyMandatoryFields(createPageRequestBodyDto);
        String pageUrl = getPageUrl(createPage(createPageRequestBody));

        open(pageUrl);
        completeSuccessfulCardPayment(CARD_NUMBER_SUCCESS, CARD_EXPIRY_DATE, CARD_CVV, PAYMENT_EMAIL);

        PaymentResultPage resultPage = new PaymentResultPage();
        resultPage.verifyPaymentSuccessOnUI();

        String statusRequestBody = createCheckOrderStatusRequestBody(orderId);
        Response checkOrderStatusResponse = checkOrderStatus(statusRequestBody);

        CheckOrderStatusResponseDto responseDto = parseStrictResponse(checkOrderStatusResponse.getBody().asString(), CheckOrderStatusResponseDto.class);
        softAssertionFactory.assertThat(responseDto)
                .hasAmount(createPageRequestBodyDto.getOrder().getAmount())
                .hasCurrency(createPageRequestBodyDto.getOrder().getCurrency())
                .hasSuccessfulStatus();
    }

}