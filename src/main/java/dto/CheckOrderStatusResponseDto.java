package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckOrderStatusResponseDto {
    private OrderDto order;
    private ErrorDto error;
    private TransactionDto transaction;
    private Map<String, TransactionDto> transactions;
    private ThreeDsDto three_ds;
    private RoutingDto routing;
    private VerificationResultDto verification_result;
    private Map<String, ChargebackDto> chargebacks;
    private DeviceInfoDto device_info;
    private String verify_url;
    private String redirect_url;
    private OrderMetadataDto order_metadata;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDto {
        private String order_id;
        private String order_description;
        private String psp_order_id;
        private String provider_payment_id;
        private String product_id;
        private String subscription_id;
        private int amount;
        private String currency;
        private int processing_amount;
        private String processing_currency;
        private int marketing_amount;
        private String marketing_currency;
        private int refunded_amount;
        private String status;
        private String auth_code;
        private String payment_type;
        private String customer_account_id;
        private String customer_email;
        private String descriptor;
        private String mid;
        private String traffic_source;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorDto {
        private String code;
        private List<String> messages;
        private String recommended_message_for_user;
        private String merchant_advice_code;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TransactionDto {
        private String id;
        private String created_at;
        private String updated_at;
        private int amount;
        private String currency;
        private int marketing_amount;
        private String marketing_currency;
        private String operation;
        private String status;
        private String descriptor;
        private BillingDetailsDto billing_details;
        private String refund_reason;
        private String refund_reason_code;
        private CardTokenDto card_token;
        private CardDto card;
        private ErrorDto error;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BillingDetailsDto {
        private String address;
        private String city;
        private String country;
        private String state;
        private String zip;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CardTokenDto {
        private String token;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CardDto {
        private String bank;
        private String bin;
        private String brand;
        private String card_exp_month;
        private int card_exp_year;
        private String card_holder;
        private String card_type;
        private String card_id;
        private String country;
        private String number;
        private CardTokenDto card_token;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ThreeDsDto {
        private String eci;
        private String flow;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoutingDto {
        private List<CascadeStepDto> cascade_steps;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CascadeStepDto {
        private String mid;
        private String mid_descriptor;
        private String route_id;
        private int cascade_number;
        private String segment_id;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VerificationResultDto {
        private String avs_result;
        private String cvv_result;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChargebackDto {
        private long id;
        private String dispute_date;
        private String settlement_date;
        private int amount;
        private String currency;
        private String type;
        private String status;
        private String reason_group;
        private String reason_code;
        private String reason_description;
        private List<ChargebackFlowDto> chargeback_flow;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChargebackFlowDto {
        private long id;
        private String date;
        private String updated_date;
        private String settlement_date;
        private String deadline_date;
        private int amount;
        private int dispute_amount;
        private String currency;
        private String type;
        private String status;
        private String arn_code;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeviceInfoDto {
        private String user_agent;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderMetadataDto {
        private String coupon_code;
        private String partner_id;
    }
}
