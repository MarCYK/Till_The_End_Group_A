package TTE;
import java.util.Random;
public class Gold {
    Random random = new Random();
    
    //initial amount of gold
    int gold = 200;
    
    public void tax(){
        //generate 0,1,2,3,4
        int rand = random.nextInt(5);
        switch(rand){
            case 0 -> this.gold = gold + 200;
            case 1 -> this.gold = gold + 250;
            case 2 -> this.gold = gold + 300;
            case 3 -> this.gold = gold + 350;
            case 4 -> this.gold = gold + 400;
            default -> {
            }
        }
    }
}
