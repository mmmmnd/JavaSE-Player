package com.player.test;


import com.player.model.PlayerList;
import com.player.model.Song;

public class MainTest {

  public static void main(String[] args) {
    MainTest mainTest = new MainTest();
    mainTest.playerTest();
  }

  public void songTest() {
    Song song1 = new Song("s001", "a", "aa");
    Song song2 = new Song("s002", "b", "bb");
    Song song3 = new Song("s003", "c", "cc");
    Song song4 = new Song("s003", "c", "cc");
  }

  public void playerTest() {
    Song song1 = new Song("s001", "a", "aa");
    Song song2 = new Song("s002", "b", "bb");
    Song song3 = new Song("s003", "c", "cc");
    Song song4 = new Song("s003", "c", "cc");

    PlayerList playerList = new PlayerList("主播放列表");

    playerList.addToPlayerList(song1);
    playerList.addToPlayerList(song2);
    playerList.addToPlayerList(song3);
    playerList.addToPlayerList(song4);
    playerList.showAllPlayerList();
  }
}
