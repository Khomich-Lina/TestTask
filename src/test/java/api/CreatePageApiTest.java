package api;

import dto.CreatePageApiResponseDto;
import dto.ErrorResponseDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static api.CheckoutSolutionSvcApi.createPage;
import static api.CheckoutSolutionSvcApi.createPageWithCustomSignature;
import static org.junit.Assert.*;
import static util.Constants.AUTHENTICATION_ERROR;
import static util.Constants.BLANK_ERROR;
import static util.PaymentPageDtoBuilder.*;

public class CreatePageApiTest extends PaymentCardPageBaseApiTests {

    @Test
    public void testCreatePageOneTimePaymentApiCall() {
        String orderId = generateOrderId();
        String requestBody = createPageRequestBodyMandatoryFields(orderId);

        Response response = createPage(requestBody);

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        CreatePageApiResponseDto dto = parseStrictResponse(response.getBody().asString(),
                CreatePageApiResponseDto.class);

        softAssertionFactory.assertThat(dto)
                .hasNonEmptyUrl()
                .hasNonEmptyGuid();
    }

    @Test
    public void testCreatePageWithInvalidSignatureShouldReturnUnauthorizedError() {
        String orderId = generateOrderId();
        String requestBody = createPageRequestBodyMandatoryFields(orderId);
        String invalidSignature = "invalid_signature";

        Response response = createPageWithCustomSignature(requestBody, invalidSignature);

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        ErrorResponseDto dto = parseStrictResponse(response.getBody().asString(), ErrorResponseDto.class);

        softAssertionFactory.assertThat(dto)
                .hasErrorCode("1.01")
                .hasAuthenticationErrorMessage("Authentication failed");
    }

    @Test
    public void testCreatePageWithMissingFieldsAndAuthenticationError() {
        String requestBody = "{ \"order\": {}}";

        Response response = createPage(requestBody);

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        ErrorResponseDto dto = parseStrictResponse(response.getBody().asString(), ErrorResponseDto.class);

        softAssertionFactory.assertThat(dto)
                .hasErrorCode("2.01")
                .hasFieldError("order", BLANK_ERROR)
                .hasFieldError("page_customization", BLANK_ERROR)
                .hasAuthenticationErrorMessage(AUTHENTICATION_ERROR);
    }

}
