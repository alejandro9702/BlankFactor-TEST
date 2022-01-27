package tasks;


import exceptions.Exception;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.time.Duration;

import static exceptions.Exception.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.BlogsBlankFactor.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class SearchTheBlog implements Task {
    private String blogName;
    private String blogAuthor;

    public SearchTheBlog(String blogName, String blogAuthor) {
        this.blogName = blogName;
        this.blogAuthor = blogAuthor;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.should(seeThat(the(LATEST_POSTS_TITLE.waitingForNoMoreThan(Duration.ofSeconds(20))), isVisible())
                .orComplainWith(Exception.class, PAGE_ERROR_MESSAGE));
        loadBlogsUntilFindIt(actor);
        actor.should(seeThat(the(BLOG_TITLE_WITH_AUTHOR.of(blogAuthor, blogName).waitingForNoMoreThan(Duration.ofSeconds(20))), isVisible())
                .orComplainWith(Exception.class, BLOG_NOT_FOUND));
        actor.attemptsTo(Scroll.to(BLOG_TITLE_WITH_AUTHOR.of(blogAuthor, blogName)).andAlignToBottom().then(Click.on(BLOG_TITLE_WITH_AUTHOR.of(blogAuthor, blogName))));
    }


    private void loadBlogsUntilFindIt(Actor actor) {
        while (!BLOG_TITLE_WITH_AUTHOR.of(blogAuthor, blogName).resolveFor(actor).isPresent() && LOAD_MORE_BUTTON.resolveFor(actor).isVisible()) {
            actor.attemptsTo(Scroll.to(LOAD_MORE_BUTTON).andAlignToBottom().then(Click.on(LOAD_MORE_BUTTON)));
            LOAD_MORE_LOADER_BUTTON.resolveFor(actor).waitUntilNotVisible();
        }

    }

    public static SearchTheBlog withNameAndAuthor(String blogName, String blogAuthor) {
        return instrumented(SearchTheBlog.class, blogName, blogAuthor);
    }

}

