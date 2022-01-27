package userinterface;


import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


@DefaultUrl("http://blankfactor.com")
public class BlogsBlankFactor extends PageObject {

    public static final Target LATEST_POSTS_TITLE = Target.the("latest posts title").locatedBy("//h1[contains(text(),'Latest posts')]");
    public static final Target LOAD_MORE_BUTTON = Target.the("load more blogs").locatedBy("//div[@class='load-more-btn-wrap']/button[1]");
    public static final Target LOAD_MORE_LOADER_BUTTON = Target.the("loader on button load more").locatedBy("//div[@class='load-more-btn-wrap']/button[1]//span[2]");
    public static final Target BLOG_TITLE_WITH_AUTHOR= Target.the("blog title with author item").locatedBy("//span[contains(text(),'By')]//following::a[text()=' {0} ']//preceding::div[@class='post-template__info']/h2/a[contains(text(),'{1}')]");
    public static final Target BLOG_TITLE_PAGE= Target.the("blog main title").locatedBy("//div/h1[contains(@class,'post-title')]");
    public static final Target SUBSCRIBE_EMAIL_INPUT= Target.the("subscribe email").locatedBy("//input[@name='email']");
    public static final Target SUBSCRIBE_BUTTON= Target.the("subscribe Button").locatedBy("//button[@id='form-newsletter-submit-btn']");
    public static final Target SUBSCRIBE_LOADER_BUTTON = Target.the("LOADER ON BUTTON").locatedBy("//button[@id='form-newsletter-submit-btn']//span");
    public static final Target SUBSCRIBE_RESULT_MESSAGE = Target.the("subscribe result").locatedBy("//form[contains(@class,'form-newsletter')]//div[2]");
    public static final Target BLOG_CATEGORY = Target.the("blog category based in blog searched").locatedBy("//div/h1[contains(@class,'post-title')]//preceding::div[@class='categories-list']");
    public static final Target BLOG_LIST_TOPICS = Target.the("blog category based in blog searched").locatedBy("//div[contains(@class,'widget-categories')]//a[contains(text(),'{0}')]");
    public static final Target BLOG_TITLE_WITH_TOPIC = Target.the("blog category based in blog searched").locatedBy("//div[@class='post-template__info']//div[@class='categories-list']//a[contains(text(),'{0}')]");
    public static final Target BLOG_TITLE_WITH_TOPIC2 = Target.the("blog category based in blog searched").locatedBy("//div[@class='post-template-wide__info']//div[@class='categories-list']//a[contains(text(),'Fintech')]//following::h2/a");



}
