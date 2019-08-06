package Controller;


import Model.Heros.Hero;
import View.drawMap;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class KeyHandle extends Hero {
   private Scanner input = new Scanner(System.in);
    public void keyPressed()
    {


        System.out.println("This is Y " + getyCoordinates() + '\n' + "This is X " + getxCoordinates());
        System.out.println("Press something ");
        String command = input.next();
        System.out.println(command);

//        boolean loop = true;
//        while (loop) {
//            System.out.println("Press something ");
////            String command ;
//            String command = input.next();
//            System.out.println(command);
//
//            switch (command) {
//                case "exit":
//                    System.out.println("Pussy niggar left the game!!");
//                    loop = false;
//                    System.exit(1);
//
//                case "8":
//                case "w":
//                case "north":
//                    System.out.println("This is Y " + getyCoordinates() + '\n' + "This is X " + getxCoordinates());
//                    break;
//
//                case "4":
//                case "a":
//                case "east":
//                    System.out.println("Going Left");
//                    break;
//
//                case "6":
//                case "d":
//                case "west":
//                    System.out.println("Going Right");
//                    break;
//
//                case "2":
//                case "s":
//                case "south":
//                    System.out.println("Going Down");
//                    break;
//            }
//        }
//        input.close();
    }
}
