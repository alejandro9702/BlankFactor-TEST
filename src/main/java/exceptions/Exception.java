package exceptions;

public class Exception extends AssertionError {
    public static final String PAGE_ERROR_MESSAGE = "cant load the page";
    public static final String BLOG_NOT_FOUND = "Blog with this name or Author has not been found";
    public static final String ERROR_BLOG_PAGE = "ERROR LOADING THE BLOG PAGE OR THE TITLE HAS CHANGED";



    public Exception(String message, Throwable cause) {
        super(message, cause);
    }

}
