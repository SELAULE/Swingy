package View;

import Model.Heros.Hero;

public class printing {
    public void welcome() {
        System.out.println("/**********************************\\");
        System.out.println("/*                                *\\");
        System.out.println("/*        Welcome to Swingy       *\\");
        System.out.println("/*                                *\\");
        System.out.println("/**********************************\\");
    }

    public void Info(Hero theHero) {
        System.out.println("-------------------------------");
        System.out.println("Hero name is : " + theHero.getHeroName());
        System.out.println("Hero class is : " + theHero.getHeroClass());
        System.out.println("The Level is : " + theHero.getLevel());
        System.out.println("The Experience is : " + theHero.getExperience());
        System.out.println("Hero Attack is : " + theHero.getAttack());
        System.out.println("Hero Defense is : " + theHero.getDefense());
    }

}