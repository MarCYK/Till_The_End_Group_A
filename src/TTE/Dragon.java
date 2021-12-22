package TTE;
public class Dragon {
    //Dragon initial stats
    String id = "Dragon";
    static double dragonLvl = 1;
    static double dragonHP = 100;
    static double dragonAP = 7;
        //didn't use percentage cause easier to handle
    static double dragonCritRate = 20;
    static double dragonACC = 80;  
    static double tempHP = dragonHP;
    
        //Dragon leveling up mechanism
    public static void dragonLevelUp(){
        dragonLvl++;
        dragonHP += 15;
        //reset dragon HP
        tempHP = Dragon.dragonHP;
        dragonAP++;
        dragonCritRate += 2;
    }
    
}
