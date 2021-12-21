package TTE;
public class Tower {
    //Tower initaial stats
    String id = "Tower";
    double towerAP = 5;
        //didn't use percentage cause easier to handle
    double towerCritRate = 10;
    double towerACC = 80; 
    int tier = 1;
    
    public void towerUpgrade(){
        
       
        tier++;
        towerAP += 1;
       
        if(towerCritRate <=50){
             towerCritRate += 5;
             Gold.gold -= 100;
        }
        if(towerACC <=100){
            towerACC += 4;
            Gold.gold -= 100;
        }

    }
    
}
