package com.player.model;

public class Menu {

  public void mainMenu() {
    System.out.println("**************************");
    System.out.println("        **主菜单**");
    System.out.println("        1--播放列表管理");
    System.out.println("        2--播放器管理");
    System.out.println("        0--退出");
    System.out.println("**************************");
  }

  public Boolean closeMenu(int i) {
    switch (i) {
      case 1:
        System.out.println(1);
        break;
      case 2:
        System.out.println(2);
        break;
    }
    return false;
  }
}
