package assertion;

import dto.CreatePageApiResponseDto;
import org.assertj.core.api.AbstractAssert;

public class CreatePageResponseDtoAssertion
        extends AbstractAssert<CreatePageResponseDtoAssertion, CreatePageApiResponseDto> {

    public CreatePageResponseDtoAssertion(CreatePageApiResponseDto actual) {
        super(actual, CreatePageResponseDtoAssertion.class);
    }

    public CreatePageResponseDtoAssertion hasNonEmptyUrl() {
        isNotNull();
        String url = actual.getUrl();
        if (url == null || url.trim().isEmpty()) {
            failWithMessage("Expected non-null and non-empty URL but was <%s>", url);
        }
        return this;
    }

    public CreatePageResponseDtoAssertion hasNonEmptyGuid() {
        isNotNull();
        String guid = actual.getGuid();
        if (guid == null || guid.trim().isEmpty()) {
            failWithMessage("Expected non-null and non-empty GUID but was <%s>", guid);
        }
        return this;
    }
}
