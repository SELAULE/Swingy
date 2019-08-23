import Controller.FileUpload;
import Model.Hero;
import View.drawMap;
import View.printing;

import java.io.IOException;
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
        String classHero[] = {"Siyan", "GOD", "Angel", "GrandPriest"};

        System.out.println("Name of the hero");
        hero.setHeroName(input.next());

        System.out.println("Name of the heroClass");
        for (int i = 0; i < classHero.length; i++) {
            System.out.println(i + ") " + classHero[i]);
        }
        hero.setHeroClass(classHero[input.nextInt()]);

        hero.setLevel(1);

        hero.setExperience(1000);

        hero.setAttack(1200);

        hero.setDefense(1200);

        hero.setXCoordinates(drawing.mapSize(hero.getLevel()) / 2);
        hero.setYCoordinates(drawing.mapSize(hero.getLevel()) / 2);
            }
            if (number == 2) {
                System.out.println("Selecting an existing hero");
                String[] contents = reader.OpenFile("./db.txt");
                drawing.selectHero(contents);
                int index = input.nextInt();
                hero = new Hero();
                hero.selectedHero(index, contents, drawing);
//                Hero hero = drawing.newHero();
//                hero.keyPressed();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        //init villains
        //init Map

        ////clean this messs
        drawing.genVillains(hero);
        clearScreen();
        drawing.drawingTheMap(hero);

        /////////////////

        //init game loop
        boolean loop = true;
        while (loop) {
            if ((hero.getXCoordinates() == drawing.getMapsize() - 1 || hero.getYCoordinates() == drawing.getMapsize() - 1 || hero.getXCoordinates() == 0 || hero.getYCoordinates() == 0) && (drawing.checkVill(drawing.getVillains(), hero.getXCoordinates(), hero.getYCoordinates()) == -1 )) {
                System.out.println("You Won Niggah");
                try {
                    printing.savePlayer(hero);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
            System.out.println("Let's get moving ");
            String command = input.nextLine();

            switch (command) {
                case "exit":
                    try {
                        gameOver(hero);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    loop = false;
//                    System.exit(0);

                case "8":
                case "w":
                case "north":
                    hero.setOldXCoordinates(hero.getXCoordinates());
                    hero.setOldYCoordinates(hero.getYCoordinates());
                    hero.setYCoordinates(hero.getYCoordinates() - 1);
                    clearScreen();
                    drawing.drawingTheMap(hero);
                    for (int w = 0; w < drawing.getVillains().size(); w++) {
                        if (hero.getYCoordinates() == drawing.getVillains().get(w).getCoordinates().get_yPosition() && hero.getXCoordinates() == drawing.getVillains().get(w).getCoordinates().get_xPosition()) {
//                            System.out.println("-------------------------------");
//                            System.out.print("The Villains attack is : " + drawing.getVillains().get(w).getAttack());
//                            System.out.print(" || The Experience is : " + drawing.getVillains().get(w).getExperiance());
//                            System.out.println(" || The Villains Defense is : " + drawing.getVillains().get(w).getDefense());
//                            System.out.println("1) Fight");
//                            System.out.println("2) Run");
                            printing.showInfo(drawing.getVillains().get(w));
                            int choose = input.nextInt();
                            if (choose == 1) {
                                try {
                                    drawing.fight(hero, drawing.getVillains().get(w));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                drawing.run(hero, drawing.getVillains().get(w));
                            }
                        }
                    }
                    break;

                case "4":
                case "a":
                case "east":
                    hero.setOldXCoordinates(hero.getXCoordinates());
                    hero.setOldYCoordinates(hero.getYCoordinates());
                    hero.setXCoordinates(hero.getXCoordinates() - 1);
                    clearScreen();
                    drawing.drawingTheMap(hero);
                    for (int w = 0; w < drawing.getVillains().size(); w++) {
                        if (hero.getYCoordinates() == drawing.getVillains().get(w).getCoordinates().get_yPosition() && hero.getXCoordinates() == drawing.getVillains().get(w).getCoordinates().get_xPosition()) {
//                            System.out.println("-------------------------------");
//                            System.out.print("The Villains attack is : " + drawing.getVillains().get(w).getAttack());
//                            System.out.print(" || The Experience is : " + drawing.getVillains().get(w).getExperiance());
//                            System.out.println(" || The Villains Defense is : " + drawing.getVillains().get(w).getDefense());
//                            System.out.println("1) Fight");
//                            System.out.println("2) Run");
                            printing.showInfo(drawing.getVillains().get(w));
                            int choose = input.nextInt();
                            if (choose == 1) {
                                try {
                                    drawing.fight(hero, drawing.getVillains().get(w));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                drawing.run(hero, drawing.getVillains().get(w));
                            }
                        }
                    }
                    break;

                case "6":
                case "d":
                case "west":
                    hero.setOldXCoordinates(hero.getXCoordinates());
                    hero.setOldYCoordinates(hero.getYCoordinates());
                    hero.setXCoordinates(hero.getXCoordinates() + 1);
                    clearScreen();
                    drawing.drawingTheMap(hero);
                    for (int w = 0; w < drawing.getVillains().size(); w++) {
                        if (hero.getYCoordinates() == drawing.getVillains().get(w).getCoordinates().get_yPosition() && hero.getXCoordinates() == drawing.getVillains().get(w).getCoordinates().get_xPosition()) {
//                            System.out.println("-------------------------------");
//                            System.out.print("The Villains attack is : " + drawing.getVillains().get(w).getAttack());
//                            System.out.print(" || The Experience is : " + drawing.getVillains().get(w).getExperiance());
//                            System.out.println(" || The Villains Defense is : " + drawing.getVillains().get(w).getDefense());
//                            System.out.println("1) Fight");
//                            System.out.println("2) Run");
                            printing.showInfo(drawing.getVillains().get(w));
                            int choose = input.nextInt();
                            if (choose == 1) {
                                try {
                                    drawing.fight(hero, drawing.getVillains().get(w));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                drawing.run(hero, drawing.getVillains().get(w));
                            }
                        }
                    }
                    break;

                case "2":
                case "s":
                case "south":
                    hero.setOldXCoordinates(hero.getXCoordinates());
                    hero.setOldYCoordinates(hero.getYCoordinates());
                    hero.setYCoordinates(hero.getYCoordinates() + 1);
                    clearScreen();
                    drawing.drawingTheMap(hero);
                    for (int w = 0; w < drawing.getVillains().size(); w++) {
                        if (hero.getYCoordinates() == drawing.getVillains().get(w).getCoordinates().get_yPosition() && hero.getXCoordinates() == drawing.getVillains().get(w).getCoordinates().get_xPosition()) {
//                            System.out.println("-------------------------------");
//                            System.out.print("The Villains attack is : " + drawing.getVillains().get(w).getAttack());
//                            System.out.print(" || The Experience is : " + drawing.getVillains().get(w).getExperiance());
//                            System.out.println(" || The Villains Defense is : " + drawing.getVillains().get(w).getDefense());
//                            System.out.println("1) Fight");
//                            System.out.println("2) Run");
                            printing.showInfo(drawing.getVillains().get(w));
                            String  choose = input.next();
                            if (!choose.equals("1") || !choose.equals("2")) {
                                System.out.println("Invalid option choose 1 or 2");
                            } else if (choose.equals("1")) {
                                try {
                                    drawing.fight(hero, drawing.getVillains().get(w));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                drawing.run(hero, drawing.getVillains().get(w));
                            }
                        }
                    }
                    break;
            }
        }
    }
}