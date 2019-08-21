package Model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Character {

    protected String heroName;
    protected String heroClass;
    protected Coordinates Coordinates;
    protected int level;
    protected int experiance;
    protected int attack;
    protected int Defense;

    public Character(){

    }
    public Character (String _heroName, String _heroClass, int _Defense, int _experiance, int _attack, Coordinates _coordinates) {
        this.Coordinates = _coordinates;
        this.heroName = _heroName;
        this.heroClass = _heroClass;
        this.attack = _attack;
        this.Defense = _Defense;
        this.experiance = _experiance;
//        this.level = _level;
    }
}
