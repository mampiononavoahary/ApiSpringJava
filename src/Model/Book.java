package Model;

import java.sql.Date;

public class Book {
  private int id;

  private String bookName;
  private int pageNumbers;
  private String topicEnum;
  private Date releaseDate;
  private String authorId;
  private boolean status;

    public Book(int id, String bookName, int pageNumbers, String topicEnum, String releaseDate, String authorId, boolean status) {
        this.id = id;
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.topicEnum = topicEnum;
        this.releaseDate = Date.valueOf(releaseDate);
        this.authorId = authorId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public String getTopicEnum() {
        return topicEnum;
    }

    public void setTopicEnum(String topicEnum) {
        this.topicEnum = topicEnum;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", pageNumbers=" + pageNumbers +
                ", topicEnum=" + topicEnum +
                ", releaseDate=" + releaseDate +
                ", authorId=" + authorId +
                ", status='" + status + '\'' +
                '}';
    }

}
