package assertion;

import dto.CheckOrderStatusResponseDto;
import dto.CreatePageApiResponseDto;
import dto.ErrorResponseDto;
import org.assertj.core.api.SoftAssertions;

public class PaymentPageSoftAssertionFactory extends SoftAssertions {

    public CreatePageResponseDtoAssertion assertThat(CreatePageApiResponseDto actual) {
        return proxy(CreatePageResponseDtoAssertion.class, CreatePageApiResponseDto.class, actual);
    }

    public ErrorResponseDtoAssertion assertThat(ErrorResponseDto actual) {
        return proxy(ErrorResponseDtoAssertion.class, ErrorResponseDto.class, actual);
    }

    public CheckOrderStatusResponseDtoAssertion assertThat(CheckOrderStatusResponseDto actual) {
        return proxy(CheckOrderStatusResponseDtoAssertion.class, CheckOrderStatusResponseDto.class, actual);
    }

}
