package com.player.model;

import java.util.ArrayList;

public class PlayerList {
  private final String playerListName;//播放列表名称
  ArrayList<Song> musicList;//播放列表

  public PlayerList(String playerListName) {
    this.playerListName = playerListName;
    this.musicList = new ArrayList<>();
  }

  /**
   * 添加歌曲到播放列表
   *
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

  /**
   * 通过id查找歌曲信息
   *
   * @param id 歌曲id
   * @return 歌曲信息
   */
  public Song getPlayerId(String id) {
    Song song = null;
    for (Song s : musicList) {
      if (s.getId().equals(id)) {
        song = s;
        break;
      }
    }
    return song;
  }

  /**
   * 通过name查找歌曲信息
   *
   * @param name 歌曲id
   * @return 歌曲信息
   */
  public Song getPlayerName(String name) {
    Song song = null;
    for (Song s : musicList) {
      if (s.getName().equals(name)) {
        song = s;
        break;
      }
    }
    return song;
  }

  /**
   * 通过id删除歌曲信息
   *
   * @param id 歌曲id
   */
  public void deletePlayerList(String id) {
    Song s = getPlayerId(id);

    if (s == null) {
      System.out.println("没有找到id为" + id + "的歌曲");
    } else {
      musicList.remove(s);
      System.out.println("已通过id查找到歌曲进行删除");
    }
  }

  /**
   * 通过id修改歌曲信息
   *
   * @param id   歌曲id
   * @param song 歌曲信息
   */
  public void updatePlayerList(String id, Song song) {
    Song s = getPlayerId(id);

    if (s == null) {
      System.out.println("没有找到id为" + id + "的歌曲");
    } else {
      musicList.remove(s);
      musicList.add(song);
      System.out.println("已通过id查找到歌曲进行更新");
    }
  }

  public String getPlayerListName() {
    return playerListName;
  }

  public ArrayList<Song> getMusicList() {
    return musicList;
  }

  public void setMusicList(ArrayList<Song> musicList) {
    this.musicList = musicList;
  }
}
