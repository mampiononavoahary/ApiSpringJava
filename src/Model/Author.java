package Model;

public class Author{
    private String authorId;
    private String authorName;
    private String sex;

    public Author(String authorId, String authorName, String sex) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId='" + authorId + '\'' +
                ", authorName='" + authorName + '\'' +
                ", sex=" + sex +
                '}';
    }
}
