package com.player.test;

import com.player.model.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTest {
  public static void main(String[] args) {
    Menu menu = new Menu();
    Scanner scanner = new Scanner(System.in);
    int inputIndex = 0;

    while (true) {
      menu.mainMenu();
      try {
        inputIndex = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("输入的格式有误请重新输入！");
        scanner.next();
      }

      if(inputIndex == 0){
        return;
      }

    }
  }
}
