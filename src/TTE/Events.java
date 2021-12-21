package TTE;
import java.util.Random;
public class Events {
    Random random = new Random();
    Tower tower = new Tower();
    Citizen citizen = new Citizen();
    Gold gold = new Gold();
    Wall wall = new Wall();
    
    int year = 1;
    int season = 0;
    String seasonName;
    boolean isWinter = false;
    boolean tempStatDrop = false;
    
    public void Spring(){
        seasonName = "Spring";
        //Generate 0,1,2
        int rand = random.nextInt(3);
        switch(rand){
            //reinforcement; towerAP +1
            case 0 -> {
                System.out.print("Reinforcements have arrived! ");
                System.out.println("Tower's AttackPoint +1");
                this.tower.towerAP++;
            }
            //Visitors; gold +100
            case 1 -> {
                System.out.print("A group of merchants visit your city! ");
                System.out.println("Gold +100");
                this.gold.gold += 100;
            }
            //Festival; berserk,diligent,fearless +50
            case 2 -> {
                System.out.print("Festival Celebration! ");
                System.out.println("Citizen's Berserk, Diligent and Fearless +50");
                citizen.berserk += 50;
                citizen.diligent += 50;
                citizen.fearless += 50;
                citizen.citizenAffect();
            }
        }
    }
    
    public void Summer(){
        seasonName = "Summer";
        int rand = random.nextInt(3);
        switch(rand){
            case 0 -> {
                System.out.print("Drought! Too thirsty to guard the walls. ");
                System.out.println("Wall HP -50");
                Wall.wallHP -= 50;
            }
            case 1 -> {
                System.out.print("Outing! Citizens' spirits are lifted. ");
                System.out.println("Citizen's Berserk, Diligent and Fearless +50");
                citizen.berserk += 50;
                citizen.diligent += 50;
                citizen.fearless += 50;              
                citizen.citizenAffect();                
            }
            case 2 -> {
                System.out.print("Heatstroke! Some citizens become bedridden. ");
                System.out.println("Citizen's Emotional, Nervous and Lazy +50");
                citizen.emotional += 50;
                citizen.nervous += 50;
                citizen.lazy += 50;               
                citizen.citizenAffect();
            }
        }
    }
    
    public void Autumn(){
        seasonName = "Autumn";
        int rand = random.nextInt(3);
        switch(rand){
            case 0 -> {
                System.out.print("Rainy! Vision reduced. ");
                System.out.println("Tower Accuracy -20%(This season only)");
                // apply seasonal debuff
                tower.towerACC -= 20;
                tempStatDrop = true;
            }
            case 1 -> {
                System.out.print("Flood! Tower walls are damaged. ");
                System.out.println("Wall HP -50");
                Wall.wallHP -= 50;
            }
            case 2 -> {
                System.out.print("Harvest! ");
                System.out.println("Gold +100");
                Gold.gold += 100;
            }
        }        
    }
    
    public void Winter(){
        seasonName = "Winter";
        isWinter = true;
        int rand = random.nextInt(4);
        switch(rand){
            case 0 -> {
                System.out.print("Blizzard! Tower walls are damaged. ");
                System.out.println("Wall HP -50");
                Wall.wallHP -= 50;
            }
            case 1 -> {
                System.out.print("Avalanche! The citizens are panicking. ");
                System.out.println("Citizen's Emotional, Nervous and Lazy +50");
                citizen.emotional += 50;
                citizen.nervous += 50;
                citizen.lazy += 50;              
                citizen.citizenAffect();
            }
            case 2 -> {
                System.out.print("Hunger! The citizens can't think straight. ");
                System.out.println("Tower Accuracy -20%(This season only)");
                // apply seasonal debuff
                tower.towerACC -= 20;
                tempStatDrop = true;
            }
            case 3 -> {
                System.out.print("Tour Group! Extra income. ");
                System.out.println("Gold +100");
                Gold.gold += 100;            
            }
        }
    }
    
    public void events(){
        // move on to next season
        season++;
        // remove seasonal debuff (line 80)
        if (tempStatDrop) {
            tower.towerACC += 20;
            tempStatDrop = false;
        }
        // move on to next year if past winter season
        if (isWinter) {
            year++;
            season = 1;
            isWinter = false;
        }
        
        System.out.print("Event: ");
        switch(season){
            case 1 -> Spring();
            case 2 -> Summer();
            case 3 -> Autumn();
            case 4 -> Winter();
            default -> {}
        }
    }
}
