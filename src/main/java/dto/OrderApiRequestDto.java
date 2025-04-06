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
public class OrderApiRequestDto {

    @JsonProperty("order_id")
    private String orderId;
    private Integer amount;
    private String currency;

    @JsonProperty("order_description")
    private String orderDescription;

    @JsonProperty("order_items")
    private String orderItems;

    @JsonProperty("order_date")
    private String orderDate;

    @JsonProperty("order_number")
    private Integer orderNumber;

    private String type;

    @JsonProperty("settle_interval")
    private Integer settleInterval;

    private Boolean force3ds;

    @JsonProperty("google_pay_allowed_auth_methods")
    private List<String> googlePayAllowedAuthMethods;

    @JsonProperty("customer_date_of_birth")
    private String customerDateOfBirth;

    @JsonProperty("customer_email")
    private String customerEmail;

    @JsonProperty("customer_first_name")
    private String customerFirstName;

    @JsonProperty("customer_last_name")
    private String customerLastName;

    @JsonProperty("customer_phone")
    private String customerPhone;

    @JsonProperty("traffic_source")
    private String trafficSource;

    @JsonProperty("transaction_source")
    private String transactionSource;

    @JsonProperty("purchase_country")
    private String purchaseCountry;

    @JsonProperty("geo_country")
    private String geoCountry;

    @JsonProperty("geo_city")
    private String geoCity;

    private String language;
    private String website;

    @JsonProperty("order_metadata")
    private OrderMetadata orderMetadata;

    @JsonProperty("success_url")
    private String successUrl;

    @JsonProperty("fail_url")
    private String failUrl;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderMetadata {
        @JsonProperty("coupon_code")
        private String couponCode;

        @JsonProperty("partner_id")
        private String partnerId;
    }
}
