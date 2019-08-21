package View;

import Model.Hero;

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
       // System.out.println("Hero class is : " + theHero.getHeroType().length);
        System.out.println("The Level is : " + theHero.getLevel());
        System.out.println("The Experience is : " + theHero.getExperience());
        System.out.println("Hero Attack is : " + theHero.getAttack());
        System.out.println("Hero Defense is : " + theHero.getDefense());
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void gameOver() {
        {
            clearScreen();
            System.out.println("\n" +
                    "  ________                                                  \n" +
                    " /  _____/_____    _____   ____     _______  __ ___________ \n" +
                    "/   \\  ___\\__  \\  /     \\_/ __ \\   /  _ \\  \\/ // __ \\_  __ \\\n" +
                    "\\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  (  <_> )   /\\  ___/|  | \\/\n" +
                    " \\______  (____  /__|_|  /\\___  >  \\____/ \\_/  \\___  >__|   \n" +
                    "        \\/     \\/      \\/     \\/                   \\/       \n");
        }
        System.exit(0);
    }
}