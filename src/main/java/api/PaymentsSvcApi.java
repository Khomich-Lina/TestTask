package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PaymentsSvcApi extends BaseApi {

    private static final String BASE_URL = configLoader.getProperty("payments.service.baseUrl");
    private static final String BASE_PATH = getBaseUrl(BASE_URL);
    private static final String CHECK_ORDER_STATUS_ENDPOINT = "/status";

    public static Response checkOrderStatus(String requestBody) {
        String signature = generator.getSignature(PUBLIC_KEY, requestBody, SECRET_KEY);

        return RestAssured.given().log().all()
                .baseUri(BASE_PATH)
                .header("merchant", PUBLIC_KEY)
                .header("signature", signature)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(CHECK_ORDER_STATUS_ENDPOINT)
                .then().log().all()
                .extract().response();
    }
}
