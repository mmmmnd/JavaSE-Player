package com.player.test;


import com.player.model.Menu;
import com.player.model.PlayListCollection;
import com.player.model.PlayerList;
import com.player.model.Song;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class MainTest {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PlayerList playerList = new PlayerList("主播放列表");
    PlayListCollection playListCollection = new PlayListCollection();
    playListCollection.addPlayList(playerList);

    int input1, input2, input3, index; // index 循环的次数
    String inputId = "", inputName = "", inputSing = ""; //输入的id 输入的name 输入的sing
    PlayerList plName = null, plAll = null; //歌曲列表名
    Song SongList = null, songId = null, songName = null; //歌曲id
    Set<String> setPlC; //播放器列表name
    boolean flag = false;//判断歌曲id是否存在


    Menu menu = new Menu();
    while (true) {

      try {
        menu.mainMenu();
        System.out.println("请输入对应数字进行操作");
        input1 = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("输入的格式有误请重新输入！");
        scanner.next();
        continue;
      }

      if (input1 == 0) break;

      switch (input1) {
        case 1:
          while (true) {

            try {
              menu.PlayerListMenu();
              input2 = scanner.nextInt();
            } catch (InputMismatchException e) {
              System.out.println("输入的格式有误请重新输入！");
              scanner.next();
              continue;
            }

            if (input2 == 9) break;

            switch (input2) {
              case 1:
                System.out.println("将歌曲添加到主播放列表");
                System.out.println("请输入要添加的数量");
                index = scanner.nextInt();
                for (int i = 0; i < index; i++) {
                  try {
                    System.out.println("请输入第" + (i + 1) + "首歌曲");

                    System.out.println("请输入歌曲的id");
                    inputId = scanner.next();
                    System.out.println("请输入歌曲的名称");
                    inputName = scanner.next();
                    System.out.println("请输入演唱者");
                    inputSing = scanner.next();

                    SongList = new Song(inputId, inputName, inputSing);
                    playerList.addToPlayerList(SongList);

                  } catch (InputMismatchException e) {
                    System.out.println("输入的格式有误请重新输入！");
                    scanner.next();
                  }
                }
                break;
              case 2:
                System.out.println("将歌曲添加到普通播放列表");
                System.out.println("请输入要添加的播放列表名称");

                inputName = scanner.next();
                plName = playListCollection.getPlayListName(inputName);

                if (plName == null) {
                  System.out.println("播放列表不存在，请返回添加播放列表");
                } else {
                  System.out.println("请输入要添加的数量");
                  index = scanner.nextInt();

                  setPlC = playListCollection.showAllPlayList(); //获取所有播放列表名

                  for (int i = 0; i < index; i++) {
                    try {
                      System.out.println("请输入第" + (i + 1) + "首歌曲");

                      System.out.println("请输入歌曲的id");
                      inputId = scanner.next();

                      for (String ps : setPlC) { //获取列表名
                        plAll = playListCollection.getPlayListName(ps);//通过列表名查找列表
                        songId = plAll.getPlayerId(inputId);//查找列表的歌曲id

                        if (songId != null) {
                          plName.addToPlayerList(songId);
                          flag = true;
                          break;
                        } else {
                          flag = false;
                        }
                      }

                      if (!flag) { //判断歌曲id是否存在
                        System.out.println("请输入歌曲的名称");
                        inputName = scanner.next();

                        System.out.println("请输入演唱者");
                        inputSing = scanner.next();

                        Song song = new Song(inputId, inputName, inputSing);
                        plName.addToPlayerList(song);
                        playerList.addToPlayerList(song);//主播放列表也要添加该歌曲
                      }

                    } catch (InputMismatchException e) {
                      System.out.println("输入的格式有误请重新输入！");
                      scanner.next();
                    }
                  }
                }
                break;
              case 3:
                System.out.println("通过歌曲id查询播放列表中的歌曲");
                System.out.println("请输入要查询的播放列表名称：");

                inputName = scanner.next();
                plName = playListCollection.getPlayListName(inputName);

                if (plName == null) {
                  System.out.println("播放列表不存在！");
                } else {
                  System.out.println("请输入要查询的歌曲id");

                  inputId = scanner.next();
                  songId = plName.getPlayerId(inputId);

                  if (songId == null) {
                    System.out.println("没有找到id为" + inputId + "的歌曲");
                  } else {
                    System.out.println("该歌曲信息为");
                    System.out.println(songId);
                  }

                }
                 break;
              case 4:
                System.out.println("通过歌曲名称查询播放列表中的歌曲");
                inputName = scanner.next();
                songName = playerList.getPlayerName(inputName);

                if (songName == null) {
                  System.out.println("没有找到id为" + inputName + "的歌曲");
                } else {
                  System.out.println("该歌曲信息为");
                  System.out.println(songName);
                }
                break;
              case 5:
                System.out.println("修改播放列表中的歌曲");
                System.out.println("请输入要修改的歌曲名称");

                inputName = scanner.next();

                setPlC = playListCollection.showAllPlayList(); //获取所有播放列表名
                for (String ps : setPlC) {
                  plAll = playListCollection.getPlayListName(ps);//歌曲列表
                  for (int i = 0; i < plAll.getMusicList().size(); i++) {
                    if (plAll.getMusicList().get(i).getName().equals(inputName)) {
                      songName = plAll.getPlayerName(inputName);//获取歌曲信息
                      break;
                    }
                  }
                }

                if (songName != null && plAll != null) {

                  System.out.println("请输入歌曲的名称");
                  inputName = scanner.next();

                  System.out.println("请输入演唱者");
                  inputSing = scanner.next();

                  for (String ps : setPlC) {
                    plAll = playListCollection.getPlayListName(ps);//歌曲列表
                    for (int i = 0; i < plAll.getMusicList().size(); i++) {
                      if (plAll.getMusicList().get(i).getId().equals(songName.getId())) {
                        SongList = new Song(songName.getId(), inputName, inputSing);
                        plAll.updatePlayerList(plAll.getMusicList().get(i).getId(), SongList);
                      }
                    }
                  }
                } else {
                  System.out.println("没有找到该歌曲信息！");
                }
                break;
              case 6:
                System.out.println("删除播放列表中的歌曲");
                System.out.println("请输入要删除的歌曲名称");

                inputName = scanner.next();

                setPlC = playListCollection.showAllPlayList(); //获取所有播放列表名
                for (String ps : setPlC) {
                  plAll = playListCollection.getPlayListName(ps);//歌曲列表
                  for (int i = 0; i < plAll.getMusicList().size(); i++) {
                    if (plAll.getMusicList().get(i).getName().equals(inputName)) {
                      songName = plAll.getPlayerName(inputName);//获取歌曲信息
                      break;
                    }
                  }
                }

                if (songName != null && plAll != null) {
                  for (String ps : setPlC) {
                    plAll = playListCollection.getPlayListName(ps);//歌曲列表
                    for (int i = 0; i < plAll.getMusicList().size(); i++) {
                      if (plAll.getMusicList().get(i).getId().equals(songName.getId())) {
                        plAll.deletePlayerList(songName.getId());
                      }
                    }
                  }
                }
                break;
              case 7:
                System.out.println("显示播放列表中的所有歌曲");
                setPlC = playListCollection.showAllPlayList();
                for (String ps : setPlC) {
                  plAll = playListCollection.getPlayListName(ps);
                  System.out.println(ps + "中的所有歌曲为：");
                  plAll.showAllPlayerList();
                }
                break;
              default:
                System.out.println("请输入对应菜单！");
                break;
            }
          }
          break;
        case 2:
          while (true) {

            try {
              menu.PlayListConllection();
              input3 = scanner.nextInt();
            } catch (InputMismatchException e) {
              System.out.println("输入的格式有误请重新输入！");
              scanner.next();
              continue;
            }

            if (input3 == 9) break;

            switch (input3) {
              case 1:
                System.out.println("向播放器添加播放列表");
                System.out.println("输入要添加的播放列表名称：");
                inputName = scanner.next();
                PlayerList favouritePlayerList = new PlayerList(inputName);
                playListCollection.addPlayList(favouritePlayerList);
                break;
              case 2:
                System.out.println("从播放器删除播放列表");
                System.out.println("请输入要删除的播放列表名称");
                inputName = scanner.next();
                if (inputName.equals("主播放列表")) {
                  System.out.println("主播放列表不能删除！");
                } else {
                  plName = playListCollection.getPlayListName(inputName);

                  if (plName == null) {
                    System.out.println("播放列表不存在，请添加播放列表");
                  } else {
                    playListCollection.deletePlayList(plName);
                  }
                }
                break;
              case 3:
                System.out.println("通过名字查询播放列表信息");
                System.out.println("请输入要查询的播放列表名称");

                inputName = scanner.next();
                plName = playListCollection.getPlayListName(inputName);

                if (plName == null) {
                  System.out.println("播放列表不存在，请添加播放列表");
                } else {
                  System.out.println("该播放列表存在!");
                  System.out.println("该播放列表的名称为：" + inputName);
                  plName.showAllPlayerList();
                }

                break;
              case 4:
                System.out.println("显示所有播放列表名称");
                System.out.println("所有播放列表的名称为：");
                System.out.println("播放列表名称为：");
                setPlC = playListCollection.showAllPlayList();
                for (String ps : setPlC) System.out.println(ps);
                break;
              default:
                System.out.println("请输入对应菜单！");
                break;
            }
          }
          break;
        default:
          System.out.println("请输入对应菜单！");
          break;
      }
    }
  }

}
