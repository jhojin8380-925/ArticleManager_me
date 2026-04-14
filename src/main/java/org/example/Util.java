package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

  public static String getNowStr() {  //static 을 쓰는이유는 객체 생성없이 바로 메서드 호출하기 위해서
    LocalDateTime now = LocalDateTime.now();
    String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    return formatedNow;
  }
}
