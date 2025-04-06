package assertion;

import dto.ErrorResponseDto;
import org.assertj.core.api.AbstractAssert;

import java.util.Map;

public class ErrorResponseDtoAssertion extends AbstractAssert<ErrorResponseDtoAssertion, ErrorResponseDto> {

    public ErrorResponseDtoAssertion(ErrorResponseDto actual) {
        super(actual, ErrorResponseDtoAssertion.class);
    }

    public ErrorResponseDtoAssertion hasErrorCode(String expectedCode) {
        isNotNull();

        if (!actual.getError().getCode().equals(expectedCode)) {
            failWithMessage("Expected error code to be <%s> but was <%s>", expectedCode,
                    actual.getError().getCode());
        }

        return this;
    }

    public ErrorResponseDtoAssertion hasFieldError(String field, String expectedMessage) {
        isNotNull();

        if (actual.getError().getMessage() instanceof Map) {
            Map<String, String> messageMap = (Map<String, String>) actual.getError().getMessage();
            String actualMessage = messageMap.get(field);
            if (actualMessage == null || !actualMessage.equals(expectedMessage)) {
                failWithMessage("Expected field <%s> to have message <%s> but was <%s>", field,
                        expectedMessage, actualMessage);
            }
        }

        return this;
    }

    public ErrorResponseDtoAssertion hasAuthenticationErrorMessage(String expectedMessage) {
        isNotNull();

        if (actual.getMessage() instanceof String && !actual.getMessage().equals(expectedMessage)) {
            failWithMessage("Expected authentication error message to be <%s> but was <%s>",
                    expectedMessage, actual.getMessage());
        }

        return this;
    }
}
