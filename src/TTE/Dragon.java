package TTE;
public class Dragon extends SameBehavior{
    //Dragon initial stats
    String id = "Dragon";
    static double dragonLvl;
    static double dragonHP;
    static double tempHP;
    static double AP;
    static double CritRate;
    static double Acc;
    public Dragon()
    {
        //didn't use percentage cause easier to handle
        ap=7;
        critRate=20;
        ACC=80;
        dragonLvl=1;
        dragonHP=100;
        tempHP=dragonHP;
        AP=ap;
        CritRate=critRate;
        Acc=ACC;
    }
    
        //Dragon leveling up mechanism
    public void Upgrade(){
        dragonLvl++;
        dragonHP += 15;
        //reset dragon HP
        tempHP = dragonHP;
        AP++;
        CritRate += 2;
    }
    
}
