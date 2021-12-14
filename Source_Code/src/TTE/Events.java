package TTE;
import java.util.Random;
public class Events {
    Random random = new Random();
    Tower tower = new Tower();
    Citizen citizen = new Citizen();
    Gold gold = new Gold();
    
    int year = 1;
    String season = "Spring";
    
    public void Spring(){
        //Generate 0,1,2
        int rand = random.nextInt(3);
        switch(rand){
            //reinforcement; towerAP +1
            case 0 -> {
                System.out.println("Reinforcements have arrive!");
                System.out.println("Tower's AttackPoint +1");
                this.tower.towerAP = tower.towerAP + 1;
            }
            //Visitors; gold +100
            case 1 -> {
                System.out.println("A group of merchants visited your city");
                System.out.println("Gold +100");
                this.gold.gold = gold.gold + 100;
            }
            //Festival; berserk,diligent,fearless +50
            case 2 -> {
                System.out.println("Festival Celebration!");
                System.out.println("Citizen's Berserk, Diligent and Fearless +50");
                this.citizen.berserk = citizen.berserk + 50;
                this.citizen.diligent = citizen.diligent + 50;
                this.citizen.fearless = citizen.fearless + 50;
            }
            
        }
    }
    
    public void Summer(){
        
    }
    
    public void Autumn(){
        
    }
    
    public void Winter(){
        
    }
    
    public void events(){
        switch(season){
            case "Spring": Spring();
            case "Summer": Summer();
            case "Autumn": Autumn();
            case "Winter": Winter();
            default: break;
        }
    }
}
