package TTE;
import java.util.Random;
public class Gold {
    Random random = new Random();
    
    //initial amount of gold
    int gold = 200;
    
    //taxation system
    public void tax(){
        // this will generate either 200/250/300/350/400
        int tax = random.nextInt(8-4+1)*50 + 200;
        
        System.out.println("Tax received from citizens this season: " + tax);
        
        this.gold += tax;
    }
    
    //check if enough gold to upgrade
    public boolean goldCheck(int cost){
        return gold - cost >= 0;
    }
}
