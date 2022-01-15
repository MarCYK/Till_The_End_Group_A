package TTE;
import static TTE.Dragon.tempHP;
import static TTE.Game_Logic.events;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class Save {
    static Scanner enterScanner = new Scanner(System.in);
    
    public static void save() {
        System.out.println("-".repeat(40));
        
        try {
            PrintWriter save = new PrintWriter(new FileOutputStream("TTE_save.txt"));
            
            save.println(Citizen.emotional);
            save.println(Citizen.nervous);
            save.println(Citizen.lazy);
            save.println(Citizen.berserk);
            save.println(Citizen.diligent);
            save.println(Citizen.fearless);
            save.println(Dragon.dragonLvl);
            save.println(Dragon.dragonHP);
            save.println(Dragon.AP);
            save.println(Dragon.CritRate);
            save.println(Dragon.Acc);
            save.println(Events.year);
            save.println(Events.season);
            save.println(Events.seasonName);
            save.println(Events.isWinter);
            save.println(Events.tempStatDrop);
            save.println(Gold.gold);
            save.println(Tower.AP);
            save.println(Tower.CritRate);
            save.println(Tower.Acc);
            save.println(Wall.wallHP);
            save.println(Wall.wallBlock);

            save.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        
        System.out.println("Save successful.");
        System.out.print("Press ENTER to continue.");
        enterScanner.nextLine();
        System.out.println("-".repeat(40));
        Game_Logic.waitforCommand();
    }
    
    public static void load() {
        System.out.println("-".repeat(40));
        
        try {
            Scanner load = new Scanner(new FileInputStream ("TTE_save.txt"));
            
            Citizen.emotional = load.nextDouble();
            Citizen.nervous = load.nextDouble();
            Citizen.lazy = load.nextDouble();
            Citizen.berserk = load.nextDouble();
            Citizen.diligent = load.nextDouble();
            Citizen.fearless = load.nextDouble();
            Dragon.dragonLvl = load.nextDouble();
            Dragon.dragonHP = load.nextDouble();           
            Dragon.AP = load.nextDouble();         
            Dragon.CritRate = load.nextDouble();       
            Dragon.Acc = load.nextDouble();
            Events.year = load.nextInt();
            Events.season = load.nextInt();
            load.nextLine(); // This is to ensure the code is reading the next line in the save file
            Events.seasonName = load.nextLine();
            Events.isWinter = load.nextBoolean();
            Events.tempStatDrop = load.nextBoolean();
            Gold.gold = load.nextInt();
            Tower.AP = load.nextDouble();
            Tower.CritRate = load.nextDouble();
            Tower.Acc = load.nextDouble();
            Wall.wallHP = load.nextDouble();
            Wall.wallBlock = load.nextDouble();

            load.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File Error");
        }
        
        tempHP = Dragon.dragonHP;
        System.out.println("Load successful.");
        System.out.print("Press ENTER to continue.");
        enterScanner.nextLine();
        System.out.println("-".repeat(40));
        System.out.printf("Year : %d\n", events.year);
        System.out.printf("Season : %s\n", events.seasonName);
        System.out.printf("Gold : %d\n", Gold.gold);        
        Game_Logic.waitforCommand();        
    }
}
