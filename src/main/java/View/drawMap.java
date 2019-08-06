package View;

import Controller.FileUpload;
import Controller.KeyHandle;
import Model.Heros.Hero;
import Model.Heros.Villains;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class drawMap {

   public int mapSize(int level) {
       return ((level - 1) * 5 + 10 - (level % 2));
   }

   public void drawingTheMap(Hero theHero) {
       drawMap d = new drawMap();
       for (int i = 0; i < d.mapSize(theHero.getLevel()); i++) {
           System.out.print('.');
           for (int j = 0; j < d.mapSize(theHero.getLevel()); j++) {

               if (i == theHero.getxCoordinates() && j == theHero.getyCoordinates())
               {
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
////       placingHero(x, y);
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

        drawMap drawing = new drawMap();

        System.out.println("Name of the hero");
        theHero.setHeroName(input.next());

        System.out.println("Name of the heroClass");
        theHero.setHeroClass(input.next());

        theHero.setLevel(1);

        theHero.setExperience(0);

        System.out.println("Name of the Attack");
        theHero.setAttack(input.next());

        System.out.println("Name of Defense");
        theHero.setDefense(input.next());

        theHero.setxCoordinates(this.mapSize(theHero.getLevel())/2);
        theHero.setyCoordinates(this.mapSize(theHero.getLevel())/2);

        System.out.println("-------------------------------");
        System.out.println("Hero name is : " + theHero.getHeroName());
        System.out.println("Hero class is : " + theHero.getHeroClass());
        System.out.println("The Level is : " + theHero.getLevel());
        System.out.println("The Experience is : " + theHero.getExperience());
        System.out.println("Hero Attack is : " + theHero.getAttack());
        System.out.println("Hero Defense is : " + theHero.getDefense());

        drawing.drawingTheMap(theHero);
//        input.close();
        return(theHero);
    }

    public void selectedHero(int index, String[] content) {
        Hero theHero = new Hero();
        System.out.println(content[index]);
        content = content[index].split(",");

        theHero.setHeroName(content[0]);
        theHero.setHeroClass(content[1]);
        theHero.setLevel(Integer.parseInt(content[2]));
        theHero.setExperience(Integer.parseInt(content[3]));
        theHero.setAttack(content[4]);
        theHero.setDefense(content[5]);
        theHero.setxCoordinates(this.mapSize(theHero.getLevel())/2);
        theHero.setyCoordinates(this.mapSize(theHero.getLevel())/2);

        drawingTheMap(theHero);
        theHero.keyPressed();
    }

//    public static void main(String args[]) {
//
//        printing printing = new printing();
//        FileUpload reader = new FileUpload();
//        Scanner input = new Scanner(System.in);
//
////        KeyHandle handler = new KeyHandle();
//        drawMap drawing = new drawMap();
//        printing.welcome();
//        System.out.println("1) Create a Hero");
//        System.out.println("2) Select a Hero");
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
//                drawing.selectedHero(index, contents);
////                Hero hero = drawing.newHero();
////                hero.keyPressed();
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
////        input.close();
//    }
}


