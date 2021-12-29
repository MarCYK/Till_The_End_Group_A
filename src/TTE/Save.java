package TTE;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Save {
    public static void save() {
        Scanner enterScanner = new Scanner(System.in);
        System.out.println("-".repeat(40));
        
        try {
            PrintWriter save = new PrintWriter(new FileOutputStream("TTE_save.txt"));
            
            save.println("emotional  = " + Citizen.emotional);
            save.println("nervous    = " + Citizen.nervous);
            save.println("lazy       = " + Citizen.lazy);
            save.println("berserk    = " + Citizen.berserk);
            save.println("diligent   = " + Citizen.diligent);
            save.println("fearless   = " + Citizen.fearless);
            save.println("dragon lv  = " + Dragon.dragonLvl);
            save.println("dragon hp  = " + Dragon.dragonHP);
            save.println("dragon ap  = " + Dragon.dragonAP);
            save.println("dragon crit= " + Dragon.dragonCritRate);
            save.println("dragon acc = " + Dragon.dragonACC);
            save.println("year       = " + Events.year);
            save.println("season no. = " + Events.season);
            save.println("season name= " + Events.seasonName);
            save.println("isWinter   = " + Events.isWinter);
            save.println("stat drop  = " + Events.tempStatDrop);
            save.println("gold       = " + Gold.gold);
            save.println("tower ap   = " + Tower.towerAP);
            save.println("tower crit = " + Tower.towerCritRate);
            save.println("tower acc  = " + Tower.towerACC);
            save.println("wall hp    = " + Wall.wallHP);
            save.println("wall block = " + Wall.wallBlock);

            save.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        
        System.out.println("Save successful.");
        System.out.println("-".repeat(40));
        System.out.print("Press ENTER to continue.");
        enterScanner.nextLine();        
        Game_Logic.waitforCommand();
    }
}
