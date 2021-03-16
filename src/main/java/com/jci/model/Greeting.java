package com.jci.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Greeting {

  @Getter
  private final long id;

  @Getter
  @Setter
  private final String content;

  @Getter
  @Setter
  private List<String> list = new ArrayList<>();

  public Greeting(long id, String content) {
    this.id = id;
    this.content = content;
  }

}
