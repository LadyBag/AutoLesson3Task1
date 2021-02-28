import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DebitCardTest {
    @Test
    void shouldSuccessSubmit() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[name=name]").setValue("Василий Алибабаев");
        form.$("[name=phone]").setValue("+79271234567");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}

