package View;

import Controller.FileUpload;
import Controller.Writing;
import Model.Hero;
import Model.Villains;

import java.io.IOException;

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

    public static void gameOver(Hero theHero) throws IOException {
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
        savePlayer(theHero);
        System.exit(0);
    }

    public static void savePlayer(Hero theHero) throws IOException {
        int i = 0;
        try {
            FileUpload upload = new FileUpload();
            String[] aryLines = upload.OpenFile("db.txt");
            while (i < aryLines.length) {
                if (aryLines[i].contains(theHero.getHeroName() + ',')) {
//                    WritePlayer(hero);
//                    System.out.println("FOUND IT: " + theHero.getHeroName());
                    aryLines[i] = theHero.getHeroName() + "," + theHero.getHeroClass() + "," + theHero.getLevel() + "," + theHero.getExperience() + "," + theHero.getAttack() + "," + theHero.getDefense();
                    ;
                }
                i++;
            }
            i = 0;
            Writing write = new Writing("db.txt", true);
            write.clearFile("db.txt");
            while (i < aryLines.length) {
                try {
                    write.writeToFile(aryLines[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showInfo(Villains villains) {
        System.out.println("-------------------------------");
        System.out.print("The Villains attack is : " + villains.getAttack());
        System.out.print(" || The Experience is : " + villains.getExperiance());
        System.out.println(" || The Villains Defense is : " + villains.getDefense());
        System.out.println("1) Fight");
        System.out.println("2) Run");
    }
}