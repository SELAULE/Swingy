package Model.Heros;

import View.drawMap;

import java.util.Random;
import java.util.Scanner;

public class Hero {
    private String heroName;
    private String heroClass;
    private int level;
    private int Experience;
    private String Attack;
    private String Defense;
    private int xCoordinates;
    private int yCoordinates;

    public int getxCoordinates() {
        return this.xCoordinates;
    }

    public void setxCoordinates(int xCoordinates) {
        this.xCoordinates = xCoordinates;
    }

    public int getyCoordinates() {
        return this.yCoordinates;
    }

    public void setyCoordinates(int yCoordinates) {
        this.yCoordinates = yCoordinates;
    }

    public String getHeroName() {
        return this.heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroClass() {
        return this.heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public int getLevel() {

        return this.level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException();
        }
        this.level = level;
    }

    public int getExperience() {
        return this.Experience;
    }

    public void setExperience(int experience) {
        this.Experience = experience;
    }

    public String getAttack() {
        return this.Attack;
    }

    public void setAttack(String attack) {
        this.Attack = attack;
    }

    public String getDefense() {
        return this.Defense;
    }

    public void setDefense(String defense) {
        this.Defense = defense;
    }

//    public Hero(String heroName, String heroClass, int level, int experience, String attack, String defense) {
//        this.heroName = heroName;
//        this.heroClass = heroClass;
//        this.level = level;
//        Experience = experience;
//        Attack = attack;
//        Defense = defense;
//    }




    public void keyPressed() {

        Scanner input = new Scanner(System.in);
        drawMap drawing = new drawMap();
        boolean loop = true;
        while (loop) {
            System.out.println("Let's get moving ");
            String command = input.next();

            if ("exit".equals(command)) {
                System.out.println("Pussy niggar left the game!!");
                loop = false;
                System.exit(0);
            } else if ("8".equals(command) || "w".equals(command) || "north".equals(command)) {
                setxCoordinates(getxCoordinates() - 1);
                drawing.drawingTheMap(this);
            } else if ("4".equals(command) || "a".equals(command) || "east".equals(command)) {
                setyCoordinates(getyCoordinates() - 1);
                drawing.drawingTheMap(this);
            } else if ("6".equals(command) || "d".equals(command) || "west".equals(command)) {
                setyCoordinates(getyCoordinates() + 1);
                drawing.drawingTheMap(this);
            } else if ("2".equals(command) || "s".equals(command) || "south".equals(command)) {
                setxCoordinates(getxCoordinates() + 1);
                drawing.drawingTheMap(this);
            }
        }
//        input.close();
    }

    public int randomVillan(int limit) {
        Random rand = new Random();
        int result = rand.nextInt(limit);
        return result;
    }
}
