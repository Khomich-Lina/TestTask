package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePageApiRequestDto {

    private OrderApiRequestDto order;

    @JsonProperty("page_customization")
    private PageCustomizationApiRequestDto pageCustomization;
}
