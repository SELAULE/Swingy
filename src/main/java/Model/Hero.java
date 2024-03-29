package Model;

import View.drawMap;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static View.printing.*;

@Getter
@Setter
public class Hero extends Character {

    private String heroName;
    private String heroClass;
    private int level;
    private int Experience;
    private int Attack;
    private int Defense;
    private int xCoordinates;
    private int yCoordinates;
    private int oldYCoordinates;
    private int oldXCoordinates;
    private String[] HeroType;

    //get rid of arraylist
    //private ArrayList<Villains> villains = new ArrayList<Villains>();
//    Villains scaryNiggahs = new Villains();


    public void keyPressed() throws IOException {
        Scanner input = new Scanner(System.in);
        drawMap drawing = new drawMap();


        boolean loop = true;
        while (loop) {
            System.out.println("Let's get moving ");
            String command = input.next();

            switch (command) {
                case "exit":
                    gameOver(this);
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

    public void selectedHero(int index, String[] content, drawMap drawing) throws IOException {
//        Hero theHero = new Hero();
//        drawMap drawing = new drawMap();
        for (int z = 0; z < content.length; z++) {
            System.out.println(content[index]);
        }
        content = content[index].split(",");

        this.setHeroName(content[0]);
        this.setHeroClass(content[1]);
        this.setLevel(Integer.parseInt(content[2]));
        this.setExperience(Integer.parseInt(content[3]));
        this.setAttack(1200);
        this.setDefense(1200);
        this.setXCoordinates(drawing.mapSize(this.getLevel())/2);
        this.setYCoordinates(drawing.mapSize(this.getLevel())/2);

//        drawing.drawingTheMap(this);
//        this.PlaceVillain(villains);
//        this.keyPressed();
    }

    public int randomVillan(int limit) {
        Random rand = new Random();
        int result = rand.nextInt(limit);
        return result;
    }



    //move elsewhere

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
