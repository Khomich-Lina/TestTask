package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static util.Constants.SUCCESSFUL_PAYMENT;

@Getter
public class PaymentResultPage {

    @FindBy(css = "[data-testid='status-title']")
    private SelenideElement statusTitle;

    @FindBy(css = "[data-testid='status-order-price-header']")
    private SelenideElement orderPrice;

    public PaymentResultPage() {
        page(this);
    }

    public void verifyPaymentSuccessOnUI() {
        statusTitle.shouldBe(visible)
                .shouldHave(text(SUCCESSFUL_PAYMENT));
    }
}