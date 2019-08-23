package View;

import Model.Coordinates;
import Model.Hero;
import Model.Villains;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

@Getter

public class drawMap {

    private ArrayList<Villains> villains = new ArrayList<Villains>();

    private int Mapsize;

    public int mapSize(int level) {
        this.Mapsize = ((level - 1) * 5 + 10 - (level % 2));
        return ((level - 1) * 5 + 10 - (level % 2));
    }

    public void drawingTheMap(Hero theHero) {
        drawMap d = new drawMap();
        int l;

        for (int i = 0; i < d.mapSize(theHero.getLevel()); i++) {
            for (int j = 0; j < d.mapSize(theHero.getLevel()); j++) {
                if (i == theHero.getYCoordinates() && j == theHero.getXCoordinates()) {
                    System.out.print('H');
                } else if ((l = checkVill(villains, i, j)) > -1) {
                    System.out.print('V');
                } else
                    System.out.print('.');
            }
            System.out.print('\n');
        }
    }

    public void initGame() {

    }

    public void fight(Hero hero, Villains villains) throws IOException {
        Random rand = new Random();
        int turn = rand.nextInt(1);
        while (villains.getDefense() >= 0 || hero.getDefense() >= 0) {
            if (turn == 1) {
                System.out.println("Heros turn");
                System.out.println("Before " + villains.getDefense());
                villains.setDefense(villains.getDefense() - hero.getAttack());
                if (villains.getDefense() <= 0) {
                    System.out.println("Heros Won");
                    hero.setExperience(hero.getExperiance() + villains.getExperiance());
                    this.villains.remove(villains);
                    break;
                }
                turn = 0;
            }
            else {
                System.out.println("Villains turn");
                System.out.println("Before " + hero.getDefense());

                hero.setDefense(hero.getDefense() - villains.getAttack());
                if (hero.getDefense() <= 0) {
                    System.out.println("Villain Won");
                    printing.gameOver(hero);
                    break;
                }
                turn = 1;
            }
            continue;
        }
        this.drawingTheMap(hero);
    }

    public void run(Hero hero, Villains villains) {
        Random rand = new Random();
        int run = rand.nextInt(100);
        if (run % 2 == 0) {
            hero.setXCoordinates(hero.getOldXCoordinates());
            hero.setYCoordinates(hero.getOldYCoordinates());
            this.drawingTheMap(hero);
        } else {
            try {
                this.fight(hero, villains);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectHero(String[] content) {
        try {
//            FileUpload reader = new FileUpload();
            String[] matches = content;
            for (int i = 0; i < matches.length; i++) {
                System.out.println(i + ") " + matches[i]);
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
        String classHero[] = {"Siyan", "GOD", "Angel", "GrandPriest"};

        System.out.println("Name of the hero");
        theHero.setHeroName(input.next());

        System.out.println("Name of the heroClass");
        for (int i = 0; i < classHero.length; i++) {
            System.out.println(i + ") " + classHero[i]);
        }
        theHero.setHeroClass(classHero[input.nextInt()]);

        theHero.setLevel(1);

        theHero.setExperience(0);

        System.out.println("Name of the Attack");
        theHero.setAttack(1200);

        System.out.println("Name of Defense");
        theHero.setDefense(1200);

        theHero.setXCoordinates(this.mapSize(theHero.getLevel()) / 2);
        theHero.setYCoordinates(this.mapSize(theHero.getLevel()) / 2);
        printing.Info(theHero);
        Villains villain = new Villains();
        villains = villain.genVillains(this, theHero);
        this.drawingTheMap(theHero);
//        input.close();
        return (theHero);
    }

    public void genVillains(Hero theeHero) {

        int i = 0;
        int limit = this.Mapsize;
        int longitude = 0;
        int latitude = 0;
        int chooseVillain = 0;
        Random rand = new Random();
        while (i < limit) {
            //randomize coordinates
            longitude = rand.nextInt(limit - 1);
            latitude = rand.nextInt(limit - 1);
            chooseVillain = rand.nextInt(4);
            Coordinates coordinates = new Coordinates(longitude, latitude);
            if (chooseVillain == 1) {
                Villains villain = new Villains("Zombie" + i, "Zombie", 500, 200, 300, coordinates);
                this.villains.add(villain);
            }
            else if (chooseVillain == 2) {
                Villains villain = new Villains("Wolf" + i, "Wolf", 800, 300, 500, coordinates);
                this.villains.add(villain);
            }
            else if (chooseVillain == 3) {
                Villains villain = new Villains("Aliance" + i, "Aliance", 1200, 800, 800, coordinates);
                this.villains.add(villain);
            }
            else {
                Villains villain = new Villains("Ameture" + i, "Ameture", 200, 50, 100, coordinates);
                this.villains.add(villain);
            }
            i++;
        }
    }

    public int checkVill(ArrayList<Villains> villains, int i, int j) {
        for (int w = 0; w < villains.size(); w++) {
            if (i == villains.get(w).getCoordinates().get_yPosition() && j == villains.get(w).getCoordinates().get_xPosition())
                return w;
        }
        return -1;
    }
}
