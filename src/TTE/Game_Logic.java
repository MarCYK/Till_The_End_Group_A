package TTE;
import java.util.Scanner;
public class Game_Logic {
    static Scanner sc = new Scanner(System.in);
    static Scanner enterScanner = new Scanner(System.in);
    static Tower tower = new Tower();
    static Events events = new Events();
    
    public Game_Logic(){
        
    }
    
    public static void game(){
        System.out.println("Welcome to Till The End - A Tower Defense Game!");
        fight();
    }
    
    //main interface
    public static void waitforCommand(){
        System.out.print("1. Tower\n2. Wall\n3. Citizen\n4. I am all ready!\n");
        System.out.println("-".repeat(40));
        System.out.print("Please enter your command: ");
        int com = sc.nextInt();
        
        while (com<1 || com>4) {
            System.out.println("-".repeat(40));
            System.out.println("Option not available, please try again.");
            System.out.println("-".repeat(40));
            System.out.print("Please enter your command: ");
            com = sc.nextInt();            
        }
        
        switch(com){
            case 1 -> tower.towerUpgrade();
            case 2 -> Wall.wallUpgrade();
            case 3 -> Citizen.citizenUpgrade();
            case 4 -> {
                System.out.println("-".repeat(40));
                fight();
            }
        }
    }
    
    //Transition to attack sequence
    public static void fight(){
        System.out.println("A dragon performs a sudden attack to your city!");
        System.out.printf("Dragon's Level: %.0f\n", Dragon.dragonLvl);
        System.out.printf("Dragon's HealthPoint: %.0f\n", Dragon.dragonHP);
        System.out.printf("Dragon's AttackPoint: %.0f\n", Dragon.dragonAP);
        System.out.printf("Dragon's Critical Chance: %.0f%%\n", Dragon.dragonCritRate);
        System.out.printf("Dragon's Accuracy: %.0f%%\n",Dragon.dragonACC);
        // Prompt message
        System.out.println("-".repeat(40));
        System.out.print("Press ENTER to continue.");
        enterScanner.nextLine();
        
        for(int i=0; i<10; i++){
            System.out.println("-".repeat(40));
            System.out.println("[Round " + (i+1) + "]");
            dragonAttack();
            System.out.println("-".repeat(40));
            System.out.print("Press ENTER to continue.");
            enterScanner.nextLine();            
        }
        Dragon.dragonLevelUp(); // line 120
        // Complete one dragon fight message
        System.out.println("-".repeat(40));
        System.out.println("The dragon grows weary and fled.");
        System.out.println("The citizens cheer as they survived the attack.");
        System.out.println("They resume their daily life and prepare for the next season.");
        System.out.println("-".repeat(40));
        // Prompt message
        System.out.print("Press ENTER to continue.");
        enterScanner.nextLine(); 

        nextSeason(); // line 155
    }
    
    //COMBAT SYSTEM ---> dragonAttack(), towerAttack() and chance()
    //dragon attack
    public static void dragonAttack(){
        if((chance(Dragon.dragonACC))||!(chance(Wall.wallBlock))){ // line 114
            //attack successful     
            double dmg = Dragon.dragonAP;
            
            if(chance(Dragon.dragonCritRate)){
                //critical attack
                System.out.println("Dragon attacked our wall with critical attack!");
                dmg += (int)dmg/2;
            }
            else{
                System.out.println("Dragon attacked our wall!");
            }
            Wall.wallHP -= dmg;
            System.out.printf("Wall's HealthPoint minus %.0f\n", dmg);
            System.out.printf("Current Wall's HealthPoint: %.0f\n\n", Wall.wallHP);     
        }
        else{
            System.out.println("Wall successfully blocked dragon's attack");
            System.out.printf("Current Wall's HealthPoint: %.0f\n\n", Wall.wallHP);  
        }
        
        if(Wall.wallHP > 0){
            towerAttack();
        }
        else{
            System.out.println("wall has no HP and not able to counterattack");
            //defeat();
        }
    }
    
    //tower attack
    public static void towerAttack(){
        if(Dragon.tempHP > 0){
            if(chance(Tower.towerACC)){
                //attack successful     
                double dmg = Tower.towerAP;

                if(chance(Tower.towerCritRate)){
                    //critical attack
                    System.out.println("Tower attacked dragon with critical attack!");
                    dmg += (int)dmg/2;
                }
                else{
                    System.out.println("Tower attacked dragon!");
                }
                Dragon.tempHP -= dmg;
                System.out.printf("Dragon's HealthPoint minus %.0f\n", dmg);
                System.out.printf("Current Dragon's HealthPoint: %.0f\n", Dragon.tempHP);     
            }
            else{
                System.out.println("Dragon dodged tower's attack!");
                System.out.printf("Current Dragon's HealthPoint: %.0f\n", Dragon.tempHP);  
            } 
        }
        else{
            //victory();
        }
        
    }
    
    //check if attack/crit/block successful or not
    public static boolean chance(double x){
        double r = Math.random()*100;
        return r <= x;
    } 
    
    //Transition to the next season
    public static void nextSeason(){
        System.out.println("-".repeat(40));
        events.events();
        Gold.tax();
        System.out.printf("Year : %d\n", events.year);
        System.out.printf("Season : %s\n", events.seasonName);
        System.out.printf("Gold : %d\n", Gold.gold);
        waitforCommand(); // line 22
    }
    
}
