import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
//       int[] array = new int[10];
//      for( int i = 0; i < array.length; i++){
//          array[i] = i;
//          int a = array[i];
//      }
//        for (int element: array) {  // duyet qua tat ca cac ptu cua mang
//            System.out.println(element);
//        }
        // khai bao tinh
//        int[] array = new int[10];
//        int[] list = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // khai bao dong
//        List<String> list = new ArrayList<>();
//        list.add('a');
//        list.add('b');
//        list.add('c');
//        list.add('d');
//        String string = list.get(0);
//        for (int i = 0; i <list.size(); i++){
//
//        }
//        for (String string: list) {
//
//        }
//        // doc cac ky tu tu ban phim;
//        Scanner scanner = new Scanner(System.in);
////      int a = scanner.nextInt();
// //     double b = scanner.nextDouble();
//        String a = scanner.next(); // doc bat ky 1 ky tu nao tu ban phim
//        System.out.println(a);
        //String[][] array = new String[4][4];
        String[][] Game = {
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
        };
        for (int i = 0; i < Game.length; i++) {
            for (int j = 0; j < Game[i].length; j++) {
                System.out.print(Game[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[] player = {1, 3};
        for (int i = 0; i < Game.length; i++) {
            for (int j = 0; j < Game[i].length; j++) {
                if ((i == player[0]) && (j == player[1])) {
                    System.out.print("P ");
                } else {
                    System.out.print(Game[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
        int[] enemy1 = new int [2];
        int[] enemy2 = new int [2];
        Random random = new Random();
        int enemy1_x = random.nextInt(4);
        int enemy1_y = random.nextInt(4);
        int enemy2_x = random.nextInt(4);
        int enemy2_y = random.nextInt(4);
        int gift_x = random.nextInt(4);
        int gift_y = random.nextInt(4);
        while ((enemy1_x == player[0]) && (enemy1_y == player[1]) || (enemy2_x == player[0]) && (enemy2_y == player[1]) || (enemy1_x == enemy2_x) && (enemy1_y == enemy2_y) || (enemy2_x == enemy1_x) && (enemy2_y == enemy1_y)){
            enemy1_x = random.nextInt(4);
            enemy1_y = random.nextInt(4);
            enemy2_x = random.nextInt(4);
            enemy2_y = random.nextInt(4);
        }
        while ((gift_x == player[0]) && (gift_y == player[1]) || (enemy1_x == gift_x) && (enemy1_y == gift_y) || (enemy2_x == gift_x) && (enemy2_y == gift_y)){
            gift_x = random.nextInt(4);
            gift_y = random.nextInt(4);
        }
        enemy1[0]= enemy1_x;
        enemy1[1] = enemy1_y;
        enemy2[0] = enemy2_x;
        enemy2[1]= enemy2_y;
        Game[gift_x][gift_y] = "G";
        while (true) {
            for (int i = 0; i < Game.length; i++) {
                for (int j = 0; j < Game[i].length; j++) {
                    if ((i == player[0]) && (j == player[1])) {
                        System.out.print("P ");
                    } else if ((i == enemy1[0]) && (j == enemy1[1])) {
                        System.out.print("X ");
                    } else if ((i == enemy2[0]) && (j == enemy2[1])) {
                        System.out.print("X ");
                    } else {
                        System.out.print(Game[i][j] + " ");
                    }
                }
                System.out.println();
            }

            Scanner scaner = new Scanner(System.in);
            String move = scaner.next();
            switch (move) {
                case "a":
                    player[1] -= 1;
                    break;
                case "d":
                    player[1] += 1;
                    break;
                case "w":
                    player[0] -= 1;
                    break;
                case "s":
                    player[0] += 1;
                    break;
                default:
                    System.out.println("can not move");
                    break;
            }
            if (player[0] > 3) {
                player[0] = 0;
            } else if (player[0] < 0) {
                player[0] = 3;
            } else if (player[1] > 3) {
                player[1] = 0;
            } else if (player[1] < 0) {
                player[1] = 3;
            }
            enemy1[0] +=1;
            enemy2[1] +=1;

            if (enemy1[0] > 3) {
                enemy1[0] = 0;
            }
            else if (enemy1[0] < 0){
                enemy1[0] = 3;
            }
            else if (enemy1[1] > 3) {
                enemy1[1] = 0;
            }
            else if (enemy1[1] < 0){
                enemy1[1] = 3;
            }

            if (enemy2[0] > 3) {
                enemy2[1] = 0;
            }
            else if (enemy2[0] < 0){
                enemy2[1] = 3;
            }
            else if (enemy2[1] > 3) {
                enemy2[1] = 0;
            }
            else if (enemy2[1] < 0){
                enemy2[1] = 3;
            }
            if (((player[0] == enemy1[0]) && (player[1] == enemy1[1])) || ((player[0] == enemy2[0]) && (player[1] == enemy2[1]))) {
                System.out.println("Game over!");
                break;
            }
            else if ((player[0] == gift_x) && (player[1] == gift_y)){
                System.out.println("You win!");
                break;
            }
            }
        }
    }

