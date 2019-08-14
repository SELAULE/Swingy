package Model.Heros;

import View.drawMap;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static View.printing.*;

@Getter
@Setter
public class Hero {

    private String heroName;
    private String heroClass;
    private int level;
    private int Experience;
    private String Attack;
    private String Defense;
    private int xCoordinates;
    private int yCoordinates;
    private String[] HeroClass;
    private ArrayList<Villains> villains = new ArrayList<Villains>();
//    Villains scaryNiggahs = new Villains();


    public void keyPressed() {
        Scanner input = new Scanner(System.in);
        drawMap drawing = new drawMap();
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
                    setXCoordinates(getXCoordinates() - 1);
                    clearScreen();
                    drawing.drawingTheMap(this);
                    break;

                case "4":
                case "a":
                case "east":
                    setYCoordinates(getYCoordinates() - 1);
                    clearScreen();
                    drawing.drawingTheMap(this);
                    break;

                case "6":
                case "d":
                case "west":
                    setYCoordinates(getYCoordinates() + 1);
                    clearScreen();
                    drawing.drawingTheMap(this);
                    break;

                case "2":
                case "s":
                case "south":
                    setXCoordinates(getXCoordinates() + 1);
                    clearScreen();
                    drawing.drawingTheMap(this);
                    break;
            }
        }
//        input.close();
    }

    public void selectedHero(int index, String[] content) {
//        Hero theHero = new Hero();
        drawMap drawing = new drawMap();
        System.out.println(content[index]);
        content = content[index].split(",");

        this.setHeroName(content[0]);
        this.setHeroClass(content[1]);
        this.setLevel(Integer.parseInt(content[2]));
        this.setExperience(Integer.parseInt(content[3]));
        this.setAttack(content[4]);
        this.setDefense(content[5]);
        this.setXCoordinates(drawing.mapSize(this.getLevel())/2);
        this.setYCoordinates(drawing.mapSize(this.getLevel())/2);

        drawing.drawingTheMap(this);
//        this.PlaceVillain(villains);
        this.keyPressed();
    }

    public int randomVillan(int limit) {
        Random rand = new Random();
        int result = rand.nextInt(limit);
        return result;
    }

    public void PlaceVillain(Villains villain) {
        villains.add(villain);
//        System.out.println(villain.Coordinates.get_yPosition());
//        System.out.println(villain.Coordinates.get_yPosition());

    }

    public void killVillain(Villains villain) {
        villains.remove(villain);
    }

    public boolean levelUp(int level)
    {
//
        int XP = (int) ((level * 1000) + Math.pow(level - 1, 2) * 450);
        if (XP == 1000) {
            this.setLevel(this.getLevel() + 1);
        }
        else if (XP == 2450) {
            this.setLevel(this.getLevel() + 2);
        }
        else if (XP == 4800) {
            this.setLevel(this.getLevel() + 3);
        }
        else if (XP == 8050) {
            this.setLevel(this.getLevel() + 4);
        }
        else if(XP == 12200) {
            this.setLevel(this.getLevel() + 5);
        }
        else {
            System.out.println("Still the same");
        }
        return false;
    }
}
