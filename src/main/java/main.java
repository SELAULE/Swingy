import Controller.FileUpload;
import Model.Heros.Hero;
import View.drawMap;
import View.printing;

import java.util.Scanner;

public class main {
    public static void main(String args[]) {

        printing printing = new printing();
        FileUpload reader = new FileUpload();
        Scanner input = new Scanner(System.in);

//        KeyHandle handler = new KeyHandle();
        drawMap drawing = new drawMap();
        printing.welcome();
        System.out.println("1) Create a Hero");
        System.out.println("2) Select a Hero");

        int number = input.nextInt();
        try {
            if (number == 1) {
                System.out.println("Making a new hero");
                Hero hero = drawing.newHero();
                hero.keyPressed();
            }
            if (number == 2) {
                System.out.println("Selecting an existing hero");
                String[] contents = reader.OpenFile("./heroes.txt");
                drawing.selectHero(contents);
                int index = input.nextInt();
                drawing.selectedHero(index, contents);
//                Hero hero = drawing.newHero();
//                hero.keyPressed();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
//        input.close();
    }
}
