package TTE;
import java.util.Scanner;
public class Game_Logic {
    Scanner sc = new Scanner(System.in);
    Dragon dragon = new Dragon();
    Tower tower = new Tower();
    Wall wall = new Wall();
    Events events = new Events();
    Citizen citizen = new Citizen();
    Gold gold = new Gold();
    
    public Game_Logic(){
        
    }
    public void game(){
        System.out.println("Welcome to Till The End - A Tower Defense Game!");
        fight();
    }
    
    //main interface
    public void waitforCommand(){
        System.out.print("1. Tower\n2. Wall\n3. Citizen\n4. I am all ready!\n");
        System.out.print("Please enter your command: ");
        int com = sc.nextInt();
        
        switch(com){
            case 1 -> tower.towerUpgrade();
            case 2 -> wall.wallUpgrade();
            case 3 -> citizen.citizenUpgrade();
            case 4 -> fight();
        }
    }
    
    //Transition to attack sequence
    public void fight(){
        System.out.println("A dragon performs a sudden attack to your city!");
        System.out.printf("Dragon's Level: %.0f\n", dragon.dragonLvl);
        System.out.printf("Dragon's HealthPoint: %.0f\n", dragon.dragonHP);
        System.out.printf("Dragon's AttackPoint: %.0f\n", dragon.dragonAP);
        System.out.printf("Dragon's Critical Chance: %.0f%%\n", dragon.dragonCritRate);
        System.out.printf("Dragon's ACcuracy: %.0f%%\n",dragon.dragonACC);
        
        for(int i=0; i<10; i++){
            dragonAttack();
        }
        dragonLevelUp();
        nextSeason();
    }
    
    //COMBAT SYSTEM ---> dragonAttack(), towerAttack() and chance()
    //dragon attack
    public void dragonAttack(){
        if((chance(dragon.dragonACC))||!(chance(wall.wallBlock))){
            //attack successful     
            double dmg = dragon.dragonAP;
            
            if(chance(dragon.dragonCritRate)){
                //critical attack
                System.out.println("Dragon attacked our wall with critical attack!");
                dmg = dmg + (int) dmg/2;
            }
            else{
                System.out.println("Dragon attacked our wall!");
            }
            this.wall.wallHP = wall.wallHP - dmg;
            System.out.printf("Wall's HealthPoint minus %.0f\n", dmg);
            System.out.printf("Current Wall's HealthPoint: %.0f\n\n", wall.wallHP);     
        }
        else{
            System.out.println("Wall successfully blocked dragon's attack");
            System.out.printf("Current Wall's HealthPoint: %.0f\n\n", wall.wallHP);  
        } 
        
        if(wall.wallHP > 0){
            towerAttack();
        }
        else{
            defeat();
        }
    }
    
    //tower attack
    public void towerAttack(){
        if(dragon.tempHP > 0){
            if(chance(tower.towerACC)){
                //attack successful     
                double dmg = tower.towerAP;

                if(chance(tower.towerCritRate)){
                    //critical attack
                    System.out.println("Tower attacked dragon with critical attack!");
                    dmg = dmg + (int) dmg/2;
                }
                else{
                    System.out.println("Tower attacked dragon!");
                }
                this.dragon.tempHP = dragon.tempHP - dmg;
                System.out.printf("Dragon's HealthPoint minus %.0f\n", dmg);
                System.out.printf("Current Dragon's HealthPoint: %.0f\n\n", dragon.tempHP);     
            }
            else{
                System.out.println("Dragon dodged tower's attack!");
                System.out.printf("Current Dragon's HealthPoint: %.0f\n\n", dragon.tempHP);  
            } 
        }
        else{
            victory();
        }
        
    }
    
    //check if attack/crit/block successful or not
    public boolean chance(double x){
        double r = Math.random()*100;
        return r >= (100 - x);
    }
    
    //Dragon leveling upmechanism
    public void dragonLevelUp(){
        this.dragon.dragonLvl = dragon.dragonLvl + 1;
        this.dragon.dragonHP = dragon.dragonHP + 15;
        //reset dragon HP
        this.dragon.tempHP = dragon.dragonHP;
        this.dragon.dragonAP = dragon.dragonAP + 1;
        this.dragon.dragonCritRate = dragon.dragonCritRate + 2;
    }
    
    //Transition to the next season
    public void nextSeason(){
        events.events();
        gold.tax();
        System.out.printf("Year : %d\n", events.year);
        System.out.printf("Season : %s\n", events.season);
        System.out.printf("Gold : %d\n", gold.gold);
        waitforCommand();
    }
    
    //To do, create a limit checker
    //Create gold upgrades
}
