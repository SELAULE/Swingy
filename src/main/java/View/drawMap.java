package View;

import Controller.FileUpload;
import Controller.KeyHandle;
import Model.Heros.Hero;
import Model.Heros.Villains;
//import Model.Heros.Villains;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class drawMap {

   public int mapSize(int level) {
       return ((level - 1) * 5 + 10 - (level % 2));
   }

   public void drawingTheMap(Hero theHero) {
       drawMap d = new drawMap();
       for (int i = 0; i < d.mapSize(theHero.getLevel()); i++) {
           System.out.print('.');
           for (int j = 0; j < d.mapSize(theHero.getLevel()); j++) {
               if (theHero.getxCoordinates() == 0) {
                   System.out.println("We on the top edge");
               }
               else if (theHero.getxCoordinates() == d.mapSize(theHero.getLevel()) - 1) {
                   System.out.println("We on the left edge");
               }
               if (i == theHero.getxCoordinates() && j == theHero.getyCoordinates())
               {
                   if (theHero.getxCoordinates() == 0) {
                       System.out.println("We on the top edge");
                   }
                   else if (theHero.getxCoordinates() == d.mapSize(theHero.getLevel()) - 1) {
                       System.out.println("We on the left edge");
                   }
                   System.out.print('H');
               }
               else if (i == theHero.randomVillan(this.mapSize(theHero.getLevel())) && j == theHero.randomVillan(this.mapSize(theHero.getLevel())))
               {
                   System.out.print('V');
               }
               else
                   System.out.print('.');
           }
           System.out.print('\n');
       }
   }

   public void initGame() {

   }

//   public void  gameInit(int level, int x, int y) {
//       drawingTheMap(level);
//       placingHero(x, y);
//   }
//


    public void selectHero(String[] content) {
        try {
//            FileUpload reader = new FileUpload();
            String[] matches = content;
            for (int i = 0; i < matches.length; i++) {
                String[] matche = matches[i].split(",");
                for (int j = 0; j < i; j++) {
                    System.out.println(i + ")" + matche[j]);
                }
            }
            System.out.print('\n');
            System.out.println("Select a Hero");
        } catch (Exception e) {
         System.out.println(e.toString());
        }
    }

    public Hero newHero() {
        Hero theHero = new Hero();
        Scanner input = new Scanner(System.in);
        printing printing = new printing();
        drawMap drawing = new drawMap();

        System.out.println("Name of the hero");
        theHero.setHeroName(input.next());

        System.out.println("Name of the heroClass");
        theHero.setHeroClass(input.next());

        theHero.setLevel(0);

        theHero.setExperience(0);

        System.out.println("Name of the Attack");
        theHero.setAttack(input.next());

        System.out.println("Name of Defense");
        theHero.setDefense(input.next());

        theHero.setxCoordinates(this.mapSize(theHero.getLevel())/2);
        theHero.setyCoordinates(this.mapSize(theHero.getLevel())/2);
        printing.Info(theHero);
        drawing.drawingTheMap(theHero);
//        input.close();
        return(theHero);
    }



//    public static void main(String args[]) {
//
//        printing printing = new printing();
//        FileUpload reader = new FileUpload();
//        Scanner input = new Scanner(System.in);
//        drawMap drawing = new drawMap();
//        Hero theHero = new Hero();
//        printing.welcome();
//        System.out.println("1) Create a Hero");
//        System.out.println("2) Select a Hero");
//        theHero.levelUp(3);
//
//        int number = input.nextInt();
//        try {
//            if (number == 1) {
//                System.out.println("Making a new hero");
//                Hero hero = drawing.newHero();
//                hero.keyPressed();
//            }
//            if (number == 2) {
//                System.out.println("Selecting an existing hero");
//                String[] contents = reader.OpenFile("./heroes.txt");
//                drawing.selectHero(contents);
//                int index = input.nextInt();
//                theHero.selectedHero(index, contents);
////                Hero hero = drawing.newHero();
////                hero.keyPressed();
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
////        input.close();
//    }
}


