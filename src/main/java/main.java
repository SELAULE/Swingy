import Controller.FileUpload;
import Model.Hero;
import View.drawMap;
import View.printing;

import java.util.Scanner;

import static View.printing.clearScreen;
import static View.printing.gameOver;

public class main {


    public static void main(String args[]) {


        printing printing = new printing();
        FileUpload reader = new FileUpload();
        Scanner input = new Scanner(System.in);

//        KeyHandle handler = new KeyHandle();
        //init Hero
        Hero hero = new Hero();
        drawMap drawing = new drawMap();
        printing.welcome();
        System.out.println("1) Create a Hero");
        System.out.println("2) Select a Hero");

        int number = input.nextInt();
        try {
            if (number == 1) {
                System.out.println("Making a new hero");
                //            hero = drawing.newHero();
                //    hero.keyPressed();
            }
            if (number == 2) {
                System.out.println("Selecting an existing hero");
                String[] contents = reader.OpenFile("./heroes.txt");
                drawing.selectHero(contents);
                int index = input.nextInt();
                hero = new Hero();
                hero.selectedHero(index, contents);
//                Hero hero = drawing.newHero();
//                hero.keyPressed();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        //init villains
        //init Map

        ////clean this messs
        String classHero[] = {"Siyan", "GOD", "Angel", "GrandPriest"};

        System.out.println("Name of the hero");
        hero.setHeroName(input.next());

        System.out.println("Name of the heroClass");
        for (int i = 0; i < classHero.length; i++) {
            System.out.println(i + ") " + classHero[i]);
        }
        hero.setHeroClass(classHero[input.nextInt()]);

        hero.setLevel(1);

        hero.setExperience(0);

        hero.setAttack(1200);

        hero.setDefense(1200);

        hero.setXCoordinates(drawing.mapSize(hero.getLevel()) / 2);
        hero.setYCoordinates(drawing.mapSize(hero.getLevel()) / 2);
        drawing.genVillains(hero);
        clearScreen();
        drawing.drawingTheMap(hero);

        /////////////////

        //init game loop
        boolean loop = true;
        while (loop) {
            System.out.println("Let's get moving ");
            String command = input.next();

            switch (command) {
                case "exit":
                    gameOver();
                    loop = false;
                    System.exit(0);

                case "8":
                case "w":
                case "north":
                    hero.setYCoordinates(hero.getYCoordinates() - 1);
                    clearScreen();
                    drawing.drawingTheMap(hero);
                    for (int w = 0; w < drawing.getVillains().size(); w++) {
                        if (hero.getYCoordinates() == drawing.getVillains().get(w).getCoordinates().get_yPosition() && hero.getXCoordinates() == drawing.getVillains().get(w).getCoordinates().get_xPosition()) {
                            System.out.println("-------------------------------");
                            System.out.print("The Villains attack is : " + drawing.getVillains().get(w).getAttack());
                            System.out.print(" || The Experience is : " + drawing.getVillains().get(w).getExperiance());
                            System.out.println(" || The Villains Defense is : " + drawing.getVillains().get(w).getDefense());
                            System.out.println("1) Fight");
                            System.out.println("2) Run");
                            int choose = input.nextInt();
                            if (choose == 1) {
                                drawing.fight(hero, drawing.getVillains().get(w));
                            } else {
                                System.out.println("Pussy as niggah Running");
                            }
                        }
                    }
                    break;

                case "4":
                case "a":
                case "east":
                    hero.setXCoordinates(hero.getXCoordinates() - 1);
                    clearScreen();
                    drawing.drawingTheMap(hero);
                    for (int w = 0; w < drawing.getVillains().size(); w++) {
                        if (hero.getYCoordinates() == drawing.getVillains().get(w).getCoordinates().get_yPosition() && hero.getXCoordinates() == drawing.getVillains().get(w).getCoordinates().get_xPosition()) {
                            System.out.println("-------------------------------");
                            System.out.print("The Villains attack is : " + drawing.getVillains().get(w).getAttack());
                            System.out.print(" || The Experience is : " + drawing.getVillains().get(w).getExperiance());
                            System.out.println(" || The Villains Defense is : " + drawing.getVillains().get(w).getDefense());
                            System.out.println("1) Fight");
                            System.out.println("2) Run");
                            int choose = input.nextInt();
                            if (choose == 1) {
                                drawing.fight(hero, drawing.getVillains().get(w));
                            } else {
                                System.out.println("Pussy as niggah Running");
                            }
                        }
                    }
                    break;

                case "6":
                case "d":
                case "west":
                    hero.setXCoordinates(hero.getXCoordinates() + 1);
                    clearScreen();
                    drawing.drawingTheMap(hero);
                    for (int w = 0; w < drawing.getVillains().size(); w++) {
                        if (hero.getYCoordinates() == drawing.getVillains().get(w).getCoordinates().get_yPosition() && hero.getXCoordinates() == drawing.getVillains().get(w).getCoordinates().get_xPosition()) {
                            System.out.println("-------------------------------");
                            System.out.print("The Villains attack is : " + drawing.getVillains().get(w).getAttack());
                            System.out.print(" || The Experience is : " + drawing.getVillains().get(w).getExperiance());
                            System.out.println(" || The Villains Defense is : " + drawing.getVillains().get(w).getDefense());
                            System.out.println("1) Fight");
                            System.out.println("2) Run");
                            int choose = input.nextInt();
                            if (choose == 1) {
                                drawing.fight(hero, drawing.getVillains().get(w));
                            } else {
                                System.out.println("Pussy as niggah Running");
                            }
                        }
                    }
                    break;

                case "2":
                case "s":
                case "south":
                    hero.setYCoordinates(hero.getYCoordinates() + 1);
                    clearScreen();
                    drawing.drawingTheMap(hero);
                    for (int w = 0; w < drawing.getVillains().size(); w++) {
                        if (hero.getYCoordinates() == drawing.getVillains().get(w).getCoordinates().get_yPosition() && hero.getXCoordinates() == drawing.getVillains().get(w).getCoordinates().get_xPosition()) {
                            System.out.println("-------------------------------");
                            System.out.print("The Villains attack is : " + drawing.getVillains().get(w).getAttack());
                            System.out.print(" || The Experience is : " + drawing.getVillains().get(w).getExperiance());
                            System.out.println(" || The Villains Defense is : " + drawing.getVillains().get(w).getDefense());
                            System.out.println("1) Fight");
                            System.out.println("2) Run");
                            int choose = input.nextInt();
                            if (choose != 1 || choose != 2) {
                                System.out.println("Invalid option choose 1 or 2");
                            } else if (choose == 1) {
                                drawing.fight(hero, drawing.getVillains().get(w));
                            } else {
                                System.out.println("Pussy as niggah Running");
                            }
                        }
                    }
                    break;
            }
        }
//        input.close();
    }


//        input.close();

}

