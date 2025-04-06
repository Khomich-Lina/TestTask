package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageCustomizationApiRequestDto {

    @JsonProperty("public_name")
    private String publicName;

    @JsonProperty("order_title")
    private String orderTitle;

    @JsonProperty("order_description")
    private String orderDescription;

    @JsonProperty("payment_methods")
    private List<String> paymentMethods;

    @JsonProperty("button_font_color")
    private String buttonFontColor;

    @JsonProperty("button_color")
    private String buttonColor;

    @JsonProperty("font_name")
    private String fontName;

    @JsonProperty("is_cardholder_visible")
    private Boolean isCardholderVisible;

    @JsonProperty("terms_url")
    private String termsUrl;

    @JsonProperty("back_url")
    private String backUrl;
}
