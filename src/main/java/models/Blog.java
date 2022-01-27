package models;

public class Blog {
    private String blogName;
    private String blogAuthor;

    public String getBlogTopic() {
        return blogTopic;
    }

    public void setBlogTopic(String blogTopic) {
        this.blogTopic = blogTopic;
    }

    private String blogTopic;

    public Blog(String blogName, String blogAuthor) {
        this.blogName = blogName;
        this.blogAuthor = blogAuthor;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }
}
