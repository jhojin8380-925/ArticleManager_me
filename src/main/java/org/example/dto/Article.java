package org.example.dto;

public class Article extends Dto{
  private String title;
  private String body;

  public Article(int id, String regDate, String updateDate, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.regDate = regDate;
    this.updateDate = updateDate;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  public String getRegDate() {
    return regDate;
  }

  public String getUpdateDate() {
    return updateDate;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public void setRegDate(String regDate) {
    this.regDate = regDate;
  }

  public void setUpdateDate(String updateDate) {
    this.updateDate = updateDate;
  }

}
