package com.player.model;

public class Music {
  private String id;
  private String name;
  private String sing;

  public Music() {
  }

  public Music(String id, String name, String sing) {
    this.id = id;
    this.name = name;
    this.sing = sing;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSing() {
    return sing;
  }

  public void setSing(String sing) {
    this.sing = sing;
  }

  @Override
  public String toString() {
    return "歌曲信息：id为" + id + "," +
        "歌曲名称为：" + name + "," +
        "演唱者为：" + sing + ","
        ;
  }
}
