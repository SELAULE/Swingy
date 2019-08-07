package Model.Heros;

import View.drawMap;

import java.util.ArrayList;
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
    private String[] HeroClass = {"Siyan", "GOD", "Angel", "GrandPriest"};
    private ArrayList<Villains> villains = new ArrayList<Villains>();
//    Villains scaryNiggahs = new Villains();


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
        if (level < 0) {
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


    public void keyPressed() {

        Scanner input = new Scanner(System.in);
        drawMap drawing = new drawMap();
        boolean loop = true;
        while (loop) {
            System.out.println("Let's get moving ");
            String command = input.next();

            switch (command) {
                case "exit":
                    System.out.println("Pussy niggar left the game!!");
                    loop = false;
                    System.exit(0);

                case "8":
                case "w":
                case "north":
                    setxCoordinates(getxCoordinates() - 1);
//                    if ()
                    drawing.drawingTheMap(this);
                    break;

                case "4":
                case "a":
                case "east":
                    setyCoordinates(getyCoordinates() - 1);
                    drawing.drawingTheMap(this);
                    break;

                case "6":
                case "d":
                case "west":
                    setyCoordinates(getyCoordinates() + 1);
                    drawing.drawingTheMap(this);
                    break;

                case "2":
                case "s":
                case "south":
                    setxCoordinates(getxCoordinates() + 1);
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
        this.setxCoordinates(drawing.mapSize(this.getLevel())/2);
        this.setyCoordinates(drawing.mapSize(this.getLevel())/2);

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
