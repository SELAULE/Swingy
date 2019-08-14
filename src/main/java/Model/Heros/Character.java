package Model.Heros;

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
    protected String attack;
    protected String Defense;

    public Character (String _heroName, String _heroClass, String _Defense, int _level, int _experiance, String _attack, Coordinates _coordinates) {
        this.Coordinates = _coordinates;
        this.heroName = _heroName;
        this.heroClass = _heroClass;
        this.attack = _attack;
        this.Defense = _Defense;
        this.experiance = _experiance;
        this.level = _level;
    }
}
