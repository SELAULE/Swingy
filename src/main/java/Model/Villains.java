package Model;

import View.drawMap;

import java.util.ArrayList;
import java.util.Random;

public class Villains extends Character {

    Hero hero = new Hero();
    private ArrayList<Villains> villains = new ArrayList<Villains>();

    public Villains() {

    }

    public Villains(String _heroName, String _heroClass, int _Defense, int _experiance, int _attack, Coordinates _coordinates) {
        super(_heroName, _heroClass, _Defense, _experiance, _attack, _coordinates);
    }

    public void fight(Hero theHero, Villains villains) {

        drawMap d = new drawMap();
//        int continueFight = 1;
//        while (continueFight) {
//            if (hero.getAttack() )
//        }
        if (theHero.getXCoordinates() == 0) {
            System.out.println("We on the top edge");
        } else if (theHero.getXCoordinates() == d.mapSize(theHero.getLevel()) - 1) {
            System.out.println("We on the left edge");
        }
    }

    public void killVillain(Villains villain) {
        villains.remove(villain);
    }


    public void PlaceVillain(Villains villain) {
        villains.add(villain);
//        System.out.println(villain.Coordinates.get_yPosition());
//        System.out.println(villain.Coordinates.get_yPosition());
    }

    public ArrayList genVillains(drawMap Map, Hero theeHero) {

        int i = 0;
        int limit = Map.mapSize(theeHero.getLevel());
        int longitude = 0;
        int latitude = 0;
        Random rand = new Random();
        while (i < limit) {
            //randomize coordinates
            longitude = rand.nextInt(limit - 1);
            latitude = rand.nextInt(limit - 1);
            Coordinates coordinates = new Coordinates(longitude, latitude);
            Villains villain = new Villains("Zombie1", "Zombie", 800, 800, 500, coordinates);
            this.PlaceVillain(villain);
            i++;
        }
        return villains;
    }
}
