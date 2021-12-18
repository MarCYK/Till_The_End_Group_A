package TTE;
public class Citizen {
    //Citizen initial stats
    String id = "Citizen";
    double emotional = 10;
    double nervous = 10;
    double lazy = 10;
    double berserk = 10;
    double diligent = 10;
    double fearless = 10;
    
    Tower tower = new Tower();
    Wall wall = new Wall();
    
    public void citizenUpgrade(){
        // this is a testing message from phang
    }
    
    public void citizenAffect() {
        if (emotional >= 100) {
            tower.towerAP--;
            emotional -= 100;
        }
        
        if (nervous >= 100) {
            tower.towerACC -= 5;
            nervous -= 100;
        }
        
        if (lazy >= 100) {
            wall.wallHP -= 100;
            lazy -= 100;
        }
        
        if (berserk >= 100) {
            tower.towerAP++;
            berserk -= 100;
        }
        
        if (diligent >= 100) {
            wall.wallHP += 75;
            diligent -= 100;
        }
        
        if (fearless >= 100) {
            tower.towerCritRate += 5;
            fearless -= 100;
        }        
    }
}
