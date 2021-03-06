import java.lang.System;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
      public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        menu();
        int menu = input.nextInt();
        if (menu == 1){
            // System.out.println("Masukkan jumlah pemain: ");
            // int jumlahPemain = input.nextInt();

            // // jumlah pemain tidak lebih dan kurang dari 2
            // while (jumlahPemain != 2){
            //     System.out.println("Jumlah pemain tidak boleh lebih dan kurang dari 2");
            //     jumlahPemain = input.nextInt();
            // }

            List<Player> playerNameList = new ArrayList<Player>(2);
            for (int i=0; i<2;i++){
                System.out.println();
                System.out.println("Nama pemain ke-" + (i+1) + ": ");
                String namaPemain = input.next();
                playerNameList.add(new Player(i, namaPemain));
            }
          

            // mulai game
            try {
              new Config();
              // Config.testMonster();
              
              System.out.println();
              System.out.println("Memulai shuffle monster untuk player...");
              List<Monster> randomMonsterList = Config.monsterList;
              for (int i=0; i<6;i++){
                  playerNameList.get(0).addMonster(randomMonsterList.get(0));
                  playerNameList.get(1).addMonster(randomMonsterList.get(1));
                  Collections.shuffle(randomMonsterList);
              }

              System.out.println();
              System.out.println("Shuffle monster selesai...");
              for (int j=0; j<2; j++){
                System.out.println();
                System.out.println("Player " + playerNameList.get(j).getPlayerName() + " mendapatkan monster: ");
                for (Monster mon : playerNameList.get(j).getMonsterList()) {
                  System.out.println("Monster " + (j+1)+ ": " + mon.getNama());
                  // System.out.println("Pokemon Element Type: " + mon.getElementTypesList());
                  // System.out.println("Pokemon Move List:");
                  // System.out.println();
                  // for (Move m : mon.getMovesList()) {
                  //   System.out.println("- " + m.getName() + ", " + m.getElementType());
                  // }
                }
            }
            } catch (Exception e) {
              
            } finally {
              selectionMenu(playerNameList);
            }
        }
    }
  
    public static void menu(){
        System.out.println();
        System.out.println("-------- START MENU  --------");
        System.out.println("Petunjuk: mohon tulis angkanya saja");
        System.out.println("(1) Start Game");
        System.out.println("(2) Exit");
        System.out.println("Pilihan: ");
    }
  
    public static void appMenu(){
        System.out.println();
        System.out.println("-------- MAIN MENU  --------");
        System.out.println("Petunjuk: mohon tulis angkanya saja");
        System.out.println("(1) Return to Battle");
        System.out.println("(2) Help");
        System.out.println("(3) View Monster Info");
        System.out.println("(4) View Game Info");
        System.out.println("(5) Exit");
        System.out.printf("Pilihan: ");
        boolean end = false;
        Scanner sc = new Scanner(System.in);
        while (end == false) {        
          int input = sc.nextInt();
          switch(input) {
            case 1:
              end = true;
              // selectionMenu();
            case 2:
              end = true;
              // help();
            case 3:
              end = true;
              // viewMonsterInfo();
            case 4:
              end = true;
              // viewGameInfo();
            case 5:
              end = true;
              System.exit(1);
          }
        }
        sc.close();
    }

    public static void turn(boolean switchTurn, List<Player> somePlayerNameList) {
      if (switchTurn) {
        Collections.reverse(somePlayerNameList);
      }
    }
    
    public static void selectionMenu(List<Player> somePlayerNameList) {
      Player somePlayer = somePlayerNameList.get(0);
      boolean endMenu = false;
      while (endMenu == false) {
        System.out.println();
        System.out.println("-------- "+ somePlayer.getPlayerName() +" BATTLE MENU  --------");
        System.out.println("Petunjuk: mohon tulis angkanya saja");
        System.out.println("(1) Move");
        System.out.println("(2) Switch");
        System.out.println("(3) Back to Menu");
        System.out.printf("Pilihan: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch(input) {
          case 1:
            Battle.moveMonster();
            break;
          case 2:
            Battle.switchMonster();
            break;
          case 3:
            appMenu();
            break;
          default:
            selectionMenu(somePlayerNameList);
        }
        sc.close();
      }
    }
}
