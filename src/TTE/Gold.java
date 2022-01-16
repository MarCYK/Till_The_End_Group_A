package TTE;
import java.util.Random;
public class Gold {
    static Random random = new Random();
    
    //initial amount of gold
    static int gold = 200;
    
    //taxation system
    public static void tax(){
        // this will generate either 200/250/300/350/400
        int tax;
        if(Game_Logic.isHardMode)
            tax = random.nextInt(8-4+1)*50 + 100;   
        else
            tax = random.nextInt(8-4+1)*50 + 200;
        
        System.out.println("Tax received from citizens this season: " + tax);
        System.out.print("Gold " + gold + " -> ");
        gold += tax;
        System.out.println(gold);
    }
    
    //check if enough gold to upgrade
    public static boolean goldCheck(int cost){
        return gold - cost >= 0;
    }
}
