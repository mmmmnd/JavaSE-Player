package com.player.model;

import java.util.Objects;

public class Song {
  private String id;
  private String name;
  private String singer;

  public Song() {
  }

  public Song(String id, String name, String singer) {
    this.id = id;
    this.name = name;
    this.singer = singer;
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

  public String getSinger() {
    return singer;
  }

  public void setSinger(String singer) {
    this.singer = singer;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Song)) return false;
    Song song = (Song) o;
    return song.getId().equals(this.getId()) && song.getName().equals(this.getName()) && song.getSinger().equals(this.getSinger());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getSinger());
  }

  @Override
  public String toString() {
    return "歌曲的id：" + id + "歌曲的名称：" + name + "歌曲的演唱者：" + singer;
  }
}
