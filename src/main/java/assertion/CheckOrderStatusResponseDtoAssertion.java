package assertion;

import dto.CheckOrderStatusResponseDto;
import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

public class CheckOrderStatusResponseDtoAssertion
        extends AbstractAssert<CheckOrderStatusResponseDtoAssertion, CheckOrderStatusResponseDto> {

    public CheckOrderStatusResponseDtoAssertion(CheckOrderStatusResponseDto actual) {
        super(actual, CheckOrderStatusResponseDtoAssertion.class);
    }

    public CheckOrderStatusResponseDtoAssertion hasAmount(int expectedAmount) {
        isNotNull();

        int actualAmount = actual.getOrder().getAmount();
        if (actualAmount != expectedAmount) {
            failWithMessage("Expected amount to be <%s> but was <%s>", expectedAmount, actualAmount);
        }
        return this;
    }

    public CheckOrderStatusResponseDtoAssertion hasCurrency(String expectedCurrency) {
        isNotNull();

        String actualCurrency = actual.getOrder().getCurrency();
        if (!Objects.equals(actualCurrency, expectedCurrency)) {
            failWithMessage("Expected currency to be <%s> but was <%s>", expectedCurrency, actualCurrency);
        }

        return this;
    }

    public CheckOrderStatusResponseDtoAssertion hasSuccessfulStatus() {
        isNotNull();

        String status = actual.getOrder().getStatus();
        if (!"success".equalsIgnoreCase(status)) {
            failWithMessage("Expected status to be <success> but was <%s>", status);
        }
        return this;
    }
}
