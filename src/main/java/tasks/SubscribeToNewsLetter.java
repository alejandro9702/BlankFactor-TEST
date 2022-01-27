package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import userinterface.BlogsBlankFactor;
import utils.RandomData;

import java.time.Duration;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SubscribeToNewsLetter implements Task {

    private String email;


    public SubscribeToNewsLetter(String email) {
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Random randomGenerator = new Random();
        actor.attemptsTo(
                Scroll.to(BlogsBlankFactor.SUBSCRIBE_EMAIL_INPUT.waitingForNoMoreThan(Duration.ofSeconds(5))).andAlignToBottom(),
                Enter.theValue(email).into(BlogsBlankFactor.SUBSCRIBE_EMAIL_INPUT).then(Click.on(BlogsBlankFactor.SUBSCRIBE_BUTTON))
                );
        BlogsBlankFactor.SUBSCRIBE_LOADER_BUTTON.resolveFor(actor).waitUntilNotVisible();


    }



    public static SubscribeToNewsLetter withTheEmail(String email) {
        return instrumented(SubscribeToNewsLetter.class, email);
    }
}
