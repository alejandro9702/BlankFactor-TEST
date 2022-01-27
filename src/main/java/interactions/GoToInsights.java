package interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HoverOverTarget;
import userinterface.BlankFactorPage;

import static userinterface.BlankFactorPage.INSIGHTS_TAB;

public class GoToInsights implements net.serenitybdd.screenplay.Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

         final String BLOG_SECTION= "Blog";

        actor.attemptsTo(
                HoverOverTarget.over(INSIGHTS_TAB),
                Click.on(BlankFactorPage.BLOG_SECTION.of(BLOG_SECTION))
        );

    }
    public static GoToInsights intoBlogSection() {
        return new GoToInsights();
    }

}
