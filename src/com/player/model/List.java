package com.player.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class List extends MusicType {
  private int inputIndex;

  /**
   * 列表管理逻辑
   *
   * @param index 输入的索引
   */
  public void listManage(Scanner scanner, int index) {
    switch (index) {
      //将歌曲添加到主播放器列表
      case 1:
        System.out.println("将歌曲添加到主播放列表");
        System.out.println("请输入要添加的歌曲的数量");
        inputIndex = scanner.nextInt();
        this.setArrIndex(inputIndex);
        for (int i = 0; i < inputIndex; i++) {
          try {
            System.out.println("请输入第" + (i + 1) + "首歌曲");

            System.out.println("请输入歌曲的id");
            String id = scanner.next();
            System.out.println("请输入歌曲的名称");
            String name = scanner.next();
            System.out.println("请输入演唱者");
            String sing = scanner.next();

            setMusicArray(new Music(id, name, sing), i); //播放器增加歌曲

          } catch (InputMismatchException e) {
            System.out.println("输入的格式有误请重新输入！");
            scanner.next();
          }
        }
        break;
      case 2:

        break;
      //通过歌曲id查询播放列表中的歌曲
      case 3:
        System.out.println("通过歌曲id查询播放列表中的歌曲");
        System.out.println("请输入要查询的播放列表名称");
        inputIndex = scanner.nextInt();
        break;

    }
  }
}
