package com.player.model;

import java.util.ArrayList;

public class PlayerList {
  ArrayList<Song> musicList;//播放列表
  private String playerListName;//播放列表名称

  public PlayerList(String playerListName) {
    this.playerListName = playerListName;
    this.musicList = new ArrayList<>();
  }

  /**
   * 添加歌曲到播放列表
   * @param song 歌曲
   */
  public void addToPlayerList(Song song) {
    boolean flag = false;//判断歌曲是否存在

    for (Song s : musicList) {
      if (s.equals(song)) {
        flag = true;
        break;
      }
    }

    if (flag) System.out.println("添加失败，该歌曲以存在播放列表中！");
    else musicList.add(song);
  }

  /**
   * 显示所有播放器列表中的歌曲
   */
  public void showAllPlayerList() {
    System.out.println("播放列表中的所有歌曲为：");
    for (Song s : musicList) {
      System.out.println(s);
    }
  }

}
