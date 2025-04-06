package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CheckoutSolutionSvcApi extends BaseApi {

    private static final String BASE_URL = configLoader.getProperty("checkout.solution.service.baseUrl");
    private static final String BASE_PATH = getBaseUrl(BASE_URL);
    private static final String CREATE_PAGE_ENDPOINT = "/init";

    public static Response createPage(String requestBody) {
        String signature = generator.getSignature(PUBLIC_KEY, requestBody, SECRET_KEY);

        return RestAssured.given().log().all()
                .baseUri(BASE_PATH)
                .header("merchant", PUBLIC_KEY)
                .header("signature", signature)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(CREATE_PAGE_ENDPOINT)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response createPageWithCustomSignature(String requestBody, String signature) {
        return RestAssured.given().log().all()
                .baseUri(BASE_PATH)
                .header("merchant", PUBLIC_KEY)
                .header("signature", signature)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(CREATE_PAGE_ENDPOINT)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
