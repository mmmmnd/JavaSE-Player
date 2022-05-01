package com.player.model;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class PlayListCollection {
  HashMap<String, PlayerList> playerListHashMap;

  public PlayListCollection() {
    this.playerListHashMap = new HashMap<>();
  }

  public HashMap<String, PlayerList> getPlayerListHashMap() {
    return playerListHashMap;
  }

  public void setPlayerListHashMap(HashMap<String, PlayerList> playerListHashMap) {
    this.playerListHashMap = playerListHashMap;
  }

  /**
   * 添加播放器列表
   *
   * @param playerList 播放列表
   */
  public void addPlayList(PlayerList playerList) {
    playerListHashMap.put(playerList.getPlayerListName(), playerList);
  }

  /**
   * 删除播放列表
   *
   * @param playerList 播放列表
   */
  public void deletePlayList(PlayerList playerList) {
    playerListHashMap.remove(playerList.getPlayerListName());
    System.out.println("删除成功！");
  }

  /**
   * 通过name查找播放列表名
   *
   * @param name 播放列表名
   * @return 播放列表
   */
  public PlayerList getPlayListName(String name) {
    PlayerList playerList = null;
    Set<String> playerSet = getPlayerListHashMap().keySet();

    for (String ps : playerSet) {
      if (ps.equals(name)) {
        playerList = playerListHashMap.get(name);
        break;
      }
    }
    return playerList;
  }

  /**
   * 显示所有播放列表名称
   */
  public void showAllPlayList() {
    Set<String> playerSet = getPlayerListHashMap().keySet();

    System.out.println("播放列表名称为：");
    for (String ps : playerSet) System.out.println(ps);

  }

}
