package com.player.model;

public class Menu {
  /**
   * 主菜单
   */
  public void mainMenu() {
    System.out.println("**************************");
    System.out.println("        **主菜单**");
    System.out.println("        1--播放列表管理");
    System.out.println("        2--播放器管理");
    System.out.println("        0--退出");
    System.out.println("**************************");
  }

  /**
   * 列表菜单
   */
  public void PlayerListMenu() {
    System.out.println("*********************************************");
    System.out.println("           **播放器列表管理**");
    System.out.println("           1--将歌曲添加到主播放列表");
    System.out.println("           2--将歌曲添加到普通播放列表");
    System.out.println("           3--通过歌曲id查询播放列表中的歌曲");
    System.out.println("           4--通过歌曲名称查询播放列表中的歌曲");
    System.out.println("           5--修改播放列表中的歌曲");
    System.out.println("           6--删除播放列表中的歌曲");
    System.out.println("           7--显示播放列表中的所有歌曲");
    System.out.println("           8--导出歌单");
    System.out.println("           9--返回上一级菜单");
    System.out.println("*********************************************");
  }

  /**
   * 管理菜单
   */
  public void PlayListConllection() {
    System.out.println("*********************************************");
    System.out.println("           **播放器管理**");
    System.out.println("           1--向播放器添加播放列表");
    System.out.println("           2--从播放器删除播放列表");
    System.out.println("           3--通过名字查询播放列表信息");
    System.out.println("           4--显示所有播放列表名称");
    System.out.println("           9--返回上一级菜单");
    System.out.println("*********************************************");
  }
}
