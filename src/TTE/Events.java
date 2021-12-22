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
                System.out.println("Reinforcements have arrived! Tower's AttackPoint +1");
                System.out.print("Tower AP " + tower.towerAP + " -> ");
                tower.towerAP++;
                System.out.println(tower.towerAP);
            }
            //Visitors; gold +100
            case 1 -> {
                System.out.println("A group of merchants visit your city! Gold +100");
                System.out.print("Gold " + gold.gold + " -> ");
                gold.gold += 100;
                System.out.println(gold.gold);
            }
            //Festival; berserk,diligent,fearless +50
            case 2 -> {
                System.out.println("Festival Celebration! Citizen's Berserk, Diligent and Fearless +50");
                System.out.print("Berserk " + citizen.berserk + " -> ");
                citizen.berserk += 50;
                System.out.println(citizen.berserk);
                System.out.print("Diligent " + citizen.diligent + " -> ");
                citizen.diligent += 50;
                System.out.println(citizen.diligent);
                System.out.print("Fearless " + citizen.fearless + " -> ");
                citizen.fearless += 50;
                System.out.println(citizen.fearless);
                citizen.citizenAffect();
            }
        }
    }
    
    public void Summer(){
        seasonName = "Summer";
        int rand = random.nextInt(3);
        switch(rand){
            case 0 -> {
                System.out.println("Drought! Too thirsty to guard the walls. Wall HP -50");
                System.out.print("Wall HP " + Wall.wallHP + " -> ");
                Wall.wallHP -= 50;
                System.out.println(Wall.wallHP);
            }
            case 1 -> {
                System.out.println("Outing! Citizens' spirits are lifted. Citizen's Berserk, Diligent and Fearless +50");
                System.out.print("Berserk " + citizen.berserk + " -> ");
                citizen.berserk += 50;
                System.out.println(citizen.berserk);
                System.out.print("Diligent " + citizen.diligent + " -> ");
                citizen.diligent += 50;
                System.out.println(citizen.diligent);
                System.out.print("Fearless " + citizen.fearless + " -> ");
                citizen.fearless += 50;
                System.out.println(citizen.fearless);             
                citizen.citizenAffect();                
            }
            case 2 -> {
                System.out.println("Heatstroke! Some citizens become bedridden. Citizen's Emotional, Nervous and Lazy +50");
                System.out.print("Emotional " + citizen.emotional + " -> ");
                citizen.emotional += 50;
                System.out.println(citizen.emotional);
                System.out.print("Nervous " + citizen.nervous + " -> ");
                citizen.nervous += 50;
                System.out.println(citizen.nervous);
                System.out.print("Lazy " + citizen.lazy + " -> ");
                citizen.lazy += 50;
                System.out.println(citizen.lazy);                  
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
                System.out.print("Tower Accuracy " + tower.towerACC + " -> ");
                tower.towerACC -= 20;
                System.out.println(tower.towerACC);
                tempStatDrop = true;
            }
            case 1 -> {
                System.out.println("Flood! Tower walls are damaged. Wall HP -50");
                System.out.print("Wall HP " + Wall.wallHP + " -> ");
                Wall.wallHP -= 50;
                System.out.println(Wall.wallHP);
            }
            case 2 -> {
                System.out.println("Harvest! Gold +100");
                System.out.print("Gold " + gold.gold + " -> ");
                gold.gold += 100;
                System.out.println(gold.gold);
            }
        }        
    }
    
    public void Winter(){
        seasonName = "Winter";
        isWinter = true;
        int rand = random.nextInt(4);
        switch(rand){
            case 0 -> {
                System.out.println("Blizzard! Tower walls are damaged. Wall HP -50");
                System.out.print("Wall HP " + Wall.wallHP + " -> ");
                Wall.wallHP -= 50;
                System.out.println(Wall.wallHP);
            }
            case 1 -> {
                System.out.println("Avalanche! The citizens are panicking. Citizen's Emotional, Nervous and Lazy +50");
                System.out.print("Emotional " + citizen.emotional + " -> ");
                citizen.emotional += 50;
                System.out.println(citizen.emotional);
                System.out.print("Nervous " + citizen.nervous + " -> ");
                citizen.nervous += 50;
                System.out.println(citizen.nervous);
                System.out.print("Lazy " + citizen.lazy + " -> ");
                citizen.lazy += 50;
                System.out.println(citizen.lazy);              
                citizen.citizenAffect();
            }
            case 2 -> {
                System.out.print("Hunger! The citizens can't think straight. ");
                System.out.println("Tower Accuracy -20%(This season only)");
                // apply seasonal debuff
                System.out.print("Tower Accuracy " + tower.towerACC + " -> ");
                tower.towerACC -= 20;
                System.out.println(tower.towerACC);
                tempStatDrop = true;
            }
            case 3 -> {
                System.out.println("Tour Group! Extra income. Gold +100");
                System.out.print("Gold " + gold.gold + " -> ");
                gold.gold += 100;
                System.out.println(gold.gold);           
            }
        }
    }
    
    public void events(){
        // move on to next season
        season++;
        // remove seasonal debuff (line 80)
        if (tempStatDrop) {
            System.out.println("The citizens have recovered from previous season.");
            System.out.print("Tower Accuracy " + tower.towerACC + " -> ");
            tower.towerACC += 20;
            System.out.println(tower.towerACC);
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
