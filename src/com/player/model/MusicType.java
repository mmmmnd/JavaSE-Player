package com.player.model;

public class MusicType {
  private String[] musicArray; //播放器数组
  private int musicArrayIndex; //播放器数组长度

  public int getArrIndex() {
    return musicArrayIndex;
  }

  /**
   * 设置数组长度
   * @param musicArrayIndex 索引
   */
  public void setArrIndex(int musicArrayIndex) {
    this.musicArrayIndex = musicArrayIndex;
    this.musicArray = new String[getArrIndex()];
  }

  public String[] getMusicArray() {
    return musicArray;
  }

  /**
   * 增加播放器
   * @param music 歌单
   * @param i 索引
   */
  public void setMusicArray(Music music,int i) {
    this.musicArray[i] = String.valueOf(music);
  }

}
