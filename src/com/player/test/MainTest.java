package com.player.test;

import com.player.model.List;
import com.player.model.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTest {
  public static void main(String[] args) {
    Menu menu = new Menu();
    List list = new List();

    Scanner scanner = new Scanner(System.in);
    int inputIndex = 0; //输入索引
    boolean flag = true, flagList = true, flagPlayer = true;// flag 主菜单 flagList 列表菜单 flag Player 播放器菜单

    while (flag) {
      menu.mainMenu();
      try {
        System.out.println("请输入对应数字进行操作");
        inputIndex = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("输入的格式有误请重新输入！");
        scanner.next();
        continue;
      }

      switch (inputIndex) {
        case 0:
          flag = false;
        case 1:
          while (flagList) {
            menu.listMenu();
            System.out.println("请输入对应的数字对播放列表进行管理:");

            try {
              inputIndex = scanner.nextInt();
            } catch (InputMismatchException e) {
              System.out.println("输入的格式有误请重新输入！");
              scanner.next();
              continue;
            }

            if (inputIndex == 9) flagList = false;

            list.listManage(scanner, inputIndex); //播放列表

          }
          break;
        case 2:
          menu.player();
          break;
        default:
          System.out.println("输入有误请重新输入！");
      }
    }
  }
}
