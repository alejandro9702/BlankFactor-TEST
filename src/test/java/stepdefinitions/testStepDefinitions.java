package stepdefinitions;


import exceptions.Exception;
import interactions.GoToInsights;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Blog;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import questions.Validation;
import tasks.SubscribeToNewsLetter;
import tasks.SearchTheBlog;
import userinterface.BlankFactorPage;
import userinterface.BlogsBlankFactor;
import utils.RandomData;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsOnlyText;
import static userinterface.BlogsBlankFactor.*;


public class testStepDefinitions {


    private BlankFactorPage pagina;
    @Managed(uniqueSession = true)
    private WebDriver driver;
    private Blog blog;
    private final String SUBSCRIBE_MESSAGE = "Thank you for subscribing! Stay tuned.";


    @Before
    public void configuracionInicial() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.aNewActor().can(
                BrowseTheWeb.with(driver)
        );
        driver.manage().window().maximize();
    }


    @Given("^the user (.*) go to blankFactor page and go to blogs section$")
    public void theUserGoToBlankFactorPageAndGoToBlogsSection(String userName) {
        theActorCalled(userName).attemptsTo(
                Open.browserOn(pagina),
                GoToInsights.intoBlogSection()
        );
    }

    @When("^try to search the blog (.*) By (.*)$")
    public void tryToSearchTheBlogBlogNameByAuthor(String blogTitle, String blogAuthor) {
        blog = new Blog(blogTitle, blogAuthor);
        theActorInTheSpotlight().attemptsTo(SearchTheBlog.withNameAndAuthor(blog.getBlogName(), blog.getBlogAuthor())
        );
    }


    @Then("should be in the correct URL and have main title equal to the blog name$")
    public void shouldBeInTheCorrectURLAndHaveMainTitleEqualToTheBlogName() {
        theActorInTheSpotlight().should(seeThat(Validation.blogResume(blog.getBlogName()))
                .orComplainWith(Exception.class, Exception.ERROR_BLOG_PAGE));
        blog.setBlogTopic(BLOG_CATEGORY.resolveFor(theActorInTheSpotlight()).getText());
    }

    @And("Subscribe to the newsletter using the subscribe form with the email$")
    public void subscribeToTheNewsletterUsingTheSubscribeFormWithTheEmail() {
        RandomData randoEmail = new RandomData();
        theActorInTheSpotlight().attemptsTo(
                SubscribeToNewsLetter.withTheEmail(randoEmail.generateRandomEmail()));
        theActorInTheSpotlight().should(seeThat(the(BlogsBlankFactor.SUBSCRIBE_RESULT_MESSAGE),
                containsOnlyText(SUBSCRIBE_MESSAGE)));


    }

    @Then("Go back to the Blog section and print a list of the all posts titles with related links.")
    public void goBackToTheBlogSectionAndPrintAListOfTheAllPostsTitlesWithRelatedLinks() {
        theActorInTheSpotlight().attemptsTo(
                GoToInsights.intoBlogSection(),
                Click.on(BLOG_LIST_TOPICS.of(blog.getBlogTopic()).waitingForNoMoreThan(Duration.ofSeconds(10)))
        );

        List<WebElement> lista = driver.findElements(By.xpath(BLOG_TITLE_WITH_TOPIC2.of(blog.getBlogTopic()).
                waitingForNoMoreThan(Duration.ofSeconds(10)).getCssOrXPathSelector()));

        lista.forEach(item -> {
            System.out.println(item.getText());
        });
    }


}

