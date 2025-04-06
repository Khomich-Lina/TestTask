package util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import dto.CheckOrderStatusRequestDto;
import dto.CreatePageApiRequestDto;
import dto.OrderApiRequestDto;
import dto.PageCustomizationApiRequestDto;

import java.util.UUID;

import static org.assertj.core.api.Fail.fail;

public class PaymentPageDtoBuilder {

    public final static ObjectMapper objectMapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

    public static CreatePageApiRequestDto createPageRequestBodyDto(String orderId) {
        return CreatePageApiRequestDto.builder()
                .order(buildOrderRequestBodyMandatoryFields(orderId))
                .pageCustomization(buildPageCustomizationRequestBodyMandatoryFields())
                .build();
    }

    public static String createPageRequestBodyMandatoryFields(String orderId) {
        return fromJsonToString(createPageRequestBodyDto(orderId));
    }

    public static String createPageRequestBodyMandatoryFields(CreatePageApiRequestDto requestDto) {
        return fromJsonToString(requestDto);
    }

    public static OrderApiRequestDto buildOrderRequestBodyMandatoryFields(String orderId) {
        return OrderApiRequestDto.builder()
                .orderId(orderId)
                .amount(100)
                .currency("EUR")
                .orderDescription("Premium package")
                .build();
    }

    public static PageCustomizationApiRequestDto buildPageCustomizationRequestBodyMandatoryFields() {
        return PageCustomizationApiRequestDto.builder()
                .publicName("Public Name")
                .build();
    }

    public static String createCheckOrderStatusRequestBody(String orderId) {
        CheckOrderStatusRequestDto requestBody = CheckOrderStatusRequestDto.builder()
                .order_id(orderId)
                .build();
        return fromJsonToString(requestBody);
    }

    public static String generateOrderId() {
        return UUID.randomUUID().toString();
    }

    private static String fromJsonToString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to serialize request body");
            return null;
        }
    }

    public static <T> T parseStrictResponse(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (UnrecognizedPropertyException e) {
            fail("Unexpected field in response: '" + e.getPropertyName() + "'");
        } catch (Exception e) {
            fail("Deserialization failed: " + e.getMessage());
        }
        return null;
    }
}
