package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
  static List<Article> articles = new ArrayList<>();

  public static void main(String[] args) {
    System.out.println("== 프로그램 시작 ==");
    Scanner sc = new Scanner(System.in);

    int Articlenumberid = 0;

    while (true) {
      System.out.print("명령어 ) ");
      String cmd = sc.nextLine().trim();

      if (cmd.equals("exit")) { //시스템 종료
        break;
      } else if (cmd.length() == 0) {  //사용자가 입력한 값이 없으면 출력
        System.out.println("명령어를 입력해주세요");
        continue;
      } else if (cmd.equals("article write")) {  //게시글 작성 시작
        System.out.println("== 게시글 작성 ==");
        int id = Articlenumberid + 1;
        System.out.print("제목 : ");
        String title = sc.nextLine().trim();  //제목값 title
        System.out.print("내용 : ");
        String body = sc.nextLine().trim();//내용값 body
        String regDate = Util.getNowStr();
        String updateDate = Util.getNowStr();

        Article article = new Article(id, regDate, updateDate, title, body);
        articles.add(article); //articles 리스트 안에 추가.
        System.out.println(id + "번 게시글이 작성되었습니다.");
        Articlenumberid++;

      } else if (cmd.startsWith("article list ")) {
        String Id = String.format(cmd.split(" ")[2]);

        Article found = foundtitleArticle(Id);
        if (found != null) {
          System.out.println(Id + "가 제목에 들어간 게시글 목록");
          for (int i = 0; i < articles.size(); i++){
            System.out.printf(" %d / %s / %s / %s \n", found.getId(), found.getRegDate(), found.getTitle(), found.getBody());
          }
        }
        if (articles.size() == 0) {
          System.out.println("게시글이 없습니다.");
          continue;
        } else {
          System.out.println("번호 / 날짜 / 제목 / 내용 ");
          for (int i = articles.size() - 1; i >= 0; i--) {
            Article article = articles.get(i);  //article 변수에 articles가 가지고있는 각각의 객체를 i값에 따라 초기화
            if (Util.getNowStr().split(" ")[0].equals(article.getRegDate().split(" ")[0])) {
              System.out.printf(" %d / %s / %s / %s \n", article.getId(), article.getRegDate().split(" ")[1], article.getTitle(), article.getBody());
            } else {
              System.out.printf(" %d / %s / %s / %s \n", article.getId(), article.getRegDate().split(" ")[0], article.getTitle(), article.getBody());
            }
          }
        }
      } else if (cmd.startsWith("article delete ")) {
        int Id = Integer.parseInt(cmd.split(" ")[2]);

        Article found = getArticebyId(Id);

        if (found == null) {
          System.out.println(Id + "번 게시글은 없습니다.");
          continue;
        }
        articles.remove(found);
        System.out.println(Id + "번 게시글 삭제 완료.");
      } else if (cmd.startsWith("article modify ")) {
        int Id = Integer.parseInt(cmd.split(" ")[2]);

        Article found = getArticebyId(Id);

        if (found == null) {
          System.out.println(Id + "번 게시글은 없습니다.");
          continue;
        }
        System.out.println("==게시글 수정==");
        System.out.println("기존 제목" + found.getTitle());
        System.out.println("기존 내용" + found.getBody());
        System.out.print("제목 수정 : ");
        String retitle = sc.nextLine().trim();
        System.out.print("내용 수정 : ");
        String rebody = sc.nextLine().trim();
        String updateDate = Util.getNowStr();

        found.setTitle(retitle);
        found.setBody(rebody);
        found.setUpdateDate(updateDate);
        System.out.println(Id + "번 게시글 수정 완료.");
      } else if (cmd.startsWith("article detail ")){
        int Id = Integer.parseInt(cmd.split(" ")[2]);

        Article found = getArticebyId(Id);

        if (found == null) {
          System.out.println(Id + "번 게시글은 없습니다.");
          continue;
        }
        System.out.println("==게시글 상세보기==");
        System.out.println("번호 : " + found.getId());
        System.out.println("제목 : " + found.getTitle());
        System.out.println("내용 : " + found.getBody());
        System.out.println("작성날짜 : " + found.getRegDate());
        System.out.println("수정날짜 : " + found.getUpdateDate());

      }

    }

  }

  private static Article getArticebyId(int Id) {
    for (Article article : articles) {
      if (article.getId() == Id) {
        return article;
      }
    }
    return null;
  }

  private static Article foundtitleArticle(String title) {
    for (Article article : articles) {
      if (article.getTitle() == title) {
        return article;
      }
    }
    return null;
  }
}

class Article {
  private int id;
  private String title;
  private String body;
  private String regDate;
  private String updateDate;

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