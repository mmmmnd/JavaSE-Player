package com.player.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class List {
  private int inputIndex;
  private int indexArr;
  private String[] arr;

  /**
   * 列表管理逻辑
   *
   * @param i 输入的索引
   */
  public void listManage(Scanner scanner, int i) {
    switch (i) {
      case 1:
        System.out.println("将歌曲添加到主播放列表");
        System.out.println("请输入要添加的歌曲的数量");
        inputIndex = scanner.nextInt();
        arr = new String[inputIndex];
        for (int j = 0; j < inputIndex; j++) {
          try {
            System.out.println("请输入第" + (j + 1) + "首歌曲");
            System.out.println("请输入歌曲的id");
            String id = scanner.next();
            System.out.println("请输入歌曲的名称");
            String name = scanner.next();
            System.out.println("请输入演唱者");
            String sing = scanner.next();
            arr[j] = String.valueOf(new Music(id, name, sing));
          } catch (InputMismatchException e) {
            System.out.println("输入的格式有误请重新输入！");
            scanner.next();
            continue;
          }
          for (String a : arr) {
            System.out.println(a);
          }
        }
        break;
      case 2:
        break;

    }
  }
}
