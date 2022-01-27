package questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import userinterface.BlogsBlankFactor;


public class Validation implements Question<Boolean> {
    public static final String URL_BLOG = "fintech-in-latin-america";

    private String blogTitle;

    public Validation(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String url = BrowseTheWeb.as(actor).getDriver().getCurrentUrl().toString();
        return url.contains(URL_BLOG) && BlogsBlankFactor.BLOG_TITLE_PAGE.resolveFor(actor).containsOnlyText(blogTitle);


    }


    public static Validation blogResume(String blogTitle) {
        return new Validation(blogTitle);
    }

}
